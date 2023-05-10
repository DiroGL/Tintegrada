package Main;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import java.util.*;

import bbdd.*;
import Modelos.*;
import Orden.*;

public class MenuGUI extends JFrame implements ActionListener {

	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;

	private String compañias[] = { "Jazztel", "MasMovil", "Movistar", "Orange", "Pepephone", "Vodaphone", "Yoigo" };
	BD_Tintegrada bd = new BD_Tintegrada("tintegrada");

	public MenuGUI() {

		setTitle("DevelopersClub");
		boxsize();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Creamos el panel principal
		JPanel panelPrincipal = new JPanel(new GridLayout(10, 1));

		Menu();

	}

	// Método que se ejecuta al hacer clic en algún botón
	public void actionPerformed(ActionEvent e) {

		JLabel ptn1 = null, ptn2 = null, ptn3 = null, ptn4 = null, ptn5 = null, ptn6 = null, ptn7 = null, ptn8 = null;
		JButton sal = new JButton("Salida");
		Vector<oferta> comp = new Vector<oferta>();
		Vector<compañia> compa = new Vector<compañia>();
		if (e.getSource() == btn1) {
			boxsize();
			compa = bd.ListarComp();
			JPanel panelcaso1 = new JPanel(new GridLayout(compa.size()+1, 0));
			Vector<JLabel> botones = new Vector<JLabel>();
			for (int i = 0; i < compa.size(); i++) {
				botones.add(i, new JLabel(compa.get(i).getNombre()));
			}

			setTitle("Compañías");

			for (int i = 0; i < botones.size(); i++) {
				panelcaso1.add(botones.get(i));
			}

			Limpieza(panelcaso1, sal);

		} else if (e.getSource() == btn2) {
			
			setTitle("Ofertas De las compañias");
			boxsize();

			comp = bd.MostrarComp();
			JPanel panelcaso2 = new JPanel(new GridLayout(comp.size()+2, 1));
			Vector<JLabel> botones = new Vector<JLabel>();
			for (int i = 0; i < comp.size(); i++) {
				botones.add(i, new JLabel(comp.get(i).toString()));
			}
			ptn8 = new JLabel(" COMPAÑIAS: ");
			panelcaso2.add(ptn8);
			for (int i = 0; i < botones.size(); i++) {
				panelcaso2.add(botones.get(i));
			}
			Limpieza(panelcaso2, sal);

		} else if (e.getSource() == btn3) {

			setTitle("Precios ordenados en su máxima tarifa");
			boxsize();

			comp = bd.MostrarComp();
			Collections.sort(comp, new OrdenarPrecio());

			JPanel panelcaso2 = new JPanel(new GridLayout(comp.size()+2, 1));

			Vector<JLabel> botones = new Vector<JLabel>();
			for (int i = 0; i < comp.size(); i++) {
				// botones.set(i,new JLabel (compa.get(i).getNombre()));
				botones.add(i, new JLabel(comp.get(i).toString()));
			}

			ptn8 = new JLabel(" COMPAÑIAS: ");
			panelcaso2.add(ptn8);
			for (int i = 0; i < botones.size(); i++) {
				panelcaso2.add(botones.get(i));
			}

			Limpieza(panelcaso2, sal);

		} else if (e.getSource() == btn4) {

			setTitle("Precios ordenados de las ofertas por Permanencia");
			boxsize();

			comp = bd.MostrarComp();
			Collections.sort(comp, new OrdenarPermanencia());

			JPanel panelcaso2 = new JPanel(new GridLayout(comp.size()+2, 1));
			Vector<JLabel> botones = new Vector<JLabel>();

			for (int i = 0; i < comp.size(); i++) {
				botones.add(i, new JLabel(comp.get(i).toString()));
			}
			ptn8 = new JLabel(" COMPAÑIAS: ");
			panelcaso2.add(ptn8);
			for (int i = 0; i < botones.size(); i++) {
				panelcaso2.add(botones.get(i));
			}

			Limpieza(panelcaso2, sal);

		} else if (e.getSource() == btn5) {

			setTitle("Seleccione compañía");
			boxsize();

			Vector<JButton> boton = new Vector<JButton>();
			compa = bd.ListarComp();

			JPanel panelcaso2 = new JPanel(new GridLayout(compa.size()+1, 1));

			for (int i = 0; i < compa.size(); i++) {
				boton.add(i, new JButton(compa.get(i).getNombre()));
			}

			for (int i = 0; i < compa.size(); i++) {
				Tarifa tar = bd.MostrarTar(compa.get(i).getNombre());

				boton.get(i).addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						JOptionPane.showMessageDialog(null, tar.toString());

					}
				});

			}

			for (int i = 0; i < boton.size(); i++) {
				panelcaso2.add(boton.get(i));
			}

			Limpieza(panelcaso2, sal);

		} else if (e.getSource() == btn6) {

			JPanel panelBusqueda = new JPanel(new GridLayout(4, 1));
			setTitle("Seleccione el número de megas");
			boxsize();
			Vector<JTextField> text= menubusqueda(panelBusqueda);
			

			JButton botonBusqueda = new JButton("Buscar");
			panelBusqueda.add(botonBusqueda);
			botonBusqueda.addActionListener(new ActionListener(){
	          
	        	 
	        	 String textoBusqueda = text.get(0).getText();
	        	 String textoBusqueda2 = text.get(1).getText();
				public void actionPerformed(ActionEvent e) {
					Vector<oferta> bus = bd.BusquedaMegas(textoBusqueda, textoBusqueda2);
					JPanel panelBusqueda = new JPanel(new GridLayout(bus.size(), 1));
					setTitle("Aqui se muestran lso megas entre " + textoBusqueda + " y " + textoBusqueda2);
					boxsize();
					Vector<JLabel> ofer = new Vector<JLabel>();
					for (int i = 0; i < bus.size(); i++) {
						ofer.add(new JLabel (bus.get(i).toString()));
					}
					
					for (int i = 0; i < ofer.size(); i++) {
						panelBusqueda.add(ofer.get(i));
					}
					VolverAtras(panelBusqueda, sal);
					
					
					
				}
	        });
	       
			Limpieza(panelBusqueda, sal);
		} else if (e.getSource() == btn7) {
			System.out.println("Opc 7");
		} else if (e.getSource() == btn8) {
			JOptionPane.showMessageDialog(null, "Has seleccionado la opción 8");
		} else if (e.getSource() == btn9) {
			JOptionPane.showMessageDialog(null, "Has seleccionado la opción 9");
		} else if (e.getSource() == btn10) {
			getContentPane().removeAll();
			getContentPane().revalidate();
			getContentPane().repaint();

		}
	}

	public static void main(String[] args) {
		new MenuGUI();
	}

	public void boxsize() {
		setSize(1920, 1080);
	}

	public void Menu() {
		setTitle("Menu de opciones");
		boxsize();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Creamos el panel principal
		JPanel panelPrincipal = new JPanel(new GridLayout(10, 1));

		btn1 = new JButton("Ver las compañias");
		btn2 = new JButton("Ofertas de compañías");
		btn3 = new JButton("Ordenar por precio ofertas");
		btn4 = new JButton("Ordenar por duración de contrato");
		btn5 = new JButton("Tarifas");
		btn6 = new JButton("Buscar por megas");
		btn7 = new JButton("Información de compañía a elegir");
		btn8 = new JButton("Telefono fijo");
		btn9 = new JButton("Información de forma de pago");
		btn10 = new JButton("Salir");

		// Asignamos un ActionListener a cada botón
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// Añadimos los botones al panel principal
		panelPrincipal.add(btn1);
		panelPrincipal.add(btn2);
		panelPrincipal.add(btn3);
		panelPrincipal.add(btn4);
		panelPrincipal.add(btn5);
		panelPrincipal.add(btn6);
		panelPrincipal.add(btn7);
		panelPrincipal.add(btn8);
		panelPrincipal.add(btn9);
		panelPrincipal.add(btn10);

		// Añadimos el panel principal al JFrame
		getContentPane().add(panelPrincipal);

		// Hacemos visible la interfaz gráfica
		setVisible(true);

	}

	public Vector<JTextField> menubusqueda(JPanel panelBusqueda) {
		JLabel part1 = new JLabel("Introduzca el minimo de megas"); 
		panelBusqueda.add(part1);
		Vector<JTextField> text = new Vector<JTextField>();
		
		// Caja de texto de búsqueda
		JTextField cajaTexto = new JTextField();
		cajaTexto.setPreferredSize(new Dimension(300, 30));
		panelBusqueda.add(cajaTexto, BorderLayout.CENTER);
		text.add(cajaTexto);
		
		
		JLabel part2 = new JLabel("Introduzca el maximo de megas");
		panelBusqueda.add(part2);
		
		JTextField cajaTexto2 = new JTextField();
		cajaTexto.setPreferredSize(new Dimension(300, 30));
		panelBusqueda.add(cajaTexto2, BorderLayout.CENTER);
		text.add(cajaTexto2);
		JOptionPane.showMessageDialog(null, text.get(0).getText());
		return text;
		
	}

	public void Limpieza(JPanel panelcaso2, JButton sal) {

		panelcaso2.add(sal);
		getContentPane().removeAll();
		getContentPane().revalidate();
		getContentPane().repaint();
		getContentPane().add(panelcaso2);
		pack();
		setVisible(true);
		sal.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				Menu();
			}
		});
	}
	public void VolverAtras(JPanel panelcaso2, JButton sal) {

		panelcaso2.add(sal);
		getContentPane().removeAll();
		getContentPane().revalidate();
		getContentPane().repaint();
		getContentPane().add(panelcaso2);
		pack();
		setVisible(true);
		sal.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				menubusqueda(panelcaso2);
			}
		});
	}

}
