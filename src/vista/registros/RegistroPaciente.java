/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.registros;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Gustavo
 */
public class RegistroPaciente extends javax.swing.JFrame {
  
  FondoPanel fondo = new FondoPanel();

  /**
   * Creates new form RegistroPaciente
   */
  public RegistroPaciente() {
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
    jLabel1 = new javax.swing.JLabel();
    jPanel1 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    jPanel3 = new javax.swing.JPanel();
    jLabel3 = new javax.swing.JLabel();
    txtNombrePaciente = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    txtCedulaPaciente = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    cbSangre = new javax.swing.JComboBox<>();
    dcFechaNacimiento = new com.toedter.calendar.JDateChooser();
    jLabel11 = new javax.swing.JLabel();
    txtNacionalidad = new javax.swing.JTextField();
    jPanel4 = new javax.swing.JPanel();
    jLabel9 = new javax.swing.JLabel();
    passContrasena = new javax.swing.JPasswordField();
    btnRegistrarPaciente = new javax.swing.JButton();
    jLabel8 = new javax.swing.JLabel();
    txtTelefono = new javax.swing.JTextField();
    btnAgregarTelefono = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    listTelefonos = new javax.swing.JList<>();
    jLabel10 = new javax.swing.JLabel();
    txtResidencia = new javax.swing.JTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setMinimumSize(new java.awt.Dimension(750, 600));
    setResizable(false);

    jPanel2.setOpaque(false);

    jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setText("<html>Registro de Pacientes</html>");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        .addContainerGap(15, Short.MAX_VALUE)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    jPanel1.setMaximumSize(new java.awt.Dimension(750, 480));
    jPanel1.setMinimumSize(new java.awt.Dimension(750, 480));
    jPanel1.setOpaque(false);
    jPanel1.setLayout(null);

    jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(255, 255, 255));
    jLabel2.setText("Ingrese los datos que se le solicitan a continuaci??n: ");
    jPanel1.add(jLabel2);
    jLabel2.setBounds(30, 30, 570, 32);

    jPanel2.setOpaque(false);
    jPanel3.setOpaque(false);

    jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 255, 255));
    jLabel3.setText("Nombre Completo:");

    txtNombrePaciente.setBackground(new java.awt.Color(102, 102, 102));
    txtNombrePaciente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    txtNombrePaciente.setForeground(new java.awt.Color(255, 255, 255));
    txtNombrePaciente.setCaretColor(new java.awt.Color(51, 51, 51));

    jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(255, 255, 255));
    jLabel4.setText("C??dula:");

    txtCedulaPaciente.setBackground(new java.awt.Color(102, 102, 102));
    txtCedulaPaciente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    txtCedulaPaciente.setForeground(new java.awt.Color(255, 255, 255));

    jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(255, 255, 255));
    jLabel6.setText("Fecha de Nacimiento:");

    jLabel7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 255, 255));
    jLabel7.setText("Tipo de Sangre:");

    cbSangre.setBackground(new java.awt.Color(102, 102, 102));
    cbSangre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    cbSangre.setForeground(new java.awt.Color(255, 255, 255));
    cbSangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A negativo", "A positivo", "B negativo", "B positivo", "O negativo", "O positivo", "AB negativo", "AB positivo" }));

    dcFechaNacimiento.setBackground(new java.awt.Color(102, 102, 102));
    dcFechaNacimiento.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

    jLabel11.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    jLabel11.setForeground(new java.awt.Color(255, 255, 255));
    jLabel11.setText("Nacionalidad:");

    txtNacionalidad.setBackground(new java.awt.Color(102, 102, 102));
    txtNacionalidad.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    txtNacionalidad.setForeground(new java.awt.Color(255, 255, 255));

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(txtNombrePaciente)
      .addComponent(txtCedulaPaciente)
      .addComponent(cbSangre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(dcFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel3)
          .addComponent(jLabel4)
          .addComponent(jLabel6)
          .addComponent(jLabel7)
          .addComponent(jLabel11))
        .addGap(0, 0, Short.MAX_VALUE))
      .addComponent(txtNacionalidad)
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addComponent(jLabel3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txtNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jLabel4)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txtCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jLabel6)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(dcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jLabel7)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(cbSangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jLabel11)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txtNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 12, Short.MAX_VALUE))
    );

    jPanel1.add(jPanel3);
    jPanel3.setBounds(30, 80, 320, 350);

    jPanel4.setOpaque(false);
    jPanel4.setPreferredSize(new java.awt.Dimension(320, 346));

    jLabel9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 255, 255));
    jLabel9.setText("Contrase??a:");

    passContrasena.setBackground(new java.awt.Color(102, 102, 102));
    passContrasena.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    passContrasena.setForeground(new java.awt.Color(255, 255, 255));

    btnRegistrarPaciente.setBackground(new java.awt.Color(255, 255, 255));
    btnRegistrarPaciente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    btnRegistrarPaciente.setForeground(new java.awt.Color(0, 0, 0));
    btnRegistrarPaciente.setText("Registrar");

    jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(255, 255, 255));
    jLabel8.setText("Tel??fonos:");

    txtTelefono.setBackground(new java.awt.Color(102, 102, 102));
    txtTelefono.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    txtTelefono.setForeground(new java.awt.Color(255, 255, 255));

    btnAgregarTelefono.setBackground(new java.awt.Color(51, 51, 51));
    btnAgregarTelefono.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    btnAgregarTelefono.setForeground(new java.awt.Color(0, 255, 0));
    btnAgregarTelefono.setText("???");
    btnAgregarTelefono.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnAgregarTelefonoActionPerformed(evt);
      }
    });

    listTelefonos.setBackground(new java.awt.Color(102, 102, 102));
    listTelefonos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    listTelefonos.setForeground(new java.awt.Color(255, 255, 255));
    jScrollPane1.setViewportView(listTelefonos);

    jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(255, 255, 255));
    jLabel10.setText("Lugar de Residencia:");

    txtResidencia.setBackground(new java.awt.Color(102, 102, 102));
    txtResidencia.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    txtResidencia.setForeground(new java.awt.Color(255, 255, 255));

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(btnRegistrarPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(passContrasena)
          .addGroup(jPanel4Layout.createSequentialGroup()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarTelefono))
              .addComponent(jLabel9)
              .addComponent(jLabel8)
              .addComponent(jLabel10))
            .addGap(0, 0, Short.MAX_VALUE))
          .addComponent(txtResidencia)
          .addComponent(jScrollPane1))
        .addContainerGap())
    );
    jPanel4Layout.setVerticalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
        .addComponent(jLabel8)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnAgregarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jLabel10)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txtResidencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
        .addComponent(jLabel9)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(passContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(btnRegistrarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(13, 13, 13))
    );

    jPanel1.add(jPanel4);
    jPanel4.setBounds(390, 80, 320, 350);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 3, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnAgregarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTelefonoActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_btnAgregarTelefonoActionPerformed

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
      java.util.logging.Logger.getLogger(RegistroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex)
    {
      java.util.logging.Logger.getLogger(RegistroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex)
    {
      java.util.logging.Logger.getLogger(RegistroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex)
    {
      java.util.logging.Logger.getLogger(RegistroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new RegistroPaciente().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  public javax.swing.JButton btnAgregarTelefono;
  public javax.swing.JButton btnRegistrarPaciente;
  public javax.swing.JComboBox<String> cbSangre;
  public com.toedter.calendar.JDateChooser dcFechaNacimiento;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JScrollPane jScrollPane1;
  public javax.swing.JList<String> listTelefonos;
  public javax.swing.JPasswordField passContrasena;
  public javax.swing.JTextField txtCedulaPaciente;
  public javax.swing.JTextField txtNacionalidad;
  public javax.swing.JTextField txtNombrePaciente;
  public javax.swing.JTextField txtResidencia;
  public javax.swing.JTextField txtTelefono;
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
