package com.sumit.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sumit.dto.Student;
import com.sumit.factory.ConnectionFactory;
import com.sumit.factory.StudentDaoFactory;

public class StudentDaoImplementation implements StudentDao {

	@Override
	public String add(Student student) {
		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			Student std = search(student.getSid());
			if(std == null) {
				int rowCount = st.executeUpdate("insert into student values('" + student.getSid() + "','" + student.getSname() + "','" + student.getSaddr() + "')" );
				if(rowCount == 1)
					status = "student inserted successfully";
				else
					status = "student insertion failure";
			}
			else {
				status = "Student already exists";
			}
			
		} catch (SQLException e) {
			status = "student insertion failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student search(String sid) {
		Student student = null;
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from student where SID = '" + sid + "'");
			
			boolean b = rs.next();
			
			if(b) {
				student = new Student();
				student.setSid(rs.getString("SID"));
				student.setSname(rs.getString("SNAME"));
				student.setSaddr(rs.getString("SADDR"));
			}
			else {
				student = null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public String update(Student student) {
		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			
			int rowCount = st.executeUpdate("update student set SNAME = '" + student.getSname() + "', SADDR = '" + student.getSaddr() + "' where SID = '" + student.getSid() + "'");
			if(rowCount == 1) {
				status = "Student updated successfully";
			}
			else {
				status = "Student update failure";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String delete(String sid) {
		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			
			int rowCount = st.executeUpdate("delete from student where SID = '" + sid + "'");
			if(rowCount == 1) {
				status = "Student deleted successfully";
			}
			else {
				status = "Student deletion failure";
			}
		}
		catch(Exception e) {
			status = "Student deletion failure";
			e.printStackTrace();
		}
		return status;
	}

}
