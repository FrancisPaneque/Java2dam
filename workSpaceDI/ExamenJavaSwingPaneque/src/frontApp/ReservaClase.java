package frontApp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Clase;
import models.Usuario;
import utilidades.UtilidadesApp;
import utilidades.UtilidadesLogin;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ReservaClase extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static String[] arrayClases;
	public static List<String> nomreClases = new ArrayList<>();

	/**
	 * Create the dialog.
	 * @param b 
	 * @param pantallaClient 
	 */
	public ReservaClase(PantallaClient pantallaClient, boolean b) {
		setBounds(100, 100, 411, 294);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelCabeceraRegistro = new JPanel();
			panelCabeceraRegistro.setBackground(new Color(0, 128, 255));
			contentPanel.add(panelCabeceraRegistro, BorderLayout.NORTH);
			panelCabeceraRegistro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel lblReservarClase = new JLabel("Reservar Clase");
				lblReservarClase.setForeground(Color.WHITE);
				lblReservarClase.setFont(new Font("Tahoma", Font.BOLD, 14));
				panelCabeceraRegistro.add(lblReservarClase);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			contentPanel.add(panel, BorderLayout.CENTER);
			{
				JLabel lblClase = new JLabel("Clase");
				lblClase.setBounds(119, 29, 45, 13);
				panel.add(lblClase);
			}
			{
				JLabel lblTurno = new JLabel("Turno");
				lblTurno.setBounds(119, 71, 45, 13);
				panel.add(lblTurno);
			}
			{
				JButton btnReservar = new JButton("Reservar");
				btnReservar.setBounds(157, 154, 85, 21);
				panel.add(btnReservar);
			}
			
			añadeALista();
			arrayClases = nomreClases.toArray(new String[0]);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(arrayClases));
			comboBox.setBounds(174, 29, 107, 21);
			panel.add(comboBox);
			
			JComboBox comboBox_1 = new JComboBox();
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Mañana", "Tarde"}));
			comboBox_1.setBounds(174, 67, 107, 21);
			panel.add(comboBox_1);
		}
	}
	
	// Método que convierte una lista en un array
    public static void añadeALista() {
        for (Clase clase : utilidades.UtilidadesApp.listaDeClases) {
			nomreClases.add(clase.getNombre());
		}
    }
}
