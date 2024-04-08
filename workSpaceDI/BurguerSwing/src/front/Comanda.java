package front;

import java.awt.BorderLayout;
import java.util.ArrayList;
import models.*;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Comanda extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static JTable table;
	public static List<Pedido> pedidos= new ArrayList<>();
	


	/**
	 * Create the dialog.
	 */
	public Comanda(GestionMesas padre, boolean modal){
		setBounds(100, 100, 1092, 813);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(244, 164, 96));
			panel.setForeground(new Color(244, 164, 96));
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			JLabel lblNumeroMesa = new JLabel("Comanda" +  GestionMesas.numeroMesa);
			lblNumeroMesa.setFont(new Font("Tahoma", Font.BOLD, 18));
			panel.add(lblNumeroMesa);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.WEST);
			
			JButton btnComida = new JButton("Comida");
			btnComida.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comidaPressed(e);
				}
			});
			
			JButton btnBeida = new JButton("Bebida");
			btnBeida.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bebidaPressed(e);
				}
			});
			
			JButton btnFactura = new JButton("Factura");
			
			JButton btnSalir = new JButton("salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					salidaPressed(e);
				}
			});
			panel.setLayout(new GridLayout(0, 1, 0, 0));
			panel.add(btnComida);
			panel.add(btnBeida);
			panel.add(btnFactura);
			panel.add(btnSalir);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(245, 222, 179));
			panel.setForeground(new Color(245, 222, 179));
			contentPanel.add(panel, BorderLayout.CENTER);
			
			JScrollPane scrollPane = new JScrollPane();
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(193)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 584, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(206, Short.MAX_VALUE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(119, Short.MAX_VALUE))
			);
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nombre", "Precio"
				}
			));
			scrollPane.setViewportView(table);
			panel.setLayout(gl_panel);
		}
	}
	protected void comidaPressed (ActionEvent e) {
        ComandaComida registro = new ComandaComida(this, true);
        registro.setVisible(true);
        
    }
	
	protected void bebidaPressed (ActionEvent e) {
        ComandaBebida registro = new ComandaBebida(this, true);
        registro.setVisible(true);
        
    }
	
	protected void salidaPressed(ActionEvent e) {
	    // Cierra el JDialog
	    this.dispose(); // Si la clase en la que estás implementando este método es un JDialog
	    // O bien:
	    // comandaComida.dispose(); // Si la clase es un JDialog llamado comandaComida
	}
}