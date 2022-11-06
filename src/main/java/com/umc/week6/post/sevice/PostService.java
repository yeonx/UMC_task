package com.umc.week6.post.sevice;

import com.umc.week6.exception.NotFoundException;
import com.umc.week6.post.domain.Post;
import com.umc.week6.post.repository.PostRepository;
import com.umc.week6.post.dto.PostCreateDto;
import com.umc.week6.post.dto.PostDetailDto;
import com.umc.week6.post.dto.PostUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.umc.week6.exception.ErrorCode.POST_NOT_FOUND;

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

    @Transactional
    public void update(PostUpdateDto postUpdateDto, long postId){
        Optional<Post> checkPost = postRepository.findById(postId);
        Post post = checkPost.orElseThrow(() ->
                new NotFoundException(POST_NOT_FOUND));
        post.update(postUpdateDto.getTitle(),postUpdateDto.getContent());
    }

    @Transactional
    public void delete(long postId){
        postRepository.deleteById(postId);
    }

    @Transactional(readOnly = true)
    public PostDetailDto getPostDetail(long postId) {
        Optional<Post> checkPost = postRepository.findById(postId);
        Post post = checkPost.orElseThrow(() ->
                new NotFoundException(POST_NOT_FOUND));
       return new PostDetailDto(post);
    }

    @Transactional(readOnly = true)
    public List<Post> getPost() {
        return postRepository.findAll();
    }
}
