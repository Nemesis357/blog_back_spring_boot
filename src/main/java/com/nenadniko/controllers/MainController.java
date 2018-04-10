package com.nenadniko.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nenadniko.entity.PostDB;
import com.nenadniko.service.PostServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class MainController {
	//Save the uploaded file to this folder
    private static String UPLOAD_FOLDER = "G:\\blog\\images\\";
    //Logger
    private final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	PostServiceImpl postService;
	
	@GetMapping("/")
	public String mainCtrl() {
		return "Welcome to TURBO REST Server!";
	}

	@PostMapping("/create")
	public ResponseEntity<?> createCtrl(
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("image") MultipartFile file,
			@RequestParam("key") Long key,
			RedirectAttributes redirectAttributes) {
		
		logger.debug("Single file upload!");
		
		PostDB entity = new PostDB();
		entity.setTitle(title);
		entity.setContent(content);
		entity.setImageUrl(UPLOAD_FOLDER);
		entity.setUniqueKey(key);
		
		try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + key + ".jpg");
            Files.write(path, bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

		if (!postService.addPost(entity))
			return new ResponseEntity<Object>("Blog post already exist - ", HttpStatus.CONFLICT);
		
		return new ResponseEntity<Object>("Successfully uploaded - ", HttpStatus.OK);
	}
	
	@GetMapping("/retrivePosts")
	private List<PostDB> retrivePost() {
		return postService.getAllPosts();
	}
	
	@GetMapping("/post/{id}")
	private PostDB getPost(@PathVariable("id") long id) {
		PostDB post = postService.getByUniqueKey(id);

		post.setImageUrl(post.getImageUrl() + "/" + id + ".*");
		
		//Path path = Paths.get(file.getAbsolutePath());
	    //ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

		return post;
	}

}





















