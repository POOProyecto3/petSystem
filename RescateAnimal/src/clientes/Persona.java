package clientes;

public class Persona {
	protected String nombre;
	protected String pApellido;
	protected String sApellido;
	protected String telefono;
	protected String correo;
	protected String cedula;
	protected String direccion;

	public Persona(String dNombre, String dPApellido, String dSApellido, String dTelefono, String dCorreo, String dCedula, String dDireccion) {
		setNombre(dNombre);
		setpApellido(dPApellido);
		setsApellido(dSApellido);
		setTelefono(dTelefono);
		setCorreo(dCorreo);
		setCedula(dCedula);
		setDireccion(dDireccion);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getpApellido() {
		return pApellido;
	}

	public void setpApellido(String pApellido) {
		this.pApellido = pApellido;
	}

	public String getsApellido() {
		return sApellido;
	}

	public void setsApellido(String sApellido) {
		this.sApellido = sApellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String toString() {
		String msg;
		
		msg = "Nombre completo: " + getNombre() + " " + getpApellido() + " " + getsApellido() + "\n";
		msg += "Teléfono: " + getTelefono() + "\n";
		msg += "Email: " + getCorreo() + "\n";
		msg += "Número de cédula: " + getCedula() + "\n";
		msg += "Dirección exacta: " + getDireccion() + "\n";
		
		return msg;
	}
	

}
