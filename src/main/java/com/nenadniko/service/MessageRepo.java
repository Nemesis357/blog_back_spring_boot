package com.nenadniko.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nenadniko.entity.Message;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {
	Message findById(Integer id);
	//@Query("UPDATE spring_db.message SET date = :date, email = :email, message = :message, name = :name WHERE id = :id")
	//Message updateMessage(Message msg);
	
	 //@Query("SELECT a FROM Article a WHERE a.title=:title and a.category=:category")
	 //PostDB post findPostById(@Param("uniqueKey") String title);
}
