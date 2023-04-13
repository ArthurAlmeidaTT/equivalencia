package br.com.equivalencia.view;

import br.com.equivalencia.dao.ModuloConexao;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author aalmeida
 */
public class TelaArea extends javax.swing.JFrame {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void adicionar(){
        String sql = "insert into tb_area_tecnologica(nome_area) values (?)";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,txtNomeArea.getText());
            
            if (txtNomeArea.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Campo de preenchimento obrigatório não foi preenchido.");
            }else{
                int adicionado = pst.executeUpdate();
                    System.out.println(adicionado);
                    if (adicionado>0) {
                       JOptionPane.showMessageDialog(null,"Área Tecnológica cadastrada com sucesso!"); 
                       txtNomeArea.setText(null);
                    }
                }
                
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
}
 
private void consultar() {
        String sql = "select id_area as Id, nome_area as Área from tb_area_tecnologica where nome_area like ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtConsultaArea.getText() + "%");
            rs = pst.executeQuery();
            tblAreaConsulta.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
public void setar_campos(){
    tblAreaConsulta.setVisible(true);
    int setar = tblAreaConsulta.getSelectedRow();
    txtIdArea.setText(tblAreaConsulta.getModel().getValueAt(setar,0).toString());
    txtNomeArea.setText(tblAreaConsulta.getModel().getValueAt(setar,1).toString());
    btncAdicionarArea.setEnabled(false);
    btnEditarArea.setEnabled(true);
    btnExcluirArea.setEnabled(true);
}    

public void alterar(){
    String sql = "update tb_area_tecnologica set nome_area =? where id_area =?";
    
    try {
        pst = conexao.prepareStatement(sql);
        pst.setString(1,txtNomeArea.getText());
        pst.setString(2, txtIdArea.getText());
        
        if ((txtIdArea.getText().isEmpty()) || (txtNomeArea.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Campos obrigatorios não preenchidas.");
            
    } else {
            int adicionado = pst.executeUpdate();
            
            if (adicionado >0){
                JOptionPane.showMessageDialog(null, "Area Tecnológica alterada com sucesso");
                btncAdicionarArea.setEnabled(true);
                btnEditarArea.setEnabled(false);
                txtIdArea.setText(null);
                txtNomeArea.setText(null);
            }
            
        }
        
    } catch (Exception e) {
         JOptionPane.showMessageDialog(null,e);
    }
}
    
    public TelaArea() {
        initComponents(); 
        getContentPane().setBackground(Color.black);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/com/equivalencia/imagens/icon app.png")));
        
        conexao = ModuloConexao.conector();
    
        
    }
    
    public void excluir() {
        
        int confirm = JOptionPane.showConfirmDialog(null, "Você tem certeza?, pessoas podem ser demitidas.","Atenção",JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION);
            String sql = "delete from tb_area_tecnologica where id_area =?";
            
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1,txtIdArea.getText());
                
                int apagado = pst.executeUpdate();
                
                if(apagado > 0 ){
                    JOptionPane.showMessageDialog(null, "Área Tecnológiaca apagada com sucesso.");
                    txtIdArea.setText(null);
                    txtNomeArea.setText(null);
                    btncAdicionarArea.setEnabled(true);
                    btnExcluirArea.setEnabled(false);
                    btnEditarArea.setEnabled(false);
                }
                
        }catch (java.sql.SQLIntegrityConstraintViolationException e){
            JOptionPane.showMessageDialog(null,"A area não pode ser deletada -- \n tente deletar os cursos vinculados a ela antes de apagar a mesma.");
          
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null,e1);
         
        } 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel3 = new javax.swing.JPanel();
        jMenu1 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtIdArea = new javax.swing.JTextField();
        txtNomeArea = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btncAdicionarArea = new javax.swing.JButton();
        btnEditarArea = new javax.swing.JButton();
        btnPesquisarArea = new javax.swing.JButton();
        btnExcluirArea = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAreaConsulta = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtConsultaArea = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 282, Short.MAX_VALUE)
        );

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema Equivalência - Tela Área Tecnologica");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID:");

        txtIdArea.setBackground(new java.awt.Color(153, 153, 153));
        txtIdArea.setEnabled(false);
        txtIdArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdAreaActionPerformed(evt);
            }
        });

        txtNomeArea.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome");

        btncAdicionarArea.setBackground(new java.awt.Color(51, 153, 0));
        btncAdicionarArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/equivalencia/imagens/adcionar.png"))); // NOI18N
        btncAdicionarArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncAdicionarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncAdicionarAreaActionPerformed(evt);
            }
        });

        btnEditarArea.setBackground(new java.awt.Color(102, 102, 255));
        btnEditarArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/equivalencia/imagens/editar.png"))); // NOI18N
        btnEditarArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarArea.setEnabled(false);
        btnEditarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAreaActionPerformed(evt);
            }
        });

        btnPesquisarArea.setBackground(new java.awt.Color(255, 255, 102));
        btnPesquisarArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/equivalencia/imagens/pesquisa.png"))); // NOI18N
        btnPesquisarArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnExcluirArea.setBackground(new java.awt.Color(255, 102, 102));
        btnExcluirArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/equivalencia/imagens/lixeira.png"))); // NOI18N
        btnExcluirArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluirArea.setEnabled(false);
        btnExcluirArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirAreaActionPerformed(evt);
            }
        });

        tblAreaConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Área", "Nome Área"
            }
        ));
        tblAreaConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAreaConsultaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblAreaConsulta);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Pesquisar :");

        txtConsultaArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtConsultaAreaMouseClicked(evt);
            }
        });
        txtConsultaArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConsultaAreaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeArea, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdArea, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btncAdicionarArea, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnEditarArea, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnPesquisarArea, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(btnExcluirArea, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtConsultaArea, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditarArea, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarArea, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncAdicionarArea, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtConsultaArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btncAdicionarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncAdicionarAreaActionPerformed
        adicionar();
        consultar();
    }//GEN-LAST:event_btncAdicionarAreaActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(TelaArea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosed

    private void txtConsultaAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultaAreaKeyReleased
        consultar();
    }//GEN-LAST:event_txtConsultaAreaKeyReleased

    private void txtIdAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdAreaActionPerformed

    private void tblAreaConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAreaConsultaMouseClicked
        setar_campos();
        consultar();
    }//GEN-LAST:event_tblAreaConsultaMouseClicked

    private void txtConsultaAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtConsultaAreaMouseClicked
        tblAreaConsulta.setVisible(true);
        consultar();
    }//GEN-LAST:event_txtConsultaAreaMouseClicked

    private void btnEditarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAreaActionPerformed
        alterar();
        consultar();
    }//GEN-LAST:event_btnEditarAreaActionPerformed

    private void btnExcluirAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirAreaActionPerformed
        excluir();
        consultar();
    }//GEN-LAST:event_btnExcluirAreaActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaArea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarArea;
    private javax.swing.JButton btnExcluirArea;
    private javax.swing.JButton btnPesquisarArea;
    private javax.swing.JButton btncAdicionarArea;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblAreaConsulta;
    private javax.swing.JTextField txtConsultaArea;
    private javax.swing.JTextField txtIdArea;
    private javax.swing.JTextField txtNomeArea;
    // End of variables declaration//GEN-END:variables


}
