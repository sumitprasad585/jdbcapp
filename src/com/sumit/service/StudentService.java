package com.sumit.service;

import com.sumit.dto.Student;

public interface StudentService {
	public String addStudent(Student s);
	public Student searchStudent(String sid);
	public String updateStudent(Student s);
	public String deleteStudent(String sid);

}
