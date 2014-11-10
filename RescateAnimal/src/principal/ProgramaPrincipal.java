package principal;

import interfaz.*;
import sistema.*;
import apoyoanimal.*;
import clientes.*;

public class ProgramaPrincipal {
	public static Registro registro = new Registro();
	
	public ProgramaPrincipal(){
		
	}
	
	public boolean registrarUsuario(Usuario usuario, String clave){
		return registro.agregarUsuario(usuario);
	}
	
	public boolean verificarLogIn(String usuario, String clave){
		return true;//logIn(usuario, clave);
	}
	
	public static void main(String[] args) {
		//cargarRegistros();
		new VentanaPrincipal();
	}
	
}
