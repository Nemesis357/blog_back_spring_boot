package com.nenadniko.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nenadniko.entity.Message;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {
	Message findById(Integer id);
}
