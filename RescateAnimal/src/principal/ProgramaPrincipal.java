package principal;

import interfaz.*;
import sistema.*;
import apoyoanimal.*;
import clientes.*;

public class ProgramaPrincipal {
	public static Registro registro = new Registro();
	
	public ProgramaPrincipal(){
		
	}
	
	public boolean registrarUsuario(Usuario nuevo, String clave){
		return registro.agregarUsuario(nuevo);
	}
	
	public static void main(String[] args) {
		new VentanaPrincipal();
	}
	
}
