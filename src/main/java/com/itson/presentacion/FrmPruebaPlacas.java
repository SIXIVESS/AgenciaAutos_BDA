/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itson.presentacion;

import com.itson.dao.AutomovilesDAO;
import com.itson.dao.LicenciasDAO;
import com.itson.dao.PersonasDAO;
import com.itson.dao.PlacasDAO;
import com.itson.dominio.Automovil;
import com.itson.dominio.Persona;
import com.itson.dominio.Placa;
import com.itson.interfaces.IAutomovilesDAO;
import com.itson.interfaces.ILicenciasDAO;
import com.itson.interfaces.IPersonasDAO;
import com.itson.interfaces.IPlacasDAO;
import com.itson.utils.TipoAutomovil;
import excepciones.PersistenciaException;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexa Soto(236348) y Rosalía Perez (233505)
 */
public class FrmPruebaPlacas extends javax.swing.JFrame {

    private String serie, rfc;

    IPlacasDAO placaDao = new PlacasDAO();
    IAutomovilesDAO automovilDao = new AutomovilesDAO();
    IPersonasDAO personaDao = new PersonasDAO();
    ILicenciasDAO licenciasDao = new LicenciasDAO();

    /**
     * Constructor que inicializa las variables de serie y rfc
     *
     * @param serie
     * @param rfc
     */
    public FrmPruebaPlacas(String serie, String rfc) {
        initComponents();
        this.rfc = rfc;
        this.txtRfc2.setText(rfc);

        this.serie = serie;
        this.txtSerie.setText(serie);
        this.txtSerie.setEditable(false);

        buscarRfc(rfc);
        buscarAuto(serie);
    }

    public FrmPruebaPlacas() {
        initComponents();
    }

    /**
     * Método que busca un auto existente mediante su número de serie
     *
     * @param serie Número de serie del auto
     */
    public void buscarAuto(String serie) {
        TipoAutomovil tipoAuto = new TipoAutomovil();
        Automovil auto = new Automovil();

        //Consulta la placa
        Placa placa = placaDao.consultarActiva(serie);
        //Busca el automovil
        auto = automovilDao.consultar(serie);

        //Campos de texto que se rellenan automaticamente si se encontró el automóvil
        this.txtColor.setText(auto.getColor());
        this.txtLinea.setText(auto.getLinea());
        this.txtMarca.setText(auto.getMarca());
        this.txtModelo.setText(auto.getModelo());
        this.btnGuardar.setEnabled(true);
        //Validaciones
        if (placa != null) {
            //Si no es null, entonces el auto ya existe
            this.txtTipoAuto.setText(String.valueOf(tipoAuto.costoAuto(txtTipoAuto.getText())));
            this.txtTipoAuto.setText("Usado");
        } else {
            this.txtTipoAuto.setText(String.valueOf(tipoAuto.costoAuto(txtTipoAuto.getText())));
            this.txtTipoAuto.setText("Nuevo");
        }

    }

    public void buscarRfc(String rfc) {
        Persona persona = new Persona();
        persona = personaDao.consultar(rfc);

        //Se llenan los campos de texto de manera automática
        txtNombre.setText(persona.getNombres());
        txtApellido.setText(persona.getAp_paterno());

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
        lblAutoNuevo = new javax.swing.JLabel();
        lblDatosPersona = new javax.swing.JLabel();
        lblSerie = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblColor = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblLinea = new javax.swing.JLabel();
        txtLinea = new javax.swing.JTextField();
        lblModelo = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnBuscarSerie = new javax.swing.JButton();
        lblRfc = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        txtRfc2 = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        btnBuscarRfc = new javax.swing.JButton();
        lblDatosAuto1 = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        txtTipoAuto = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 143, 143));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAutoNuevo.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblAutoNuevo.setForeground(new java.awt.Color(255, 255, 255));
        lblAutoNuevo.setText("PLACAS");
        jPanel1.add(lblAutoNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 617, 90));

        lblDatosPersona.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        lblDatosPersona.setText("DATOS CLIENTE");
        getContentPane().add(lblDatosPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 108, -1, -1));

        lblSerie.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblSerie.setText("Núm. de serie:");
        getContentPane().add(lblSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        lblMarca.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblMarca.setText("Marca:");
        getContentPane().add(lblMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 520, -1, -1));

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 218, 170, -1));

        lblColor.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblColor.setText("Color:");
        getContentPane().add(lblColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 570, -1, -1));

        txtApellido.setEditable(false);
        txtApellido.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        getContentPane().add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 275, 170, -1));

        lblLinea.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblLinea.setText("Linea:");
        getContentPane().add(lblLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 620, -1, -1));

        txtLinea.setEditable(false);
        txtLinea.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        getContentPane().add(txtLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 620, 170, -1));

        lblModelo.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblModelo.setText("Modelo:");
        getContentPane().add(lblModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 670, -1, -1));

        txtModelo.setEditable(false);
        txtModelo.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        getContentPane().add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 670, 170, -1));

        btnGuardar.setBackground(new java.awt.Color(255, 90, 130));
        btnGuardar.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 880, -1, -1));

        btnBuscarSerie.setBackground(new java.awt.Color(255, 90, 130));
        btnBuscarSerie.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        btnBuscarSerie.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarSerie.setText("BUSCAR");
        btnBuscarSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarSerieActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, -1, -1));

        lblRfc.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblRfc.setText("RFC:");
        getContentPane().add(lblRfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 171, -1, -1));

        lblApellido.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblApellido.setText("Apellido:");
        getContentPane().add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 279, -1, -1));

        lblNombre.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblNombre.setText("Nombre:");
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 222, -1, -1));

        txtSerie.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        txtSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSerieKeyTyped(evt);
            }
        });
        getContentPane().add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 170, -1));

        txtRfc2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        txtRfc2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRfc2KeyTyped(evt);
            }
        });
        getContentPane().add(txtRfc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 167, 170, -1));

        txtMarca.setEditable(false);
        txtMarca.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        getContentPane().add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, 170, -1));

        txtColor.setEditable(false);
        txtColor.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        getContentPane().add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 560, 170, -1));

        btnBuscarRfc.setBackground(new java.awt.Color(255, 90, 130));
        btnBuscarRfc.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        btnBuscarRfc.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarRfc.setText("BUSCAR");
        btnBuscarRfc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRfcActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarRfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, -1, -1));

        lblDatosAuto1.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        lblDatosAuto1.setText("DATOS AUTOMÓVIL");
        getContentPane().add(lblDatosAuto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, -1, -1));

        lblCosto.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblCosto.setText("Costo:");
        getContentPane().add(lblCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 740, -1, -1));

        txtTipoAuto.setEditable(false);
        txtTipoAuto.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        getContentPane().add(txtTipoAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 780, 170, -1));

        lblTipo.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblTipo.setText("Tipo:");
        getContentPane().add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 790, -1, -1));

        txtCosto.setEditable(false);
        txtCosto.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        getContentPane().add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 730, 170, -1));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 620, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        float costo = Float.parseFloat(this.txtCosto.getText());

        try {
            Placa placa = placaDao.consultarActiva(txtSerie.getText());
            Automovil auto = automovilDao.consultar(this.txtSerie.getText());
            Persona persona = personaDao.consultar(this.txtRfc2.getText());

            if (licenciasDao.consultar(persona.getRfc())) {
                if (placa != null) {
                    placaDao.insertar1(auto, persona, costo);
                    placaDao.actualizar(placa.getNum_alfanumerico());
                } else {
                    placaDao.insertar1(auto, persona, costo);
                }
            }
            this.txtColor.setText("");
            this.txtCosto.setText("");
            this.txtModelo.setText("");
            this.txtMarca.setText("");
            this.txtSerie.setText("");
            this.txtLinea.setText("");
            this.txtTipoAuto.setText("");
        } catch (PersistenciaException ex) {
            Logger.getLogger(FrmPruebaPlacas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSerieActionPerformed
        // TODO add your handling code here:
        String numSerie = this.txtSerie.getText();

        try {
            Placa placas = placaDao.consultarActiva(numSerie);
            if (automovilDao.existe(numSerie)) {
                buscarAuto(numSerie);
            } else {
                int op = JOptionPane.showOptionDialog(null, "Número de serie inexistente",
                        "Error inesperado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, new Object[]{"Registrar auto", "No"}, null);

                if (op == JOptionPane.YES_OPTION) {
                    FrmAutoNuevo frm = new FrmAutoNuevo(rfc);
                    frm.setVisible(true);
                    this.dispose();
                }
            }

        } catch (PersistenceException ex) {
            Logger.getLogger(FrmPruebaPlacas.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_btnBuscarSerieActionPerformed

    private void btnBuscarRfcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRfcActionPerformed

        try {
            String rfc = txtRfc2.getText();

            IPersonasDAO personaDAO = new PersonasDAO();
            Persona persona = personaDAO.consultar(rfc);
            //Se llenan los campos de texto de manera automática
            txtNombre.setText(persona.getNombres());
            txtApellido.setText(persona.getAp_paterno());
            //Convierte la fecha en String

        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "No se encontró la persona", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarRfcActionPerformed

    private void txtSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyTyped
        // TODO add your handling code here:
        if (txtSerie.getText().length() >= 30) {
            evt.consume();
        }
        final char key = evt.getKeyChar();

        if (Character.isLowerCase(key) || (key == KeyEvent.VK_BACK_SPACE) || key == KeyEvent.VK_DELETE) {
            evt.setKeyChar(Character.toUpperCase(key));
        } else if (!(Character.isLetterOrDigit(key) || (key == KeyEvent.VK_BACK_SPACE) || key == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSerieKeyTyped

    private void txtRfc2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRfc2KeyTyped
        // TODO add your handling code here:
        if (txtRfc2.getText().length() >= 20) {
            evt.consume();
        }
        final char key = evt.getKeyChar();

        if (Character.isLowerCase(key) || (key == KeyEvent.VK_BACK_SPACE) || key == KeyEvent.VK_DELETE) {
            evt.setKeyChar(Character.toUpperCase(key));
        } else if (!(Character.isLetterOrDigit(key) || (key == KeyEvent.VK_BACK_SPACE) || key == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRfc2KeyTyped

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarRfc;
    private javax.swing.JButton btnBuscarSerie;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblAutoNuevo;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblDatosAuto1;
    private javax.swing.JLabel lblDatosPersona;
    private javax.swing.JLabel lblLinea;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRfc;
    private javax.swing.JLabel lblSerie;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRfc2;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtTipoAuto;
    // End of variables declaration//GEN-END:variables
}
