package br.com.luanhroliveira.modal.veiculo;

import br.com.luanhroliveira.exceptions.VeicExistException;
import br.com.luanhroliveira.services.VeiculoService;

import javax.swing.*;
import java.awt.*;

public abstract class VeiculoFrame {
    private final VeiculoService veiculoService = new VeiculoService();

    private final JFrame jFrame = new JFrame();

    private final JLabel lbPlaca = new JLabel();
    private final JLabel lbMarca = new JLabel();
    private final JLabel lbModelo = new JLabel();
    private final JLabel lbCor = new JLabel();
    private final JLabel lbVelocMax = new JLabel();
    private final JLabel lbQtRodas = new JLabel();
    private final JLabel lbQtPist = new JLabel();
    private final JLabel lbPotencia = new JLabel();

    private final JTextField tfPlaca = new JTextField();
    private final JTextField tfMarca = new JTextField();
    private final JTextField tfModelo = new JTextField();
    private final JTextField tfCor = new JTextField();
    private final JTextField tfVelocMax = new JTextField();
    private final JTextField tfQtRodas = new JTextField();
    private final JTextField tfQtPist = new JTextField();
    private final JTextField tfPotencia = new JTextField();

    private final JButton btValidarPlaca = new JButton();

    public JFrame getVeiculoFrame() {
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setBounds(550, 250, 730, 490);
        jFrame.getContentPane().setBackground(Color.WHITE);

        jFrame.add(lbPlaca());
        jFrame.add(lbMarca());
        jFrame.add(lbModelo());
        jFrame.add(lbCor());
        jFrame.add(lbVelocMax());
        jFrame.add(lbQtRodas());
        jFrame.add(lbQtPist());
        jFrame.add(lbPotencia());

        jFrame.add(tfPlaca());
        jFrame.add(tfMarca());
        jFrame.add(tfModelo());
        jFrame.add(tfCor());
        jFrame.add(tfVelocMax());
        jFrame.add(tfQtRodas());
        jFrame.add(tfQtPist());
        jFrame.add(tfPotencia());

        jFrame.add(btValidarPlaca());

        return jFrame;
    }

    public VeiculoService getVeiculoService() {
        return veiculoService;
    }

    public JTextField getTfPlaca() {
        return tfPlaca;
    }

    public JTextField getTfMarca() {
        return tfMarca;
    }

    public JTextField getTfModelo() {
        return tfModelo;
    }

    public JTextField getTfCor() {
        return tfCor;
    }

    public JTextField getTfVelocMax() {
        return tfVelocMax;
    }

    public JTextField getTfQtRodas() {
        return tfQtRodas;
    }

    public JTextField getTfQtPist() {
        return tfQtPist;
    }

    public JTextField getTfPotencia() {
        return tfPotencia;
    }

    public JButton getBtValidarPlaca() {
        return btValidarPlaca;
    }

    public JLabel lbPlaca() {
        lbPlaca.setText("Placa: ");
        lbPlaca.setBounds(30, 30, 150, 15);
        lbPlaca.setHorizontalAlignment(SwingConstants.RIGHT);
        return lbPlaca;
    }

    public JLabel lbMarca() {
        lbMarca.setText("Marca: ");
        lbMarca.setBounds(30, 60, 150, 15);
        lbMarca.setHorizontalAlignment(SwingConstants.RIGHT);
        return lbMarca;
    }

    public JLabel lbModelo() {
        lbModelo.setText("Modelo: ");
        lbModelo.setBounds(30, 90, 150, 15);
        lbModelo.setHorizontalAlignment(SwingConstants.RIGHT);
        return lbModelo;
    }

    public JLabel lbCor() {
        lbCor.setText("Cor: ");
        lbCor.setBounds(30, 120, 150, 15);
        lbCor.setHorizontalAlignment(SwingConstants.RIGHT);
        return lbCor;
    }

    public JLabel lbVelocMax() {
        lbVelocMax.setText("Velocidade máxima: ");
        lbVelocMax.setBounds(30, 150, 150, 15);
        lbVelocMax.setHorizontalAlignment(SwingConstants.RIGHT);
        return lbVelocMax;
    }

    public JLabel lbQtRodas() {
        lbQtRodas.setText("Quantidade de Rodas: ");
        lbQtRodas.setBounds(30, 180, 150, 15);
        lbQtRodas.setHorizontalAlignment(SwingConstants.RIGHT);
        return lbQtRodas;
    }

    public JLabel lbQtPist() {
        lbQtPist.setText("Quantidade de Pistões: ");
        lbQtPist.setBounds(30, 210, 150, 15);
        lbQtPist.setHorizontalAlignment(SwingConstants.RIGHT);
        return lbQtPist;
    }

    public JLabel lbPotencia() {
        lbPotencia.setText("Potência: ");
        lbPotencia.setBounds(30, 240, 150, 15);
        lbPotencia.setHorizontalAlignment(SwingConstants.RIGHT);
        return lbPotencia;
    }

    public JTextField tfPlaca() {
        tfPlaca.setBounds(183, 30, 300, 20);
        tfPlaca.setColumns(10);
        return tfPlaca;
    }

    public JTextField tfMarca() {
        tfMarca.setBounds(183, 60, 300, 20);
        tfMarca.setColumns(10);
        return tfMarca;
    }

    public JTextField tfModelo() {
        tfModelo.setBounds(183, 90, 300, 20);
        tfModelo.setColumns(10);
        return tfModelo;
    }

    public JTextField tfCor() {
        tfCor.setBounds(183, 120, 300, 20);
        tfCor.setColumns(10);
        return tfCor;
    }

    public JTextField tfVelocMax() {
        tfVelocMax.setBounds(183, 150, 300, 20);
        tfVelocMax.setColumns(10);
        return tfVelocMax;
    }

    public JTextField tfQtRodas() {
        tfQtRodas.setBounds(183, 180, 300, 20);
        tfQtRodas.setColumns(10);
        return tfQtRodas;
    }

    public JTextField tfQtPist() {
        tfQtPist.setBounds(183, 210, 300, 20);
        tfQtPist.setColumns(10);
        return tfQtPist;
    }

    public JTextField tfPotencia() {
        tfPotencia.setBounds(183, 240, 300, 20);
        tfPotencia.setColumns(10);
        return tfPotencia;
    }

    public JButton btValidarPlaca() {
        btValidarPlaca.setText("Validar");
        btValidarPlaca.setBounds(490, 29, 100, 20);
        btValidarPlaca.setMnemonic('V');
        return btValidarPlaca;
    }

    public void limparCampos() {
        getTfPlaca().setText(null);
        getTfMarca().setText(null);
        getTfModelo().setText(null);
        getTfCor().setText(null);
        getTfVelocMax().setText(null);
        getTfQtRodas().setText(null);
        getTfQtPist().setText(null);
        getTfPotencia().setText(null);
    }

    public boolean validarPlaca() {
        try {
            return this.getVeiculoService().validarPlaca(this.getTfPlaca().getText());
        } catch (VeicExistException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Placa já existente!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public void enableBotoes(boolean enable) {
        this.tfPlaca.setEnabled(!enable);
        this.tfCor.setEnabled(enable);
        this.tfPotencia.setEnabled(enable);
        this.tfMarca.setEnabled(enable);
        this.tfModelo.setEnabled(enable);
        this.tfQtPist.setEnabled(enable);
        this.tfQtRodas.setEnabled(enable);
        this.tfVelocMax.setEnabled(enable);
    }
}
