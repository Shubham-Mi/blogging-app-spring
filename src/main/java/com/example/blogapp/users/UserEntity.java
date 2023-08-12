package com.example.blogapp.users;

import com.example.blogapp.articles.ArticleEntity;
import com.example.blogapp.comments.CommentEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
