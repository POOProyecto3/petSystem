package apoyoanimal;
import java.util.ArrayList;

public class Asociacion {
	private String nombre;
	private ArrayList<String> transacciones;
	private int fondos;

	public Asociacion(String aNombre, int aFondos) {
		setNombre(aNombre);
		setFondos(aFondos);
	}
	
	public Asociacion(String aNombre) {
		setNombre(aNombre);
	}
	
	public void agregarTransaccion(String movimiento) {
		transacciones.add(movimiento);
		/*
		int donativo = 0;
		if (donativo > 0 && movimiento != null) {
			fondos = fondos + donativo;
		}
		else {
			fondos = fondos + 0;
		}
		*/
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
