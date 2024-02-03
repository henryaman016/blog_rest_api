package com.blog.api.respository;

import com.blog.api.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    public List<Comment> findByPostId(long postId);
    public void deleteByPostId(long postId);

}
