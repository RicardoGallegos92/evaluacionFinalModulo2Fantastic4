package prevencionRiesgos;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	Scanner leer = new Scanner(System.in);
	Principal principal = new Principal();
	
	public void nuevoCliente(){
		String nombre = null;
		LocalDate fechaNacimiento = null;
		int run = 0;
		String nombres = null;
	    String apellidos = null;
	    String telefono = null;
	    String afp = null;
	    int sistemaSalud = 0;
	    String direccion = null;
	    String comuna = null;

	    Cliente nuevoCliente = new Cliente(
						    		nombre,
						    		fechaNacimiento,
						    		run,
						    		nombres,
						    		apellidos,
						    		telefono,
						    		afp,
						    		sistemaSalud,
						    		direccion,
						    		comuna,
						    		0		// se debe remover el int edad
	    						);
		principal.getContenedor().almacenarCliente(nuevoCliente);
	}
	
	public void nuevoProfesional(){
		String nombre = null;
		LocalDate fechaNacimiento = null;
		int run = 0;
		String titulo;
		LocalDate fechaIngreso;

		Profesional nuevoProfesional = new Profesional(
									nombre,
									fechaNacimiento,
									run,
									titulo,
									fechaIngreso
								);

		principal.getContenedor().almacenarProfesional(nuevoProfesional);
	}
	
	public void nuevoAdministrativo(){
		String nombre = null;
		LocalDate fechaNacimiento = null;
		int run = 0;
		String area = null;
		String expPrevia = null;

		Administrativo nuevoAdministrativo = new Administrativo(
									nombre,
									fechaNacimiento,
									run,
									area,
									expPrevia
								);
		
		principal.getContenedor().almacenarAdministrativo(nuevoAdministrativo);
	}
	// metodoPendiente
	public void nuevoCapacitacion(){
		
		principal.getContenedor().almacenarCapacitacion();
	}
	
	public void eliminarUsuario(){
		int run = 0;
		principal.getContenedor().eliminarUsuario(run);
	}

	public void imprimirListado(ArrayList<Object> listado){
		for(Object elemento : listado){
			System.out.println(elemento.toString());
		}
	}
	
	public void listarUsuarios(){
		ArrayList<Asesoria> asesorias = principal.getContenedor().listarUsuarios();
		if(asesorias == null){
			System.out.println("No existen asesorias en el registro");
			return;
		}
		imprimirListado(asesorias);
	}
	
	public void listarUsuariosPorTipo(){
		String tipoUsuario = null;
		ArrayList<Usuario> usuariosPorTipo = principal.getContenedor().listarUsuariosPorTipo(tipoUsuario);
		if(usuariosPorTipo == null){
			System.out.printf("No existen Usuarios de tipo %s en el registro\n",tipoUsuario);
			return;
		}
		imprimirListado(usuariosPorTipo);
	}
	
	public void listarCapacitaciones(){
		ArrayList<Capacitacion> capacitaciones = principal.getContenedor().listarCapacitaciones();
		if(capacitaciones == null){
			System.out.println("No existen capacitaciones en el registro");
			return;
		}
		imprimirListado(capacitaciones);
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
				nuevoCliente();
			case 2:
				nuevoProfesional();
			case 3:
				nuevoAdministrativo();
			case 4:
				nuevoCapacitacion();
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