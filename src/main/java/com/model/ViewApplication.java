package com.model;

public class ViewApplication {
	
    private Job job;
    private Job_application application;
    private User user;

    public ViewApplication(User user,Job job) {
    	this.user = user;
        this.job = job;
       }
    
    public Job getJob() { 
    	return job; 
    	}
    
    public Job_application getApplication() { 
    	return application;
    	}
    public User getUser(){
    	return user;
    }
}