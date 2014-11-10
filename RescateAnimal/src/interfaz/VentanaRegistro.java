package interfaz;

import javax.swing.*;
import clientes.*;
import principal.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class VentanaRegistro extends JFrame{
	ProgramaPrincipal controlador = new ProgramaPrincipal();
	JPanel contenedor = new JPanel();
	GridBagConstraints constraint = new GridBagConstraints();
	
	JLabel lNombre = new JLabel("Nombre:");
	JLabel lPApellido = new JLabel("Primer Apellido:");
	JLabel lSApellido = new JLabel("Segundo Apellido:");
	JLabel lTelefono = new JLabel("Teléfono:");
	JLabel lCorreo = new JLabel("Correo:");
	JLabel lCedula = new JLabel("Cédula:");
	JLabel lDireccion = new JLabel("Dirección:");
	JLabel lUsuario = new JLabel("Usuario:");
	JLabel lClave = new JLabel("contraseña:");
	TextField nombreIn = new TextField();
	TextField pApellidoIn = new TextField();
	TextField sApellidoIn = new TextField();
	TextField telefonoIn = new TextField();
	TextField correoIn = new TextField();
	TextField cedulaIn = new TextField();
	TextField direccionIn = new TextField();
	TextField usuarioRegistroIn = new TextField();
	TextField claveRegistroIn = new TextField();
	JButton terminarRegistro = new JButton("Registrar");
	JButton cancelarRegistro = new JButton("Cancelar");
	
	public VentanaRegistro(){
		setSize(300,405);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Registro");
		meterWidgets();
		getContentPane().add(contenedor);
		setVisible(true);
	}
	
	public void meterWidgets(){
		contenedor.setLayout(new GridBagLayout());
		constraint.gridwidth=2;
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx=0;
		
		constraint.gridy=0;
		contenedor.add(lNombre ,constraint);
		constraint.gridy=1;
		contenedor.add(nombreIn  ,constraint);
		constraint.gridy=2;
		contenedor.add(lPApellido ,constraint);
		constraint.gridy=3;
		contenedor.add(pApellidoIn ,constraint);
		constraint.gridy=4;
		contenedor.add(lSApellido ,constraint);
		constraint.gridy=5;
		contenedor.add(sApellidoIn ,constraint);
		constraint.gridy=6;
		contenedor.add(lTelefono ,constraint);
		constraint.gridy=7;
		contenedor.add(telefonoIn ,constraint);
		constraint.gridy=8;
		contenedor.add(lCorreo ,constraint);
		constraint.gridy=9;
		contenedor.add(correoIn ,constraint);
		constraint.gridy=10;
		contenedor.add(lCedula ,constraint);
		constraint.gridy=11;
		contenedor.add(cedulaIn ,constraint);
		constraint.gridy=12;
		contenedor.add(lDireccion ,constraint);
		constraint.gridy=13;
		contenedor.add(direccionIn ,constraint);
		constraint.gridy=14;
		contenedor.add(lUsuario ,constraint);
		constraint.gridy=15;
		contenedor.add(usuarioRegistroIn ,constraint);
		constraint.gridy=16;
		contenedor.add(lClave ,constraint);
		constraint.gridy=17;
		contenedor.add(claveRegistroIn ,constraint);
		constraint.gridy=18;
		
		constraint.gridwidth=1;
		constraint.weightx=0.5;
		constraint.gridy=19;
		contenedor.add(terminarRegistro ,constraint);
		constraint.gridx=1;
		contenedor.add(cancelarRegistro ,constraint);
		
		terminarRegistro.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent arg0){
				String nombre = nombreIn.getText();
				String pApellido = pApellidoIn.getText();
				String sApellido = sApellidoIn.getText();
				String telefono = telefonoIn.getText();
				String correo = correoIn.getText();
				String cedula = cedulaIn.getText();
				String direccion = direccionIn.getText();
				String usuario = usuarioRegistroIn.getText();
				String clave = claveRegistroIn.getText();
				Usuario nuevoUsuario = new Usuario(nombre,pApellido,sApellido,telefono,correo,cedula,direccion,usuario);
				controlador.registrarUsuario(nuevoUsuario, clave);
			}
		});
		
		cancelarRegistro.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent arg0){
				dispose();
			}
		});
	}
}
