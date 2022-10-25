package br.com.luanhroliveira.services;

import br.com.luanhroliveira.entities.Cargo;
import br.com.luanhroliveira.entities.Funcionario;
import br.com.luanhroliveira.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CargoService cargoService;

    @Transactional
    public void saveFuncionarioWithCargo(
        final Funcionario funcionario,
        final Cargo cargo
    ) {
        funcionario.setCargo(cargo);
        this.cargoService.saveCargo(cargo);
        this.funcionarioRepository.save(funcionario);
    }

    @Transactional
    public void deleteById(
        final Long funcionarioId
    ) {
        this.funcionarioRepository.deleteById(funcionarioId);
    }

    @Transactional(readOnly = true)
    public List<Funcionario> findAll() {
        return this.funcionarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<String> findAllNomeOrderByAsc() {
        return this.funcionarioRepository.findAllNomeOrderByAsc();
    }

    @Transactional(readOnly = true)
    public Long countFuncionarios() {
        return this.funcionarioRepository.count();
    }
}
