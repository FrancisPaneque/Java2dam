/**
 * La clase GestionMesas representa la interfaz de usuario para la gestión de mesas en un restaurante.
 */
package front;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GestionMesas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JLabel lblMesa1txt;
    public JLabel lblMesa2txt;
    public JLabel lblMesa3txt;
    public static String numeroMesa;

    /**
     * Crea la interfaz de usuario para la gestión de mesas.
     */
    public GestionMesas () {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 991, 601);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        // Panel de cabecera
        JPanel panelCabecera = new JPanel();
        panelCabecera.setBackground(new Color(240, 230, 140));
        contentPane.add(panelCabecera, BorderLayout.NORTH);
        panelCabecera.setLayout(new BorderLayout(0, 0));
        
        // Panel del logo
        JPanel panelLogo = new JPanel();
        panelLogo.setBackground(new Color(240, 230, 140));
        panelCabecera.add(panelLogo, BorderLayout.WEST);
        panelLogo.setLayout(new BorderLayout(0, 0));
        
        JLabel lblLogo = new JLabel("                        ");
        panelLogo.add(lblLogo, BorderLayout.WEST);
        
        JLabel lblEspacioIzqLogo = new JLabel("                                    ");
        lblEspacioIzqLogo.setIcon(new ImageIcon("resources/logoRest.png"));
        panelLogo.add(lblEspacioIzqLogo, BorderLayout.CENTER);
        
        // Panel del título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(240, 230, 140));
        panelCabecera.add(panelTitulo, BorderLayout.EAST);
        panelTitulo.setLayout(new BorderLayout(0, 0));
        
        JLabel lblCerrarSesion = new JLabel("             ");
        lblCerrarSesion.setBackground(new Color(240, 230, 140));
        lblCerrarSesion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cerrarSesionPressed(e);
            }
        });
        lblCerrarSesion.setIcon(new ImageIcon("resources/logout.png"));
        panelTitulo.add(lblCerrarSesion);
        
        JLabel lblNewLabel_1 = new JLabel("Burger Swing");
        lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
        panelCabecera.add(lblNewLabel_1, BorderLayout.CENTER);
        
        // Panel central
        JPanel panelCentral = new JPanel();
        panelCentral.setBackground(new Color(238, 232, 170));
        contentPane.add(panelCentral, BorderLayout.CENTER);
        
        JLabel lblMesa1 = new JLabel("");
        lblMesa1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	numeroMesa = "Mesa 1";
                comadaPressed(e);
            }
        });
        lblMesa1.setIcon(new ImageIcon("resources/mesa.png"));
        
        JLabel lblMesa2 = new JLabel("");
        lblMesa2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	numeroMesa = "Mesa 2";
            	comadaPressed(e);
            }
        });
        lblMesa2.setIcon(new ImageIcon("resources/mesa.png"));
        
        JLabel lblMesa3 = new JLabel("");
        lblMesa3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	numeroMesa = "Mesa 3";
            	comadaPressed(e);
            	
            }
        });
        lblMesa3.setIcon(new ImageIcon("resources/mesa.png"));
        
        JLabel lblModcarta = new JLabel("");
        lblModcarta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	AñadirCarta(e);
            }
        });
        lblModcarta.setIcon(new ImageIcon("resources/AddComida.png"));
        
        lblMesa1txt = new JLabel("Mesa1");
        
        lblMesa2txt = new JLabel("Mesa2");
        
        lblMesa3txt = new JLabel("Mesa3");
        
        JLabel lblModCartaTxt = new JLabel("Modificar la carta");
        GroupLayout gl_panelCentral = new GroupLayout(panelCentral);
        gl_panelCentral.setHorizontalGroup(
            gl_panelCentral.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panelCentral.createSequentialGroup()
                    .addGap(213)
                    .addGroup(gl_panelCentral.createParallelGroup(Alignment.TRAILING)
                        .addComponent(lblMesa2txt, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMesa1txt, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
                            .addComponent(lblMesa1)
                            .addComponent(lblMesa3, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                    .addGroup(gl_panelCentral.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panelCentral.createParallelGroup(Alignment.TRAILING, false)
                            .addComponent(lblModcarta, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(lblMesa2, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(lblMesa3txt, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblModCartaTxt))
                    .addGap(222))
        );
        gl_panelCentral.setVerticalGroup(
            gl_panelCentral.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panelCentral.createSequentialGroup()
                    .addGap(96)
                    .addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblMesa2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMesa1))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblMesa1txt)
                        .addComponent(lblMesa3txt))
                    .addGap(27)
                    .addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblMesa3, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblModcarta, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblMesa2txt)
                        .addComponent(lblModCartaTxt))
                    .addContainerGap(127, Short.MAX_VALUE))
        );
        panelCentral.setLayout(gl_panelCentral);
        
        // Panel del pie
        JPanel panelPie = new JPanel();
        panelPie.setBackground(new Color(240, 230, 140));
        contentPane.add(panelPie, BorderLayout.SOUTH);
        
        JLabel lblNewLabel = new JLabel("Camino de los Castillejos 8, 29010, Málaga");
        lblNewLabel.setIcon(new ImageIcon("resources/location.png"));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        panelPie.add(lblNewLabel);
    }
    
    /**
     * Método invocado cuando se presiona el botón de cerrar sesión.
     * @param e El evento del ratón.
     */
    protected void cerrarSesionPressed(MouseEvent e) {
        Login pantalla = new Login();
        pantalla.setLocationRelativeTo(null);
        pantalla.setResizable(false);
        pantalla.setVisible(true);
        setVisible(false);
    }
    
    protected void AñadirCarta(MouseEvent e) {
        AddCarta registro = new AddCarta(this, true);
        registro.setVisible(true);
        
    }
    
    protected void comadaPressed (MouseEvent e) {
        Comanda registro = new Comanda(this, true);
        registro.setVisible(true);
        
    }
    
    
}

