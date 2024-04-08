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
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BajaCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textClienteBaja;

	/**
	 * Create the dialog.
	 */
	public BajaCliente(PantaPrincipal padre, boolean modal) {
		setBounds(100, 100, 325, 242);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblBajaCliente = new JLabel("BAJA CLIENTE");
			lblBajaCliente.setFont(new Font("Consolas", Font.BOLD, 20));
			lblBajaCliente.setBounds(10, 10, 143, 20);
			contentPanel.add(lblBajaCliente);
		}
		{
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Consolas", Font.BOLD, 15));
			lblNombre.setBounds(10, 40, 64, 13);
			contentPanel.add(lblNombre);
		}
		{
			textClienteBaja = new JTextField();
			textClienteBaja.setColumns(10);
			textClienteBaja.setBounds(10, 63, 195, 19);
			contentPanel.add(textClienteBaja);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton bajaClienteButton = new JButton("Dar de baja");
				bajaClienteButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Utilidades.eliminaCliente(textClienteBaja.getText());
					}
				});
				bajaClienteButton.setActionCommand("OK");
				buttonPane.add(bajaClienteButton);
				getRootPane().setDefaultButton(bajaClienteButton);
			}
		}
	}

}
