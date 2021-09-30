package com.demo.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springboot.cruddemo.entity.ParentChild;

public interface ParentChildRepository extends JpaRepository<ParentChild, Integer> {
	
}
