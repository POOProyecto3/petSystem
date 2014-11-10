package interfaz;

import javax.swing.*;

import principal.*;
import clientes.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaOpciones extends JFrame{
	ProgramaPrincipal controlador = new ProgramaPrincipal();
	JPanel contenedor = new JPanel();
	GridBagConstraints constraint = new GridBagConstraints();
	
	ImageIcon logoi = new ImageIcon(this.getClass().getResource("/recursos/logo600.jpg"));
	JLabel logo = new JLabel(logoi);
	ImageIcon iConsultas = new ImageIcon(this.getClass().getResource("/recursos/consultas.jpg"));
	JLabel consultas = new JLabel(iConsultas);
	ImageIcon iEditar = new ImageIcon(this.getClass().getResource("/recursos/consultas.jpg"));
	JLabel editar = new JLabel(iEditar);
	ImageIcon iAdopcion = new ImageIcon(this.getClass().getResource("/recursos/consultas.jpg"));
	JLabel adopcion = new JLabel(iAdopcion);
	ImageIcon iAsociacion = new ImageIcon(this.getClass().getResource("/recursos/consultas.jpg"));
	JLabel asociacion = new JLabel(iAsociacion);
	ImageIcon iCasaCuna = new ImageIcon(this.getClass().getResource("/recursos/consultas.jpg"));
	JLabel casaCuna = new JLabel(iCasaCuna);
	ImageIcon iMascota = new ImageIcon(this.getClass().getResource("/recursos/consultas.jpg"));
	JLabel mascota = new JLabel(iMascota);
	
	public VentanaOpciones(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,1230);
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
		constraint.gridwidth=1;
		constraint.gridx=0;
		constraint.gridy=1;
		contenedor.add(mascota, constraint);
		constraint.gridx=1;
		contenedor.add(consultas, constraint);
		constraint.gridx=0;
		constraint.gridy=2;
		contenedor.add(adopcion, constraint);
		constraint.gridx=1;
		contenedor.add(editar, constraint);
		constraint.gridx=0;
		constraint.gridy=3;
		contenedor.add(asociacion, constraint);
		constraint.gridx=1;
		contenedor.add(casaCuna, constraint);
	}
}
