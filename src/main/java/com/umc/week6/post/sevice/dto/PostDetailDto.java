package com.umc.week6.post.sevice.dto;

import com.umc.week6.post.domain.Post;
import lombok.Getter;

@Getter
public class PostDetailDto {

    private long id;
    private String title;
    private String content;

    public PostDetailDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
