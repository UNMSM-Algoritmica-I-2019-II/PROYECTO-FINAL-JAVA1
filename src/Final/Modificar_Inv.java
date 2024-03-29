/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

import Dbconected.basedatos;
import Dbconected.metodos;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Gonzalo
 */
public class Modificar_Inv extends javax.swing.JFrame {

    DefaultListModel modelo = new DefaultListModel();
    Connection cn;
    Statement s;
    ResultSet rs;

    /**
     * Creates new form Eliminar_Inv
     */
    public Modificar_Inv() {
        initComponents();
        Cargarcontenido();
        Cargar_empresas();
        Lista.setModel(modelo);
        bloquear();
    }

    private void Cargar_empresas() {
        //Creamos objeto tipo Connection    
        Connection conectar;
        Statement s;
        ResultSet result = null;

//Creamos la Consulta SQL
        String SSQL = "SELECT empresa FROM proveedores ORDER BY codigo ASC";

//Establecemos bloque try-catch-finally
        try {

            //Establecemos conexión con la BD 
            conectar = basedatos.conectar();
            //Preparamos la consulta SQL
            s = conectar.createStatement();
            //Ejecutamos la consulta
            result = s.executeQuery(SSQL);

            //LLenamos nuestro ComboBox
            proveedor.addItem("Seleccione una opción");

            while (result.next()) {

                proveedor.addItem(result.getString("empresa"));

            }

        } catch (SQLException e) {

            System.out.println(e);

        }

    }

    private void Cargarcontenido() {
        String SQL = "select * from inventario order by codigo asc ";
        String datos[] = new String[1];
        // limpiarT();
        try {
            cn = basedatos.conectar();
            s = cn.createStatement();
            rs = s.executeQuery(SQL);
            while (rs.next()) {
                datos[0] = rs.getString(2);
                // datos[1]=cn.rt.getString(2);

                modelo.addElement(datos[0]);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void bloquear() {

        codigo.setEnabled(false);
        codigo.setEditable(false);
        nombre.setEnabled(false);
        nombre.setEditable(false);
        stock.setEnabled(false);
        stock.setEditable(false);
        precio.setEnabled(false);
        precio.setEditable(false);
        proveedor.setEnabled(false);
        proveedor.setEditable(false);
    }

    private void desbloquear() {

        nombre.setEnabled(true);
        nombre.setEditable(true);
        stock.setEnabled(true);
        stock.setEditable(true);
        precio.setEnabled(true);
        precio.setEditable(true);
        proveedor.setEnabled(true);
    }

    private void vaciar() {
        codigo.setText(null);
        nombre.setText(null);
        stock.setText(null);
        precio.setText(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        Lista = new javax.swing.JList<>();
        eliminar = new javax.swing.JButton();
        atras = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        stock = new javax.swing.JTextField();
        proveedor = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Lista.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(Lista);

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        atras.setText("Atras");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        jLabel4.setText("Precio :");

        jLabel5.setText("Stock :");

        jLabel6.setText("Proveedor:");

        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });
        codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoKeyPressed(evt);
            }
        });

        jLabel1.setText("Codigo : ");

        jLabel2.setText("Nombre : ");

        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreKeyPressed(evt);
            }
        });

        precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                precioKeyPressed(evt);
            }
        });

        stock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                stockKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(stock)
                                    .addComponent(proveedor, 0, 84, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modificar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(atras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                        .addComponent(eliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modificar)
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(atras)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Realmente quiere eliminar este elemento?");
        if (respuesta == 0) {
            int codi = Lista.getSelectedIndex() + 1;
            String SQL = "delete from inventario where codigo = " + codi + " ";
            try {
                cn = basedatos.conectar();
                s = cn.createStatement();
                int p = s.executeUpdate(SQL);
            } catch (Exception e) {

                System.out.println(e);
            }
            modelo.clear();
            Lista.setModel(modelo);
            Cargarcontenido();
        }//finsi
    }//GEN-LAST:event_eliminarActionPerformed

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        // TODO add your handling code here:
        menu menux = new menu();
        menux.setVisible(true);
        menux.setLocationRelativeTo(null);
        this.dispose();

    }//GEN-LAST:event_atrasActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // TODO add your handling code here:

        int codi = Lista.getSelectedIndex() + 1;
        String codi1 = Integer.toString(codi);
        if (codigo.getText().length() == 0) {//verificar si el codigo esta vacio
            desbloquear();

            codigo.setText(codi1);
        } else {
            String nombre_upd = nombre.getText();
            String precio_upd = precio.getText();
            String stock_upd = stock.getText();
            String provee_upd = proveedor.getSelectedItem().toString();

            if (nombre.getText().length() == 0 || precio.getText().length() == 0 || stock.getText().length() == 0 ) {
                bloquear();
                vaciar();
                JOptionPane.showMessageDialog(null, "algun campo esta vacio");
            } else {
                try {
                    metodos.ActualizarDatosInv("articulo", nombre_upd, codi1);
                    metodos.ActualizarDatosInv("precio_unitario", precio_upd, codi1);
                    metodos.ActualizarDatosInv("stock", stock_upd, codi1);
                    metodos.ActualizarDatosInv("proveedor", provee_upd, codi1);

                    bloquear();
                    vaciar();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            modelo.clear();
            Lista.setModel(modelo);
            Cargarcontenido();

        }
    }//GEN-LAST:event_modificarActionPerformed

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_codigoActionPerformed

    private void codigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoKeyPressed
        // TODO add your handling code here:
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            nombre.requestFocus();//focusea al cuadro nombre
        }
    }//GEN-LAST:event_codigoKeyPressed

    private void nombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyPressed
        // TODO add your handling code here:
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            precio.requestFocus();//focusea al cuadro precio
        }
    }//GEN-LAST:event_nombreKeyPressed

    private void precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioKeyPressed
        // TODO add your handling code here:
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            stock.requestFocus();//focusea al cuadro stock
        }
    }//GEN-LAST:event_precioKeyPressed

    private void stockKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockKeyPressed
        // TODO add your handling code here:
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            proveedor.requestFocus();
        }

    }//GEN-LAST:event_stockKeyPressed

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
            java.util.logging.Logger.getLogger(Modificar_Inv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_Inv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_Inv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_Inv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modificar_Inv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> Lista;
    private javax.swing.JButton atras;
    private javax.swing.JTextField codigo;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField precio;
    private javax.swing.JComboBox<String> proveedor;
    private javax.swing.JTextField stock;
    // End of variables declaration//GEN-END:variables
}
