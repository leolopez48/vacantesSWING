/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.ControladorProfesional;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import modelo.ModeloProfesional;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Leonel
 */
public class Detalle_Profesional extends javax.swing.JFrame {

    /**
     * Creates new form Detalle_Profesional
     */
    ControladorProfesional pro = new ControladorProfesional();
    ModeloProfesional profesional = new ModeloProfesional();
    List<ModeloProfesional> data = new ArrayList<>();
    
    public Detalle_Profesional() {
        initComponents();
        super.setExtendedState(Frame.MAXIMIZED_BOTH);
        cerrarVentana();
    }
    
    public Detalle_Profesional(Integer id_profesional) {
        initComponents();
        super.setExtendedState(Frame.MAXIMIZED_BOTH);
        cerrarVentana();
        cargar(id_profesional);
        
    }
    
    public void cargar(Integer id_profesional){
        profesional = pro.seleccionarProfesional(id_profesional);
        
            /*fila.getId_profesional();
            fila.getEdad();*/
            txtNombre.setText(profesional.getApellido_profesional()+", "+profesional.getNombre_profesional());
                ImageIcon imageIcon = new ImageIcon(new ImageIcon((String)profesional.getUsuario().getFoto()).getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT));
                btnFoto.setText("");
                btnFoto.setIcon(imageIcon);
            txtEdad.setText(profesional.getEdad().toString());
            txtProfesion.setText(profesional.getProfesion());
            /*fila.getCorreo();
            fila.getId_usuario();*/
    }

    public void cerrarVentana(){
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //new Profesional().setVisible(true);           
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        btnTituloPerfil = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnFoto = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtProfesion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtEdad = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btnTituloPerfil.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        btnTituloPerfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTituloPerfil.setText("Perfil");
        btnTituloPerfil.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información básica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 18), new java.awt.Color(49, 57, 69))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(49, 57, 69));

        btnFoto.setText("Foto");
        btnFoto.setBorder(null);
        btnFoto.setBorderPainted(false);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setBackground(new java.awt.Color(49, 57, 69));
        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(49, 57, 69));
        jLabel7.setText("Edad");

        txtProfesion.setBackground(new java.awt.Color(233, 235, 237));
        txtProfesion.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        txtProfesion.setBorder(null);
        txtProfesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProfesionActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(49, 57, 69));
        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(49, 57, 69));
        jLabel4.setText("Profesión");

        jLabel2.setBackground(new java.awt.Color(49, 57, 69));
        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(49, 57, 69));
        jLabel2.setText("Nombre");

        jSeparator2.setBackground(new java.awt.Color(233, 235, 237));
        jSeparator2.setForeground(new java.awt.Color(49, 57, 69));

        txtEdad.setBackground(new java.awt.Color(233, 235, 237));
        txtEdad.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        txtEdad.setBorder(null);

        txtNombre.setBackground(new java.awt.Color(233, 235, 237));
        txtNombre.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        txtNombre.setBorder(null);

        jSeparator4.setBackground(new java.awt.Color(233, 235, 237));
        jSeparator4.setForeground(new java.awt.Color(49, 57, 69));

        jSeparator3.setBackground(new java.awt.Color(233, 235, 237));
        jSeparator3.setForeground(new java.awt.Color(49, 57, 69));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel2))
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEdad, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addComponent(txtProfesion)
                    .addComponent(jSeparator4))
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(108, 108, 108)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(5, 5, 5)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(123, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFoto)
                .addGap(193, 193, 193))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFoto)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Últimos trabajos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 18), new java.awt.Color(49, 57, 69))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(49, 57, 69));

        jSeparator10.setBackground(new java.awt.Color(233, 235, 237));
        jSeparator10.setForeground(new java.awt.Color(49, 57, 69));

        jSeparator11.setBackground(new java.awt.Color(233, 235, 237));
        jSeparator11.setForeground(new java.awt.Color(49, 57, 69));

        jLabel6.setBackground(new java.awt.Color(49, 57, 69));
        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(49, 57, 69));
        jLabel6.setText("Trabajo 1");

        jTextField9.setBackground(new java.awt.Color(233, 235, 237));
        jTextField9.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jTextField9.setBorder(null);

        jTextField10.setBackground(new java.awt.Color(233, 235, 237));
        jTextField10.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jTextField10.setBorder(null);

        jLabel11.setBackground(new java.awt.Color(49, 57, 69));
        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(49, 57, 69));
        jLabel11.setText("Trabajo 2");

        jLabel12.setBackground(new java.awt.Color(49, 57, 69));
        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(49, 57, 69));
        jLabel12.setText("Trabajo 3");

        jTextField11.setBackground(new java.awt.Color(233, 235, 237));
        jTextField11.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jTextField11.setBorder(null);

        jSeparator12.setBackground(new java.awt.Color(233, 235, 237));
        jSeparator12.setForeground(new java.awt.Color(49, 57, 69));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel6)
                    .addComponent(jLabel12))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField10, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                    .addComponent(jTextField11)
                    .addComponent(jTextField9)
                    .addComponent(jSeparator10)
                    .addComponent(jSeparator11)
                    .addComponent(jSeparator12))
                .addContainerGap(458, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cursos y capacitaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 18), new java.awt.Color(49, 57, 69))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(49, 57, 69));

        jLabel5.setBackground(new java.awt.Color(49, 57, 69));
        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(49, 57, 69));
        jLabel5.setText("Trabajo 1");

        jTextField6.setBackground(new java.awt.Color(233, 235, 237));
        jTextField6.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jTextField6.setBorder(null);

        jLabel9.setBackground(new java.awt.Color(49, 57, 69));
        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(49, 57, 69));
        jLabel9.setText("Trabajo 2");

        jTextField7.setBackground(new java.awt.Color(233, 235, 237));
        jTextField7.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jTextField7.setBorder(null);

        jLabel10.setBackground(new java.awt.Color(49, 57, 69));
        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(49, 57, 69));
        jLabel10.setText("Trabajo 3");

        jTextField8.setBackground(new java.awt.Color(233, 235, 237));
        jTextField8.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jTextField8.setBorder(null);

        jSeparator7.setBackground(new java.awt.Color(233, 235, 237));
        jSeparator7.setForeground(new java.awt.Color(49, 57, 69));

        jSeparator8.setBackground(new java.awt.Color(233, 235, 237));
        jSeparator8.setForeground(new java.awt.Color(49, 57, 69));

        jSeparator9.setBackground(new java.awt.Color(233, 235, 237));
        jSeparator9.setForeground(new java.awt.Color(49, 57, 69));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                    .addComponent(jTextField8)
                    .addComponent(jTextField7)
                    .addComponent(jSeparator7)
                    .addComponent(jSeparator8)
                    .addComponent(jSeparator9))
                .addContainerGap(458, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Habilidades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 18), new java.awt.Color(49, 57, 69))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(49, 57, 69));

        jSeparator13.setBackground(new java.awt.Color(233, 235, 237));
        jSeparator13.setForeground(new java.awt.Color(49, 57, 69));

        jSeparator14.setBackground(new java.awt.Color(233, 235, 237));
        jSeparator14.setForeground(new java.awt.Color(49, 57, 69));

        jLabel8.setBackground(new java.awt.Color(49, 57, 69));
        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(49, 57, 69));
        jLabel8.setText("Trabajo 1");

        jTextField12.setBackground(new java.awt.Color(233, 235, 237));
        jTextField12.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jTextField12.setBorder(null);

        jTextField13.setBackground(new java.awt.Color(233, 235, 237));
        jTextField13.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jTextField13.setBorder(null);

        jLabel13.setBackground(new java.awt.Color(49, 57, 69));
        jLabel13.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(49, 57, 69));
        jLabel13.setText("Trabajo 2");

        jLabel14.setBackground(new java.awt.Color(49, 57, 69));
        jLabel14.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(49, 57, 69));
        jLabel14.setText("Trabajo 3");

        jTextField14.setBackground(new java.awt.Color(233, 235, 237));
        jTextField14.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jTextField14.setBorder(null);

        jSeparator15.setBackground(new java.awt.Color(233, 235, 237));
        jSeparator15.setForeground(new java.awt.Color(49, 57, 69));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel8)
                    .addComponent(jLabel14))
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField13, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                    .addComponent(jTextField14)
                    .addComponent(jTextField12)
                    .addComponent(jSeparator13)
                    .addComponent(jSeparator14)
                    .addComponent(jSeparator15))
                .addContainerGap(458, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTituloPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTituloPerfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtProfesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProfesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProfesionActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Detalle_Profesional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Detalle_Profesional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Detalle_Profesional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Detalle_Profesional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Detalle_Profesional(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFoto;
    private javax.swing.JLabel btnTituloPerfil;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtProfesion;
    // End of variables declaration//GEN-END:variables
}
