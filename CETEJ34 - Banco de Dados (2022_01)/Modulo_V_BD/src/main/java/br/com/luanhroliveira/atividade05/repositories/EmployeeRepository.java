package br.com.luanhroliveira.atividade05.repositories;

import br.com.luanhroliveira.atividade05.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
