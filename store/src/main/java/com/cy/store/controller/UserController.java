package com.cy.store.controller;

import com.cy.store.controller.exception.*;
import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.service.exception.UpdateException;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/**
 * ClassName:UserController
 * Package:com.cy.store.controller
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/7 - 19:24
 * @Version:v1.0
 */
@RestController
@RequestMapping("/users")
public class UserController extends BaseController{
    @Autowired
    private IUserService iUserService;

    /**
     * 用户注册请求处理
     * @param user
     * @return
     */
    @RequestMapping("/register")
    public JsonResult<Void> reg(User user)
    {
        iUserService.regist(user);
        return new JsonResult<>(ok);
    }

    /**
     * 用户登录请求处理  (保存用户信息)
     * @param username
     * @param password
     * @param session
     * 服务器本身自动创建有session对象,已经是一个全局的session对象,所以我们需要想办法获取session对象:
     * 如果直接将HttpSession类型的对象作为请求处理方法的参数,这时springboot会自动将全局的session对象注入到请求处理方法的session形参上:
     * 将登录模块的设计请求中的请求参数:String username,String password加上HttpSession session
     * 将登录模块的处理请求中login方法加上参数HttpSession session并修改代码如下:
     */
    @RequestMapping("/login")
    public JsonResult<User> login(String username, String password, HttpSession session)
    {
        User data = iUserService.login(username, password);
        //向session对象中完成数据的绑定(这个session是全局的,项目的任何位置都可以访问)
        session.setAttribute("uid",data.getUid());
        session.setAttribute("username",data.getUsername());
        return new JsonResult<User>(ok,data);//将用户以json格式传递给前端
    }

    /**
     * 修改密码请求处理
     */
    @RequestMapping("/change_password")
    public JsonResult<Void> changePassword(String oldPassword,String newPassword,HttpSession session)
    {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        iUserService.changePassword(uid,username,oldPassword,newPassword);
        return new JsonResult<>(ok);
    }

    /**
     * 一打开修改个人资料页面时需要回显用户数据，所以需要通过uid查询用户数据
     */
    @RequestMapping("/get_by_uid")
    public JsonResult<User> getUser(HttpSession session)
    {
        Integer uid = getUidFromSession(session);
        User data = iUserService.getByUid(uid);
        return new JsonResult<>(ok,data);//将用户数据回显到前端页面
    }

    /**
     * 更新个人资料请求处理
     */
    @RequestMapping("/change_user_info")
    public JsonResult<Void> changeInfo(HttpSession session,User user)
    {
        //user对象中有四部分的数据:username,phone,email,gender
        //控制层给业务层传递uid,并在业务层通过user.setUid(uid);将uid封装到user中
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        iUserService.updateUserInfoByUid(uid,username,user);
        return new JsonResult<>(ok);
    }

    //设置上传文件的最大值
    public static final int AVATAR_MAX_SIZE = 10 * 1024 * 1024;
    //限制上传文件的类性
    public static final List<String> AVATAR_TYPE = new ArrayList<>();
    static {
        AVATAR_TYPE.add("/image/jpeg");
        AVATAR_TYPE.add("/image/png");
        AVATAR_TYPE.add("/image/bmp");
        AVATAR_TYPE.add("/image/gif");
    }

    /**
     * 上传头像请求处理
     * @param session
     * @param file
     * @return
     * 1.参数名为什么必须用file:在upload.html页面的147行<input type=
     * "file" name="file">中的name="file",所以必须有一个方法的参数名
     * 为file用于接收前端传递的该文件.如果想要参数名和前端的name不一
     * 样:@RequestParam("file")MultipartFile ffff:把表单中name=
     * "file"的控件值传递到变量ffff上
     * 2.参数类型为什么必须是MultipartFile:这是springmvc中封装的一个
     * 包装接口,如果类型是MultipartFile并且参数名和前端上传文件的name
     * 相同,则会自动把整体的数据包传递给file
     */
    @RequestMapping("/change_avatar")
    public JsonResult<String> uploadAvatar(HttpSession session,@RequestParam("file") MultipartFile file) {
        //判断文件是否为空
        if (file.isEmpty()) {
            throw new FileEmptyException("文件为空");
        }
        if (file.getSize() > AVATAR_MAX_SIZE) {
            throw new FileSizeException("文件超出限制");
        }
        //判断文件的类型是否是我们规定的后缀类型
        String contentType = file.getContentType();
        //如果集合包含某个元素则返回值为true
        if (!AVATAR_TYPE.contains(contentType)) {
            throw new FileTypeException("文件类型不支持");
        }

        //上传的文件路径:.../upload/文件名.png
        /**
         * session.getServletContext()获取当前Web应用程序的上下文
         * 对象(每次启动tomcat都会创建一个新的上下文对象)
         * getRealPath("/upload")的/代表当前web应用程序的根目录,通过该相
         * 对路径获取绝对路径,返回一个路径字符串,如果不能进行映射返回null,单
         * 斜杠可要可不要
         */
        String parent =
                session.getServletContext().getRealPath("/upload");

        //File对象指向这个路径,通过判断File是否存在得到该路径是否存在
        File dir = new File(parent);
        if (!dir.exists()) {//检测目录是否存在
            dir.mkdirs();//创建当前目录
        }

        //获取这个文件名称(文件名+后缀,如avatar01.png,不包含父目录结构)用UUID
        // 工具生成一个新的字符串作为文件名(好处:避免了因文件名重复发生的覆盖)
        String originalFilename = file.getOriginalFilename();
        System.out.println("OriginalFilename=" + originalFilename);
        int index = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(index);
        //filename形如SAFS1-56JHIOHI-HIUGHUI-5565TYRF.png
        String filename =
                UUID.randomUUID().toString().toUpperCase() + suffix;

        //在dir目录下创建filename文件(此时是空文件)
        File dest = new File(dir, filename);

        //java可以把一个文件的数据直接写到同类型的文件中,这里将参数file中的数据写入到空文件dest中
        try {
            file.transferTo(dest);//transferTo是一个封装的方法,用来将file文件中的数据写入到dest文件

            /**
             * 先捕获FileStateException再捕获IOException是
             * 因为后者包含前者,如果先捕获IOException那么
             * FileStateException就永远不可能会被捕获
             */
        } catch (FileStateException e) {
            throw new FileStateException("文件状态异常");
        } catch (IOException e) {
            //这里不用打印e,而是用自己写的FileUploadIOException类并
            // 抛出文件读写异常
            throw new FileUploadIOException("文件读写异常");
        }

        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        String avatar = "/upload/" + filename;
        iUserService.uploadAvatar(uid, avatar, username);
        //返回用户头像的路径给前端页面,将来用于头像展示使用
        return new JsonResult<>(ok, avatar);
    }
}
