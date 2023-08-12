package com.example.blogapp.comments;

import com.example.blogapp.articles.ArticleEntity;
import com.example.blogapp.users.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
