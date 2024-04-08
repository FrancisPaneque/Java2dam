package Pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Utils.Reservas;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * Pantalla que lista las clases que hay disponibles para reservar
 * @author Alvaro
 */
public class PanatallaListarClase extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public PanatallaListarClase() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(78, 121, 237));
		panel.setBounds(0, 0, 436, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblListarReservas = new JLabel("Listar Reservas");
		lblListarReservas.setBounds(139, 10, 154, 25);
		lblListarReservas.setForeground(Color.WHITE);
		lblListarReservas.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblListarReservas);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 45, 436, 218);
		contentPane.add(panel_1);
		// Boton para ir a la pagina anterior
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(146, 182, 70, 21);
		
		 // Boton para actualizar la tabla
		JButton btnRecargar = new JButton("Actualiza");
		btnRecargar.setBounds(226, 182, 73, 21);
		panel_1.setLayout(null);
		panel_1.add(btnSalir);
		panel_1.add(btnRecargar);
		
		table = new JTable();
		//Establece un modelo en la tabla
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellido", "Clase", "Turno"
			}
		));
		table.setEnabled(false);
	}
	
	/**
	 * Crea un nuevo modelo de tabla con los nuevos datos de la tabla
	 * @return the model
	 */
	private DefaultTableModel actualizaTabla() {
		DefaultTableModel  modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Clase");
		modelo.addColumn("Turno");
		
		for (int i = 0; i < Reservas.listaReserva.size(); i++) {
			Reservas reservas = Reservas.listaReserva.get(i);
			modelo.addRow(new Object[] {reservas.getNombre(), reservas.getApellidos(), reservas.getClase(), reservas.getTurno()});
		}
		return modelo;
	}
	
	/**
	 * Hace cerrarse la pantalla
	 */
	protected void desaparece() {
		this.dispose();
	}
}
