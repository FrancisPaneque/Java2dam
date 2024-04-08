package Front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaPrincipalNew extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JPanel panelPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipalNew frame = new PantallaPrincipalNew();
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
	public PantallaPrincipalNew() {
		FlatIntelliJLaf.setup();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 532);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCabezera = new JPanel();
		panelCabezera.setBackground(new Color(128, 128, 255));
		contentPane.add(panelCabezera, BorderLayout.NORTH);
		panelCabezera.setLayout(new BorderLayout(0, 0));
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(128, 128, 255));
		panelCabezera.add(panelMenu, BorderLayout.EAST);
		panelMenu.setLayout(new BorderLayout(0, 0));
		
		JLabel espacio1 = new JLabel("     ");
		panelMenu.add(espacio1, BorderLayout.NORTH);
		
		JLabel espacio2 = new JLabel("     ");
		panelMenu.add(espacio2, BorderLayout.EAST);
		
		JLabel espacio3 = new JLabel("     ");
		panelMenu.add(espacio3, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		panelMenu.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton = new JButton("Clientes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcionesCliente(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Francis\\Desktop\\Programación\\workSpaceDI\\JavaSwingTarea2\\imagenes\\usuario (1).png"));
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Productos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcionesProducto(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Francis\\Desktop\\Programación\\workSpaceDI\\JavaSwingTarea2\\imagenes\\carrito-de-compras.png"));
		panel_3.add(btnNewButton_1);
		
		JPanel panelLogo = new JPanel();
		panelLogo.setBackground(new Color(128, 128, 255));
		panelCabezera.add(panelLogo, BorderLayout.WEST);
		panelLogo.setLayout(new BorderLayout(0, 0));
		
		JLabel espacio1_1 = new JLabel("     ");
		panelLogo.add(espacio1_1, BorderLayout.NORTH);
		
		JLabel espacio2_1 = new JLabel("     ");
		panelLogo.add(espacio2_1, BorderLayout.SOUTH);
		
		JLabel espacio3_1 = new JLabel("     ");
		panelLogo.add(espacio3_1, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Francis\\Desktop\\Programación\\workSpaceDI\\JavaSwingTarea2\\imagenes\\Picasso_logo1.png"));
		panelLogo.add(lblNewLabel, BorderLayout.EAST);
		
		JPanel panelPiePagina = new JPanel();
		panelPiePagina.setBackground(new Color(128, 128, 255));
		contentPane.add(panelPiePagina, BorderLayout.SOUTH);
		panelPiePagina.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblPagina = new JLabel("Francisco José Paneque Jurado");
		panelPiePagina.add(lblPagina);
		
		panelPrincipal = new JPanel();
		contentPane.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
	
	protected void funcionesCliente(ActionEvent e) {
		IntermedioCliente intermedioPantalla = new IntermedioCliente();
		intermedioPantalla.setSize(400,300);
		intermedioPantalla.setLocation(5,5);
		
		panelPrincipal.removeAll();
		panelPrincipal.add(intermedioPantalla, BorderLayout.CENTER);
		panelPrincipal.revalidate();
		panelPrincipal.repaint();	
	}
	
	protected void funcionesProducto(ActionEvent e) {
		IntermedioProducto intermedioPantalla = new IntermedioProducto();
		intermedioPantalla.setSize(400,300);
		intermedioPantalla.setLocation(5,5);
		
		panelPrincipal.removeAll();
		panelPrincipal.add(intermedioPantalla, BorderLayout.CENTER);
		panelPrincipal.revalidate();
		panelPrincipal.repaint();	
	}
}
