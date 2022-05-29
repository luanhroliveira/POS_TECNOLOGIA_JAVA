package br.com.luanhroliveira.modal.veiculo;

import br.com.luanhroliveira.entity.enums.VeiculoType;
import br.com.luanhroliveira.services.VeiculoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarOuExcluirTodosPanel extends JFrame implements ActionListener {
    private final transient VeiculoService veiculoService = new VeiculoService();

    private VeiculoType veiculoType;

    private final JFrame jFrame = new JFrame();
    private final JPanel jPanel = new JPanel();
    private final JTable jTable = new JTable();
    private final JScrollPane jScrollPane = new JScrollPane();

    private final JButton btVerTodos = new JButton();
    private final JButton btExcluirTodos = new JButton();
    private final JButton btSair = new JButton();

    public VeiculoService getVeiculoService() {
        return this.veiculoService;
    }

    private VeiculoType getVeiculoType() {
        return veiculoType;
    }

    private void setVeiculoType(VeiculoType veiculoType) {
        this.veiculoType = veiculoType;
    }

    private JFrame getjFrame() {
        return this.jFrame;
    }

    private JPanel getjPanel() {
        return this.jPanel;
    }

    private JTable getjTable() {
        return this.jTable;
    }

    private JScrollPane getjScrollPane() {
        return jScrollPane;
    }

    private JButton getBtVerTodos() {
        return this.btVerTodos;
    }

    private JButton getBtExcluirTodos() {
        return this.btExcluirTodos;
    }

    private JButton getBtSair() {
        return this.btSair;
    }

    public void loadListarOuExcluirTodosPasseioPanel(VeiculoType type) {
        this.setVeiculoType(type);

        super.setTitle("Imprimir / Excluir todos");

        super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        super.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        super.setBounds(550, 250, 730, 490);

        this.btVerTodos();
        this.btExcluirTodos();
        this.btSair();


        this.getjScrollPane().setViewportView(this.getjTable());

        GroupLayout jPanel1Layout = new GroupLayout(this.getjPanel());
        this.getjPanel().setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(this.getjScrollPane(), GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(this.getjScrollPane(), GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        super.getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(this.getjPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(this.getBtVerTodos())
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(this.getBtExcluirTodos())
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(this.getBtSair())
                    .addContainerGap())
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(this.getjPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.getBtVerTodos())
                        .addComponent(this.getBtExcluirTodos())
                        .addComponent(this.getBtSair()))
                    .addGap(0, 67, Short.MAX_VALUE))
        );

        super.pack();

        super.setVisible(true);
    }

    private void btVerTodos() {
        this.getBtVerTodos().setText("Ver todos");
        this.getBtVerTodos().setMnemonic('V');
        this.getBtVerTodos().addActionListener(this);
    }

    private void btExcluirTodos() {
        this.getBtExcluirTodos().setText("Excluir Todos");
        this.getBtExcluirTodos().setMnemonic('E');
        this.getBtExcluirTodos().addActionListener(this);
    }

    private void btSair() {
        this.getBtSair().setText("Sair");
        this.getBtSair().setMnemonic('S');
        this.getBtSair().addActionListener(this);
    }

    private void getTodosVeiculo() {
        if (this.getVeiculoType().equals(VeiculoType.PASSEIO)) {
            this.getjTable().setModel(new DefaultTableModel(
                this.getVeiculoService().listarTodosVeiculoDePasseio(),
                this.getColunasVeiculoPasseio()
            ));
        } else {
            this.getjTable().setModel(new DefaultTableModel(
                this.getVeiculoService().listarTodosVeiculoDeCarga(),
                this.getColunasVeiculoCarga()
            ));
        }
    }

    private void excluirTodosVeiculo() {
        if (this.getVeiculoType().equals(VeiculoType.PASSEIO)) {
            this.getVeiculoService().deletarTodosVeiculoPasseio();
        } else {
            this.getVeiculoService().deletarTodosVeiculoCarga();
        }
        this.getTodosVeiculo();
    }

    private String[] getColunasVeiculoPasseio() {
        return new String[]
            {"Placa", "Marca", "Modelo", "Cor", "Velocidade Máxima", "Quantidade de Rodas"
                , "Quantidade de Pistão", "Potência", "Quantidade de Passageiros"};
    }

    private String[] getColunasVeiculoCarga() {
        return new String[]
            {"Placa", "Marca", "Modelo", "Cor", "Velocidade Máxima", "Quantidade de Rodas"
                , "Quantidade de Pistão", "Potência", "Carga Máxima", "Tara"};
    }

    @Override
    public void actionPerformed(ActionEvent act) {
        if (act.getSource().equals(this.getBtVerTodos())) {
            this.getTodosVeiculo();
        } else if (act.getSource().equals(this.getBtExcluirTodos())) {
            this.excluirTodosVeiculo();
        } else if (act.getSource().equals(this.getBtSair())) {
            this.getjFrame().dispose();
        }
    }

}
