package com.springaop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springaop.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {
	

}
