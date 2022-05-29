package br.com.luanhroliveira.modal.veiculo.passeio;

import br.com.luanhroliveira.entity.dto.PasseioDTO;
import br.com.luanhroliveira.exceptions.VeiculoNotFoundException;
import br.com.luanhroliveira.interfaces.ConsultarExcluirPorPlacaInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarExcluirPorPlacaPasseioPanel extends VeiculoPasseioFrame implements ConsultarExcluirPorPlacaInterface, ActionListener {

    private final JFrame jFrame = super.getJFrame();

    private final JButton btConsultar = new JButton();
    private final JButton btExcluir = new JButton();
    private final JButton btSair = new JButton();

    public void loadConsultarExcluirPlacaPasseioPanel() {
        this.jFrame.add(btConsultar());
        this.jFrame.add(btExcluir());
        this.jFrame.add(btSair());

        super.getBtValidarPlaca().setVisible(false);

        super.enableBotoes(false);

        this.jFrame.setVisible(true);
    }

    public JButton getBtConsultar() {
        return btConsultar;
    }

    public JButton getBtExcluir() {
        return btExcluir;
    }

    public JButton getBtSair() {
        return btSair;
    }

    private void getVeiculoPorPlaca() {
        try {
            PasseioDTO passeioDTO = super.getVeiculoService()
                .listarVeiculoDePasseioPorPlaca(super.getTfPlaca().getText()).orElseThrow(VeiculoNotFoundException::new);

            super.getTfPlaca().setText(passeioDTO.getPlaca());
            super.getTfMarca().setText(passeioDTO.getMarca());
            super.getTfModelo().setText(passeioDTO.getModelo());
            super.getTfCor().setText(passeioDTO.getCor());
            super.getTfVelocMax().setText(String.valueOf(passeioDTO.getVelocMax()));
            super.getTfQtRodas().setText(String.valueOf(passeioDTO.getQtdRodas()));
            super.getTfQtPist().setText(String.valueOf(passeioDTO.getQtdPist()));
            super.getTfPotencia().setText(String.valueOf(passeioDTO.getQtdRodas()));
            super.getTfQtPassageiros().setText(String.valueOf(passeioDTO.getQtdPassageiros()));
        } catch (VeiculoNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Veículo não encontrado!", JOptionPane.INFORMATION_MESSAGE);
            super.limparCampos();
        }
    }

    private void excluir() {
        try {
            super.getVeiculoService().deleteVeiculoDePasseioPorPlaca(super.getTfPlaca().getText());
            JOptionPane.showMessageDialog(null, "Veículo de Passeio removido com sucesso!", "Veículo removido!", JOptionPane.INFORMATION_MESSAGE);
        } catch (VeiculoNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Veículo não encontrado!", JOptionPane.INFORMATION_MESSAGE);
        }
        super.limparCampos();
    }

    @Override
    public JButton btConsultar() {
        this.btConsultar.setText("Consultar");
        this.btConsultar.setMnemonic('C');
        this.btConsultar.setBounds(183, 300, 148, 30);
        this.btConsultar.addActionListener(this);

        return this.btConsultar;
    }

    @Override
    public JButton btExcluir() {
        this.btExcluir.setText("Excluir");
        this.btExcluir.setMnemonic('E');
        this.btExcluir.setBounds(334, 300, 148, 30);
        this.btExcluir.addActionListener(this);
        return this.btExcluir;
    }

    @Override
    public JButton btSair() {
        this.btSair.setText("Sair");
        this.btSair.setMnemonic('S');
        this.btSair.setBounds(183, 333, 300, 30);
        this.btSair.addActionListener(this);
        return this.btSair;
    }

    @Override
    public void actionPerformed(ActionEvent act) {
        if (act.getSource().equals(this.getBtConsultar())) {
            this.getVeiculoPorPlaca();
        } else if (act.getSource().equals(this.getBtExcluir())) {
            this.excluir();
        } else if (act.getSource().equals(this.getBtSair())) {
            super.limparCampos();
            this.jFrame.setVisible(false);
        }
    }

}
