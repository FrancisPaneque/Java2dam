package Front;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import Utilidades.Utilidades;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminaProducto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JLabel lblConfirmacion;

	/**
	 * Create the panel.
	 */
	public EliminaProducto() {
		
		JPanel contentPanel_2 = new JPanel();
		contentPanel_2.setLayout(null);
		contentPanel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblEliminarProducto = new JLabel("ELIMINAR PRODUCTO");
		lblEliminarProducto.setFont(new Font("Consolas", Font.BOLD, 20));
		lblEliminarProducto.setBounds(10, 10, 195, 20);
		contentPanel_2.add(lblEliminarProducto);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Consolas", Font.BOLD, 15));
		lblNombre.setBounds(10, 40, 64, 13);
		contentPanel_2.add(lblNombre);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 63, 195, 19);
		contentPanel_2.add(textField);
		
		lblConfirmacion = new JLabel("");
		lblConfirmacion.setBounds(10, 92, 195, 13);
		contentPanel_2.add(lblConfirmacion);
		
		JButton btnDarDeBaja = new JButton("Eliminar Producto");
		btnDarDeBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utilidades.eliminaProducto(textField.getText());
				if (!Utilidades.productos.contains(textField.getText())) {
					lblConfirmacion.setText("Se ha eliminado el producto");
					textField.setText("");
					
				} else {
					lblConfirmacion.setText("No se ha podido eliminar el producto");
				}
			}
		});
		btnDarDeBaja.setBounds(10, 143, 128, 21);
		contentPanel_2.add(btnDarDeBaja);
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addComponent(contentPanel_2, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(70, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(contentPanel_2, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(116, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
