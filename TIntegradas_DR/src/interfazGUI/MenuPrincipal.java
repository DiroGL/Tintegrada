package interfazGUI;

import javax.imageio.ImageIO;
import javax.swing.*;

import conexionSQL.ConexionBD;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

public class MenuPrincipal extends JFrame {
    public MenuPrincipal() {
        // Configurar la ventana principal
        setTitle("Menú Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        // Crear el panel para los botones
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBackground(Color.WHITE);

        // Crear los botones para las opciones del menú principal
        JButton companiasButton = createMenuButton("Compañías", "imagenes/compañias.png");
        JButton ofertasButton = createMenuButton("Ofertas", "imagenes/discount.png");
        JButton precontratoButton = createMenuButton("Precontrato", "imagenes/precontract.png");
        JButton usuariosButton = createMenuButton("Usuarios", "imagenes/user.png");

        // Agregar los botones al panel
        buttonPanel.add(companiasButton);
        buttonPanel.add(ofertasButton);
        buttonPanel.add(precontratoButton);
        buttonPanel.add(usuariosButton);

        // Agregar el panel al centro del contenedor
        add(buttonPanel, BorderLayout.CENTER);

        // Mostrar la ventana principal
        setVisible(true);
    }

    private JButton createMenuButton(String text, String iconFile) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(26, 121, 255));
        button.setFocusPainted(false);

        // Agregar icono al botón
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream(iconFile)) {
            Image iconImage = ImageIO.read(stream);
            Image scaledIcon = iconImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(scaledIcon));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Estilo del botón al pasar el mouse
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(10, 91, 191));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(26, 121, 255));
            }
        });

        // Acción del botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para mostrar el menú secundario correspondiente
                showSecondaryMenu(text);
            }
        });

        return button;
    }

    private void showSecondaryMenu(String option) {
        int result = JOptionPane.showConfirmDialog(this, "¿Deseas ir al menú de " + option + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            switch (option) {
                case "Compañías":
                    break;
                case "Ofertas":
                    OfertasMenu ofertasMenu = new OfertasMenu();
                    ofertasMenu.OfertasMenu();
                    break;
                case "Precontrato":
                    PrecontratoMenu precontratoMenu = new PrecontratoMenu();
                    precontratoMenu.PrecontratoMenu();
                    break;
                case "Usuarios":
                    UsuariosMenu usuariosMenu = new UsuariosMenu();
                    usuariosMenu.UsuariosMenu();
                    break;
                default:
                    break;
            }
        }
    }


    private void openCompaniasMenu() {
        JOptionPane.showMessageDialog(this, "Abriendo el menú de Compañías");
      
    }

    private void openOfertasMenu() {
        JOptionPane.showMessageDialog(this, "Abriendo el menú de Ofertas");
    }

    private void openPrecontratoMenu() {
        JOptionPane.showMessageDialog(this, "Abriendo el menú de Precontrato");
    }

    private void openUsuariosMenu() {
        JOptionPane.showMessageDialog(this, "Abriendo el menú de Usuarios");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal();
            }
        });
    }
}
