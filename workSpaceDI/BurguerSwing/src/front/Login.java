package front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import models.Usuario;
import util.UtilidadesLogin;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import models.*;
import util.*;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textNombreUsuario;
    private JTextField textContrasenia;
    
    // Crear objetos de prueba y añadirlos a la lista
    Bebida bebida1 = new Bebida("Refresco", 2);
    Bebida bebida2 = new Bebida("Café", 3);
    Bebida bebida3 = new Bebida("Té", 2);
    
    // Crear objetos de prueba y añadirlos a la lista
    String ingredientes1 = "Pan,Carne,Lechuga,Tomate";
    Comida comida1 = new Comida("Hamburguesa", 5, ingredientes1);

    String ingredientes2 = "Arroz,Pollo,Verduras";
    Comida comida2 = new Comida("Arroz con Pollo", 7, ingredientes2);

    String ingredientes3 = "Pasta,Salsa de tomate,Queso";
    Comida comida3 = new Comida("Pasta a la bolognesa", 8, ingredientes3);
    
    // Crear un objeto de prueba y añadirlo a la lista
    Usuario usuario = new Usuario("usuario1", "contraseña123");


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Login() {
        // Añadimos ejemplos
        UtilidadesLogin.bebidas.add(bebida1);
        UtilidadesLogin.bebidas.add(bebida2);
        UtilidadesLogin.bebidas.add(bebida3);
        
        UtilidadesLogin.comidas.add(comida1);
        UtilidadesLogin.comidas.add(comida2);
        UtilidadesLogin.comidas.add(comida3);
        
        UtilidadesLogin.usuarios.add(usuario);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1003, 673);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel panelCabecera = new JPanel();
        panelCabecera.setBackground(new Color(240, 230, 140));
        contentPane.add(panelCabecera, BorderLayout.NORTH);
        panelCabecera.setLayout(new BorderLayout(0, 0));
        
        JPanel panelLogin = new JPanel();
        panelCabecera.add(panelLogin, BorderLayout.EAST);
        panelLogin.setLayout(new BorderLayout(0, 0));
        
        JPanel panelCabeceraLogin = new JPanel();
        panelCabeceraLogin.setBackground(new Color(244, 164, 96));
        panelLogin.add(panelCabeceraLogin, BorderLayout.NORTH);
        panelCabeceraLogin.setLayout(new BorderLayout(0, 0));
        
        JLabel lblEspacioIzq = new JLabel("     ");
        panelCabeceraLogin.add(lblEspacioIzq, BorderLayout.WEST);
        
        JLabel lblTituloLogin = new JLabel("Inicio de sesión");
        lblTituloLogin.setForeground(new Color(255, 255, 255));
        lblTituloLogin.setFont(new Font("Source Code Pro Medium", Font.BOLD, 12));
        lblTituloLogin.setHorizontalAlignment(SwingConstants.TRAILING);
        panelCabeceraLogin.add(lblTituloLogin, BorderLayout.CENTER);
        
        JLabel lblEspacioDer = new JLabel("     ");
        panelCabeceraLogin.add(lblEspacioDer, BorderLayout.EAST);
        
        JPanel panelRegistro = new JPanel();
        panelRegistro.setForeground(new Color(238, 232, 170));
        panelLogin.add(panelRegistro, BorderLayout.CENTER);
        
        JLabel lblUsuario = new JLabel("Usuario");
        
        JLabel lblContraseña = new JLabel("Contraseña");
        
        textNombreUsuario = new JTextField();
        textNombreUsuario.setColumns(10);
        
        textContrasenia = new JTextField();
        textContrasenia.setColumns(10);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            //Inicia sesion en el usuario
            public void actionPerformed(ActionEvent e) {
                for (Usuario usuario : UtilidadesLogin.usuarios) {
                    if (usuario.getNombreUsuario().equals(textNombreUsuario.getText())) {
                        if(usuario.getContraseña().equals(textContrasenia.getText())){
                            loginPressed(e);
                        } else {
                            JOptionPane.showMessageDialog(null,"Contraseña incorrecta");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,"Usuario no encontrado");
                    }
                }
            }
        });
        btnLogin.setBackground(new Color(244, 164, 96));
        btnLogin.setForeground(new Color(0, 0, 0));
        GroupLayout gl_panelRegistro = new GroupLayout(panelRegistro);
        gl_panelRegistro.setHorizontalGroup(
            gl_panelRegistro.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panelRegistro.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_panelRegistro.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panelRegistro.createSequentialGroup()
                            .addGroup(gl_panelRegistro.createParallelGroup(Alignment.LEADING, false)
                                .addGroup(gl_panelRegistro.createSequentialGroup()
                                    .addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18)
                                    .addComponent(textNombreUsuario, 0, 0, Short.MAX_VALUE))
                                .addGroup(gl_panelRegistro.createSequentialGroup()
                                    .addComponent(lblContraseña, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(ComponentPlacement.UNRELATED)
                                    .addComponent(textContrasenia, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap())
                        .addComponent(btnLogin, Alignment.TRAILING)))
        );
        gl_panelRegistro.setVerticalGroup(
            gl_panelRegistro.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panelRegistro.createSequentialGroup()
                    .addGap(20)
                    .addGroup(gl_panelRegistro.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblUsuario)
                        .addComponent(textNombreUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_panelRegistro.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblContraseña)
                        .addComponent(textContrasenia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                    .addComponent(btnLogin))
        );
        panelRegistro.setLayout(gl_panelRegistro);
        
        JPanel panelLogo = new JPanel();
        panelLogo.setBackground(new Color(240, 230, 140));
        panelCabecera.add(panelLogo, BorderLayout.WEST);
        panelLogo.setLayout(new BorderLayout(0, 0));
        
        JLabel lblLogo = new JLabel("                                                                  ");
        lblLogo.setIcon(new ImageIcon("resources/logoRest.png"));
        panelLogo.add(lblLogo, BorderLayout.CENTER);
        
        JLabel lblEspacioIzqLogo = new JLabel("               ");
        panelLogo.add(lblEspacioIzqLogo, BorderLayout.WEST);
        
        JLabel lblNewLabel_1 = new JLabel("Burger Swing");
        lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
        panelCabecera.add(lblNewLabel_1, BorderLayout.CENTER);
        
        JPanel panelPiePagina = new JPanel();
        panelPiePagina.setBackground(new Color(240, 230, 140));
        contentPane.add(panelPiePagina, BorderLayout.SOUTH);
        panelPiePagina.setLayout(new BorderLayout(0, 0));
        
        JLabel lblNewLabel = new JLabel("Camino de los Castillejos 8, 29010, Málaga");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel.setIcon(new ImageIcon("resources/location.png"));
        panelPiePagina.add(lblNewLabel, BorderLayout.CENTER);
        
        JLabel lblEspacioIzqPie = new JLabel("                                                                                             ");
        panelPiePagina.add(lblEspacioIzqPie, BorderLayout.WEST);
        
        JPanel panelCentral = new JPanel();
        panelCentral.setBackground(new Color(250, 250, 210));
        contentPane.add(panelCentral, BorderLayout.CENTER);
        
        JLabel lblCarta = new JLabel("");
        lblCarta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cartaPressed(e);
                
            }
        });
        lblCarta.setIcon(new ImageIcon("resources/sloganPortada.jpg"));
        GroupLayout gl_panelCentral = new GroupLayout(panelCentral);
        gl_panelCentral.setHorizontalGroup(
            gl_panelCentral.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_panelCentral.createSequentialGroup()
                    .addContainerGap(322, Short.MAX_VALUE)
                    .addComponent(lblCarta)
                    .addGap(307))
        );
        gl_panelCentral.setVerticalGroup(
            gl_panelCentral.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panelCentral.createSequentialGroup()
                    .addComponent(lblCarta, GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCentral.setLayout(gl_panelCentral);
    }
    
    protected void loginPressed(ActionEvent e) {
        GestionMesas pantalla = new GestionMesas();
        pantalla.setLocationRelativeTo(null);
        pantalla.setResizable(false);
        pantalla.setVisible(true);
        setVisible(false);
    }
    
    protected void cartaPressed(MouseEvent e) {
        Carta registro = new Carta(this, true);
        registro.setVisible(true);
        
    }
}
