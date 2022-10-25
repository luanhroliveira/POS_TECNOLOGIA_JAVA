package br.com.luanhroliveira.repositories;

import br.com.luanhroliveira.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Query(
        value = "select f.nome " +
            "from Funcionario f " +
            "order by f.nome asc"
    )
    List<String> findAllNomeOrderByAsc();
}
