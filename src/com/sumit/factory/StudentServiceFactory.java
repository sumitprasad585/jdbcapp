package com.sumit.factory;

import com.sumit.service.StudentService;
import com.sumit.service.StudentServiceImplementation;

public class StudentServiceFactory {
	private static StudentService studentService = null;
	
	static {
		studentService = new StudentServiceImplementation();
	}
	
	public static StudentService getStudentService() {
		return studentService;
	}
}
