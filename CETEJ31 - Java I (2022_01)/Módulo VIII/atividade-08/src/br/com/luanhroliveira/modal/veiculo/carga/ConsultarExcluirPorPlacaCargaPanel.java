package br.com.luanhroliveira.modal.veiculo.carga;

import br.com.luanhroliveira.entity.dto.CargaDTO;
import br.com.luanhroliveira.exceptions.VeiculoNotFoundException;
import br.com.luanhroliveira.interfaces.ConsultarExcluirPorPlacaInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarExcluirPorPlacaCargaPanel extends VeiculoCargaFrame implements ConsultarExcluirPorPlacaInterface, ActionListener {

    private final JFrame jFrame = super.getVeiculoCargaFrame();

    private final JButton btConsultar = new JButton();
    private final JButton btExcluir = new JButton();
    private final JButton btSair = new JButton();

    public void loadConsultarExcluirPorPlacaCargaPanel() {
        super.getBtValidarPlaca().setVisible(false);
        super.enableBotoes(false);

        this.jFrame.add(btConsultar());
        this.jFrame.add(btExcluir());
        this.jFrame.add(btSair());

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

    @Override
    public JButton btConsultar() {
        this.btConsultar.setText("Consultar");
        this.btConsultar.setMnemonic('C');
        this.btConsultar.setBounds(183, 328, 148, 30);
        this.btConsultar.addActionListener(this);
        return this.btConsultar;
    }

    @Override
    public JButton btExcluir() {
        this.btExcluir.setText("Excluir");
        this.btExcluir.setMnemonic('E');
        this.btExcluir.setBounds(334, 328, 148, 30);
        this.btExcluir.addActionListener(this);
        return this.btExcluir;
    }

    @Override
    public JButton btSair() {
        this.btSair.setText("Sair");
        this.btSair.setMnemonic('S');
        this.btSair.setBounds(183, 360, 300, 30);
        this.btSair.addActionListener(this);
        return this.btSair;
    }

    private void getVeiculoPorPlaca() {
        try {

            CargaDTO cargaDTO = super.getVeiculoService()
                .listarVeiculoDeCargaPorPlaca(super.getTfPlaca().getText()).orElseThrow(VeiculoNotFoundException::new);

            super.getTfPlaca().setText(cargaDTO.getPlaca());
            super.getTfMarca().setText(cargaDTO.getMarca());
            super.getTfModelo().setText(cargaDTO.getModelo());
            super.getTfCor().setText(cargaDTO.getCor());
            super.getTfVelocMax().setText(String.valueOf(cargaDTO.getVelocMax()));
            super.getTfQtRodas().setText(String.valueOf(cargaDTO.getQtdRodas()));
            super.getTfQtPist().setText(String.valueOf(cargaDTO.getQtdPist()));
            super.getTfPotencia().setText(String.valueOf(cargaDTO.getQtdRodas()));
            super.getTfCargaMax().setText(String.valueOf(cargaDTO.getCargaMax()));
            super.getTfTara().setText(String.valueOf(cargaDTO.getTara()));
        } catch (VeiculoNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Veículo não encontrado!", JOptionPane.INFORMATION_MESSAGE);
            super.limparCampos();
        }
    }

    private void excluir() {
        try {
            super.getVeiculoService().deleteVeiculoDeCargaPorPlaca(super.getTfPlaca().getText());
            JOptionPane.showMessageDialog(null, "Veículo de Carga removido com sucesso!", "Veículo removido!", JOptionPane.INFORMATION_MESSAGE);
        } catch (VeiculoNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Veículo não encontrado!", JOptionPane.INFORMATION_MESSAGE);
        }
        super.limparCampos();
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
