package clientes;

public class Mascota {
	private String nombre;
	private String especie;
	private String raza;
	private String chip;
	
	private String color;
	private String foto;
	private String ubicacion;
	private String fecha;
	
	private String estado;
	private String recompensa;
	private String notas;

	public Mascota(String mNombre, String mEspecie, String mRaza, String mChip, String mColor,
			String mFoto, String mUbicacion, String mFecha, String mEstado, String mRecompensa,
			String mNotas) {
		setNombre(mNombre);
		setEspecie(mEspecie);
		setRaza(mRaza);
		setChip(mChip);
		
		setColor(mColor);
		setFoto(mFoto);
		setUbicacion(mUbicacion);
		setFecha(mFecha);
		
		setEstado(mEstado);
		setRecompensa(mRecompensa);
		setNotas(mNotas);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRecompensa() {
		return recompensa;
	}

	public void setRecompensa(String recompensa) {
		this.recompensa = recompensa;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}
	
	public String toString() {
		return "Nombre: " + nombre + "\nEspecie: " + especie + "\nRaza: "
				+ raza + "\nChip; " + chip + "\nColor: " + color + "\nFoto: "
				+ foto + "\nUbicacion: " + ubicacion + "\nFecha: " + fecha
				+ "\nEstado: " + estado + "\nRecompensa: " + recompensa
				+ "\nNotas: " + notas;
	}
		
}
