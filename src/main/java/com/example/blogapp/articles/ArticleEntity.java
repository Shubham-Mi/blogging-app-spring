package com.example.blogapp.articles;

import com.example.blogapp.comments.CommentEntity;
import com.example.blogapp.users.UserEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
