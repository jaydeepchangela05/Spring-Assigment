package com.demo.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.springboot.cruddemo.dao.ParentChildRepository;
import com.demo.springboot.cruddemo.entity.ParentChild;

@Service
public class ParentChildServiceImpl implements ParentChildService {

	private ParentChildRepository parentChildRepository;
	
	public Logger LOGGER = LoggerFactory.getLogger(ParentChildServiceImpl.class);

	@Autowired
	public ParentChildServiceImpl(ParentChildRepository theParentChildRepository) {
		parentChildRepository = theParentChildRepository;
	}

	@Override
	@Transactional
	public List<ParentChild> findAll() {
		
		LOGGER.info("Call Of FindAll Method");
		
		return parentChildRepository.findAll();
	}

	@Override
	@Transactional
	public ParentChild findById(int theId) {

		Optional<ParentChild> result = parentChildRepository.findById(theId);

		ParentChild theParentChild = null;

		if (result.isPresent()) {
			theParentChild = result.get();
		} else {
			throw new RuntimeException("Did no find Parent id - " + theId);
		}
		
		LOGGER.info("Call Of FindById Method");
		
		return theParentChild;
	}

	@Override
	@Transactional
	public void save(ParentChild theParentChild) {
		
		LOGGER.info("Call Of Save Method");
		
		parentChildRepository.save(theParentChild);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		
		LOGGER.info("Call Of deleteById Method");
		
		parentChildRepository.deleteById(theId);
	}

}
