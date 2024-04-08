package utils;

import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.Usuario;

public class Utilidades {
	
	public static List<Usuario> usuarios = new ArrayList<>();
	
	/**
	 * metodo que toma los datos de los campos y cre un objeto usuario
	 * 
	 * @param textNombre
	 * @param textMail
	 * @param rdbtSexo
	 * @param textNumero
	 * 
	 * @return devuelve un nuevo usuario
	 */
	public static void nuevoUsuario(JTextField textNombre, JTextField textMail, JRadioButton rdbtSexo, JTextField textNumero) {
		
		String nombreUsuario = textNombre.getText();
		String mailUsuario = textMail.getText();
		String genero = rdbtSexo.getText();
		int numero = Integer.parseInt(textNumero.getText());
		
		Usuario nuevoUsuario = new Usuario(nombreUsuario, mailUsuario, genero, numero);
		
		usuarios.add(nuevoUsuario);
		
		if (Utilidades.usuarios.contains(nuevoUsuario)) {
			JOptionPane.showMessageDialog(null,"Usuario correctamente añadido");
		} else {
			JOptionPane.showMessageDialog(null,"Error al crear el usuario");
		}
	}
	
	
	/**
	 * Devuelve el cliete que este en la posicion que el parametro
	 * @param  i numero en la lista
	 * @return cliente
	 */
	public static Usuario devuelve(int i) {
		return usuarios.get(i);
	}
	
	public static DefaultTableModel actualizaTabla() {
		DefaultTableModel  modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("edad");
		modelo.addColumn("id");
		modelo.addColumn("sexx");
		
		for (int i = 0; i < usuarios.size(); i++) {
			Usuario cliente = devuelve(i);
			modelo.addRow(new Object[] {cliente.getNombre(), cliente.getMail(), cliente.getSexo(), cliente.getNumero()});
		}
		return modelo;
	}
}
