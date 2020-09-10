package com.lzh.comment.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzh.comment.mapper.CommentMapper;
import com.lzh.comment.pojo.Comment;
import com.lzh.comment.service.CommentService;
import com.lzh.comment.vo.UserCommentVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Override
    public List<UserCommentVO> getUserComment(Page<UserCommentVO> page) {
        return this.baseMapper.getUserComment(page);
    }

    @Override
    public List<UserCommentVO> getUserCommentList() {
        return this.baseMapper.getUserCommentList();
    }
}
