package front;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import models.Cita;
import util.Utils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PedirCita extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textMatricula;
	private JTextField textMarca;
	private JTextField textModelo;
	private JLabel lblModelo;
	private JDateChooser dateChooser;

	/**
	 * Create the dialog.
	 */
	public PedirCita(PerfilCliente padre, boolean modal) {
		setBounds(100, 100, 756, 472);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 0, 128));
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel lblTitulo = new JLabel("Pedir Cita Previa");
				lblTitulo.setForeground(new Color(255, 255, 255));
				lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
				panel.add(lblTitulo);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(64, 224, 208));
			contentPanel.add(panel, BorderLayout.SOUTH);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton btnAcpetar = new JButton("Aceptar");
				btnAcpetar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Cita nuevaCita = Utils.nuevoCita(textMatricula, textMarca, textModelo, dateChooser);
						if (Utils.citas.contains(nuevaCita)) {
							JOptionPane.showMessageDialog(null,"Cita correctamente añadido");
							salidaPressed(e);
						} else {
							JOptionPane.showMessageDialog(null,"Error al crear la cita");
						}
						
					}
				});
				panel.add(btnAcpetar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						salidaPressed(e);
					}
				});
				panel.add(btnCancelar);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(64, 224, 208));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					textMatricula = new JTextField();
					textMatricula.setBounds(347, 25, 319, 41);
					panel_1.add(textMatricula);
					textMatricula.setColumns(10);
				}
				{
					textMarca = new JTextField();
					textMarca.setBounds(347, 76, 319, 41);
					panel_1.add(textMarca);
					textMarca.setColumns(10);
				}
				{
					textModelo = new JTextField();
					textModelo.setBounds(347, 134, 319, 41);
					panel_1.add(textModelo);
					textModelo.setColumns(10);
				}
				{
					JLabel lblMatricula = new JLabel("Matrícula");
					lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblMatricula.setBounds(106, 39, 72, 13);
					panel_1.add(lblMatricula);
				}
				{
					JLabel lblMarca = new JLabel("Marca");
					lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblMarca.setBounds(106, 90, 72, 13);
					panel_1.add(lblMarca);
				}
				{
					lblModelo = new JLabel("Modelo");
					lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblModelo.setBounds(106, 148, 72, 13);
					panel_1.add(lblModelo);
				}
				
				JLabel lblFecha = new JLabel("Fecha");
				lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblFecha.setBounds(106, 200, 45, 13);
				panel_1.add(lblFecha);
				
				dateChooser = new JDateChooser();
				dateChooser.setBounds(347, 200, 319, 41);
				panel_1.add(dateChooser);
			}
			{
				JLabel lblNewLabel_1 = new JLabel(" ");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				panel.add(lblNewLabel_1, BorderLayout.NORTH);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("       ");
				panel.add(lblNewLabel_2, BorderLayout.EAST);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("       ");
				panel.add(lblNewLabel_3, BorderLayout.WEST);
			}
		}
	}
	
	/**
	 * Metodo que cierra la venta en la que este
	 * @param e
	 */
	protected void salidaPressed(ActionEvent e) {
	    // Cierra el JDialog
	    this.dispose();
	}
}
