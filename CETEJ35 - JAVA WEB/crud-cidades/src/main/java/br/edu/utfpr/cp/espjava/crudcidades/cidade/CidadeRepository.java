package br.edu.utfpr.cp.espjava.crudcidades.cidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CidadeRepository extends JpaRepository<CidadeEntity, Long> {
    Optional<CidadeEntity> findByNomeAndEstado(String nome, String estado);
}
