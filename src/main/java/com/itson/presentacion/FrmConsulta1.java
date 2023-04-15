/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itson.presentacion;

import com.itson.dao.PersonasDAO;
import com.itson.dominio.Persona;
import com.itson.interfaces.IPersonasDAO;
import com.itson.utils.Busqueda;
import com.itson.utils.FormatoPaginas;
import com.itson.utils.Renderizacion;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexa
 */
public class FrmConsulta1 extends javax.swing.JFrame {

     //Objeto tipo persona
    IPersonasDAO personasDAO = new PersonasDAO();
    private final FormatoPaginas formato;

    /**
     * Creates new form FrmConsulta
     */
    public FrmConsulta1() {
        initComponents();
        Busqueda busqueda; //Filtros para la búsqueda de personas
        this.tblTramites.setDefaultRenderer(Object.class, new Renderizacion()); //Es para crear el botón con la cual se va a seleccionar la persona
        this.formato = new FormatoPaginas(2, 0);
    }

    public void cargar(Busqueda busqueda) {
        this.tblTramites.setDefaultRenderer(Object.class, new Renderizacion());
        JButton btnSeleccion = new JButton("Selección");
        btnSeleccion.setName("Selección");
        DefaultTableModel tabla = (DefaultTableModel) this.tblTramites.getModel();
        tabla.setRowCount(0);
        List<Persona> busquedaPersona = personasDAO.consultarListaBusqueda(busqueda, formato);

        for (Persona persona : busquedaPersona) {
            Object[] fila = {btnSeleccion, persona.getNombres() + " " + persona.getAp_paterno() + " " + persona.getAp_materno(),
                persona.getRfc(), persona.getFecha_nacimiento()};
            tabla.addRow(fila);
        }
        this.tblTramites.setModel(tabla);
    }
    private void atras(Busqueda busqueda){
        this.formato.retroceder();
        this.cargar(busqueda);
    }
    
    private void sigPagina(Busqueda busqueda){
        this.formato.avanzar();
        this.cargar(busqueda);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTramites = new javax.swing.JTable();
        lblNombre = new javax.swing.JLabel();
        lblAnioNacimiento = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtFechaNac = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnAvanzar = new javax.swing.JToggleButton();
        btnRetroceder = new javax.swing.JToggleButton();
        cbxElementosPag = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        lblConsulta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblTramites.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        tblTramites.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Selección", "Nombre", "RFC", "Fecha de nacimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTramites.setAlignmentX(1.0F);
        tblTramites.setAlignmentY(1.0F);
        tblTramites.setRowHeight(40);
        tblTramites.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTramitesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTramites);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 648, 169));

        lblNombre.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblNombre.setText("Nombre:");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));

        lblAnioNacimiento.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblAnioNacimiento.setText("Año de nacimiento:");
        jPanel1.add(lblAnioNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, 32));

        txtNombre.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 168, -1));

        txtFechaNac.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        txtFechaNac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNacActionPerformed(evt);
            }
        });
        jPanel1.add(txtFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 168, -1));

        btnAceptar.setBackground(new java.awt.Color(255, 90, 130));
        btnAceptar.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("");
        btnAceptar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnAceptarbtnRetrocederItemStateChanged(evt);
            }
        });
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 520, -1, -1));

        btnSalir.setBackground(new java.awt.Color(255, 90, 130));
        btnSalir.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnSalirbtnRetrocederItemStateChanged(evt);
            }
        });
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 520, -1, -1));

        btnAvanzar.setBackground(new java.awt.Color(255, 90, 130));
        btnAvanzar.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        btnAvanzar.setForeground(new java.awt.Color(255, 255, 255));
        btnAvanzar.setText(">>");
        btnAvanzar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnAvanzarbtnRetrocederItemStateChanged(evt);
            }
        });
        btnAvanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAvanzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 450, -1, -1));

        btnRetroceder.setBackground(new java.awt.Color(255, 90, 130));
        btnRetroceder.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        btnRetroceder.setForeground(new java.awt.Color(255, 255, 255));
        btnRetroceder.setText("<<");
        btnRetroceder.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnRetrocederItemStateChanged(evt);
            }
        });
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });
        jPanel1.add(btnRetroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 450, -1, -1));

        cbxElementosPag.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        cbxElementosPag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "4", "6" }));
        cbxElementosPag.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxElementosPagItemStateChanged(evt);
            }
        });
        cbxElementosPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxElementosPagActionPerformed(evt);
            }
        });
        jPanel1.add(cbxElementosPag, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 143, 143));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblConsulta.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblConsulta.setForeground(new java.awt.Color(255, 255, 255));
        lblConsulta.setText("CONSULTA DE TRÁMITES");
        jPanel2.add(lblConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 761, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblTramitesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTramitesMouseClicked
        // TODO add your handling code here:
        int columna=this.tblTramites.getColumnModel().getColumnIndexAtX(evt.getX());
        int fila = evt.getY()/this.tblTramites.getRowHeight();
        if(fila<this.tblTramites.getRowCount() && fila >=0
            && columna < this.tblTramites.getColumnCount()
            && columna >=0){
            Object valor = this.tblTramites.getValueAt(fila, columna);

            if (valor instanceof JButton){
                ((JButton)valor).doClick();
                JButton boton = (JButton) valor;
                String rfc = this.tblTramites.getValueAt(fila, 0).toString();
                try{
                    System.out.println(rfc);
                    FrmConsulta2 frm = new FrmConsulta2(rfc);
                    frm.setVisible(true);
                    System.exit(0);
                }catch(PersistenceException ex){
                    Logger.getLogger(FrmConsulta1.class.
                        getName()).log(Level.SEVERE,null,ex);

                }
            }
        }
    }//GEN-LAST:event_tblTramitesMouseClicked

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        ////        kk
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtFechaNacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaNacActionPerformed

    private void btnAceptarbtnRetrocederItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnAceptarbtnRetrocederItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarbtnRetrocederItemStateChanged

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        String nombre = this.txtNombre.getText();
        Integer fechaNac;

        if (this.txtFechaNac.getText().equals("")) {
            fechaNac = null;
        } else {
            fechaNac = Integer.valueOf(this.txtFechaNac.getText());
        }

        if (nombre.equals("") && fechaNac == null) {
            JOptionPane.showMessageDialog(null, "Campos incompletos",
                "Mucho ojo", JOptionPane.ERROR);
        }
        Busqueda busqueda = new Busqueda(nombre, fechaNac);
        this.cargar(busqueda);
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnSalirbtnRetrocederItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnSalirbtnRetrocederItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirbtnRetrocederItemStateChanged

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        FrmPrincipal frm = new FrmPrincipal();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAvanzarbtnRetrocederItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnAvanzarbtnRetrocederItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAvanzarbtnRetrocederItemStateChanged

    private void btnAvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarActionPerformed
        // TODO add your handling code here:
        String nombre = this.txtNombre.getText();
        Integer fechaNac;

        if (this.txtFechaNac.getText().equals("")) {
            fechaNac = null;
        } else {
            fechaNac = Integer.valueOf(this.txtFechaNac.getText());
        }
        Busqueda busqueda = new Busqueda(nombre, fechaNac);
        sigPagina(busqueda);
    }//GEN-LAST:event_btnAvanzarActionPerformed

    private void btnRetrocederItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnRetrocederItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRetrocederItemStateChanged

    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        String nombre = this.txtNombre.getText();
        Integer fechaNac;

        if (this.txtFechaNac.getText().equals("")) {
            fechaNac = null;
        } else {
            fechaNac = Integer.valueOf(this.txtFechaNac.getText());
        }
        Busqueda busqueda = new Busqueda(nombre, fechaNac);
        atras(busqueda);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRetrocederActionPerformed

    private void cbxElementosPagItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxElementosPagItemStateChanged
        // TODO add your handling code here:
        String nombre = this.txtNombre.getText();
        Integer fechaNac;

        if (this.txtFechaNac.getText().equals("")) {
            fechaNac = null;
        } else {
            fechaNac = Integer.valueOf(this.txtFechaNac.getText());
        }
        Busqueda busqueda = new Busqueda(nombre, fechaNac);
        if(evt.getStateChange()==ItemEvent.SELECTED){
            int elementosPerPag = Integer.parseInt(evt.getItem().toString());
            this.formato.setElementosPerPag(elementosPerPag);
            this.cargar(busqueda);
        }

    }//GEN-LAST:event_cbxElementosPagItemStateChanged

    private void cbxElementosPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxElementosPagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxElementosPagActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JToggleButton btnAvanzar;
    private javax.swing.JToggleButton btnRetroceder;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxElementosPag;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnioNacimiento;
    private javax.swing.JLabel lblConsulta;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblTramites;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
