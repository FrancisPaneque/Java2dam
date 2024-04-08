package frontLogin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Usuario;
import utilidades.UtilidadesLogin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class RegistroUsuario extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldEmail;
	private JTextField textFieldContraseña;
	private JTextField textFieldConfirmaContraseña;
	private JComboBox comboBoxPerfil;
	JDateChooser textFieldFechaNacimiento;

	/**
	 * Create the dialog.
	 */
	public RegistroUsuario(Login padre, boolean modal) {
		setBounds(100, 100, 416, 549);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelCabeceraRegistro = new JPanel();
			panelCabeceraRegistro.setBackground(new Color(0, 128, 255));
			contentPanel.add(panelCabeceraRegistro, BorderLayout.NORTH);
			panelCabeceraRegistro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel lblTituloRegistroUsuario = new JLabel("Registro de usuario");
				lblTituloRegistroUsuario.setForeground(new Color(255, 255, 255));
				lblTituloRegistroUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
				panelCabeceraRegistro.add(lblTituloRegistroUsuario);
			}
		}
		{
			JPanel panelFormularioRegistro = new JPanel();
			contentPanel.add(panelFormularioRegistro, BorderLayout.SOUTH);
			JLabel lblNewLabel = new JLabel("Nombre");
			JLabel lblApellidos = new JLabel("Apellidos");
			JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
			JLabel lblPerfil = new JLabel("Perfil");
			JLabel lblEmail = new JLabel("Email");
			JLabel lblContrasea = new JLabel("Contraseña");
			JLabel lblRepitaContrasea = new JLabel("Repita contraseña");
			textFieldNombre = new JTextField();
			textFieldNombre.setColumns(10);
			textFieldApellidos = new JTextField();
			textFieldApellidos.setColumns(10);
			textFieldEmail = new JTextField();
			textFieldEmail.setColumns(10);
			textFieldContraseña = new JTextField();
			textFieldContraseña.setColumns(10);
			textFieldConfirmaContraseña = new JTextField();
			textFieldConfirmaContraseña.setColumns(10);
			textFieldFechaNacimiento = new JDateChooser();
			comboBoxPerfil = new JComboBox();
			comboBoxPerfil.setModel(new DefaultComboBoxModel(new String[] {"Cliente", "Administración"}));
			
			JButton btnEnviar = new JButton("Enviar");
			btnEnviar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Si el campo contraseña y confirmaContraseña son iguales
					if (textFieldContraseña.getText().equals(textFieldConfirmaContraseña.getText())) {
		                // Crea el nuenvo usuario y lo añade a la lista de usuarios
						Usuario usuario = UtilidadesLogin.creaUsuario(textFieldNombre.getText(), textFieldApellidos.getText(), textFieldFechaNacimiento.getToolTipText(), textFieldEmail.getText(), textFieldContraseña.getText(), comboBoxPerfil.getSelectedItem().toString());
						UtilidadesLogin.añadeUsuario(usuario);
						if (UtilidadesLogin.usuarios.containsKey(usuario.getEmail())) {
							JOptionPane.showMessageDialog(null,"Usuario correctamente añadido");
						} else {
							JOptionPane.showMessageDialog(null,"Error al crear el usuario");
						}
						
					} else {
						JOptionPane.showMessageDialog(null,"La contraseña y la confirmación no coinciden");
					}
				}
			});
			
			
			GroupLayout gl_panelFormularioRegistro = new GroupLayout(panelFormularioRegistro);
			gl_panelFormularioRegistro.setHorizontalGroup(
				gl_panelFormularioRegistro.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelFormularioRegistro.createSequentialGroup()
						.addGroup(gl_panelFormularioRegistro.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panelFormularioRegistro.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnEnviar))
							.addGroup(gl_panelFormularioRegistro.createSequentialGroup()
								.addGap(48)
								.addGroup(gl_panelFormularioRegistro.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panelFormularioRegistro.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblPerfil, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblFechaDeNacimiento, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblContrasea)
										.addComponent(lblRepitaContrasea, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addComponent(lblApellidos, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
								.addGroup(gl_panelFormularioRegistro.createParallelGroup(Alignment.LEADING)
									.addComponent(textFieldFechaNacimiento, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(Alignment.TRAILING, gl_panelFormularioRegistro.createParallelGroup(Alignment.LEADING, false)
										.addComponent(comboBoxPerfil, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textFieldNombre, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
										.addComponent(textFieldEmail, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
										.addComponent(textFieldContraseña, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
										.addComponent(textFieldConfirmaContraseña, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
										.addComponent(textFieldApellidos, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))))
						.addGap(40))
			);
			gl_panelFormularioRegistro.setVerticalGroup(
				gl_panelFormularioRegistro.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panelFormularioRegistro.createSequentialGroup()
						.addGap(44)
						.addGroup(gl_panelFormularioRegistro.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
						.addGroup(gl_panelFormularioRegistro.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblApellidos)
							.addComponent(textFieldApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(26)
						.addGroup(gl_panelFormularioRegistro.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblFechaDeNacimiento)
							.addComponent(textFieldFechaNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(40)
						.addGroup(gl_panelFormularioRegistro.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPerfil)
							.addComponent(comboBoxPerfil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(46)
						.addGroup(gl_panelFormularioRegistro.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblEmail)
							.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(41)
						.addGroup(gl_panelFormularioRegistro.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblContrasea)
							.addComponent(textFieldContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(51)
						.addGroup(gl_panelFormularioRegistro.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblRepitaContrasea)
							.addComponent(textFieldConfirmaContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addComponent(btnEnviar)
						.addGap(36))
			);
			panelFormularioRegistro.setLayout(gl_panelFormularioRegistro);
		}
	}
}
