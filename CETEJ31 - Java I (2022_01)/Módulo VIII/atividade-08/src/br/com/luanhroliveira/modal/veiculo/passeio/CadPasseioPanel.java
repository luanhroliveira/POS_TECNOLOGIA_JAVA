package br.com.luanhroliveira.modal.veiculo.passeio;

import br.com.luanhroliveira.entity.dto.PasseioDTO;
import br.com.luanhroliveira.interfaces.CadVeiculoInterface;
import br.com.luanhroliveira.modal.veiculo.VeiculoFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadPasseioPanel extends VeiculoFrame implements ActionListener, CadVeiculoInterface {

    private final JFrame jFrame = super.getVeiculoFrame();

    private final JLabel lbQtPassageiros = new JLabel();

    private final JTextField tfQtPassageiros = new JTextField();

    private final JButton btSalvar = new JButton();
    private final JButton btLimpar = new JButton();
    private final JButton btSair = new JButton();

    private JFrame getjFrame() {
        return jFrame;
    }

    private JButton getBtSalvar() {
        return btSalvar;
    }

    private JButton getBtLimpar() {
        return btLimpar;
    }

    private JButton getBtSair() {
        return btSair;
    }

    private JLabel getLbQtPassageiros() {
        return lbQtPassageiros;
    }

    private JTextField getTfQtPassageiros() {
        return tfQtPassageiros;
    }

    public void loadPasseioPanel() {
        this.getjFrame().setTitle("Cadastrar Veículo de Passeio");
        this.getjFrame().add(this.lbQtPassageiros());
        this.getjFrame().add(this.tfQtPassageiros());
        this.getjFrame().add(this.btSair());
        this.getjFrame().add(this.btLimpar());
        this.getjFrame().add(this.btSalvar());

        super.getBtValidarPlaca().addActionListener(this);

        this.enableBotoes(false);

        this.getjFrame().setVisible(true);
    }

    private JLabel lbQtPassageiros() {
        this.getLbQtPassageiros().setText("Quantidade de Passageiros: ");
        this.getLbQtPassageiros().setBounds(30, 270, 150, 15);
        this.getLbQtPassageiros().setHorizontalAlignment(SwingConstants.RIGHT);
        return this.getLbQtPassageiros();
    }

    private JTextField tfQtPassageiros() {
        this.getTfQtPassageiros().setBounds(183, 270, 300, 20);
        this.getTfQtPassageiros().setColumns(10);
        return this.getTfQtPassageiros();
    }

    private PasseioDTO getVeicPasseio() {
        return new PasseioDTO(
            super.getTfPlaca().getText(),
            super.getTfMarca().getText(),
            super.getTfModelo().getText(),
            super.getTfCor().getText(),
            Float.parseFloat(super.getTfVelocMax().getText()),
            Integer.parseInt(super.getTfQtRodas().getText()),
            Integer.parseInt(super.getTfQtPist().getText()),
            Integer.parseInt(super.getTfPotencia().getText()),
            Integer.parseInt(this.tfQtPassageiros().getText())
        );
    }

    private void salvar() {
        try {
            int yesOrNot = 0;
            boolean sucesso = super.getVeiculoService().adicionarNovoVeiculoDePasseioALista(this.getVeicPasseio());
            if (sucesso) {
                yesOrNot = JOptionPane.showConfirmDialog(null, "Veiculo de Passeio inserido com sucesso! \n " +
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

    private void sair() {
        this.limparCampos();
        this.getjFrame().dispose();
    }

    @Override
    public JButton btLimpar() {
        this.getBtLimpar().setText("Limpar");
        this.getBtLimpar().setBounds(183, 300, 148, 30);
        this.getBtLimpar().addActionListener(this);
        this.getBtLimpar().setMnemonic('L');
        return this.getBtLimpar();
    }

    @Override
    public JButton btSair() {
        this.getBtSair().setText("Sair");
        this.getBtSair().setBounds(334, 300, 148, 30);
        this.getBtSair().addActionListener(this);
        this.getBtSair().setMnemonic('S');
        return this.getBtSair();
    }

    @Override
    public JButton btSalvar() {
        this.getBtSalvar().setText("Salvar");
        this.getBtSalvar().setBounds(183, 333, 300, 30);
        this.getBtSalvar().addActionListener(this);
        this.getBtSalvar().setMnemonic('S');

        return this.getBtSalvar();
    }

    @Override
    public void limparCampos() {
        this.enableBotoes(false);
        super.limparCampos();
        this.tfQtPassageiros().setText(null);
    }

    @Override
    public void enableBotoes(boolean enable) {
        super.enableBotoes(enable);
        this.tfQtPassageiros().setEnabled(enable);
        this.getBtSalvar().setEnabled(enable);
    }

    @Override
    public void actionPerformed(ActionEvent act) {
        if (act.getSource().equals(this.getBtLimpar())) {
            this.limparCampos();
        } else if (act.getSource().equals(this.getBtSair())) {
            this.sair();
        } else if (act.getSource().equals(this.getBtSalvar())) {
            this.salvar();
        } else if (act.getSource().equals(super.getBtValidarPlaca())) {
            this.enableBotoes(super.validarPlaca());
        }
    }

}
