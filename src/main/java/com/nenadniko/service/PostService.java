package com.nenadniko.service;

import java.util.List;

import com.nenadniko.entity.PostDB;

public interface PostService {
	boolean addPost(PostDB post);
	List<PostDB> getAllPosts();
	PostDB getByUniqueKey(long id);
}
