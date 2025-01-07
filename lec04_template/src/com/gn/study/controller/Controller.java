package com.gn.study.controller;

import com.gn.study.model.service.Service;
import com.gn.study.model.vo.Car;

public class Controller {
	private Service service = new Service();
	
	public int insertCarOne(String modelName, int price, String date) {
		Car car = new Car(modelName, price, date);
		int result = service.insertCarOne(car);
		return result; 
	}
}
