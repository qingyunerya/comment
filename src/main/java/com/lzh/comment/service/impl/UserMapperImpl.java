package com.lzh.comment.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzh.comment.mapper.UserMapper;
import com.lzh.comment.pojo.User;
import com.lzh.comment.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
