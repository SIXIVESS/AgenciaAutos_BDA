
package com.itson.presentacion;

import com.itson.dao.PersonasDAO;
import com.itson.dominio.*;
import com.itson.interfaces.*;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class FrmPrincipal extends javax.swing.JFrame {

//    Persona persona = null;
//    private final IPersonasDAO personaDAO;
//    private final ILicenciasDAO licenciaDAO;
    /**
     * Creates new form Principal
     */
    public FrmPrincipal() {
        initComponents();
//        this.personaDAO = personaDAO;
//        this.licenciaDAO = licenciaDAO;
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnLicencia = new javax.swing.JButton();
        btnPlacas = new javax.swing.JButton();
        btnConsultaTramite = new javax.swing.JButton();
        btnInsertarClientes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnReporteTramite1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(242, 243, 245));

        btnLicencia.setBackground(new java.awt.Color(255, 143, 143));
        btnLicencia.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnLicencia.setForeground(new java.awt.Color(255, 255, 255));
        btnLicencia.setText("LICENCIA");
        btnLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLicenciaActionPerformed(evt);
            }
        });

        btnPlacas.setBackground(new java.awt.Color(255, 143, 143));
        btnPlacas.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnPlacas.setForeground(new java.awt.Color(255, 255, 255));
        btnPlacas.setText("PLACAS");
        btnPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlacasActionPerformed(evt);
            }
        });

        btnConsultaTramite.setBackground(new java.awt.Color(255, 143, 143));
        btnConsultaTramite.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnConsultaTramite.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultaTramite.setText("CONSULTAR TRÁMITES");
        btnConsultaTramite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaTramiteActionPerformed(evt);
            }
        });

        btnInsertarClientes.setBackground(new java.awt.Color(255, 143, 143));
        btnInsertarClientes.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnInsertarClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertarClientes.setText("INSERTAR CLIENTES");
        btnInsertarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarClientesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel1.setText("TRÁMITES");

        btnReporteTramite1.setBackground(new java.awt.Color(255, 143, 143));
        btnReporteTramite1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnReporteTramite1.setForeground(new java.awt.Color(255, 255, 255));
        btnReporteTramite1.setText("REPORTE DE TRÁMITES");
        btnReporteTramite1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteTramite1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLicencia)
                    .addComponent(btnPlacas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(btnConsultaTramite)
                .addGap(105, 105, 105))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(btnInsertarClientes)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(371, Short.MAX_VALUE)
                    .addComponent(btnReporteTramite1)
                    .addGap(94, 94, 94)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel1)
                .addGap(95, 95, 95)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLicencia)
                    .addComponent(btnConsultaTramite))
                .addGap(45, 45, 45)
                .addComponent(btnPlacas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(btnInsertarClientes)
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(278, Short.MAX_VALUE)
                    .addComponent(btnReporteTramite1)
                    .addGap(133, 133, 133)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlacasActionPerformed
//        // TODO add your handling code here:
//        String rfc = JOptionPane.showInputDialog(null, "Introduce un RFC");
//        Persona personaConsulta = personaDAO.consultar(rfc);
//        if (personaConsulta.getRfc().equalsIgnoreCase(rfc)) {
//            FrmPlaca frm = new FrmPlaca();
//            frm.setVisible(true);
//        } else {
//            JOptionPane.showInputDialog(null, "Persona inexistente", "Error",
//                    JOptionPane.ERROR_MESSAGE);
//        }                                
    }//GEN-LAST:event_btnPlacasActionPerformed

    private void btnConsultaTramiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaTramiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultaTramiteActionPerformed

    private void btnInsertarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarClientesActionPerformed
        // TODO add your handling code here:
        IPersonasDAO personaDAO = new PersonasDAO();
       personaDAO.insertar();
       
    }//GEN-LAST:event_btnInsertarClientesActionPerformed

    private void btnReporteTramite1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteTramite1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReporteTramite1ActionPerformed

    private void btnLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLicenciaActionPerformed
        // TODO add your handling code here:
//        FrmLicencia frm = new FrmLicencia();
//        frm.setVisible(true);
//        String rfc = JOptionPane.showInputDialog(null, "Introduce un RFC");
////        Persona persona = new Persona(rfc);
//        List<Persona> personas = personaDAO.consultarLista(rfc);
//        
//        for (Persona p : personas) {
//            this.persona = p;
//            if (personas.contains(p)) {
//                FrmLicencia frm = new FrmLicencia(p, personaDAO, licenciaDAO);
//                frm.setVisible(true);
//            } else {
//                JOptionPane.showInputDialog(null, "Persona inexistente", "Error",
//                        JOptionPane.ERROR_MESSAGE);
//            }
//        }
FrmLicencia licenciaForm =new FrmLicencia();
licenciaForm.setVisible(true);

    }//GEN-LAST:event_btnLicenciaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultaTramite;
    private javax.swing.JButton btnInsertarClientes;
    private javax.swing.JButton btnLicencia;
    private javax.swing.JButton btnPlacas;
    private javax.swing.JButton btnReporteTramite1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
