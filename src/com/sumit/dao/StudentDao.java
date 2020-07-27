package com.sumit.dao;

import com.sumit.dto.Student;

public interface StudentDao {
	public String add(Student s);
	public Student search(String sid);
	public String update(Student s);
	public String delete(String sid);

}
