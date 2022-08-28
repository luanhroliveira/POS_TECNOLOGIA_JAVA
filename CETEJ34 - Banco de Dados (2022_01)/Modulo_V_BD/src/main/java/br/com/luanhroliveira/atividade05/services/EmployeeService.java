package br.com.luanhroliveira.atividade05.services;

import br.com.luanhroliveira.atividade05.entities.Department;
import br.com.luanhroliveira.atividade05.entities.Employee;
import br.com.luanhroliveira.atividade05.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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

    @Transactional(readOnly = true)
    public Employee findByNameAndNumberDependent(final String name, final Integer numberDependent) {
        return this.employeeRepository.findByNameAndNumberDependent(name, numberDependent);
    }

    @Transactional(readOnly = true)
    public List<Employee> findEmployeeByDepartmentName(final String departmentName) {
        return this.employeeRepository.findEmployeeByDepartmentName(departmentName);
    }

    @Transactional(readOnly = true)
    public Employee findFirstByOrderByIdAsc() {
        return this.employeeRepository.findFirstByOrderByIdAsc();
    }

    @Transactional(readOnly = true)
    public Employee findTopByOrderByWageAsc() {
        return this.employeeRepository.findTopByOrderByWageAsc();
    }

    @Transactional(readOnly = true)
    public List<Employee> findFirst3ByOrderByWageDesc() {
        return this.employeeRepository.findFirst3ByOrderByWageDesc();
    }

    @Transactional(readOnly = true)
    public List<Employee> findAllByNumberDependentEqualsToZero() {
        return this.employeeRepository.findAllByNumberDependentEqualsToZero();
    }

    @Transactional(readOnly = true)
    public List<Employee> findAllByWageGreaterThan(final BigDecimal wage) {
        return this.employeeRepository.findAllByWageGreaterThan(wage);
    }

    @Transactional(readOnly = true)
    public List<Employee> findAllByWageGreater(final BigDecimal wage) {
        return this.employeeRepository.findAllByWageGreater(wage);
    }

    @Transactional(readOnly = true)
    public List<Employee> findAllByNumberDependentEquals(final Integer numberDependent) {
        return this.employeeRepository.findAllByNumberDependentEquals(numberDependent);
    }

    @Transactional(readOnly = true)
    public List<Employee> findAllByNameContaining(final String name) {
        return this.employeeRepository.findAllByNameContaining(name);
    }

    @Transactional
    public void deleteAllByDepartmentId(final Long departmentId) {
        this.employeeRepository.deleteAllByDepartment(departmentId);
    }

    @Transactional
    public void updateAllDepartmentFromTo(final Long fromDepartment, final Long toDepartment) {
        this.employeeRepository.updateEveryoneDepartmentFromTo(fromDepartment, toDepartment);
    }

    @Transactional(readOnly = true)
    public List<Employee> findAllByDepartmentId(final Long departmentId) {
        return this.employeeRepository.findAllByDepartmentId(departmentId);
    }

    @Transactional
    public void updateAllWageByPercentage(final Integer percentage) {
        this.employeeRepository.updateAllWageByPercentage(percentage);
    }
}
