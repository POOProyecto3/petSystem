package apoyoanimal;
import java.util.ArrayList;

public class Asociacion {
	private String nombre;
	private ArrayList<String> transacciones;
	private int fondos;

	public Asociacion(String aNombre, int aFondos) {
		setNombre(aNombre);
		setFondos(aFondos);
		transacciones = new ArrayList<>();
	}
	
	public Asociacion(String aNombre) {
		setNombre(aNombre);
	}
	
	public boolean agregarTransaccion(String persona, int donativo) {
		if (donativo > 0) {
			fondos += donativo;
			transacciones.add(persona + " dona: " + donativo);
			return true;
		}
		else {
			return false;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(ArrayList<String> transacciones) {
		this.transacciones = transacciones;
	}

	public int getFondos() {
		return fondos;
	}

	public void setFondos(int fondos) {
		this.fondos = fondos;
	}

}
