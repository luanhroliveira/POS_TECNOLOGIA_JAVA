package br.com.luanhroliveira.modal.veiculo.passeio;

import br.com.luanhroliveira.entity.enums.VeiculoType;
import br.com.luanhroliveira.modal.veiculo.ListarOuExcluirTodosPanel;
import br.com.luanhroliveira.modal.veiculo.MenuVeiculoPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VeiculoPasseioPanel extends MenuVeiculoPanel implements ActionListener {

    private final JFrame jFrame = super.getMenuVeiculoFrame();

    private final CadPasseioPanel cadPasseioPanel = new CadPasseioPanel();
    private final ConsultarExcluirPorPlacaPasseioPanel consultarExcluirPorPlacaPasseioPanel = new ConsultarExcluirPorPlacaPasseioPanel();
    private final ListarOuExcluirTodosPanel listarOuExcluirTodosPasseioPanel = new ListarOuExcluirTodosPanel();

    private JFrame getjFrame() {
        return jFrame;
    }

    private CadPasseioPanel getCadPasseioPanel() {
        return cadPasseioPanel;
    }

    private ConsultarExcluirPorPlacaPasseioPanel getConsultarExcluirPorPlacaPasseioPanel() {
        return consultarExcluirPorPlacaPasseioPanel;
    }

    private ListarOuExcluirTodosPanel getListarOuExcluirTodosPasseioPanel() {
        return listarOuExcluirTodosPasseioPanel;
    }

    public void loadVeiculoPasseioPanel() {
        this.getjFrame().setTitle("Veículo de Passeio");

        super.getBtCadastrarVeiculo().addActionListener(this);
        super.getBtConsultarOuExcluirPorPlaca().addActionListener(this);
        super.getBtImprimirOuExcluirTodos().addActionListener(this);
        super.getBtSair().addActionListener(this);

        this.getjFrame().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent act) {
        if (act.getSource().equals(super.getBtCadastrarVeiculo())) {
            this.getCadPasseioPanel().loadPasseioPanel();
        } else if (act.getSource().equals(super.getBtConsultarOuExcluirPorPlaca())) {
            this.getConsultarExcluirPorPlacaPasseioPanel().loadConsultarExcluirPlacaPasseioPanel();
        } else if (act.getSource().equals(super.getBtImprimirOuExcluirTodos())) {
            this.getListarOuExcluirTodosPasseioPanel().loadListarOuExcluirTodosPasseioPanel(VeiculoType.PASSEIO);
        } else if (act.getSource().equals(super.getBtSair())) {
            this.getjFrame().dispose();
        }
    }
}
