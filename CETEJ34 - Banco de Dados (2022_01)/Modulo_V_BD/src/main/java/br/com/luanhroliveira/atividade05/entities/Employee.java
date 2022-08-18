package br.com.luanhroliveira.atividade05.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
@NamedQuery(
    name = "Employee.byNumberDependent",
    query = "select e " +
        "from Employee e " +
        "where e.numberDependent = ?1")
@NamedNativeQuery(
    name = "Employee.byName",
    query = "select * " +
        "from employee e " +
        "where e.name like ?1",
    resultClass = Employee.class)
public class Employee extends AbstractPersistable<Long> implements Serializable {

    private String name;
    private Integer numberDependent;
    private BigDecimal wage;
    private String office;

    @OneToOne
    private Department department;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Employee employee = (Employee) o;
        return getId() != null && Objects.equals(getId(), employee.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
