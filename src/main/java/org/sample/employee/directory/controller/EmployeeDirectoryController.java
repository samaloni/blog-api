package org.sample.employee.directory.controller;

import java.util.List;

import org.sample.employee.directory.domain.Person;
import org.sample.employee.directory.service.EmployeeDirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/employeedirectories")
public class EmployeeDirectoryController {
	
	@Autowired
	EmployeeDirectoryService employeeDirectoryService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Person> list() {
		return employeeDirectoryService.list();
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Person show(@PathVariable Long id) {
		return employeeDirectoryService.getPerson(id);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.PUT)
	public Person update(@PathVariable Long id, @RequestParam String firstName, @RequestParam String lastName) {
		return employeeDirectoryService.updatePerson(id, firstName, lastName);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Person save(@RequestParam String firstName, @RequestParam String lastName) {
		return employeeDirectoryService.addPerson(firstName, lastName);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		employeeDirectoryService.deletePerson(id);
	}

}
