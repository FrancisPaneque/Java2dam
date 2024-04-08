package Pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Utils.Administrador;
import Utils.Cliente;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Pantalla Principal de login
 * @author Alvaro
 *
 */
public class PantallaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtPassword;

	/**
	 * Create the frame.
	 */
	public PantallaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(183, 255, 255));
		contentPane.add(panelSuperior, BorderLayout.NORTH);
		
		JLabel lblIcono = new JLabel("  ");
		lblIcono.setIcon(new ImageIcon("C:\\Users\\Alvaro\\Workspace\\ExamenJavaSwing\\resources\\logoApp.png"));
		panelSuperior.add(lblIcono);
		
		JLabel lblTitulo = new JLabel("GYM Picasso");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTitulo.setForeground(new Color(58, 107, 235));
		panelSuperior.add(lblTitulo);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panelIzquierdo = new JPanel();
		panelIzquierdo.setBackground(Color.WHITE);
		
		JPanel panelDerecho = new JPanel();
		
		JPanel panelSuperiorDerecho = new JPanel();
		panelSuperiorDerecho.setBackground(new Color(0, 128, 192));
		
		JLabel lblBienvenidos = new JLabel("Bienvenido/a la aplicación  GYM Picasso");
		lblBienvenidos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBienvenidos.setForeground(Color.WHITE);
		panelSuperiorDerecho.add(lblBienvenidos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(183, 255, 255));
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(78, 121, 237));
		lblUsuario.setBackground(new Color(139, 168, 243));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setForeground(new Color(78, 121, 237));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		
		JButton btnInicioSesion = new JButton("Inicia Sesion");
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = txtUsuario.getText();
				String password = txtPassword.getText();
				if (Cliente.existeCliente(usuario)) {
					int usuarioCliente = Cliente.buscaCliente(usuario);
					String contraseniaCliente = Cliente.listaCliente.get(usuarioCliente).getContrasenia();
					if (password.compareTo(contraseniaCliente) >= 0) {
						apareceCliente();
					} else {
						JOptionPane.showMessageDialog(null,"Usuario no encontrado");
					}
				}
				
				if (Administrador.existeAdmin(usuario)) {
					int usuarioAdmin = Administrador.buscaAdmin(usuario);
					String contraseniaAdmin = Administrador.listaAdmins.get(usuarioAdmin).getContrasenia();
					if (password.compareTo(contraseniaAdmin) >= 0) {
						apareceAdmin();
					} else {
						JOptionPane.showMessageDialog(null,"Usuario no encontrado");
					}
				}
				txtUsuario.setText("");
				txtPassword.setText("");
			}
		});
		btnInicioSesion.setBackground(new Color(78, 121, 237));
		btnInicioSesion.setForeground(Color.WHITE);
		
		JButton btnNewButton = new JButton("Pulse aqui para registrarse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				apareceRegister();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBackground(new Color(78, 121, 237));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(77)
							.addComponent(lblUsuario))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(66)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(btnInicioSesion, Alignment.TRAILING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblPassword)
									.addGap(49)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtPassword, 149, 149, 149)))
								.addComponent(btnNewButton, Alignment.TRAILING))))
					.addGap(36))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(74)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addComponent(btnInicioSesion)
					.addPreferredGap(ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(48))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblImagen = new JLabel("   ");
		lblImagen.setIcon(new ImageIcon("C:\\Users\\Alvaro\\Workspace\\ExamenJavaSwing\\resources\\imgLogin.png"));
		panelIzquierdo.add(lblImagen);
		GroupLayout gl_panelDerecho = new GroupLayout(panelDerecho);
		gl_panelDerecho.setHorizontalGroup(
			gl_panelDerecho.createParallelGroup(Alignment.LEADING)
				.addComponent(panelSuperiorDerecho, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
				.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);
		gl_panelDerecho.setVerticalGroup(
			gl_panelDerecho.createParallelGroup(Alignment.LEADING)
				.addComponent(panelSuperiorDerecho, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panelDerecho.createSequentialGroup()
					.addGap(37)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE))
		);
		panelDerecho.setLayout(gl_panelDerecho);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(355)
					.addComponent(panelDerecho, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addComponent(panelIzquierdo, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panelDerecho, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)
				.addComponent(panelIzquierdo, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 255, 255));
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("Alvaro Ruiz Blanquez 14/11/2023");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(78, 121, 237));
		panel_2.add(lblNewLabel);
	}

	/**
	 * Hace que se abra la pantalla de Cliente
	 */
	protected void apareceCliente() {
		PantallaCliente pantalla = new PantallaCliente();
		pantalla.setVisible(true);
	}
	
	/**
	 * Hace que se abra la pantalla de Administrador
	 */
	protected void apareceAdmin() {
		PantallaAdministrador pantalla = new PantallaAdministrador();
		pantalla.setVisible(true);
	}
	
	/**
	 * Hace que se abra la pantalla del register
	 */
	protected void apareceRegister() {
		PantallaRegistraUsuario pantalla = new PantallaRegistraUsuario();
		pantalla.setVisible(true);
	}
}
