
package com.itson.presentacion;

import com.itson.dao.*;
import com.itson.dominio.*;
import com.itson.interfaces.*;
import com.itson.utils.Busqueda;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class FrmPrincipal extends javax.swing.JFrame {

    private Busqueda params;
    Persona persona = null;
    
    /**
     * Creates new form Principal
     */
    public FrmPrincipal() {
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

        btnLicencia = new javax.swing.JButton();
        btnPlacas = new javax.swing.JButton();
        btnConsultaTramite = new javax.swing.JButton();
        btnInsertarClientes = new javax.swing.JButton();
        btnReporteTramite = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblMenu = new javax.swing.JLabel();
        lblTramites = new javax.swing.JLabel();
        lblConsultas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú principal");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLicencia.setBackground(new java.awt.Color(255, 90, 130));
        btnLicencia.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        btnLicencia.setForeground(new java.awt.Color(255, 255, 255));
        btnLicencia.setText("LICENCIA");
        btnLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLicenciaActionPerformed(evt);
            }
        });
        getContentPane().add(btnLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        btnPlacas.setBackground(new java.awt.Color(255, 90, 130));
        btnPlacas.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        btnPlacas.setForeground(new java.awt.Color(255, 255, 255));
        btnPlacas.setText("PLACAS");
        btnPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlacasActionPerformed(evt);
            }
        });
        getContentPane().add(btnPlacas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        btnConsultaTramite.setBackground(new java.awt.Color(255, 90, 130));
        btnConsultaTramite.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        btnConsultaTramite.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultaTramite.setText("CONSULTAR TRÁMITES");
        btnConsultaTramite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaTramiteActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsultaTramite, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, -1, -1));

        btnInsertarClientes.setBackground(new java.awt.Color(255, 90, 130));
        btnInsertarClientes.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        btnInsertarClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertarClientes.setText("INSERTAR CLIENTES");
        btnInsertarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarClientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsertarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        btnReporteTramite.setBackground(new java.awt.Color(255, 90, 130));
        btnReporteTramite.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        btnReporteTramite.setForeground(new java.awt.Color(255, 255, 255));
        btnReporteTramite.setText("REPORTE DE TRÁMITES");
        btnReporteTramite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteTramiteActionPerformed(evt);
            }
        });
        getContentPane().add(btnReporteTramite, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, -1, -1));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 20, 400));

        jPanel2.setBackground(new java.awt.Color(255, 143, 143));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMenu.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblMenu.setForeground(new java.awt.Color(255, 255, 255));
        lblMenu.setText("MENÚ PRINCIPAL");
        jPanel2.add(lblMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 90));

        lblTramites.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        lblTramites.setText("TRÁMITES");
        getContentPane().add(lblTramites, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, 30));

        lblConsultas.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        lblConsultas.setText("CONSULTAS");
        getContentPane().add(lblConsultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, -1, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlacasActionPerformed
//        // TODO add your handling code here:
        FrmConsultaPersona frm = new FrmConsultaPersona();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPlacasActionPerformed

    private void btnConsultaTramiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaTramiteActionPerformed
        // TODO add your handling code here:
        FrmConsulta frmConsulta= new FrmConsulta();
        frmConsulta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnConsultaTramiteActionPerformed

    private void btnInsertarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarClientesActionPerformed
        // TODO add your handling code here:
        IPersonasDAO personaDAO = new PersonasDAO();
        personaDAO.insertar();
    }//GEN-LAST:event_btnInsertarClientesActionPerformed

    private void btnReporteTramiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteTramiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReporteTramiteActionPerformed

    private void btnLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLicenciaActionPerformed
        // TODO add your handling code here:
          FrmLicencia frm = new FrmLicencia();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLicenciaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultaTramite;
    private javax.swing.JButton btnInsertarClientes;
    private javax.swing.JButton btnLicencia;
    private javax.swing.JButton btnPlacas;
    private javax.swing.JButton btnReporteTramite;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblConsultas;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblTramites;
    // End of variables declaration//GEN-END:variables
}

