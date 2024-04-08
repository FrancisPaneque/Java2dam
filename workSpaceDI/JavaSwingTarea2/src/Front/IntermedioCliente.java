package Front;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntermedioCliente extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public IntermedioCliente() {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnLista = new JButton("Listar Clientes");
		btnLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaCliente(e);
			}
		});
		add(btnLista);
		
		JButton btnAlta = new JButton("Dar de alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaCliente(e);
			}
		});
		add(btnAlta);
		
		JButton btnBaja = new JButton("Dar de baja");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bajaCliente(e);
			}
		});
		add(btnBaja);

	}
	
	protected void altaCliente(ActionEvent e) {
		AltaClienteNew intermedioPantalla = new AltaClienteNew();
		intermedioPantalla.setSize(400,300);
		intermedioPantalla.setLocation(5,5);
		
		PantallaPrincipalNew.panelPrincipal.removeAll();
		PantallaPrincipalNew.panelPrincipal.add(intermedioPantalla, BorderLayout.CENTER);
		PantallaPrincipalNew.panelPrincipal.revalidate();
		PantallaPrincipalNew.panelPrincipal.repaint();	
	}
	
	protected void bajaCliente(ActionEvent e) {
		BajaClienteNew intermedioPantalla = new BajaClienteNew();
		intermedioPantalla.setSize(400,300);
		intermedioPantalla.setLocation(5,5);
		
		PantallaPrincipalNew.panelPrincipal.removeAll();
		PantallaPrincipalNew.panelPrincipal.add(intermedioPantalla, BorderLayout.CENTER);
		PantallaPrincipalNew.panelPrincipal.revalidate();
		PantallaPrincipalNew.panelPrincipal.repaint();	
	}
	
	protected void listaCliente(ActionEvent e) {
		ListaClientesNew intermedioPantalla = new ListaClientesNew();
		intermedioPantalla.setSize(400,300);
		intermedioPantalla.setLocation(5,5);
		
		PantallaPrincipalNew.panelPrincipal.removeAll();
		PantallaPrincipalNew.panelPrincipal.add(intermedioPantalla, BorderLayout.CENTER);
		PantallaPrincipalNew.panelPrincipal.revalidate();
		PantallaPrincipalNew.panelPrincipal.repaint();	
	}
	
	

}
