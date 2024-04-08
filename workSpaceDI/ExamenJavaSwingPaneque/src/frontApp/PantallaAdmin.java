package frontApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import frontLogin.*;
import utilidades.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaAdmin frame = new PantallaAdmin();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
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
	public PantallaAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCabecera = new JPanel();
		panelCabecera.setForeground(new Color(128, 255, 255));
		panelCabecera.setBackground(new Color(128, 255, 255));
		contentPane.add(panelCabecera, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("  GYM Picasso");
		lblNewLabel.setIcon(new ImageIcon("resources/logoApp.png"));
		lblNewLabel.setForeground(new Color(0, 64, 128));
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 30));
		panelCabecera.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Ver Reservas");
		lblNewLabel_1.setBounds(405, 103, 73, 13);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Cerrar Sesion");
		lblNewLabel_3.setBounds(405, 253, 73, 13);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			// Vuelbe al login
			@Override
			public void mouseClicked(MouseEvent e) {
				loginPressed(e);
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon("resources/cierreSesion.png"));
		lblNewLabel_2.setBounds(405, 190, 73, 53);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("resources/listarReservas.png"));
		lblNewLabel_2_1.setBounds(405, 40, 73, 53);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listaClientesPressed(e);
			}
		});
		lblNewLabel_2_2.setIcon(new ImageIcon("resources/listarUsuarios.png"));
		lblNewLabel_2_2.setBounds(162, 190, 73, 53);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("");
		lblNewLabel_2_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				añadeClasePressed(e);
			}
		});
		lblNewLabel_2_3.setIcon(new ImageIcon("resources/addClase.png"));
		lblNewLabel_2_3.setBounds(162, 40, 73, 53);
		panel_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Añadir clase");
		lblNewLabel_3_1.setBounds(162, 103, 73, 13);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Ver Usuarios");
		lblNewLabel_3_2.setBounds(162, 253, 73, 13);
		panel_1.add(lblNewLabel_3_2);
		
		JPanel panePiePagina = new JPanel();
		panePiePagina.setBackground(new Color(128, 255, 255));
		contentPane.add(panePiePagina, BorderLayout.SOUTH);
		
		JLabel lblPie = new JLabel(frontLogin.Login.usuarioActual + " Fecha: " + UtilidadesApp.imprimirFechaActual());
		lblPie.setForeground(new Color(0, 0, 160));
		lblPie.setFont(new Font("Tahoma", Font.BOLD, 12));
		panePiePagina.add(lblPie);
	}
	
	protected void loginPressed(MouseEvent e) {
		Login pantalla = new Login();
		pantalla.setLocationRelativeTo(null);
		pantalla.setResizable(false);
		pantalla.setVisible(true);
		setVisible(false);
	}
	
	protected void añadeClasePressed(MouseEvent e) {
		FormularioNuevaClase pantalla = new FormularioNuevaClase(this, true);
		pantalla.setVisible(true);
	}
	
	protected void listaClientesPressed(MouseEvent e) {
		ListaClientes pantalla = new ListaClientes(this, true);
		pantalla.setVisible(true);
	}
}
