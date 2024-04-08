package Pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Utils.Clases;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Pantalla que permite que los administradores puedan crear una clase nueva
 * @author Alvaro
 */
public class PantallaNuevaClase extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtProfesor;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String turno;
	
	/**
	 * Create the frame.
	 */
	public PantallaNuevaClase() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(152, 241, 254));
		panel.setBounds(0, 0, 436, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNuevaClase = new JLabel("Nueva Clase");
		lblNuevaClase.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNuevaClase.setForeground(Color.WHITE);
		lblNuevaClase.setBounds(156, 10, 125, 30);
		panel.add(lblNuevaClase);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(31, 88, 84, 13);
		contentPane.add(lblNombre);
		
		JLabel lblPorfesor = new JLabel("Profesor/a:");
		lblPorfesor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPorfesor.setBounds(31, 130, 84, 13);
		contentPane.add(lblPorfesor);
		
		JLabel lblTurno = new JLabel("Turno");
		lblTurno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTurno.setBounds(31, 175, 84, 13);
		contentPane.add(lblTurno);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(220, 85, 145, 19);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtProfesor = new JTextField();
		txtProfesor.setBounds(220, 127, 145, 19);
		contentPane.add(txtProfesor);
		txtProfesor.setColumns(10);
		
		JRadioButton rdbtnManiana = new JRadioButton("Mañana");
		buttonGroup.add(rdbtnManiana);
		rdbtnManiana.setBounds(220, 167, 103, 21);
		contentPane.add(rdbtnManiana);
		
		JRadioButton rdbtnTarde = new JRadioButton("Tarde");
		buttonGroup.add(rdbtnTarde);
		rdbtnTarde.setBounds(220, 190, 103, 21);
		contentPane.add(rdbtnTarde);
		
		if (rdbtnManiana.isSelected()) {
			turno = "Mañana";
		} else {
			turno = "Tarde";
		}
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addClase();
			}
		});
		btnEnviar.setBounds(220, 232, 85, 21);
		contentPane.add(btnEnviar);
	}
	
	/**
	 * Añade la clase a la lista clase
	 */
	public void addClase() {
		Clases.addClase(creaClase());
	}

	// Crea la clase con el modelo 'Clase'
	private Clases creaClase() {
		String nombre = txtNombre.getText();
		String profesor = txtProfesor.getText();
		Clases clase = new Clases(nombre, profesor, turno);
		return clase;
	}
}
