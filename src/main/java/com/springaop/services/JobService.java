package com.springaop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springaop.model.JobPost;
import com.springaop.repo.JobRepo;

@Service
public class JobService {
	
	@Autowired
	private JobRepo jobrepo;
	
	public void addJob(JobPost jobPost)
	{
		jobrepo.save(jobPost);
	}

	public List<JobPost> viewAllJobs() {
		return jobrepo.findAll();
	}

	public void update(JobPost jobPost) {
		jobrepo.save(jobPost);
		
	}

	public void delete(int jobId) {
		jobrepo.deleteById(jobId);
		
	}

	public JobPost viewJob(int id) {
		return jobrepo.findById(id).orElse(new JobPost());
	}

}
