package br.com.luanhroliveira.services;

import br.com.luanhroliveira.entities.Cargo;
import br.com.luanhroliveira.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Transactional
    public void saveCargo(
        final Cargo cargo
    ) {
        this.cargoRepository.save(cargo);
    }

    @Transactional
    public void deleteCargoById(
        final Long cargoId
    ) {
        this.cargoRepository.deleteById(cargoId);
    }

    @Transactional
    public List<Cargo> findAll() {
        return this.cargoRepository.findAll();
    }
}
