package apoyoanimal;

import java.util.ArrayList;

import clientes.Persona;
import clientes.Mascota;

public class CasaCuna {
	private Persona encargado;
	private ArrayList<String> tipos;
	private ArrayList<String> razas;
	
	private String periodosCuido;
	private int lapsoCuido;
	private boolean ayudaComida;
	
	private boolean ayudaRopas;
	private boolean ayudaEconomica;
	private String notas;
	
	private ArrayList<Mascota> mascotasEnCuido;
	
	public CasaCuna(Persona pEncargado) {
		setEncargado(pEncargado);
	}
	
	public boolean agregarMascota(Mascota mascota) {
		Mascota ccmascota = mascota;
		int situacion = 0;
		
		switch(situacion) {
			case 1:
				ayudaComida = true;
				break;
				
			case 2:
				ayudaRopas = true;
				break;
				
			case 3:
				ayudaEconomica = true;
				break;
				
			default:
				break;
		}
		return false;
		
	}

	public Persona getEncargado() {
		return encargado;
	}

	public void setEncargado(Persona encargado) {
		this.encargado = encargado;
	}

	public ArrayList<String> getTipos() {
		return tipos;
	}

	public void setTipos(ArrayList<String> tipos) {
		this.tipos = tipos;
	}

	public ArrayList<String> getRazas() {
		return razas;
	}

	public void setRazas(ArrayList<String> razas) {
		this.razas = razas;
	}

	public String getPeriodosCuido() {
		return periodosCuido;
	}

	public void setPeriodosCuido(String periodosCuido) {
		this.periodosCuido = periodosCuido;
	}

	public int getLapsoCuido() {
		return lapsoCuido;
	}

	public void setLapsoCuido(int lapsoCuido) {
		this.lapsoCuido = lapsoCuido;
	}

	public boolean isAyudaComida() {
		return ayudaComida;
	}

	public void setAyudaComida(boolean ayudaComida) {
		this.ayudaComida = ayudaComida;
	}

	public boolean isAyudaRopas() {
		return ayudaRopas;
	}

	public void setAyudaRopas(boolean ayudaRopas) {
		this.ayudaRopas = ayudaRopas;
	}

	public boolean isAyudaEconomica() {
		return ayudaEconomica;
	}

	public void setAyudaEconomica(boolean ayudaEconomica) {
		this.ayudaEconomica = ayudaEconomica;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public ArrayList<Mascota> getMascotasEnCuido() {
		return mascotasEnCuido;
	}

	public void setMascotasEnCuido(ArrayList<Mascota> mascotasEnCuido) {
		this.mascotasEnCuido = mascotasEnCuido;
	}
	

}
