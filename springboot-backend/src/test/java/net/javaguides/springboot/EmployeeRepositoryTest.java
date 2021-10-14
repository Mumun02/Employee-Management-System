package net.javaguides.springboot;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import com.mindtree.employeemanagerapp.model.Employee;
import com.mindtree.employeemanagerapp.repository.EmployeeRepository;
@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
public class EmployeeRepositoryTest {
	@Autowired
	private EmployeeRepository employeeRepository;

	
	@Test
	@Order(1)
	public void getEmployeeTest() {

		Employee employee = employeeRepository.findById(1L).get();

		Assertions.assertThat(employee.getId()).isEqualTo(1L);

	}

	@Test
	@Order(2)
	public void getListOfEmployeesTest() {

		List<Employee> employees = employeeRepository.findAll();

		Assertions.assertThat(employees.size()).isGreaterThan(0);

	}

	@Test
	@Order(3)

	public void updateEmployeeTest() {

		Employee employee = employeeRepository.findById(1L).get();

		employee.setEmailId("moon@gmail.com");

		Employee employeeUpdated = employeeRepository.save(employee);

		Assertions.assertThat(employeeUpdated.getEmailId()).isEqualTo("moon@gmail.com");

	}

	
}
