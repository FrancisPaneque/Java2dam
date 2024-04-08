package front;

import java.awt.EventQueue;
import com.toedter.calendar.JDateChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.Utils;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PerfilCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilCliente frame = new PerfilCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PerfilCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("resources/cocheAzul.png"));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Talleres Picasso");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_3, BorderLayout.CENTER);
		
		JLabel lblCita = new JLabel("");
		lblCita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pedirCitaPressed(e);
			}
		});
		lblCita.setIcon(new ImageIcon("resources/calendario.png"));
		
		JLabel lblReparacion = new JLabel("");
		lblReparacion.setIcon(new ImageIcon("resources/reparaciones.png"));
		
		JLabel lblPieCita = new JLabel("Pedir cita previa");
		
		JLabel lblPieReparacion = new JLabel("Ver más reparaciones");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(131)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCita, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPieCita))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblReparacion, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(10)
							.addComponent(lblPieReparacion, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))
					.addGap(116))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(68)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCita)
						.addComponent(lblReparacion))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPieCita)
						.addComponent(lblPieReparacion))
					.addContainerGap(265, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JLabel lblUsuario = new JLabel("     Bienvenido/a " + Utils.usuarioActual);
		lblUsuario.setForeground(new Color(0, 139, 139));
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblUsuario, BorderLayout.NORTH);
		
		JLabel lblNewLabel_4 = new JLabel("    ");
		panel_1.add(lblNewLabel_4, BorderLayout.WEST);
		
		JLabel lblNewLabel_5 = new JLabel("    ");
		panel_1.add(lblNewLabel_5, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblCerrarSesion = new JLabel("");
		lblCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cerrarSesionPressed(e);
			}
		});
		lblCerrarSesion.setIcon(new ImageIcon("resources/logout.png"));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(527, Short.MAX_VALUE)
					.addComponent(lblCerrarSesion, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblCerrarSesion))
		);
		panel_2.setLayout(gl_panel_2);
	}
	
	/**
	 * metodo que navega a la venta de Login
	 * 
	 * @param e
	 */
	protected void cerrarSesionPressed(MouseEvent e) {
        Login pantalla = new Login();
        pantalla.setLocationRelativeTo(null);
        pantalla.setResizable(false);
        pantalla.setVisible(true);
        setVisible(false);
    }
	
	/**
	 * al pulsarse despliega la venta para pedir cita
	 * @param e
	 */
	protected void pedirCitaPressed (MouseEvent e) {
        PedirCita registro = new PedirCita(this, true);
        registro.setVisible(true);
        registro.setResizable(false);
        
    }

}
