package frontApp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.Usuario;
import utilidades.UtilidadesApp;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ListaClientes extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField textField;

	/**
	 * Create the dialog.
	 * @param b 
	 * @param pantallaAdmin 
	 */
	public ListaClientes(PantallaAdmin pantallaAdmin, boolean b) {
		setBounds(100, 100, 701, 554);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			
			JScrollPane scrollPane = new JScrollPane();
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
			);
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nombre", "Apellidos", "Fecha Nacimiento", "Email"
				}
			));
			scrollPane.setViewportView(table);
			//Actualiza la tabla con los datos
			table.setModel(actualizaTabla());
			panel.setLayout(gl_panel);
					}
		{
			JPanel panelCabeceraRegistro = new JPanel();
			panelCabeceraRegistro.setBackground(new Color(0, 128, 255));
			contentPanel.add(panelCabeceraRegistro, BorderLayout.NORTH);
			panelCabeceraRegistro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel lblListarClientes = new JLabel("Listar Clientes");
				lblListarClientes.setForeground(Color.WHITE);
				lblListarClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
				panelCabeceraRegistro.add(lblListarClientes);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JLabel lblNewLabel = new JLabel("Apellidos");
			
			textField = new JTextField();
			textField.setColumns(10);
			
			JButton btnNewButton = new JButton("Filtrar");
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(137)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnNewButton)
						.addContainerGap(141, Short.MAX_VALUE))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton))
						.addContainerGap(13, Short.MAX_VALUE))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}
	
	protected DefaultTableModel actualizaTabla() {
	    DefaultTableModel model = new DefaultTableModel();
	    model.addColumn("Nombre");
	    model.addColumn("Apellido");
	    model.addColumn("Edad");
	    model.addColumn("Provincia");
	    
	    for (int i = 0; i < UtilidadesApp.listaDeUsuarios.size(); i++) {
	      Usuario clientes = UtilidadesApp.devuelveCliente(i);
	      model.addRow(new Object[] {clientes.getNombre(), clientes.getApellidos(), clientes.getFechaNacimiento(), clientes.getEmail()});
	    }
	    return model;
	}
	
}
