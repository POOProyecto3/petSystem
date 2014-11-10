package sistema;

import java.util.ArrayList;

import apoyoanimal.Asociacion;
import apoyoanimal.CasaCuna;
import clientes.Mascota;
import clientes.Usuario;

public class Registro {
	private ArrayList<Usuario> personas;
	private ArrayList<Mascota> reportes;
	private ArrayList<CasaCuna> casasCuna;
	private ArrayList<Asociacion> asociaciones;
	private ArrayList<Usuario> listaNegra;
	private ArrayList<String> listaRazas;
	private ArrayList<String> listaTipos;
	private ArrayList<String> listaColores;
	
	Registro() {
		personas = new ArrayList<>();
		reportes = new ArrayList<>();
		casasCuna = new ArrayList<>();
		asociaciones = new ArrayList<>();
		listaNegra = new ArrayList<>();
		listaRazas = new ArrayList<>();
		listaTipos = new ArrayList<>();
		listaColores = new ArrayList<>();
	}
	
	
	private boolean verificarAdd(ArrayList lista, Object elemento) {
		if (lista.get(lista.size() - 1) == elemento) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean agregarUsuario(Usuario nUsuario) {
		personas.add(nUsuario);
		return verificarAdd(personas, nUsuario);
	}
	
	public boolean agregarReporte(Mascota nReporte) {
		reportes.add(nReporte);
		return verificarAdd(reportes, nReporte);
	}
	
	public boolean agregarCasaCuna(CasaCuna nCasa) {
		casasCuna.add(nCasa);
		return verificarAdd(casasCuna, nCasa);
	}
	
	public boolean agregarAsociacion(Asociacion nAsocia) {
		asociaciones.add(nAsocia);
		return verificarAdd(casasCuna, nAsocia);
	}
	
	public boolean notificarPorCorreo() {
		//Proximamente...
		return true;
		
	}
	
	public ArrayList<Mascota> buscarCoincidencias(Mascota reporte) {
		ArrayList<Mascota> resultados = new ArrayList<Mascota>(); 
		Mascota temp;
		int coincidencias;
		
		for (int i = 0; i < reportes.size(); i++) {
			coincidencias = 0;
			temp = reportes.get(i);
			
			//Se buscan caracteristicas similares y se suma 1 a las coincidencias
			if (temp.getNombre() == reporte.getNombre()) {
				coincidencias += 1;
			}
			
			if (temp.getEspecie() == reporte.getEspecie()) {
				coincidencias += 1;
			}
			
			if (temp.getRaza() == reporte.getRaza()) { 
				coincidencias += 1;
			}
			
			if (temp.getChip() == reporte.getChip()) { 
				coincidencias += 1;
			}
			
			if (temp.getColor() == reporte.getColor()) { 
				coincidencias += 1;
			}
			
			if (temp.getUbicacion() == reporte.getUbicacion()) { 
				coincidencias += 1;
			}
			
			if (temp.getFecha() == reporte.getFecha()) { 
				coincidencias += 1;
			}
			
			if (coincidencias <= 4) {
				resultados.add(temp);
			}
		}
		
		return resultados;
		
	}

	public boolean publicarEnFacebook(Mascota mascota) {
		//Proximamente...
		return true; 
	}
	
	public boolean editarDatosUser(Usuario user) {
		//Proximamente...
		return true;
	}
	
	public boolean efectuarDonaciones(int cantidad, int ubicacionAsocia, Usuario user) {
		return asociaciones.get(ubicacionAsocia).agregarTransaccion(user.getNombre(), cantidad);
	}
	
	public boolean adoptar(int Usuario, Mascota mascota) {
		if (Usuario < personas.size()) {
			ArrayList<Mascota> adoptados = personas.get(Usuario).getAdopciones();
			personas.get(Usuario).setAdopciones(adoptados);
			
			int i = 0;
			while (i < reportes.size()) {
				if (mascota == reportes.get(i)) {
					reportes.get(i).setEstado("En Adopción");
					mascota.setEstado("En Adopción");
				}
				i++;
			}
			
			adoptados.add(mascota);
			personas.get(Usuario).setAdopciones(adoptados);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//Se utiliza el indexCasaCuna para idenfiticar a cuál Casa Cuna se le agregará la mascota
	public boolean alojarEnCasaCuna(int indexCasaCuna,Mascota mascota){
		//TODO
		return true;
	}
	
	
/**************       Setters y Getters  ****************************************************/
	public ArrayList<Usuario> getPersonas() {
		return personas;
	}


	public void setPersonas(ArrayList<Usuario> personas) {
		this.personas = personas;
	}


	public ArrayList<Mascota> getReportes() {
		return reportes;
	}


	public void setReportes(ArrayList<Mascota> reportes) {
		this.reportes = reportes;
	}


	public ArrayList<CasaCuna> getCasasCuna() {
		return casasCuna;
	}


	public void setCasasCuna(ArrayList<CasaCuna> casasCuna) {
		this.casasCuna = casasCuna;
	}


	public ArrayList<Asociacion> getAsociaciones() {
		return asociaciones;
	}


	public void setAsociaciones(ArrayList<Asociacion> asociaciones) {
		this.asociaciones = asociaciones;
	}


	public ArrayList<Usuario> getListaNegra() {
		return listaNegra;
	}


	public void setListaNegra(ArrayList<Usuario> listaNegra) {
		this.listaNegra = listaNegra;
	}


	public ArrayList<String> getListaRazas() {
		return listaRazas;
	}


	public void setListaRazas(ArrayList<String> listaRazas) {
		this.listaRazas = listaRazas;
	}


	public ArrayList<String> getListaTipos() {
		return listaTipos;
	}


	public void setListaTipos(ArrayList<String> listaTipos) {
		this.listaTipos = listaTipos;
	}


	public ArrayList<String> getListaColores() {
		return listaColores;
	}


	public void setListaColores(ArrayList<String> listaColores) {
		this.listaColores = listaColores;
	}
	
}