package com.gn.study.model.service;

import static com.gn.study.common.JDBCTemplate.close;
import static com.gn.study.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.gn.study.model.dao.Dao;
import com.gn.study.model.vo.Car;

public class Service {
	private Dao dao = new Dao();
	
	public int insertCarOne(Car car) {
		Connection conn = getConnection();
		int result = dao.insertCarOne(car, conn);
		close(conn);
		return result;
	}
}
