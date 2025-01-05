package com.gn.study.model.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProjectVo {
	private int projectId;
	private String projectName;
	private int projectManager;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	private String managerName;
	
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
	
	public String getManagerName() {
		return managerName;
	}
	
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
	public String dateToStr(LocalDateTime ldt) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy-mm-dd(E)");
		return dtf.format(ldt);
	}

	@Override
	public String toString() {
		String result = "[번호 : " + projectId 
				+ ", 이름 : " + projectName ;
		if(projectManager==0) {
			result += ", 관리자 : 미정";
		} else {
			result += ", 관리자 : "+ managerName+"(" +projectManager+")";
		}
		result += ", 등록일 : " + dateToStr(regDate) ;
		result += ", 수정일 : " + dateToStr(modDate) + "]";
		return result;
	}
	
}
