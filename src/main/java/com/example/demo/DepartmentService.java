package com.example.demo;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository deptRepository;
	
	public Collection<Department> findAllDepartments() {
		return deptRepository.findAll();
	}
	
	public String createDepartment(Department department) {

		
		deptRepository.save(department);
		
		return "record successfully created";
	}
	
	public Department findDepartment(String id) {
		Department department = null;
		
		Optional<Department> deptId = deptRepository.findById(id);
		
		if(deptId.isPresent()) {
			department = deptId.get();
		}else {
			throw new RuntimeException("Employee is not found");
		}
		
		return department;
	}
	
	public void removeDepartment(String id) {
		deptRepository.deleteById(id);
		
		
	}
	
	public void updateDepartment(String id, Department department) {
		
		deptRepository.deleteById(id);
		
		Optional<Department> deptId = deptRepository.findById(id);
		
		
		if(deptId.isPresent()) {
			department = deptId.get();
		}
		
		deptRepository.save(department);
		
	}

	
}
