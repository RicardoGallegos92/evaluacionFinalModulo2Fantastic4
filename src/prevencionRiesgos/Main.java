package prevencionRiesgos;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		//Usuario user = new Usuario();
		//System.out.println(user);
		//System.out.println(user.mostrarEdad());

		// Prueba 1: Crear un Cliente con datos válidos
		System.out.println("=== Prueba 1: Creación de Cliente ===");
		try {
			Cliente cliente = new Cliente("Juan Pérez", LocalDate.of(1980, 5, 15), 12345678, "Juan Antonio",
					"Pérez Gómez", "+56912345678", "Provida", 1, "Av. Principal 123", "Santiago", 45);
			System.out.println("Cliente creado: " + cliente.toString());
			System.out.println("Nombre completo: " + cliente.obtenerNombre());
			System.out.println("Sistema de salud: " + cliente.obtenerSistemaSalud());
			System.out.println("Edad: " + cliente.mostrarEdad());
		} catch (IllegalArgumentException e) {
			System.out.println("Error en Cliente: " + e.getMessage());
		}

		// Prueba 2: Crear un Cliente con datos inválidos
		System.out.println("\n=== Prueba 2: Cliente con datos inválidos ===");
		try {
			Cliente clienteInvalido = new Cliente("Ana", // Nombre muy corto
					LocalDate.of(1985, 10, 20), 999999999, // RUN inválido
					"Ana", // Nombres muy corto
					"Gómez", "12345", // Teléfono inválido
					"AFP", // AFP muy corto
					3, // Sistema de salud inválido
					"Calle muy larga que excede los setenta caracteres permitidos por el sistema de validación", // Dirección
																													// inválida
					"Comuna muy larga que excede el límite", // Comuna inválida
					200 // Edad inválida
			);
			System.out.println("Cliente inválido creado (no debería llegar aquí)");
		} catch (IllegalArgumentException e) {
			System.out.println("Error esperado en Cliente: " + e.getMessage());
		}

		// Prueba 3: Crear una VisitaTerreno con datos válidos
		System.out.println("\n=== Prueba 3: Creación de VisitaTerreno ===");
		try {
			VisitaTerreno visita = new VisitaTerreno(1, 12345678, "15/10/2025", "14:30", "Planta Industrial Norte",
					"Visita programada para revisar seguridad.");
			System.out.println("Visita creada: " + visita.toString());
		} catch (IllegalArgumentException e) {
			System.out.println("Error en VisitaTerreno: " + e.getMessage());
		}

		// Prueba 4: Crear una VisitaTerreno con datos inválidos
		System.out.println("\n=== Prueba 4: VisitaTerreno con datos inválidos ===");
		try {
			VisitaTerreno visitaInvalida = new VisitaTerreno(-1, // Identificador inválido
					999999999, // RUT inválido
					"2025-10-15", // Formato de fecha inválido
					"25:00", // Hora inválida
					"Planta", // Lugar muy corto
					"Comentarios muy largos que exceden el límite de cien caracteres establecido por las reglas del sistema para garantizar la correcta gestión de la información." // Comentarios
																																													// inválidos
			);
			System.out.println("Visita inválida creada (no debería llegar aquí)");
		} catch (IllegalArgumentException e) {
			System.out.println("Error esperado en VisitaTerreno: " + e.getMessage());
		}

		// Prueba 5: Crear una Revision y asociarla a una VisitaTerreno
		System.out.println("\n=== Prueba 5: Creación y asociación de Revision ===");
		try {
			VisitaTerreno visita = new VisitaTerreno(2, 12345678, "20/10/2025", "09:00", "Edificio Central",
					"Inspección de equipos.");
			Revision revision = new Revision(1, 2, // Misma ID que la visita
					"Revisión de Seguridad Estructural", "Verificación de soportes y vigas.", Revision.SIN_PROBLEMAS);
			visita.agregarRevision(revision);
			System.out.println("Visita con revisión: " + visita.toString());
			System.out.println("Revisión: " + revision.toString());
		} catch (IllegalArgumentException e) {
			System.out.println("Error en Revision: " + e.getMessage());
		}

		// Prueba 6: Asociar VisitaTerreno a Cliente
		System.out.println("\n=== Prueba 6: Asociación de VisitaTerreno a Cliente ===");
		try {
			Cliente cliente = new Cliente("María López", LocalDate.of(1975, 3, 22), 87654321, "María Elena",
					"López Vargas", "+56987654321", "Cuprum", 2, "Calle Secundaria 456", "Providencia", 50);
			VisitaTerreno visita = new VisitaTerreno(3, 87654321, // Mismo RUT que el cliente
					"25/10/2025", "11:00", "Oficina Principal Sur", "Capacitación de seguridad.");
			// Agregar visita al cliente (método que debes añadir en Cliente)
			cliente.agregarVisitaTerreno(visita);
			cliente.getVisitasTerreno().add(visita);
			System.out.println("Cliente con visita: " + cliente.toString());
			System.out.println("Visitas del cliente: " + cliente.getVisitasTerreno().size());
		} catch (IllegalArgumentException e) {
			System.out.println("Error en asociación Cliente-Visita: " + e.getMessage());
		}

		// Prueba 7: Probar eliminación de una revisión
		System.out.println("\n=== Prueba 7: Eliminación de Revision ===");
		try {
			VisitaTerreno visita = new VisitaTerreno(4, 12345678, "30/10/2025", "15:00", "Planta de Producción",
					"Revisión de maquinaria.");
			Revision revision = new Revision(2, 4, "Revisión de Equipos", "Chequeo de motores.",
					Revision.CON_OBSERVACIONES);
			visita.agregarRevision(revision);
			System.out.println("Antes de eliminar: " + visita.getRevisiones().size() + " revisiones");
			visita.eliminarRevision(2);
			System.out.println("Después de eliminar: " + visita.getRevisiones().size() + " revisiones");
		} catch (IllegalArgumentException e) {
			System.out.println("Error en eliminación de revisión: " + e.getMessage());
		}
	}

}
