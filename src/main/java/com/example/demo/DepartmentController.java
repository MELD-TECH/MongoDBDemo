package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class DepartmentController {

	@Autowired
	DepartmentService deptService;
	
	@PostMapping("/add")
	public ResponseEntity<Object> createDepartment(@RequestBody Department department){
		deptService.createDepartment(department);
		
		return new ResponseEntity<Object>("Department successfully created", HttpStatus.OK);
	}
	
	@GetMapping("/findall")
	public ResponseEntity<Object> findAllDepartments(){
		
		
		return new ResponseEntity<Object>(deptService.findAllDepartments(), HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Object> getDepartment(@PathVariable String id){
				
		return new ResponseEntity<Object>(deptService.findDepartment(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Object> deleteDepartment(@PathVariable String id){
		deptService.removeDepartment(id);
		
		return new ResponseEntity<Object>("Department successfully deleted", HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateDepartment(@PathVariable String id, @RequestBody Department department){
		
		deptService.updateDepartment(id, department);
		
		return new ResponseEntity<Object>("Department successfully updated ", HttpStatus.OK);
	}
	
}
