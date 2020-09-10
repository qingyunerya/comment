package com.lzh.comment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzh.comment.pojo.Comment;
import com.lzh.comment.vo.UserCommentVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper extends BaseMapper<Comment> {
    @Select("SELECT c.id,c.user_id,u.name,c.title,c.content,c.create_time,c.update_time FROM comment AS c,user AS u WHERE c.user_id=u.id")
    List<UserCommentVO> getUserComment(Page<UserCommentVO> page);
    @Select("SELECT c.id,c.user_id,u.name,c.title,c.content,c.create_time,c.update_time FROM comment AS c,user AS u WHERE c.user_id=u.id")
    List<UserCommentVO> getUserCommentList();
   // Map<String,Object> addUserComment(Long id, Long userId, String title, Date createTime,Date updateTime);
}
