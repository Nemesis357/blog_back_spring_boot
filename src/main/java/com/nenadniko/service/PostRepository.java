package com.nenadniko.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nenadniko.entity.PostDB;

@Repository
public interface PostRepository extends JpaRepository<PostDB, Integer> {
	PostDB findByUniqueKey(Long unique_key);
	
	
	 //@Query("SELECT a FROM Article a WHERE a.title=:title and a.category=:category")
	 //PostDB post findPostById(@Param("uniqueKey") String title);
}
