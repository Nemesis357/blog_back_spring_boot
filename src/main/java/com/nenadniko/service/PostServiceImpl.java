package com.nenadniko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nenadniko.entity.PostDB;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostRepository postRepo;

	@Override
	public boolean addPost(PostDB post) {
		if (postRepo.findByUniqueKey(post.getUniqueKey()) == null) {
			postRepo.save(post);
			return true;
		}
		return false;
	}

	@Override
	public List<PostDB> getAllPosts() {
		List<PostDB> posts = postRepo.findAll();
		return posts;
	}

	@Override
	public PostDB getByUniqueKey(long id) {
		return postRepo.findByUniqueKey(id); 
	}
	
}
