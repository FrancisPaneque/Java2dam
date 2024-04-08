package Pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Utils.Clases;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

/**
 * Pantalla que permite a los clientes reservar las clases disponibles
 * @author Alvaro
 *
 */
public class PantallaReservaClase extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PantallaReservaClase() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 42);
		panel.setBackground(new Color(78, 121, 237));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblReservarClase = new JLabel("Reservar Clase");
		lblReservarClase.setBounds(144, 10, 149, 22);
		lblReservarClase.setForeground(Color.WHITE);
		lblReservarClase.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblReservarClase.setBackground(new Color(78, 121, 237));
		panel.add(lblReservarClase);
		
		JLabel lblClase = new JLabel("Clase");
		lblClase.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClase.setBounds(38, 74, 45, 13);
		contentPane.add(lblClase);
		
		JLabel lblTurno = new JLabel("Turno");
		lblTurno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTurno.setBounds(38, 142, 45, 13);
		contentPane.add(lblTurno);
		
		JComboBox cbClase = new JComboBox();
		cbClase.setModel(actualizaClases());
		cbClase.setBounds(223, 72, 138, 21);
		contentPane.add(cbClase);
		
		JComboBox cbTurno = new JComboBox();
		cbTurno.setBounds(223, 134, 138, 21);
		contentPane.add(cbTurno);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.setBounds(223, 192, 85, 21);
		contentPane.add(btnReservar);
	}
	
	/**
	 * Crea un nuevo model con los datos de la lista clase
	 * @return the DefaultComboBoxModel
	 */
	private DefaultComboBoxModel actualizaClases() {
		List<String> lista = new ArrayList<>();
		for (int i = 0; i <= Clases.listaClase.size(); i++) {
			lista.add(Clases.listaClase.get(i).getNombre());
		}
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addAll(lista);
		return model;

	}
	
}
