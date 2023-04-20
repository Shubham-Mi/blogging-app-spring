package com.example.blogapp.users;

import com.example.blogapp.articles.ArticleEntity;
import com.example.blogapp.comments.CommentEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(nullable = false, unique = true)
    String username;
    @Column(nullable = false, unique = true)
    String email;
    @Column(nullable = false)
    String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    List<ArticleEntity> articles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commenter")
    List<CommentEntity> comments;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "following")
    Set<UserEntity> followers;
    @ManyToMany(cascade = CascadeType.ALL)
    Set<UserEntity> following;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "likes")
    Set<ArticleEntity> likedArticles;
}
