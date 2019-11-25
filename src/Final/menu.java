/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

import Dbconected.basedatos;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gonzalo
 */
public class menu extends javax.swing.JFrame {

    
    
     

    /**
     * Creates new form menu
     */
    public menu() {
        initComponents();
        cargar();
        cargar2();
    }
    
    private void cargar(){
    Connection cn;
        Statement s;
        ResultSet rs;
         try {
            //Para establecer el modelo al JTable
            DefaultTableModel modelo = new DefaultTableModel();
            this.tablita.setModel(modelo);
            //Para conectarnos a nuestra base de datos
            //String url = "jdbc:oracle:thin:@localhost:1521:XE";
            // Establecemos los valores de cadena de conexión, usuario y contraseña
           // cn = DriverManager.getConnection(url, "gonzalo", "admin");
            //Para ejecutar la consulta
            cn = basedatos.conectar();//cn variable de tipo coneccion
            s = cn.createStatement();
            //Ejecutamos la consulta y los datos lo almacenamos en un ResultSet
             rs = s.executeQuery("select * from inventario ORDER BY codigo ASC ");
            //Obteniendo la informacion de las columnas que estan siendo consultadas
            ResultSetMetaData rsMd = rs.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
            //Establecer como cabezeras el nombre de las colimnas
            for (int i = 1; i <= cantidadColumnas; i++) {
             modelo.addColumn(rsMd.getColumnLabel(i));
            }
            //Creando las filas para el JTable
            while (rs.next()) {
             Object[] fila = new Object[cantidadColumnas];
             for (int i = 0; i < cantidadColumnas; i++) {
               fila[i]=rs.getObject(i+1);
             }
             modelo.addRow(fila);
            }
            rs.close();
            cn.close();
       } catch (SQLException ex) {
           System.out.println(ex);
       }
    
    }
    
    private void cargar2(){
    Connection cn;
        Statement s;
        ResultSet rs;
         try {
            //Para establecer el modelo al JTable
            DefaultTableModel modelo = new DefaultTableModel();
            this.Tabla_proveedores.setModel(modelo);
            //Para conectarnos a nuestra base de datos
            //String url = "jdbc:oracle:thin:@localhost:1521:XE";
            // Establecemos los valores de cadena de conexión, usuario y contraseña
           // cn = DriverManager.getConnection(url, "gonzalo", "admin");
            //Para ejecutar la consulta
            cn = basedatos.conectar();//cn variable de tipo coneccion
            s = cn.createStatement();
            //Ejecutamos la consulta y los datos lo almacenamos en un ResultSet
             rs = s.executeQuery("select * from proveedores Order by empresa asc ");
            //Obteniendo la informacion de las columnas que estan siendo consultadas
            ResultSetMetaData rsMd = rs.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
            //Establecer como cabezeras el nombre de las colimnas
            for (int i = 1; i <= cantidadColumnas; i++) {
             modelo.addColumn(rsMd.getColumnLabel(i));
            }
            //Creando las filas para el JTable
            while (rs.next()) {
             Object[] fila = new Object[cantidadColumnas];
             for (int i = 0; i < cantidadColumnas; i++) {
               fila[i]=rs.getObject(i+1);
             }
             modelo.addRow(fila);
            }
            rs.close();
            cn.close();
       } catch (SQLException ex) {
           System.out.println(ex);
       }
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
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablita = new javax.swing.JTable();
        Busqueda = new javax.swing.JButton();
        recuadro = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_proveedores = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        buscarp = new javax.swing.JTextField();
        buscar_proveedor = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setText("Cerrar Sesion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Realizar una busqueda: ");

        tablita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablita);

        Busqueda.setText("Buscar");
        Busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaActionPerformed(evt);
            }
        });

        recuadro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recuadroActionPerformed(evt);
            }
        });
        recuadro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                recuadroKeyPressed(evt);
            }
        });

        jButton4.setText("Insertar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setText("R");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)
                        .addGap(41, 41, 41)
                        .addComponent(recuadro, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jButton4)
                        .addGap(78, 78, 78)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Busqueda)
                    .addComponent(recuadro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Inventario", jPanel4);

        jButton3.setText("Cerrar Sesion");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Tabla_proveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tabla_proveedores);

        jLabel2.setText("Realizar una busqueda: ");

        buscarp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarpActionPerformed(evt);
            }
        });
        buscarp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarpKeyPressed(evt);
            }
        });

        buscar_proveedor.setText("Buscar");
        buscar_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_proveedorActionPerformed(evt);
            }
        });

        jButton6.setText("Insertar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setText("R");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Eliminar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jButton6)
                        .addGap(82, 82, 82)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)
                        .addGap(41, 41, 41)
                        .addComponent(buscarp, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(buscar_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(buscarp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar_proveedor)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton6)
                    .addComponent(jButton9))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Proveedores", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        login login2 = new login();//crear un nuevo objeto llamado login2
        login2.setVisible(true);//hacer visible el nuevo objeto
        login2.setLocationRelativeTo(null);//hacer que el nuevo objeto aparezca al centro
        this.dispose();//cerrar objeto actual
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        login login2 = new login();//crear un nuevo objeto llamado login2
        login2.setVisible(true);//hacer visible el nuevo objeto
        login2.setLocationRelativeTo(null);//hacer que el nuevo objeto aparezca al centro
        this.dispose();//cerrar objeto actual
    }//GEN-LAST:event_jButton3ActionPerformed

    private void recuadroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recuadroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recuadroActionPerformed

    private void recuadroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_recuadroKeyPressed
        // TODO add your handling code here:
        if(evt.getExtendedKeyCode() == KeyEvent.VK_ENTER){
        Busqueda.requestFocus();
        Busqueda.doClick();
        }
    }//GEN-LAST:event_recuadroKeyPressed

    private void buscarpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarpActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Aniadir_Inv anadir = new Aniadir_Inv();
        anadir.setVisible(true);
        anadir.setLocationRelativeTo(null);
        this.dispose();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Aniadir_Prov prove = new Aniadir_Prov();
        prove.setVisible(true);
        prove.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void BusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaActionPerformed
        // TODO add your handling code here:
        Connection cn ;
        Statement s ;
        ResultSet rs;
        String cuadrito = recuadro.getText();
        
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            this.tablita.setModel(modelo);
            cn = basedatos.conectar();
            s = cn.createStatement();
            rs = s.executeQuery("select * from inventario where codigo = '" + cuadrito + "' or articulo = '" + cuadrito + "'" );
             ResultSetMetaData rsMd = rs.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
            //Establecer como cabezeras el nombre de las colimnas
            for (int i = 1; i <= cantidadColumnas; i++) {
             modelo.addColumn(rsMd.getColumnLabel(i));
            }
            //Creando las filas para el JTable
            while (rs.next()) {
             Object[] fila = new Object[cantidadColumnas];
             for (int i = 0; i < cantidadColumnas; i++) {
               fila[i]=rs.getObject(i+1);
             }
             modelo.addRow(fila);
            }
            rs.close();
            cn.close();
            recuadro.setText(null);
            recuadro.requestFocus();
            
        
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
        
    }//GEN-LAST:event_BusquedaActionPerformed

    private void buscar_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_proveedorActionPerformed
        // TODO add your handling code here:
        Connection cn ;
        Statement s ;
        ResultSet rs;
        String buscar = buscarp.getText();
        
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            this.Tabla_proveedores.setModel(modelo);
            cn = basedatos.conectar();
            s = cn.createStatement();
            rs = s.executeQuery("select * from proveedores where empresa = '" + buscar + "' OR codigo = " + buscar  );
             ResultSetMetaData rsMd = rs.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
            //Establecer como cabezeras el nombre de las colimnas
            for (int i = 1; i <= cantidadColumnas; i++) {
             modelo.addColumn(rsMd.getColumnLabel(i));
            }
            //Creando las filas para el JTable
            while (rs.next()) {
             Object[] fila = new Object[cantidadColumnas];
             for (int i = 0; i < cantidadColumnas; i++) {
               fila[i]=rs.getObject(i+1);
             }
             modelo.addRow(fila);
            }
            rs.close();
            cn.close();
            buscarp.setText(null);
            buscarp.requestFocus();
            
        
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_buscar_proveedorActionPerformed

    private void buscarpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarpKeyPressed
        // TODO add your handling code here:
        if(evt.getExtendedKeyCode() == KeyEvent.VK_ENTER){
            buscar_proveedor.requestFocus();
            buscar_proveedor.doClick();
            }
    }//GEN-LAST:event_buscarpKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Eliminar_Inv eliminar = new Eliminar_Inv();
        eliminar.setVisible(true);
        eliminar.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        cargar2();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cargar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        Eliminar_Prov eliminar = new Eliminar_Prov();
        eliminar.setVisible(true);
        eliminar.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Busqueda;
    private javax.swing.JTable Tabla_proveedores;
    private javax.swing.JButton buscar_proveedor;
    private javax.swing.JTextField buscarp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField recuadro;
    private javax.swing.JTable tablita;
    // End of variables declaration//GEN-END:variables
}
