/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import classes.Endereco;
import classes.GetId;
import classes.Search;
import elementos.Menu1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import modelo.ConexaoFireBird;
import modelo.ConexaoMySQL;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author LucianoRex
 */
public class CadastroSubGrupo extends javax.swing.JFrame {

    /**
     * Creates new form Cadastros
     */
    public CadastroSubGrupo() {
        initComponents();
    }
    DefaultTableModel model;
    ArrayList<String> lista = new ArrayList();

    boolean add = false;
    boolean edit = false;
    boolean cancel = false;
    boolean editCancel = false;
    boolean ok=false;
    String id = "";

    public void confereBtn() {
        if (jTBSubGrupo.getRowCount() > 0) {
            //botoes
            btnEdit.setEnabled(true);
            btnDelete.setEnabled(true);
            //campos
            jTSubGrupo.setEnabled(false);
        } else {
            btnEdit.setEnabled(false);
            btnDelete.setEnabled(false);
        }
        if (add) {
            //botoes
            btnCancel.setEnabled(true);
            btnOk.setEnabled(true);
            btnDelete.setEnabled(false);
            btnEdit.setEnabled(false);
            btnAdd.setEnabled(false);

            //campos
            jTSubGrupo.setEnabled(true);
        } else {
            btnCancel.setEnabled(false);
            btnOk.setEnabled(false);

            jTSubGrupo.setEnabled(false);
        }

        if (edit) {
            btnAdd.setEnabled(false);
            btnOk.setEnabled(false);
            btnCancel.setEnabled(true);
            btnDelete.setEnabled(false);

            jTSubGrupo.setEnabled(true);
        } 
        if(ok){
            btnAdd.setEnabled(true);
        }
        if (cancel) {
            btnAdd.setEnabled(true);
            btnOk.setEnabled(false);
            btnCancel.setEnabled(false);

            jTSubGrupo.setEnabled(false);
            jTCodigo.setText("");
            jTSubGrupo.setText("");
        }
        if (editCancel) {
            //nao vai salvar o update
        }
    }

    public void atualizaTabela(int linhaSelecionada, ArrayList lista) {
        for (int i = 0; i < lista.size(); i++) {
            jTBSubGrupo.setValueAt(lista.get(i), linhaSelecionada, i);
        }
    }

    public void montaTabela(String id) {
        jTBSubGrupo.setVisible(true);
        Connection con = ConexaoMySQL.getConnection();
        String sql = "SELECT * FROM SUBGRUPO WHERE SUBGRUPO.CSUBGRUPO IN (" + id + ")";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            jTBSubGrupo.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    GetId getId = new GetId();


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenu2 = new javax.swing.JMenu();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jTCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTSubGrupo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTBSubGrupo = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JToggleButton();
        btnSearch = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jMenu2.setText("jMenu2");

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Close Window-30.png"))); // NOI18N
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastro de SubGrupo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 297, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 102), 2, true));
        jPanel2.setLayout(null);

        jLabel18.setText("Código");

        jTCodigo.setEditable(false);

        jLabel5.setText("SubGrupo");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel18)
                .addGap(4, 4, 4)
                .addComponent(jTCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addGap(10, 10, 10)
                .addComponent(jTSubGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel18))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jTCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5))
                    .addComponent(jTSubGrupo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(10, 50, 460, 100);

        jTBSubGrupo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Unidade", "UF"
            }
        ));
        jTBSubGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTBSubGrupoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTBSubGrupo);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(30, 170, 340, 210);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Plus-20.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Ok-20.png"))); // NOI18N
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Delete-20.png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Edit-20.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Search-20.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cancel-20.png"))); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(btnAdd)
                .addGap(8, 8, 8)
                .addComponent(btnOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addComponent(btnOk)
                    .addComponent(btnDelete)
                    .addComponent(btnSearch)
                    .addComponent(btnEdit)
                    .addComponent(btnCancel, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jPanel2.add(jPanel6);
        jPanel6.setBounds(10, 10, 362, 31);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        model = (DefaultTableModel) jTBSubGrupo.getModel();
        model.setNumRows(0);
        confereBtn();

    }//GEN-LAST:event_formWindowOpened


    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Close Window red-30.png")));
    }//GEN-LAST:event_btnCloseMouseEntered

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Close Window-30.png")));
    }//GEN-LAST:event_btnCloseMouseExited

    private void jTBSubGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTBSubGrupoMouseClicked
        //retornar o valor aos campos

//        int linha = jTBSubGrupo.getSelectedRow();
//        jTCodigo.setText(jTBSubGrupo.getValueAt(linha, 0).toString());
//        jTSubGrupo.setText((String) jTBSubGrupo.getValueAt(linha, 1));      
    }//GEN-LAST:event_jTBSubGrupoMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        add = true;
        cancel = false;
        ok=false;
        confereBtn();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        ArrayList<String> colunas = new ArrayList();

        Connection con = ConexaoMySQL.getConnection();
        String subgrupo = jTSubGrupo.getText();
        String sql = "INSERT INTO SUBGRUPO(SUBGRUPO)"
        + " VALUES(?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, subgrupo);
            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(this, "Registros inseridos");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        //id += getId.getId("UNIDADE", "CUNIDADE") + ",";
        String linha[] = {getId.getId("SUBGRUPO", "CSUBGRUPO"), subgrupo};//RETORNA O ID
        jTCodigo.setText(getId.getId("SUBGRUPO", "CSUBGRUPO"));

        model.addRow(linha);
        add = false;
        cancel = false;
        ok=true;
        confereBtn();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //        model.removeRow(tabela.getSelectedRow());
        int option = JOptionPane.showConfirmDialog(this, "Excluir?");
        if (option == JOptionPane.YES_OPTION) {
            int linhaSelecionada = jTBSubGrupo.getSelectedRow();
            System.out.println(linhaSelecionada);
            if (linhaSelecionada >= 0) {
                Connection con = ConexaoMySQL.getConnection();
                String sql = "DELETE FROM SUBGRUPO"
                + " WHERE SUBGRUPO.CSUBGRUPO = " + jTBSubGrupo.getValueAt(linhaSelecionada, 0);
                try {
                    PreparedStatement st = con.prepareStatement(sql);
                    st.execute();
                    st.close();
                    model.removeRow(jTBSubGrupo.getSelectedRow());
                    JOptionPane.showMessageDialog(this, "Cadastro removido");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um cadastro");
            }
        }
        confereBtn();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        Connection con = ConexaoMySQL.getConnection();
        String marca = jTSubGrupo.getText();
        String sql = "UPDATE SUBGRUPO SET SUBGRUPO = ? WHERE SUBGRUPO.CSUBGRUPO = ? ";

        if (btnEdit.isSelected()) {
            btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Ok-20.png")));
            edit = true;
            add = false;
            cancel = false;
            confereBtn();

        } else {
            edit = false;
            add = false;

            confereBtn();
            if (!editCancel) {
                int linhaSelecionada = jTBSubGrupo.getSelectedRow();
                try {
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, marca);
                    System.out.println(jTBSubGrupo.getValueAt(linhaSelecionada, 0));
                    ps.setInt(2, Integer.parseInt((String) jTBSubGrupo.getValueAt(linhaSelecionada, 0)));
                    ps.execute();
                    ps.close();
                    JOptionPane.showMessageDialog(this, "Registro alterado");
                    confereBtn();
                    lista.clear();
                    lista.add(((String) jTBSubGrupo.getValueAt(linhaSelecionada, 0)));
                    lista.add(marca);
                    edit = false;
                    atualizaTabela(linhaSelecionada, lista);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
                add = true;
            } else {
                JOptionPane.showMessageDialog(null, "Operação cancelada");
            }
            btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Edit-20.png")));
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
//        TabelaMarca tabelaMarca = new TabelaMarca(this);
//        tabelaMarca.setVisible(true);
//        confereBtn();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        add = false;
        cancel = true;
        if (edit) {
            editCancel = true;
            btnEdit.doClick();
        }
        confereBtn();
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroSubGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroSubGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroSubGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroSubGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroSubGrupo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JToggleButton btnEdit;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTBSubGrupo;
    private javax.swing.JTextField jTCodigo;
    public javax.swing.JTextField jTSubGrupo;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}