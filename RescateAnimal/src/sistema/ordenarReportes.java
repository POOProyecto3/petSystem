package sistema;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import clientes.Mascota;

public class ordenarReportes implements Comparator{
	public String atributoPorOrdenar;
	
	public ordenarReportes(String atributoPorOrdenar){
		this.atributoPorOrdenar = atributoPorOrdenar;
	}
	
	public int compare(Object objeto1, Object objeto2){
		Mascota mascota1 = (Mascota) objeto1;
		Mascota mascota2 = (Mascota) objeto2;
		try {
			if(atributoPorOrdenar=="nombre"){
				return mascota1.getNombre().toLowerCase().compareTo(mascota2.getNombre().toLowerCase());
			} else if (atributoPorOrdenar == "especie"){
				return mascota1.getEspecie().toLowerCase().compareTo(mascota2.getEspecie().toLowerCase());
			} else if (atributoPorOrdenar == "raza"){
				return mascota1.getRaza().toLowerCase().compareTo(mascota2.getRaza().toLowerCase());
			} else if (atributoPorOrdenar == "chip"){
				return mascota1.getChip().toLowerCase().compareTo(mascota2.getChip().toLowerCase());
			} else if (atributoPorOrdenar == "color"){
				return mascota1.getColor().toLowerCase().compareTo(mascota2.getColor().toLowerCase());
			} else if (atributoPorOrdenar == "ubicacion"){
				return mascota1.getUbicacion().toLowerCase().compareTo(mascota2.getUbicacion().toLowerCase());
			} else if (atributoPorOrdenar == "fecha"){
				return mascota1.getFecha().toLowerCase().compareTo(mascota2.getFecha().toLowerCase());
			} else if (atributoPorOrdenar == "estado"){
				return mascota1.getEstado().toLowerCase().compareTo(mascota2.getEstado().toLowerCase());
			} else if (atributoPorOrdenar == "recompensa"){
				return mascota1.getRecompensa().toLowerCase().compareTo(mascota2.getRecompensa().toLowerCase());
			}
		} catch(Exception error){}
		return 0;
	}
	
	public ArrayList<Mascota> ordenar(ArrayList<Mascota> reportes) {
		Collections.sort(reportes, new ordenarReportes(atributoPorOrdenar));
		return reportes;
	}
}
