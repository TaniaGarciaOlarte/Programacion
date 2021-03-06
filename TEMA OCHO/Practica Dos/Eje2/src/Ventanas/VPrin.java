/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Excepciones.*;
import eje2.*;
import static javax.swing.JOptionPane.*;

/**
 *
 * @author TaNiA
 */
public class VPrin extends javax.swing.JFrame {

    public VPrin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfMatricu = new javax.swing.JTextField();
        tfPropietario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfCod = new javax.swing.JTextField();
        jInte = new javax.swing.JButton();
        tfDesc = new javax.swing.JTextField();
        bAceptar = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();
        jErr = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Alta de multas");

        jLabel2.setText("Matricula");

        tfMatricu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfMatricuFocusLost(evt);
            }
        });

        tfPropietario.setEditable(false);

        jLabel3.setText("Multa");

        tfCod.setEnabled(false);
        tfCod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCodFocusLost(evt);
            }
        });

        jInte.setText("?");
        jInte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jInteActionPerformed(evt);
            }
        });

        tfDesc.setEditable(false);

        bAceptar.setText("Aceptar");
        bAceptar.setEnabled(false);
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        jErr.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfMatricu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfCod, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jErr)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jInte, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(tfDesc))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(bAceptar)
                                    .addGap(50, 50, 50)
                                    .addComponent(bSalir))))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(188, 188, 188))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfMatricu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInte)
                    .addComponent(tfDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jErr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAceptar)
                    .addComponent(bSalir))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jInteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jInteActionPerformed
        Eje2.mostrarvtipo();
    }//GEN-LAST:event_jInteActionPerformed

    private void tfMatricuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfMatricuFocusLost
        try
        {
            String matri = tfMatricu.getText().toUpperCase();

            if (!Eje2.comprobarmatri(matri))
                throw new DatoNoValido("MATRICULA NO EXISTENTE");
            else
            {
                jErr.setText("");
                tfPropietario.setText(Eje2.mostrardni(matri));
                tfCod.setEnabled(true);
                tfMatricu.setEditable(false);
            } 
        }
        catch (DatoNoValido dnv)
        {
            jErr.setText(dnv.getCampo());
            tfPropietario.setText("");
            bAceptar.setEnabled(false);
        }   
    }//GEN-LAST:event_tfMatricuFocusLost

    private void tfCodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodFocusLost
        String cod = tfCod.getText();
        
        if (!Eje2.comprobarcod(cod))
        {
            jErr.setText("CODIGO MULTA INCORRECTO");
            tfDesc.setText("");
        }
        else
        {
            jErr.setText("");
            bAceptar.setEnabled(true);
            tfDesc.setText(Eje2.mostrardesc(cod));
        }
    }//GEN-LAST:event_tfCodFocusLost

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        String cod = tfCod.getText();
        String mat = tfMatricu.getText();
        defecto();
        
        Eje2.añadirdato(cod,mat);
    }//GEN-LAST:event_bAceptarActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        dispose();
        if (!Eje2.mostrarlistado().isEmpty())
            showMessageDialog(this,"LISTADO DE MULTAS IMPUESTAS: \n" + 
                    Eje2.mostrarlistado());
        else
            showMessageDialog(this,"NO HAY NINGUNA MULTA IMPUESTA");
        System.exit(0);
    }//GEN-LAST:event_bSalirActionPerformed

    public void defecto()
    {
        tfCod.setText("");
        tfMatricu.setText("");
        tfDesc.setText("");
        tfPropietario.setText("");
        tfMatricu.setEditable(true);
        tfCod.setEnabled(false);
        bAceptar.setEnabled(false);
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
            java.util.logging.Logger.getLogger(VPrin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VPrin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VPrin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VPrin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VPrin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bSalir;
    private javax.swing.JLabel jErr;
    private javax.swing.JButton jInte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tfCod;
    private javax.swing.JTextField tfDesc;
    private javax.swing.JTextField tfMatricu;
    private javax.swing.JTextField tfPropietario;
    // End of variables declaration//GEN-END:variables
}
