package com.blog.api.service;

import com.blog.api.model.Comment;
import com.blog.api.respository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllCommentsOfPost(long postId){
        return commentRepository.findByPostId(postId);
    }

    public Comment addComment(Comment comment){
        Timestamp timestamp=new Timestamp(new Date().getTime());
        comment.setTime(timestamp);
        return commentRepository.save(comment);
    }

    public void deleteComment(long id) throws Exception{
        Comment comment=commentRepository.getOne(id);
        if (comment != null){
            commentRepository.deleteById(id);
        }else {
            throw new RuntimeException("Comment not found");
        }
    }
    public Comment updateComment(Comment comment){
        Comment editedComment=commentRepository.getOne(comment.getId());
        editedComment.setComment(comment.getComment());
        Timestamp timestamp=new Timestamp(new Date().getTime());
        editedComment.setTime(timestamp);
        return commentRepository.save(editedComment);
    }
}
