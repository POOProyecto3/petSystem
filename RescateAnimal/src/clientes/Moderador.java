package clientes;

import java.util.ArrayList;
import clientes.Mascota;

public class Moderador extends Usuario {
	private boolean master = false;

	public Moderador(String dNombre, String dPApellido, String dSApellido, String dTelefono, 
			String dCorreo, String dCedula, String dDireccion, String dUsername,
			ArrayList<Integer> dReportes, float dCalificacion, ArrayList<Mascota> dAdopciones,
			boolean isMaster) {
		super (dNombre, dPApellido, dSApellido, dTelefono, dCorreo, dCedula, dDireccion,
				dUsername, dReportes, dCalificacion, dAdopciones);
		setMaster(isMaster);
	}

	public boolean isMaster() {
		return master;
	}

	public void setMaster(boolean master) {
		this.master = master;
	}
	
	@SuppressWarnings("null")
	public static void crearUsuario() {
		int indice;
		String[] nombre = null;
		String cedula;
		String[] cedulas = null;
		String[] username = null;
		int numUsuarios = 0;
		
		System.out.print("Ingrese el número de cédula: ");
		cedula = System.in.toString();
		System.out.println();
		indice = buscarUsuario(cedula);
		if (indice == -1) {
			cedulas[numUsuarios] = cedula;
			System.out.print("Ingrese el nombre completo del nuevo usuario: ");
			nombre[numUsuarios] = System.in.toString();
			System.out.print("Ingrese el seudónimo del nuevo usuario: ");
			username[numUsuarios] = System.in.toString();
			System.out.println();
			numUsuarios++;
			System.out.println("Nuevo usuario registrado de manera exitosa.");
		}
		else {
			System.out.println("Error: Nombre de usuario ocupado.");
		}
	}
	
	@SuppressWarnings("null")
	public static int buscarUsuario(String cedula) {
		boolean encontrado = false;
		int i = 0;
		String[] cedulas = null;
		int indice = -1;
		while (!encontrado && i < cedulas.length && cedulas[i] != null) {
			if(cedulas[i].equals(cedula)) {
				indice = i;
				encontrado = true;
			}
			i++;
		}
		return indice;
	}
	
	public void agregarModerador(String nombre, String pApellido, String sApellido, String telefono, 
			String correo, String cedula, String direccion, String username, boolean isMaster) {
		
	}
	

}
