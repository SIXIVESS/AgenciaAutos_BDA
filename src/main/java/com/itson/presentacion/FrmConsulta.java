package com.itson.presentacion;

import com.itson.dao.PersonasDAO;
import com.itson.dominio.Persona;
import com.itson.interfaces.IPersonasDAO;
import com.itson.utils.Busqueda;
import com.itson.utils.FormatoPaginas;
import com.itson.utils.Renderizacion;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author
 */
public class FrmConsulta extends javax.swing.JPanel {

    //Objeto tipo persona
    IPersonasDAO personasDAO = new PersonasDAO();
    private final FormatoPaginas formato;

    /**
     * Creates new form FrmConsulta
     */
    public FrmConsulta() {
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTramites = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtFechaNac = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnAvanzar = new javax.swing.JToggleButton();
        btnRetroceder = new javax.swing.JToggleButton();
        cbxElementosPag = new javax.swing.JComboBox<>();

        jLabel1.setText("CONSULTA DE TRÁMITES");
        jLabel1.setToolTipText("");

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
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
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
        tblTramites.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTramitesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTramites);

        jLabel2.setText("NOMBRE:");

        jLabel4.setText("AÑO DE NACIMIENTO:");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtFechaNac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNacActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAvanzar.setText(">>");
        btnAvanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarActionPerformed(evt);
            }
        });

        btnRetroceder.setText("<<");
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });

        cbxElementosPag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "4", "6" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalir)
                        .addGap(27, 27, 27)
                        .addComponent(btnAceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(588, 588, 588)
                        .addComponent(btnRetroceder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAvanzar)))
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cbxElementosPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRetroceder)
                    .addComponent(btnAvanzar)
                    .addComponent(cbxElementosPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnAceptar))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaNacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaNacActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

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
                    this.dispose();
                }catch(PersistenceException ex){
                    Logger.getLogger(FrmConsulta.class.
                            getName()).log(Level.SEVERE,null,ex);
                    
                }
            }
        }
    }//GEN-LAST:event_tblTramitesMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        FrmPrincipal frm = new FrmPrincipal();
        frm.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JToggleButton btnAvanzar;
    private javax.swing.JToggleButton btnRetroceder;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxElementosPag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTramites;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
