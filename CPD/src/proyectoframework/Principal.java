/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoframework;

import com.itextpdf.text.Font;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

/**
 *
 * @author Ricky
 */
public class Principal extends javax.swing.JFrame {

    public Usuario us;
    public ConcreteSubject concreteSub;
    public Conexion C;
    /**
     * Creates new form Principal
     */
    public Principal() {        
        initComponents();
        setLocationRelativeTo(null);
        setResizable(true);   
        setVisible(true);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        
        concreteSub = concreteSub.Instance(); 
        this.us = concreteSub.getArray().get(concreteSub.getArray().size()-1);
        this.us.setInterfaz(this);
        try{
        C.ActualizarCarteleraPrimeraVez();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        UpdateCartelera();
        jButton6.setText("Crear");
        HabilitarCampos();
        jComboBox6.addMouseListener(new java.awt.event.MouseAdapter() {
            
            public void itemStateChanged(java.awt.event.MouseEvent evt) {
                UpdateCartelera();
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UpdateCartelera();
            }
        });
       // System.out.println(this.us.getTipo());
    }
    
    public void HabilitarCampos(){
        String tipo = this.us.getTipo();
        if(tipo!="GerenteSolicitante" && tipo!="SupervisorSolicitante"){
            jButton6.setEnabled(false);
        } 
        
       jButton3.setBackground(Color.pink);
       jButton3.setForeground(Color.black);
       
       jButton5.setBackground(Color.pink);
       jButton5.setForeground(Color.black);
       
       jButton7.setBackground(Color.pink);
       jButton7.setForeground(Color.black);
       
       jButton8.setBackground(Color.pink);
       jButton8.setForeground(Color.black);
       
       jButton9.setBackground(Color.pink);
       jButton9.setForeground(Color.black);
    }

    public void UpdateCartelera(){
        Iterator I = CarteleraDeRequerimientos.Instance().createIterator();  
        DefaultTableModel modelo=(DefaultTableModel) jTable1.getModel();  
        modelo.setRowCount(0);        
        jTable1.setModel(modelo);         
        modelo= (DefaultTableModel) jTable1.getModel();  
        //Sección 2
        Object [] fila=new Object[9];
        //Sección 3
        ArrayList<Requerimiento> Array = new ArrayList<Requerimiento>();
        Array= AplicarFiltro(I);
        if(Array.size()==0){
                    
        }else{
            for(int i=0; i< Array.size();i++){
                for(int j=0;j<9;j++)
                    fila[j] = Array.get(i).get(j);  
                modelo.addRow(fila);
            }
        }

        jTable1.setModel(modelo); 
    }
    
       
    public ArrayList<Requerimiento> AplicarFiltro(Iterator I){
        ArrayList<Requerimiento> Array = new ArrayList<Requerimiento>();
        String Busqueda = jTextField1.getText();
        //System.out.println("Este es el valor '"+jTextField1.getText()+"'");
        String tipo = this.us.getTipo();
        if(Busqueda.length()==0){
            if(tipo.equals("Consultor")){
                String nombre = this.us.getTipo();
                while(!I.IsDone()){
                    Requerimiento R = I.Next();
                    if(R.get(7).equals(this.us.getNombre())){
                        Array.add(R);
                    }
                }
            }else
                Array = CarteleraDeRequerimientos.Instance().getCarteleraDeRequerimientos();
        }else{
            int jSelected = jComboBox6.getSelectedIndex();
            while ( !I.IsDone() ){
                Requerimiento R = I.Next();
                if(jSelected == 0){                    
                    for(int k=0;k<9;k++){
                        if ((R.get(k).toLowerCase()).contains(Busqueda.toLowerCase())){  
                            if(tipo.equals("Consultor")){
                                if(R.get(7).equals(this.us.getNombre())){
                                    Array.add(R);                                    
                                }
                                break;
                                
                            }else{
                                Array.add(R);
                                break;
                            }
                        }
                    }
                }else{
                    if( (R.get(jSelected-1).toLowerCase()).contains(Busqueda.toLowerCase())){
                        if(tipo.equals("Consultor")){
                                if(R.get(7).equals(this.us.getNombre())){
                                    Array.add(R);                                    
                                }  
                        }else{
                            Array.add(R);
                        }
                    }
                }
            }
        }        
    
        return Array;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox6 = new javax.swing.JComboBox();
        jLabel60 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jTextField12 = new javax.swing.JTextField();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jDateChooser7 = new com.toedter.calendar.JDateChooser();
        jDateChooser8 = new com.toedter.calendar.JDateChooser();
        jComboBox11 = new javax.swing.JComboBox();
        jPanel11 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jDateChooser9 = new com.toedter.calendar.JDateChooser();
        jLabel39 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel40 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jPanel12 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jDateChooser10 = new com.toedter.calendar.JDateChooser();
        jDateChooser11 = new com.toedter.calendar.JDateChooser();
        jDateChooser12 = new com.toedter.calendar.JDateChooser();
        jPanel14 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox4 = new javax.swing.JComboBox();
        jTextField37 = new javax.swing.JTextField();
        jComboBox5 = new javax.swing.JComboBox();
        jPanel16 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jTextField40 = new javax.swing.JTextField();
        jTextField39 = new javax.swing.JTextField();
        jTextField41 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jTextField42 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        ReporteIndividual = new javax.swing.JButton();
        ReporteConsultor = new javax.swing.JButton();
        ReporteTotal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proyecto Framework | Principal |");

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro Requerimiento", "Aplicación", "Nombre Requerimiento", "Status Comite TI", "VP Solicitante", "Nombre Solicitante", "GG Resp Func", "Nombre Responsable", "Fecha Creación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jComboBox6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Nro Requerimiento", "Aplicación", "Nombre Requerimiento", "Status Comite TI", "VP Solicitante", "Nombre Solicitante", "GG Resp Func", "Nombre Responsable", "Fecha Creación" }));
        jComboBox6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox6MouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jComboBox6MouseReleased(evt);
            }
        });
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        jLabel60.setText("Búsqueda");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1009, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 60, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(354, 354, 354)
                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel60)
                .addGap(459, 459, 459))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jTabbedPane1.addTab("Cartelera de Requerimientos", jScrollPane1);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Número de requerimiento");

        jLabel3.setText("Fecha de la solicitud");

        jLabel4.setText("Situación");

        jLabel5.setText("Ejes de telefonica");

        jLabel6.setText("Iniciativas");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel4)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel5)
                        .addGap(159, 159, 159)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("RequestID");

        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        jLabel7.setText("Certificación del requerimiento");

        jRadioButton1.setText("Certificado");

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del requerimiento", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel8.setText("Nombre Req.");

        jLabel9.setText("Descripción");

        jLabel10.setText("DSAA");

        jLabel11.setText("Aplicación");

        jLabel12.setText("Prioridad Solic.");

        jLabel13.setText("Impacto Neg.");

        jLabel14.setText("Justificación/Obs");

        jLabel15.setText("Fecha Esperada");

        jLabel16.setText("Fecha Certificación");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alto", "Medio", "Bajo" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField12, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del solicitante", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel17.setText("Nombre Sol.");

        jLabel18.setText("Cod. Empleado");

        jLabel19.setText("VP Solicitante");

        jLabel20.setText("GG Solicitante");

        jLabel21.setText("G Solicitante");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(36, 36, 36)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel21)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Persona Contacto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel22.setText("Nombre Contac.");

        jLabel23.setText("VP Contacto");

        jLabel24.setText("GG Contacto");

        jLabel25.setText("G Contacto");

        jLabel26.setText("Extensión");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addGap(36, 36, 36)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel26)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Información del solicitante", jPanel4);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Comite TI", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel27.setText("Status Comite TI");

        jLabel28.setText("Obs. Comite TI");

        jLabel29.setText("Fecha Cancelado");

        jLabel30.setText("Fecha Pend. Rec");

        jLabel31.setText("Ger. Demand.");

        jLabel32.setText("Prioridad TI");

        jLabel33.setText("Fecha comite");

        jLabel34.setText("Fecha facilidad");

        jLabel35.setText("Fecha req. Interv");

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aprobado", "En Ejecución", "Concluido" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel27))
                .addGap(46, 46, 46)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox11, 0, 139, Short.MAX_VALUE)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(jTextField24))
                .addGap(30, 30, 30)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31)
                    .addComponent(jLabel30))
                .addGap(22, 22, 22)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField27)
                    .addComponent(jTextField28)
                    .addComponent(jDateChooser5, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                .addGap(53, 53, 53)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35))
                .addGap(23, 23, 23)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser6, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jDateChooser7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(jLabel30)
                        .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(jLabel31)
                        .addComponent(jLabel34)
                        .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(jLabel32)
                        .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel35))
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Requerimiento", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel36.setText("Tipo de requerimiento");

        jLabel37.setText("SubTipo");

        jLabel38.setText("Fecha Estimada de inicio");

        jLabel39.setText("Complejidad");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alto", "Medio", "Bajo" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel40.setText("Solicitud");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Planificada", "No Planificada", "Por Revisar" }));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel36)
                                    .addGap(30, 30, 30))
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabel37)
                                    .addGap(66, 66, 66)))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addGap(30, 30, 30)))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField26)
                            .addComponent(jTextField25)
                            .addComponent(jDateChooser9, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel40)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38)
                    .addComponent(jDateChooser9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del responsable funcional TI", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel41.setText("Nombre Responsable Funcional");

        jLabel42.setText("Código Resp. Func.");

        jLabel43.setText("GG Resp. Func.");

        jLabel44.setText("G Resp. Func.");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel42))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43)
                            .addComponent(jLabel44))))
                .addGap(42, 42, 42)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Información funcional", jPanel5);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fechas Requerimientos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel45.setText("Fecha Inicio Real");

        jLabel46.setText("Fecha Estimada Culminación");

        jLabel47.setText("Fecha Culminación");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel45))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel46))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel47)))
                .addGap(39, 39, 39)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser11, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser12, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser10, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addComponent(jDateChooser10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel47))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jDateChooser11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del responsable implementación/ejecución", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel48.setText("Nombre Responsable Implementación");

        jLabel49.setText("Cod. Responsable Implementación");

        jLabel50.setText("GG Responsable Implementación");

        jLabel51.setText("G Responsable Implementación");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addComponent(jLabel49)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel51)
                            .addComponent(jLabel50))))
                .addGap(73, 73, 73)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Requerimiento", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel52.setText("Costo Requerimiento");

        jLabel53.setText("Impacto Ténico");

        jLabel54.setText("Observaciones");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alto", "Medio", "Bajo" }));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bs", "$" }));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                        .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19))
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addGap(50, 50, 50)))
                .addGap(31, 31, 31))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel54)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del ejecutor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel55.setText("Nombre del Ejecutor");

        jLabel58.setText("G Ejecutor");

        jLabel57.setText("GG Ejecutor");

        jLabel56.setText("Cod. Ejecutor");

        jLabel59.setText("Extensión");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel56)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel58)
                                .addComponent(jLabel57)
                                .addComponent(jLabel59)))
                        .addGap(70, 70, 70)))
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField41, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(jTextField39)
                    .addComponent(jTextField38)
                    .addComponent(jTextField40)
                    .addComponent(jTextField42))
                .addGap(45, 45, 45))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        jTabbedPane2.addTab("Información Implementación/Ejecución", jPanel6);

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton6.setText("CREAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel1)))
                        .addGap(510, 510, 510)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 996, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jScrollPane4.setViewportView(jPanel2);

        jScrollPane2.setViewportView(jScrollPane4);

        jTabbedPane1.addTab("Registrar Requerimiento", jScrollPane2);

        jButton3.setText("Editar");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Aprobar");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setText("Ejecutar");
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Eliminar");
        jButton8.setEnabled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Concluir");
        jButton9.setEnabled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        ReporteIndividual.setText("Reporte Individual");
        ReporteIndividual.setEnabled(false);
        ReporteIndividual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteIndividualActionPerformed(evt);
            }
        });

        ReporteConsultor.setText("Reporte Consultor");
        ReporteConsultor.setEnabled(false);
        ReporteConsultor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteConsultorActionPerformed(evt);
            }
        });

        ReporteTotal.setText("Reporte total");
        ReporteTotal.setEnabled(false);
        ReporteTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(ReporteIndividual, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ReporteConsultor, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ReporteTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addComponent(jTabbedPane1))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReporteIndividual, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReporteConsultor, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReporteTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    public void Limpiar(){
        ArrayList <String> Array = new ArrayList<String>();
              for(int i=0;i<60;i++)
                  Array.add("");
              try {
                  CambiarValoresPlantilla(Array);
              } catch (ParseException ex) {
                  Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
              }
              jTabbedPane1.setSelectedIndex(0);
    
    }
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        String tipo = this.us.getTipo();
        String nombre = this.us.getNombre();
        int aux=jTable1.getSelectedRow();
        if(aux < 0) return;        
        String estado = (String) jTable1.getValueAt(aux, 3);
        String nombreResponsable = (String) jTable1.getValueAt(aux, 7);
        
        ReporteIndividual.setEnabled(true);
        ReporteConsultor.setEnabled(true);
        ReporteTotal.setEnabled(true);
        ReporteIndividual.setBackground(Color.orange);
        ReporteConsultor.setBackground(Color.orange);
        ReporteTotal.setBackground(Color.orange);
        
        
        if(estado.equals("Aprobado") && tipo.equals("Consultor") && nombreResponsable.equals(nombre)){
            jButton7.setEnabled(true);
            return;
        }else{
            jButton7.setEnabled(false);
        }
        
        if( (tipo.equals("SupervisorResponsable") || tipo.equals("GerenteResponsable")) && estado.equals("Pendiente por comite")){
                jButton5.setEnabled(true);
        }else{
                jButton5.setEnabled(false);                 
        }
        
        if( (tipo.equals("SupervisorResponsable") || tipo.equals("GerenteResponsable" )) && estado.equals("En Ejecución") ){
            jButton9.setEnabled(true);            
        }else{
            jButton9.setEnabled(false);         
        }               
        if( ((tipo.equals("SupervisorSolicitante") || tipo.equals("GerenteSolicitante" )) && estado.equals("Aprobado") ) || ( (tipo.equals("SupervisorResponsable") || tipo.equals("GerenteResponsable")) && estado.equals("Pendiente por comite") ) ){ 
                jButton3.setEnabled(true);
                jButton8.setEnabled(true);
        }else{
                jButton3.setEnabled(false);
                jButton8.setEnabled(false);        
        }    
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
       /* int i=jTabbedPane1.getSelectedIndex();
        if(i>=1){
            jButton3.setVisible(false);
        }else{
            jButton3.setVisible(true);    
        }*/
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private boolean RevisarCampos(int Tab){
        if(Tab == 0){
            if(jTextField2.getText().length()==0)
                return false;
            if(jTextField3.getText().length()==0)
                return false;
            if(jTextField4.getText().length()==0)
                return false;
            if(jTextField5.getText().length()==0)
                return false;
            if(jTextField6.getText().length()==0)
                return false;
            if(jTextField7.getText().length()==0)
                return false;
            if(jTextField8.getText().length()==0)
                return false;
            if(jTextField9.getText().length()==0)
                return false;
            if(jTextField10.getText().length()==0)
                return false;
            if(jTextField11.getText().length()==0)
                return false;
            if(jTextField12.getText().length()==0)
                return false;
            if(jTextField13.getText().length()==0)
                return false;
            if(jTextField14.getText().length()==0)
                return false;
            if(jTextField15.getText().length()==0)
                return false;
            if(jTextField16.getText().length()==0)
                return false;
            if(jTextField17.getText().length()==0)
                return false;
            if(jTextField18.getText().length()==0)
                return false;
            if(jTextField19.getText().length()==0)
                return false;
            if(jTextField20.getText().length()==0)
                return false;
            if(jTextField21.getText().length()==0)
                return false;
            if(jTextField22.getText().length()==0)
                return false;             

            if(jDateChooser1.getDate()==null)
                return false;
            if(jDateChooser2.getDate()==null)
                return false;;
            if(jDateChooser3.getDate()==null)
                return false;
                       
            
            
        }else if (Tab == 1){
            if(jTextField2.getText().length()==0)
                return false;
            if(jTextField3.getText().length()==0)
                return false;
            if(jDateChooser10.getDate()==null)
                return false;      
            if(jDateChooser11.getDate()==null)
                return false; 
            if(jDateChooser12.getDate()==null)
                return false; 
            if(jTextField33.getText().length()==0)
                return false;
            if(jTextField34.getText().length()==0)
                return false;
            if(jTextField35.getText().length()==0)
                return false;
            if(jTextField35.getText().length()==0)
                return false;
            if(jTextField36.getText().length()==0)
                return false;
            if(jTextField37.getText().length()==0)
                return false;
            if(jTextField38.getText().length()==0)
                return false;
            if(jTextField39.getText().length()==0)
                return false;
            if(jTextField40.getText().length()==0)
                return false;
            if(jTextField41.getText().length()==0)
                return false;
            if(jTextField42.getText().length()==0)
                return false;   
            if(jTextField24.getText().length()==0)
                return false;
            if(jTextField25.getText().length()==0)
                return false;
            if(jTextField26.getText().length()==0)
                return false;
            if(jTextField27.getText().length()==0)
                return false;
            if(jTextField28.getText().length()==0)
                return false;
            if(jTextField29.getText().length()==0)
                return false;
            if(jTextField30.getText().length()==0)
                return false;
            if(jTextField31.getText().length()==0)
                return false;  
            if(jTextField32.getText().length()==0)
                return false;              
            if(jDateChooser4.getDate()==null)
                return false;            
            if(jDateChooser6.getDate()==null)
                return false;
            if(jDateChooser5.getDate()==null)
                return false;
            if(jDateChooser7.getDate()==null)
                return false;
            if(jDateChooser9.getDate()==null)
                return false; 
        }
                
                
        return true;
    }
    
    public void Ejecutar(int valor){
        if(RevisarCampos(1)){
                ArrayList<String> Array = new ArrayList<String>();
                SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy/MM/dd");  
                Array.add(jTextField2.getText());    
                
                if(valor == 0){
                    Array.add("Aprobado");
                }else{
                    Array.add("En Ejecución");
                }
               // Array.add(jComboBox11.getSelectedItem().toString());
                Array.add(jTextField24.getText());
                Array.add(sdf.format(jDateChooser4.getDate()));
                Array.add(sdf.format(jDateChooser5.getDate()));
                Array.add(jTextField27.getText());
                Array.add(jTextField28.getText());
                Array.add(sdf.format(jDateChooser6.getDate()));
                Array.add(sdf.format(jDateChooser7.getDate()));
                Array.add(sdf.format(jDateChooser8.getDate()));
                Array.add(jTextField25.getText());
                Array.add(jTextField26.getText());
                Array.add(sdf.format(jDateChooser9.getDate()));
                Array.add(jComboBox1.getSelectedItem().toString());
                Array.add(jComboBox3.getSelectedItem().toString());
                Array.add(jTextField29.getText());
                Array.add(jTextField30.getText());
                Array.add(jTextField31.getText());
                Array.add(jTextField32.getText());   
                
                Array.add(sdf.format(jDateChooser10.getDate())); 
                Array.add(sdf.format(jDateChooser11.getDate())); 
                Array.add(sdf.format(jDateChooser12.getDate())); 
                Array.add(jTextField33.getText());  
                Array.add(jTextField34.getText());
                Array.add(jTextField35.getText());
                Array.add(jTextField36.getText());                
                Array.add(jTextField37.getText()+" "+jComboBox5.getSelectedItem().toString());
                Array.add(jComboBox4.getSelectedItem().toString());                
                Array.add(jTextArea1.getText());   
                Array.add(jTextField41.getText());
                Array.add(jTextField38.getText());  
                Array.add(jTextField39.getText());
                Array.add(jTextField40.getText());                
                Array.add(jTextField42.getText());
                
                try {
                    C.InsertarRequerimiento(Array,1);
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                //Requerimiento ahora en ejecucion
                if(valor==0){
                    JOptionPane.showMessageDialog(rootPane, "Requerimiento Aprobado","Requerimiento",JOptionPane.CLOSED_OPTION);
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Requerimiento Ejecutado","Requerimiento",JOptionPane.CLOSED_OPTION);
                }
                CarteleraDeRequerimientos cartelera = CarteleraDeRequerimientos.Instance();
                try {
                    C.ActualizarCartelera2();
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                concreteSub.ActualizarCartelera();                
           }else{
                JOptionPane.showMessageDialog(rootPane, "Campos vacíos","Error Campos Vacios",JOptionPane.ERROR_MESSAGE);
            }
    }
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(jButton6.getText()=="Crear"){
            if(RevisarCampos(0)){
                ArrayList<String> Array = new ArrayList<String>();
                SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy/MM/dd"); 
                Array.add(jTextField2.getText());
                Array.add(jTextField3.getText());            
                Array.add(sdf.format(jDateChooser1.getDate()));
                Array.add(jTextField6.getText());
                Array.add(jTextField4.getText());
                Array.add(jTextField5.getText());
                if (jRadioButton1.isSelected()){
                    Array.add("Certificado");
                }else{
                    Array.add("No Certificado");
                }

                Array.add(jTextField8.getText());
                Array.add(jTextField7.getText());            
                Array.add(jTextField9.getText());
                Array.add(jTextField10.getText());
                Array.add(jTextField11.getText());
                Object O =jComboBox2.getSelectedItem();
                Array.add(O.toString());            
                Array.add(jTextField12.getText());
                Array.add(sdf.format(jDateChooser2.getDate()));
                Array.add(sdf.format(jDateChooser3.getDate()));
                Array.add(jTextField13.getText());
                Array.add(jTextField14.getText());
                Array.add(jTextField15.getText());
                Array.add(jTextField16.getText());
                Array.add(jTextField17.getText());
                Array.add(jTextField18.getText());
                Array.add(jTextField19.getText());
                Array.add(jTextField20.getText());
                Array.add(jTextField21.getText());
                Array.add(jTextField22.getText());
        
                Array.add("Pendiente por comite");
                for(int i = 0; i <32;i++){
                    Array.add("");
                }               
                try {
                    C.InsertarRequerimiento(Array,0);
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //ACTUALIZAR CARTELERA
                

                CarteleraDeRequerimientos cartelera = CarteleraDeRequerimientos.Instance();
                ArrayList<String> req = new ArrayList<String>();
                req.add(jTextField3.getText());
                req.add(jTextField10.getText());
                req.add(jTextField8.getText());
                req.add("Pendiente por comite");
                req.add(jTextField15.getText());
                req.add(jTextField13.getText());
                req.add(jTextField31.getText());
                req.add(jTextField29.getText());
                req.add(sdf.format(jDateChooser1.getDate()));  
                cartelera.addRequerimiento(new Requerimiento(req));
                concreteSub.ActualizarCartelera();
                
                Limpiar();
                JOptionPane.showMessageDialog(rootPane, "Requerimiento creado","Requerimiento",JOptionPane.CLOSED_OPTION);
                HabilitarCampos();

            }else{
                JOptionPane.showMessageDialog(rootPane, "Campos vacíos","Error Campos Vacios",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            if(RevisarCampos(1)){
                ArrayList<String> Array = new ArrayList<String>();
                SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy/MM/dd");  
                Array.add(jTextField2.getText());    
                
                Array.add(jComboBox11.getSelectedItem().toString());
                Array.add(jTextField24.getText());
                Array.add(sdf.format(jDateChooser4.getDate()));
                Array.add(sdf.format(jDateChooser5.getDate()));
                Array.add(jTextField27.getText());
                Array.add(jTextField28.getText());
                Array.add(sdf.format(jDateChooser6.getDate()));
                Array.add(sdf.format(jDateChooser7.getDate()));
                Array.add(sdf.format(jDateChooser8.getDate()));
                Array.add(jTextField25.getText());
                Array.add(jTextField26.getText());
                Array.add(sdf.format(jDateChooser9.getDate()));
                Array.add(jComboBox1.getSelectedItem().toString());
                Array.add(jComboBox3.getSelectedItem().toString());
                Array.add(jTextField29.getText());
                Array.add(jTextField30.getText());
                Array.add(jTextField31.getText());
                Array.add(jTextField32.getText());   
                
                Array.add(sdf.format(jDateChooser10.getDate())); 
                Array.add(sdf.format(jDateChooser11.getDate())); 
                Array.add(sdf.format(jDateChooser12.getDate())); 
                Array.add(jTextField33.getText());  
                Array.add(jTextField34.getText());
                Array.add(jTextField35.getText());
                Array.add(jTextField36.getText());                
                Array.add(jTextField37.getText()+" "+jComboBox5.getSelectedItem().toString());
                Array.add(jComboBox4.getSelectedItem().toString());                
                Array.add(jTextArea1.getText());   
                Array.add(jTextField41.getText());
                Array.add(jTextField38.getText());  
                Array.add(jTextField39.getText());
                Array.add(jTextField40.getText());                
                Array.add(jTextField42.getText());
                
                try {
                    C.InsertarRequerimiento(Array,1);
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                CarteleraDeRequerimientos cartelera = CarteleraDeRequerimientos.Instance();
                try {
                    C.ActualizarCartelera2();
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                concreteSub.ActualizarCartelera();   
                Limpiar();
                HabilitarCampos();
                //Requerimiento ahora en ejecucion
                JOptionPane.showMessageDialog(rootPane, "Requerimiento modificado","Requerimiento",JOptionPane.CLOSED_OPTION);
            }else{
                JOptionPane.showMessageDialog(rootPane, "Campos vacíos","Error Campos Vacios",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
       int aux =jTabbedPane2.getSelectedIndex();
       String tipo = this.us.getTipo();
       if(aux==0){
           jButton6.setText("Crear");
           if(tipo!="GerenteSolicitante" && tipo!="SupervisorSolicitante"){
               jButton6.setEnabled(false);
           }          
       }else{
           jButton6.setText("Ejecutar/Aprobar");
           if(tipo!="GerenteSolicitante" && tipo!="SupervisorSolicitante"){
               jButton6.setEnabled(true);
           }
       }    
       

    }//GEN-LAST:event_jTabbedPane2MouseClicked
    
    public void CambiarValoresPlantilla(ArrayList<String> Array) throws ParseException{
                SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy/MM/dd"); 
                jTextField2.setText(Array.get(0));                
                jTextField3.setText(Array.get(1));
                if(!Array.get(2).equals("") )
                    jDateChooser1.setDate(sdf.parse(Array.get(2)));
                
                    
                
                jTextField6.setText(Array.get(3));
                jTextField4.setText(Array.get(4));
                jTextField5.setText(Array.get(5));
                
                if (Array.get(6).equals("Certificado")){
                    jRadioButton1.setSelected(true);
                }else{
                    jRadioButton1.setSelected(false);
                }
                jTextField8.setText(Array.get(7));
                jTextField7.setText(Array.get(8));
                jTextField9.setText(Array.get(9));
                jTextField10.setText(Array.get(10));
                jTextField11.setText(Array.get(11));
                if(Array.get(12).equals("Alto")){
                    jComboBox2.setSelectedIndex(0);
                }else if(Array.get(12).equals("Medio")){
                    jComboBox2.setSelectedIndex(1);
                }else{
                    jComboBox2.setSelectedIndex(2);
                }
                jTextField12.setText(Array.get(13));
                
                
                 if(!Array.get(14).equals("") )
                    jDateChooser2.setDate(sdf.parse(Array.get(14)));
                 if(!Array.get(15).equals("") )
                    jDateChooser3.setDate(sdf.parse(Array.get(15)));
                jTextField13.setText(Array.get(16));
                jTextField14.setText(Array.get(17));
                jTextField15.setText(Array.get(18));
                jTextField16.setText(Array.get(19));
                jTextField17.setText(Array.get(20));
                jTextField18.setText(Array.get(21));
                jTextField19.setText(Array.get(22));
                jTextField20.setText(Array.get(23));
                jTextField21.setText(Array.get(24));
                jTextField22.setText(Array.get(25));
                
                if(Array.get(26).equals("Aprobado")){
                    jComboBox11.setSelectedIndex(0);
                }else if(Array.get(26).equals("En Ejecución")){
                    jComboBox11.setSelectedIndex(1);
                }else{
                    jComboBox11.setSelectedIndex(2);
                }
                jComboBox11.setSelectedItem(Array.get(26));
                jTextField24.setText(Array.get(27));
                 if(!Array.get(28).equals("") )
                    jDateChooser4.setDate(sdf.parse(Array.get(28)));
                 if(!Array.get(29).equals("") )
                    jDateChooser5.setDate(sdf.parse(Array.get(29)));
                jTextField27.setText(Array.get(30));
                jTextField28.setText(Array.get(31));
                
                 if(!Array.get(32).equals("") )
                    jDateChooser6.setDate(sdf.parse(Array.get(32)));
                
                 if(!Array.get(33).equals("") )
                    jDateChooser7.setDate(sdf.parse(Array.get(33)));
                
                 if(!Array.get(34).equals("") )
                    jDateChooser8.setDate(sdf.parse(Array.get(34)));
                
                jTextField25.setText(Array.get(35));
                jTextField26.setText(Array.get(36));
                
                 if(!Array.get(37).equals("") )
                    jDateChooser9.setDate(sdf.parse(Array.get(37)));
                
                if(Array.get(38).equals("Alto")){
                    jComboBox1.setSelectedIndex(0);
                }else if(Array.get(38).equals("Medio")){
                    jComboBox1.setSelectedIndex(1);
                }else{
                    jComboBox1.setSelectedIndex(2);
                }  
                
                if(Array.get(39).equals("Planificada")){
                    jComboBox3.setSelectedIndex(0);
                }else if(Array.get(39).equals("No Planificada")){
                    jComboBox3.setSelectedIndex(1);
                }else{
                    jComboBox3.setSelectedIndex(2);
                }             
                jTextField29.setText(Array.get(40));
                jTextField30.setText(Array.get(41));
                jTextField31.setText(Array.get(42));
                jTextField32.setText(Array.get(43));
                
                 if(!Array.get(44).equals("") )
                    jDateChooser10.setDate(sdf.parse(Array.get(44)));
                
                 if(!Array.get(45).equals("") )
                    jDateChooser11.setDate(sdf.parse(Array.get(45)));
                
                 if(!Array.get(46).equals("") )
                    jDateChooser12.setDate(sdf.parse(Array.get(46)));
                
                jTextField33.setText(Array.get(47));
                jTextField34.setText(Array.get(48));
                jTextField35.setText(Array.get(49));
                jTextField36.setText(Array.get(50));
                
                String Costo = Array.get(51);
                
                if(Costo.equals("") || Costo.equals("vacio")){
                   jTextField37.setText("");
                   jComboBox5.setSelectedIndex(0);
                }else{
                    if(Costo.split(" ")[1].equals("Bs")){
                        jComboBox5.setSelectedIndex(0);
                    }else{
                        jComboBox5.setSelectedIndex(1);
                    }
                    jTextField37.setText(Costo.split(" ")[0]);
                }
                
                if(Array.get(52).equals("Alto")){
                    jComboBox4.setSelectedIndex(0);
                }else if(Array.get(52).equals("Medio")){
                    jComboBox4.setSelectedIndex(1);
                }else{
                    jComboBox4.setSelectedIndex(2);
                }                
                               
                jTextArea1.setText(Array.get(53));
                jTextField41.setText(Array.get(54));
                jTextField38.setText(Array.get(55));
                jTextField39.setText(Array.get(56));
                jTextField40.setText(Array.get(57));
                jTextField42.setText(Array.get(58));                 
                
                
    }
    
    public void EditarReq(){
        int aux=jTable1.getSelectedRow();
        String tipo = (String) jTable1.getValueAt(aux, 3);
        ArrayList<String> Array = new ArrayList<String>();
        SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy/MM/dd");
             if(RevisarCampos(0)){
                Array.add(jTextField2.getText());
                Array.add(jTextField3.getText());            
                Array.add(sdf.format(jDateChooser1.getDate()));
                Array.add(jTextField6.getText());
                Array.add(jTextField4.getText());
                Array.add(jTextField5.getText());
                if (jRadioButton1.isSelected()){
                    Array.add("Certificado");
                }else{
                    Array.add("No Certificado");
                }
                Array.add(jTextField8.getText());
                Array.add(jTextField7.getText());            
                Array.add(jTextField9.getText());
                Array.add(jTextField10.getText());
                Array.add(jTextField11.getText());
                Object O =jComboBox2.getSelectedItem();
                Array.add(O.toString());            
                Array.add(jTextField12.getText());
                Array.add(sdf.format(jDateChooser2.getDate()));
                Array.add(sdf.format(jDateChooser3.getDate()));
                Array.add(jTextField13.getText());
                Array.add(jTextField14.getText());
                Array.add(jTextField15.getText());
                Array.add(jTextField16.getText());
                Array.add(jTextField17.getText());
                Array.add(jTextField18.getText());
                Array.add(jTextField19.getText());
                Array.add(jTextField20.getText());
                Array.add(jTextField21.getText());
                Array.add(jTextField22.getText());
        }else{
            JOptionPane.showMessageDialog(rootPane, "Campos vacíos","Error Campos Vacios",JOptionPane.ERROR_MESSAGE);
             return;            
        }
        
        
        if(tipo.equals("Aprobado")){
            if(RevisarCampos(1)){    
                Array.add(jComboBox11.getSelectedItem().toString());
                Array.add(jTextField24.getText());
                Array.add(sdf.format(jDateChooser4.getDate()));
                Array.add(sdf.format(jDateChooser5.getDate()));
                Array.add(jTextField27.getText());
                Array.add(jTextField28.getText());
                Array.add(sdf.format(jDateChooser6.getDate()));
                Array.add(sdf.format(jDateChooser7.getDate()));
                Array.add(sdf.format(jDateChooser8.getDate()));
                Array.add(jTextField25.getText());
                Array.add(jTextField26.getText());
                Array.add(sdf.format(jDateChooser9.getDate()));
                Array.add(jComboBox1.getSelectedItem().toString());
                Array.add(jComboBox3.getSelectedItem().toString());
                Array.add(jTextField29.getText());
                Array.add(jTextField30.getText());
                Array.add(jTextField31.getText());
                Array.add(jTextField32.getText());                   
                Array.add(sdf.format(jDateChooser10.getDate())); 
                Array.add(sdf.format(jDateChooser11.getDate())); 
                Array.add(sdf.format(jDateChooser12.getDate())); 
                Array.add(jTextField33.getText());  
                Array.add(jTextField34.getText());
                Array.add(jTextField35.getText());
                Array.add(jTextField36.getText());                
                Array.add(jTextField37.getText()+" "+jComboBox5.getSelectedItem().toString());
                Array.add(jComboBox4.getSelectedItem().toString());                
                Array.add(jTextArea1.getText());   
                Array.add(jTextField41.getText());
                Array.add(jTextField38.getText());  
                Array.add(jTextField39.getText());
                Array.add(jTextField40.getText());                
                Array.add(jTextField42.getText());
            }else{
                JOptionPane.showMessageDialog(rootPane, "Campos vacíos","Error Campos Vacios",JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
            
        try {
            C.InsertarTodo(Array);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
            JOptionPane.showMessageDialog(rootPane, "Requerimiento editado","Requerimiento",JOptionPane.CLOSED_OPTION);
            try {
                C.ActualizarCartelera2();
            } catch (SQLException ex) {
               Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            concreteSub.ActualizarCartelera();
        
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      int indexActual = jTabbedPane1.getSelectedIndex();
      if(indexActual==0){  
        jTabbedPane1.setSelectedIndex(1);
        int aux=jTable1.getSelectedRow();
        if(aux < 0) return;         

        String nroReq = (String) jTable1.getValueAt(aux, 0);
        ArrayList<String> Array = new ArrayList<String>();
          try {            
              Array = C.getRequerimiento(nroReq);
          } catch (SQLException ex) {
              Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
          }
          try {
              CambiarValoresPlantilla(Array);
              jButton3.setBackground(Color.orange);              
          } catch (ParseException ex) {
              Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
          }
      }else{
          int editar = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea editar este requerimiento?");
          if(editar == 0){ 
              EditarReq();  
              Limpiar();
          }else if(editar == 1){
              ArrayList <String> Array = new ArrayList<String>();
              for(int i=0;i<60;i++)
                  Array.add("");
              try {
                  CambiarValoresPlantilla(Array);
              } catch (ParseException ex) {
                  Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
              }
              jTabbedPane1.setSelectedIndex(0);
          }else{
              return;
          }
          HabilitarCampos();
      }        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int editar = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea ELIMINAR este requerimiento?");
        if(editar == 0){
              jTabbedPane1.setSelectedIndex(0);
              int aux=jTable1.getSelectedRow();
              if(aux < 0) return;
              String req = (String) jTable1.getValueAt(aux, 0);
              
              ArrayList <String> Array = new ArrayList<String>();
              for(int i=0;i<60;i++)
                  Array.add("");
              try {
                  CambiarValoresPlantilla(Array);
              } catch (ParseException ex) {
                  Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
              }

            try {
                C.EliminarReq(req);
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
              
              
              try {
                   C.ActualizarCartelera2();
              } catch (SQLException ex) {
                  Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
              }
              concreteSub.ActualizarCartelera();
              JOptionPane.showMessageDialog(rootPane, "Requerimiento eliminado","Requerimiento",JOptionPane.CLOSED_OPTION);
              HabilitarCampos();
        }
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int editar = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea CONCLUIR este requerimiento?");
        if(editar == 0){
            jTabbedPane1.setSelectedIndex(0);
            int aux=jTable1.getSelectedRow();
            if(aux < 0) return;
            String req = (String) jTable1.getValueAt(aux, 0);
            
             try {
                C.CulminarReq(req);
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
             
             try {
                   C.ActualizarCartelera2();
              } catch (SQLException ex) {
                  Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
              }
              concreteSub.ActualizarCartelera();
              JOptionPane.showMessageDialog(rootPane, "Requerimiento concluido","Requerimiento",JOptionPane.CLOSED_OPTION);
              HabilitarCampos();
        }
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      int indexActual = jTabbedPane1.getSelectedIndex();
      if(indexActual==0){  
        jTabbedPane1.setSelectedIndex(1);        
        int aux=jTable1.getSelectedRow();
        if(aux < 0) return;         

        String nroReq = (String) jTable1.getValueAt(aux, 0);
        ArrayList<String> Array = new ArrayList<String>();
          try {            
              Array = C.getRequerimiento(nroReq);
          } catch (SQLException ex) {
              Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
          }
          try {
              CambiarValoresPlantilla(Array);
              jButton5.setBackground(Color.orange);             
          } catch (ParseException ex) {
              Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
          }
          jTabbedPane2.setSelectedIndex(1);
                 
           String tipo = this.us.getTipo();
           jButton6.setText("Ejecutar/Aprobar");
           if(tipo!="GerenteSolicitante" && tipo!="SupervisorSolicitante"){
               jButton6.setEnabled(true);
           }
     
      }else{
          int editar = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea APROBAR este requerimiento?");
          if(editar == 0){
              Ejecutar(0);  
              Limpiar();
          }else if(editar == 1){
              ArrayList <String> Array = new ArrayList<String>();
              for(int i=0;i<60;i++)
                  Array.add("");
              try {
                  CambiarValoresPlantilla(Array);
              } catch (ParseException ex) {
                  Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
              }
              jTabbedPane1.setSelectedIndex(0);          
          }else{
              return;
          }          
          HabilitarCampos();
          
      }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
      int indexActual = jTabbedPane1.getSelectedIndex();
      if(indexActual==0){  
        jTabbedPane1.setSelectedIndex(1);        
        int aux=jTable1.getSelectedRow();
        
        if(aux < 0) return;         

        String nroReq = (String) jTable1.getValueAt(aux, 0);
        ArrayList<String> Array = new ArrayList<String>();
          try {            
              Array = C.getRequerimiento(nroReq);
              C.EjecucionReq(nroReq,true); //ACTIVA "EN USO"
          } catch (SQLException ex) {
              Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
          }
          try {
              CambiarValoresPlantilla(Array);
              jButton7.setBackground(Color.orange);
              
          } catch (ParseException ex) {
              Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
          }
          jTabbedPane2.setSelectedIndex(1);
                 
           String tipo = this.us.getTipo();
           jButton6.setText("Ejecutar/Aprobar");
           if(tipo!="GerenteSolicitante" && tipo!="SupervisorSolicitante"){
               jButton6.setEnabled(true);
           }
              try {
                   C.ActualizarCartelera2();
              } catch (SQLException ex) {
                  Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
              }
              concreteSub.ActualizarCartelera();
     
      }else{
          int editar = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea EJECUTAR este requerimiento?");
          if(editar == 0){
              Ejecutar(1);  
              Limpiar();
          }else if(editar == 1){
              ArrayList <String> Array = new ArrayList<String>();
              int aux=jTable1.getSelectedRow();
              String nroReq = (String) jTable1.getValueAt(aux, 0);
              try {            
                    C.EjecucionReq(nroReq,false); //Cancela "EN USO"
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
              for(int i=0;i<60;i++)
                  Array.add("");
              try {
                  CambiarValoresPlantilla(Array);
              } catch (ParseException ex) {
                  Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
              }
              try {
                   C.ActualizarCartelera2();
              } catch (SQLException ex) {
                  Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
              }
              concreteSub.ActualizarCartelera();
              jTabbedPane1.setSelectedIndex(0);          
          }else{
              return;
          }          
          HabilitarCampos();
          
      }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
       // UpdateCartelera();
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
      //  UpdateCartelera();
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        UpdateCartelera();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jComboBox6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox6MouseReleased
       
    }//GEN-LAST:event_jComboBox6MouseReleased

    private void jComboBox6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox6MouseClicked
      
    }//GEN-LAST:event_jComboBox6MouseClicked

    private void jComboBox6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox6MouseEntered
        
    }//GEN-LAST:event_jComboBox6MouseEntered

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        UpdateCartelera();
    }//GEN-LAST:event_jComboBox6ActionPerformed

    public void GenerarReporte(boolean Consultor){
           

        
        Iterator I = CarteleraDeRequerimientos.Instance().createIterator(); 
        
        try{
            com.itextpdf.text.Document documento = new com.itextpdf.text.Document(PageSize.LETTER.rotate()); 
            FileOutputStream ficheroPdf;
            
            Font Af=new Font();
            Af.setSize(16);
            Af.setStyle(Font.BOLD);
            Paragraph parrafo2;
            if(Consultor){
                int aux=jTable1.getSelectedRow();
                if(aux<0) return;                
                ficheroPdf=new FileOutputStream("ReporteConsultor"+((String) jTable1.getValueAt(aux, 7)).toUpperCase()+".PDF");
                parrafo2 = new Paragraph("Reporte de Consultor: "+((String) jTable1.getValueAt(aux, 7)).toUpperCase(),Af);
            }
            else{
                parrafo2 = new Paragraph("Reporte de Requerimientos (Cartelera)",Af);
                ficheroPdf=new FileOutputStream("ReporteTotal.PDF");
            }
            
            PdfWriter.getInstance(
                       documento, 
                       ficheroPdf
                       ).setInitialLeading(20);
            documento.open();
            documento.setMargins(0, 0, 0, 0);
            
            
            parrafo2.setAlignment(1);
            documento.add(parrafo2);
            documento.add(new Paragraph(" ",Af));  
            
            PdfPTable tabla = new PdfPTable(9);           
            Font F=new Font();           
            F.setSize(10);
            F.setStyle(Font.BOLD);            
            tabla.setWidthPercentage(108);            
            
            PdfPCell celda0 = new PdfPCell(); 
            Paragraph parrafoAux = new Paragraph("Número del Requerimiento",F);
            parrafoAux.setAlignment(1);
            celda0.setMinimumHeight(40);
            celda0.setColspan(1);
            celda0.setRowspan(1); //CAMBIADO
            celda0.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda0.addElement(parrafoAux);
            tabla.addCell(celda0);
            
            PdfPCell celda1 = new PdfPCell(); 
            parrafoAux = new Paragraph("Aplicación",F);
            parrafoAux.setAlignment(1);
            celda1.setMinimumHeight(40);
            celda1.setColspan(1);
            celda1.setRowspan(1); //CAMBIADO
            celda1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda1.addElement(parrafoAux);
            tabla.addCell(celda1);
            
            PdfPCell celda2 = new PdfPCell(); 
            parrafoAux = new Paragraph("Nombre del Requerimiento",F);
            parrafoAux.setAlignment(1);
            celda2.setMinimumHeight(40);
            celda2.setColspan(1);
            celda2.setRowspan(1); //CAMBIADO
            celda2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda2.addElement(parrafoAux);
            tabla.addCell(celda2);
            
            PdfPCell celda3 = new PdfPCell(); 
            parrafoAux = new Paragraph("Status Comité TI",F);
            parrafoAux.setAlignment(1);
            celda3.setMinimumHeight(40);
            celda3.setColspan(1);
            celda3.setRowspan(1); //CAMBIADO
            celda3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda3.addElement(parrafoAux);
            tabla.addCell(celda3);
            
            PdfPCell celda4 = new PdfPCell(); 
            parrafoAux = new Paragraph("VP Solicitante",F);
            parrafoAux.setAlignment(1);
            celda4.setMinimumHeight(40);
            celda4.setColspan(1);
            celda4.setRowspan(1); //CAMBIADO
            celda4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda4.addElement(parrafoAux);
            tabla.addCell(celda4);
            
            PdfPCell celda5 = new PdfPCell(); 
            parrafoAux = new Paragraph("Nombre Solicitante",F);
            parrafoAux.setAlignment(1);
            celda5.setMinimumHeight(40);
            celda5.setColspan(1);
            celda5.setRowspan(1); //CAMBIADO
            celda5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda5.addElement(parrafoAux);
            tabla.addCell(celda5);
            
            PdfPCell celda6 = new PdfPCell(); 
            parrafoAux = new Paragraph("GG Responsable Funcional",F);
            parrafoAux.setAlignment(1);
            celda6.setMinimumHeight(40);
            celda6.setColspan(1);
            celda6.setRowspan(1); //CAMBIADO
            celda6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda6.addElement(parrafoAux);
            tabla.addCell(celda6);
            
            PdfPCell celda7 = new PdfPCell(); 
            parrafoAux = new Paragraph("Nombre Responsable",F);
            parrafoAux.setAlignment(1);
            celda7.setMinimumHeight(40);
            celda7.setColspan(1);
            celda7.setRowspan(1); //CAMBIADO
            celda7.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda7.addElement(parrafoAux);
            tabla.addCell(celda7);
            
            PdfPCell celda8 = new PdfPCell(); 
            parrafoAux = new Paragraph("Fecha Creación",F);
            parrafoAux.setAlignment(1);
            celda8.setMinimumHeight(40);
            celda8.setColspan(1);
            celda8.setRowspan(1); //CAMBIADO
            celda8.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda8.addElement(parrafoAux);
            tabla.addCell(celda8);  
            
            Font FR=new Font();           
            FR.setSize(10);
           // R.setStyle(Font.BOLD);
            int aux=jTable1.getSelectedRow();
            if(aux<0) return; 
            while(!I.IsDone()){
                Requerimiento R = I.Next();
                for(int i=0;i<9;i++){
                    if(Consultor){
                        if(!((String)jTable1.getValueAt(aux, 7)).equals(R.get(7))){
                            break;
                        }
                    }                    
                    PdfPCell celda9 = new PdfPCell(); 
                    parrafoAux = new Paragraph(R.get(i),FR);
                    parrafoAux.setAlignment(1);
                    celda9.setMinimumHeight(40);
                    celda9.setColspan(1);
                    celda9.setRowspan(1); //CAMBIADO
                    celda9.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda9.addElement(parrafoAux);
                    tabla.addCell(celda9);                      
                    
                }
            }
            
            documento.add(tabla);  
            documento.close();
            
            try {
                if(Consultor){
                    if(aux<0) return; 
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "ReporteConsultor"+((String)jTable1.getValueAt(aux, 7)).toUpperCase()+".PDF");
                }else{
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "ReporteTotal.PDF");
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(rootPane, "Error al Abrir el Archivo", "ERROR", JOptionPane.ERROR_MESSAGE);  
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    }
    
    
    private void ReporteIndividualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteIndividualActionPerformed
        int aux=jTable1.getSelectedRow();
        
        if(aux < 0) return;         

        String nroReq = (String) jTable1.getValueAt(aux, 0);
        ArrayList<String> Array = new ArrayList<String>();
        for(int i=0;i<9;i++)
            Array.add((String) jTable1.getValueAt(aux, i));
        try {
            com.itextpdf.text.Document documento = new com.itextpdf.text.Document(PageSize.LETTER.rotate()); 
            FileOutputStream ficheroPdf;
            
            ficheroPdf=new FileOutputStream("ReporteIndividual"+Array.get(2).toUpperCase()+".PDF");
            PdfWriter.getInstance(
                       documento, 
                       ficheroPdf
                       ).setInitialLeading(20);
            documento.open();
            documento.setMargins(0, 0, 0, 0);
            
            
            Font Af=new Font();
            Af.setSize(16);
            Af.setStyle(Font.BOLD);
            Paragraph parrafo2 = new Paragraph("Reporte de Requerimiento",Af); // Escribe el nombre de la empresa
            
            parrafo2.setAlignment(1);
            documento.add(parrafo2);
            documento.add(new Paragraph(" ",Af));
            
            PdfPTable tabla = new PdfPTable(2);           
            Font F=new Font();
            Font R= new Font();
            R.setSize(13);            
            F.setSize(12);
            R.setStyle(Font.BOLD);
            F.setStyle(Font.BOLD);            
            tabla.setWidthPercentage(80);
            
            // Celdas

            /*PdfPCell celda0 = new PdfPCell(new Paragraph("Nombre del Requerimiento",F));
            celda0.setColspan(1);
            celda0.setRowspan(1); //CAMBIADO            
            celda0.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tabla.addCell(celda0);*/
            
            PdfPCell celda0 = new PdfPCell(); 
            Paragraph parrafoAux = new Paragraph("Nombre del Requerimiento",F);
            parrafoAux.setAlignment(1);
            celda0.setMinimumHeight(40);
            celda0.setColspan(1);
            celda0.setRowspan(1); //CAMBIADO
            celda0.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda0.addElement(parrafoAux);
            tabla.addCell(celda0);
            
            PdfPCell celda1 = new PdfPCell();
            parrafoAux = new Paragraph(Array.get(2),R);
            parrafoAux.setAlignment(1);
            celda1.setMinimumHeight(40);
            celda1.setColspan(1);
            celda1.setRowspan(1); //CAMBIADO
            celda1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda1.addElement(parrafoAux);            
            tabla.addCell(celda1);
            
            PdfPCell celda2 = new PdfPCell();
            parrafoAux = new Paragraph("Número del Requerimiento",F);
            parrafoAux.setAlignment(1);
            celda2.setMinimumHeight(40);
            celda2.setColspan(1);
            celda2.setRowspan(1); //CAMBIADO
            celda2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda2.addElement(parrafoAux);            
            tabla.addCell(celda2);
            
            PdfPCell celda3 = new PdfPCell();
            parrafoAux = new Paragraph(Array.get(0),R);
            parrafoAux.setAlignment(1);
            celda3.setMinimumHeight(40);
            celda3.setColspan(1);
            celda3.setRowspan(1); //CAMBIADO
            celda3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda3.addElement(parrafoAux);            
            tabla.addCell(celda3);
            
            PdfPCell celda4 = new PdfPCell();
            parrafoAux = new Paragraph("Aplicación",F);
            parrafoAux.setAlignment(1);
            celda4.setMinimumHeight(40);
            celda4.setColspan(1);
            celda4.setRowspan(1); //CAMBIADO
            celda4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda4.addElement(parrafoAux);            
            tabla.addCell(celda4);
            
            PdfPCell celda5 = new PdfPCell();
            parrafoAux = new Paragraph(Array.get(1),R);
            parrafoAux.setAlignment(1);
            celda5.setMinimumHeight(40);
            celda5.setColspan(1);
            celda5.setRowspan(1); //CAMBIADO
            celda5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda5.addElement(parrafoAux);            
            tabla.addCell(celda5);
            
            PdfPCell celda6 = new PdfPCell();
            parrafoAux = new Paragraph("Status Comité",F);
            parrafoAux.setAlignment(1);
            celda6.setMinimumHeight(40);
            celda6.setColspan(1);
            celda6.setRowspan(1); //CAMBIADO
            celda6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda6.addElement(parrafoAux);            
            tabla.addCell(celda6);
            
            PdfPCell celda7 = new PdfPCell();
            parrafoAux = new Paragraph(Array.get(3),R);
            parrafoAux.setAlignment(1);
            celda7.setMinimumHeight(40);
            celda7.setColspan(1);
            celda7.setRowspan(1); //CAMBIADO
            celda7.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda7.addElement(parrafoAux);            
            tabla.addCell(celda7);
            
            PdfPCell celda8 = new PdfPCell();
            parrafoAux = new Paragraph("VP Solicitante",F);
            parrafoAux.setAlignment(1);
            celda8.setMinimumHeight(40);
            celda8.setColspan(1);
            celda8.setRowspan(1); //CAMBIADO
            celda8.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda8.addElement(parrafoAux);            
            tabla.addCell(celda8);
            
            PdfPCell celda9 = new PdfPCell();
            parrafoAux = new Paragraph(Array.get(4),R);
            parrafoAux.setAlignment(1);
            celda9.setMinimumHeight(40);
            celda9.setColspan(1);
            celda9.setRowspan(1); //CAMBIADO
            celda9.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda9.addElement(parrafoAux);            
            tabla.addCell(celda9);
            
            PdfPCell celda10 = new PdfPCell();
            parrafoAux = new Paragraph("Nombre Solicitante",F);
            parrafoAux.setAlignment(1);
            celda10.setMinimumHeight(40);
            celda10.setColspan(1);
            celda10.setRowspan(1); //CAMBIADO
            celda10.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda10.addElement(parrafoAux);            
            tabla.addCell(celda10);
            
            PdfPCell celda11 = new PdfPCell();
            parrafoAux = new Paragraph(Array.get(5),R);
            parrafoAux.setAlignment(1);
            celda11.setMinimumHeight(40);
            celda11.setColspan(1);
            celda11.setRowspan(1); //CAMBIADO
            celda11.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda11.addElement(parrafoAux);            
            tabla.addCell(celda11);
            
            PdfPCell celda12 = new PdfPCell();
            parrafoAux = new Paragraph("GG Responsable Funcional",F);
            parrafoAux.setAlignment(1);
            celda12.setMinimumHeight(40);
            celda12.setColspan(1);
            celda12.setRowspan(1); //CAMBIADO
            celda12.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda12.addElement(parrafoAux);            
            tabla.addCell(celda12);
            
            PdfPCell celda13 = new PdfPCell();
            parrafoAux = new Paragraph(Array.get(6),R);
            parrafoAux.setAlignment(1);
            celda13.setMinimumHeight(40);
            celda13.setColspan(1);
            celda13.setRowspan(1); //CAMBIADO
            celda13.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda13.addElement(parrafoAux);            
            tabla.addCell(celda13);
            
            PdfPCell celda14 = new PdfPCell();
            parrafoAux = new Paragraph("Nombre Responsable",F);
            parrafoAux.setAlignment(1);
            celda14.setMinimumHeight(40);
            celda14.setColspan(1);
            celda14.setRowspan(1); //CAMBIADO
            celda14.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda14.addElement(parrafoAux);            
            tabla.addCell(celda14);
            
            PdfPCell celda15 = new PdfPCell();
            parrafoAux = new Paragraph(Array.get(7),R);
            parrafoAux.setAlignment(1);
            celda15.setMinimumHeight(40);
            celda15.setColspan(1);
            celda15.setRowspan(1); //CAMBIADO
            celda15.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda15.addElement(parrafoAux);            
            tabla.addCell(celda15);
            
            PdfPCell celda16 = new PdfPCell();
            parrafoAux = new Paragraph("Fecha Creación",F);
            parrafoAux.setAlignment(1);
            celda16.setMinimumHeight(40);
            celda16.setColspan(1);
            celda16.setRowspan(1); //CAMBIADO
            celda16.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda16.addElement(parrafoAux);            
            tabla.addCell(celda16);
            
            PdfPCell celda17 = new PdfPCell();
            parrafoAux = new Paragraph(Array.get(8),R);
            parrafoAux.setAlignment(1);
            celda17.setMinimumHeight(40);
            celda17.setColspan(1);
            celda17.setRowspan(1); //CAMBIADO
            celda17.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda17.addElement(parrafoAux);            
            tabla.addCell(celda17);            
            
            documento.add(tabla);  
            documento.close();
            
            try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "ReporteIndividual"+Array.get(2).toUpperCase()+".PDF");
            } catch (Exception e){
                JOptionPane.showMessageDialog(rootPane, "Error al Abrir el Archivo", "ERROR", JOptionPane.ERROR_MESSAGE);  
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
            

    }//GEN-LAST:event_ReporteIndividualActionPerformed

    private void ReporteConsultorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteConsultorActionPerformed
        GenerarReporte(true);
    }//GEN-LAST:event_ReporteConsultorActionPerformed

    private void ReporteTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteTotalActionPerformed
        GenerarReporte(false);
    }//GEN-LAST:event_ReporteTotalActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ReporteConsultor;
    private javax.swing.JButton ReporteIndividual;
    private javax.swing.JButton ReporteTotal;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox11;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser10;
    private com.toedter.calendar.JDateChooser jDateChooser11;
    private com.toedter.calendar.JDateChooser jDateChooser12;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
    private com.toedter.calendar.JDateChooser jDateChooser7;
    private com.toedter.calendar.JDateChooser jDateChooser8;
    private com.toedter.calendar.JDateChooser jDateChooser9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
