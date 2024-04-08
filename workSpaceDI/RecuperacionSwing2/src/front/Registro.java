package front;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.Utils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textTelefono;
	private JTextField textMail;
	private JPasswordField passwordContrasnia;
	private JPasswordField passwordConfirmContrasenia;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnTelefono;
	private JRadioButton rdbtnEmail;

	/**
	 * Create the dialog.
	 */
	public Registro(Login padre, boolean modal) {
		setBounds(100, 100, 680, 586);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel paneTitulo = new JPanel();
			paneTitulo.setBackground(new Color(0, 0, 139));
			contentPanel.add(paneTitulo, BorderLayout.NORTH);
			paneTitulo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel lblTitulo = new JLabel("Registro Cliente");
				lblTitulo.setForeground(new Color(255, 255, 255));
				lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
				paneTitulo.add(lblTitulo);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(72, 209, 204));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(null);
				{
					JLabel lblNombre = new JLabel("Nombre");
					lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblNombre.setBounds(110, 45, 54, 13);
					panel_1.add(lblNombre);
				}
				{
					JLabel lblApellidos = new JLabel("Apellidos");
					lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblApellidos.setBounds(110, 81, 65, 13);
					panel_1.add(lblApellidos);
				}
				{
					textNombre = new JTextField();
					textNombre.setBounds(280, 28, 322, 35);
					panel_1.add(textNombre);
					textNombre.setColumns(10);
				}
				{
					textApellido = new JTextField();
					textApellido.setBounds(280, 73, 322, 33);
					panel_1.add(textApellido);
					textApellido.setColumns(10);
				}
				{
					textTelefono = new JTextField();
					textTelefono.setBounds(280, 119, 322, 35);
					panel_1.add(textTelefono);
					textTelefono.setColumns(10);
				}
				{
					textMail = new JTextField();
					textMail.setBounds(280, 164, 322, 35);
					panel_1.add(textMail);
					textMail.setColumns(10);
				}
				{
					passwordContrasnia = new JPasswordField();
					passwordContrasnia.setBounds(280, 216, 322, 33);
					panel_1.add(passwordContrasnia);
				}
				{
					passwordConfirmContrasenia = new JPasswordField();
					passwordConfirmContrasenia.setBounds(280, 259, 322, 35);
					panel_1.add(passwordConfirmContrasenia);
				}
				{
					JLabel lblTelefono = new JLabel("Teléfono");
					lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblTelefono.setBounds(110, 130, 65, 13);
					panel_1.add(lblTelefono);
				}
				{
					JLabel lblMail = new JLabel("Email");
					lblMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblMail.setBounds(110, 175, 65, 13);
					panel_1.add(lblMail);
				}
				{
					JLabel lblContrasenia = new JLabel("Contraseña");
					lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblContrasenia.setBounds(94, 224, 86, 13);
					panel_1.add(lblContrasenia);
				}
				{
					JLabel lblConfiContrasenia = new JLabel("Confirma Contraseña");
					lblConfiContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblConfiContrasenia.setBounds(74, 268, 143, 13);
					panel_1.add(lblConfiContrasenia);
				}
				{
					JLabel lblContacto = new JLabel("Metodo de Contacto");
					lblContacto.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblContacto.setBounds(74, 347, 143, 13);
					panel_1.add(lblContacto);
				}
				
				rdbtnTelefono = new JRadioButton("Teléfono");
				buttonGroup.add(rdbtnTelefono);
				rdbtnTelefono.setBounds(280, 331, 103, 21);
				panel_1.add(rdbtnTelefono);
				
				rdbtnEmail = new JRadioButton("Email");
				buttonGroup.add(rdbtnEmail);
				rdbtnEmail.setBounds(280, 366, 103, 21);
				panel_1.add(rdbtnEmail);
			}
			{
				JLabel lblNewLabel = new JLabel(" ");
				panel.add(lblNewLabel, BorderLayout.NORTH);
			}
			{
				JLabel lblNewLabel_1 = new JLabel(" ");
				panel.add(lblNewLabel_1, BorderLayout.SOUTH);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("       ");
				panel.add(lblNewLabel_2, BorderLayout.WEST);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("       ");
				panel.add(lblNewLabel_3, BorderLayout.EAST);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(72, 209, 204));
			contentPanel.add(panel, BorderLayout.SOUTH);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (rdbtnTelefono.isSelected()) {
							Utils.nuevoUsuario(textNombre, textApellido, textTelefono, textMail, passwordContrasnia, rdbtnTelefono);
							JOptionPane.showMessageDialog(null,"Usuario correctamente creado");
							salidaPressed(e);
						} else if (rdbtnEmail.isSelected()) {
							Utils.nuevoUsuario(textNombre, textApellido, textTelefono, textMail, passwordContrasnia, rdbtnEmail);
							JOptionPane.showMessageDialog(null,"Usuario correctamente creado");
							salidaPressed(e);
						} else {
							JOptionPane.showMessageDialog(null,"Error al crear el usuario, compruebe los campos");
						}
					}
				});
				panel.add(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						salidaPressed(e);
					}
				});
				panel.add(btnCancelar);
			}
		}
	}
	/**
	 * Metodo que cierra la venta en la que este
	 * @param e
	 */
	protected void salidaPressed(ActionEvent e) {
	    // Cierra el JDialog
	    this.dispose();
	}
}
