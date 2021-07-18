package com.lezijie.admin.service;

import com.lezijie.admin.exception.MsgException;
import com.lezijie.admin.info.ResultInfo;
import com.lezijie.admin.pojo.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author aaa
 * @since 2021-07-18
 */
public interface ITUserService extends IService<TUser> {

    ResultInfo<TUser> login(TUser user);
    TUser findUserByUserName(String username);

    void updateInfo(String username, String password,TUser user) throws MsgException;

    void updatePassword(TUser user, String oldPsd, String newPsd, String repeatedPsd) throws MsgException;
}
