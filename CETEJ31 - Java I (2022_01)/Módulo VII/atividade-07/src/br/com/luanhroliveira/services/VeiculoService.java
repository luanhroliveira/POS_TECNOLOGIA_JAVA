package br.com.luanhroliveira.services;

import br.com.luanhroliveira.entity.Carga;
import br.com.luanhroliveira.entity.Passeio;
import br.com.luanhroliveira.exceptions.VeicExistException;
import br.com.luanhroliveira.exceptions.VelocException;
import br.com.luanhroliveira.repositories.BDVeiculos;

import java.util.Optional;
import java.util.stream.Collectors;

public class VeiculoService {

    private BDVeiculos bdVeiculos = new BDVeiculos();

    public String adicionarNovoVeiculoDePasseioALista() throws VeicExistException {
        boolean exit = false;
        while (!exit) {
            try {
                Passeio passeio = new Passeio();

                String placa = Leitura.entDados("Digite a placa:");

                boolean veiculoExistente = bdVeiculos.getPasseios().stream().anyMatch(veiculo -> veiculo.getPlaca().equals(placa));
                if (veiculoExistente) {
                    throw new VeicExistException();
                }

                passeio.setPlaca(placa);
                passeio.setMarca(Leitura.entDados("Digite a marca: "));
                passeio.setModelo(Leitura.entDados("Digite o modelo: "));
                passeio.setCor(Leitura.entDados("Digite a cor: "));

                try {
                    passeio.setVelocMax(Float.parseFloat(Leitura.entDados("Digite velocidade máxima: ")));
                } catch (VelocException e) {
                    System.out.println(e.getMessage());
                    passeio.setVelocMax(100);
                }

                passeio.setQtdRodas(Integer.parseInt(Leitura.entDados("Digite a quantidade de rodas: ")));
                int qtdPist = Integer.parseInt(Leitura.entDados("Digite a quantidade de pistões do Motor: "));
                int potencia = Integer.parseInt(Leitura.entDados("Digite a potência do Motor: "));
                passeio.setMotor(qtdPist, potencia);
                passeio.setQtdPassageiros(Integer.parseInt(Leitura.entDados("Digite a quantidade de passageiros do veículo: ")));

                bdVeiculos.addVeicPasseio(passeio);

                exit = Leitura.entDados("Veículo adicionado com sucesso! Deseja cadastrar um novo veículo?(S/N): ").equalsIgnoreCase("N");
            } catch (VeicExistException e) {
                return e.getMessage();
            }
        }
        return "Veículo(s) de passeio cadastrado(s) com sucesso! ";
    }

    public String adicionarNovoVeiculoDeCargaALista() throws VeicExistException {
        boolean exit = false;
        while (!exit) {
            try {
                Carga carga = new Carga();

                String placa = Leitura.entDados("Digite a placa: ");

                boolean veiculoExistente = bdVeiculos.getCargas().stream().anyMatch(veiculo -> veiculo.getPlaca().equals(placa));
                if (veiculoExistente) {
                    throw new VeicExistException();
                }

                carga.setPlaca(placa);
                carga.setMarca(Leitura.entDados("Digite a marca: "));
                carga.setModelo(Leitura.entDados("Digite o modelo: "));
                carga.setCor(Leitura.entDados("Digite a cor: "));

                try {
                    carga.setVelocMax(Float.parseFloat(Leitura.entDados("Digite velocidade máxima: ")));
                } catch (VelocException e) {
                    System.out.println(e.getMessage());
                    carga.setVelocMax(90);
                }

                carga.setQtdRodas(Integer.parseInt(Leitura.entDados("Digite a quantidade de rodas: ")));
                int qtdPist = Integer.parseInt(Leitura.entDados("Digite a quantidade de pistões do Motor:"));
                int potencia = Integer.parseInt(Leitura.entDados("Digite a potência do Motor: "));
                carga.setMotor(qtdPist, potencia);
                carga.setCargaMax(Integer.parseInt(Leitura.entDados("Digite a carga máxima:")));
                carga.setTara(Integer.parseInt(Leitura.entDados("Digite a tara:")));

                bdVeiculos.addVeicCarga(carga);

                exit = Leitura.entDados("Veículo adicionado com sucesso! Deseja cadastrar um novo veículo?(S/N): ").equalsIgnoreCase("N");
            } catch (VeicExistException e) {
                return e.getMessage();
            }
        }
        return "Veículo(s) de carga cadastrado(s) com sucesso! ";
    }

    public Object listarVeiculosDePasseio() {
        if (bdVeiculos.getPasseios().isEmpty()) {
            return "Não existem veículos cadastrados.";
        }

        return bdVeiculos.getPasseios()
            .stream()
            .map(Passeio::toString)
            .collect(Collectors.toList());
    }

    public Object listarVeiculosDeCarga() {
        if (bdVeiculos.getCargas().isEmpty()) {
            return "Não existem veículos cadastrados.";
        }

        return bdVeiculos.getCargas()
            .stream()
            .map(Carga::toString)
            .collect(Collectors.toList());
    }

    public Object listarVeiculoDePasseioPorPlaca() {
        String placa = Leitura.entDados("Digite a placa do veículo: ");

        Optional<Passeio> carPasseio = bdVeiculos.getPasseios()
            .stream()
            .filter(passeio -> passeio.getPlaca().equals(placa))
            .findFirst();

        if (carPasseio.isEmpty()) {
            return "Não foi encontrado nenhum veículo com essa placa. Por favor, tente novamente.";
        }

        return carPasseio.map(Passeio::toString);
    }

    public Object listarVeiculoDeCargaPorPlaca() {
        String placa = Leitura.entDados("Digite a placa do veículo: ");

        Optional<Carga> veiCarga = bdVeiculos.getCargas()
            .stream()
            .filter(carga -> carga.getPlaca().equals(placa))
            .findFirst();

        if (veiCarga.isEmpty()) {
            return "Não foi encontrado nenhum veículo com essa placa. Por favor, tente novamente.";
        }

        return veiCarga.map(Carga::toString);
    }

    public String deleteVeiculoDePasseioPorPlaca() {
        String placa = Leitura.entDados("Digite a placa do veículo: ");

        Optional<Passeio> veicPasseio = bdVeiculos.getPasseios()
            .stream()
            .filter(passeio -> passeio.getPlaca().equals(placa))
            .findFirst();

        if (veicPasseio.isEmpty()) {
            return "Não foi encontrado nenhum veículo com essa placa. Por favor, tente novamente.";
        }

        try {
        veicPasseio.ifPresent(passeio -> bdVeiculos.getPasseios().remove(passeio));
        }catch (Exception e){
            return "Não foi possível remover este veículo, erro inesperado.";
        }

        return "Veículo removido com sucesso!";
    }

    public String deleteVeiculoDeCargaPorPlaca() {
        String placa = Leitura.entDados("Digite a placa do veículo: ");

        Optional<Carga> veicCarga = bdVeiculos.getCargas()
            .stream()
            .filter(passeio -> passeio.getPlaca().equals(placa))
            .findFirst();

        if (veicCarga.isEmpty()) {
            return "Não foi encontrado nenhum veículo com essa placa. Por favor, tente novamente.";
        }

        try {
            veicCarga.ifPresent(carga -> bdVeiculos.getCargas().remove(carga));
        }catch (Exception e){
            return "Não foi possível remover este veículo, erro inesperado.";
        }

        return "Veículo removido com sucesso!";
    }
}
