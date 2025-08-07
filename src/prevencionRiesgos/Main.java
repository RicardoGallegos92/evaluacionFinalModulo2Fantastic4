package prevencionRiesgos;

import java.util.Scanner;

public class Main {
	Scanner leer = new Scanner(System.in);
	Principal principal = new Principal();
	
	public void almacenarCliente(){
		
		principal.getContenedor().almacenarCliente();
	}
	
	public void almacenarProfesional(){
		
		principal.getContenedor().almacenarProfesional();
	}
	
	public void almacenarAdministrativo(){
		
		principal.getContenedor().almacenarAdministrativo();
	}
	
	public void almacenarCapacitacion(){
		
		principal.getContenedor().almacenarCapacitacion();
	}
	
	public void eliminarUsuario(){
		
		principal.getContenedor().eliminarUsuario();
	}
	
	public void listarUsuarios(){
		
		principal.getContenedor().listarUsuarios();
	}
	
	public void listarUsuariosPorTipo(){
		
		principal.getContenedor().listarUsuariosPorTipo();
	}
	
	public void listarCapacitaciones(){
		
		principal.getContenedor().listarCapacitaciones();
	}
	

	/**
	 *retorna un menu con opciones
	 */
	public void menu() {
		String[] opciones= {"Almacenar Cliente",
				"Almacenar Profesional",
				"Almacenar Administrativo",
				"Almacenar Capacitacion",
				"Aliminar Usuario",
				"Listar Usuarios",
				"Listar UsuariosPorTipo",
				"Listar Capacitaciones"};
		String menu = "";
		for( int i = 0; i < opciones.length; i++ ){
			menu+= String.format("%d: %s\n", (i+1), opciones[i]);
		}
		menu+= "0: Salir"; 
		System.out.println(menu);
	}

	public void solicitarInput() {
//		limpiarPantalla();
		menu();
		int opcion = -1;

		opcion = Integer.parseUnsignedInt(leer.nextLine().trim());
		switch (opcion){		
			case 0:
				return;
			case 1:
				almacenarCliente();
			case 2:
				almacenarProfesional();
			case 3:
				almacenarAdministrativo();
			case 4:
				almacenarCapacitacion();
			case 5:
				eliminarUsuario();
			case 6:
				listarUsuarios();
			case 7:
				listarUsuariosPorTipo();
			case 8:
				listarCapacitaciones();
			default:
				;
		}
		
	}

	public static void main(String[] args) {
/*
		Usuario user = new Usuario();
		System.out.println( user );
		System.out.println( user.mostrarEdad() );
*/
	}

}