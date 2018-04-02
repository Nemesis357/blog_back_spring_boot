package com.nenadniko.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="posts")
public class PostDB {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	@Column(name="title")
	private String title;
	@Column(name="content") 
    @Lob
	private String content;
	@Column(name="image_url")
	private String imageUrl;
	@Column(name="unique_key")
	private Long uniqueKey;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Long getUniqueKey() {
		return uniqueKey;
	}
	public void setUniqueKey(Long uniqueKey) {
		this.uniqueKey = uniqueKey;
	}
}
