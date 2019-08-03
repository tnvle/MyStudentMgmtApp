package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.ClassroomRepository;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;
import edu.mum.cs.cs425.studentmgmt.repository.TranscriptRepository;

@SpringBootApplication
public class StudentMgmtApp implements CommandLineRunner{

	@Autowired
	private StudentRepository repository;
	@Autowired
	private ClassroomRepository classroomRepository;
	@Autowired
	private TranscriptRepository transcriptRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentMgmtApp.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		//Task1
		Student s = new Student("000-61-0001", "Anna", "Lynn", "Smith", 3.45f, LocalDate.of(2019, 5, 24));
		Student savedStudent = saveStudent(s);
		System.out.println(savedStudent);
		
		//Task2
		//Student & Transcript
		Student s2 = new Student("000-61-0002", "Kenn", "Alley", "Brown", 4.45f, LocalDate.of(2019, 5, 25));
		Transcript transcript = new Transcript("BS Computer Science");
		s2.setTranscript(transcript);
		transcript.setStudent(s2);
		Student savedStudent2 = saveStudent(s2);
		System.out.println(savedStudent2);
//		transcript.setStudent(s2);
//		s2.setTranscript(transcript);
//		Transcript savedTranscript = saveTranscript(transcript);
//		System.out.println(savedTranscript);
		
		//Student & Classroom
		Student s3 = new Student("000-61-0003", "Micheal", "John", "Mike", 4.45f, LocalDate.of(2019, 5, 25));
		Student s4 = new Student("000-61-0004", "Mary", "Baker", "David", 5.45f, LocalDate.of(2019, 5, 26));
		Classroom classroom = new Classroom("McLaughlin building", "M105");			
		classroom.addStudent(s3);
		classroom.addStudent(s4);		
		s3.setClassroom(classroom);
		s4.setClassroom(classroom);
		Classroom savedClassRoom = saveClassroom(classroom);
		System.out.println(savedClassRoom);		
		
	}
	Student saveStudent(Student s) {		
		return this.repository.save(s);
	}
	
	Classroom saveClassroom(Classroom classroom) {		
		return this.classroomRepository.save(classroom);
	}
	
	Transcript saveTranscript(Transcript transcript) {		
		return this.transcriptRepository.save(transcript);
	}

}
