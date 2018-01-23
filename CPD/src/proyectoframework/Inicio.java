/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoframework;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ricky
 */
public class Inicio extends javax.swing.JFrame {

    public Usuario us;
    public ConcreteSubject concreteSub;
    public Conexion C;
    private int Numero;

    /**
     * Creates new form Inicio
     */

    public Inicio() {
        initComponents();        
        setLocationRelativeTo(null);
       
        
        setResizable(false);   
        this.getContentPane().setBackground(Color.lightGray);
        setVisible(true); 
        //Conexion C = new Conexion();
        concreteSub = concreteSub.Instance(); 
    }  
    
    public void setNumero(int Numero){
        this.Numero=Numero;
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if ( Numero==0 ){
            setLocation(screenSize.width/5,screenSize.height/3);
        }else{
            setLocation(screenSize.width/2,screenSize.height/3);
        }
    }
    
     public Usuario createUsuario(String type){      
        if ( type.equals("Investigador") ) return new TipoInvestigador().createUsuario();
        if ( type.equals("Administrador") ) return new TipoAdministrador().createUsuario();
        return null;
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
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proyecto Framework");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenidos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Por favor seleccione el tipo de usuario");

        jButton1.setText("Administrador");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Investigador");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("El sistema verificará si el usuario es nuevo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public boolean Existe(String name){
        ArrayList<Usuario> Array = new ArrayList<Usuario>();
        Array = concreteSub.getArray();
        for(int i=0;i<Array.size();i++){
            if(Array.get(i).getNombre().equals(name)){
                return true;
            }
        }        
        return false;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTextField1.getText().length() >= 4) {
            if(Existe(jTextField1.getText())){
                JOptionPane.showMessageDialog(rootPane, "El usuario con el nombre: "+jTextField1.getText().toUpperCase()+" se encuentra en sesión.","Error doble sesión",JOptionPane.ERROR_MESSAGE);
                return;
            }
            boolean ventanaEmergente = false;
            try {
                if(!C.InsertarUsuario(jTextField1.getText(),"Administrador")){
                    ventanaEmergente = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.us = createUsuario("Administrador");
            us.setNombre(jTextField1.getText());
            concreteSub.Attach(this.us);
            concreteSub.setCurrent();
            this.dispose();
            Principal p = new Principal();
            if(ventanaEmergente){                
                javax.swing.JOptionPane. showMessageDialog (this, "Bienvenido de nuevo "+jTextField1.getText().toUpperCase());
            }else{
                 javax.swing.JOptionPane. showMessageDialog (this, "Bienvenido "+jTextField1.getText().toUpperCase()+" ahora eres un nuevo: Administrador de la aplicación.");
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Campo nombre vacío o el tamaño es menor a 4","Error Campo Nombre",JOptionPane.ERROR_MESSAGE);
        }
        //this.proyecto.ControlUsuario("SupervisorResponsable");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTextField1.getText().length() >= 4) {
            if(Existe(jTextField1.getText())){
                JOptionPane.showMessageDialog(rootPane, "El usuario con el nombre: "+jTextField1.getText().toUpperCase()+" se encuentra en sesión.","Error doble sesión",JOptionPane.ERROR_MESSAGE);
                return;
            }
            boolean ventanaEmergente = false;
            try {
                if(!C.InsertarUsuario(jTextField1.getText(),"Investigador")){
                    ventanaEmergente = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.us = createUsuario("Investigador");
            us.setNombre(jTextField1.getText());
            concreteSub.Attach(this.us);
            concreteSub.setCurrent();
            this.dispose();
            Principal p = new Principal();
            if(ventanaEmergente){                
                javax.swing.JOptionPane. showMessageDialog (this, "Bienvenido de nuevo "+jTextField1.getText().toUpperCase());
            }else{
                 javax.swing.JOptionPane. showMessageDialog (this, "Bienvenido "+jTextField1.getText().toUpperCase()+" ahora eres un nuevo: Investigador de la aplicación.");
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Campo nombre vacío o el tamaño es menor a 4","Error Campo Nombre",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

//GerenteResponsable
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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
