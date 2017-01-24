package org.sample.employee.directory.service;

import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.sample.employee.directory.domain.EmployeeDirectory;
import org.sample.employee.directory.domain.Person;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDirectoryService {
	
	EmployeeDirectory directory;
	long range;
	Random random;
	
	@PostConstruct
	private void init() {
		directory = new EmployeeDirectory();
		range = 1234567L;
		random = new Random();
	}
	
	public List<Person> list() {
		return directory.getDirectory();
	}
	
	public Person getPerson(Long id) {
		return directory.getPerson(id);
	}
	
	public Person addPerson(String firstName, String lastName) {
		Person person = new Person();
		long id = (long)(random.nextDouble()*range);
		person.setId(new Long(id));
		person.setFirstName(firstName);
		person.setLastName(lastName);
		directory.add(person);
		return person;
	}
	
	public Person updatePerson(Long id, String firstName, String lastName) {
		Person person = directory.getPerson(id);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		return person;
	}
	
	public void deletePerson(Long id) {
		Person person = directory.getPerson(id);
		directory.delete(person);
	}
	
}
