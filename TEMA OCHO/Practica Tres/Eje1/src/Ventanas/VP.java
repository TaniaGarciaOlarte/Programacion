/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Excepciones.*;
import eje1.*;
import java.awt.Color;
import java.util.regex.*;
import static javax.swing.JOptionPane.*;

/**
 *
 * @author TaNiA
 */
public class VP extends javax.swing.JFrame {

    private int unidades;
    private double preciocomp;
    
    //Primera vez que se visualiza o no la ventana para mostrar la informacion
        private boolean primeravez = true;

    public VP() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    public VP(boolean valor)
    {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        primeravez = valor;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Produ = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfUnidades = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jrCompra = new javax.swing.JRadioButton();
        jrVenta = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfPreCom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jcProvee = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tfImporCom = new javax.swing.JTextField();
        PrecioErr = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tfPreVent = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfCliente = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jcVolumen = new javax.swing.JCheckBox();
        jcPronPago = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        tfImportVenta = new javax.swing.JTextField();
        ClienteErr = new javax.swing.JLabel();
        bAceptar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        NombreErr = new javax.swing.JLabel();
        UniErr = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("ALMACEN");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Nombre del producto");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Unidades");

        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });

        tfUnidades.setEnabled(false);
        tfUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUnidadesActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operaciones a contabilizar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(51, 51, 255))); // NOI18N

        Produ.add(jrCompra);
        jrCompra.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jrCompra.setText("Compra");
        jrCompra.setEnabled(false);
        jrCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrCompraActionPerformed(evt);
            }
        });

        Produ.add(jrVenta);
        jrVenta.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jrVenta.setText("Venta");
        jrVenta.setEnabled(false);
        jrVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jrCompra)
                .addGap(92, 92, 92)
                .addComponent(jrVenta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrVenta)
                    .addComponent(jrCompra))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos sobre la compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Precio");

        tfPreCom.setEnabled(false);
        tfPreCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPreComActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Proveedor");

        jcProvee.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("Importe de la compra:");

        tfImporCom.setEnabled(false);

        PrecioErr.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfPreCom, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PrecioErr))
                            .addComponent(jcProvee, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfImporCom, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfPreCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrecioErr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcProvee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfImporCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos sobre la venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setText("Precio");

        tfPreVent.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel8.setText("Cliente");

        tfCliente.setEnabled(false);
        tfCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfClienteActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descuentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(51, 51, 255))); // NOI18N

        jcVolumen.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jcVolumen.setText("Por Volumen");
        jcVolumen.setEnabled(false);
        jcVolumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcVolumenActionPerformed(evt);
            }
        });

        jcPronPago.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jcPronPago.setText("Por pronto pago");
        jcPronPago.setEnabled(false);
        jcPronPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcPronPagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jcVolumen)
                .addGap(65, 65, 65)
                .addComponent(jcPronPago)
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jcPronPago)
                .addComponent(jcVolumen))
        );

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel9.setText("Importe de la venta:");

        tfImportVenta.setEnabled(false);

        ClienteErr.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfPreVent, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(tfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ClienteErr))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(tfImportVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfPreVent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClienteErr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfImportVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        bAceptar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        bAceptar.setText("Aceptar");
        bAceptar.setEnabled(false);
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        bCancelar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        NombreErr.setForeground(new java.awt.Color(204, 0, 0));

        UniErr.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(NombreErr))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(UniErr))))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(bAceptar)
                        .addGap(109, 109, 109)
                        .addComponent(bCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jLabel1)))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreErr))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UniErr))
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAceptar)
                    .addComponent(bCancelar))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
        try
        {
            String producto = tfNombre.getText().toUpperCase();
            
            if (producto.isEmpty())
                throw new DatoNoValido("CAMPO OBLIGATORIO");
                        
            if (!Eje1.comprobarproduct(producto))
                throw new DatoNoValido("PRODUCTO INEXISTENTE");
            
            /*Opcional
                Pattern pt = Pattern.compile("^[A-Z]+$");
                Matcher m = pt.matcher(producto);
                if (!m.matches())
                    throw new DatoNoValido("→ SOLO LETRAS");
            */
            
            NombreErr.setText("");
            tfNombre.setBackground(Color.WHITE);
            tfNombre.setEnabled(false);
            tfUnidades.setEnabled(true);
            tfUnidades.requestFocus();
        }
        catch (DatoNoValido dnv)
        {
            NombreErr.setText(dnv.getCampo());
            tfNombre.setBackground(Color.RED);
        }       
    }//GEN-LAST:event_tfNombreActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       if (primeravez)
            showMessageDialog(this,"PULSA EL INTRO PARA CONTINUAR Y VALIDAR EL DATO INTRODUCIDO");
    }//GEN-LAST:event_formWindowOpened

    private void tfUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUnidadesActionPerformed
        try
        {
            if (tfUnidades.getText().isEmpty())
                throw new DatoNoValido("CAMPO OBLIGATORIO");
            
            Pattern pt = Pattern.compile("^[1-9]+[0-9]*$");
            Matcher m = pt.matcher(tfUnidades.getText());
            if (!m.matches())
                throw new DatoNoValido("SOLO NUMEROS A PARTIR DEL 1");
            
            unidades = Integer.parseInt(tfUnidades.getText());
            
            UniErr.setText("");
            tfUnidades.setBackground(Color.WHITE);
            jrCompra.setEnabled(true);
            jrVenta.setEnabled(true);
            tfUnidades.setEnabled(false);
        }
        catch (DatoNoValido dnv)
        {
            UniErr.setText(dnv.getCampo());
            tfUnidades.setBackground(Color.RED);
        }
        catch (NumberFormatException nfe)
        {
            UniErr.setText("SOLO NUMEROS");
            tfUnidades.setBackground(Color.RED);
        }
    }//GEN-LAST:event_tfUnidadesActionPerformed

    private void jrVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrVentaActionPerformed
        if (!Eje1.comprobaruni(unidades))
        {
            showMessageDialog(this,"NO HAY UNIDADES");
            tfUnidades.setEnabled(true);
            tfUnidades.requestFocus();
            Produ.clearSelection();
            jrVenta.setEnabled(false);
            jrCompra.setEnabled(false);
        }
        else
        {
            habilitarventa();
            jrCompra.setEnabled(false);
        }
    }//GEN-LAST:event_jrVentaActionPerformed

    private void habilitarventa()
    {
        tfCliente.setEnabled(true);
        tfPreVent.setText(String.valueOf(Eje1.preciuni(unidades)) + "€");
        tfCliente.setEnabled(true);
        tfCliente.requestFocus();
        tfImportVenta.setText(String.valueOf(Eje1.preciuni(unidades)) + "€");
    }
    
    private void jrCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrCompraActionPerformed
        habilitarcompra();
        jrVenta.setEnabled(false);
    }//GEN-LAST:event_jrCompraActionPerformed

    private void tfPreComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPreComActionPerformed
        try
        {
            if (tfPreCom.getText().isEmpty())
                throw new DatoNoValido("CAMPO OBLIGATORIO");
            
            preciocomp = Double.parseDouble(tfPreCom.getText());
            Eje1.guardarprovee(jcProvee.getSelectedIndex());
            
            PrecioErr.setText("");
            tfPreCom.setBackground(Color.WHITE);
            tfImporCom.setText(String.valueOf(unidades*preciocomp) + "€");
            bAceptar.setEnabled(true);
            bAceptar.requestFocus();
        }
        catch (DatoNoValido dnv)
        {
            PrecioErr.setText(dnv.getCampo());
            tfPreCom.setBackground(Color.RED);
            tfPreCom.requestFocus();
        }
        catch (NumberFormatException nfe)
        {
            PrecioErr.setText("SOLO NUMEROS");
            tfPreCom.setBackground(Color.RED);
            tfPreCom.requestFocus();
        }
    }//GEN-LAST:event_tfPreComActionPerformed

    private void tfClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfClienteActionPerformed
        try
        {
            if (tfCliente.getText().isEmpty())
                throw new DatoNoValido("CAMPO OBLIGATORIO");
            
            Pattern pt = Pattern.compile("^[A-Z]+$");
            Matcher m = pt.matcher(tfCliente.getText().toUpperCase());
            if (!m.matches())
                throw new DatoNoValido("SOLO LETRAS");
            
            tfCliente.setBackground(Color.WHITE);
            ClienteErr.setText("");
            tfCliente.setEditable(false);
            jcVolumen.requestFocus();
            bAceptar.setEnabled(true);
            jcVolumen.setEnabled(true);
            jcPronPago.setEnabled(true);
        }
        catch (DatoNoValido dnv)
        {
            ClienteErr.setText(dnv.getCampo());
            tfCliente.setBackground(Color.RED);
            tfCliente.requestFocus();
        }
    }//GEN-LAST:event_tfClienteActionPerformed

    private void jcVolumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcVolumenActionPerformed
        tfImportVenta.setText(String.valueOf(Eje1.calcularimporte(unidades,jcVolumen.isSelected(),jcPronPago.isSelected())) + "€");
    }//GEN-LAST:event_jcVolumenActionPerformed

    private void jcPronPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcPronPagoActionPerformed
        tfImportVenta.setText(String.valueOf(Eje1.calcularimporte(unidades,jcVolumen.isSelected(),jcPronPago.isSelected())) + "€");
    }//GEN-LAST:event_jcPronPagoActionPerformed

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        if (jrVenta.isSelected())
            Eje1.venta(unidades,tfCliente.getText());
        else
            Eje1.compra(unidades,preciocomp);
        
        bAceptar.setEnabled(false);
    }//GEN-LAST:event_bAceptarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        Eje1.cancelar();
    }//GEN-LAST:event_bCancelarActionPerformed

    public void limpiar()
    {
        //Texto y listas por defecto
            tfNombre.setText("");
            tfUnidades.setText("");
            Produ.clearSelection();
            tfPreCom.setText("");
            tfPreVent.setText("");
            jcProvee.removeAllItems();
            jcVolumen.setSelected(false);
            jcPronPago.setSelected(false);
            tfImportVenta.setText("");
            tfImporCom.setText("");
            tfCliente.setText("");
        
        //Habilitar nombre    
            tfNombre.setEnabled(true);
            tfNombre.requestFocus();
            
        //Deshabilitar opciones
            tfUnidades.setEnabled(false);
            jrCompra.setEnabled(false);
            jrVenta.setEnabled(false);
            tfPreCom.setEnabled(false);
            jcProvee.setEnabled(false);
            tfCliente.setEnabled(false);
            jcVolumen.setEnabled(false);
            jcPronPago.setEnabled(false);
            bAceptar.setEnabled(false);
    }
    
    private void habilitarcompra()
    {
        Eje1.llenarprovee(jcProvee);
        jcProvee.setEnabled(true);
        tfPreCom.setEnabled(true);
        tfPreCom.requestFocus();
        tfImporCom.setText("0€");
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
    private javax.swing.JLabel ClienteErr;
    private javax.swing.JLabel NombreErr;
    private javax.swing.JLabel PrecioErr;
    private javax.swing.ButtonGroup Produ;
    private javax.swing.JLabel UniErr;
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JCheckBox jcPronPago;
    private javax.swing.JComboBox<String> jcProvee;
    private javax.swing.JCheckBox jcVolumen;
    private javax.swing.JRadioButton jrCompra;
    private javax.swing.JRadioButton jrVenta;
    private javax.swing.JTextField tfCliente;
    private javax.swing.JTextField tfImporCom;
    private javax.swing.JTextField tfImportVenta;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfPreCom;
    private javax.swing.JTextField tfPreVent;
    private javax.swing.JTextField tfUnidades;
    // End of variables declaration//GEN-END:variables
}
