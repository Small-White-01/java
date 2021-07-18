package com.lezijie.admin.controller;


import com.lezijie.admin.exception.MsgException;
import com.lezijie.admin.info.ResponseInfo;
import com.lezijie.admin.info.ResultInfo;
import com.lezijie.admin.pojo.TUser;
import com.lezijie.admin.service.ITUserService;
import com.lezijie.admin.utils.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author aaa
 * @since 2021-07-18
 */
@RestController
@RequestMapping("/")
public class TUserController {

    @Autowired
    private ITUserService itUserService;

    @RequestMapping("login")
    @ResponseBody
    public ResponseInfo login(String username, String password, HttpSession session) throws MsgException {
        TUser tUser = new TUser();
        tUser.setUsername(username);
        tUser.setPassword(password);

        ResultInfo<TUser> login = itUserService.login(tUser);

        Assert.isNull(login.getT()==null,"用户名不存在");
        Assert.isTrue(!login.isFlag(),"密码错误");
        session.setAttribute("user",login.getT());
        return ResponseInfo.success(login.getInfo(),login.getT());





    }

    @RequestMapping("/update")
    //定义了GlobalExceptionHandler全局全局处理异常,简化开发
    public ResponseInfo update(String username,String password,HttpSession session) throws MsgException {
        TUser user = (TUser) session.getAttribute("user");


            //Assert.isNull(user,"用户请登录");
            itUserService.updateInfo(username, password, user);
            user.setUsername(username);
            user.setPassword(password);
            session.setAttribute("user",user);


        return ResponseInfo.success("更新成功",user);
    }


    @RequestMapping("changePsd")
    public ResponseInfo changePsd(HttpSession session,String oldPsd,String newPsd,String repeatedPsd) throws MsgException {


            Assert.isBlank(oldPsd,"旧密码不能为空");
            Assert.isBlank(newPsd,"新密码不能为空");
            Assert.isBlank(repeatedPsd,"密码不能为空");
            TUser user= (TUser) session.getAttribute("user");
            itUserService.updatePassword(user,oldPsd,newPsd,repeatedPsd);
            return ResponseInfo.success("更新密码成功");

    }


    @RequestMapping("logout")
    public ResponseInfo logout(HttpSession session){
        session.invalidate();
        return ResponseInfo.success("请重新登录");
    }

}
