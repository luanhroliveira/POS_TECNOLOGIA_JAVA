package br.com.luanhroliveira.modal.veiculo.carga;

import br.com.luanhroliveira.modal.veiculo.VeiculoFrame;

import javax.swing.*;

public abstract class VeiculoCargaFrame extends VeiculoFrame {

    private final JFrame jFrame = super.getVeiculoFrame();

    private final JLabel lbCargaMax = new JLabel();
    private final JLabel lbTara = new JLabel();

    private final JTextField tfCargaMax = new JTextField();
    private final JTextField tfTara = new JTextField();

    public JFrame getVeiculoCargaFrame() {
        this.jFrame.add(lbCargaMax());
        this.jFrame.add(lbTara());
        this.jFrame.add(tfCargaMax());
        this.jFrame.add(tfTara());

        this.jFrame.setVisible(true);
        return this.jFrame;
    }

    public JTextField getTfCargaMax() {
        return this.tfCargaMax;
    }

    public JTextField getTfTara() {
        return this.tfTara;
    }

    private JLabel lbCargaMax() {
        this.lbCargaMax.setText("Carga Máxima: ");
        this.lbCargaMax.setBounds(30, 270, 150, 15);
        this.lbCargaMax.setHorizontalAlignment(SwingConstants.RIGHT);
        return this.lbCargaMax;
    }

    private JLabel lbTara() {
        this.lbTara.setText("Tara: ");
        this.lbTara.setBounds(30, 300, 150, 15);
        this.lbTara.setHorizontalAlignment(SwingConstants.RIGHT);
        return this.lbTara;
    }

    private JTextField tfCargaMax() {
        this.tfCargaMax.setBounds(183, 270, 300, 20);
        this.tfCargaMax.setColumns(10);
        return this.tfCargaMax;
    }

    private JTextField tfTara() {
        this.tfTara.setBounds(183, 300, 300, 20);
        this.tfTara.setColumns(10);
        return this.tfTara;
    }

    @Override
    public void limparCampos() {
        super.limparCampos();
        this.getTfCargaMax().setText(null);
        this.getTfTara().setText(null);
    }

    @Override
    public void enableBotoes(boolean enable) {
        super.enableBotoes(enable);
        this.getTfCargaMax().setEnabled(enable);
        this.getTfTara().setEnabled(enable);
    }
}
