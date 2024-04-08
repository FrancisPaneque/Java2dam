package Pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Utils.*;

/**
 * Pantalla para resgistrar tanto a clientes, como a administradores
 * @author Alvaro
 *
 */
public class PantallaRegistraUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtFechaNacimiento;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtContrasenia1;
	private JTextField txtContrasenia2;

	/**
	 * Create the frame.
	 */
	public PantallaRegistraUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 393, 30);
		panel.setBackground(new Color(139, 168, 243));
		contentPane.add(panel);
		
		JLabel lblTitulo = new JLabel("Registro de Usuario");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setForeground(Color.WHITE);
		panel.add(lblTitulo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 35, 393, 433);
		contentPane.add(panel_1);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblFechaNacimiento = new JLabel("FechaNacimiento:");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblPerfil = new JLabel("Perfil:");
		lblPerfil.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblcontrasenia1 = new JLabel("Contraseña:");
		lblcontrasenia1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblContrasenia2 = new JLabel("Repite la contraseña:");
		lblContrasenia2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		
		JComboBox cbPerfil = new JComboBox();
		cbPerfil.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Cliente"}));
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		txtContrasenia1 = new JTextField();
		txtContrasenia1.setColumns(10);
		
		txtContrasenia2 = new JTextField();
		txtContrasenia2.setColumns(10);
		
		JLabel lblSalida = new JLabel("    ");
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String contrasenia1 = txtContrasenia1.getText();
				String contrasenia2 = txtContrasenia2.getText();
				if (compruebaPalabras(contrasenia1, contrasenia2)) {
					String nombre = txtNombre.getText();
					String apellido = txtApellido.getText();
					String email = txtEmail.getText();
					String fechaNacimiento = txtFechaNacimiento.getText();
					String perfil = (String) cbPerfil.getSelectedItem();
					if (compruebaPalabras(perfil, "Administrador")) {
						createAdministrador(nombre, apellido, fechaNacimiento, email, contrasenia1);
					} else {
						createCliente(nombre, apellido, fechaNacimiento, email, contrasenia1);
					}
					ocultaPantalla();
				} else {
					JOptionPane.showMessageDialog(null,"Contraseña no correcta");
					txtContrasenia1.setText("");
					txtContrasenia2.setText("");
				}
				
			}
		});
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFechaNacimiento)
								.addComponent(lblPerfil, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblcontrasenia1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblContrasenia2)
								.addComponent(lblSalida, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblApellidos, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
							.addGap(31)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtContrasenia2)
								.addComponent(txtContrasenia1)
								.addComponent(txtEmail)
								.addComponent(cbPerfil, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtFechaNacimiento, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
								.addComponent(txtApellido)
								.addComponent(txtNombre)
								.addComponent(btnEnviar, Alignment.TRAILING)))
						.addComponent(lblNombre))
					.addContainerGap(505, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(52)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblApellidos))
					.addGap(29)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaNacimiento)
						.addComponent(txtFechaNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPerfil)
						.addComponent(cbPerfil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblcontrasenia1)
						.addComponent(txtContrasenia1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblContrasenia2)
						.addComponent(txtContrasenia2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEnviar)
						.addComponent(lblSalida))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
	}
	
	/**
	 * Hace que se cierre esta pantalla
	 */
	protected void ocultaPantalla() {
		this.dispose();
	}
	
	/**
	 * Crea con los datos dados el cliente y lo guarda en la lista de clientes
	 * @param nombre
	 * @param apellidos
	 * @param fechaNacimiento
	 * @param Email
	 * @param contrasenia
	 */
	protected void createCliente(String nombre, String apellidos, String fechaNacimiento, String Email,String contrasenia) {
		Cliente cliente = new Cliente(nombre, apellidos, fechaNacimiento, Email, contrasenia);
		Cliente.addCliente(cliente);
		
	}
	
	/**
	 * Crea con los datos dados el administrador y lo guarda en la lista de administradores
	 * @param nombre
	 * @param apellidos
	 * @param fechaNacimiento
	 * @param Email
	 * @param contrasenia
	 */
	protected void createAdministrador(String nombre, String apellidos, String fechaNacimiento, String Email,String contrasenia) {
		Administrador admin = new Administrador(nombre, apellidos, fechaNacimiento, Email, contrasenia);
		Administrador.addAdministrador(admin);
	}
	
	// Comprueba si la cadena 1 y la cadena 2 son iguales
	private boolean compruebaPalabras(String cadena1, String cadena2) {
		
		if (cadena1.compareTo(cadena2)  == 0) {
			return true;
		} else {
			return false;
		}
	}
}
