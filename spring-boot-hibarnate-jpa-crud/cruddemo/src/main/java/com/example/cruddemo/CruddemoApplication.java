package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner-> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		//retrieve student based on the id: primary key
		int studentId = 3;
		System.out.println("Deleting student with id: " + studentId);

		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);

		Student myStudent = studentDAO.findById(studentId);
		System.out.println("Updating student..");

		//change first name to "Scooby"
		myStudent.setFirstName("John");
		studentDAO.update(myStudent);

		//display updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Doe");

		//display list of students
		for( Student tempStudents: theStudents){
			System.out.println(tempStudents);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new object..");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");

		//save the student object
		System.out.println("Saving the student..");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

		//retrieve student based on the id: primary key
		System.out.println("\nRetrieving student with id: " + tempStudent.getId());

		Student myStudent = studentDAO.findById(tempStudent.getId());
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating 3 student objects..");
		Student tempStudent1 = new Student("Paul", "Doe", "pauldoe@gmail.com");
		Student tempStudent2 = new Student("Vlad", "Andrei", "vladandrei@gmail.com");
		Student tempStudent3 = new Student("Anisia", "Love", "anisialove@gmail.com");
		//save the student objects
		System.out.println("Saving the students..");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object..");
		Student tempStudent = new Student("Paul", "Doe", "pauldoe@gmail.com");
		//save the student object
		System.out.println("Saving the student..");
		studentDAO.save(tempStudent);
		//display id of the saved student
		System.out.println("Saved student: Generated id: " + tempStudent.getId());
	}

}
