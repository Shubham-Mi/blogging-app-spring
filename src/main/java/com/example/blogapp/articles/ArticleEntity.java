package com.example.blogapp.articles;

import com.example.blogapp.comments.CommentEntity;
import com.example.blogapp.users.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String title;
    @Column(nullable = false, unique = true)
    String slug;
    String subtitle;
    @Column(nullable = false)
    String body;
    Date createdAt;
    List<String> tags;
    @ManyToOne
    UserEntity author;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
    List<CommentEntity> comments;
    @ManyToMany(cascade = CascadeType.ALL)
    List<UserEntity> likes;
}
