/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itson.presentacion;

import com.itson.dao.AutomovilesDAO;
import com.itson.dao.PlacasDAO;
import com.itson.dominio.Automovil;
import com.itson.dominio.Persona;
import com.itson.interfaces.IAutomovilesDAO;
import com.itson.interfaces.IPlacasDAO;
import com.itson.utils.GeneracionPlacas;
import com.itson.utils.TipoAutomovil;

/**
 *
 * @author 
 */
public class FrmAutoNuevo extends javax.swing.JFrame {

    IAutomovilesDAO autosDAO = new AutomovilesDAO();
    Persona persona = null;
    
    /**
     * Creates new form FrmVehiculoNuevo
     */
    public FrmAutoNuevo(Persona persona) {
        this.persona = persona;
        initComponents();
    }

    private void guardar(){
        TipoAutomovil tipo = TipoAutomovil.NUEVO;
        String serie = this.txtSerie.getText();
        String marca = this.txtMarca.getText();
        String color = this.txtColor.getText();
        String modelo = this.txtModelo.getText();
        String linea = this.txtLinea.getText();
        
        autosDAO.insertar(tipo, serie, marca, modelo, color, linea);
    }
    
    private void guardarPlacas(){
        GeneracionPlacas placa = new GeneracionPlacas();
        String placaNueva = placa.generarPlaca();
        float costo = 1500;
        
        Automovil autoConsulta = (Automovil) 
                autosDAO.consultar(this.txtSerie.getText());
        
        IPlacasDAO placaDAO = new PlacasDAO();
        placaDAO.insertar(placaNueva, autoConsulta, persona, costo);
        this.txtNumAlfa.setText(placaNueva);
        this.txtCosto.setText(String.valueOf(costo));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSerie = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        lblLinea = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        txtSerie = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        txtLinea = new javax.swing.JTextField();
        lblRegistroAuto = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnPlacas = new javax.swing.JButton();
        lblCosto = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        lblNumAlfa = new javax.swing.JLabel();
        txtNumAlfa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de automovil");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSerie.setText("Núm. de serie:");
        getContentPane().add(lblSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        lblModelo.setText("Modelo:");
        getContentPane().add(lblModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        lblMarca.setText("Marca:");
        getContentPane().add(lblMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        lblColor.setText("Color:");
        getContentPane().add(lblColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        lblLinea.setText("Linea:");
        getContentPane().add(lblLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        txtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloActionPerformed(evt);
            }
        });
        getContentPane().add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 120, -1));

        txtSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerieActionPerformed(evt);
            }
        });
        getContentPane().add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 120, -1));

        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });
        getContentPane().add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 120, -1));

        txtColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColorActionPerformed(evt);
            }
        });
        getContentPane().add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 120, -1));

        txtLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLineaActionPerformed(evt);
            }
        });
        getContentPane().add(txtLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 120, -1));

        lblRegistroAuto.setText("REGISTRO AUTO NUEVO");
        getContentPane().add(lblRegistroAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, -1, -1));

        btnPlacas.setText("PLACAS");
        btnPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlacasActionPerformed(evt);
            }
        });
        getContentPane().add(btnPlacas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, -1, -1));

        lblCosto.setText("Costo:");
        getContentPane().add(lblCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));
        getContentPane().add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 130, -1));

        lblNumAlfa.setText("Número alfanúmerico:");
        getContentPane().add(lblNumAlfa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));
        getContentPane().add(txtNumAlfa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 130, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModeloActionPerformed

    private void txtSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerieActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColorActionPerformed

    private void txtLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLineaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLineaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        this.guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlacasActionPerformed
        // TODO add your handling code here:
        this.guardarPlacas();
    }//GEN-LAST:event_btnPlacasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnPlacas;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblLinea;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNumAlfa;
    private javax.swing.JLabel lblRegistroAuto;
    private javax.swing.JLabel lblSerie;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNumAlfa;
    private javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
