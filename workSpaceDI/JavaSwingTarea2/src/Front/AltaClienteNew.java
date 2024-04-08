package Front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Cliente.Cliente;
import Utilidades.Utilidades;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AltaClienteNew extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textEdad;
	private JComboBox comboBoxProvincia;
	

	/**
	 * Create the dialog.
	 */
	public AltaClienteNew() {
		
		JPanel contentPanel_1 = new JPanel();
		contentPanel_1.setLayout(null);
		contentPanel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblTitle_1 = new JLabel("ALTA CLIENTE");
		lblTitle_1.setFont(new Font("Consolas", Font.BOLD, 20));
		lblTitle_1.setBounds(10, 10, 143, 20);
		contentPanel_1.add(lblTitle_1);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Consolas", Font.BOLD, 15));
		lblNombre.setBounds(10, 40, 64, 13);
		contentPanel_1.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(10, 58, 195, 28);
		contentPanel_1.add(textNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Consolas", Font.BOLD, 15));
		lblApellidos.setBounds(10, 87, 80, 13);
		contentPanel_1.add(lblApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(10, 110, 195, 28);
		contentPanel_1.add(textApellidos);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Consolas", Font.BOLD, 15));
		lblEdad.setBounds(10, 139, 64, 13);
		contentPanel_1.add(lblEdad);
		
		textEdad = new JTextField();
		textEdad.setColumns(10);
		textEdad.setBounds(10, 162, 195, 28);
		contentPanel_1.add(textEdad);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Consolas", Font.BOLD, 15));
		lblProvincia.setBounds(10, 191, 80, 13);
		contentPanel_1.add(lblProvincia);
		
		JComboBox comboBoxProvincia = new JComboBox();
		comboBoxProvincia.setModel(new DefaultComboBoxModel(new String[] {"Álava", "Albacete", "Alicante", "Almería", "Asturias", "Ávila", "Badajoz", "Barcelona", "Burgos", "Cáceres", "Cádiz", "Cantabria", "Castellón", "Ciudad Real", "Córdoba", "Cuenca", "Gerona (Girona)", "Granada", "Guadalajara", "Guipúzcoa (Gipuzkoa)", "Huelva", "Huesca", "Islas Balears (Baleares)", "Jaén", "La Coruña (A Coruña)", "La Rioja", "Las Palmas", "León", "Lérida (Lleida)", "Lugo", "Madrid", "Málaga", "Murcia", "Navarra", "Orense (Ourense)", "Palencia", "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Segovia", "Sevilla", "Soria", "Tarragona", "Teruel", "Toledo", "Valencia", "Valladolid", "Vizcaya (Bizkaia)", "Zamora", "Zaragoza"}));
		comboBoxProvincia.setBounds(10, 214, 195, 20);
		contentPanel_1.add(comboBoxProvincia);
		
		JLabel lblConfirmacion = new JLabel("");
		lblConfirmacion.setForeground(Color.BLACK);
		lblConfirmacion.setBounds(10, 250, 143, 13);
		contentPanel_1.add(lblConfirmacion);
		
		JButton darAltaButton = new JButton("Dar de alta");
		darAltaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Crea cliente 
				Cliente cliente = Utilidades.creaCliente(textNombre.getText(), textApellidos.getText(), Integer.parseInt(textEdad.getText()), (String) comboBoxProvincia.getSelectedItem());
				//Añade el cliente al mapa
				Utilidades.añadeCliente(cliente);
				if (Utilidades.clientes.containsKey(textNombre.getText())) {
					lblConfirmacion.setText("Se ha añadido un nuevo cliente");
					Utilidades.reiniciaCliente(textNombre, textApellidos, textEdad);
				} else {
					lblConfirmacion.setText("No se ha podido añadir un nuevo cliente");
				}
			}
		});
		darAltaButton.setActionCommand("OK");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(111)
					.addComponent(contentPanel_1, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(darAltaButton, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(17, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(darAltaButton)
						.addComponent(contentPanel_1, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		setLayout(groupLayout);
		
	}
}
