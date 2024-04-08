package Front;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Producto.Producto;
import Utilidades.Utilidades;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class AltaProductoNew extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombreProducto;
	private JTextField textPrecioUnidad;
	private JLabel lblPrecedero;
	JLabel lblConfirmacionProducto;
	

	/**
	 * Create the dialog.
	 */
	public AltaProductoNew() {
		
		JPanel contentPanel_2 = new JPanel();
		contentPanel_2.setLayout(null);
		contentPanel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblAltaProducto = new JLabel("ALTA PRODUCTO");
		lblAltaProducto.setFont(new Font("Consolas", Font.BOLD, 20));
		lblAltaProducto.setBounds(10, 10, 173, 20);
		contentPanel_2.add(lblAltaProducto);
		
		JLabel lblNombreProducto = new JLabel("Nombre Producto:");
		lblNombreProducto.setFont(new Font("Consolas", Font.BOLD, 15));
		lblNombreProducto.setBounds(10, 40, 128, 13);
		contentPanel_2.add(lblNombreProducto);
		
		textNombreProducto = new JTextField();
		textNombreProducto.setColumns(10);
		textNombreProducto.setBounds(10, 63, 195, 28);
		contentPanel_2.add(textNombreProducto);
		
		JLabel lblPrecioPorUnidad = new JLabel("Precio por unidad:");
		lblPrecioPorUnidad.setFont(new Font("Consolas", Font.BOLD, 15));
		lblPrecioPorUnidad.setBounds(10, 92, 163, 13);
		contentPanel_2.add(lblPrecioPorUnidad);
		
		textPrecioUnidad = new JTextField();
		textPrecioUnidad.setColumns(10);
		textPrecioUnidad.setBounds(10, 115, 195, 28);
		contentPanel_2.add(textPrecioUnidad);
		
		JLabel lblPrecedero_1 = new JLabel("Precedero:");
		lblPrecedero_1.setFont(new Font("Consolas", Font.BOLD, 15));
		lblPrecedero_1.setBounds(10, 144, 80, 13);
		contentPanel_2.add(lblPrecedero_1);
		
		JCheckBox chckbxPrecedero = new JCheckBox("Precedero");
		chckbxPrecedero.setBounds(10, 163, 93, 21);
		contentPanel_2.add(chckbxPrecedero);
		
		JLabel lblConfirmacionProducto = new JLabel("");
		lblConfirmacionProducto.setHorizontalAlignment(SwingConstants.TRAILING);
		lblConfirmacionProducto.setBounds(10, 197, 195, 13);
		contentPanel_2.add(lblConfirmacionProducto);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(122, Short.MAX_VALUE)
					.addComponent(contentPanel_2, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addGap(112))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(contentPanel_2, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		
		JButton btnNewButton = new JButton("Nuevo Producto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto nuevoProducto = Utilidades.creaProducto(textNombreProducto.getText(), Double.valueOf(textPrecioUnidad.getText()), chckbxPrecedero.isSelected());
				Utilidades.añadeProducto(nuevoProducto);
				if (Utilidades.productos.contains(nuevoProducto)) {
					lblConfirmacionProducto.setText("Se ha añadido un nuevo Producto");
					Utilidades.reiniciaProducto(textNombreProducto, textPrecioUnidad);
				} else {
					lblConfirmacionProducto.setText("Se ha producido un erro al añadir en nuevo Producto");
				}
			}
		});
		btnNewButton.setBounds(113, 211, 103, 21);
		contentPanel_2.add(btnNewButton);
		setLayout(groupLayout);
		JPanel contentPanel_1 = new JPanel();
		
	}
}
