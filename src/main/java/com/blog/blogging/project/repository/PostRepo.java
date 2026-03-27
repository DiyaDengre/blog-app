package com.blog.blogging.project.repository;

import com.blog.blogging.project.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post,Integer> {

}
