package com.javaSpring.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaSpring.entity.Employee;
import com.javaSpring.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	public void addEmployee(Employee e) {
		empRepo.save(e);
	}
	
	public List<Employee> getAll(){
		
		return empRepo.findAll();
	}
	
	public Employee getEmployeeById(int id) {
		
		Optional<Employee> e = empRepo.findById(id);
		
		if(e.isPresent()) {
			return e.get();
		}
		
		return null;
	}
	
    public void deleteEmployeeById(int id) {
		
    	empRepo.deleteById(id);
	}
}
