package com.umc.week6.post.controller;

import com.umc.week6.post.domain.Post;
import com.umc.week6.post.sevice.PostService;
import com.umc.week6.post.dto.PostCreateDto;
import com.umc.week6.post.dto.PostDetailDto;
import com.umc.week6.post.dto.PostUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @PostMapping("")
    public long createPost(PostCreateDto postCreateDto){
        return postService.create(postCreateDto);
    }

    @PostMapping("/{postId}")
    public void updatePost(@PathVariable("postId") long postId, PostUpdateDto postUpdateDto){
        postService.update(postUpdateDto,postId);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable("postId") long postId){
        postService.delete(postId);
    }

    @GetMapping("/{postId}")
    public PostDetailDto getPostDetail(@PathVariable("postId") long postId){
        return postService.getPostDetail(postId);
    }

    @GetMapping("")
    public List<Post> getPost(Pageable pageable){
        return postService.getPost(pageable);
    }
}
