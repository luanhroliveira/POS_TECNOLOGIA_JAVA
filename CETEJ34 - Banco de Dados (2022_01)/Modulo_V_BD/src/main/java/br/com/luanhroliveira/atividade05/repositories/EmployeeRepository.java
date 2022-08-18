package br.com.luanhroliveira.atividade05.repositories;

import br.com.luanhroliveira.atividade05.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByNameAndNumberDependent(String name, Integer numberDependent);

    @Query(
        value = "select e " +
            "from Employee e " +
            "where e.department.name = :departmentName ")
    List<Employee> findEmployeeByDepartmentName(@Param("departmentName") String departmentName);

    Employee findFirstByOrderByIdAsc();

    Employee findTopByOrderByWageAsc();

    List<Employee> findFirst3ByOrderByWageDesc();

    @Query(
        value = "select e " +
            "from Employee e " +
            "where e.numberDependent = 0 " +
            "order by e.name asc ")
    List<Employee> findAllByNumberDependentEqualsToZero();

    @Query(
        value = "select e " +
            "from Employee e " +
            "where e.wage > :wage ")
    List<Employee> findAllByWageGreaterThan(BigDecimal wage);

    @Query(
        value = "select * " +
            "from employee e " +
            "where e.wage > :wage ",
        nativeQuery = true)
    List<Employee> findAllByWageGreater(BigDecimal wage);

    @Query(name = "Employee.byNumberDependent")
    List<Employee> findAllByNumberDependentEquals(Integer numberDependent);

    @Query(name = "Employee.byName")
    List<Employee> findAllByNameContaining(String employeeName);
}
