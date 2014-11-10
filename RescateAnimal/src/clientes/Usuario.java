package clientes;

import java.util.ArrayList;


import clientes.Persona;
import clientes.Mascota;

public class Usuario extends Persona {
	protected String username;
	protected ArrayList<Integer> reportes;
	protected float calificacion;
	protected ArrayList<Mascota> adopciones;

	public Usuario(String dNombre, String dPApellido, String dSApellido, String dTelefono, 
			String dCorreo, String dCedula, String dDireccion, String dUsername) {
		super(dNombre, dPApellido, dSApellido, dTelefono, dCorreo, dCedula, dDireccion);
		reportes = new ArrayList<>();
		adopciones = new ArrayList<>();
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<Integer> getReportes() {
		return reportes;
	}

	public void setReportes(ArrayList<Integer> reportes) {
		this.reportes = reportes;
	}

	public float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}

	public ArrayList<Mascota> getAdopciones() {
		return adopciones;
	}

	public void setAdopciones(ArrayList<Mascota> adopciones) {
		this.adopciones = adopciones;
	}
	
	public String verInfo() {
		return "Nombre: " + nombre + "\nApellidos: " + pApellido + " " + sApellido + "\nTeléfono: " + telefono +
				"\nCorreo: " + correo + "\nCédula: " + cedula + "\nDirección: " + direccion;
	}
	
	public Mascota reportarMascota(String nombre, String especie, String raza, String chip,
			String color, String foto, String ubicacion, String fecha, String estado,
			int recompensa, String notas) {
				return null;
		
	}

}
