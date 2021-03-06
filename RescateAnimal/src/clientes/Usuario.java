package clientes;

import java.util.ArrayList;
import clientes.Persona;
import clientes.Mascota;

public class Usuario extends Persona {
	protected String username;
	protected ArrayList<Mascota> reportes;
	protected float calificacion;
	protected ArrayList<Mascota> adopciones;

	public Usuario(String dNombre, String dPApellido, String dSApellido, String dTelefono, 
			String dCorreo, String dCedula, String dDireccion, String dUsername) {
		super(dNombre, dPApellido, dSApellido, dTelefono, dCorreo, dCedula, dDireccion);
		setUsername(dUsername);
		setCalificacion(0);
		reportes = new ArrayList<>();
		adopciones = new ArrayList<>();
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<Mascota> getReportes() {
		return reportes;
	}

	public void setReportes(ArrayList<Mascota> reportes) {
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
	
	public String toString() {
		return "Nombre: " + nombre + "\nApellidos: " + pApellido + " " + sApellido + "\nTeléfono: " + telefono +
				"\nCorreo: " + correo + "\nCédula: " + cedula + "\nDirección: " + direccion;
	}
	
	public Mascota reportarMascota(String nombre, String especie, String raza, String chip,
			String color, String foto, String ubicacion, String fecha, String estado,
			String recompensa, String notas) {
		Mascota mascotaReportada = new Mascota(nombre, especie, raza, chip, color, foto, ubicacion, fecha, estado, recompensa, notas);
		return mascotaReportada;
	}
	
	public void agregarReporte(Mascota nuevoReporte) {
		reportes.add(nuevoReporte);
	}
	
	public void agregarAdopcion(Mascota nuevaAdopcion) {
		adopciones.add(nuevaAdopcion);
	}

}
