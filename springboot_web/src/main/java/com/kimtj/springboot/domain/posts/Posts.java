package com.kimtj.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity     //테이블과 링크될 클래스
public class Posts {
    @Id     //해당 테이블 PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK생성규칙
    private Long id;

    @Column(length = 500,nullable = false)  //
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)    //
    private String content;
    private String author;

    @Builder    //빌더패턴 클래스
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
