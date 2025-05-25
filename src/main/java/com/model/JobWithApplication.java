package com.model;

public class JobWithApplication {
	
    private Job job;
    private Job_application application;

    public JobWithApplication(Job job, Job_application application) {
        this.job = job;
        this.application = application;
    }

    public Job getJob() { 
    	return job; 
    	}
    
    public Job_application getApplication() { 
    	return application;
    	}
}