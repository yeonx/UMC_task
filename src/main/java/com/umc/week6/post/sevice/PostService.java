package com.umc.week6.post.sevice;

import com.umc.week6.post.domain.Post;
import com.umc.week6.post.repository.PostRepository;
import com.umc.week6.post.sevice.dto.PostCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public long create(PostCreateDto postCreateDto){
        Post post = Post.builder()
                .title(postCreateDto.getTitle())
                .content(postCreateDto.getContent())
                .build();
        postRepository.save(post);
        return post.getId();
    }
}
