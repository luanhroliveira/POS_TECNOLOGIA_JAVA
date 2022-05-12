package br.com.luanhroliveira.repositories;

import br.com.luanhroliveira.entity.Carga;
import br.com.luanhroliveira.entity.Passeio;

import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {

    private List<Passeio> passeios = new ArrayList<>();
    private List<Carga> cargas = new ArrayList<>();

    public List<Passeio> getPasseios() {
        return passeios;
    }

    public void addVeicPasseio(Passeio passeio) {
        getPasseios().add(passeio);
    }

    public List<Carga> getCargas() {
        return cargas;
    }

    public void addVeicCarga(Carga carga) {
        getCargas().add(carga);
    }

    public void setPasseios(List<Passeio> passeios) {
        this.passeios = passeios;
    }

    public void setCargas(List<Carga> cargas) {
        this.cargas = cargas;
    }
}
