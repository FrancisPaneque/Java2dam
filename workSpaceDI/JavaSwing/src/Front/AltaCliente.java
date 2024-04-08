package Front;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Cliente.Cliente;
import Utilidades.Utilidades;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class AltaCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textEdad;
	private JComboBox comboBoxProvincia;

	/**
	 * Create the dialog.
	 */
	public AltaCliente(PantaPrincipal padre, boolean modal) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 235, 341);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTitle = new JLabel("ALTA CLIENTE");
			lblTitle.setFont(new Font("Consolas", Font.BOLD, 20));
			lblTitle.setBounds(10, 10, 143, 20);
			contentPanel.add(lblTitle);
		}
		{
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Consolas", Font.BOLD, 15));
			lblNombre.setBounds(10, 40, 64, 13);
			contentPanel.add(lblNombre);
		}
		{
			textNombre = new JTextField();
			textNombre.setColumns(10);
			textNombre.setBounds(10, 58, 195, 19);
			contentPanel.add(textNombre);
		}
		{
			JLabel lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setFont(new Font("Consolas", Font.BOLD, 15));
			lblApellidos.setBounds(10, 87, 80, 13);
			contentPanel.add(lblApellidos);
		}
		{
			textApellidos = new JTextField();
			textApellidos.setColumns(10);
			textApellidos.setBounds(10, 110, 195, 19);
			contentPanel.add(textApellidos);
		}
		{
			JLabel lblEdad = new JLabel("Edad:");
			lblEdad.setFont(new Font("Consolas", Font.BOLD, 15));
			lblEdad.setBounds(10, 139, 64, 13);
			contentPanel.add(lblEdad);
		}
		{
			textEdad = new JTextField();
			textEdad.setColumns(10);
			textEdad.setBounds(10, 162, 195, 19);
			contentPanel.add(textEdad);
		}
		{
			JLabel lblProvincia = new JLabel("Provincia:");
			lblProvincia.setFont(new Font("Consolas", Font.BOLD, 15));
			lblProvincia.setBounds(10, 191, 80, 13);
			contentPanel.add(lblProvincia);
		}
		{
			comboBoxProvincia = new JComboBox();
			comboBoxProvincia.setModel(new DefaultComboBoxModel(new String[] {"Álava", "Albacete", "Alicante", "Almería", "Asturias", "Ávila", "Badajoz", "Barcelona", "Burgos", "Cáceres", "Cádiz", "Cantabria", "Castellón", "Ciudad Real", "Córdoba", "Cuenca", "Gerona (Girona)", "Granada", "Guadalajara", "Guipúzcoa (Gipuzkoa)", "Huelva", "Huesca", "Islas Balears (Baleares)", "Jaén", "La Coruña (A Coruña)", "La Rioja", "Las Palmas", "León", "Lérida (Lleida)", "Lugo", "Madrid", "Málaga", "Murcia", "Navarra (Nafarroa)", "Orense (Ourense)", "Palencia", "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Segovia", "Sevilla", "Soria", "Tarragona", "Teruel", "Toledo", "Valencia", "Valladolid", "Vizcaya (Bizkaia)", "Zamora", "Zaragoza"}));
			comboBoxProvincia.setBounds(10, 214, 195, 20);
			contentPanel.add(comboBoxProvincia);
		}
		
		JLabel lblConfirmacion = new JLabel("");
		lblConfirmacion.setForeground(new Color(0, 0, 0));
		lblConfirmacion.setBounds(10, 250, 143, 13);
		contentPanel.add(lblConfirmacion);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
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
				buttonPane.add(darAltaButton);
				getRootPane().setDefaultButton(darAltaButton);
			}
		}
	}
}
