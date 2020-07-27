package com.sumit.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.sumit.dto.Student;
import com.sumit.factory.ConnectionFactory;
import com.sumit.factory.StudentServiceFactory;
import com.sumit.service.StudentService;
import com.sumit.service.StudentServiceImplementation;

public class Test {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		while(true) {
			System.out.println("1-ADD");
			System.out.println("2-Search");
			System.out.println("3-UPDATE");
			System.out.println("4-DELETE");
			System.out.println("5-EXIT");
			System.out.print("Enter your choice : " );
			choice = Integer.parseInt(br.readLine());
			
			String sname = "";
			String sid = "";
			String saddr = "";
			
			String status = "";
			StudentService studentService = null;
			Student student = null;
			
			switch(choice) {
				case 1:
					System.out.println("===========ADD Student============");
					System.out.print("Student ID       :" );
					sid = br.readLine();
					System.out.print("Student name     :");
					sname = br.readLine();
					System.out.print("Student address  :");
					saddr = br.readLine();
					student = new Student();
					student.setSid(sid);
					student.setSname(sname);
					student.setSaddr(saddr);
					
					studentService = StudentServiceFactory.getStudentService();
					status = studentService.addStudent(student);
					System.out.println(status);
					break;
				case 2:
					System.out.println("===========Search Student==============");
					System.out.print("Enter the student id to search : ");
					sid = br.readLine();
					studentService = StudentServiceFactory.getStudentService();
					student = studentService.searchStudent(sid);
					if(student == null) {
						System.out.println("Student does not exist");
					}
					else {
						System.out.println("Student details : ");
						System.out.println("--------------------");
						System.out.println(student.getSid());
						System.out.println(student.getSname());
						System.out.println(student.getSaddr());
					}
					break;
				case 3:
					System.out.println("===========UPDATE Student==============");
					System.out.print("Enter the Student ID : ");
					sid = br.readLine();
					studentService = StudentServiceFactory.getStudentService();
					student = studentService.searchStudent(sid);
					if(student == null) {
						System.out.println("Student doesn't exist");
					}
					else {
						System.out.println("Student Name [old value : " + student.getSname() + "] New value : ");
						sname = br.readLine();
						if(sname == null || sname.equals("")) {
							sname = student.getSname();
						}
						System.out.println("Student Address [old value : " + student.getSaddr() + "] New value : ");
						saddr = br.readLine();
						if(saddr == null || saddr.equals("")) {
							saddr = student.getSname();
						}
						
						student = new Student();
						student.setSid(sid);
						student.setSname(sname);
						student.setSaddr(saddr);
						status = studentService.updateStudent(student);
						System.out.println(status);
					}
					break;
				case 4:
					System.out.println("===========Delete Student==============");
					System.out.print("Enter the student ID : ");
					sid = br.readLine();
					studentService = StudentServiceFactory.getStudentService();
					student = studentService.searchStudent(sid);
					if(student == null) {
						System.out.println("Student does not exits");
					}
					else {
						status = studentService.deleteStudent(sid);
						System.out.println(status);
					}
					break;
				case 5:
					ConnectionFactory.closeResources();
					System.out.println("Thanks for using application");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid entry!!! Pls enter a valid option[1, 2, 3, 4, 5] : ");
					choice = Integer.parseInt(br.readLine());
				
			}
		}

	}

}
