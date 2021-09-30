package com.demo.springboot.cruddemo.service;

import java.util.List;

import com.demo.springboot.cruddemo.entity.ParentChild;

public interface ParentChildService {

	public List<ParentChild> findAll();

	public ParentChild findById(int theId);

	public void save(ParentChild theEmployee);

	public void deleteById(int theId);

}
