package front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import utils.Utilidades;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("resources/logoApp.png"));
		panel.add(lblLogo);
		
		JLabel lblTitulo = new JLabel("    RECUPERACION");
		lblTitulo.setForeground(new Color(0, 128, 255));
		lblTitulo.setFont(new Font("Source Serif Pro Semibold", Font.BOLD, 18));
		panel.add(lblTitulo);
		
		JPanel menu = new JPanel();
		contentPane.add(menu, BorderLayout.EAST);
		menu.setLayout(new BorderLayout(0, 0));
		
		JPanel titulo = new JPanel();
		titulo.setBackground(new Color(128, 255, 255));
		menu.add(titulo, BorderLayout.NORTH);
		titulo.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel(" ");
		titulo.add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		titulo.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_2 = new JLabel("                   ");
		titulo.add(lblNewLabel_2, BorderLayout.WEST);
		
		JLabel lblNewLabel_3 = new JLabel("                   ");
		titulo.add(lblNewLabel_3, BorderLayout.EAST);
		
		JLabel lblNewLabel_4 = new JLabel("Menu de opciones");
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		titulo.add(lblNewLabel_4, BorderLayout.CENTER);
		
		JPanel opciones = new JPanel();
		opciones.setBackground(new Color(192, 192, 192));
		menu.add(opciones, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Registro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cuestionarioPressed(e);
			}
		});
		/**
		 * ACTUALIZA TABLA
		 */
		JButton btnNewButton_1 = new JButton("Actualiza Tabla");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(Utilidades.actualizaTabla()); 
			}
		});
		GroupLayout gl_opciones = new GroupLayout(opciones);
		gl_opciones.setHorizontalGroup(
			gl_opciones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_opciones.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_opciones.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(145, Short.MAX_VALUE))
		);
		gl_opciones.setVerticalGroup(
			gl_opciones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_opciones.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addContainerGap(241, Short.MAX_VALUE))
		);
		opciones.setLayout(gl_opciones);
		
		JPanel tabla = new JPanel();
		contentPane.add(tabla, BorderLayout.WEST);
		tabla.setLayout(new BorderLayout(0, 0));
		
		JPanel tituloTabla = new JPanel();
		tituloTabla.setBackground(new Color(128, 255, 255));
		tabla.add(tituloTabla, BorderLayout.NORTH);
		tituloTabla.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel(" ");
		tituloTabla.add(lblNewLabel_5, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1_1 = new JLabel(" ");
		tituloTabla.add(lblNewLabel_1_1, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_2_1 = new JLabel("                                               ");
		tituloTabla.add(lblNewLabel_2_1, BorderLayout.WEST);
		
		JLabel lblNewLabel_3_1 = new JLabel("                                     ");
		tituloTabla.add(lblNewLabel_3_1, BorderLayout.EAST);
		
		JLabel lblNewLabel_4_1 = new JLabel("Lista de usuarios");
		lblNewLabel_4_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		tituloTabla.add(lblNewLabel_4_1, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		tabla.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 128));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"aa", "dd", "ss", "aa"},
				{null, null, null, null}
			},
			new String[] {
				"name", "mail", "sexo", "numero"
			}
		){
			Class[] columnTypes = new Class[] {
					String.class, String.class, Integer.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		scrollPane.setViewportView(table);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
		);
		panel_1.setLayout(gl_panel_1);
	}
	
	protected void cuestionarioPressed(ActionEvent e) {
		Cuestionario registro = new Cuestionario(this, true);
		registro.setVisible(true);
		
	}
}
