
package Ventanas;

import Excepciones.*;
import eje3.*;
import java.awt.Color;
import java.io.File;
import javax.swing.ImageIcon;
import static javax.swing.JOptionPane.*;

/**
 *
 * @author TaNiA
 */
public class VP extends javax.swing.JFrame {
    private static File dir = new File("src/Escudos");
    private static String[] ficheros = dir.list();
    private static String escudo;
    private static int cont;
    
    public VP() {
        initComponents();
        setLocationRelativeTo(null);
        llenarCombo();
    }
    
    public void llenarCombo()
    {   
        cdEscudos.removeAllItems();
        
        for (int i = 0; i<ficheros.length;i++)
        {
            cdEscudos.insertItemAt(ficheros[i], i);
        }   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfJugador = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfPuesto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfDorsal = new javax.swing.JTextField();
        bMasJu = new javax.swing.JButton();
        bGrabar = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();
        bEsc = new javax.swing.JButton();
        cdEscudos = new javax.swing.JComboBox<>();
        NombreErr = new javax.swing.JLabel();
        JugadorErr = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Alta de equipos y jugadores");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Nombre del equipo:");

        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Escudo:");

        jLabel4.setText("-------------------------------------Jugadores----------------------------------------------------------------");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Jugador:");

        tfJugador.setEnabled(false);
        tfJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfJugadorActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("Puesto");

        tfPuesto.setEnabled(false);
        tfPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPuestoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setText("Dorsal:");

        tfDorsal.setEnabled(false);
        tfDorsal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDorsalActionPerformed(evt);
            }
        });

        bMasJu.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        bMasJu.setText("Más jugadores");
        bMasJu.setEnabled(false);
        bMasJu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMasJuActionPerformed(evt);
            }
        });

        bGrabar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        bGrabar.setText("Grabar");
        bGrabar.setEnabled(false);
        bGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGrabarActionPerformed(evt);
            }
        });

        bSalir.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        bEsc.setBorder(null);
        bEsc.setEnabled(false);

        cdEscudos.setEnabled(false);
        cdEscudos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cdEscudosActionPerformed(evt);
            }
        });

        NombreErr.setForeground(new java.awt.Color(204, 0, 0));

        JugadorErr.setForeground(new java.awt.Color(255, 0, 0));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 153));
        jLabel8.setText("*Observacion: Debes dar de alta al menos a 3 jugadores");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(57, 57, 57)
                                .addComponent(tfDorsal, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(bMasJu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bGrabar)
                        .addGap(18, 18, 18)
                        .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addGap(152, 152, 152))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cdEscudos, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bEsc, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(NombreErr))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(JugadorErr))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreErr))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bEsc, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cdEscudos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(tfDorsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(JugadorErr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bMasJu)
                    .addComponent(bGrabar)
                    .addComponent(bSalir))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cdEscudosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdEscudosActionPerformed
        if (cdEscudos.getSelectedIndex() != -1)
        {
            int x = cdEscudos.getSelectedIndex();
            ImageIcon imagen = new ImageIcon(dir + "/" +ficheros[x]);

            escudo = ficheros[x];

            bEsc.setEnabled(true);
            bEsc.setIcon(imagen);
            cdEscudos.setEnabled(false);
            tfJugador.setEnabled(true);
            tfJugador.requestFocus();
        }
    }//GEN-LAST:event_cdEscudosActionPerformed

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
        try
        {
            cont = 0;
            if (tfNombre.getText().isEmpty())
                throw new DatoNoValido("CAMPO OBLIGATORIO");
            
            if (!Eje3.comprobarexpresionregu(tfNombre.getText().toUpperCase(),"^[A-Z]+( [A-Z]+)*$"))
                throw new DatoNoValido("SOLO LETRAS");
            
            if (!Eje3.comprobarnombre(tfNombre.getText().toUpperCase()))
                throw new DatoNoValido("EQUIPO YA CREADO");
            
            NombreErr.setText("");
            tfNombre.setBackground(Color.WHITE);
            tfNombre.setEnabled(false);
            cdEscudos.setEnabled(true);
            cdEscudos.requestFocus();
        }
        catch (DatoNoValido dnv)
        {
            NombreErr.setText(dnv.getCampo());
            tfNombre.setBackground(Color.RED);
        }      
    }//GEN-LAST:event_tfNombreActionPerformed

    private void tfJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfJugadorActionPerformed
        try
        {
            if (tfJugador.getText().isEmpty())
                throw new DatoNoValido("CAMPO OBLIGATORIO");
           
            if (!Eje3.comprobarexpresionregu(tfJugador.getText().toUpperCase(), "^[A-Z]+( [A-Z]+){2}$"))
                    throw new DatoNoValido("INDICA NOMBRE Y APELLIDOS (SOLO LETRAS)");
            
            if (!Eje3.comprobarnombrejugador(tfJugador.getText().toUpperCase()))
                throw new DatoNoValido("ESTE JUGADOR YA ESTA INTRODUCIDO");
            
            if (!Eje3.comprobarsiestarepetido(tfJugador.getText().toUpperCase()))
                throw new DatoNoValido("ESTE JUGADOR YA ESTA INSCRITO EN OTRO EQUIPO");
            
            continuar(tfJugador,tfPuesto);
        }
        catch (DatoNoValido dnv)
        {
            JugadorErr.setText(dnv.getCampo());
            tfJugador.setBackground(Color.RED);
        }
    }//GEN-LAST:event_tfJugadorActionPerformed

    private void tfPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPuestoActionPerformed
        try
        {
            if (tfPuesto.getText().isEmpty())
                throw new DatoNoValido("CAMPO OBLIGATORIO");
            
            if (!Eje3.comprobarpuesto(tfPuesto.getText().toUpperCase()))
                throw new DatoNoValido("PUESTO INDICADO NO CORRECTO");
            
            continuar(tfPuesto,tfDorsal);
        }
        catch (DatoNoValido dnv)
        {
            JugadorErr.setText(dnv.getCampo());
            tfPuesto.setBackground(Color.RED);
        }
    }//GEN-LAST:event_tfPuestoActionPerformed

    private void tfDorsalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDorsalActionPerformed
        try
        {
            if (tfDorsal.getText().isEmpty())
                throw new DatoNoValido("CAMPO OBLIGATORIO");
            
            if (!Eje3.comprobardorsal(tfDorsal.getText()))
                throw new DatoNoValido("ESTE DORSAL YA ESTA INTRODUCIDO"); 
            
            if (!Eje3.comprobarexpresionregu(tfDorsal.getText(),"^[1-9][0-9]?$"))
                throw new DatoNoValido("EL DORSAL SOLO PUEDE TENER 1 O 2 DIGITOS");
            
            bMasJu.setEnabled(true);
            tfDorsal.setEnabled(false);
            tfDorsal.setBackground(Color.WHITE);
            JugadorErr.setText("");
        }
        catch (DatoNoValido dnv)
        {
            JugadorErr.setText(dnv.getCampo());
            tfDorsal.setBackground(Color.RED);
        }
    }//GEN-LAST:event_tfDorsalActionPerformed

    private void bMasJuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMasJuActionPerformed
        cont ++;
        Eje3.añadirjugador(tfJugador.getText().toUpperCase(),tfPuesto.getText().toUpperCase(),tfDorsal.getText());
        limpiarjugador();
        
        if (cont >= 3)
            bGrabar.setEnabled(true);
    }//GEN-LAST:event_bMasJuActionPerformed

    private void bGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGrabarActionPerformed
        if(Eje3.grabar(tfNombre.getText().toUpperCase(),escudo))
           showMessageDialog(this,"¡INSCRIPCION CORRECTA!");
        limpiar();
    }//GEN-LAST:event_bGrabarActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        int y = Eje3.capacidadequipos();
        
        if (y == 0)
        {   
            showMessageDialog(this,"NO HAY EQUIPOS INSCRITOS");
            System.exit(0);
        }
        
        Eje3.salir();
    }//GEN-LAST:event_bSalirActionPerformed

    public void limpiar()
    {
        tfNombre.setText("");
        tfNombre.setEnabled(true);
        tfNombre.requestFocus();
        bEsc.setIcon(null);
        llenarCombo();
        bEsc.setEnabled(false);
        bMasJu.setEnabled(false);
        bGrabar.setEnabled(false);
    }
    
    public void limpiarjugador()
    {
        tfJugador.setText("");
        tfJugador.setEnabled(true);
        tfJugador.requestFocus();
        tfPuesto.setText("");
        tfDorsal.setText("");
        bMasJu.setEnabled(false);
    }
    
    public void continuar(javax.swing.JTextField j,javax.swing.JTextField p)
    {
        j.setBackground(Color.WHITE);
        JugadorErr.setText("");
        j.setEnabled(false);
        p.setEnabled(true);
        p.requestFocus();
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JugadorErr;
    private javax.swing.JLabel NombreErr;
    private javax.swing.JButton bEsc;
    private javax.swing.JButton bGrabar;
    private javax.swing.JButton bMasJu;
    private javax.swing.JButton bSalir;
    private javax.swing.JComboBox<String> cdEscudos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField tfDorsal;
    private javax.swing.JTextField tfJugador;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfPuesto;
    // End of variables declaration//GEN-END:variables
}
