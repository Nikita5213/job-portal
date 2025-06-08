package com.model;

import java.io.InputStream;

public class Profile{
	
	String email;
	int phoneno,experience;
	String education,skills,project,certificates;
	//InputStream resumeFile;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}

//    public InputStream getResumeFile() {
//        return resumeFile;
//    }
//    public void setResumeFile(InputStream resumeFile) {
//        this.resumeFile = resumeFile;
//    }
}
	
		
