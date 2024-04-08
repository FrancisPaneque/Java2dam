package util;
import models.*;

import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Utils {
	
	public static List<Usuario> usuarios = new ArrayList<>();
	public static List<Cita> citas = new ArrayList<>();
	public static String usuarioActual; 
	
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
	public static void nuevoUsuario(JTextField textNombre, JTextField textApellidos, JTextField textTelefono, JTextField textMail, JPasswordField textContrania, JRadioButton rdbtContacto) {
		
		String nombreUsuario = textNombre.getText();
		String apellidos = textApellidos.getText();
		String telefono = textTelefono.getText();
		String mail = textMail.getText();
		String contrasenia = String.valueOf(textContrania.getPassword());
		String metodoContacto = rdbtContacto.getText();
		Usuario nuevoUsuario = new Usuario(nombreUsuario, apellidos, telefono, mail, contrasenia,
				metodoContacto);
		
		usuarios.add(nuevoUsuario);
		
		if (Utils.usuarios.contains(nuevoUsuario)) {
			JOptionPane.showMessageDialog(null,"Usuario correctamente añadido");
		} else {
			JOptionPane.showMessageDialog(null,"Error al crear el usuario");
		}
	}
	/**
	 * Metodo encargado de crear una cita y añadirla a la lista de citas
	 * @param texMatricula
	 * @param textMarca
	 * @param textModelo
	 * @param textFecha
	 */
	public static Cita nuevoCita(JTextField texMatricula, JTextField textMarca, JTextField textModelo, JDateChooser dateChooser) {
		String matricula = texMatricula.getText();
		String marca = textMarca.getText();
		String modelo = textModelo.getText();
		String fecha =  dateChooser.getDateFormatString();
		Cita nuevaCita = new Cita(matricula, marca, modelo, fecha);
		
		citas.add(nuevaCita);
		
		return nuevaCita;
	}
}