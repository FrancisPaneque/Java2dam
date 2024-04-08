package Pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import Utils.Cliente;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Panatalla que lista a todos los clientes que existen
 * @author Alvaro
 *
 */
public class PantallaListarClientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	/**
	 * Create the frame.
	 */
	public PantallaListarClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 426, 35);
		panel.setBackground(new Color(78, 121, 237));
		contentPane.add(panel);
		
		JLabel lblListarCliente = new JLabel("Listar Clientes");
		lblListarCliente.setForeground(Color.WHITE);
		lblListarCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblListarCliente);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 40, 426, 218);
		contentPane.add(panel_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellido", "Fecha Nacimiento", "Email"
			}
		));
		table.setEnabled(false);
		
		JButton btnRecargar = new JButton("Actualiza");
		btnRecargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(actualizaTabla());
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desaparece();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(121, Short.MAX_VALUE)
					.addComponent(btnSalir)
					.addGap(18)
					.addComponent(btnRecargar)
					.addGap(129))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRecargar)
						.addComponent(btnSalir))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
	}
	
	/**
	 * Crea un model de la tabla con los datos de la lista cliente actualizada
	 * @return the DefaultTableModel
	 */
	private DefaultTableModel actualizaTabla() {
		DefaultTableModel  modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Fecha Nacimiento");
		modelo.addColumn("Email");
		
		for (int i = 0; i < Cliente.tamanioLista(); i++) {
			Cliente cliente = Cliente.devuelveCliente(i);
			modelo.addRow(new Object[] {cliente.getNombre(), cliente.getApellidos(), cliente.getFechaNacimiento(), cliente.getEmail()});
		}
		return modelo;
	}
	
	/**
	 *  Hace que se cierre la pantalla
	 */
	protected void desaparece() {
		this.dispose();
	}
}
