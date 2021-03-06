/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Gustavo
 */
public class ModuloAdministrador extends javax.swing.JFrame {
  
  FondoPanel fondo = new FondoPanel();

  /**
   * Creates new form ModuloAdministrador
   */
  public ModuloAdministrador() {
    this.setContentPane(fondo);
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel2 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    jPanel1 = new javax.swing.JPanel();
    btnUsuarios = new javax.swing.JButton();
    btnCentrosMedicos = new javax.swing.JButton();
    jPanel3 = new javax.swing.JPanel();
    btnDiagnosticos = new javax.swing.JButton();
    btnTratamientos = new javax.swing.JButton();
    btnBitacoraCitas = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setResizable(false);

    jPanel2.setOpaque(false);

    jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(255, 255, 255));
    jLabel2.setText("<html>Módulo de Administrador</html>");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
    jPanel1.setOpaque(false);

    btnUsuarios.setBackground(new java.awt.Color(255, 255, 255));
    btnUsuarios.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
    btnUsuarios.setForeground(new java.awt.Color(0, 0, 0));
    btnUsuarios.setText("Usuarios");
    btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnUsuariosActionPerformed(evt);
      }
    });

    btnCentrosMedicos.setBackground(new java.awt.Color(255, 255, 255));
    btnCentrosMedicos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    btnCentrosMedicos.setForeground(new java.awt.Color(0, 0, 0));
    btnCentrosMedicos.setText("Centros Médicos");
    btnCentrosMedicos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    btnCentrosMedicos.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCentrosMedicosActionPerformed(evt);
      }
    });

    jPanel3.setOpaque(false);

    btnDiagnosticos.setBackground(new java.awt.Color(255, 255, 255));
    btnDiagnosticos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    btnDiagnosticos.setForeground(new java.awt.Color(0, 0, 0));
    btnDiagnosticos.setText("Diagnósticos");
    btnDiagnosticos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    btnDiagnosticos.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnDiagnosticosActionPerformed(evt);
      }
    });

    btnTratamientos.setBackground(new java.awt.Color(255, 255, 255));
    btnTratamientos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    btnTratamientos.setForeground(new java.awt.Color(0, 0, 0));
    btnTratamientos.setText("Tratamientos");
    btnTratamientos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    btnTratamientos.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnTratamientosActionPerformed(evt);
      }
    });

    btnBitacoraCitas.setBackground(new java.awt.Color(255, 255, 255));
    btnBitacoraCitas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    btnBitacoraCitas.setForeground(new java.awt.Color(0, 0, 0));
    btnBitacoraCitas.setText("Bitácora de Citas");
    btnBitacoraCitas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    btnBitacoraCitas.setMaximumSize(new java.awt.Dimension(152, 34));
    btnBitacoraCitas.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnBitacoraCitasActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(btnDiagnosticos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(btnTratamientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(btnBitacoraCitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(btnDiagnosticos, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(btnTratamientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(btnBitacoraCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(btnCentrosMedicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(18, 18, 18)
        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(btnCentrosMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(210, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 42, Short.MAX_VALUE)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_btnUsuariosActionPerformed

  private void btnCentrosMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCentrosMedicosActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_btnCentrosMedicosActionPerformed

  private void btnTratamientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTratamientosActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_btnTratamientosActionPerformed

  private void btnDiagnosticosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiagnosticosActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_btnDiagnosticosActionPerformed

  private void btnBitacoraCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBitacoraCitasActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_btnBitacoraCitasActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try
    {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
      {
        if ("Nimbus".equals(info.getName()))
        {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex)
    {
      java.util.logging.Logger.getLogger(ModuloAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex)
    {
      java.util.logging.Logger.getLogger(ModuloAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex)
    {
      java.util.logging.Logger.getLogger(ModuloAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex)
    {
      java.util.logging.Logger.getLogger(ModuloAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new ModuloAdministrador().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  public javax.swing.JButton btnBitacoraCitas;
  public javax.swing.JButton btnCentrosMedicos;
  public javax.swing.JButton btnDiagnosticos;
  public javax.swing.JButton btnTratamientos;
  public javax.swing.JButton btnUsuarios;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  // End of variables declaration//GEN-END:variables

class FondoPanel extends JPanel{
    private Image imagen;
    
    @Override
    public void paint(Graphics g){
      imagen = new ImageIcon(getClass().getResource("/imagenes/Fondo.png")).getImage();
      g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
      setOpaque(false);
      super.paint(g);
    }
  }
}
