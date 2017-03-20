/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import classes.Endereco;
import classes.GetId;
import classes.Search;
import classes.Valores;
import elementos.Menu1;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.ConexaoFireBird;
import modelo.ConexaoMySQL;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author LucianoRex
 */
public class CadastroProduto extends javax.swing.JFrame {

    /**
     * Creates new form Cadastros
     */
    public CadastroProduto() {
        initComponents();
    }
    DefaultTableModel model;
    ArrayList<String> lista = new ArrayList();
    String ImgPath = null;
   // Valores valores = new Valores();

    int codigo;
    int grupo;
    int subGrupo;
    int mSegment;
    int marca;
    int unidade;

    String descricao;
    String referencia;
    String codBarras;
    String caminho;
    double valorUnidade;

    boolean add = false;
    boolean edit = false;
    boolean cancel = false;
    boolean editCancel = false;
    boolean ok = false;
    String id = "";

    public void confereBtn() {
        if (jTBProduto.getRowCount() > 0) {
            //botoes
            btnEdit.setEnabled(true);
            btnDelete.setEnabled(true);
            //campos
            jTDescricao.setEnabled(false);
        } else {
            btnEdit.setEnabled(false);
            btnDelete.setEnabled(false);
        }
        if (add) {
            //botoes Principais
            btnCancel.setEnabled(true);
            btnOk.setEnabled(true);
            btnDelete.setEnabled(false);
            btnEdit.setEnabled(false);
            btnAdd.setEnabled(false);

            //Botoes secundarios
            btnGrupo.setEnabled(true);
            btnMSegment.setEnabled(true);
            btnMarca.setEnabled(true);
            btnSubGrupo.setEnabled(true);
            btnUnidade.setEnabled(true);
            btnAddImage.setEnabled(true);

            //campos
            jTDescricao.setEnabled(true);
            jTCodBarras.setEnabled(true);
            jTDescricao.setEnabled(true);
            jTReferencia.setEnabled(true);
            jTValorUnidade.setEnabled(true);

        } else {
            //Botoes Princiapis
            btnCancel.setEnabled(false);
            btnOk.setEnabled(false);
            //Botoes secundarios
            btnGrupo.setEnabled(false);
            btnMSegment.setEnabled(false);
            btnMarca.setEnabled(false);
            btnSubGrupo.setEnabled(false);
            btnUnidade.setEnabled(false);
            btnAddImage.setEnabled(false);
            //campos
            jTDescricao.setEnabled(false);
            jTCodBarras.setEnabled(false);
            jTDescricao.setEnabled(false);
            jTReferencia.setEnabled(false);
            jTValorUnidade.setEnabled(false);
        }

        if (edit) {
            btnAdd.setEnabled(false);
            btnOk.setEnabled(false);
            btnCancel.setEnabled(true);
            btnDelete.setEnabled(false);

            jTDescricao.setEnabled(true);
        }
        if (ok) {
            btnAdd.setEnabled(true);
        }
        if (cancel) {
            btnAdd.setEnabled(true);
            btnOk.setEnabled(false);
            btnCancel.setEnabled(false);

            jTDescricao.setEnabled(false);
            jTCodigo.setText("");
            jTDescricao.setText("");
        }
        if (editCancel) {
            //nao vai salvar o update
        }
    }

    public void atulaizaCampos(String campo) {
        jTGrupo.setText(campo);
        System.out.println("Retorno: " + campo);
    }

    public void atualizaTabela(int linhaSelecionada, ArrayList lista) {
        for (int i = 0; i < lista.size(); i++) {
            jTBProduto.setValueAt(lista.get(i), linhaSelecionada, i);
        }
    }

    public void montaTabela(String id) {
        jTBProduto.setVisible(true);
        Connection con = ConexaoMySQL.getConnection();
        String sql = "SELECT * FROM UNIDADE WHERE UNIDADE.CUNIDADE IN (" + id + ")";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            jTBProduto.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public void setNomeFiled(String conteudo) {
        jTUnidade.setText(conteudo);
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
        jTDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTReferencia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTCodBarras = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTUnidade = new javax.swing.JTextField();
        btnUnidade = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTGrupo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTSubGrupo = new javax.swing.JTextField();
        btnGrupo = new javax.swing.JButton();
        btnSubGrupo = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTMarca = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTMsegment = new javax.swing.JTextField();
        btnMSegment = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnAddImage = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTValorUnidade = new javax.swing.JTextField();
        btnMarca = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTBProduto = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JToggleButton();
        btnSearch = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLImagem = new javax.swing.JLabel();

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
        jLabel1.setText("Cadastro de Produto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1118, Short.MAX_VALUE)
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

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel18.setText("Código");

        jTCodigo.setEditable(false);

        jLabel5.setText("Descrição");

        jLabel2.setText("Referência");

        jLabel3.setText("Cód. Barras");

        jLabel4.setText("Unidade");

        btnUnidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Search-15.png"))); // NOI18N
        btnUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnidadeActionPerformed(evt);
            }
        });

        jLabel6.setText("Grupo");

        jTGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTGrupoActionPerformed(evt);
            }
        });

        jLabel7.setText("SubGrupo");

        btnGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Search-15.png"))); // NOI18N
        btnGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrupoActionPerformed(evt);
            }
        });

        btnSubGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Search-15.png"))); // NOI18N
        btnSubGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubGrupoActionPerformed(evt);
            }
        });

        jLabel8.setText("Marca");

        jLabel9.setText("M. Segment");

        btnMSegment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Search-15.png"))); // NOI18N
        btnMSegment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMSegmentActionPerformed(evt);
            }
        });

        jLabel10.setText("Imagem");

        btnAddImage.setText("...");
        btnAddImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddImageActionPerformed(evt);
            }
        });

        jLabel11.setText("Valor Unidade");

        btnMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Search-15.png"))); // NOI18N
        btnMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel18)
                        .addGap(4, 4, 4)
                        .addComponent(jTCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)
                        .addGap(10, 10, 10)
                        .addComponent(jTDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTCodBarras)
                            .addComponent(jTSubGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnSubGrupo)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMarca)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTMsegment, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMSegment)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUnidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTValorUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGrupo)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddImage)
                .addGap(40, 40, 40))
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jTReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jTCodBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jTUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUnidade))
                    .addComponent(btnGrupo)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTValorUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(3, 3, 3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTSubGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnSubGrupo)
                        .addComponent(btnMSegment)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnMarca)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jTMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(jTMsegment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddImage)
                        .addComponent(jLabel10)))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(10, 50, 1050, 210);

        jTBProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTBProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTBProdutoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTBProduto);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(10, 280, 1260, 210);

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

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(1080, 50, 190, 210);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        model = (DefaultTableModel) jTBProduto.getModel();
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

    private void jTBProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTBProdutoMouseClicked
        //retornar o valor aos campos

        int linha = jTBProduto.getSelectedRow();
        jTCodigo.setText(jTBProduto.getValueAt(linha, 0).toString());
        jTDescricao.setText((String) jTBProduto.getValueAt(linha, 1));
        jTReferencia.setText((String) jTBProduto.getValueAt(linha,2));
    }//GEN-LAST:event_jTBProdutoMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        add = true;
        cancel = false;
        ok = false;
        confereBtn();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        ArrayList<String> colunas = new ArrayList();

        Connection con = ConexaoMySQL.getConnection();
        String descricao = jTDescricao.getText();
        String referencia = jTReferencia.getText();
        String codBarra = jTCodBarras.getText();
        valorUnidade = Double.parseDouble(jTValorUnidade.getText());
//        int unidade= Integer.parseInt(jTUnidade.getText());
//        int grupo = Integer.parseInt(jTGrupo.getText());
//        int subGrupo = Integer.parseInt(jTSubGrupo.getText());
//        int mSegment = Integer.parseInt(jTMsegment.getText());
//        int marca = Integer.parseInt(jTMarca.get)
        InputStream img = null;
        try {
            img = new FileInputStream(new File(ImgPath));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

      //  String msegment = jTDescricao.getText();
        String sql = "INSERT INTO PRODUTO(DESCRICAO,REFERENCIA,CODBARRAS,CGRUPO,CSUBGRUPO,CMARCA,CMSEGMENT,CUNIDADE,VALORUNIDADE,IMAGEM)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, descricao);
            ps.setString(2, referencia);
            ps.setString(3, codBarra);
            ps.setInt(4, grupo);
            ps.setInt(5, subGrupo);
            ps.setInt(6, marca);
            ps.setInt(7, mSegment);
            ps.setInt(8, unidade);
            ps.setDouble(9, valorUnidade);
            ps.setBlob(10, img);          
            ps.execute();
            ps.close();
           
            

            JOptionPane.showMessageDialog(this, "Registros inseridos");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
         System.out.println(grupo);
            System.out.println(subGrupo);
            System.out.println(marca);
            System.out.println(mSegment);
            System.out.println(unidade);
        //id += getId.getId("UNIDADE", "CUNIDADE") + ",";
       // String linha[] = {getId.getId("MSEGMENT", "CMSEGMENT"), msegment};//RETORNA O ID
        //jTCodigo.setText(getId.getId("MSEGMENT", "CMSEGMENT"));

       // model.addRow(linha);
        add = false;
        cancel = false;
        ok = true;
        confereBtn();
        String consulta="SELECT * FROM PRODUTO";
        
         try {
            PreparedStatement ps = con.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            jTBProduto.setModel(DbUtils.resultSetToTableModel(rs));

            // retornaDescricao(rs.getString(1));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "" + ex.getMessage());
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //        model.removeRow(tabela.getSelectedRow());
        int option = JOptionPane.showConfirmDialog(this, "Excluir?");
        if (option == JOptionPane.YES_OPTION) {
            int linhaSelecionada = jTBProduto.getSelectedRow();
            System.out.println(linhaSelecionada);
            if (linhaSelecionada >= 0) {
                Connection con = ConexaoMySQL.getConnection();
                String sql = "DELETE FROM MSEGMENT"
                        + " WHERE MSEGMENT.CMSEGMENT = " + jTBProduto.getValueAt(linhaSelecionada, 0);
                try {
                    PreparedStatement st = con.prepareStatement(sql);
                    st.execute();
                    st.close();
                    model.removeRow(jTBProduto.getSelectedRow());
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
        String marca = jTDescricao.getText();
        String sql = "UPDATE MSEGMENT SET MSEGMENT = ? WHERE MSEGMENT.CMSEGMENT = ? ";

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
                int linhaSelecionada = jTBProduto.getSelectedRow();
                try {
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, marca);
                    System.out.println(jTBProduto.getValueAt(linhaSelecionada, 0));
                    ps.setInt(2, Integer.parseInt((String) jTBProduto.getValueAt(linhaSelecionada, 0)));
                    ps.execute();
                    ps.close();
                    JOptionPane.showMessageDialog(this, "Registro alterado");
                    confereBtn();
                    lista.clear();
                    lista.add(((String) jTBProduto.getValueAt(linhaSelecionada, 0)));
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

    private void btnUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnidadeActionPerformed
        Consulta consulta = new Consulta(this, true);
        consulta.jCTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Código", "Descricao"}));
        consulta.sql = "SELECT UNIDADE.CUNIDADE AS CODIGO, UNIDADE.UNIDADE AS DESCRICAO FROM UNIDADE";
        consulta.campo.add("UNIDADE.CUNIDADE");
        consulta.campo.add("UNIDADE.UNIDADE");
        consulta.setVisible(true);
        jTUnidade.setText(consulta.valores.getDescricao());
        unidade = consulta.valores.getCodigo();
        System.out.println(unidade);

    }//GEN-LAST:event_btnUnidadeActionPerformed

    private void btnGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrupoActionPerformed
        Consulta consulta = new Consulta(this, true);
        consulta.jCTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Código", "Descricao"}));
        consulta.sql = "SELECT GRUPO.CGRUPO AS CODIGO,GRUPO.GRUPO AS DESCRICAO FROM GRUPO";
        consulta.campo.add("GRUPO.CGRUPO");
        consulta.campo.add("GRUPO.GRUPO");
        consulta.setVisible(true);
        jTGrupo.setText(consulta.valores.getDescricao());
        grupo = consulta.valores.getCodigo();
        System.out.println(grupo);

    }//GEN-LAST:event_btnGrupoActionPerformed

    private void btnSubGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubGrupoActionPerformed
        Consulta consulta = new Consulta(this, true);
        consulta.jCTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Código", "Descricao"}));
        consulta.sql = "SELECT SUBGRUPO.CSUBGRUPO AS CODIGO,SUBGRUPO.SUBGRUPO AS DESCRICAO FROM SUBGRUPO";
        consulta.campo.add("SUBGRUPO.CSUBGRUPO");
        consulta.campo.add("SUBGRUPO.SUBGRUPO");
        consulta.setVisible(true);
        jTSubGrupo.setText(consulta.valores.getDescricao());
        subGrupo = consulta.valores.getCodigo();
        System.out.println(subGrupo);
    }//GEN-LAST:event_btnSubGrupoActionPerformed

    private void btnMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcaActionPerformed
        Consulta consulta = new Consulta(this, true);
        consulta.jCTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Código", "Descricao"}));
        consulta.sql = "SELECT MARCA.CMARCA AS CODIGO,MARCA.MARCA AS NOME FROM MARCA";
        consulta.campo.add("MARCA.CMARCA");
        consulta.campo.add("MARCA.MARCA");
        consulta.setVisible(true);
        jTMarca.setText(consulta.valores.getDescricao());
        marca = consulta.valores.getCodigo();
        System.out.println(marca);
    }//GEN-LAST:event_btnMarcaActionPerformed

    private void btnMSegmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMSegmentActionPerformed
        Consulta consulta = new Consulta(this, true);
        consulta.jCTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Código", "Descricao"}));
        consulta.sql = "SELECT MSEGMENT.CMSEGMENT AS CODIGO,MSEGMENT.MSEGMENT AS NOME FROM MSEGMENT";
        consulta.campo.add("MSEGMENT.CMSEGMENT");
        consulta.campo.add("MSEGMENT.MSEGMENT");
        consulta.setVisible(true);
        jTMsegment.setText(consulta.valores.getDescricao());
        mSegment = consulta.valores.getCodigo();
        System.out.println(mSegment);
    }//GEN-LAST:event_btnMSegmentActionPerformed

    private void btnAddImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddImageActionPerformed
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*image", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            jLImagem.setIcon(ResizeImage(path, null));
            ImgPath = path;
        } else {
            System.out.println("Nenhum arquivo selecionado");
        }
    }//GEN-LAST:event_btnAddImageActionPerformed

    private void jTGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTGrupoActionPerformed
    public ImageIcon ResizeImage(String imagePath, byte[] pic) {
        ImageIcon myImage = null;

        if (imagePath != null) {
            myImage = new ImageIcon(imagePath);
        } else {
            myImage = new ImageIcon(pic);
        }

        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(jLImagem.getWidth(), jLImagem.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }

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
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddImage;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JToggleButton btnEdit;
    private javax.swing.JButton btnGrupo;
    private javax.swing.JButton btnMSegment;
    private javax.swing.JButton btnMarca;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSubGrupo;
    private javax.swing.JButton btnUnidade;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLImagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTBProduto;
    private javax.swing.JTextField jTCodBarras;
    private javax.swing.JTextField jTCodigo;
    public javax.swing.JTextField jTDescricao;
    public javax.swing.JTextField jTGrupo;
    private javax.swing.JTextField jTMarca;
    private javax.swing.JTextField jTMsegment;
    private javax.swing.JTextField jTReferencia;
    private javax.swing.JTextField jTSubGrupo;
    private javax.swing.JTextField jTUnidade;
    private javax.swing.JTextField jTValorUnidade;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
