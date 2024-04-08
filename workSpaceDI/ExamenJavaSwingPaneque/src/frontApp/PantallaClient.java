package frontApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import frontLogin.Login;
import utilidades.UtilidadesApp;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaClient extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaClient frame = new PantallaClient();
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
	public PantallaClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 551);
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
		
		JLabel lblNewLabel_1 = new JLabel("Reservar clase");
		lblNewLabel_1.setBounds(184, 190, 87, 13);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Cerrar sesion");
		lblNewLabel_3.setBounds(437, 190, 87, 13);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				reservaClasePressed(e);
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon("resources/apuntaAClase.png"));
		lblNewLabel_2.setBounds(184, 116, 67, 64);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginPressed(e);
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon("resources/cierreSesion.png"));
		lblNewLabel_4.setBounds(437, 125, 62, 55);
		panel_1.add(lblNewLabel_4);
		
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
	
	protected void reservaClasePressed(MouseEvent e) {
		ReservaClase pantalla = new ReservaClase(this, true);
		pantalla.setVisible(true);
	}
}
