package com.sumit.factory;

import com.sumit.dao.StudentDao;
import com.sumit.dao.StudentDaoImplementation;

public class StudentDaoFactory {
	private static StudentDao studentDao = null;
	static {
		studentDao = new StudentDaoImplementation();
	}
	public static StudentDao getStudentDao() {
		return studentDao;
	}

}
