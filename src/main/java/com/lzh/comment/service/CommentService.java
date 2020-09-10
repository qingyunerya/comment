package com.lzh.comment.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lzh.comment.pojo.Comment;
import com.lzh.comment.vo.UserCommentVO;

import java.util.List;

public interface CommentService extends IService<Comment> {

    List<UserCommentVO> getUserComment(Page<UserCommentVO> page);

    List<UserCommentVO> getUserCommentList();
}
