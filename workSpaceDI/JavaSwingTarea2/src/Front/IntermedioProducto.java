package Front;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntermedioProducto extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public IntermedioProducto() {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnLista = new JButton("Listar Productos");
		btnLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaProducto(e);
			}
		});
		add(btnLista);
		
		JButton btnNuevoProducto = new JButton("Nuevo Producto");
		btnNuevoProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevoProducto(e);
			}
		});
		add(btnNuevoProducto);
		
		JButton btnEliminaProducto = new JButton("Elimina Productos");
		btnEliminaProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminaProducto(e);
			}
		});
		add(btnEliminaProducto);

	}
	
	protected void listaProducto(ActionEvent e) {
		ListaProductosNew intermedioPantalla = new ListaProductosNew();
		intermedioPantalla.setSize(400,300);
		intermedioPantalla.setLocation(5,5);
		
		PantallaPrincipalNew.panelPrincipal.removeAll();
		PantallaPrincipalNew.panelPrincipal.add(intermedioPantalla, BorderLayout.CENTER);
		PantallaPrincipalNew.panelPrincipal.revalidate();
		PantallaPrincipalNew.panelPrincipal.repaint();	
	}
	
	protected void nuevoProducto(ActionEvent e) {
		AltaProductoNew intermedioPantalla = new AltaProductoNew();
		intermedioPantalla.setSize(400,300);
		intermedioPantalla.setLocation(5,5);
		
		PantallaPrincipalNew.panelPrincipal.removeAll();
		PantallaPrincipalNew.panelPrincipal.add(intermedioPantalla, BorderLayout.CENTER);
		PantallaPrincipalNew.panelPrincipal.revalidate();
		PantallaPrincipalNew.panelPrincipal.repaint();	
	}
	
	protected void eliminaProducto(ActionEvent e) {
		EliminaProducto intermedioPantalla = new EliminaProducto();
		intermedioPantalla.setSize(400,300);
		intermedioPantalla.setLocation(5,5);
		
		PantallaPrincipalNew.panelPrincipal.removeAll();
		PantallaPrincipalNew.panelPrincipal.add(intermedioPantalla, BorderLayout.CENTER);
		PantallaPrincipalNew.panelPrincipal.revalidate();
		PantallaPrincipalNew.panelPrincipal.repaint();	
	}
}
