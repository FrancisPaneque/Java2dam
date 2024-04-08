package front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Usuario;
import util.Utils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField passwordField;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 576);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 224, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon("resources/cocheAzul.png"));
		
		JLabel lblTitulo = new JLabel("Talleres Picasso");
		lblTitulo.setForeground(new Color(0, 0, 128));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton btnIniciarSesion = new JButton("Inicia Sesión");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Usuario usuario : Utils.usuarios) {
                    if (usuario.getNombreUsuario().equals(textUsuario.getText())) {
                        if(usuario.getContrasenia().equals(String.valueOf(passwordField.getPassword()))){
                        	Utils.usuarioActual=textUsuario.getText();
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
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JLabel lblRegistro = new JLabel("¿No tienes cuenta?");
		lblRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crearUsuarioPressed(e);
			}
		});
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRegistro.setForeground(new Color(0, 0, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(195, Short.MAX_VALUE)
					.addComponent(lblIcono, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(187))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(93)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRegistro)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblContrasenia)))
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
								.addComponent(textUsuario, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(155)
							.addComponent(lblTitulo)))
					.addContainerGap(100, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(310, Short.MAX_VALUE)
					.addComponent(btnIniciarSesion)
					.addGap(120))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addComponent(lblIcono)
					.addGap(18)
					.addComponent(lblTitulo)
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(60)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContrasenia)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIniciarSesion)
						.addComponent(lblRegistro))
					.addGap(35))
		);
		contentPane.setLayout(gl_contentPane);
	}
	/**
	 * al pulsarse despliega la venta de registro
	 * @param e
	 */
	protected void crearUsuarioPressed (MouseEvent e) {
        Registro registro = new Registro(this, true);
        registro.setVisible(true);
        registro.setResizable(false);
        
    }
	/**
	 * metodo que navega a la venta de PerfilCliente
	 * 
	 * @param e
	 */
	protected void loginPressed(ActionEvent e) {
        PerfilCliente pantalla = new PerfilCliente();
        pantalla.setLocationRelativeTo(null);
        pantalla.setResizable(false);
        pantalla.setVisible(true);
        setVisible(false);
    }
}