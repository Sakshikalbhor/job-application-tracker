package com.sakshi.jobtracker.controller;

import com.sakshi.jobtracker.entity.JobApplication;
import com.sakshi.jobtracker.service.JobApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @PostMapping
    public JobApplication createJobApplication(@RequestBody JobApplication jobApplication) {
        return jobApplicationService.saveJobApplication(jobApplication);
    }

    @GetMapping
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationService.getAllJobApplications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getJobApplicationById(@PathVariable Long id) {
        return jobApplicationService.getJobApplicationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
