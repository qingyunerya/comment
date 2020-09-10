package com.lzh.comment.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzh.comment.pojo.Comment;
import com.lzh.comment.service.CommentService;
import com.lzh.comment.vo.UserCommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

//    @GetMapping("/addUserComment")
//    public Page<UserCommentVO> listUserComment(@PathVariable Integer page,@PathVariable Integer size){
//        Page<UserCommentVO> userComment = commentService.getUserComment(new Page<>(page,size));
//        return userComment;
//
//    }
    @GetMapping("/listUserComment")
    public Page<UserCommentVO> listUserComment(@RequestParam(name = "page",defaultValue = "1") Integer page, @RequestParam(name = "size" ,defaultValue = "5") Integer size,@RequestParam(name = "user_id",required = false)Long userId){
        Page<UserCommentVO> userCommentVOPage = new Page<>(page, size);
        userCommentVOPage.setRecords(commentService.getUserComment(userCommentVOPage));
        return userCommentVOPage;
    }
    @GetMapping("/listUserCommentList")
    public List<UserCommentVO> listUserCommentList(@RequestParam(name = "user_id",required = false)Long userId){
        return commentService.getUserCommentList();
    }
    @PostMapping("/insert")
    public Map insert(@RequestParam(name = "user_id",defaultValue = "1") Long userId, @RequestParam(name = "title",defaultValue = "标题") String title, @RequestParam(name = "content",defaultValue = "内容") String content){
        HashMap<String, Object> map = new HashMap<>();
        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setTitle(title);
        comment.setContent(content);
        commentService.save(comment);
        map.put("status",200);
        return map;
    }

}
