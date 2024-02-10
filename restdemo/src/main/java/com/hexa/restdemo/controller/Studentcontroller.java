package com.hexa.restdemo.controller;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hexa.restdemo.bean.Student;
 
@RestController
public class Studentcontroller {
	// returns a single object
	//http://localhost:8085/getStudent
	@GetMapping("/getStudent")
	public ResponseEntity<Student> getStudent() {
		Student obj=new Student(100, "Riju", "Antony");
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}
	// retruns a list of students
	@GetMapping("/getStudentlist")
	// http://localhost:8085/getStudentlist
	public ResponseEntity<List<Student>> getStudentList() {
		java.util.List<Student> myList = new ArrayList<Student>();
		myList.add(new Student(101, "Rahul", "KR"));
		myList.add(new Student(102, "Sowmya", "T"));
		myList.add(new Student(103, "Laja", "S"));
		return new ResponseEntity<>(myList,HttpStatus.OK);
 
	}
	
 
	// path variable gettind details of student with id
	//http://localhost:8085/getStudentusingsuppliedargs/100/Hema/V
	@GetMapping("/getStudentbyid/{id}")
	public Student getStudentById(@PathVariable int id) {
		Student result = null;
		java.util.List<Student> myList = new ArrayList<Student>();
		myList.add(new Student(101, "Rahul", "KR"));
		myList.add(new Student(102, "Sowmya", "T"));
		myList.add(new Student(103, "Laja", "S"));
		for (Student obj : myList) {
			if (obj.getId() == id) {
				result = obj;
				break;
 
			}
		}
 
		return result;
 
	}
 
	// returns a single object created by passing values from url
	//http://localhost:8085/getStudentusingsuppliedargs/100/Hema/V
	@GetMapping("/getStudentusingsuppliedargs/{id}/{fname}/{lname}")
	public Student getStudent(@PathVariable("id") int studentId, @PathVariable("fname") String firstName,
			@PathVariable("lname") String lastName) {
		return (new Student(studentId,firstName,lastName));
	}

 
	// @requestParam or queryparam gettind details of student with id
	//http://localhost:8085/getStudentbyidreqparam?id=101
	@GetMapping("/getStudentbyidreqparam")
	public Student getStudentByIdReqParam(@RequestParam int id) {
		Student result = null;
		java.util.List<Student> myList = new ArrayList<Student>();
		myList.add(new Student(101, "Rahul", "KR"));
		myList.add(new Student(102, "Sowmya", "T"));
		myList.add(new Student(103, "Laja", "S"));
		for (Student obj : myList) {
			if (obj.getId() == id) {
				result = obj;
				break;
 
			}
		}
 
		return result;
 
	}

	// returns a single object created by passing values from reqparams
	// http://localhost:8085/demo/getStudentusingsuppliedargsreqparamas?id=107&fname=Hema&lname=V&opt=hhg
	@GetMapping("/getStudentusingsuppliedargsreqparamas")
	public ResponseEntity<Student> getStudentobj(@RequestParam(name = "id", defaultValue = "100") int studentId,
			@RequestParam(name = "fname") String firstName, @RequestParam(name = "lname") String lastName,
			@RequestParam(required = false) String opt) {
		Student t=new Student(studentId, firstName, lastName);
		return ResponseEntity.ok().header("admin", "sayooj").body(t);
	}
		
		// prints teh student entity. used for saving the entity in db
		// http://localhost:8085/saveStudent
		@PostMapping("/saveStudent")
		@ResponseStatus(HttpStatus.CREATED)
		public Student createStudent(@RequestBody Student s) {
			System.out.println(s);
			return s;
	 
		}
	 
		// updATE STUDENT WITH given id
		// http://localhost:8085/updateStudent/{id}
		@PutMapping("/updatestudent/{id}")
		public Student updateStudent(@PathVariable int id, @RequestBody Student s) {
			Student result = null;
			java.util.List<Student> myList = new ArrayList<Student>();
			myList.add(new Student(101, "Rahul", "KR"));
			myList.add(new Student(102, "Sowmya", "T"));
			myList.add(new Student(103, "Laja", "S"));
			for (Student obj : myList) {
				if (obj.getId() == id) {
					result = obj;
					break;
	 
				}
	 
			}
			result.setFirstname(s.getFirstname());
			result.setLastname(s.getLastname());
			System.out.println(result);
			return result;
	 
		}
		
		@DeleteMapping(path = "/deletestudent/{id}")
		public ResponseEntity<List<Student>> deleteStudent(@PathVariable int id) {
			
			java.util.List<Student> myList = new ArrayList<>();
			
			myList.add(new Student(1, "rahul", "tiwari"));
			myList.add(new Student(2, "raj", "tiwari"));
			myList.add(new Student(3, "ritu", "tiwari"));
			
			for(Student st:myList) {
				if(id==st.getId()) {
					myList.remove(st);
					break;
				}
			}
			return new ResponseEntity<List<Student>>(myList,HttpStatus.OK);
		}
		
		
	 
		// retruns a list of students
		
		
//		// returns a single object created by passing values from reqparams
//		// http://localhost:8085/demo/getStudentusingsuppliedargsreqparamas?id=107&fname=Hema&lname=V&opt=hhg
//		@GetMapping("/getStudentusingsuppliedargsreqparamas")
//		public ResponseEntity<Student> getStudentobj(@RequestParam(name = "id", defaultValue = "100") int studentId,
//				@RequestParam(name = "fname") String firstName, @RequestParam(name = "lname") String lastName,
//				@RequestParam(required = false) String opt) {
//			Student t=new Student(studentId, firstName, lastName);
//			return ResponseEntity.ok().header("admin", "sayooj").body(t);
//		}

 
}