package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.service.Service;
import com.gn.study.model.vo.Car;

public class Controller {
	private Service service = new Service();
	
	public List<Car> selectCarAll(){
		List<Car> list = service.selectCarAll();
		return list;
	}
	
	public int insertCarOne(String modelName, int price, String date) {
		Car car = new Car(modelName, price, date);
		int result = service.insertCarOne(car);
		return result; 
	}
}
