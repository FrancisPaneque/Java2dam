package util;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import front.*;
import java.awt.event.ActionEvent;
import java.util.*;

import models.*;

public class UtilidadesLogin {
	
	public static List<Usuario> usuarios = new ArrayList<>();
	
	public static List<Comida> comidas = new ArrayList<>();
	
	public static List<Bebida> bebidas = new ArrayList<>();
	
	public static Comida devuelve(int i) {
		return comidas.get(i);
	}
	
	public static DefaultTableModel actualizaTablaComida() {
		DefaultTableModel  modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("precio");
		modelo.addColumn("ingredientes");
		
		for (int i = 0; i < comidas.size(); i++) {
			Comida comidas = devuelve(i);
			modelo.addRow(new Object[] {comidas.getNombreComida(), comidas.getPrecio(), comidas.getIngredientes()});
		}
		return modelo;
	}
	
	public static Bebida devuelveBebida(int i) {
		return bebidas.get(i);
	}
	
	public static DefaultTableModel actualizaTablaBebida() {
		DefaultTableModel  modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("precio");
		
		for (int i = 0; i < bebidas.size(); i++) {
			Comida comidas = devuelve(i);
			modelo.addRow(new Object[] {comidas.getNombreComida(), comidas.getPrecio()});
		}
		return modelo;
	}
	
}
