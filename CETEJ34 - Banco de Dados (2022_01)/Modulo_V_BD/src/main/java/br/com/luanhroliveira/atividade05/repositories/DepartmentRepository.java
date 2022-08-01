package br.com.luanhroliveira.atividade05.repositories;

import br.com.luanhroliveira.atividade05.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByName(String departmentName);
}
