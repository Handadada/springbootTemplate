package com.example.bootDemo.user.service;

import com.example.bootDemo.enums.ErrorEnum;
import com.example.bootDemo.exception.ProjectException;
import com.example.bootDemo.user.mapper.UserMapper;
import com.example.bootDemo.user.model.User;
import com.example.bootDemo.utils.UuidUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2020-01-20 14:20
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> listUsers(User user) {
        if (null == user) {
            throw new ProjectException(ErrorEnum.DATA_ERROR);
        }
        String name = StringUtils.isBlank(user.getRealName()) ? "" : user.getRealName();
        return userMapper.listUsers(name);
    }

    public void addUser(User user) {
        if (!checkUser(user)) {
            throw new ProjectException(ErrorEnum.DATA_ERROR);
        }
        int num = userMapper.addUser(user);
        if (num <= 0) {
            throw new ProjectException(ErrorEnum.DATA_ADD_ERROR);
        }
    }

    //检验人员信息
    private boolean checkUser(User user) {
        if (null == user)
            return false;
        if (StringUtils.isBlank(user.getRealName()))
            return false;
        if (StringUtils.isBlank(user.getAccount()))
            return false;
        if (StringUtils.isBlank(user.getPwd()) || StringUtils.isBlank(user.getSecondPwd()))
            return false;
        if (!user.getPwd().equals(user.getSecondPwd()))
            return false;
        if (StringUtils.isBlank(user.getPhoneNumber()))
            return false;
        user.setRoleId(1);
        user.setStatus(1);
        user.setCreateTime(new Date());
        user.setId(UuidUtil.getUUID());
        return true;
    }

    public void deleteUser(User user) {
        if (null == user || StringUtils.isBlank(user.getId())) {
            throw new ProjectException(ErrorEnum.DATA_ERROR);
        }
        userMapper.deleteUser(user);
    }

    public void updateUser(User user) {
        if (null == user || StringUtils.isBlank(user.getId())) {
            throw new ProjectException(ErrorEnum.DATA_ERROR);
        }
        user.setUpdateTime(new Date());
        userMapper.updateUser(user);
    }

    public void reSetPwd(User user) {
        if (null == user || StringUtils.isBlank(user.getId())) {
            throw new ProjectException(ErrorEnum.DATA_ERROR);
        }
        userMapper.reSetPwd(user);
    }
}