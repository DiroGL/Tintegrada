package interfazGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import DAO.CompaniaDAO;
import conexionSQL.ConexionBD;
import entitiesBBDD.*;

public class CompaniasMenu {

    private JFrame frame;
    private JTable table;
    private JTextField coberturasTextField;
    private JTextField formaPagoTextField;
    private JTextField ncomTextField;
    private JTextField telcomTextField;
    private CompaniaDAO companiaDAO;
    private DefaultTableModel model;
    private ConexionBD conexionBD;
 
    public CompaniasMenu() {
        initialize();
        conexionBD = new ConexionBD("tintegrada");
    }

    /**
     * Initialize the contents of the frame.
     */
    public void initialize() {
    	
  
        // Inicializar el objeto CompaniaDAO
        companiaDAO = new CompaniaDAO();

        // Crear la ventana principal
        frame = new JFrame("Menú de compañías");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(100, 100, 800, 600);
        frame.getContentPane().setLayout(new BorderLayout());

        // Crear la tabla de compañías
        table = new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        table.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Crear los botones de la barra de herramientas
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarCompania();
            }
        });

        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editarCompania();
            }
        });

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarCompania();
            }
        });

        // Crear la barra de herramientas
        JPanel toolBarPanel = new JPanel();
        toolBarPanel.setLayout(new BoxLayout(toolBarPanel, BoxLayout.X_AXIS));
        toolBarPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        toolBarPanel.add(btnAgregar);
        toolBarPanel.add(Box.createHorizontalStrut(5));
        toolBarPanel.add(btnEditar);
        toolBarPanel.add(Box.createHorizontalStrut(5));
        toolBarPanel.add(btnEliminar);
        toolBarPanel.add(Box.createHorizontalGlue());

        // Agregar la barra de herramientas a la ventana
        frame.getContentPane().add(toolBarPanel, BorderLayout.NORTH);

        // Crear el panel de búsqueda
        JPanel searchPanel = new JPanel();
        searchPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Búsqueda", TitledBorder.LEADING, TitledBorder.TOP));
        searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JLabel lblNombre = new JLabel("Nombre:");
        searchPanel.add(lblNombre);

        JTextField searchTextField = new JTextField();
        searchPanel.add(searchTextField);
        searchTextField.setColumns(20);

        JButton btnBuscar = new JButton("Buscar");
        searchPanel.add(btnBuscar);
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // buscarCompanias(searchTextField.getText());
            }
        });

        // Agregar el panel de búsqueda a la ventana
        frame.getContentPane().add(searchPanel, BorderLayout.SOUTH);

        // Cargar los datos de las compañías en la tabla
        cargarCompanias();

        // Mostrar la ventana
        frame.setVisible(true);
    }

    /**
     * Carga los datos de las compañías en la tabla.
     */
    private void cargarCompanias() {
        ArrayList<Compañias> companias = (ArrayList<Compañias>) companiaDAO.obtenerCompanias();

        // Definir las columnas de la tabla
        String[] columnas = {"Coberturas", "FormaPago","NCom", "Telcom"};
        model = new DefaultTableModel(columnas, 0);

        // Agregar las compañías como filas en la tabla
        for (Compañias compania : companias) {
            String[] fila = {compania.getCoberturas(), compania.getFormaPago(), compania.getNcom(),compania.getTelcom()};
            model.addRow(fila);
        }

        // Asignar el modelo a la tabla
        table.setModel(model);

        // Ajustar el ancho de las columnas
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(300);
        columnModel.getColumn(2).setPreferredWidth(100);
    }

    /**
     * Agrega una nueva compañía a la base de datos.
     */
    private void agregarCompania() {
        // Crear el panel de entrada de datos
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel lblCobertura = new JLabel("Cobertura:");
        GridBagConstraints gbc_lblCobertura = new GridBagConstraints();
        gbc_lblCobertura.anchor = GridBagConstraints.WEST;
        gbc_lblCobertura.insets = new Insets(0, 0, 5, 5);
        gbc_lblCobertura.gridx = 0;
        gbc_lblCobertura.gridy = 0;
        inputPanel.add(lblCobertura, gbc_lblCobertura);

        coberturasTextField = new JTextField();
        GridBagConstraints gbc_coberturasTextField = new GridBagConstraints();
        gbc_coberturasTextField.insets = new Insets(0, 0, 5, 0);
        gbc_coberturasTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_coberturasTextField.gridx = 1;
        gbc_coberturasTextField.gridy = 0;
        inputPanel.add(coberturasTextField, gbc_coberturasTextField);
        coberturasTextField.setColumns(20);

        JLabel lblFormaPago = new JLabel("FormaPago:");
        GridBagConstraints gbc_lblFormaPago = new GridBagConstraints();
        gbc_lblFormaPago.anchor = GridBagConstraints.WEST;
        gbc_lblFormaPago.insets = new Insets(0, 0, 5, 5);
        gbc_lblFormaPago.gridx = 0;
        gbc_lblFormaPago.gridy = 1;
        inputPanel.add( lblFormaPago, gbc_lblFormaPago);

        formaPagoTextField = new JTextField();
        GridBagConstraints gbc_formaPagoTextField = new GridBagConstraints();
        gbc_formaPagoTextField.insets = new Insets(0, 0, 5, 0);
        gbc_formaPagoTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_formaPagoTextField.gridx = 1;
        gbc_formaPagoTextField.gridy = 1;
        inputPanel.add(formaPagoTextField, gbc_formaPagoTextField);
        formaPagoTextField.setColumns(20);

        JLabel lblNcom = new JLabel("Ncom:");
        GridBagConstraints gbc_lblNCom = new GridBagConstraints();
        gbc_lblNCom.anchor = GridBagConstraints.WEST;
        gbc_lblNCom.insets = new Insets(0, 0, 5, 5);
        gbc_lblNCom.gridx = 0;
        gbc_lblNCom.gridy = 2;
        inputPanel.add(lblNcom, gbc_lblNCom);

        ncomTextField = new JTextField();
        GridBagConstraints gbc_ncomTextField = new GridBagConstraints();
        gbc_ncomTextField.insets = new Insets(0, 0, 5, 0);
        gbc_ncomTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_ncomTextField.gridx = 1;
        gbc_ncomTextField.gridy = 2;
        inputPanel.add(ncomTextField, gbc_ncomTextField);
        ncomTextField.setColumns(20);
        
        JLabel lblTelcom = new JLabel("Telcom:");
        GridBagConstraints gbc_lblTelcom = new GridBagConstraints();
        gbc_lblTelcom.anchor = GridBagConstraints.WEST;
        gbc_lblTelcom.insets = new Insets(0, 0, 5, 5);
        gbc_lblTelcom.gridx = 0;
        gbc_lblTelcom.gridy = 2;
        inputPanel.add(lblTelcom, gbc_lblTelcom);

        telcomTextField = new JTextField();
        GridBagConstraints gbc_TelComTextField = new GridBagConstraints();
        gbc_TelComTextField.insets = new Insets(0, 0, 5, 0);
        gbc_TelComTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_TelComTextField.gridx = 1;
        gbc_TelComTextField.gridy = 2;
        inputPanel.add(telcomTextField, gbc_TelComTextField);
        telcomTextField.setColumns(20);

        // Mostrar el diálogo de entrada de datos
        int result = JOptionPane.showConfirmDialog(frame, inputPanel, "Agregar Compañía",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            // Obtener los datos ingresados
        	String coberturas  = coberturasTextField.getText();
            String formaPago = formaPagoTextField.getText();
            String Ncom = ncomTextField.getText();
            String telcom = telcomTextField.getText();
            

            Compañias compania = new Compañias(coberturas,formaPago,Ncom,telcom);
            
           
            boolean success = companiaDAO.agregarCompania(compania);

            if (success) {
                // Actualizar la tabla con los nuevos datos
                cargarCompanias();
                JOptionPane.showMessageDialog(frame, "Compañía agregada exitosamente.", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Error al agregar la compañía.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Edita una compañía existente en la base de datos.
     */
    private void eliminarCompania() {
        // Obtener la fila seleccionada
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(frame, "Seleccione una compañía para eliminar.", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obtener el nombre de la compañía seleccionada
        String nombre = (String) table.getValueAt(selectedRow, 0);

        // Confirmar la eliminación
        int confirmResult = JOptionPane.showConfirmDialog(frame,
                "¿Está seguro de que desea eliminar la compañía " + nombre + "?", "Eliminar Compañía", JOptionPane.YES_NO_OPTION);
        if (confirmResult == JOptionPane.YES_OPTION) {
            // Eliminar la compañía de la base de datos
            boolean success = companiaDAO.eliminarCompania(nombre);

            if (success) {
                // Actualizar la tabla con los nuevos datos
                cargarCompanias();
                JOptionPane.showMessageDialog(frame, "Compañía eliminada exitosamente.", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Error al eliminar la compañía.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Carga las compañías desde la base de datos y las muestra en la tabla.
     */
	private void buscarCompañia() {
		
		
		
		
	}
    private void editarCompania() {
        // Obtener la fila seleccionada
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una compañía para editar.", "Advertencia",JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obtener los datos actuales de la compañía seleccionada
        String nombreActual = (String) table.getValueAt(selectedRow, 0);
        String cifActual = (String) table.getValueAt(selectedRow, 1);
        String direccionActual = (String) table.getValueAt(selectedRow, 2);
        
        // Crear el panel de entrada de datos
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());

        JLabel lblCobertura = new JLabel("Cobertura:");
        GridBagConstraints gbc_lblCobertura = new GridBagConstraints();
        gbc_lblCobertura.anchor = GridBagConstraints.WEST;
        gbc_lblCobertura.insets = new Insets(0, 0, 5, 5);
        gbc_lblCobertura.gridx = 0;
        gbc_lblCobertura.gridy = 0;
        inputPanel.add(lblCobertura, gbc_lblCobertura);

        coberturasTextField = new JTextField();
        GridBagConstraints gbc_coberturasTextField = new GridBagConstraints();
        gbc_coberturasTextField.insets = new Insets(0, 0, 5, 0);
        gbc_coberturasTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_coberturasTextField.gridx = 1;
        gbc_coberturasTextField.gridy = 0;
        inputPanel.add(coberturasTextField, gbc_coberturasTextField);
        coberturasTextField.setColumns(20);

        JLabel lblFormaPago = new JLabel("FormaPago:");
        GridBagConstraints gbc_lblFormaPago = new GridBagConstraints();
        gbc_lblFormaPago.anchor = GridBagConstraints.WEST;
        gbc_lblFormaPago.insets = new Insets(0, 0, 5, 5);
        gbc_lblFormaPago.gridx = 0;
        gbc_lblFormaPago.gridy = 1;
        inputPanel.add( lblFormaPago, gbc_lblFormaPago);

        formaPagoTextField = new JTextField();
        GridBagConstraints gbc_formaPagoTextField = new GridBagConstraints();
        gbc_formaPagoTextField.insets = new Insets(0, 0, 5, 0);
        gbc_formaPagoTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_formaPagoTextField.gridx = 1;
        gbc_formaPagoTextField.gridy = 1;
        inputPanel.add(formaPagoTextField, gbc_formaPagoTextField);
        formaPagoTextField.setColumns(20);

        JLabel lblNcom = new JLabel("Ncom:");
        GridBagConstraints gbc_lblNCom = new GridBagConstraints();
        gbc_lblNCom.anchor = GridBagConstraints.WEST;
        gbc_lblNCom.insets = new Insets(0, 0, 5, 5);
        gbc_lblNCom.gridx = 0;
        gbc_lblNCom.gridy = 2;
        inputPanel.add(lblNcom, gbc_lblNCom);

        ncomTextField = new JTextField();
        GridBagConstraints gbc_ncomTextField = new GridBagConstraints();
        gbc_ncomTextField.insets = new Insets(0, 0, 5, 0);
        gbc_ncomTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_ncomTextField.gridx = 1;
        gbc_ncomTextField.gridy = 2;
        inputPanel.add(ncomTextField, gbc_ncomTextField);
        ncomTextField.setColumns(20);
        
        JLabel lblTelcom = new JLabel("Telcom:");
        GridBagConstraints gbc_lblTelcom = new GridBagConstraints();
        gbc_lblTelcom.anchor = GridBagConstraints.WEST;
        gbc_lblTelcom.insets = new Insets(0, 0, 5, 5);
        gbc_lblTelcom.gridx = 0;
        gbc_lblTelcom.gridy = 2;
        inputPanel.add(lblTelcom, gbc_lblTelcom);

        telcomTextField = new JTextField();
        GridBagConstraints gbc_TelComTextField = new GridBagConstraints();
        gbc_TelComTextField.insets = new Insets(0, 0, 5, 0);
        gbc_TelComTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_TelComTextField.gridx = 1;
        gbc_TelComTextField.gridy = 2;
        inputPanel.add(telcomTextField, gbc_TelComTextField);
        telcomTextField.setColumns(20);
        
        // Mostrar el diálogo de entrada de datos
        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Editar Compañía",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            // Obtener los datos ingresados
        	String coberturas  = coberturasTextField.getText();
            String formaPago = formaPagoTextField.getText();
            String Ncom = ncomTextField.getText();
            String telcom = telcomTextField.getText();
           
            // Validar los campos de entrada
            if (coberturas.isEmpty() || formaPago.isEmpty() || Ncom.isEmpty()||telcom.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Advertencia",JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Crear un objeto Compania con los datos nuevos
            Compañias companiaNueva = new Compañias(coberturas,formaPago,Ncom,telcom);
            // Actualizar la compañía en la base de datos
            boolean success = companiaDAO.actualizarCompania(nombreActual, companiaNueva);

            if (success) {
                // Actualizar la tabla con los nuevos datos
                cargarCompanias();
                JOptionPane.showMessageDialog(null, "Compañía actualizada exitosamente.", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar la compañía.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }


}
