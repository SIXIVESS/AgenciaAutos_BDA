/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itson.presentacion;

import com.itson.dao.PersonasDAO;
import com.itson.dao.TramitesDAO;
import com.itson.dominio.Licencia;
import com.itson.dominio.Persona;
import com.itson.dominio.Tramite;
import com.itson.interfaces.IPersonasDAO;
import com.itson.interfaces.ITramitesDAO;
import com.itson.utils.FormatoPaginas;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author
 */
public class FrmConsulta2 extends javax.swing.JFrame {

    private final FormatoPaginas formato;
    IPersonasDAO personaDao = new PersonasDAO();
    ITramitesDAO tramiteDao = new TramitesDAO();

    /**
     * 
     */
    public void cargar() {
        DefaultTableModel tabla = (DefaultTableModel) this.tblTramites.getModel();
        tabla.setRowCount(0);
        SimpleDateFormat fecha = new SimpleDateFormat("dd/mm/yyy");
        List<Tramite> busqueda = tramiteDao.consultaTramite(this.txtRfc.getText(), formato);
        for (Tramite tramite : busqueda) {
            if (tramite instanceof Licencia) {
                Object[] fila = {"Licencia", tramite.getCosto(), fecha.format(tramite.getFechaEmision())};
                tabla.addRow(fila);
            } else if (tramite instanceof Licencia) {
                Object[] fila = {"Placas", tramite.getCosto(), fecha.format(tramite.getFechaEmision())};
                tabla.addRow(fila);
            }
        }
    }

    /**
     * Método que llena los campos de texto según los datos de la persona dada
     * en el parámetro
     * @param persona Persona de la que se quieren los datos
     */
    public void cargarTexto(Persona persona) {

        Integer fechaNac = persona.getFecha_nacimiento().getYear();

        this.txtRfc.setText(persona.getRfc());
        this.txtNombre.setText(persona.getNombres() + "" + persona.getAp_paterno() + "" + persona.getAp_materno());

        this.txtFechaNac.setText(fechaNac.toString());
        this.txtTelefono.setText(persona.getTelefono());
    }

    public FrmConsulta2(String rfc) throws PersistenceException {
        Persona persona = personaDao.consultar(rfc);
        initComponents();
        this.formato = new FormatoPaginas(2, 0);
        setLocationRelativeTo(null);
        this.cargarTexto(persona);
        this.cargar();

    }

    /**
     * Método que retrocede de página
     */
    private void atras() {
        this.formato.retroceder();
        this.cargar();
    }

    /**
     * Método que avanza de página
     */
    private void sigPagina() {
        this.formato.avanzar();
        this.cargar();
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
        lblConsulta = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblFechaNac = new javax.swing.JLabel();
        txtFechaNac = new javax.swing.JTextField();
        lblRfc = new javax.swing.JLabel();
        txtRfc = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTramites = new javax.swing.JTable();
        cbxElementosPag = new javax.swing.JComboBox<>();
        btnRetroceder = new javax.swing.JToggleButton();
        btnAvanzar = new javax.swing.JToggleButton();
        btnAceptar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 143, 143));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblConsulta.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblConsulta.setForeground(new java.awt.Color(255, 255, 255));
        lblConsulta.setText("CONSULTA DE TRÁMITES");
        jPanel1.add(lblConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        lblNombre.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblNombre.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        lblFechaNac.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblFechaNac.setText("Año de nacimiento:");

        txtFechaNac.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        lblRfc.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblRfc.setText("RFC:");

        txtRfc.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        lblTelefono.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblTelefono.setText("Teléfono:");

        txtTelefono.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        tblTramites.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        tblTramites.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tipo", "Costo", "Fecha de emisión"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTramites.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTramitesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTramites);

        cbxElementosPag.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        cbxElementosPag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "4", "6" }));
        cbxElementosPag.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxElementosPagItemStateChanged(evt);
            }
        });

        btnRetroceder.setBackground(new java.awt.Color(255, 90, 130));
        btnRetroceder.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        btnRetroceder.setForeground(new java.awt.Color(255, 255, 255));
        btnRetroceder.setText("<<");
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });

        btnAvanzar.setBackground(new java.awt.Color(255, 90, 130));
        btnAvanzar.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        btnAvanzar.setForeground(new java.awt.Color(255, 255, 255));
        btnAvanzar.setText(">>");
        btnAvanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarActionPerformed(evt);
            }
        });

        btnAceptar.setBackground(new java.awt.Color(255, 90, 130));
        btnAceptar.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 90, 130));
        btnSalir.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblFechaNac)
                                .addComponent(lblRfc)
                                .addComponent(lblNombre))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(lblTelefono)))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRfc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxElementosPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(458, 458, 458)
                                .addComponent(btnRetroceder)
                                .addGap(22, 22, 22)
                                .addComponent(btnAvanzar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRfc)
                    .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxElementosPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRetroceder)
                    .addComponent(btnAvanzar))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnSalir))
                .addGap(0, 29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblTramitesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTramitesMouseClicked
        // TODO add your handling code here:
        int columna = this.tblTramites.getColumnModel().getColumnIndexAtX(evt.getX());
        int fila = evt.getY() / this.tblTramites.getRowHeight();
        if (fila < this.tblTramites.getRowCount() && fila >= 0
                && columna < this.tblTramites.getColumnCount()
                && columna >= 0) {
            Object valor = this.tblTramites.getValueAt(fila, columna);

            if (valor instanceof JButton) {
                ((JButton) valor).doClick();
                JButton boton = (JButton) valor;
                String rfc = this.tblTramites.getValueAt(fila, 0).toString();
                try {
                    System.out.println(rfc);
                    FrmConsulta2 frm = new FrmConsulta2(rfc);
                    frm.setVisible(true);
                    System.exit(0);
                } catch (PersistenceException ex) {
                    Logger.getLogger(FrmConsulta2.class.
                            getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_tblTramitesMouseClicked

    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        atras();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRetrocederActionPerformed

    private void btnAvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarActionPerformed
        // TODO add your handling code here:
      sigPagina();
    }//GEN-LAST:event_btnAvanzarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        FrmPrincipal frm = new FrmPrincipal();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cbxElementosPagItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxElementosPagItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange()==ItemEvent.SELECTED){
            int elementosPerPag = Integer.parseInt(evt.getItem().toString());
            this.formato.setElementosPerPag(elementosPerPag);
            this.cargar();
        }
    }//GEN-LAST:event_cbxElementosPagItemStateChanged

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
      
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JToggleButton btnAvanzar;
    private javax.swing.JToggleButton btnRetroceder;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxElementosPag;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblConsulta;
    private javax.swing.JLabel lblFechaNac;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRfc;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tblTramites;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRfc;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
