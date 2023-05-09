package interfazGUI;

import javax.swing.*;

import conexionSQL.ConexionBD;
import interfaz.InterfazBD;
import interfaz.InterfazBDImpl;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class OpereacionesCrud extends JFrame {

	private InterfazBD interfazBD;
	private ConexionBD conexion;
	// Crea los componentes de la GUI (botones, etiquetas, etc.)
	private JButton crearButton;
	private JButton leerButton;
	private JButton actualizarButton;
	private JButton eliminarButton;

	public OpereacionesCrud() {

		conexion = new ConexionBD("tintegrador");
	}

	public void InterfazGrafica() {
		// Crea una instancia de la implementación de InterfazBD
		interfazBD = new InterfazBDImpl(conexion.abrirConexion());

		// Configura la ventana principal de la GUI
		setTitle("Interfaz CRUD");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Crea los componentes de la GUI
		crearButton = new JButton("Crear");
		leerButton = new JButton("Leer");
		actualizarButton = new JButton("Actualizar");
		eliminarButton = new JButton("Eliminar");

		// Agrega controladores de eventos a los botones
		crearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Lógica para la creación de un registro en la base de datos
				interfazBD.crearRegistro();
			}
		});

		leerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Lógica para la lectura de un registro de la base de datos
				interfazBD.leerRegistro();
			}
		});

		actualizarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Lógica para la actualización de un registro en la base de datos
				interfazBD.actualizarRegistro();
			}
		});

		eliminarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Lógica para la eliminación de un registro de la base de datos
				interfazBD.eliminarRegistro();
			}
		});

		// Agrega los componentes a la ventana principal
		getContentPane().setLayout(new GridLayout(2, 2));
		getContentPane().add(crearButton);
		getContentPane().add(leerButton);
		getContentPane().add(actualizarButton);
		getContentPane().add(eliminarButton);
		// Muestra la ventana principal de la GUI
		setVisible(true);
	}

	public static void main(String[] args) {
		// Crea una instancia de la interfaz gráfica
		OpereacionesCrud interfaz = new OpereacionesCrud();
		interfaz.InterfazGrafica();
	}
}
