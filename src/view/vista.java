package view;

import controller.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class vista extends javax.swing.JFrame {

    public vista() {
        initComponents();
        setLocationRelativeTo(null);
        String sql = ("SELECT * FROM graficas");
        cargarTabla(sql);

    }

    public void cargarTabla(String sql) {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            Tablebbdd.setModel(modelo);

            Controlador.Conectar();

            ResultSet rs = Controlador.Sentencia(sql);
            
            ResultSetMetaData rsMd = rs.getMetaData();

            int columnas = rsMd.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("VRAM");
            modelo.addColumn("MARCA");
            modelo.addColumn("FABRICANTE");
            modelo.addColumn("PRECIO");

            int[] anchos = {60, 450, 60, 80, 100, 80};

            for (int j = 0; j < columnas; j++) {
                Tablebbdd.getColumnModel().getColumn(j).setPreferredWidth(anchos[j]);
            }

            // Agregar las filas al modelo
            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int i = 1; i <= columnas; i++) {
                    fila[i - 1] = rs.getObject(i);
                }
                modelo.addRow(fila);
            }
            

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        /*
        // Crear la tabla
        JTable tabla = new JTable();

        // Obtener el modelo de la tabla del controlador
        DefaultTableModel modelo = Controlador.obtenerDatosTabla();

        // Establecer el modelo de la tabla
        Tablebbdd.setModel(modelo);

        // Agregar la tabla al panel de la vista
        Table.add(new JScrollPane(tabla));
         */
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
        Funciones = new javax.swing.JPanel();
        Exit = new javax.swing.JButton();
        Scan = new javax.swing.JButton();
        Edit = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Table = new javax.swing.JScrollPane();
        Tablebbdd = new javax.swing.JTable();
        Web = new javax.swing.JComboBox<>();
        Label_Web = new javax.swing.JLabel();
        Label_Componente = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Order_Fabricante = new javax.swing.JComboBox<>();
        Order_Marca = new javax.swing.JComboBox<>();
        Order_VRAM = new javax.swing.JComboBox<>();
        Order_Precio = new javax.swing.JComboBox<>();
        Component = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Component Tracker");

        Exit.setText("Salir");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        Scan.setText("Scan");
        Scan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScanActionPerformed(evt);
            }
        });

        Edit.setText("Editar");

        Delete.setText("Borrar");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Add.setText("Añadir");

        Update.setText("Actualizar");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FuncionesLayout = new javax.swing.GroupLayout(Funciones);
        Funciones.setLayout(FuncionesLayout);
        FuncionesLayout.setHorizontalGroup(
            FuncionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FuncionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FuncionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FuncionesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Exit))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FuncionesLayout.createSequentialGroup()
                        .addComponent(Add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 401, Short.MAX_VALUE)
                        .addComponent(Update)
                        .addGap(18, 18, 18)
                        .addComponent(Scan)))
                .addContainerGap())
        );
        FuncionesLayout.setVerticalGroup(
            FuncionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FuncionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FuncionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Scan)
                    .addComponent(Add)
                    .addComponent(Edit)
                    .addComponent(Delete)
                    .addComponent(Update))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(Exit))
        );

        Tablebbdd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "VRAM", "MARCA", "FABRICANTE", "PRECIO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setViewportView(Tablebbdd);
        if (Tablebbdd.getColumnModel().getColumnCount() > 0) {
            Tablebbdd.getColumnModel().getColumn(0).setMinWidth(60);
            Tablebbdd.getColumnModel().getColumn(0).setPreferredWidth(60);
            Tablebbdd.getColumnModel().getColumn(0).setMaxWidth(60);
            Tablebbdd.getColumnModel().getColumn(2).setMinWidth(60);
            Tablebbdd.getColumnModel().getColumn(2).setPreferredWidth(60);
            Tablebbdd.getColumnModel().getColumn(2).setMaxWidth(60);
            Tablebbdd.getColumnModel().getColumn(3).setMinWidth(100);
            Tablebbdd.getColumnModel().getColumn(3).setPreferredWidth(100);
            Tablebbdd.getColumnModel().getColumn(3).setMaxWidth(100);
            Tablebbdd.getColumnModel().getColumn(4).setMinWidth(100);
            Tablebbdd.getColumnModel().getColumn(4).setPreferredWidth(100);
            Tablebbdd.getColumnModel().getColumn(4).setMaxWidth(100);
            Tablebbdd.getColumnModel().getColumn(5).setMinWidth(100);
            Tablebbdd.getColumnModel().getColumn(5).setPreferredWidth(100);
            Tablebbdd.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        Web.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VsGamers" }));
        Web.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WebActionPerformed(evt);
            }
        });

        Label_Web.setText("Web");

        Label_Componente.setText("Componente");

        Order_Fabricante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nvidia", "AMD" }));
        Order_Fabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Order_FabricanteActionPerformed(evt);
            }
        });

        Order_Marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Asrock", "Asus", "Gigabyte", "MSI", "Palit", "PNY", "Zotac" }));
        Order_Marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Order_MarcaActionPerformed(evt);
            }
        });

        Order_VRAM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascendente", "Descendente" }));
        Order_VRAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Order_VRAMActionPerformed(evt);
            }
        });

        Order_Precio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascendente", "Descendente" }));
        Order_Precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Order_PrecioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Order_VRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(Order_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Order_Fabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(Order_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 52, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Order_VRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Order_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Order_Fabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Order_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        Component.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GPU" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Table, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Label_Web)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Label_Componente))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(Web, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Component, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Web)
                    .addComponent(Label_Componente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Component, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Web, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Table, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Funciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Funciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        dispose();
    }//GEN-LAST:event_ExitActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteActionPerformed

    private void ScanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScanActionPerformed
        try {
            Controlador.Scan();
        } catch (SQLException ex) {
            Logger.getLogger(vista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ScanActionPerformed

    private void Order_VRAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Order_VRAMActionPerformed
        JComboBox comboBoxOrden = (JComboBox) evt.getSource();
        String ordenSeleccionado = comboBoxOrden.getSelectedItem().toString();
        String sql = "";

        switch (ordenSeleccionado) {
            case "Ascendente":
                sql = "SELECT * FROM graficas ORDER BY vram DESC";
                break;
            case "Descendente":
                sql = "SELECT * FROM graficas ORDER BY vram ASC";
                break;
            default:
                break;
        }

        cargarTabla(sql);
    }//GEN-LAST:event_Order_VRAMActionPerformed

    private void WebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WebActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WebActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        try {
            Controlador.Update();
        } catch (SQLException ex) {
            Logger.getLogger(vista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void Order_FabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Order_FabricanteActionPerformed
        JComboBox comboBoxOrden = (JComboBox) evt.getSource();
        String ordenSeleccionado = comboBoxOrden.getSelectedItem().toString();
        String sql = "";

        switch (ordenSeleccionado) {
            case "Nvidia":
                sql = "SELECT * FROM graficas WHERE fabricante = 'Nvidia'";
                break;
            case "AMD":
                sql = "SELECT * FROM graficas WHERE fabricante = 'AMD'";
                break;
            default:
                break;
        }

        cargarTabla(sql);
    }//GEN-LAST:event_Order_FabricanteActionPerformed

    private void Order_PrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Order_PrecioActionPerformed
        JComboBox comboBoxOrden = (JComboBox) evt.getSource();
        String ordenSeleccionado = comboBoxOrden.getSelectedItem().toString();
        String sql = "";

        switch (ordenSeleccionado) {
            case "Ascendente":
                sql = "SELECT * FROM graficas ORDER BY precio DESC";
                break;
            case "Descendente":
                sql = "SELECT * FROM graficas ORDER BY precio ASC";
                break;
            default:
                break;
        }

        cargarTabla(sql);
    }//GEN-LAST:event_Order_PrecioActionPerformed

    private void Order_MarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Order_MarcaActionPerformed
         JComboBox comboBoxOrden = (JComboBox) evt.getSource();
        String ordenSeleccionado = comboBoxOrden.getSelectedItem().toString();
        String sql = "";

        switch (ordenSeleccionado) {
            case "Asrock":
                sql = "SELECT * FROM graficas WHERE marca = 'ASROCK'";
                break;
            case "Asus":
                sql = "SELECT * FROM graficas WHERE marca = 'ASUS'";
                break;
            case "Gigabyte":
                sql = "SELECT * FROM graficas WHERE marca = 'GIGABYTE'";
                break;
            case "Msi":
                sql = "SELECT * FROM graficas WHERE marca = 'MSI'";
                break;
            case "Palit":
                sql = "SELECT * FROM graficas WHERE marca = 'PALIT'";
                break;
            case "PNY":
                sql = "SELECT * FROM graficas WHERE marca = 'PNY'";
                break;
            case "Zotac":
                sql = "SELECT * FROM graficas WHERE marca = 'ZOTAC'";
                break;
            default:
                break;
        }

        cargarTabla(sql);
    }//GEN-LAST:event_Order_MarcaActionPerformed

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
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JComboBox<String> Component;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Edit;
    private javax.swing.JButton Exit;
    private javax.swing.JPanel Funciones;
    private javax.swing.JLabel Label_Componente;
    private javax.swing.JLabel Label_Web;
    private javax.swing.JComboBox<String> Order_Fabricante;
    private javax.swing.JComboBox<String> Order_Marca;
    private javax.swing.JComboBox<String> Order_Precio;
    private javax.swing.JComboBox<String> Order_VRAM;
    private javax.swing.JButton Scan;
    private javax.swing.JScrollPane Table;
    private javax.swing.JTable Tablebbdd;
    private javax.swing.JButton Update;
    private javax.swing.JComboBox<String> Web;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

}
