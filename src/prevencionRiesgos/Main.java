package prevencionRiesgos;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		Usuario user = new Usuario();
		
		// Crear una fecha de nacimiento y fecha de ingreso de ejemplo
        LocalDate fechaNacimiento = LocalDate.of(1985, 5, 15);
        LocalDate fechaIngreso = LocalDate.of(2020, 3, 10);
		
     // Crear un objeto Profesional
        Profesional profesional = new Profesional(
            "Mar�a Gonz�lez",
            fechaNacimiento, 
            12345678,
            null,
            fechaIngreso
        );
        
        // Probar el método analizarUsuario() de la clase PROFESIONAL
        System.out.println("=== AN�LISIS DEL USUARIO PROFESIONAL ===");
        String resultado = profesional.analizarUsuario();
        System.out.println(resultado);
        
		
	}

}
