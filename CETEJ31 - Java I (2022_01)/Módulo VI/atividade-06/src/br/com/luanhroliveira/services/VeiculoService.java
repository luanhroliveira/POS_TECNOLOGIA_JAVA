package br.com.luanhroliveira.services;

import br.com.luanhroliveira.entity.Carga;
import br.com.luanhroliveira.entity.Passeio;
import br.com.luanhroliveira.exceptions.VeicExistException;
import br.com.luanhroliveira.exceptions.VelocException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VeiculoService {

    public String adicionarNovoVeiculoDePasseioALista(List<Passeio> veiculoList) throws VeicExistException{
        boolean exit = false;
        while (!exit) {
            try {
                if (veiculoList.size() >= 5) {
                    return "Limite máximo de 5 carros atingido! ";
                }

                Passeio passeio = new Passeio();

                String placa = Leitura.entDados("Digite a placa:");

                boolean veiculoExistente = veiculoList.stream().anyMatch(veiculo -> veiculo.getPlaca().equals(placa));
                if (veiculoExistente) {
                    throw new VeicExistException("Já existe um veículo com esta placa");
                }

                passeio.setPlaca(placa);
                passeio.setMarca(Leitura.entDados("Digite a marca: "));
                passeio.setModelo(Leitura.entDados("Digite o modelo: "));
                passeio.setCor(Leitura.entDados("Digite a cor: "));

                try {
                passeio.setVelocMax(Float.parseFloat(Leitura.entDados("Digite velocidade máxima: ")));
                }catch (VelocException e){
                    System.out.println(e.getMessage());
                    passeio.setVelocMax(100);
                }

                passeio.setQtdRodas(Integer.parseInt(Leitura.entDados("Digite a quantidade de rodas: ")));
                int qtdPist = Integer.parseInt(Leitura.entDados("Digite a quantidade de pistões do Motor: "));
                int potencia = Integer.parseInt(Leitura.entDados("Digite a potência do Motor: "));
                passeio.setMotor(qtdPist, potencia);
                passeio.setQtdPassageiros(Integer.parseInt(Leitura.entDados("Digite a quantidade de passageiros do veículo: ")));

                veiculoList.add(passeio);

                exit = Leitura.entDados("Veículo adicionado com sucesso! Deseja cadastrar um novo veículo?(S/N): ").equalsIgnoreCase("N");
            } catch (VeicExistException e) {
                return e.getMessage();
            }
        }
        return "Veículo de passeio cadastrado com sucesso! ";
    }

    public String adicionarNovoVeiculoDeCargaALista(List<Carga> veiculoList) throws VeicExistException{
        boolean exit = false;
        while (!exit) {
            try {
                if (veiculoList.size() >= 5) {
                    return "Limite máximo de 5 carros atingido! ";
                }

                Carga carga = new Carga();

                String placa = Leitura.entDados("Digite a placa: ");

                boolean veiculoExistente = veiculoList.stream().anyMatch(veiculo -> veiculo.getPlaca().equals(placa));
                if (veiculoExistente) {
                    throw new VeicExistException("Já existe um veículo com esta placa");
                }

                carga.setPlaca(placa);
                carga.setMarca(Leitura.entDados("Digite a marca: "));
                carga.setModelo(Leitura.entDados("Digite o modelo: "));
                carga.setCor(Leitura.entDados("Digite a cor: "));

                try {
                carga.setVelocMax(Float.parseFloat(Leitura.entDados("Digite velocidade máxima: ")));
                }catch (VelocException e){
                    System.out.println(e.getMessage());
                    carga.setVelocMax(90);
                }

                carga.setQtdRodas(Integer.parseInt(Leitura.entDados("Digite a quantidade de rodas: ")));
                int qtdPist = Integer.parseInt(Leitura.entDados("Digite a quantidade de pistões do Motor:"));
                int potencia = Integer.parseInt(Leitura.entDados("Digite a potência do Motor: "));
                carga.setMotor(qtdPist, potencia);
                carga.setCargaMax(Integer.parseInt(Leitura.entDados("Digite a carga máxima:")));
                carga.setTara(Integer.parseInt(Leitura.entDados("Digite a tara:")));

                veiculoList.add(carga);

                exit = Leitura.entDados("Veículo adicionado com sucesso! Deseja cadastrar um novo veículo?(S/N): ").equalsIgnoreCase("N");
            } catch (VeicExistException e) {
                return e.getMessage();
            }
        }
        return "Veículo(s) de carga cadastrado(s) com sucesso! ";
    }

    public Object listarVeiculosDePasseio(List<Passeio> veiculoList) {
        if (veiculoList.isEmpty()) {
            return "Não existem veículos cadastrados.";
        }

        return veiculoList.stream()
            .map(Passeio::toString)
            .collect(Collectors.toList());
    }

    public Object listarVeiculosDeCarga(List<Carga> veiculoList) {
        if (veiculoList.isEmpty()) {
            return "Não existem veículos cadastrados.";
        }

        return veiculoList.stream()
            .map(Carga::toString)
            .collect(Collectors.toList());
    }

    public Object listarVeiculoDePasseioPorPlaca(List<Passeio> passeios) {
        String placa = Leitura.entDados("Digite a placa do veículo: ");

        Optional<Passeio> carPAsseio = passeios.stream()
            .filter(passeio -> passeio.getPlaca().equals(placa))
            .findFirst();

        if (carPAsseio.isEmpty()) {
            return "Não foi encontrado nenhum veículo com essa placa. Por favor, tente novamente.";
        }

        return carPAsseio.map(Passeio::toString);
    }

    public Object listarVeiculoDeCargaPorPlaca(List<Carga> cargas) {
        String placa = Leitura.entDados("Digite a placa do veículo: ");

        Optional<Carga> veiCarga = cargas.stream()
            .filter(carga -> carga.getPlaca().equals(placa))
            .findFirst();

        if (veiCarga.isEmpty()) {
            return "Não foi encontrado nenhum veículo com essa placa. Por favor, tente novamente.";
        }

        return veiCarga.map(Carga::toString);
    }
}
