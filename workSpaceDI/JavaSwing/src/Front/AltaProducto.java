package Front;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Producto.Producto;
import Utilidades.Utilidades;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class AltaProducto extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombreProducto;
	private JTextField textPrecioUnidad;
	private JLabel lblPrecedero;
	JLabel lblConfirmacionProducto;
	

	/**
	 * Create the dialog.
	 */
	public AltaProducto(PantaPrincipal padre, boolean modal) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAltaProducto = new JLabel("ALTA PRODUCTO");
			lblAltaProducto.setFont(new Font("Consolas", Font.BOLD, 20));
			lblAltaProducto.setBounds(10, 10, 173, 20);
			contentPanel.add(lblAltaProducto);
		}
		{
			JLabel lblNombreProducto = new JLabel("Nombre Producto:");
			lblNombreProducto.setFont(new Font("Consolas", Font.BOLD, 15));
			lblNombreProducto.setBounds(10, 40, 128, 13);
			contentPanel.add(lblNombreProducto);
		}
		{
			textNombreProducto = new JTextField();
			textNombreProducto.setColumns(10);
			textNombreProducto.setBounds(10, 63, 195, 19);
			contentPanel.add(textNombreProducto);
		}
		{
			JLabel lblPrecioPorUnidad = new JLabel("Precio por unidad:");
			lblPrecioPorUnidad.setFont(new Font("Consolas", Font.BOLD, 15));
			lblPrecioPorUnidad.setBounds(10, 92, 163, 13);
			contentPanel.add(lblPrecioPorUnidad);
		}
		{
			textPrecioUnidad = new JTextField();
			textPrecioUnidad.setColumns(10);
			textPrecioUnidad.setBounds(10, 115, 195, 19);
			contentPanel.add(textPrecioUnidad);
		}
		{
			lblPrecedero = new JLabel("Precedero:");
			lblPrecedero.setFont(new Font("Consolas", Font.BOLD, 15));
			lblPrecedero.setBounds(10, 144, 80, 13);
			contentPanel.add(lblPrecedero);
		}
		
		JCheckBox chckbxPrecedero = new JCheckBox("Precedero");
		chckbxPrecedero.setBounds(10, 163, 93, 21);
		contentPanel.add(chckbxPrecedero);
		{
			lblConfirmacionProducto = new JLabel("");
			lblConfirmacionProducto.setHorizontalAlignment(SwingConstants.TRAILING);
			lblConfirmacionProducto.setBounds(10, 197, 363, 13);
			contentPanel.add(lblConfirmacionProducto);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
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
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
