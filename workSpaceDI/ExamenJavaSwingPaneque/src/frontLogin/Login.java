package frontLogin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import frontApp.*;
import utilidades.UtilidadesLogin;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	public static String usuarioActual;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setLocationRelativeTo(null);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCabecera = new JPanel();
		panelCabecera.setBackground(new Color(128, 255, 255));
		contentPane.add(panelCabecera, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("  GYM Picasso");
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(0, 64, 128));
		lblNewLabel.setIcon(new ImageIcon("resources/logoApp.png"));
		panelCabecera.add(lblNewLabel);
		
		JPanel panelLogin = new JPanel();
		contentPane.add(panelLogin, BorderLayout.EAST);
		panelLogin.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLoginTitulo = new JPanel();
		panelLoginTitulo.setBackground(new Color(128, 128, 255));
		panelLogin.add(panelLoginTitulo, BorderLayout.NORTH);
		panelLoginTitulo.setLayout(new BorderLayout(0, 0));
		
		JLabel tituloLogin = new JLabel("Bienvenido/a a la aplicación Gym Picasso");
		tituloLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tituloLogin.setForeground(new Color(255, 255, 255));
		panelLoginTitulo.add(tituloLogin);
		
		JLabel espacioArriba = new JLabel("\r\n\r\n\r\n\r\n\r\n\r\n");
		panelLoginTitulo.add(espacioArriba, BorderLayout.NORTH);
		
		JLabel espacioAbajo = new JLabel("\r\n\r\n\r\n\r\n\r\n\r\n");
		panelLoginTitulo.add(espacioAbajo, BorderLayout.SOUTH);
		
		JLabel espacioIzquierda = new JLabel("\r\n\r\n\r\n\r\n                  ");
		panelLoginTitulo.add(espacioIzquierda, BorderLayout.WEST);
		
		JLabel espacioDerecha = new JLabel("\r\n\r\n\r\n\r\n                  ");
		panelLoginTitulo.add(espacioDerecha, BorderLayout.EAST);
		
		JPanel panelLoginCentral = new JPanel();
		panelLoginCentral.setBackground(new Color(128, 255, 255));
		panelLogin.add(panelLoginCentral, BorderLayout.CENTER);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		
		textContraseña = new JTextField();
		textContraseña.setColumns(10);
		
		JButton btnNewButton = new JButton("Inicia Sesión");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Si es de administracion
					if (UtilidadesLogin.usuarios.get(textUsuario.getText()).getPerfil().equals("Administración")) {
						// Si la contraseña es correcta
						if (textContraseña.getText().equals(UtilidadesLogin.usuarios.get(textUsuario.getText()).getContrasenia())) {
							usuarioActual = textUsuario.getText(); 
							adminPressed(e);
						} else {
							JOptionPane.showMessageDialog(null,"Contraseña incorrecta");
						}
					// Si es cliente	
					} else if (UtilidadesLogin.usuarios.get(textUsuario.getText()).getPerfil().equals("Cliente")) {
						// Si la contraseña es correcta
						if (textContraseña.getText().equals(UtilidadesLogin.usuarios.get(textUsuario.getText()).getContrasenia())) {
							usuarioActual = textUsuario.getText(); 
							clientePressed(e);
						} else {
							JOptionPane.showMessageDialog(null,"Contraseña incorrecta");
						}
					// Si no es de ningun tipo	
					}
				// Si no se encuentra el usuario en la lista de usuarios	
				} catch (Exception j) {
					JOptionPane.showMessageDialog(null,"Usuario no encontrado");
				}	
			}
		}

		);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		
		JButton btnPulsaAquPara = new JButton("Pulsa aquí para registrarte");
		btnPulsaAquPara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registroPressed(e);
			}
		});
		btnPulsaAquPara.setForeground(Color.WHITE);
		btnPulsaAquPara.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPulsaAquPara.setBackground(new Color(0, 128, 255));
		GroupLayout gl_panelLoginCentral = new GroupLayout(panelLoginCentral);
		gl_panelLoginCentral.setHorizontalGroup(
			gl_panelLoginCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLoginCentral.createSequentialGroup()
					.addGap(124)
					.addGroup(gl_panelLoginCentral.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton)
						.addGroup(gl_panelLoginCentral.createSequentialGroup()
							.addGroup(gl_panelLoginCentral.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblContraseña, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelLoginCentral.createParallelGroup(Alignment.LEADING)
								.addComponent(textContraseña, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
								.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnPulsaAquPara))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		gl_panelLoginCentral.setVerticalGroup(
			gl_panelLoginCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLoginCentral.createSequentialGroup()
					.addGap(94)
					.addGroup(gl_panelLoginCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsuario))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelLoginCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(textContraseña, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContraseña))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addGap(51)
					.addComponent(btnPulsaAquPara, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		panelLoginCentral.setLayout(gl_panelLoginCentral);
		
		JPanel panelFondo = new JPanel();
		contentPane.add(panelFondo, BorderLayout.WEST);
		panelFondo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setIcon(new ImageIcon("resources/imgLogin.png"));
		panelFondo.add(imagenFondo);
	}
	
	protected void registroPressed(ActionEvent e) {
		RegistroUsuario registro = new RegistroUsuario(this, true);
		registro.setVisible(true);
		
	}
	
	
	protected void adminPressed(ActionEvent e) {
		PantallaAdmin pantalla = new PantallaAdmin();
		pantalla.setLocationRelativeTo(null);
		pantalla.setResizable(false);
		pantalla.setVisible(true);
		setVisible(false);
	}
	
	protected void clientePressed(ActionEvent e) {
		PantallaClient pantalla = new PantallaClient();
		pantalla.setLocationRelativeTo(null);
		pantalla.setResizable(false);
		pantalla.setVisible(true);
		setVisible(false);
	}
}
