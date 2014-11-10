package interfaz;

import javax.swing.*;
import principal.*;
import clientes.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaPrincipal extends JFrame{
	ProgramaPrincipal controlador = new ProgramaPrincipal();
	JPanel contenedor = new JPanel();
	GridBagConstraints constraint = new GridBagConstraints();
	
	//Widgets usados para el inicio de la ventana y LogIn
	ImageIcon logoi = new ImageIcon(this.getClass().getResource("/recursos/logo.jpg"));
	JLabel logo = new JLabel(logoi);
	TextField usuarioIn = new TextField("Usuario");
	TextField claveIn = new TextField("Contraseña");
	JButton logIn = new JButton("Iniciar sesión");
	JButton registrar = new JButton("Registrar");
	
	public VentanaPrincipal() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,400);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Rescate Animal");
		meterWidgets();
		getContentPane().add(contenedor);
		
		setVisible(true);
	}
	
	public void meterWidgets(){
		contenedor.setLayout(new GridBagLayout());
		constraint.gridwidth=2;
		constraint.gridx=0;
		constraint.gridy=0;
		contenedor.add(logo,constraint);
		
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx=0;
		constraint.gridy=1;
		contenedor.add(usuarioIn,constraint);
		constraint.gridx=0;
		constraint.gridy=2;
		contenedor.add(claveIn,constraint);
		
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridwidth=1;
		constraint.weightx=0.5;
		constraint.gridx=0;
		constraint.gridy=3;
		contenedor.add(logIn,constraint);
		constraint.weightx=0.5;
		constraint.gridx=1;
		constraint.gridy=3;
		contenedor.add(registrar,constraint);
		contenedor.repaint();
		
		logIn.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent arg0){
				String usuario = usuarioIn.getText();
				String clave = claveIn.getText();
				if(controlador.verificarLogIn(usuario, clave)){
					dispose();
				}else{
					mostrarErrorLogIn();
				}
			}
		});
		
		registrar.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent arg0){
				dispose();
				new VentanaRegistro();
			}
		});
		
		usuarioIn.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent arg0){
				usuarioIn.setText("");
			}
		});
		
		claveIn.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent arg0){
				claveIn.setText("");
			}
		});
		
	}
	
	public void mostrarErrorLogIn(){
		JOptionPane.showMessageDialog(this,"Error en LogIn!");
	}
	
}
