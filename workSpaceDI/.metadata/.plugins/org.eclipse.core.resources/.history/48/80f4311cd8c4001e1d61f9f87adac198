package front;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import util.UtilidadesLogin;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Carta extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static JTable table;
	public static JTable table_1;

	/**
	 * Create the dialog.
	 */
	public Carta(Login padre, boolean modal) {
		
		setBounds(100, 100, 869, 688);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelCabecera = new JPanel();
			panelCabecera.setBackground(new Color(255, 127, 80));
			contentPanel.add(panelCabecera, BorderLayout.NORTH);
			JLabel lblNewLabel = new JLabel("Carta");
			lblNewLabel.setForeground(new Color(248, 248, 255));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GroupLayout gl_panelCabecera = new GroupLayout(panelCabecera);
			gl_panelCabecera.setHorizontalGroup(
				gl_panelCabecera.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelCabecera.createSequentialGroup()
						.addGap(391)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(397, Short.MAX_VALUE))
			);
			gl_panelCabecera.setVerticalGroup(
				gl_panelCabecera.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelCabecera.createSequentialGroup()
						.addComponent(lblNewLabel)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			panelCabecera.setLayout(gl_panelCabecera);
		}
		{
			JPanel panelCarta = new JPanel();
			contentPanel.add(panelCarta, BorderLayout.CENTER);
			panelCarta.setLayout(new BorderLayout(0, 0));
			{
				JPanel panelComida = new JPanel();
				panelCarta.add(panelComida, BorderLayout.NORTH);
				panelComida.setLayout(new BorderLayout(0, 0));
				{
					JPanel panelTituloComida = new JPanel();
					panelTituloComida.setBackground(new Color(240, 230, 140));
					panelTituloComida.setForeground(new Color(240, 230, 140));
					panelComida.add(panelTituloComida, BorderLayout.NORTH);
					JLabel lblComida = new JLabel("Comida");
					lblComida.setBackground(new Color(248, 248, 255));
					lblComida.setFont(new Font("Tahoma", Font.BOLD, 15));
					GroupLayout gl_panelTituloComida = new GroupLayout(panelTituloComida);
					gl_panelTituloComida.setHorizontalGroup(
						gl_panelTituloComida.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelTituloComida.createSequentialGroup()
								.addGap(388)
								.addComponent(lblComida)
								.addContainerGap(398, Short.MAX_VALUE))
					);
					gl_panelTituloComida.setVerticalGroup(
						gl_panelTituloComida.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelTituloComida.createSequentialGroup()
								.addComponent(lblComida)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					);
					panelTituloComida.setLayout(gl_panelTituloComida);
				}
				{
					JPanel panelTablaComida = new JPanel();
					panelComida.add(panelTablaComida, BorderLayout.SOUTH);
					
					JScrollPane scrollPane = new JScrollPane();
					GroupLayout gl_panelTablaComida = new GroupLayout(panelTablaComida);
					gl_panelTablaComida.setHorizontalGroup(
						gl_panelTablaComida.createParallelGroup(Alignment.LEADING)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
					);
					gl_panelTablaComida.setVerticalGroup(
						gl_panelTablaComida.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelTablaComida.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					);
					
					table = new JTable();
					table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Nombre", "Precio", "Ingredientes"
						}
					));
					scrollPane.setViewportView(table);
					panelTablaComida.setLayout(gl_panelTablaComida);
				}
				//Actualiza la carta
				table.setModel(UtilidadesLogin.actualizaTablaComida());
			}
			{
				JPanel panelBebida = new JPanel();
				panelCarta.add(panelBebida, BorderLayout.SOUTH);
				panelBebida.setLayout(new BorderLayout(0, 0));
				
				JPanel panelTituloBebida = new JPanel();
				panelTituloBebida.setBackground(new Color(240, 230, 140));
				panelTituloBebida.setForeground(new Color(240, 230, 140));
				panelBebida.add(panelTituloBebida, BorderLayout.NORTH);
				
				JLabel lblBebida = new JLabel("Bebida");
				lblBebida.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblBebida.setBackground(new Color(248, 248, 255));
				GroupLayout gl_panelTituloBebida = new GroupLayout(panelTituloBebida);
				gl_panelTituloBebida.setHorizontalGroup(
					gl_panelTituloBebida.createParallelGroup(Alignment.LEADING)
						.addGap(0, 844, Short.MAX_VALUE)
						.addGroup(gl_panelTituloBebida.createSequentialGroup()
							.addGap(388)
							.addComponent(lblBebida)
							.addContainerGap(398, Short.MAX_VALUE))
				);
				gl_panelTituloBebida.setVerticalGroup(
					gl_panelTituloBebida.createParallelGroup(Alignment.LEADING)
						.addGap(0, 29, Short.MAX_VALUE)
						.addGroup(gl_panelTituloBebida.createSequentialGroup()
							.addComponent(lblBebida)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
				panelTituloBebida.setLayout(gl_panelTituloBebida);
				
				JPanel panelTablaBebida = new JPanel();
				panelBebida.add(panelTablaBebida, BorderLayout.SOUTH);
				
				JScrollPane scrollPane = new JScrollPane();
				GroupLayout gl_panelTablaBebida = new GroupLayout(panelTablaBebida);
				gl_panelTablaBebida.setHorizontalGroup(
					gl_panelTablaBebida.createParallelGroup(Alignment.LEADING)
						.addGap(0, 844, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
				);
				gl_panelTablaBebida.setVerticalGroup(
					gl_panelTablaBebida.createParallelGroup(Alignment.LEADING)
						.addGap(0, 215, Short.MAX_VALUE)
						.addGroup(gl_panelTablaBebida.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
				
				table_1 = new JTable();
				table_1.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Nombre", "Precio"
					}
				));
				scrollPane.setViewportView(table_1);
				panelTablaBebida.setLayout(gl_panelTablaBebida);
			}
			//Actualiza tabla
			table_1.setModel(UtilidadesLogin.actualizaTablaBebida());
		}
		{
			JPanel panelPie = new JPanel();
			panelPie.setBackground(new Color(240, 230, 140));
			contentPanel.add(panelPie, BorderLayout.SOUTH);
			
			JButton btnNewButton = new JButton("Volver");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					volverPressed(e);
				}
			});
			GroupLayout gl_panelPie = new GroupLayout(panelPie);
			gl_panelPie.setHorizontalGroup(
				gl_panelPie.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelPie.createSequentialGroup()
						.addGap(378)
						.addComponent(btnNewButton)
						.addContainerGap(406, Short.MAX_VALUE))
			);
			gl_panelPie.setVerticalGroup(
				gl_panelPie.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelPie.createSequentialGroup()
						.addComponent(btnNewButton)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			panelPie.setLayout(gl_panelPie);
		}
	}
	
	protected void volverPressed(ActionEvent e) {
		this.setVisible(false);
	}
}
