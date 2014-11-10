package sistema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.exception.FacebookOAuthException;
import com.restfb.types.FacebookType;

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
	
	public Registro() {
		personas = new ArrayList<>();
		reportes = new ArrayList<>();
		casasCuna = new ArrayList<>();
		asociaciones = new ArrayList<>();
		listaNegra = new ArrayList<>();
		listaRazas = new ArrayList<>();
		listaTipos = new ArrayList<>();
		listaColores = new ArrayList<>();
	}
	
	
	private boolean verificarAdd(ArrayList<Usuario> lista, Usuario nuevo) {
		int i=0;
		boolean respuesta = true;
		while(i<lista.size()){
			if(lista.get(i).getUsername()== nuevo.getUsername()){
				respuesta = false;
			}
		}
		return respuesta;
	}
	
	public boolean agregarUsuario(Usuario nUsuario) {
		if(verificarAdd(personas,nUsuario)){
			personas.add(nUsuario);
			return true;
		}else{
			return false;
		}
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
		boolean estado = false;
		try{
			FacebookClient cliente = new DefaultFacebookClient(
					"CAAVPzMos6fUBAFZALjQ3Mdh6YZBQJkWe4JzZBHJcXtQAMGEK4QWChlVRJaF9Jf8ZCh1lIZ"
					+ "BtmWs9CPh2AEKQClAqK3QjH9AWE2Y9P657KnC2ygrscagVOJsIRgL17XWkcIZAsTKun1j"
					+ "pnb9qRapJawn30DYb8n1ZBC3B9KheM7NbZBpGaoMHybGpzl5ZALhCidtTmjFpKGRWZCZCN"
					+ "Vvcj6sX8ps&expires=5183623");
			
			cliente.publish("me/feed", FacebookType.class, Parameter.with("message", "He reportado "
					+ "una mascota en el sistema Rescate Animal:\n"+mascota.toString()));
			estado=true;
		}catch(Exception ex){
			if(ex instanceof FacebookOAuthException){
				estado=false;
			}
		}
		return estado;
	}
	
	public boolean editarDatosUser(Usuario user) {
		//Proximamente...
		//TODO
		return true;
	}
	
	public boolean efectuarDonaciones(int cantidad, int ubicacionAsocia, Usuario user) {
		return asociaciones.get(ubicacionAsocia).agregarTransaccion(user.getNombre(), cantidad);
	}
	
	public boolean adoptar(int Usuario, Mascota mascota) {
		if (0 <= Usuario && Usuario < personas.size()) {
			ArrayList<Mascota> adoptados = personas.get(Usuario).getAdopciones();
			
			int i = 0;
			while (i < reportes.size()) {
				if (mascota == reportes.get(i)) {
					reportes.get(i).setEstado("En Adopción");
					mascota.setEstado("En Adopción");
					adoptados.add(mascota);
					personas.get(Usuario).setAdopciones(adoptados);
					return true;
				}
				i++;
			}
		}
		else {
			return false;
		}
		return false;
		
	}
	
	//Se utiliza el indexCasaCuna para idenfiticar a cuál Casa Cuna se le agregará la mascota
	public boolean alojarEnCasaCuna(int indexCasaCuna,Mascota mascota) {
		if (0 <= indexCasaCuna && indexCasaCuna<casasCuna.size()) {
			ArrayList<Mascota> lista = casasCuna.get(indexCasaCuna).getMascotasEnCuido();
			
			int i = 0;
			while (i < reportes.size()) {
				if (mascota == reportes.get(i)) {
					reportes.get(i).setEstado("En Casa Cuna");
					mascota.setEstado("En Casa Cuna");
					lista.add(mascota);
					casasCuna.get(indexCasaCuna).setMascotasEnCuido(lista);
					return true;
				}
				i++;
			}			
		}
		return false;
	}
	
	
	public boolean reportarUsuario(Usuario user) {
		listaNegra.add(user);
		return true;
	}
	
	public boolean calificar(Usuario user, float calificacion) {
		int i = 0;
		
		while (i < personas.size()) {			
			if (personas.get(i) == user) {
				if (personas.get(i).getCalificacion() == 0) {
					 personas.get(i).setCalificacion(calificacion);
				}
				
				else {
					personas.get(i).setCalificacion((personas.get(i).getCalificacion() + calificacion) / 2);
					return true;
				}
			}
		}
		return false;
	}
	
	/*Copia un archivo de una ubicacion a otra, el formato de la ruta debe ser "C:/ejemplo/de/ruta/nombreDeArchivo.extension"
	(Puede tener espacios) */
	
	public boolean copiarArchivo(String direccion) {
		File origen = new File(direccion);
		File destino = new File(direccion.substring(direccion.lastIndexOf("/") + 1));

		try {
			InputStream in = new FileInputStream(origen);
			OutputStream out = new FileOutputStream(destino);

			byte[] buf = new byte[1024];
			int len;

			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}

			in.close();
			out.close();
			return true;
		} 
		
		catch (IOException ioe) {
			ioe.printStackTrace();
			return false;
		}
	}
	
	public boolean aceptarCoincidencia(Mascota pMascota, Mascota sMascota) {
		//TODO
		return false;
	}
	
	public boolean ponerEnAdopcion(Mascota mascota) {
		//TODO
		return false;
	}
	
	//Función anteriormente llamada AgregarListaBlanca
	public boolean removerDeListaNegra(Usuario user) {
		//TODO
		return false;
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
