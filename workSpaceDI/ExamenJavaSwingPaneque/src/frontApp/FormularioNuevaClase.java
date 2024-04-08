package frontApp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import frontLogin.Login;
import models.Clase;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioNuevaClase extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textProfesor;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;

	/**
	 * Create the dialog.
	 */
	public FormularioNuevaClase(PantallaAdmin padre, boolean modal) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 436, 263);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelCabeceraRegistro = new JPanel();
			panelCabeceraRegistro.setBackground(new Color(0, 128, 255));
			contentPanel.add(panelCabeceraRegistro, BorderLayout.NORTH);
			panelCabeceraRegistro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel lblNuevaClase = new JLabel("Nueva Clase");
				lblNuevaClase.setForeground(Color.WHITE);
				lblNuevaClase.setFont(new Font("Tahoma", Font.BOLD, 14));
				panelCabeceraRegistro.add(lblNuevaClase);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				textNombre = new JTextField();
				textNombre.setBounds(194, 26, 96, 19);
				panel.add(textNombre);
				textNombre.setColumns(10);
			}
			{
				textProfesor = new JTextField();
				textProfesor.setBounds(194, 68, 96, 19);
				panel.add(textProfesor);
				textProfesor.setColumns(10);
			}
			{
				JLabel lblNombre = new JLabel("Nombre");
				lblNombre.setBounds(119, 29, 45, 13);
				panel.add(lblNombre);
			}
			{
				JLabel lblProfesor = new JLabel("Profesor");
				lblProfesor.setBounds(119, 71, 45, 13);
				panel.add(lblProfesor);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Turno");
				lblNewLabel_2.setBounds(119, 119, 45, 13);
				panel.add(lblNewLabel_2);
			}
			{
				JButton btnNewButton = new JButton("Enviar");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Clase nuevaClase = null;
						if (rdbtnNewRadioButton.isSelected()) {
							nuevaClase = utilidades.UtilidadesApp.creaClase(textNombre.getText(), textProfesor.getText(), rdbtnNewRadioButton.getText());
							utilidades.UtilidadesApp.añadeClase(nuevaClase);
						} else if (rdbtnNewRadioButton_1.isSelected()) {
							nuevaClase = utilidades.UtilidadesApp.creaClase(textNombre.getText(), textProfesor.getText(), rdbtnNewRadioButton_1.getText());
							utilidades.UtilidadesApp.añadeClase(nuevaClase);
						} else {
							JOptionPane.showMessageDialog(null,"Error al crear la clase");
						}
					}
				});
				btnNewButton.setBounds(157, 182, 85, 21);
				panel.add(btnNewButton);
			}
			
			rdbtnNewRadioButton = new JRadioButton("Mañana");
			buttonGroup.add(rdbtnNewRadioButton);
			rdbtnNewRadioButton.setBounds(194, 111, 103, 21);
			panel.add(rdbtnNewRadioButton);
			
			rdbtnNewRadioButton_1 = new JRadioButton("Tarde");
			buttonGroup.add(rdbtnNewRadioButton_1);
			rdbtnNewRadioButton_1.setBounds(194, 131, 103, 21);
			panel.add(rdbtnNewRadioButton_1);
		}
	}
}
