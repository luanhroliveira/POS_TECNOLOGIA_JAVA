package br.com.luanhroliveira.modal;

import br.com.luanhroliveira.modal.veiculo.carga.VeiculoCargaPanel;
import br.com.luanhroliveira.modal.veiculo.passeio.VeiculoPasseioPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalPanel implements ActionListener {

    private final JFrame jFrame = new JFrame();
    private final VeiculoPasseioPanel veiculoPasseioPanel = new VeiculoPasseioPanel();
    private final VeiculoCargaPanel veiculoCargaPanel = new VeiculoCargaPanel();

    private final JButton veiculoPasseio = new JButton();
    private final JButton veiculoCarga = new JButton();

    public JFrame getJFrame() {
        return this.jFrame;
    }

    public VeiculoPasseioPanel getVeiculoPasseioPanel() {
        return this.veiculoPasseioPanel;
    }

    public VeiculoCargaPanel getVeiculoCargaPanel() {
        return this.veiculoCargaPanel;
    }

    public JButton getVeiculoPasseio() {
        return this.veiculoPasseio;
    }

    public JButton getVeiculoCarga() {
        return this.veiculoCarga;
    }

    public void loadPanel() {
        this.getJFrame().setTitle("Sistema de Gestão de Veículos - Menu Inicial ");
        this.getJFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getJFrame().setLayout(new GridLayout(2, 1, 1, 1));
        this.getJFrame().setBounds(550, 250, 730, 490);
        this.getJFrame().getContentPane().setBackground(Color.WHITE);

        this.getJFrame().add(this.veiculoPasseio());
        this.getJFrame().add(this.veiculoCarga());

        this.getJFrame().setVisible(true);
    }

    public JButton veiculoPasseio() {
        this.getVeiculoPasseio().setText("Passeio");
        this.getVeiculoPasseio().setMnemonic('P');
        this.getVeiculoPasseio().addActionListener(this);

        return this.getVeiculoPasseio();
    }

    public JButton veiculoCarga() {
        this.getVeiculoCarga().setText("Carga");
        this.getVeiculoCarga().setMnemonic('C');
        this.getVeiculoCarga().addActionListener(this);

        return this.getVeiculoCarga();
    }

    @Override
    public void actionPerformed(ActionEvent act) {
        if (act.getSource().equals(this.getVeiculoPasseio())) {
            this.getVeiculoPasseioPanel().loadVeiculoPasseioPanel();
        } else if (act.getSource().equals(this.getVeiculoCarga())) {
            this.getVeiculoCargaPanel().loadVeiculoCargaModal();
        }
    }
}
