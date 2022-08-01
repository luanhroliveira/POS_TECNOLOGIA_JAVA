package br.com.luanhroliveira.atividade05.services;

import br.com.luanhroliveira.atividade05.entities.Department;
import br.com.luanhroliveira.atividade05.entities.Employee;
import br.com.luanhroliveira.atividade05.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentService departmentService;

    public Employee save(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    public void delete(Employee employee) {
        this.employeeRepository.delete(employee);
    }

    public Optional<Employee> findById(Long employeeId) {
        return this.employeeRepository.findById(employeeId);
    }

    public List<Employee> findAllByNameEnding(String employeeName) {
        Employee employee = new Employee();
        employee.setName(employeeName);

        ExampleMatcher matcher = ExampleMatcher
            .matching()
            .withIgnoreCase()
            .withStringMatcher(ExampleMatcher.StringMatcher.ENDING);

        Example<Employee> example = Example.of(employee, matcher);
        return this.employeeRepository.findAll(example);
    }

    public List<Employee> findAllEmployeesByDepartmentContaining(String departmentName) {
        Department department = this.departmentService.findByName(departmentName);

        Employee employee = new Employee();
        employee.setDepartment(department);

        Example<Employee> example = Example.of(employee);

        return this.employeeRepository.findAll(example);
    }
}
