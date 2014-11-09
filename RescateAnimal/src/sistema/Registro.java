package sistema;

import java.util.ArrayList;

import apoyoanimal.Asociacion;
import apoyoanimal.CasaCuna;
import clientes.Mascota;
import clientes.Usuario;

public class Registro {
	private ArrayList<Usuario> personas;
	private ArrayList<Mascota> reportes;
	private ArrayList<CasaCuna> casasCuna ;
	private ArrayList<Asociacion> asociaciones ;
	private ArrayList<Usuario> listaNegra;
	private ArrayList<String> listaRazas ;
	private ArrayList<String> listaTipos ;
	private ArrayList<String> listaColores;
	
	Registro(){
		personas=new ArrayList<>();
		reportes=new ArrayList<>();
		casasCuna=new ArrayList<>();
		asociaciones=new ArrayList<>();
		listaNegra=new ArrayList<>();
		listaRazas=new ArrayList<>();
		listaTipos=new ArrayList<>();
		listaColores=new ArrayList<>();
	}
	
	
	private boolean verificarAdd(ArrayList lista,Object elemento){
		if (lista.get(lista.size()-1)==elemento){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean agregarUsuario(Usuario nUsuario){
		personas.add(nUsuario);
		return verificarAdd(personas,nUsuario);
	}
	
	public boolean agregarReporte(Mascota nReporte){
		reportes.add(nReporte);
		return verificarAdd(reportes,nReporte);
	}
	
	public boolean agregarCasaCuna(CasaCuna nCasa){
		casasCuna.add(nCasa);
		return verificarAdd(casasCuna, nCasa);
	}
	
	public boolean agregarAsociacion(Asociacion nAsocia){
		asociaciones.add(nAsocia);
		return verificarAdd(casasCuna, nAsocia);
	}
	
}