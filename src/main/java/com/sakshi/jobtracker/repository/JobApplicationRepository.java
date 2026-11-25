package com.sakshi.jobtracker.repository;

import com.sakshi.jobtracker.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

}
