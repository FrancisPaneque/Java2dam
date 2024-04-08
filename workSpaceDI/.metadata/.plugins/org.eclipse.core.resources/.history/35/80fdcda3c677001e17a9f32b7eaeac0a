package Front;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

import Utilidades.Utilidades;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PantaPrincipal {

	private JFrame frame;
	public static JTextArea textAreaClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantaPrincipal window = new PantaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 589, 381);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 555, 194);
		frame.getContentPane().add(scrollPane);
		
		textAreaClientes = new JTextArea();
		textAreaClientes.setWrapStyleWord(true);
		textAreaClientes.setEditable(false);
		scrollPane.setViewportView(textAreaClientes);
		
		JButton btnNewButton = new JButton("Refrescar lista clientes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utilidades.imprimeClientes(textAreaClientes);
			}
		});
		btnNewButton.setBounds(216, 214, 135, 21);
		frame.getContentPane().add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu clientesMenu = new JMenu("CLIENTE");
		menuBar.add(clientesMenu);
		
		JMenuItem altaClienteMenuItem = new JMenuItem("Dar de alta");
		clientesMenu.add(altaClienteMenuItem);
		altaClienteMenuItem.addActionListener((ActionListener) new ActionListener(){
		  public void actionPerformed(ActionEvent e) {
			  altaClientePressed(e);
		  }
		});
		
		
		JMenuItem bajaClienteMenuIte = new JMenuItem("Dar de baja");
		clientesMenu.add(bajaClienteMenuIte);
		bajaClienteMenuIte.addActionListener((ActionListener) new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				  bajaClientePressed(e);
			  }
		});
		
		JMenu productoMenu = new JMenu("PRODUCTO");
		menuBar.add(productoMenu);
		
		JMenuItem altaProductoMenuItem = new JMenuItem("Dar de alta");
		productoMenu.add(altaProductoMenuItem);
		altaProductoMenuItem.addActionListener((ActionListener) new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				  altaProductoPressed(e);
			  }
		});
		
		JMenuItem listaProductoMenuItem = new JMenuItem("Listar");
		productoMenu.add(listaProductoMenuItem);
		listaProductoMenuItem.addActionListener((ActionListener) new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				  listaProductoPressed(e);
			  }
		});
	}

	protected void listaProductoPressed(ActionEvent e) {
		ListaProductos listaProducto = new ListaProductos(this, true);
		listaProducto.setVisible(true);
		
	}

	protected void altaProductoPressed(ActionEvent e) {
		AltaProducto altaProducto = new AltaProducto(this, true);
		altaProducto.setVisible(true);
		
	}

	protected void bajaClientePressed(ActionEvent e) {
		BajaCliente bajaCliente = new BajaCliente(this, true);
		bajaCliente.setVisible(true);
		
	}

	protected void altaClientePressed(ActionEvent e) {
		AltaCliente altaCliente = new AltaCliente(this, true);
		altaCliente.setVisible(true);
		
	}
}
