package br.com.luanhroliveira.modal.veiculo;

import javax.swing.*;
import java.awt.*;

public abstract class MenuVeiculoPanel {

    private final JFrame jFrame = new JFrame();

    private final JButton btCadastrarVeiculo = new JButton();
    private final JButton btConsultarOuExcluirPorPlaca = new JButton();
    private final JButton btImprimirOuExcluirTodos = new JButton();
    private final JButton btSair = new JButton();

    private JFrame getjFrame() {
        return jFrame;
    }

    public JFrame getMenuVeiculoFrame() {
        this.getjFrame().setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.getjFrame().setLayout(new GridLayout(4, 1, 1, 1));
        this.getjFrame().setBounds(550, 250, 730, 490);
        this.getjFrame().getContentPane().setBackground(Color.WHITE);

        this.getjFrame().add(this.btCadVeiculoPasseio());
        this.getjFrame().add(this.btConsultarOuExcluirPorPlaca());
        this.getjFrame().add(this.btImprimirOuExcluirTodos());
        this.getjFrame().add(this.btSair());

        return this.getjFrame();
    }

    public JButton getBtCadastrarVeiculo() {
        return btCadastrarVeiculo;
    }

    public JButton getBtConsultarOuExcluirPorPlaca() {
        return btConsultarOuExcluirPorPlaca;
    }

    public JButton getBtImprimirOuExcluirTodos() {
        return btImprimirOuExcluirTodos;
    }

    public JButton getBtSair() {
        return btSair;
    }

    private JButton btCadVeiculoPasseio() {
        this.getBtCadastrarVeiculo().setText("Cadastrar");
        this.getBtCadastrarVeiculo().setMnemonic('C');

        return this.getBtCadastrarVeiculo();
    }

    private JButton btConsultarOuExcluirPorPlaca() {
        this.getBtConsultarOuExcluirPorPlaca().setText("Consultar / Excluir pela placa");
        this.getBtConsultarOuExcluirPorPlaca().setMnemonic('C');
        return this.getBtConsultarOuExcluirPorPlaca();
    }

    private JButton btImprimirOuExcluirTodos() {
        this.getBtImprimirOuExcluirTodos().setText("Imprimir / Excluir todos");
        this.getBtImprimirOuExcluirTodos().setMnemonic('I');
        return this.getBtImprimirOuExcluirTodos();
    }

    private JButton btSair() {
        this.getBtSair().setText("Sair");
        this.getBtSair().setMnemonic('S');
        return this.getBtSair();
    }
}
