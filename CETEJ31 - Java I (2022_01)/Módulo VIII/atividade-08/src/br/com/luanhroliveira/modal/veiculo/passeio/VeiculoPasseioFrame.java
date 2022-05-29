package br.com.luanhroliveira.modal.veiculo.passeio;

import br.com.luanhroliveira.modal.veiculo.VeiculoFrame;

import javax.swing.*;

public class VeiculoPasseioFrame extends VeiculoFrame {

    private final JFrame jFrame = super.getVeiculoFrame();

    private final JLabel lbQtPassageiros = new JLabel();

    private final JTextField tfQtPassageiros = new JTextField();

    public JFrame getJFrame() {
        this.jFrame.add(lbQtPassageiros());
        this.jFrame.add(tfQtPassageiros());

        return this.jFrame;
    }

    public JTextField getTfQtPassageiros() {
        return this.tfQtPassageiros;
    }

    private JLabel lbQtPassageiros() {
        this.lbQtPassageiros.setText("Quantidade de Passageiros: ");
        this.lbQtPassageiros.setBounds(30, 270, 150, 15);
        this.lbQtPassageiros.setHorizontalAlignment(SwingConstants.RIGHT);
        return this.lbQtPassageiros;
    }

    private JTextField tfQtPassageiros() {
        this.tfQtPassageiros.setBounds(183, 270, 300, 20);
        this.tfQtPassageiros.setColumns(10);
        return this.tfQtPassageiros;
    }

    @Override
    public void enableBotoes(boolean enable) {
        super.enableBotoes(enable);
        this.tfQtPassageiros.setEnabled(enable);
    }

    @Override
    public void limparCampos() {
        super.limparCampos();
        this.tfQtPassageiros.setText(null);
    }

}
