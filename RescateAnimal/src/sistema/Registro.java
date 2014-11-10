package sistema;

import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.exception.FacebookOAuthException;
import com.restfb.types.FacebookType;

import comunicacion.Javamail;
import apoyoanimal.Asociacion;
import apoyoanimal.CasaCuna;
import clientes.Mascota;
import clientes.Usuario;

public class Registro implements Serializable{
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
	
	public boolean guardar(){
		try{
			ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream("registro.ser"));
			objout.writeObject(this);
			objout.close();
		}catch(IOException i){return false;}
		return true;
	}
	
	public boolean cargar(){
		try{
			ObjectInputStream objin = new ObjectInputStream(new FileInputStream("registro.ser"));
			Registro registro = (Registro)objin.readObject();
			objin.close();
			personas = registro.personas;
			reportes = registro.reportes;
			casasCuna = registro.casasCuna;
			asociaciones = registro.asociaciones;
			listaNegra = registro.listaNegra;
			listaRazas = registro.listaRazas;
			listaTipos = registro.listaTipos;
			listaColores = registro.listaColores;
		
		}catch(IOException i){return false;}catch(ClassNotFoundException j){return false;}
		return true;
	}
	
	public boolean validarLogin(String username, String clave){
		for(int i=0; i<personas.size(); i++){
			if((username.equals(personas.get(i).getUsername())) && (clave.equals(personas.get(i).getClave())))
				return true;
		}
		return false;
	}
	
	public Usuario getUsuario(String username){
		for(int i=0; i<personas.size(); i++){
			if((username.equals(personas.get(i).getUsername())))
				return personas.get(i);
		}
		return null;
	}
	
	private boolean verificarAdd(ArrayList<Usuario> lista, Usuario nuevo) {
		int i = 0;
		boolean respuesta = true;
		while (i < lista.size()) {
			if (lista.get(i).getUsername() == nuevo.getUsername()) {
				respuesta = false;
			}
		}
		return respuesta;
	}
	
	public boolean agregarUsuario(Usuario nUsuario) {
		if (verificarAdd(personas, nUsuario)) {
			personas.add(nUsuario);
			return true;
		}
		
		else {
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
	
	public boolean notificarPorCorreo(String destinatario, String asunto, String mensaje) {
		Javamail mail = new Javamail();
		return mail.enviarCorreo(destinatario, asunto, mensaje);		
	}
	
	/*Funcion verificar correo: analiza el correo ingresado para evitar problemas a la hora de enviar notificaciones.
	Recibe un correo en forma de string
	retorna un boolean
	Se crea static, ya que es necesario utilizarla sin una instancia de Pesona
	 */
	public static boolean verificarCorreo(String correo) {
		if (correo.contains("@")) { //busca que el correo contenga un "@"
			String[] temp = correo.split("@"); //separa el correo en dos partes mediante el "@"
			if (temp[0].length() != 0) { //si esta condición se cumple significa que existe un nombre de usuario antes del "@"
				if (temp[1].contains(".")) { //verifica que exista un "." al lado derecho del "@"
					if (temp[1].startsWith(".")) { //si esta condición se cumple significa que no existe nada entre "@" y "."
						return false;
					}
					
					else { //si existe un dominio entre "@" y "."
						if (temp[1].endsWith(".")) {
							return false;
						}
						
						else {
							return true;
						}
					}
				}
				
				else {
					return false;
				}
			}
			
			else {
				return false;
			}
		}
		
		else {
			return false;
		}
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
		//TODO
		return false;
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
