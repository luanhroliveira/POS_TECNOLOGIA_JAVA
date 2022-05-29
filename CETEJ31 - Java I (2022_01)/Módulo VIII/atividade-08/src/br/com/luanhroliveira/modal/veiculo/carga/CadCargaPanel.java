package br.com.luanhroliveira.modal.veiculo.carga;

import br.com.luanhroliveira.entity.dto.CargaDTO;
import br.com.luanhroliveira.interfaces.CadVeiculoInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadCargaPanel extends VeiculoCargaFrame implements CadVeiculoInterface, ActionListener {

    private final JFrame jFrame = super.getVeiculoCargaFrame();

    private final JButton btSalvar = new JButton();
    private final JButton btLimpar = new JButton();
    private final JButton btSair = new JButton();

    private JFrame getJFrame() {
        return this.jFrame;
    }

    private JButton getBtSalvar() {
        return this.btSalvar;
    }

    private JButton getBtLimpar() {
        return this.btLimpar;
    }

    private JButton getBtSair() {
        return this.btSair;
    }

    public void loadCadCargaPanel() {
        this.getJFrame().setTitle("Cadastrar Veículo de Carga");

        this.getJFrame().add(this.btSalvar());
        this.getJFrame().add(this.btSair());
        this.getJFrame().add(this.btLimpar());

        super.getBtValidarPlaca().addActionListener(this);

        this.enableBotoes(false);

        this.getJFrame().setVisible(true);
    }

    private void salvar() {
        try {
            int yesOrNot = 0;
            boolean sucesso = super.getVeiculoService().adicionarNovoVeiculoDeCargaALista(this.getVeicCarga());
            if (sucesso) {
                yesOrNot = JOptionPane.showConfirmDialog(null, "Veiculo de Carga inserido com sucesso! \n " +
                    "Deseja cadastrar um novo veiculo?", "Cadastrado com sucesso!", JOptionPane.YES_NO_OPTION);
            }

            if (yesOrNot == 0) {
                this.limparCampos();
                this.enableBotoes(false);
            } else if (yesOrNot == 1) {
                this.sair();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, String.format("Falha ao tentar efetuar o cadastro, verifique se as informações inseridas estão corretas. " +
                    "\n Erro: %s", e.getMessage()),
                "Não foi possível efetuar o cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private CargaDTO getVeicCarga() {
        return new CargaDTO(
            super.getTfPlaca().getText(),
            super.getTfMarca().getText(),
            super.getTfModelo().getText(),
            super.getTfCor().getText(),
            Float.parseFloat(super.getTfVelocMax().getText()),
            Integer.parseInt(super.getTfQtRodas().getText()),
            Integer.parseInt(super.getTfQtPist().getText()),
            Integer.parseInt(super.getTfPotencia().getText()),
            Integer.parseInt(super.getTfCargaMax().getText()),
            Integer.parseInt(super.getTfTara().getText())
        );
    }

    private void sair() {
        this.limparCampos();
        this.getJFrame().dispose();
    }

    @Override
    public JButton btLimpar() {
        this.getBtLimpar().setText("Limpar");
        this.getBtLimpar().setBounds(183, 328, 148, 30);
        this.getBtLimpar().addActionListener(this);
        this.getBtLimpar().setMnemonic('L');
        return this.getBtLimpar();
    }

    @Override
    public JButton btSalvar() {
        this.getBtSalvar().setText("Salvar");
        this.getBtSalvar().setBounds(183, 360, 300, 30);
        this.getBtSalvar().addActionListener(this);
        this.getBtSalvar().setMnemonic('S');

        return this.getBtSalvar();
    }

    @Override
    public JButton btSair() {
        this.getBtSair().setText("Sair");
        this.getBtSair().setBounds(334, 328, 148, 30);
        this.getBtSair().addActionListener(this);
        this.getBtSair().setMnemonic('S');
        return this.getBtSair();
    }

    @Override
    public void limparCampos() {
        super.limparCampos();
        this.enableBotoes(false);
    }

    @Override
    public void enableBotoes(boolean enable) {
        super.enableBotoes(enable);
        this.getBtSalvar().setEnabled(enable);
    }

    @Override
    public void actionPerformed(ActionEvent act) {
        if (act.getSource().equals(super.getBtValidarPlaca())) {
            this.enableBotoes(super.validarPlaca());
        } else if (act.getSource().equals(this.getBtSalvar())) {
            this.salvar();
        } else if (act.getSource().equals(this.getBtLimpar())) {
            this.limparCampos();
        } else if (act.getSource().equals(this.getBtSair())) {
            this.sair();
        }
    }
}
