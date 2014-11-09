package clientes;


public class Moderador extends Usuario {
	private boolean master = false;

	public Moderador(String dNombre, String dPApellido, String dSApellido, String dTelefono, 
			String dCorreo, String dCedula, String dDireccion, String dUsername,boolean isMaster) {
		super (dNombre, dPApellido, dSApellido, dTelefono, dCorreo, dCedula, dDireccion,
				dUsername);
		setMaster(isMaster);
	}

	public boolean isMaster() {
		return master;
	}

	public void setMaster(boolean master) {
		this.master = master;
	}
	
	public Usuario crearUsuario(String nombre, String pApellido, String sApellido, String telefono, 
			String correo, String cedula, String direccion, String username) {
		return new Usuario(nombre, pApellido, sApellido, telefono, correo, cedula, direccion, username);
	}
	

	public Moderador agregarModerador(String nombre, String pApellido, String sApellido, String telefono, 
			String correo, String cedula, String direccion, String username, boolean isMaster) {
		return new Moderador(nombre, pApellido, sApellido, telefono, correo, cedula, direccion, username, isMaster);
		
	}
	
	public String verInfo() {
		return super.verInfo()+"\nAdmninistrador\nPuede modificar valores? "+isMaster();
	}
	

}
