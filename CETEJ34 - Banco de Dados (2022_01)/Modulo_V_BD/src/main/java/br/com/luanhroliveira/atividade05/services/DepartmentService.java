package br.com.luanhroliveira.atividade05.services;

import br.com.luanhroliveira.atividade05.entities.Department;
import br.com.luanhroliveira.atividade05.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department) {
        return this.departmentRepository.save(department);
    }

    public void delete(Department department) {
        this.departmentRepository.delete(department);
    }

    public Optional<Department> findById(Long departmentId) {
        return this.departmentRepository.findById(departmentId);
    }

    public List<Department> findAllByNameContaining(String departmentName) {
        Department department = new Department();
        department.setName(departmentName);

        ExampleMatcher matcher = ExampleMatcher
            .matching()
            .withIgnoreCase()
            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Department> example = Example.of(department, matcher);
        return this.departmentRepository.findAll(example);
    }

    public Department findByName(String departmentName) {
        return this.departmentRepository.findByName(departmentName);
    }

}
