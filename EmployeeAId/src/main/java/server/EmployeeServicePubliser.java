package server;

import javax.xml.ws.Endpoint;

import service.EmployeeServiceImpl;

public class EmployeeServicePubliser {
	public static void main(String[] args) { 
		Endpoint.publish("http://localhost:8080/employeeservice",
			new EmployeeServiceImpl()); 
		System.err.println("Server ready");
	}
}
