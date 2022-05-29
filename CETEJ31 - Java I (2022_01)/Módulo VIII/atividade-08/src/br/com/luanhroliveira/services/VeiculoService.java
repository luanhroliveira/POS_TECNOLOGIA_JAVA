package br.com.luanhroliveira.services;

import br.com.luanhroliveira.entity.Carga;
import br.com.luanhroliveira.entity.Passeio;
import br.com.luanhroliveira.entity.dto.CargaDTO;
import br.com.luanhroliveira.entity.dto.PasseioDTO;
import br.com.luanhroliveira.exceptions.VeicExistException;
import br.com.luanhroliveira.exceptions.VeiculoNotFoundException;
import br.com.luanhroliveira.exceptions.VelocException;
import br.com.luanhroliveira.repositories.BDVeiculos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeiculoService {

    private final BDVeiculos bdVeiculos = new BDVeiculos();

    public Passeio from(PasseioDTO passeioDTO) {
        Passeio passeio = new Passeio();
        passeio.setPlaca(passeioDTO.getPlaca());
        passeio.setMarca(passeioDTO.getMarca());
        passeio.setModelo(passeioDTO.getModelo());
        passeio.setCor(passeioDTO.getCor());

        try {
            passeio.setVelocMax(passeioDTO.getVelocMax());
        } catch (VelocException e) {
            System.out.println(e.getMessage());
            passeio.setVelocMax(100);
        }

        passeio.setQtdRodas(passeioDTO.getQtdRodas());
        passeio.setMotor(passeioDTO.getQtdPist(), passeioDTO.getPotencia());
        passeio.setQtdPassageiros(passeio.getQtdPassageiros());

        return passeio;
    }

    public Carga from(CargaDTO cargaDTO) {
        Carga carga = new Carga();

        carga.setPlaca(cargaDTO.getPlaca());
        carga.setMarca(cargaDTO.getMarca());
        carga.setModelo(cargaDTO.getModelo());
        carga.setCor(cargaDTO.getCor());

        try {
            carga.setVelocMax(cargaDTO.getVelocMax());
        } catch (VelocException e) {
            System.out.println(e.getMessage());
            carga.setVelocMax(100);
        }

        carga.setQtdRodas(cargaDTO.getQtdRodas());
        carga.setMotor(cargaDTO.getQtdPist(), cargaDTO.getPotencia());
        carga.setCargaMax(cargaDTO.getCargaMax());
        carga.setTara(cargaDTO.getTara());

        return carga;
    }

    public boolean adicionarNovoVeiculoDePasseioALista(PasseioDTO passeioDTO) {
        this.bdVeiculos.addVeicPasseio(this.from(passeioDTO));
        return true;
    }

    public boolean adicionarNovoVeiculoDeCargaALista(CargaDTO cargaDTO) {
        this.bdVeiculos.addVeicCarga(this.from(cargaDTO));
        return true;
    }

    public Object[][] listarTodosVeiculoDePasseio() {
        List<Object[]> objects = new ArrayList<>();

        for (Passeio p : this.bdVeiculos.getPasseios()) {
            Object[] obj = new Object[]{
                p.getPlaca(),
                p.getMarca(),
                p.getModelo(),
                p.getCor(),
                p.getVelocMax(),
                p.getQtdRodas(),
                p.getMotor().getQtdPist(),
                p.getMotor().getPotencia(),
                p.getQtdPassageiros()
            };

            objects.add(obj);
        }

        return objects.toArray(new Object[0][]);
    }

    public Object[][] listarTodosVeiculoDeCarga() {
        List<Object[]> objects = new ArrayList<>();

        for (Carga c : this.bdVeiculos.getCargas()) {
            Object[] obj = new Object[]{
                c.getPlaca(),
                c.getMarca(),
                c.getModelo(),
                c.getCor(),
                c.getVelocMax(),
                c.getQtdRodas(),
                c.getMotor().getQtdPist(),
                c.getMotor().getPotencia(),
                c.getCargaMax(),
                c.getTara()
            };

            objects.add(obj);
        }

        return objects.toArray(new Object[0][]);
    }

    public Optional<PasseioDTO> listarVeiculoDePasseioPorPlaca(String placa) {
        return this.bdVeiculos.getPasseios()
            .stream()
            .filter(passeio -> passeio.getPlaca().equals(placa))
            .findFirst()
            .map(PasseioDTO::new);
    }

    public Optional<CargaDTO> listarVeiculoDeCargaPorPlaca(String placa) {
        return this.bdVeiculos.getCargas()
            .stream()
            .filter(passeio -> passeio.getPlaca().equals(placa))
            .findFirst()
            .map(CargaDTO::new);
    }

    public void deleteVeiculoDePasseioPorPlaca(String placa) throws VeiculoNotFoundException {
        Optional<Passeio> veicPasseio = Optional.ofNullable(this.bdVeiculos.getPasseios().stream()
            .filter(passeio -> passeio.getPlaca().equals(placa)).findFirst().orElseThrow(VeiculoNotFoundException::new));

        veicPasseio.ifPresent(passeio -> this.bdVeiculos.getPasseios().remove(passeio));
    }

    public void deleteVeiculoDeCargaPorPlaca(String placa) throws VeiculoNotFoundException {
        Optional<Carga> veicCarga = Optional.ofNullable(this.bdVeiculos.getCargas().stream()
            .filter(carga -> carga.getPlaca().equals(placa)).findFirst().orElseThrow(VeiculoNotFoundException::new));

        veicCarga.ifPresent(carga -> this.bdVeiculos.getCargas().remove(carga));
    }

    public boolean validarPlaca(String placa) throws VeicExistException {
        boolean veiculoExistenteEmPasseio = bdVeiculos.getPasseios().stream().anyMatch(veiculo -> veiculo.getPlaca().equals(placa));
        boolean veiculoExistenteEmCarga = bdVeiculos.getCargas().stream().anyMatch(veiculo -> veiculo.getPlaca().equals(placa));
        if (veiculoExistenteEmPasseio || veiculoExistenteEmCarga) {
            throw new VeicExistException();
        }
        return true;
    }

    public void deletarTodosVeiculoPasseio() {
        this.bdVeiculos.getPasseios().clear();
    }

    public void deletarTodosVeiculoCarga() {
        this.bdVeiculos.getCargas().clear();
    }
}

