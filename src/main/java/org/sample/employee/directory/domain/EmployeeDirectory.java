package org.sample.employee.directory.domain;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory {
	
	List<Person> directory;

	public EmployeeDirectory() {
		directory = new ArrayList<>();
	}
	
	public void add(Person p) {
		directory.add(p);
	}
	
	public void delete(Person p) {
		directory.remove(p);
	}
	
	public Person getPerson(Long id) {
		Person person = directory.stream()
				.filter(p -> p.getId().equals(id))
				.findFirst().get();
		return person;
	}
	
	public List<Person> getDirectory() {
		return directory;
	}

}
