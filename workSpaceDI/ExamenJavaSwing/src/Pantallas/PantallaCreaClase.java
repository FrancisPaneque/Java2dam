package Pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Utils.Clases;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Pantalla que permite crear las clases a los administradores
 * @author Alvaro
 *
 */
public class PantallaCreaClase extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtProfesor;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String turno; 

	/**
	 * Create the frame.
	 */
	public PantallaCreaClase() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(78, 121, 237));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("Nueva Clase");
		lblTitulo.setBackground(new Color(78, 121, 237));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblTitulo);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(54, 30, 50, 13);
		panel_1.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(203, 29, 165, 19);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Profesor/a");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(54, 84, 65, 13);
		panel_1.add(lblNewLabel);
		
		txtProfesor = new JTextField();
		txtProfesor.setBounds(203, 83, 165, 19);
		panel_1.add(txtProfesor);
		txtProfesor.setColumns(10);
		
		JLabel lblTurno = new JLabel("Turno");
		lblTurno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTurno.setBounds(59, 145, 45, 13);
		panel_1.add(lblTurno);
		
		JRadioButton rdbtnTarde = new JRadioButton("Tarde");
		rdbtnTarde.setSelected(true);
		buttonGroup.add(rdbtnTarde);
		rdbtnTarde.setBounds(187, 143, 103, 21);
		panel_1.add(rdbtnTarde);
		
		JRadioButton rdbtnManiana = new JRadioButton("Mañana");
		buttonGroup.add(rdbtnManiana);
		rdbtnManiana.setBounds(300, 143, 103, 21);
		panel_1.add(rdbtnManiana);
		if (rdbtnManiana.isSelected()) {
			turno = "Mañana";
		} else {
			turno = "tarde";
		}
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adddeClase();
				ocultaPantalla();
			}
		});
		btnEnviar.setBounds(147, 190, 85, 21);
		panel_1.add(btnEnviar);
	}
	
	/**
	 * Añade la clase a lista de las clases
	 */
	private void adddeClase() {
		String nombre = txtNombre.getText();
		String profesor = txtProfesor.getText();
		Clases  clase = new Clases(nombre, profesor, turno);
		Clases.addClase(clase);
	}
	
	/**
	 * Hace que se cierre la pantalla
	 */
	protected void ocultaPantalla() {
		this.dispose();
	}
}
