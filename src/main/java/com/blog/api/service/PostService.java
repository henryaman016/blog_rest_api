package com.blog.api.service;

import com.blog.api.model.Post;
import com.blog.api.respository.CommentRepository;
import com.blog.api.respository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    public List<Post> retrieveAllPosts(){
        return postRepository.findAll();
    }

    public Post getPost(long id){
        return postRepository.getOne(id);
    }
    public Post createPost(Post post){
        return postRepository.save(post);
    }

    @Transactional
    public void deletePost(long id) throws Exception {

        Post post = postRepository.getOne(id);
        if (post != null) {
            commentRepository.deleteByPostId(id);
            postRepository.deleteById(id);
        } else {
            throw new RuntimeException("Record not found");
        }
    }
        public Post updatePost(Post post) {

            Post editedPost = postRepository.getOne(post.getId());
            editedPost.setTitle(post.getTitle());
            editedPost.setDescription(post.getDescription());
            return postRepository.save(editedPost);
        }
    }



