package Front;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Map;

import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import Cliente.Cliente;
import Utilidades.Utilidades;

public class ListaClientesNew extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public ListaClientesNew() {
		JLabel lblListaProductos = new JLabel("LISTA CLIENTES");
		lblListaProductos.setFont(new Font("Consolas", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(141)
							.addComponent(lblListaProductos, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(lblListaProductos)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEnabled(false);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		setLayout(groupLayout);
		imprimeClientes(textArea);

	}
	
	/**
	 * metodo que imprme a la los clientes dados de alta
	 * @param textArea
	 */
	public static void imprimeClientes(JTextArea textArea) {
		textArea.setText("");
		for (Map.Entry<String, String> entry : Utilidades.clientes.entrySet()) {
            String valor = entry.getValue();
            textArea.append(valor);
            System.out.println(valor);
        }
	}
}
