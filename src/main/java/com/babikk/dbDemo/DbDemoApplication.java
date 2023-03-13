package com.babikk.dbDemo;

import com.babikk.dbDemo.dao.StudentDAO;
import com.babikk.dbDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return  runner ->{
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO dao){

		Student student = dao.findById(2);
		System.out.println(student);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student student=new Student("Max","Babik","kamilmaxbabik@gmail.com");
		studentDAO.save(student);

		Student student2=new Student("Max","Babicky","dssssds@gmail.com");
		studentDAO.save(student2);

		Student student3=new Student("Kamil","Babicky","dsad@gmail.com");
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student=new Student("Max","Babik","kamilmaxbabik@gmail.com");
		studentDAO.save(student);
	}
}
