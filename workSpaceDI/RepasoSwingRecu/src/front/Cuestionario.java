package front;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import utils.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import models.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cuestionario extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textMail;
	private JTextField textNumero;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Create the dialog.
	 */
	public Cuestionario (Principal padre, boolean modal){
		setBounds(100, 100, 297, 410);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(128, 128, 255));
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JLabel lblNewLabel = new JLabel(" ");
				panel.add(lblNewLabel, BorderLayout.NORTH);
			}
			{
				JLabel lblNewLabel_1 = new JLabel(" ");
				panel.add(lblNewLabel_1, BorderLayout.SOUTH);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("                   ");
				panel.add(lblNewLabel_2, BorderLayout.WEST);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("                   ");
				panel.add(lblNewLabel_3, BorderLayout.EAST);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("         Cuestionario");
				lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
				panel.add(lblNewLabel_4, BorderLayout.CENTER);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(128, 255, 255));
			contentPanel.add(panel, BorderLayout.CENTER);
			
			JLabel lblNombre = new JLabel("Nombre: ");
			
			JLabel lblMail = new JLabel("Mail: ");
			
			JLabel lblSexo = new JLabel("Sexo: ");
			
			JLabel lblNewLabel_8 = new JLabel("Numero: ");
			
			textNombre = new JTextField();
			textNombre.setColumns(10);
			
			textMail = new JTextField();
			textMail.setColumns(10);
			
			textNumero = new JTextField();
			textNumero.setColumns(10);
			
			JRadioButton rdbtnHombre = new JRadioButton("Hombre");
			buttonGroup.add(rdbtnHombre);
			rdbtnHombre.setSelected(true);
			
			JRadioButton rdbtnMujer = new JRadioButton("Mujer");
			buttonGroup.add(rdbtnMujer);
			
			JButton btnNuevoUsuario = new JButton("Enviar");
			btnNuevoUsuario.addActionListener(new ActionListener() {
				//Logica registro de usuario
				public void actionPerformed(ActionEvent e) {
					if (rdbtnHombre.isSelected()) {
						Utilidades.nuevoUsuario(textNombre,textMail,rdbtnHombre,textNumero);
						JOptionPane.showMessageDialog(null,"Usuario correctamente creado");
						
					} else if (rdbtnMujer.isSelected()){
						Utilidades.nuevoUsuario(textNombre,textMail,rdbtnMujer,textNumero);
						JOptionPane.showMessageDialog(null,"Usuario correctamente creado");
						
					} else {
						System.out.println("Error");
					}
					
				}
			});
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblMail, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblSexo, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(rdbtnHombre)
								.addGap(18)
								.addComponent(rdbtnMujer))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(88, Short.MAX_VALUE))
					.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
						.addContainerGap(108, Short.MAX_VALUE)
						.addComponent(btnNuevoUsuario)
						.addGap(104))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(25)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNombre)
							.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(39)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblMail)
							.addComponent(textMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(50)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblSexo)
							.addComponent(rdbtnHombre)
							.addComponent(rdbtnMujer))
						.addGap(47)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_8)
							.addComponent(textNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addComponent(btnNuevoUsuario)
						.addContainerGap(41, Short.MAX_VALUE))
			);
			panel.setLayout(gl_panel);
		}
	}
}
