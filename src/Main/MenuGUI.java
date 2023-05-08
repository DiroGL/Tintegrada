package Main;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import java.util.*;

import bbdd.*;
import Modelos.*;

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

		// Creamos los botones de la interfaz
		/*btn1 = new JButton("Ver las compañias");
		btn2 = new JButton("Ordenar por precio");
		btn3 = new JButton("Buscar por megas");
		btn4 = new JButton("Ordenar por duración de contrato");
		btn5 = new JButton("Información de forma de pago");
		btn6 = new JButton("Precios de líneas a contratar");
		btn7 = new JButton("Ofertas de compañías");
		btn8 = new JButton("Telefono fijo");
		btn9 = new JButton("Información de compañía a elegir");
		btn10 = new JButton("Salir"); */
		
		Menu();

	
	
		
	}

	// Método que se ejecuta al hacer clic en algún botón
	public void actionPerformed(ActionEvent e) {

		JLabel ptn1, ptn2, ptn3, ptn4, ptn5, ptn6, ptn7, ptn8;
		JButton sal;
		Vector<oferta> comp = new Vector<oferta>();
		if (e.getSource() == btn1) {
			boxsize();
			JPanel panelcaso1 = new JPanel(new GridLayout(8, 1));
			setTitle("Compañías");
			

			ptn1 = new JLabel("- Jazztel");
			ptn2 = new JLabel("- MasMovil");
			ptn3 = new JLabel("- Movistar");
			ptn4 = new JLabel("- Orange");
			ptn5 = new JLabel("- Pepephone");
			ptn6 = new JLabel("- Vodafone");
			ptn7 = new JLabel("- Yoigo");
			sal = new JButton("- Salida");

			panelcaso1.add(ptn1);
			panelcaso1.add(ptn2);
			panelcaso1.add(ptn3);
			panelcaso1.add(ptn4);
			panelcaso1.add(ptn5);
			panelcaso1.add(ptn6);
			panelcaso1.add(ptn7);
			sal.addActionListener(this);
			panelcaso1.add(sal);
			getContentPane().removeAll();
			getContentPane().revalidate();
			getContentPane().repaint();
			getContentPane().add(panelcaso1);
			setVisible(true);
			sal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getContentPane().removeAll();
					Menu();
				}
			});
		} else if (e.getSource() == btn2) {
			JPanel panelcaso2 = new JPanel(new GridLayout(9, 1));
			setTitle("Precios ordenados en su máxima tarifa");
			boxsize();

	

			comp = bd.MostrarComp();
			//Collections.sort(comp,new OrdenarPrecio());
			
			ptn8 = new JLabel(
					" COMPAÑIAS: ");
			panelcaso2.add(ptn8);
			if (comp.size() > 0) {
				ptn1 = new JLabel(comp.get(0).toString());
				panelcaso2.add(ptn1);
			}
			if (comp.size() > 1) {
				ptn2 = new JLabel(comp.get(1).toString());
				panelcaso2.add(ptn2);
			}
			if (comp.size() > 2) {
				ptn3 = new JLabel(comp.get(2).toString());
				panelcaso2.add(ptn3);
			}
			if (comp.size() > 3) {
				ptn4 = new JLabel(comp.get(3).toString());
				panelcaso2.add(ptn4);
			}
			if (comp.size() > 4) {
				ptn5 = new JLabel(comp.get(4).toString());
				panelcaso2.add(ptn5);
			}
			if (comp.size() > 5) {
				ptn6 = new JLabel(comp.get(5).toString());
				panelcaso2.add(ptn6);
			}
			if (comp.size() > 6) {
				ptn7 = new JLabel(comp.get(6).toString());
				panelcaso2.add(ptn7);
			}
			sal = new JButton("- Salida");

			sal.addActionListener(this);
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

		} else if (e.getSource() == btn3) {
			JPanel panelcaso2 = new JPanel(new GridLayout(9, 1));
			setTitle("Precios ordenados en su máxima tarifa");
			boxsize();


			comp = bd.MostrarComp();
			Collections.sort(comp,new OrdenarPrecio());
			
			ptn8 = new JLabel(
					" COMPAÑIAS: ");
			panelcaso2.add(ptn8);
			if (comp.size() > 0) {
				ptn1 = new JLabel(comp.get(0).toString());
				panelcaso2.add(ptn1);
			}
			if (comp.size() > 1) {
				ptn2 = new JLabel(comp.get(1).toString());
				panelcaso2.add(ptn2);
			}
			if (comp.size() > 2) {
				ptn3 = new JLabel(comp.get(2).toString());
				panelcaso2.add(ptn3);
			}
			if (comp.size() > 3) {
				ptn4 = new JLabel(comp.get(3).toString());
				panelcaso2.add(ptn4);
			}
			if (comp.size() > 4) {
				ptn5 = new JLabel(comp.get(4).toString());
				panelcaso2.add(ptn5);
			}
			if (comp.size() > 5) {
				ptn6 = new JLabel(comp.get(5).toString());
				panelcaso2.add(ptn6);
			}
			if (comp.size() > 6) {
				ptn7 = new JLabel(comp.get(6).toString());
				panelcaso2.add(ptn7);
			}
			sal = new JButton("- Salida");

			sal.addActionListener(this);
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

			
		} else if (e.getSource() == btn4) {
			JPanel panelcaso4 = new JPanel(new GridLayout(9, 1));
			setTitle("Compañías ordenadas en su máximo contrato");
			boxsize();
			ptn1 = new JLabel("- Compañias-----");
			ptn2 = new JLabel("- Pepephone-----Duración: 0 años");
			ptn3 = new JLabel("- Vodafone------Duración: 1 año");
			ptn4 = new JLabel("- Jazztel-------Duración: 1 año / 2 años");
			ptn5 = new JLabel("- MasMovil------Duración: 1 año / 2 años");
			ptn6 = new JLabel("- Movistar------Duración: 2 años");
			ptn7 = new JLabel("- Orange--------Duración: 2 años");
			ptn8 = new JLabel("- Yoigo---------Duración: 2 años");
			sal = new JButton("- Salida");

			panelcaso4.add(ptn1);
			panelcaso4.add(ptn2);
			panelcaso4.add(ptn3);
			panelcaso4.add(ptn4);
			panelcaso4.add(ptn5);
			panelcaso4.add(ptn6);
			panelcaso4.add(ptn7);
			panelcaso4.add(ptn8);
			sal.addActionListener(this);
			panelcaso4.add(sal);
			getContentPane().removeAll();
			getContentPane().revalidate();
			getContentPane().repaint();
			getContentPane().add(panelcaso4);
			pack();
			setVisible(true);
			sal.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					getContentPane().removeAll();
					Menu();
				}
			});

		} else if (e.getSource() == btn5) {

			JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7;

			JPanel panelcaso5 = new JPanel(new GridLayout(8, 1));
			setTitle("Seleccione compañía");
			boxsize();
			btn1 = new JButton("Movistar");
			btn2 = new JButton("Pepephone");
			btn3 = new JButton("Yoigo");
			btn4 = new JButton("Jazztel");
			btn5 = new JButton("Orange");
			btn6 = new JButton("Vodafone");
			btn7 = new JButton("MasMovil");
			sal = new JButton("Salida");

			btn1.addActionListener(this);
			btn2.addActionListener(this);
			btn3.addActionListener(this);
			btn4.addActionListener(this);
			btn5.addActionListener(this);
			btn6.addActionListener(this);
			btn7.addActionListener(this);

			panelcaso5.add(btn1);
			panelcaso5.add(btn2);
			panelcaso5.add(btn3);
			panelcaso5.add(btn4);
			panelcaso5.add(btn5);
			panelcaso5.add(btn6);
			panelcaso5.add(btn7);

			sal.addActionListener(this);
			panelcaso5.add(sal);
			getContentPane().removeAll();
			getContentPane().revalidate();
			getContentPane().repaint();
			getContentPane().add(panelcaso5);
			pack();
			setVisible(true);
			sal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getContentPane().removeAll();
					Menu();
				}
			});
			btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panelcaso5_1 = new JPanel(new GridLayout(9, 1));
					setTitle("Movistar");
					boxsize();
					JLabel ptn31, ptn32, ptn33, ptn34, ptn35, ptn36, ptn37, ptn38;
					JButton sal1;

					ptn31 = new JLabel("Pago con tarjeta de crédito o débito, estés donde estés:");
					ptn32 = new JLabel(" - En Mi Movistar: Al entrar verás tus facturas pendientes y podrás pagarlas.");
					ptn33 = new JLabel(
							" - Llamando al 1004 (número gratuito): Te daremos las indicaciones para efectuar el pago.");
					ptn34 = new JLabel("Pago en una oficina de Correos, del BBVA o del Banco Santander.");
					ptn35 = new JLabel(
							" - Importe a pagar: Si no lo sabes, puedes consultarlo accediendo al Área Cliente Mi Movistar, app Mi Movistar o llamando al 1004.");
					ptn36 = new JLabel(
							" - Emisora: Movistar Fusión/Fijo (si la factura es de miMovistar, de Fusión o de fijo) o Movistar Móvil (si la factura es de móvil).");
					ptn37 = new JLabel(
							" - Número del documento de identidad del titular sin letras: Por ejemplo, 01111111.");
					ptn38 = new JLabel(" - Número de teléfono que tiene la factura pendiente.");

					sal1 = new JButton("Salida");

					panelcaso5_1.add(ptn31);
					panelcaso5_1.add(ptn32);
					panelcaso5_1.add(ptn33);
					panelcaso5_1.add(ptn34);
					panelcaso5_1.add(ptn35);
					panelcaso5_1.add(ptn36);
					panelcaso5_1.add(ptn37);
					panelcaso5_1.add(ptn38);

					sal1.addActionListener(this);
					panelcaso5_1.add(sal);
					getContentPane().removeAll();
					getContentPane().revalidate();
					getContentPane().repaint();
					getContentPane().add(panelcaso5_1);
					setVisible(true);
					sal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							getContentPane().removeAll();
							Menu3();
						}

					});

				}

			});

			btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panelcaso5_2 = new JPanel(new GridLayout(5, 1));
					setTitle("Pepephone");
					setSize(800, 450);
					JLabel ptn31, ptn32, ptn33, ptn34;
					JButton sal1;

					ptn31 = new JLabel(
							"Puedes pagar una factura pendiente de Pepephone con tarjeta o en efectivo en una agencia Halcón Viajes o Viajes Ecuador");
					ptn32 = new JLabel(
							"También puedes pagar una factura atrasada de Pepephone online. Desde el área de cliente con tu tarjeta de crédito o débito.");
					ptn33 = new JLabel(
							"Otra opción para pagar una factura pendiente de Pepephone es haciendo una transferencia bancaria");
					ptn34 = new JLabel(
							"O un ingreso en la cuenta de Bankia de la compañía. Tienes que indicar en el concepto el DNI del titular de la línea.");

					sal1 = new JButton("Salida");

					panelcaso5_2.add(ptn31);
					panelcaso5_2.add(ptn32);
					panelcaso5_2.add(ptn33);
					panelcaso5_2.add(ptn34);

					sal1.addActionListener(this);
					panelcaso5_2.add(sal);
					getContentPane().removeAll();
					getContentPane().revalidate();
					getContentPane().repaint();
					getContentPane().add(panelcaso5_2);
					setVisible(true);
					sal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							getContentPane().removeAll();
							Menu3();
						}

					});

				}

			});

			btn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panelcaso5_3 = new JPanel(new GridLayout(5, 1));
					setTitle("Yoigo");
					setSize(800, 450);
					JLabel ptn31, ptn32, ptn33, ptn34;
					JButton sal1;

					ptn31 = new JLabel(
							"Puedes pagar con tarjetas.  Para ello, puedes hacerlo entrando en pago.yoigo.com o llamando al 622");
					ptn32 = new JLabel(
							"Con bizum sólo necesitas tu teléfono móvil. Encontraras esta opción en pago.yoigo.com y seguir estos pasos.");
					ptn33 = new JLabel("Puedes pagar en efectivo en los cajeros del banco BBVA.");
					ptn34 = new JLabel(
							"Puedes pagar haciendo una transferencia a este número de cuenta: ES75 0049 1500 08 2110410351 con tu DNI");

					sal1 = new JButton("Salida");

					panelcaso5_3.add(ptn31);
					panelcaso5_3.add(ptn32);
					panelcaso5_3.add(ptn33);
					panelcaso5_3.add(ptn34);

					sal1.addActionListener(this);
					panelcaso5_3.add(sal);
					getContentPane().removeAll();
					getContentPane().revalidate();
					getContentPane().repaint();
					getContentPane().add(panelcaso5_3);
					setVisible(true);
					sal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							getContentPane().removeAll();
							Menu3();
						}

					});

				}

			});

			btn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panelcaso5_4 = new JPanel(new GridLayout(6, 1));
					setTitle("Jazztel");
					boxsize();
					JLabel ptn31, ptn32, ptn33, ptn34, ptn35;
					JButton sal1;

					ptn31 = new JLabel(
							"Con tarjeta en tu área de clientes web, en el detalle de la factura, pulsando sobre el botón Pagar Factura");
					ptn32 = new JLabel(
							"Dentro de tu App, en el apartado “Mis facturas”, pulsando sobre el botón Pagar Factura");
					ptn33 = new JLabel(
							"Realizando una transferencia bancaria al número de cuenta BBVA:  ES89 0182 3994 00 0014690030. ");
					ptn34 = new JLabel("En cualquier cajero automático de las Oficinas del BBVA ó La Caixa.");
					ptn35 = new JLabel("Llamando al 1565 para el pago mediante tarjeta de débito o crédito ");

					sal1 = new JButton("Salida");

					panelcaso5_4.add(ptn31);
					panelcaso5_4.add(ptn32);
					panelcaso5_4.add(ptn33);
					panelcaso5_4.add(ptn34);
					panelcaso5_4.add(ptn35);

					sal1.addActionListener(this);
					panelcaso5_4.add(sal);
					getContentPane().removeAll();
					getContentPane().revalidate();
					getContentPane().repaint();
					getContentPane().add(panelcaso5_4);
					setVisible(true);
					sal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							getContentPane().removeAll();
							Menu3();
						}

					});

				}

			});

			btn5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panelcaso5_5 = new JPanel(new GridLayout(4, 1));
					setTitle("Orange");
					boxsize();
					JLabel ptn31, ptn32, ptn33;
					JButton sal1;

					ptn31 = new JLabel(
							"Si quieres, puedes pagar tu factura pendiente por teléfono: llama al 1478 desde un móvil o llama al 656001478 desde un fijo.");
					ptn32 = new JLabel(
							"Por transferencia: ES41 0049 1500 0229 1012 7757 en el Santander o ES03 0182 3994 0002 0151 5421 en el BBVA");
					ptn33 = new JLabel(" Por transferencia: ES88 2038 0969 4760 0003 1614 en Bankia");

					sal1 = new JButton("Salida");

					panelcaso5_5.add(ptn31);
					panelcaso5_5.add(ptn32);
					panelcaso5_5.add(ptn33);

					sal1.addActionListener(this);
					panelcaso5_5.add(sal);
					getContentPane().removeAll();
					getContentPane().revalidate();
					getContentPane().repaint();
					getContentPane().add(panelcaso5_5);
					setVisible(true);
					sal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							getContentPane().removeAll();
							Menu3();
						}

					});

				}

			});

			btn6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panelcaso5_6 = new JPanel(new GridLayout(5, 1));
					setTitle("Vodafone");
					boxsize();
					JLabel ptn31, ptn32, ptn33, ptn34;
					JButton sal1;

					ptn31 = new JLabel(
							" Está disponible Mi Vodafone y te permite pagar facturas pendientes de los últimos 12 meses. ");
					ptn32 = new JLabel(
							"Entrando en https://www.vodafone.es/c/pagodeuda/, puedes pagar tu factura con tarjeta de crédito o débito");
					ptn33 = new JLabel(
							"Puedes pagar tu factura Vodafone en Correos con el DNI. Este pago solo puede realizarse en efectivo.");
					ptn34 = new JLabel(
							"Puedes pagar tu factura en efectivo o una transferencia bancaria en la cuenta del Banco Santander ES25-0049-1500-09-2219314266");

					sal1 = new JButton("Salida");

					panelcaso5_6.add(ptn31);
					panelcaso5_6.add(ptn32);
					panelcaso5_6.add(ptn33);
					panelcaso5_6.add(ptn34);

					sal1.addActionListener(this);
					panelcaso5_6.add(sal);
					getContentPane().removeAll();
					getContentPane().revalidate();
					getContentPane().repaint();
					getContentPane().add(panelcaso5_6);
					setVisible(true);
					sal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							getContentPane().removeAll();
							Menu3();
						}

					});

				}

			});

		} else if (e.getSource() == btn6) {
			JButton btn1, btn2, btn3, btn4, btn5;

			JPanel panelcaso3 = new JPanel(new GridLayout(6, 1));
			setTitle("Seleccione el número de megas");
			boxsize();

			btn1 = new JButton("300 megas");
			btn2 = new JButton("500 megas");
			btn3 = new JButton("600 megas");
			btn4 = new JButton("800 megas");
			btn5 = new JButton("1000 megas");
			sal = new JButton("Salida");

			btn1.addActionListener(this);
			btn2.addActionListener(this);
			btn3.addActionListener(this);
			btn4.addActionListener(this);
			btn5.addActionListener(this);

			panelcaso3.add(btn1);
			panelcaso3.add(btn2);
			panelcaso3.add(btn3);
			panelcaso3.add(btn4);
			panelcaso3.add(btn5);

			sal.addActionListener(this);
			panelcaso3.add(sal);
			getContentPane().removeAll();
			getContentPane().revalidate();
			getContentPane().repaint();
			getContentPane().add(panelcaso3);
			pack();
			setVisible(true);
			sal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getContentPane().removeAll();
					Menu();
				}
			});
			btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panelcaso3_1 = new JPanel(new GridLayout(5, 1));
					setTitle("300 Megas");
					setSize(600, 450);
					JLabel ptn31, ptn32, ptn33, ptn34;
					JButton sal1;

					ptn31 = new JLabel("- MasMovil------Fibra de 300 megas: 24.99€/mes");
					ptn32 = new JLabel("- Jazztel-------Fibra de 300 megas: 28.95€/mes");
					ptn33 = new JLabel("- Movistar------Fibra de 300 megas: 29.90€/mes");
					ptn34 = new JLabel("- Yoigo---------Fibra de 300 megas: 32.00€/mes");
					sal1 = new JButton("Salida");

					panelcaso3_1.add(ptn31);
					panelcaso3_1.add(ptn32);
					panelcaso3_1.add(ptn33);
					panelcaso3_1.add(ptn34);

					sal1.addActionListener(this);
					panelcaso3_1.add(sal);
					getContentPane().removeAll();
					getContentPane().revalidate();
					getContentPane().repaint();
					getContentPane().add(panelcaso3_1);
					setVisible(true);
					sal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							getContentPane().removeAll();
							Menu3();
						}

					});

				}

			});
			btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panelcaso3_2 = new JPanel(new GridLayout(3, 1));
					setTitle("500 Megas");
					boxsize();
					JLabel ptn31, ptn32;
					JButton sal1;

					ptn31 = new JLabel("- Orange--------Fibra de 500 megas: 30.95€/mes");
					ptn32 = new JLabel("- Pepephone-----Fibra de 500 megas: 42.90€/mes");
					sal1 = new JButton("Salida");

					panelcaso3_2.add(ptn31);
					panelcaso3_2.add(ptn32);

					sal1.addActionListener(this);
					panelcaso3_2.add(sal);
					getContentPane().removeAll();
					getContentPane().revalidate();
					getContentPane().repaint();
					getContentPane().add(panelcaso3_2);
					setVisible(true);
					sal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							getContentPane().removeAll();
							Menu3();
						}

					});

				}

			});
			btn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panelcaso3_3 = new JPanel(new GridLayout(6, 1));
					setTitle("600 Megas");
					boxsize();
					JLabel ptn31, ptn32, ptn33, ptn34, ptn35;
					JButton sal1;

					ptn31 = new JLabel("- MasMovil------Fibra de 600 megas: 29.99€/mes");
					ptn32 = new JLabel("- Vodafone------Fibra de 600 megas: 30.40€/mes");
					ptn33 = new JLabel("- Jazztel-------Fibra de 600 megas: 32.95€/mes");
					ptn34 = new JLabel("- Movistar------Fibra de 600 megas: 33.90€/mes");
					ptn35 = new JLabel("- Yoigo---------Fibra de 600 megas: 42.00€/mes");

					sal1 = new JButton("Salida");

					panelcaso3_3.add(ptn31);
					panelcaso3_3.add(ptn32);
					panelcaso3_3.add(ptn33);
					panelcaso3_3.add(ptn34);
					panelcaso3_3.add(ptn35);

					sal1.addActionListener(this);
					panelcaso3_3.add(sal);
					getContentPane().removeAll();
					getContentPane().revalidate();
					getContentPane().repaint();
					getContentPane().add(panelcaso3_3);
					setVisible(true);
					sal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							getContentPane().removeAll();
							Menu3();
						}

					});

				}

			});
			btn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panelcaso3_4 = new JPanel(new GridLayout(2, 1));
					setTitle("800 Megas");
					boxsize();
					JLabel ptn31;
					JButton sal1;

					ptn31 = new JLabel("- Pepephone--------Fibra de 800 megas: 50.90€/mes");
					sal1 = new JButton("Salida");

					panelcaso3_4.add(ptn31);

					sal1.addActionListener(this);
					panelcaso3_4.add(sal);
					getContentPane().removeAll();
					getContentPane().revalidate();
					getContentPane().repaint();
					getContentPane().add(panelcaso3_4);
					setVisible(true);
					sal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							getContentPane().removeAll();
							Menu3();
						}

					});

				}

			});
			btn5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panelcaso3_5 = new JPanel(new GridLayout(7, 1));
					setTitle("1 Giga");
					boxsize();
					JLabel ptn31, ptn32, ptn33, ptn34, ptn35, ptn36;
					JButton sal1;

					ptn31 = new JLabel("- Jazztel-------Fibra de un Giga: 33.95€/mes");
					ptn32 = new JLabel("- MasMovil------Fibra de un Giga: 34.99€/mes");
					ptn33 = new JLabel("- Orange--------Fibra de un Giga: 40.95€/mes");
					ptn34 = new JLabel("- Vodafone------Fibra de un Giga: 41.30€/mes");
					ptn35 = new JLabel("- Movistar------Fibra de un Giga: 43.90€/mes");
					ptn36 = new JLabel("- Yoigo---------Fibra de un Giga: 47.00€/mes");

					sal1 = new JButton("Salida");

					panelcaso3_5.add(ptn31);
					panelcaso3_5.add(ptn32);
					panelcaso3_5.add(ptn33);
					panelcaso3_5.add(ptn34);
					panelcaso3_5.add(ptn35);
					panelcaso3_5.add(ptn36);

					sal1.addActionListener(this);
					panelcaso3_5.add(sal);
					getContentPane().removeAll();
					getContentPane().revalidate();
					getContentPane().repaint();
					getContentPane().add(panelcaso3_5);
					setVisible(true);
					sal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							getContentPane().removeAll();
							Menu3();
						}

					});

				}

			});
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
		btn5 = new JButton("Precios de líneas a contratar");
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
		btn10.addActionListener(this);

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

	public void Menu3() {
		JButton btn1, btn2, btn3, btn4, btn5, sal;

		JPanel panelcaso3 = new JPanel(new GridLayout(6, 1));
		setTitle("Seleccione el número de megas");
		setSize(1920, 1080);

		btn1 = new JButton("300 megas");
		btn2 = new JButton("500 megas");
		btn3 = new JButton("600 megas");
		btn4 = new JButton("800 megas");
		btn5 = new JButton("1000 megas");
		sal = new JButton("Salida");

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);

		panelcaso3.add(btn1);
		panelcaso3.add(btn2);
		panelcaso3.add(btn3);
		panelcaso3.add(btn4);
		panelcaso3.add(btn5);

		sal.addActionListener(this);
		panelcaso3.add(sal);
		getContentPane().removeAll();
		getContentPane().revalidate();
		getContentPane().repaint();
		getContentPane().add(panelcaso3);
		pack();
		setVisible(true);
		sal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				Menu();
			}
		});
	}
}
