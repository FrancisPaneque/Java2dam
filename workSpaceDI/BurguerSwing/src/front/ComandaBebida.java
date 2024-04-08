package front;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import models.Bebida;
import models.Comida;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ComandaBebida extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textCantidad;

	/**
	 * Create the dialog.
	 */
	public ComandaBebida(Comanda padre, boolean modal) {
		setBounds(100, 100, 1026, 753);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("New label");
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			JLabel lblNewLabel_1 = new JLabel("New label");
			JLabel lblNewLabel_2 = new JLabel("New label");
			JLabel lblNewLabel_3 = new JLabel("New label");
			JLabel lblPrecio = new JLabel("Precio");
			JButton btnNewButton = new JButton("Salir");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					salidaPressed(e);
				}
			});
			
			JComboBox comboBox = new JComboBox();
			// Crear el modelo y añadir los elementos al modelo
	        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
	        for (Bebida item : util.UtilidadesLogin.bebidas) {
	            model.addElement(item.getNombreBebida());
	        }
	        // Establecer el modelo en el JComboBox
	        comboBox.setModel(model);
	        
	        comboBox.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	                // Obtener el nombre de la comida seleccionada del JComboBox
	                String selectedComidaName = (String) comboBox.getSelectedItem();
	                
	                // Buscar el objeto Comida correspondiente al nombre seleccionado
	                Bebida selectedComida = null;
	                for (Bebida comida : util.UtilidadesLogin.bebidas) {
	                    if (comida.getNombreBebida().equals(selectedComidaName)) {
	                        selectedComida = comida;
	                        break;
	                    }
	                }
	                
	                // Verificar si se encontró la comida seleccionada
	                if (selectedComida != null) {
	                    // Mostrar el precio en el JLabel
	                    lblPrecio.setText(Integer.toString(selectedComida.getPrecio()));
	                } else {
	                    // Manejar el caso cuando no se encuentra la comida seleccionada
	                	lblPrecio.setText("Precio no disponible");
	                }
	            }
			});
	        
	        JButton btnNewButton_1 = new JButton("Añadir");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			        String selectedComidaName = (String) comboBox.getSelectedItem();
			        Bebida selectedComida = null;
			        for (Bebida comida : util.UtilidadesLogin.bebidas) {
			            if (comida.getNombreBebida().equals(selectedComidaName)) {
			                selectedComida = comida;
			                break;
			            }
			        }
			        for (int i = 0; i <= Integer.parseInt(textCantidad.getText()) - 1; i++) {
				        if (selectedComida != null) {
				            // Obtener el modelo de la tabla
				            DefaultTableModel model = (DefaultTableModel) Comanda.table.getModel();
				            // Añadir una nueva fila al modelo con el nombre de la comida y su precio
				            model.addRow(new Object[]{selectedComidaName, selectedComida.getPrecio()});
				        }
			        }
			    }
			});
			
			textCantidad = new JTextField();
			textCantidad.setColumns(10);
			
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(119)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addGap(337)
										.addComponent(lblPrecio, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
										.addGap(168)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
											.addComponent(textCantidad)
											.addComponent(comboBox, 0, 407, Short.MAX_VALUE)))))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(263)
								.addComponent(btnNewButton)
								.addGap(222)
								.addComponent(btnNewButton_1)))
						.addContainerGap(263, Short.MAX_VALUE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(76)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(132)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2)
							.addComponent(textCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(139)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_3)
							.addComponent(lblPrecio))
						.addPreferredGap(ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton)
							.addComponent(btnNewButton_1))
						.addGap(130))
			);
			panel.setLayout(gl_panel);
		}
	}
	
	protected void salidaPressed(ActionEvent e) {
	    // Cierra el JDialog
	    this.dispose(); // Si la clase en la que estás implementando este método es un JDialog
	    // O bien:
	    // comandaComida.dispose(); // Si la clase es un JDialog llamado comandaComida
	}

}