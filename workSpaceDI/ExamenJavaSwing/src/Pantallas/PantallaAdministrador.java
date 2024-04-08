package Pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Pantalla que muestra las opciones que tiene los administradores
 * @author Alvaro
 *
 */
public class PantallaAdministrador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PantallaAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBounds(5, 5, 536, 138);
		panelSuperior.setBackground(new Color(152, 241, 254));
		contentPane.add(panelSuperior);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon("C:\\Users\\Alvaro\\Workspace\\ExamenJavaSwing\\resources\\logoApp.png"));
		panelSuperior.add(lblIcono);
		
		JLabel lblNewLabel_1 = new JLabel("Gym Picasso");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(78, 121, 237));
		panelSuperior.add(lblNewLabel_1);
		
		JPanel panelMedio = new JPanel();
		panelMedio.setBounds(5, 143, 536, 248);
		contentPane.add(panelMedio);
		
		JLabel lblCreaClase = new JLabel("Añade Clase");
		lblCreaClase.setBounds(126, 96, 66, 13);
		
		JLabel lblReservas = new JLabel("Ver Reservas");
		lblReservas.setBounds(318, 96, 61, 13);
		
		JLabel lblListarCliente = new JLabel("Listar clientes");
		lblListarCliente.setBounds(126, 188, 62, 13);
		
		JLabel lblCerrar = new JLabel("CerrarSesion");
		lblCerrar.setBounds(318, 193, 60, 13);
		
		JLabel lblImagenClientes = new JLabel("");
		lblImagenClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				apareceListarClientes();
			}
		});
		lblImagenClientes.setBounds(126, 119, 66, 64);
		lblImagenClientes.setIcon(new ImageIcon("C:\\Users\\Alvaro\\Workspace\\ExamenJavaSwing\\resources\\listarUsuarios.png"));
		
		JLabel lblAniadeClase = new JLabel("");
		lblAniadeClase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				apareceCreaClase();
			}
		});
		lblAniadeClase.setBounds(128, 28, 64, 64);
		lblAniadeClase.setIcon(new ImageIcon("resources\\addClase.png"));
		
		JLabel lblVerReservas = new JLabel("");
		lblVerReservas.setBounds(318, 28, 64, 64);
		lblVerReservas.setIcon(new ImageIcon("C:\\Users\\Alvaro\\Workspace\\ExamenJavaSwing\\resources\\listarReservas.png"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				desaparece();
			}
		});
		lblNewLabel.setBounds(318, 119, 64, 64);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Alvaro\\Workspace\\ExamenJavaSwing\\resources\\cierreSesion.png"));
		panelMedio.setLayout(null);
		panelMedio.add(lblImagenClientes);
		panelMedio.add(lblAniadeClase);
		panelMedio.add(lblVerReservas);
		panelMedio.add(lblNewLabel);
		panelMedio.add(lblCreaClase);
		panelMedio.add(lblListarCliente);
		panelMedio.add(lblCerrar);
		panelMedio.add(lblReservas);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 392, 536, 29);
		panel_2.setBackground(new Color(152, 241, 254));
		contentPane.add(panel_2);
		
		JLabel lblRealizado = new JLabel("Alvaro Ruiz Blanquez 14/11/2023");
		lblRealizado.setForeground(new Color(78, 121, 237));
		lblRealizado.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(lblRealizado);
	}
		
	/**
	 * Hace aparecer la pantalla de Añade Clase
	 */
		protected void apareceCreaClase() {
			PantallaCreaClase pantalla = new PantallaCreaClase();
			pantalla.setVisible(true);
		}
		
	/**
	 * Hace visible la pantalla de Listar clientes
	 */
		protected void apareceListarClientes() {
			PantallaListarClientes pantalla = new PantallaListarClientes();
			pantalla.setVisible(true);
		}
		
	/**
	 *  Hace cerrar la pantalla
	 */
		protected void desaparece() {
			this.dispose();
		}
}
