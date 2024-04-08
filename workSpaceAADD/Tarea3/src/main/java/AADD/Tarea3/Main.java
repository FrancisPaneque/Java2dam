package AADD.Tarea3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.util.Util;

import Utilidades.Utilidades;

public class Main {

	private JFrame frame;
	private JTextField textId;
	private JTextField textTitulo;
	private JTextField textEstreno;
	private JTextField textDuracion;
	private JTextArea textAreaDescripcion;
	private JTextArea textAreaReparto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ResultSet rs = Utilidades.realizeSelect();
		Utilidades.añadePeliculasLista(rs);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 449, 387);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblTitle = new JLabel("Info.Peliculas");
		lblTitle.setBounds(10, 10, 177, 26);
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 59, 65, 19);
		lblId.setFont(new Font("Consolas", Font.BOLD, 15));
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(10, 88, 65, 19);
		lblTitulo.setFont(new Font("Consolas", Font.BOLD, 15));
		
		JLabel lblAñoEstreno = new JLabel("Año estreno:");
		lblAñoEstreno.setBounds(109, 59, 96, 19);
		lblAñoEstreno.setFont(new Font("Consolas", Font.BOLD, 15));
		
		JLabel lblDuracion = new JLabel("Duración:");
		lblDuracion.setBounds(291, 59, 77, 19);
		lblDuracion.setFont(new Font("Consolas", Font.BOLD, 15));
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(10, 117, 96, 19);
		lblDescripcion.setFont(new Font("Consolas", Font.BOLD, 15));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblId);
		frame.getContentPane().add(lblTitle);
		frame.getContentPane().add(lblDescripcion);
		frame.getContentPane().add(lblDuracion);
		frame.getContentPane().add(lblTitulo);
		frame.getContentPane().add(lblAñoEstreno);
		
		textId = new JTextField();
		textId.setFont(new Font("Consolas", Font.PLAIN, 12));
		textId.setBounds(41, 58, 58, 19);
		frame.getContentPane().add(textId);
		textId.setColumns(10);
		
		textTitulo = new JTextField();
		textTitulo.setFont(new Font("Consolas", Font.PLAIN, 12));
		textTitulo.setColumns(10);
		textTitulo.setBounds(71, 89, 354, 19);
		frame.getContentPane().add(textTitulo);
		
		textEstreno = new JTextField();
		textEstreno.setFont(new Font("Consolas", Font.PLAIN, 12));
		textEstreno.setColumns(10);
		textEstreno.setBounds(215, 60, 66, 19);
		frame.getContentPane().add(textEstreno);
		
		textDuracion = new JTextField();
		textDuracion.setFont(new Font("Consolas", Font.PLAIN, 12));
		textDuracion.setColumns(10);
		textDuracion.setBounds(367, 60, 58, 19);
		frame.getContentPane().add(textDuracion);
		
		JLabel lblReparto = new JLabel("Reparto:");
		lblReparto.setFont(new Font("Consolas", Font.BOLD, 15));
		lblReparto.setBounds(10, 203, 65, 19);
		frame.getContentPane().add(lblReparto);
		
		JScrollPane scrollPaneDescripcion = new JScrollPane();
		scrollPaneDescripcion.setBounds(10, 141, 415, 52);
		frame.getContentPane().add(scrollPaneDescripcion);
		
		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setEnabled(false);
		textAreaDescripcion.setWrapStyleWord(true);
		textAreaDescripcion.setLineWrap(true);
		scrollPaneDescripcion.setViewportView(textAreaDescripcion);
		
		JScrollPane scrollPanReparto = new JScrollPane();
		scrollPanReparto.setBounds(10, 222, 415, 52);
		frame.getContentPane().add(scrollPanReparto);
		
		textAreaReparto = new JTextArea();
		textAreaReparto.setWrapStyleWord(true);
		textAreaReparto.setLineWrap(true);
		textAreaReparto.setEditable(true);
		textAreaReparto.setEnabled(false);
		scrollPanReparto.setViewportView(textAreaReparto);
		
		JButton btnPrimera = new JButton("Primera");
		btnPrimera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UtilidadesMain.primeraPelicula(textId, textTitulo, textEstreno, textDuracion, textAreaDescripcion);
			}
		});
		btnPrimera.setBounds(10, 284, 85, 21);
		frame.getContentPane().add(btnPrimera);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UtilidadesMain.anteriorPelicula(textId, textTitulo, textEstreno, textDuracion, textAreaDescripcion);
			}
		});
		btnAnterior.setBounds(120, 284, 85, 21);
		frame.getContentPane().add(btnAnterior);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UtilidadesMain.siguientePelicula(textId, textTitulo, textEstreno, textDuracion, textAreaDescripcion);
			}
		});
		btnSiguiente.setBounds(231, 284, 85, 21);
		frame.getContentPane().add(btnSiguiente);
		
		JButton btnUltima = new JButton("Ultima");
		btnUltima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UtilidadesMain.ultimaPelicula(textId, textTitulo, textEstreno, textDuracion, textAreaDescripcion);
			}
		});
		btnUltima.setBounds(340, 284, 85, 21);
		frame.getContentPane().add(btnUltima);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utilidades.insertarFilm(textId, textEstreno, textDuracion, textTitulo, textAreaDescripcion);
			}
		});
		btnGuardar.setBounds(231, 319, 85, 21);
		frame.getContentPane().add(btnGuardar);
		
		JButton btnNuevo = new JButton("Nueva");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UtilidadesMain.camposVacios(textId, textTitulo, textEstreno, textDuracion, textAreaDescripcion);
			}
		});
		btnNuevo.setBounds(120, 319, 85, 21);
		frame.getContentPane().add(btnNuevo);
	}
}