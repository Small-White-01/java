package com.lezijie.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lezijie.admin.exception.MsgException;
import com.lezijie.admin.info.ResultInfo;
import com.lezijie.admin.pojo.TUser;
import com.lezijie.admin.mapper.TUserMapper;
import com.lezijie.admin.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lezijie.admin.utils.Assert;
import com.lezijie.admin.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author aaa
 * @since 2021-07-18
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {


    @Override
    public ResultInfo<TUser> login(TUser user) {
        Assert.isBlank(user.getUsername(),"用户名不能为空");
        Assert.isBlank(user.getPassword(),"密码不能为空");
        TUser tUser = this.findUserByUserName(user.getUsername());
        if(tUser!=null){
            String password = user.getPassword();
            if(StringUtils.equal(password,tUser.getPassword())){
                return new ResultInfo<TUser>(true,tUser,"登陆成功");
            }
            return new ResultInfo<>(false,tUser,"密码错误");

        }
        return new ResultInfo<>(false,null,"用户名不存在");
    }

    @Override
    public TUser findUserByUserName(String username) {

        return this.baseMapper.selectOne(new QueryWrapper<TUser>().eq("isDel",0).eq("username",username));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateInfo(String username, String password,TUser user) throws MsgException {
        TUser userByUserName = this.findUserByUserName(username);

        Assert.isTrue(userByUserName!=null&&!(user.getId()==userByUserName.getId()),"用户名已被占用");
        Assert.isTrue(!this.updateById(user),"用户信息更新失败");



    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(TUser user, String oldPsd, String newPsd, String repeatedPsd) throws MsgException {
        TUser tUser = this.findUserByUserName(user.getUsername());
        Assert.isTrue(!tUser.getPassword().equals(oldPsd),"旧密码输入有误");
        Assert.isTrue(!StringUtils.equal(newPsd,repeatedPsd),"两次输入密码不一致");
        tUser.setPassword(newPsd);
        Assert.isTrue(!this.updateById(tUser),"密码更新失败");

    }
}
