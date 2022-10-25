package br.com.luanhroliveira;

import br.com.luanhroliveira.entities.Cargo;
import br.com.luanhroliveira.entities.Funcionario;
import br.com.luanhroliveira.services.CargoService;
import br.com.luanhroliveira.services.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory
        .getLogger(MyRunner.class);

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private CargoService cargoService;

    @Override
    public void run(String... args) throws Exception {
        Cargo cargoOne = new Cargo("Cargo One");
        Cargo cargoTwo = new Cargo("Cargo Two");
        Cargo cargoThree = new Cargo("Cargo Three");

        Funcionario funcionarioOne = new Funcionario("Funcionario Name One", "Masculino", "44xxxxx99", null);
        Funcionario funcionarioTwo = new Funcionario("Funcionario Name Two", "Masculino", "44xxxxx99", null);
        Funcionario funcionarioThree = new Funcionario("Funcionario Name Three", "Masculino", "44xxxxx99", null);

        //Inserir pelo menos 3 Cargos;
        //Inserir pelo menos 3 Funcionários (associando aos seus respectivos cargos);
        this.funcionarioService.saveFuncionarioWithCargo(funcionarioOne, cargoOne);
        this.funcionarioService.saveFuncionarioWithCargo(funcionarioTwo, cargoTwo);
        this.funcionarioService.saveFuncionarioWithCargo(funcionarioThree, cargoThree);

        //Excluir pelo menos 1 Cargo pelo identificador (*1);
        this.cargoService.deleteCargoById(1L);

        //Excluir pelo menos 1 Funcionário pelo identificador
        this.funcionarioService.deleteById(1L);

        //Listar Funcionários com os seus respectivos Cargos;
        List<Funcionario> funcionarios = this.funcionarioService.findAll();

        //Listar Cargos com a respectiva lista de Funcionários;
        List<Cargo> cargos = this.cargoService.findAll();

        //Listar o Nome de Funcionários em Ordem Alfabética;
        List<String> nomesDeFuncionarios = this.funcionarioService.findAllNomeOrderByAsc();

        //Listar a Quantidade de Funcionários.
        Long quantidadeFuncionarios = this.funcionarioService.countFuncionarios();

    }
}
