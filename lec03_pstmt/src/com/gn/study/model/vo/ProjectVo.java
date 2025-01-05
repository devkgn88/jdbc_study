package com.gn.study.model.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProjectVo {
	private int projectId;
	private String projectName;
	private int projectManager;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	
	
	public ProjectVo() {}

	public ProjectVo(int projectId, String projectName, int projectManager, LocalDateTime regDate,
			LocalDateTime modDate) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectManager = projectManager;
		this.regDate = regDate;
		this.modDate = modDate;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(int projectManager) {
		this.projectManager = projectManager;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public LocalDateTime getModDate() {
		return modDate;
	}

	public void setModDate(LocalDateTime modDate) {
		this.modDate = modDate;
	}
	
	public String dateToStr(LocalDateTime ldt) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy-mm-dd(E)");
		return dtf.format(ldt);
	}

	@Override
	public String toString() {
		return "[번호 : " + projectId 
				+ ", 이름 : " + projectName 
				+ ", 관리자 : " + projectManager 
				+ ", 등록일 : " + dateToStr(regDate) 
				+ ", 수정일 : " + dateToStr(modDate) + "]";
	}
	
}
