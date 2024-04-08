package Pantalla;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JYearChooser;

public class PantallaLista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public PantallaLista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"aa", "dd", "ss", "aa"},
				{null, null, null, null},
			},
			new String[] {
				"name", "edad", "id", "sexx"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(25, 75, 390, 300);
		contentPane.add(table);
		
		JLabel lblTitulo = new JLabel("Paneque comeme los huevos");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitulo.setBounds(25, 10, 332, 29);
		contentPane.add(lblTitulo);
		
		JButton btn = new JButton("New button");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(actualizaTabla());
			}
		});
		btn.setBounds(180, 432, 85, 21);
		contentPane.add(btn);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(38, 399, 46, 19);
		contentPane.add(yearChooser);
		
		subnormales.add(new subnormales("paneque", "39", 1, "homo"));
		subnormales.add(new subnormales("pedro", "15", 2, "hetero"));
		subnormales.add(new subnormales("miguel empirico", "88", 3, "auto sexul(coches)"));
		subnormales.add(new subnormales("dios creador de la clase", "9999", 33, "mason??"));
	}
	
	private DefaultTableModel actualizaTabla() {
		DefaultTableModel  modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("edad");
		modelo.addColumn("id");
		modelo.addColumn("sexx");
		
		for (int i = 0; i < subnormales.tamanioLista(); i++) {
			subnormales cliente = subnormales.devuelve(i);
			modelo.addRow(new Object[] {cliente.getNombre(), cliente.getEdad(), cliente.getId(), cliente.getSex()});
		}
		return modelo;
	}
}
