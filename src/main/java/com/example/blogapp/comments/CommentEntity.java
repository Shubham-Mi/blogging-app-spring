package com.example.blogapp.comments;

import com.example.blogapp.articles.ArticleEntity;
import com.example.blogapp.users.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(nullable = false)
    String title;
    String body;
    @Column(nullable = false)
    Date createdAt;
    @ManyToOne
    ArticleEntity article;
    @ManyToOne
    UserEntity commenter;
}
