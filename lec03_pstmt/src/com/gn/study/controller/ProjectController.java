package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.dao.ProjectDao;
import com.gn.study.model.vo.ProjectVo;

public class ProjectController {
	private ProjectDao pd = new ProjectDao();
	
	public List<ProjectVo> selectProjectAll(){
		return pd.selectProjectAll();
	}
	
	public int insertProjectOne(String projectName, int empId) {
		return pd.insertProjectOne(projectName, empId);
	}
}
