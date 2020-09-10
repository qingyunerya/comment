package com.lzh.comment;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzh.comment.mapper.CommentMapper;
import com.lzh.comment.mapper.UserMapper;
import com.lzh.comment.pojo.User;
import com.lzh.comment.service.CommentService;
import com.lzh.comment.vo.UserCommentVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CommentApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Autowired
    CommentService commentService;
    @Test
    void contextLoads() {
        User user1 = new User();
        user1.setId(3L);
        user1.setName("小张");
//        userMapper.insert(user1);


        User user2 = new User();
        user2.setId(3L);
        user2.setName("小张");
        userMapper.updateById(user2);
        userMapper.updateById(user1);
        User user = userMapper.selectById("1L");
    }
    @Test
    void testOptim(){
        User user = userMapper.selectById(3L);
        user.setName("caodan ");
        User user2 = userMapper.selectById(3L);
        user2.setName("caodan2 ");
        userMapper.updateById(user2);
        userMapper.updateById(user);
    }
    @Test
    void testComment(){
        Page<UserCommentVO> page = new Page<>(1, 5);
        page.setRecords(commentService.getUserComment(page));
        System.out.println(page);

    }

}
