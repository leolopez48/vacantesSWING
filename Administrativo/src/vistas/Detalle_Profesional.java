
package vistas;

import controlador.ControladorCurso;
import controlador.ControladorHabilidades;
import controlador.ControladorIdioma;
import controlador.ControladorProfesional;
import controlador.ControladorTrabajo;
import controlador.ControladorUsuario;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import modelo.ModeloProfesional;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.ModeloCurso;
import modelo.ModeloHabilidades;
import modelo.ModeloIdioma;
import modelo.ModeloTrabajo;

/**
 *
 * @author Leonel
 */
public class Detalle_Profesional extends javax.swing.JFrame {

    /**
     * Creates new form Detalle Profesional
     */
    ControladorProfesional pro = new ControladorProfesional();
    ModeloProfesional profesional = new ModeloProfesional();
    ControladorHabilidades habilidad = new ControladorHabilidades();
    ControladorIdioma idioma = new ControladorIdioma();
    ControladorCurso curso = new ControladorCurso();
    ControladorUsuario usuario = new ControladorUsuario();
    ControladorTrabajo trabajo = new ControladorTrabajo();
    
    List<ModeloProfesional> data = new ArrayList<>();
    List<ModeloHabilidades> habilidades = new ArrayList<>();
    List<ModeloIdioma> idiomas = new ArrayList<>();
    List<ModeloCurso> cursos = new ArrayList<>();
    List<ModeloTrabajo> trabajos = new ArrayList<>();
    String rutaModificado;
    Integer cantIdioma=0, cantCurso=0;
    
    public Detalle_Profesional() {
        initComponents();
        super.setExtendedState(Frame.MAXIMIZED_BOTH);
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        cerrarVentana();
    }
    
    public Detalle_Profesional(Integer id_profesional) {
        initComponents();
        super.setExtendedState(Frame.MAXIMIZED_BOTH);
        cerrarVentana();
        llenarCmbGenero();
        cargar(id_profesional);
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        
    }
    
    public void llenarCmbGenero(){
        cmbGenero.removeAllItems();
        cmbGenero.addItem("Masculino");
        cmbGenero.addItem("Femenino");
        cmbGenero.addItem("Otro");
    }
    
    public void verificarEstado(Integer estado){
        if(estado == 0){
            btnDeshabilitar.setText("Habilitar");
            txtEstado.setText("Deshabilitado");
        }else{
            btnDeshabilitar.setText("Deshabilitar");
            txtEstado.setText("Habilitado");
        }
    }
    
    public void cargar(Integer id_profesional){
        profesional = pro.seleccionarProfesional(id_profesional);
        //System.out.println(profesional.getUsuario().getEstado().toString());
        txtIdUsuario.setText(profesional.getUsuario().getId_usuario().toString());
        verificarEstado(profesional.getUsuario().getEstado());
        txtNombre.setText(profesional.getNombre_profesional());
        txtApellido.setText(profesional.getApellido_profesional());
        txtCorreo.setText(profesional.getCorreo());
        rutaModificado = profesional.getUsuario().getFoto();
        //System.out.println("Inicial: "+profesional.getUsuario().getFoto());
        txtUsuario.setText(profesional.getUsuario().getNombre_usuario());
        txtContra.setText(profesional.getUsuario().getContra());
        txtPrioridad.setText(profesional.getUsuario().getPrioridad().toString());
        
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(profesional.getUsuario().getFoto()).getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT));
        btnFoto.setText("");
        btnFoto.setIcon(imageIcon);
        
        txtEdad.setText(profesional.getEdad().toString());
        txtProfesion.setText(profesional.getProfesion());
        cmbGenero.setSelectedIndex(profesional.getGenero().getId_genero()-1);
        limpiarPanel();
        
        habilidades = habilidad.seleccionarIdiomas(profesional.getId_profesional());
        mostrarHabilidades(habilidades);
        
        idiomas = idioma.seleccionarIdiomas(profesional.getId_profesional());
        mostrarIdiomas(idiomas);
        
        cursos = curso.seleccionarCurso(profesional.getId_profesional());
        mostrarCursos(cursos);
        
        trabajos = trabajo.seleccionarTrabajo(profesional.getId_profesional());
        mostrarTrabajos(trabajos);
    }
    
    public void limpiarPanel(){
        idiomas.clear();
        jPIdiomas.removeAll();
        jPIdiomas.updateUI();
        
        habilidades.clear();
        jPHabilidades.removeAll();
        jPHabilidades.updateUI();
        
        cursos.clear();
        jPCurso.removeAll();
        jPCurso.updateUI();
        
        trabajos.clear();
        jPTrabajos.removeAll();
        jPTrabajos.updateUI();
    }
    
    public void mostrarCursos(List<ModeloCurso> cursos){
        for(ModeloCurso cur: cursos){
            
            JLabel lbl = new JLabel();
            lbl.setBackground(new java.awt.Color(255,255,255));
            lbl.setFont(new java.awt.Font("Comic Sans MS", 0, 18));
            lbl.setMinimumSize(new Dimension(10,10));
            lbl.setMaximumSize(new Dimension(10,10));
            lbl.setText("Curso");
            jPCurso.add(lbl);
            
            JTextField txt = new JTextField("Idioma ");
            txt.setBackground(new java.awt.Color(255,255,255));
            txt.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
            txt.setText(cur.getCurso());
            txt.setMinimumSize(new Dimension(5,5));
            txt.setMaximumSize(new Dimension(50,50));
            txt.setBorder(null);
            jPCurso.add(txt);
            
            JLabel lblsalto = new JLabel();
            lblsalto.setMinimumSize(new Dimension(0,0));
            lblsalto.setMaximumSize(new Dimension(0,0));
            lblsalto.setText(cur.getId_curso().toString());
            lblsalto.setVisible(false);
            jPCurso.add(lblsalto);
            //System.out.println(cur.getId_curso().toString());
            
            JSeparator separator = new JSeparator();
            separator.setBackground(new java.awt.Color(233, 235, 237));
            separator.setForeground(new java.awt.Color(49, 57, 69));
            jPCurso.add(separator);
            
        }
        jPCurso.updateUI();
    }
    
    public void mostrarTrabajos(List<ModeloTrabajo> trabajos){
        for(ModeloTrabajo trabajo: trabajos){
            
            JLabel lbl = new JLabel();
            lbl.setBackground(new java.awt.Color(255,255,255));
            lbl.setFont(new java.awt.Font("Comic Sans MS", 0, 18));
            lbl.setMinimumSize(new Dimension(10,10));
            lbl.setMaximumSize(new Dimension(10,10));
            lbl.setText("Trabajo ");
            jPTrabajos.add(lbl);
            //System.out.println(trabajo.getTrabajo());
            JTextArea txt = new JTextArea("Idioma ");
            txt.setBackground(new java.awt.Color(255,255,255));
            txt.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
            txt.setText(trabajo.getTrabajo());
            txt.setMinimumSize(new Dimension(5,5));
            txt.setMaximumSize(new Dimension(100,100));
            txt.setBorder(null);
            jPTrabajos.add(txt);
            
            JLabel lblsalto = new JLabel();
            lblsalto.setMinimumSize(new Dimension(0,0));
            lblsalto.setMaximumSize(new Dimension(0,0));
            //lblsalto.setText(rutaModificado);
            jPTrabajos.add(lblsalto);
            
            JSeparator separator = new JSeparator();
            separator.setBackground(new java.awt.Color(233, 235, 237));
            separator.setForeground(new java.awt.Color(49, 57, 69));
            jPTrabajos.add(separator);
            
        }
        jPTrabajos.updateUI();
    }
    
    public void mostrarIdiomas(List<ModeloIdioma> idiomas){
        for(ModeloIdioma idi: idiomas){
            
            JLabel lbl = new JLabel();
            lbl.setBackground(new java.awt.Color(255,255,255));
            lbl.setFont(new java.awt.Font("Comic Sans MS", 0, 18));
            lbl.setMinimumSize(new Dimension(10,10));
            lbl.setMaximumSize(new Dimension(10,10));
            lbl.setText("Idioma");
            jPIdiomas.add(lbl);
            
            JTextField txt = new JTextField("Idioma ");
            txt.setBackground(new java.awt.Color(255,255,255));
            txt.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
            txt.setText(idi.getIdioma());
            txt.setBorder(null);
            jPIdiomas.add(txt);
            
            JLabel lblsalto = new JLabel();
            lblsalto.setMinimumSize(new Dimension(0,0));
            lblsalto.setMaximumSize(new Dimension(0,0));
            lblsalto.setText(idi.getId_idioma().toString());
            lblsalto.setVisible(false);
            jPIdiomas.add(lblsalto);

            JSeparator separator = new JSeparator();
            separator.setBackground(new java.awt.Color(233, 235, 237));
            separator.setForeground(new java.awt.Color(49, 57, 69));
            jPIdiomas.add(separator);
            
        }
        jPIdiomas.updateUI();
    }
    
    public void mostrarHabilidades(List<ModeloHabilidades> habilidades){
        for(ModeloHabilidades hab: habilidades){
            
            JLabel lbl = new JLabel();
            lbl.setBackground(new java.awt.Color(255,255,255));
            lbl.setFont(new java.awt.Font("Comic Sans MS", 0, 18));
            lbl.setMinimumSize(new Dimension(10,10));
            lbl.setMaximumSize(new Dimension(30,30));
            lbl.setText("Habilidad");
            jPHabilidades.add(lbl);
            
            JTextField txt = new JTextField("Idioma ");
            txt.setBackground(new java.awt.Color(255,255,255));
            txt.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
            txt.setText(hab.getDescripcion());
            /*txt.setMinimumSize(new Dimension(30,30));
            txt.setMaximumSize(new Dimension(30,30));*/
            txt.setBorder(null);
            txt.setEditable(false);
            jPHabilidades.add(txt);
            
            JLabel lblsalto = new JLabel();
            lblsalto.setMinimumSize(new Dimension(0,0));
            lblsalto.setMaximumSize(new Dimension(0,0));
            jPHabilidades.add(lblsalto);
            
            
            JSeparator separator = new JSeparator();
            separator.setBackground(new java.awt.Color(233, 235, 237));
            separator.setForeground(new java.awt.Color(49, 57, 69));
            jPHabilidades.add(separator);
            
        }
        jPHabilidades.updateUI();
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
        jLabel8 = new javax.swing.JLabel();
        cmbGenero = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        txtIdUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        txtEstado = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        txtCorreo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        txtPrioridad = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        txtContra = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jPTrabajos = new javax.swing.JPanel();
        btnCrearCurso1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPCurso = new javax.swing.JPanel();
        btnCrearCurso = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPHabilidades = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPIdiomas = new javax.swing.JPanel();
        btnAgregarIdioma = new javax.swing.JButton();
        btnDeshabilitar = new javax.swing.JButton();
        btnCargarFoto = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setBorder(null);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        txtEdad.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        txtEdad.setBorder(null);

        txtNombre.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        txtNombre.setBorder(null);

        jSeparator4.setBackground(new java.awt.Color(233, 235, 237));
        jSeparator4.setForeground(new java.awt.Color(49, 57, 69));

        jSeparator3.setBackground(new java.awt.Color(233, 235, 237));
        jSeparator3.setForeground(new java.awt.Color(49, 57, 69));

        jLabel8.setBackground(new java.awt.Color(49, 57, 69));
        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(49, 57, 69));
        jLabel8.setText("Género");

        cmbGenero.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        cmbGenero.setBorder(null);

        jLabel3.setBackground(new java.awt.Color(49, 57, 69));
        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(49, 57, 69));
        jLabel3.setText("ID");

        jSeparator5.setBackground(new java.awt.Color(233, 235, 237));
        jSeparator5.setForeground(new java.awt.Color(49, 57, 69));

        txtIdUsuario.setEditable(false);
        txtIdUsuario.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        txtIdUsuario.setBorder(null);

        jLabel5.setBackground(new java.awt.Color(49, 57, 69));
        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(49, 57, 69));
        jLabel5.setText("Estado de usuario ");

        jSeparator6.setBackground(new java.awt.Color(233, 235, 237));
        jSeparator6.setForeground(new java.awt.Color(49, 57, 69));

        txtEstado.setEditable(false);
        txtEstado.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        txtEstado.setBorder(null);

        txtApellido.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        txtApellido.setBorder(null);

        jLabel6.setBackground(new java.awt.Color(49, 57, 69));
        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(49, 57, 69));
        jLabel6.setText("Apellido");

        jSeparator7.setBackground(new java.awt.Color(233, 235, 237));
        jSeparator7.setForeground(new java.awt.Color(49, 57, 69));

        jSeparator8.setBackground(new java.awt.Color(233, 235, 237));
        jSeparator8.setForeground(new java.awt.Color(49, 57, 69));

        txtCorreo.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        txtCorreo.setBorder(null);

        jLabel9.setBackground(new java.awt.Color(49, 57, 69));
        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(49, 57, 69));
        jLabel9.setText("Correo");

        txtUsuario.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        txtUsuario.setBorder(null);

        jLabel10.setBackground(new java.awt.Color(49, 57, 69));
        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(49, 57, 69));
        jLabel10.setText("Usuario");

        jSeparator9.setBackground(new java.awt.Color(233, 235, 237));
        jSeparator9.setForeground(new java.awt.Color(49, 57, 69));

        jLabel11.setBackground(new java.awt.Color(49, 57, 69));
        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(49, 57, 69));
        jLabel11.setText("Contraseña");

        jSeparator10.setBackground(new java.awt.Color(233, 235, 237));
        jSeparator10.setForeground(new java.awt.Color(49, 57, 69));

        txtPrioridad.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        txtPrioridad.setBorder(null);

        jLabel12.setBackground(new java.awt.Color(49, 57, 69));
        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(49, 57, 69));
        jLabel12.setText("Prioridad");

        jSeparator11.setBackground(new java.awt.Color(233, 235, 237));
        jSeparator11.setForeground(new java.awt.Color(49, 57, 69));

        txtContra.setText("jPasswordField1");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel8))
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(53, 53, 53)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                        .addComponent(txtEdad))))))
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator10, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(txtContra))))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 713, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(30, 30, 30))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 428, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(btnFoto)
                .addGap(132, 132, 132))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnFoto)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Últimos trabajos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 18), new java.awt.Color(49, 57, 69))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(49, 57, 69));

        jPTrabajos.setBackground(new java.awt.Color(255, 255, 255));
        jPTrabajos.setLayout(new java.awt.GridLayout(0, 2));

        btnCrearCurso1.setText("Agregar");
        btnCrearCurso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCurso1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPTrabajos, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnCrearCurso1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPTrabajos, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnCrearCurso1))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cursos y capacitaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 18), new java.awt.Color(49, 57, 69))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(49, 57, 69));

        jPCurso.setBackground(new java.awt.Color(255, 255, 255));
        jPCurso.setLayout(new java.awt.GridLayout(0, 2));

        btnCrearCurso.setText("Agregar");
        btnCrearCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160)
                .addComponent(btnCrearCurso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnCrearCurso)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Habilidades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 18), new java.awt.Color(49, 57, 69))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(49, 57, 69));

        jPHabilidades.setBackground(new java.awt.Color(255, 255, 255));
        jPHabilidades.setLayout(new java.awt.GridLayout(0, 2));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPHabilidades, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPHabilidades, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Idiomas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 18), new java.awt.Color(49, 57, 69))); // NOI18N
        jPanel9.setForeground(new java.awt.Color(49, 57, 69));

        jPIdiomas.setBackground(new java.awt.Color(255, 255, 255));
        jPIdiomas.setLayout(new java.awt.GridLayout(0, 2));

        btnAgregarIdioma.setText("Agregar");
        btnAgregarIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarIdiomaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPIdiomas, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(265, 265, 265)
                .addComponent(btnAgregarIdioma)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPIdiomas, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAgregarIdioma)
                .addGap(39, 39, 39))
        );

        btnDeshabilitar.setBackground(new java.awt.Color(49, 57, 69));
        btnDeshabilitar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnDeshabilitar.setForeground(new java.awt.Color(49, 57, 69));
        btnDeshabilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_unavailable_32px.png"))); // NOI18N
        btnDeshabilitar.setText("Deshabilitar");
        btnDeshabilitar.setToolTipText("Deshabilita/Habilita al usuario ");
        btnDeshabilitar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(49, 57, 69)));
        btnDeshabilitar.setContentAreaFilled(false);
        btnDeshabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshabilitarActionPerformed(evt);
            }
        });

        btnCargarFoto.setText("jButton1");
        btnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFotoActionPerformed(evt);
            }
        });

        btnActualizar.setText("jButton1");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(btnDeshabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnCargarFoto)
                .addGap(38, 38, 38)
                .addComponent(btnActualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeshabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCargarFoto)
                    .addComponent(btnActualizar))
                .addContainerGap(123, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1069, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1269, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtProfesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProfesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProfesionActionPerformed

    private void btnDeshabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshabilitarActionPerformed
        Integer fila=0;
        if(txtEstado.getText().equals("Deshabilitado")){
            fila = usuario.deshabilitarUsuario(Integer.parseInt(txtIdUsuario.getText()), 1);
        }else{
            fila = usuario.deshabilitarUsuario(Integer.parseInt(txtIdUsuario.getText()), 0);
        }
        if(fila > 0 ){
            cargar(Integer.parseInt(txtIdUsuario.getText()));
            JOptionPane.showMessageDialog(this, "El usuario ha sido deshabilitado.", "Deshabilitado", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "El usuario ha sido habilitado.", "Habilitado", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnDeshabilitarActionPerformed

    private void btnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFotoActionPerformed
        String extension;
        JFileChooser guardar = new JFileChooser();
            //guardar.setFileSelectionMode(JFileChooser.);
        guardar.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files","png", "jpeg", "jpg");
        
        guardar.addChoosableFileFilter(filter);
        guardar.showSaveDialog(null);
        
        if(guardar.getSelectedFile()!=null){
            try {
                File archivo = guardar.getSelectedFile();

                extension = getFileExtension(archivo.getName());

                if(extension.equals("png")){
                    File renombrado = new File(txtIdUsuario.getText()+".png");
                    archivo.renameTo(renombrado);
                }else if(extension.equals("jpg")){
                    File renombrado = new File(txtIdUsuario.getText()+".jpg");
                    archivo.renameTo(renombrado);
                }else if(extension.equals("jpeg")){
                    File renombrado = new File(txtIdUsuario.getText()+".jpeg");
                    archivo.renameTo(renombrado);
                }

                rutaModificado = archivo.getAbsolutePath();
                String root = new File("").getAbsolutePath();
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(rutaModificado).getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT));
                btnFoto.setText("");
                btnFoto.setIcon(imageIcon);
                Files.copy(Paths.get(rutaModificado), Paths.get(root+"/src/recursos/fotosUsuarios").resolve(archivo.getName()), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                System.out.println("Error: "+e);
            }
        }
    }//GEN-LAST:event_btnCargarFotoActionPerformed

    private String getFileExtension(String name) {
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf);
    }
    
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        Integer genero = 0, estado=0;
        
        if(cmbGenero.getSelectedItem().toString().equals("Femenino")){
            genero = 2;
        }else if(cmbGenero.getSelectedItem().toString().equals("Masculino")){
            genero = 1;
        }else{
            genero = 3;
        }
        
        pro.actualizarProfesional(genero, 
                Integer.parseInt(txtEdad.getText()), 
                txtNombre.getText(), 
                txtApellido.getText(), 
                txtProfesion.getText(), 
                txtCorreo.getText(), 
                Integer.parseInt(txtIdUsuario.getText()));
        
        if(txtEstado.getText().equals("Habilitado")){
            estado = 1;
        }else{
            estado = 0;
        }
        
        usuario.actualizarProfesional(txtUsuario.getText(), Integer.parseInt(txtPrioridad.getText()), 
                new String(txtContra.getPassword()), rutaModificado, estado, Integer.parseInt(txtIdUsuario.getText()));
        
        JTextField txtField;
        for(int i=0; i < jPIdiomas.getComponentCount(); i++){
            if(jPIdiomas.getComponent(i).getClass().getName().equals("javax.swing.JTextField")){
                txtField = (JTextField)jPIdiomas.getComponent(i);
                idioma.actualizarIdioma(cantIdioma, txtField.getText(), 1);
            }
        }
        
        JTextField txtCurso;
        for(int i=0; i < jPCurso.getComponentCount(); i++){
            if(jPCurso.getComponent(i).getClass().getName().equals("javax.swing.JTextField")){
                txtCurso = (JTextField)jPCurso.getComponent(i);
                curso.actualizarCurso(cantCurso, txtCurso.getText(), 2);
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAgregarIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarIdiomaActionPerformed

        //cantIdioma = idioma.ultimoIdIdioma();
        //ModeloIdioma idi = new ModeloIdioma();
        //idi = idioma.seleccionarIdioma(cantIdioma);
        JLabel lblId;
        for(int i=0; i < jPIdiomas.getComponentCount(); i++){
            
            if(jPIdiomas.getComponent(i).getClass().getName().equals("javax.swing.JLabel")){
                lblId = (JLabel)jPIdiomas.getComponent(i);
                if(!lblId.getText().equals("Idioma")){
                 cantIdioma = Integer.parseInt(lblId.getText());
                    
                }

            }
        }
        //System.out.println(cantIdioma);
        //System.out.println(cantIdioma);
        //idioma.insertarIdioma(cantIdioma++, "No registrado", 1);
        cantIdioma++;
            JLabel lbl = new JLabel();
            lbl.setBackground(new java.awt.Color(255,255,255));
            lbl.setFont(new java.awt.Font("Comic Sans MS", 0, 18));
            lbl.setMinimumSize(new Dimension(10,10));
            lbl.setMaximumSize(new Dimension(30,30));
            lbl.setText("Habilidad");
            jPIdiomas.add(lbl);
            
            JTextField txt = new JTextField("Idioma ");
            txt.setBackground(new java.awt.Color(255,255,255));
            txt.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
            txt.setText("");
            /*txt.setMinimumSize(new Dimension(30,30));
            txt.setMaximumSize(new Dimension(30,30));*/
            txt.setBorder(null);
            jPIdiomas.add(txt);
            
            JLabel lblsalto = new JLabel();
            lblsalto.setMinimumSize(new Dimension(0,0));
            lblsalto.setMaximumSize(new Dimension(0,0));
            lblsalto.setText(cantIdioma.toString());
            lblsalto.setVisible(false);
            jPIdiomas.add(lblsalto);
            
            
            JSeparator separator = new JSeparator();
            separator.setBackground(new java.awt.Color(233, 235, 237));
            separator.setForeground(new java.awt.Color(49, 57, 69));
            jPIdiomas.add(separator);
            jPIdiomas.updateUI();
            
            idioma.insertarIdioma(cantIdioma, "No registrado", 1);
    }//GEN-LAST:event_btnAgregarIdiomaActionPerformed

    private void btnCrearCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCursoActionPerformed
        
        //cantIdioma = idioma.ultimoIdIdioma();
        //ModeloIdioma idi = new ModeloIdioma();
        //idi = idioma.seleccionarIdioma(cantIdioma);
        JLabel lblId;
        for(int i=0; i < jPCurso.getComponentCount(); i++){
            
            if(jPCurso.getComponent(i).getClass().getName().equals("javax.swing.JLabel")){
                lblId = (JLabel)jPCurso.getComponent(i);
                if(!lblId.getText().equals("Curso")){
                 cantCurso = Integer.parseInt(lblId.getText());
                    
                }

            }
        }
        //System.out.println(cantCurso);
        //System.out.println(cantIdioma);
        //idioma.insertarIdioma(cantIdioma++, "No registrado", 1);
        cantCurso++;
            JLabel lbl = new JLabel();
            lbl.setBackground(new java.awt.Color(255,255,255));
            lbl.setFont(new java.awt.Font("Comic Sans MS", 0, 18));
            lbl.setMinimumSize(new Dimension(10,10));
            lbl.setMaximumSize(new Dimension(30,30));
            lbl.setText("Curso");
            jPCurso.add(lbl);
            
            JTextField txt = new JTextField("Idioma ");
            txt.setBackground(new java.awt.Color(255,255,255));
            txt.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
            txt.setText("");
            /*txt.setMinimumSize(new Dimension(30,30));
            txt.setMaximumSize(new Dimension(30,30));*/
            txt.setBorder(null);
            jPCurso.add(txt);
            
            JLabel lblsalto = new JLabel();
            lblsalto.setMinimumSize(new Dimension(0,0));
            lblsalto.setMaximumSize(new Dimension(0,0));
            lblsalto.setText(cantCurso.toString());
            lblsalto.setVisible(false);
            jPCurso.add(lblsalto);
            
            
            JSeparator separator = new JSeparator();
            separator.setBackground(new java.awt.Color(233, 235, 237));
            separator.setForeground(new java.awt.Color(49, 57, 69));
            jPCurso.add(separator);
            jPCurso.updateUI();
            
            curso.insertarCurso(cantCurso, "No registrado", 2);
    }//GEN-LAST:event_btnCrearCursoActionPerformed

    private void btnCrearCurso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCurso1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearCurso1ActionPerformed

    
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
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarIdioma;
    private javax.swing.JButton btnCargarFoto;
    private javax.swing.JButton btnCrearCurso;
    private javax.swing.JButton btnCrearCurso1;
    private javax.swing.JButton btnDeshabilitar;
    private javax.swing.JButton btnFoto;
    private javax.swing.JLabel btnTituloPerfil;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPCurso;
    private javax.swing.JPanel jPHabilidades;
    private javax.swing.JPanel jPIdiomas;
    private javax.swing.JPanel jPTrabajos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrioridad;
    private javax.swing.JTextField txtProfesion;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
