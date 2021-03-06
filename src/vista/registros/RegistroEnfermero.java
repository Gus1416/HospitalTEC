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
public class RegistroEnfermero extends javax.swing.JFrame {
  FondoPanel fondo = new FondoPanel();

  /**
   * Creates new form RegistroEnfermero
   */
  public RegistroEnfermero() {
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

    buttonGroup1 = new javax.swing.ButtonGroup();
    buttonGroup2 = new javax.swing.ButtonGroup();
    jPanel1 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    jPanel3 = new javax.swing.JPanel();
    jLabel3 = new javax.swing.JLabel();
    txtNombreEnfermero = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    txtCedulaEnfermero = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    cbAreas = new javax.swing.JComboBox<>();
    cbCentroAtencion = new javax.swing.JComboBox<>();
    jPanel4 = new javax.swing.JPanel();
    jLabel8 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    passContrasena = new javax.swing.JPasswordField();
    btnRegistrarEnfermero = new javax.swing.JButton();
    jPanel5 = new javax.swing.JPanel();
    rbOpcionSi = new javax.swing.JRadioButton();
    rbOpcionNo = new javax.swing.JRadioButton();
    jLabel10 = new javax.swing.JLabel();
    jPanel6 = new javax.swing.JPanel();
    rbOpcionSi1 = new javax.swing.JRadioButton();
    rbOpcionNo1 = new javax.swing.JRadioButton();
    jPanel2 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();

    buttonGroup1.add(rbOpcionSi);
    buttonGroup1.add(rbOpcionNo);

    buttonGroup2.add(rbOpcionSi1);
    buttonGroup2.add(rbOpcionNo1);

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

    txtNombreEnfermero.setBackground(new java.awt.Color(102, 102, 102));
    txtNombreEnfermero.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    txtNombreEnfermero.setForeground(new java.awt.Color(255, 255, 255));
    txtNombreEnfermero.setCaretColor(new java.awt.Color(51, 51, 51));

    jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(255, 255, 255));
    jLabel4.setText("C??dula:");

    txtCedulaEnfermero.setBackground(new java.awt.Color(102, 102, 102));
    txtCedulaEnfermero.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    txtCedulaEnfermero.setForeground(new java.awt.Color(255, 255, 255));

    jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(255, 255, 255));
    jLabel6.setText("??rea:");

    jLabel7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 255, 255));
    jLabel7.setText("Centro de Atenci??n:");

    cbAreas.setBackground(new java.awt.Color(102, 102, 102));
    cbAreas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    cbAreas.setForeground(new java.awt.Color(255, 255, 255));

    cbCentroAtencion.setBackground(new java.awt.Color(102, 102, 102));
    cbCentroAtencion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    cbCentroAtencion.setForeground(new java.awt.Color(255, 255, 255));

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(txtNombreEnfermero)
      .addComponent(txtCedulaEnfermero)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel3)
          .addComponent(jLabel4)
          .addComponent(jLabel6)
          .addComponent(jLabel7))
        .addGap(0, 162, Short.MAX_VALUE))
      .addComponent(cbAreas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(cbCentroAtencion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addComponent(jLabel3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txtNombreEnfermero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jLabel4)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txtCedulaEnfermero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jLabel6)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(cbAreas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jLabel7)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(cbCentroAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 14, Short.MAX_VALUE))
    );

    jPanel1.add(jPanel3);
    jPanel3.setBounds(30, 80, 320, 290);

    jPanel4.setOpaque(false);
    jPanel4.setPreferredSize(new java.awt.Dimension(320, 346));

    jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(255, 255, 255));
    jLabel8.setText("??Ha tenido personas a su cargo?");

    jLabel9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 255, 255));
    jLabel9.setText("Contrase??a:");

    passContrasena.setBackground(new java.awt.Color(102, 102, 102));
    passContrasena.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    passContrasena.setForeground(new java.awt.Color(255, 255, 255));

    btnRegistrarEnfermero.setBackground(new java.awt.Color(255, 255, 255));
    btnRegistrarEnfermero.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    btnRegistrarEnfermero.setForeground(new java.awt.Color(0, 0, 0));
    btnRegistrarEnfermero.setText("Registrar");

    jPanel5.setBackground(new java.awt.Color(102, 102, 102));
    jPanel5.setOpaque(false);
    jPanel5.setLayout(null);

    rbOpcionSi.setBackground(new java.awt.Color(102, 102, 102));
    rbOpcionSi.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    rbOpcionSi.setForeground(new java.awt.Color(255, 255, 255));
    rbOpcionSi.setText("Si");
    jPanel5.add(rbOpcionSi);
    rbOpcionSi.setBounds(0, 0, 130, 20);

    rbOpcionNo.setBackground(new java.awt.Color(102, 102, 102));
    rbOpcionNo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    rbOpcionNo.setForeground(new java.awt.Color(255, 255, 255));
    rbOpcionNo.setText("No");
    jPanel5.add(rbOpcionNo);
    rbOpcionNo.setBounds(130, 0, 140, 20);

    jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(255, 255, 255));
    jLabel10.setText("??Tiene experiencia en capacitaciones?");

    jPanel6.setBackground(new java.awt.Color(102, 102, 102));
    jPanel6.setOpaque(false);
    jPanel6.setLayout(null);

    rbOpcionSi1.setBackground(new java.awt.Color(102, 102, 102));
    rbOpcionSi1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    rbOpcionSi1.setForeground(new java.awt.Color(255, 255, 255));
    rbOpcionSi1.setText("Si");
    jPanel6.add(rbOpcionSi1);
    rbOpcionSi1.setBounds(0, 0, 130, 20);

    rbOpcionNo1.setBackground(new java.awt.Color(102, 102, 102));
    rbOpcionNo1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    rbOpcionNo1.setForeground(new java.awt.Color(255, 255, 255));
    rbOpcionNo1.setText("No");
    jPanel6.add(rbOpcionNo1);
    rbOpcionNo1.setBounds(130, 0, 140, 20);

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(btnRegistrarEnfermero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(0, 8, Short.MAX_VALUE))
      .addComponent(passContrasena)
    );
    jPanel4Layout.setVerticalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
        .addComponent(jLabel8)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jLabel10)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jLabel9)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(passContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(29, 29, 29)
        .addComponent(btnRegistrarEnfermero, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel1.add(jPanel4);
    jPanel4.setBounds(390, 80, 320, 280);

    jPanel2.setOpaque(false);

    jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setText("<html>Registro de Enfermeros</html>");

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

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(501, Short.MAX_VALUE)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
      .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

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
      java.util.logging.Logger.getLogger(RegistroEnfermero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex)
    {
      java.util.logging.Logger.getLogger(RegistroEnfermero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex)
    {
      java.util.logging.Logger.getLogger(RegistroEnfermero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex)
    {
      java.util.logging.Logger.getLogger(RegistroEnfermero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new RegistroEnfermero().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  public javax.swing.JButton btnRegistrarEnfermero;
  public javax.swing.ButtonGroup buttonGroup1;
  public javax.swing.ButtonGroup buttonGroup2;
  public javax.swing.JComboBox<String> cbAreas;
  public javax.swing.JComboBox<String> cbCentroAtencion;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
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
  private javax.swing.JPanel jPanel5;
  private javax.swing.JPanel jPanel6;
  public javax.swing.JPasswordField passContrasena;
  public javax.swing.JRadioButton rbOpcionNo;
  public javax.swing.JRadioButton rbOpcionNo1;
  public javax.swing.JRadioButton rbOpcionSi;
  public javax.swing.JRadioButton rbOpcionSi1;
  public javax.swing.JTextField txtCedulaEnfermero;
  public javax.swing.JTextField txtNombreEnfermero;
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
