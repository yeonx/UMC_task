package com.umc.week6.post.controller;

import com.umc.week6.post.sevice.PostService;
import com.umc.week6.post.sevice.dto.PostCreateDto;
import com.umc.week6.post.sevice.dto.PostUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
