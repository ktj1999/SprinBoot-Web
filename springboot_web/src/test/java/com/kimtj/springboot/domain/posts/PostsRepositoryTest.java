package com.kimtj.springboot.domain.posts;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest extends TestCase {
    @Autowired
    PostsRepository postsRepository;

    @After      //JUnit에서 단위테스트 종료마다 수행되는 메소드, 데이터침범 방지
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void readPost(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        postsRepository.save(Posts.builder().title(title)       // posts에 insert(id 미존재시)/update(id 존재시) 쿼리 실행
                                            .content(content) 
                                            .author("kimtj.com")
                                            .build());

        //when
        List<Posts> postsList = postsRepository.findAll();      // posts의 모든 데이터 조회

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}