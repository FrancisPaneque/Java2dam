package Pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Pantalla que muestra la opciones que tiene todos los clientes
 * @author Alvaro
 *
 */
public class PantallaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PantallaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBounds(5, 5, 434, 138);
		panelSuperior.setBackground(new Color(152, 241, 254));
		contentPane.add(panelSuperior);
		
		JLabel lblIcono = new JLabel(" ");
		lblIcono.setIcon(new ImageIcon("C:\\Users\\Alvaro\\Workspace\\ExamenJavaSwing\\resources\\logoApp.png"));
		panelSuperior.add(lblIcono);
		
		JLabel lblTitulo = new JLabel("GYM Picasso");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setForeground(new Color(78, 121, 237));
		panelSuperior.add(lblTitulo);
		
		JPanel panelMedio = new JPanel();
		panelMedio.setBounds(5, 143, 434, 172);
		panelMedio.setBackground(Color.WHITE);
		contentPane.add(panelMedio);
		
		JLabel lblReserva = new JLabel("Reservar Clase");
		lblReserva.setBounds(100, 121, 69, 13);
		
		
		JLabel lblCerrar = new JLabel("Cerrar Sesion");
		lblCerrar.setBounds(239, 121, 63, 13);
		
		JLabel lblReservar = new JLabel("");
		lblReservar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				apareceReserva();
			}
		});
		lblReservar.setBounds(100, 47, 79, 64);
		lblReservar.setIcon(new ImageIcon("C:\\Users\\Alvaro\\Workspace\\ExamenJavaSwing\\resources\\apuntaAClase.png"));
		
		JLabel lblImagenCerrar = new JLabel("");
		lblImagenCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				desaparece();
			}
		});
		lblImagenCerrar.setBounds(239, 47, 63, 64);
		lblImagenCerrar.setIcon(new ImageIcon("C:\\Users\\Alvaro\\Workspace\\ExamenJavaSwing\\resources\\cierreSesion.png"));
		panelMedio.setLayout(null);
		panelMedio.add(lblReservar);
		panelMedio.add(lblReserva);
		panelMedio.add(lblImagenCerrar);
		panelMedio.add(lblCerrar);
		
		JPanel panelInferior = new JPanel();
		panelInferior.setBounds(5, 315, 434, 23);
		panelInferior.setBackground(new Color(152, 241, 254));
		contentPane.add(panelInferior);
		
		JLabel lblRealizado = new JLabel("Alvaro Ruiz Blanquez 14/11/2023");
		lblRealizado.setForeground(new Color(78, 121, 237));
		lblRealizado.setFont(new Font("Tahoma", Font.BOLD, 10));
		panelInferior.add(lblRealizado);
	}
	
	/**
	 *  Hace que se cierre la pantalla
	 */
	protected void desaparece() {
		this.dispose();
	}
	
	/**
	 *  Hace visible la pantalla de Listar clientes
	 */
	protected void apareceReserva() {
		PantallaReservaClase pantalla = new PantallaReservaClase();
		pantalla.setVisible(true);
	}
}
