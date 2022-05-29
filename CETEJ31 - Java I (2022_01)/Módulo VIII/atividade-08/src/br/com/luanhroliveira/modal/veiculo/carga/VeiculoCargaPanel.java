package br.com.luanhroliveira.modal.veiculo.carga;

import br.com.luanhroliveira.entity.enums.VeiculoType;
import br.com.luanhroliveira.modal.veiculo.MenuVeiculoPanel;
import br.com.luanhroliveira.modal.veiculo.ListarOuExcluirTodosPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VeiculoCargaPanel extends MenuVeiculoPanel implements ActionListener {
    private final JFrame jFrame = super.getMenuVeiculoFrame();

    private final CadCargaPanel cadCargaPanel = new CadCargaPanel();
    private final ListarOuExcluirTodosPanel listarOuExcluirTodosPasseioPanel = new ListarOuExcluirTodosPanel();
    private final ConsultarExcluirPorPlacaCargaPanel consultarExcluirPorPlacaCargaPanel = new ConsultarExcluirPorPlacaCargaPanel();

    private JFrame getjFrame() {
        return jFrame;
    }

    private CadCargaPanel getCadCargaPanel() {
        return cadCargaPanel;
    }

    private ListarOuExcluirTodosPanel getListarOuExcluirTodosPasseioPanel() {
        return listarOuExcluirTodosPasseioPanel;
    }

    private ConsultarExcluirPorPlacaCargaPanel getConsultarExcluirPorPlacaCargaPanel() {
        return consultarExcluirPorPlacaCargaPanel;
    }

    public void loadVeiculoCargaModal() {
        this.getjFrame().setTitle("Veículo de Carga");

        super.getBtCadastrarVeiculo().addActionListener(this);
        super.getBtConsultarOuExcluirPorPlaca().addActionListener(this);
        super.getBtImprimirOuExcluirTodos().addActionListener(this);
        super.getBtSair().addActionListener(this);

        this.getjFrame().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent act) {
        if (act.getSource().equals(super.getBtCadastrarVeiculo())) {
            this.getCadCargaPanel().loadCadCargaPanel();
        } else if (act.getSource().equals(super.getBtConsultarOuExcluirPorPlaca())) {
            this.getConsultarExcluirPorPlacaCargaPanel().loadConsultarExcluirPorPlacaCargaPanel();
        } else if (act.getSource().equals(super.getBtImprimirOuExcluirTodos())) {
            this.getListarOuExcluirTodosPasseioPanel().loadListarOuExcluirTodosPasseioPanel(VeiculoType.CARGA);
        } else if (act.getSource().equals(super.getBtSair())) {
            this.getjFrame().dispose();
        }
    }
}
