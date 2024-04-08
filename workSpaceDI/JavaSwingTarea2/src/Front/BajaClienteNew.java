package Front;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Utilidades.Utilidades;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class BajaClienteNew extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textClienteBaja;
	JLabel lblConfirmacion;

	/**
	 * Create the dialog.
	 */
	public BajaClienteNew() {
		
		JPanel contentPanel_2 = new JPanel();
		contentPanel_2.setLayout(null);
		contentPanel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblBajaCliente = new JLabel("BAJA CLIENTE");
		lblBajaCliente.setFont(new Font("Consolas", Font.BOLD, 20));
		lblBajaCliente.setBounds(10, 10, 143, 20);
		contentPanel_2.add(lblBajaCliente);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Consolas", Font.BOLD, 15));
		lblNombre.setBounds(10, 40, 64, 13);
		contentPanel_2.add(lblNombre);
		
		textClienteBaja = new JTextField();
		textClienteBaja.setColumns(10);
		textClienteBaja.setBounds(10, 63, 195, 19);
		contentPanel_2.add(textClienteBaja);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(66)
					.addComponent(contentPanel_2, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(73, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(contentPanel_2, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(116, Short.MAX_VALUE))
		);
		
		JButton btnDarDeBaja = new JButton("Dar de baja");
		btnDarDeBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utilidades.eliminaCliente(textClienteBaja.getText());
				if (!Utilidades.clientes.containsKey(textClienteBaja.getText())) {
					lblConfirmacion.setText("Se ha eliminado el cliente");
					textClienteBaja.setText("");
					
				} else {
					lblConfirmacion.setText("No se ha podido eliminar el cliente");
				}
			}
		});
		btnDarDeBaja.setBounds(10, 143, 104, 21);
		contentPanel_2.add(btnDarDeBaja);
		
		lblConfirmacion = new JLabel("");
		lblConfirmacion.setBounds(10, 92, 195, 13);
		contentPanel_2.add(lblConfirmacion);
		setLayout(groupLayout);
		JPanel contentPanel_1 = new JPanel();
		
	}	
}
