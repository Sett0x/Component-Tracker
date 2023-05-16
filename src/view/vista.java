package view;

import controller.*;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.Grafica;

public class vista extends javax.swing.JFrame {

    public vista() {
        initComponents();
        setLocationRelativeTo(null);
        // DEFAULT QUERY PARA CARGA DE BBDD
        String sql = ("SELECT * FROM graficas");
        // CARGA DEFAULT DE LA TABLA
        cargarTabla(sql);

    }

    // TABLA CON CONTENIDO DE LA BBDD
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

            // LISTENER PARA CAPTURAR SELECCION DE LA TABLA
            Tablebbdd.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent event) {
                    // Obtener la fila seleccionada
                    int filaSeleccionada = Tablebbdd.getSelectedRow();
                    if (filaSeleccionada >= 0) {
                        txtID.setText(Tablebbdd.getValueAt(filaSeleccionada, 0).toString());
                        txtNombre.setText(Tablebbdd.getValueAt(filaSeleccionada, 1).toString());
                        txtVram.setText(Tablebbdd.getValueAt(filaSeleccionada, 2).toString());
                        txtMarca.setText(Tablebbdd.getValueAt(filaSeleccionada, 3).toString());
                        txtFabricante.setText(Tablebbdd.getValueAt(filaSeleccionada, 4).toString());
                        txtPrecio.setText(Tablebbdd.getValueAt(filaSeleccionada, 5).toString());

                        // Mostrar el historial de precios
                        try {
                            historialPrecioViewer();
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Error al cargar el historial de precios.");
                        }
                    }
                }
            });
            /*
            // ORDENAMIENTO NO FUNCIONA CORRECTAMENTE, NO ORDENA DE MANERA APROPIADA
            
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(modelo);
            Tablebbdd.setRowSorter(sorter);

            JTableHeader header = Tablebbdd.getTableHeader();
            header.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int columna = header.columnAtPoint(e.getPoint());
                    sorter.toggleSortOrder(columna);
                }
            });
             */

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

    // LLAMAMIENTO A LA FUNCION DE HISTORIAL DE PRECIOS
    public void historialPrecioViewer() throws IOException {
        String idString = txtID.getText();
        int id = idString.isEmpty() ? 0 : Integer.parseInt(idString);
        String text = Controlador.obtenerHistorialPrecios(id);
        txtHistorialPrecios.setText(text);
    }

    // FUNCION PARA LIMPIAR LOS CAMPOS DE TEXTO
    public void limpiar() {
        txtID.setText(null);
        txtNombre.setText(null);
        txtVram.setText(null);
        txtMarca.setText(null);
        txtFabricante.setText(null);
        txtPrecio.setText(null);
        txtHistorialPrecios.setText(null);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Component = new javax.swing.JComboBox<>();
        btnScan = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtVram = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtFabricante = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtHistorialPrecios = new javax.swing.JTextArea();
        borrarbbdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Component Tracker");

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
        Tablebbdd.getTableHeader().setReorderingAllowed(false);
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

        Order_Marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Asrock", "Asus", "Gigabyte", "MSI", "Palit", "PNY", "Zotac", "Ascendente", "Descendente" }));
        Order_Marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Order_MarcaActionPerformed(evt);
            }
        });

        Order_VRAM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascendente", "Descendente", "2GB", "4GB", "6GB", "8GB", "10GB", "12GB", "16GB", "20GB", "24GB" }));
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

        jLabel2.setText("PRECIO");

        jLabel3.setText("FABRICANTE");

        jLabel4.setText("MARCA");

        jLabel5.setText("VRAM");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Order_VRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(37, 37, 37)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Order_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Order_Fabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Order_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4)
                        .addGap(63, 63, 63)
                        .addComponent(jLabel3)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Order_VRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Order_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Order_Fabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Order_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        Component.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GPU" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Table)
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

        btnScan.setText("Scan");
        btnScan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScanActionPerformed(evt);
            }
        });

        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel6.setText("Scraper");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel7.setText("ID");

        jLabel8.setText("NOMBRE");

        jLabel9.setText("VRAM");

        jLabel10.setText("MARCA");

        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });

        jLabel11.setText("FABRICANTE");

        jLabel12.setText("PRECIO");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(txtFabricante)
                    .addComponent(txtMarca)
                    .addComponent(txtVram)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpiar)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar)))
        );

        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel13.setText("Historial precios");

        txtHistorialPrecios.setColumns(20);
        txtHistorialPrecios.setRows(5);
        jScrollPane2.setViewportView(txtHistorialPrecios);

        borrarbbdd.setBackground(new java.awt.Color(255, 0, 0));
        borrarbbdd.setForeground(new java.awt.Color(255, 255, 0));
        borrarbbdd.setText("Borrar la bbdd");
        borrarbbdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarbbddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 832, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(btnBuscar)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(44, 44, 44)
                                .addComponent(btnScan, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnExit))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(borrarbbdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnScan)
                                .addComponent(jLabel6))
                            .addGap(18, 18, 18)
                            .addComponent(btnUpdate)
                            .addGap(43, 43, 43)
                            .addComponent(borrarbbdd)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExit))
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26))))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //BOTON DE SALIR DEL PROGRAMA
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        String[] mensajesDespedida = {"¡Con Dios!", "La mineria ya no renta, estando como está la luz...",
            "Que no te engañen en el black friday ese.", "La gráfica que quieres no va a bajar...",
            "Lo que sea, pero una Zotac no..."};
        int indiceMensaje = (int) (Math.random() * mensajesDespedida.length);
        JOptionPane.showMessageDialog(null, mensajesDespedida[indiceMensaje]);
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed
    // BOTON LLAMAMIENTO A LA FUNCION SCAN PARA HACER EL SCRAPE
    private void btnScanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScanActionPerformed
        try {
            Controlador.Scan();
        } catch (SQLException ex) {
            Logger.getLogger(vista.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = ("SELECT * FROM graficas");
        cargarTabla(sql);
    }//GEN-LAST:event_btnScanActionPerformed

    private void Order_VRAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Order_VRAMActionPerformed
        JComboBox comboBoxOrden = (JComboBox) evt.getSource();
        String ordenSeleccionado = comboBoxOrden.getSelectedItem().toString();
        String sql = "";

        switch (ordenSeleccionado) {
            case "Ascendente":
                sql = "SELECT * FROM graficas ORDER BY vram ASC";
                break;
            case "Descendente":
                sql = "SELECT * FROM graficas ORDER BY vram DESC";
                break;
            case "2GB":
                sql = "SELECT * FROM graficas WHERE vram = '2'";
                break;
            case "4GB":
                sql = "SELECT * FROM graficas WHERE vram = '4'";
                break;
            case "6GB":
                sql = "SELECT * FROM graficas WHERE vram = '6'";
                break;
            case "8GB":
                sql = "SELECT * FROM graficas WHERE vram = '8'";
                break;
            case "10GB":
                sql = "SELECT * FROM graficas WHERE vram = '10'";
                break;
            case "12GB":
                sql = "SELECT * FROM graficas WHERE vram = '12'";
                break;
            case "16GB":
                sql = "SELECT * FROM graficas WHERE vram = '16'";
                break;
            case "20GB":
                sql = "SELECT * FROM graficas WHERE vram = '20'";
                break;
            case "24GB":
                sql = "SELECT * FROM graficas WHERE vram = '24'";
                break;
            default:
                break;
        }

        cargarTabla(sql);
    }//GEN-LAST:event_Order_VRAMActionPerformed

    private void WebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WebActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WebActionPerformed
    // BOTON LLAMAMIENTO A LA FUNCION UPDATE PARA ACTUALIZAR PRECIOS GRAFICAS
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            Controlador.Update();
        } catch (SQLException ex) {
            Logger.getLogger(vista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

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
                sql = "SELECT * FROM graficas ORDER BY precio ASC";
                break;
            case "Descendente":
                sql = "SELECT * FROM graficas ORDER BY precio DESC";
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
            case "MSI":
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
            case "Ascendente":
                sql = "SELECT * FROM graficas ORDER BY marca ASC";
                break;
            case "Descendente":
                sql = "SELECT * FROM graficas ORDER BY marca DESC";
                break;
            default:
                break;
        }

        cargarTabla(sql);
    }//GEN-LAST:event_Order_MarcaActionPerformed

    // BOTON LLAMAMIENTO A LA FUNCION MODIFICAR PARA EDITAR LA GRAFICA EN LA BBDD
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int id = Integer.parseInt(txtID.getText());
        String nombre = txtNombre.getText();
        int vram = Integer.parseInt(txtVram.getText());
        String marca = txtMarca.getText();
        String fabricante = txtFabricante.getText();
        double precio = Double.parseDouble(txtPrecio.getText());

        Grafica graficaModificada = new Grafica(id, nombre, vram, marca, fabricante, precio);

        try {
            Controlador.modificarGrafica(graficaModificada.getId(), graficaModificada.getNombre(), graficaModificada.getVram(), graficaModificada.getMarca(), graficaModificada.getFabricante(), graficaModificada.getPrecio());

            limpiar();
            String sql = ("SELECT * FROM graficas");
            cargarTabla(sql);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la gráfica: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
        String sql = ("SELECT * FROM graficas");
        cargarTabla(sql);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String idString = txtID.getText();

        // Validar que idString sea un valor numérico
        if (idString.matches("\\d+")) {
            int id = Integer.parseInt(idString);

            String sql = "SELECT * FROM graficas WHERE id='" + id + "'";

            try {
                Grafica g = Controlador.buscarGraficaPorId(id);
                if (g != null) {
                    txtNombre.setText(g.getNombre());
                    txtVram.setText(String.valueOf(g.getVram()));
                    txtMarca.setText(g.getMarca());
                    txtFabricante.setText(g.getFabricante());
                    txtPrecio.setText(String.valueOf(g.getPrecio()));
                } else {
                    sql = "SELECT * FROM graficas";
                    cargarTabla(sql);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL: " + ex.getMessage());
            }
            cargarTabla(sql);
        } else {
            // idString no es un valor numérico
            JOptionPane.showMessageDialog(null, "El ID debe ser un valor numérico");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int id = Integer.parseInt(txtID.getText());
        String nombre = txtNombre.getText();
        int vram = Integer.parseInt(txtVram.getText());
        String marca = txtMarca.getText();
        String fabricante = txtFabricante.getText();
        double precio = Double.parseDouble(txtPrecio.getText());

        Grafica graficaNueva = new Grafica(id, nombre, vram, marca, fabricante, precio);

        try {
            Controlador.insertarGrafica(graficaNueva.getId(), graficaNueva.getNombre(), graficaNueva.getVram(), graficaNueva.getMarca(), graficaNueva.getFabricante(), graficaNueva.getPrecio());

            limpiar();
            String sql = ("SELECT * FROM graficas");
            cargarTabla(sql);
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int id = Integer.parseInt(txtID.getText());
        try {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea borrar también el registro de precios correspondiente?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                File archivo = new File("src/graficas_registro_precios/" + id + ".txt");
                archivo.delete();
            }

            Controlador.eliminarGrafica(id);
            limpiar();
            String sql = ("SELECT * FROM graficas");
            cargarTabla(sql);
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void borrarbbddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarbbddActionPerformed
        String sql = ("DELETE FROM graficas");
        try {
            Controlador.CUpate(sql);
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea borrar también el historial de precios?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                File carpeta = new File("src/graficas_registro_precios");
                File[] archivos = carpeta.listFiles();
                if (archivos != null) {
                    for (File archivo : archivos) {
                        archivo.delete();
                    }
                }
                if (carpeta.delete()) {
                    JOptionPane.showMessageDialog(null, "Historial de precios borrado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo borrar la carpeta.");
                }
            }
            JOptionPane.showMessageDialog(null, "BBDD borrada correctamente.");
            limpiar();
            sql = ("SELECT * FROM graficas");
            cargarTabla(sql);
        } catch (SQLException ex) {
            Logger.getLogger(vista.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR al borrar la BBDD. Aguantará un día más.");
        }
    }//GEN-LAST:event_borrarbbddActionPerformed

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
    private javax.swing.JComboBox<String> Component;
    private javax.swing.JLabel Label_Componente;
    private javax.swing.JLabel Label_Web;
    private javax.swing.JComboBox<String> Order_Fabricante;
    private javax.swing.JComboBox<String> Order_Marca;
    private javax.swing.JComboBox<String> Order_Precio;
    private javax.swing.JComboBox<String> Order_VRAM;
    private javax.swing.JScrollPane Table;
    private javax.swing.JTable Tablebbdd;
    private javax.swing.JComboBox<String> Web;
    private javax.swing.JButton borrarbbdd;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExit;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnModificar;
    private javax.swing.JButton btnScan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextField txtFabricante;
    private javax.swing.JTextArea txtHistorialPrecios;
    public javax.swing.JTextField txtID;
    public javax.swing.JTextField txtMarca;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPrecio;
    public javax.swing.JTextField txtVram;
    // End of variables declaration//GEN-END:variables

}
