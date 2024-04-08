package Front;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Utilidades.Utilidades;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaProductos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea textArea;

	/**
	 * Create the dialog.
	 */
	public ListaProductos(PantaPrincipal padre, boolean modal) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblListaProductos = new JLabel("LISTA PRODUCTOS");
			lblListaProductos.setFont(new Font("Consolas", Font.BOLD, 20));
			lblListaProductos.setBounds(10, 10, 185, 20);
			contentPanel.add(lblListaProductos);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 40, 416, 182);
			contentPanel.add(scrollPane);
			{
				textArea = new JTextArea();
				textArea.setWrapStyleWord(true);
				textArea.setEditable(false);
				scrollPane.setViewportView(textArea);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton refrescaListaProductosButton = new JButton("Refrescar lista de Productos");
				refrescaListaProductosButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Utilidades.imprimeProductos(textArea);
					}
				});
				refrescaListaProductosButton.setActionCommand("OK");
				buttonPane.add(refrescaListaProductosButton);
				getRootPane().setDefaultButton(refrescaListaProductosButton);
			}
		}
	}

}
