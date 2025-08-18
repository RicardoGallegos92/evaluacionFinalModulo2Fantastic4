package prevencionRiesgos;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner leer = new Scanner(System.in);
    Principal principal = new Principal();

    // Método auxiliar para leer y validar nombre
    private String leerNombre(String mensaje) {
        String entrada;
        while (true) {
            System.out.print(mensaje);
            entrada = leer.nextLine().trim();
            if (!entrada.isEmpty() && entrada.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                return entrada;
            } else {
                System.out.println("Por favor, ingrese un nombre válido (solo letras y espacios).");
            }
        }
    }

    // Método auxiliar para leer y validar RUN (formato numérico, sin puntos ni guion, o con guion)
    private int leerRun() {
        while (true) {
            System.out.print("Ingrese RUN (sin puntos ni dígito verificador): ");
            String input = leer.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("RUN inválido. Debe ser numérico.");
            }
        }
    }

    // Método auxiliar para leer teléfono
    private String leerTelefono() {
        while (true) {
            System.out.print("Ingrese teléfono (9 dígitos, solo números): ");
            String tel = leer.nextLine().trim();
            if (tel.matches("\\d{9}")) {
                return tel;
            } else {
                System.out.println("El teléfono debe tener 9 dígitos numéricos.");
            }
        }
    }

    // Método auxiliar para leer AFP
    private String leerAfp() {
        System.out.print("Ingrese AFP: ");
        return leer.nextLine().trim();
    }

    // Método auxiliar para leer sistema de salud (1 = Fonasa, 2 = Isapre)
    private int leerSistemaSalud() {
        while (true) {
            System.out.print("Sistema de salud (1: Fonasa, 2: Isapre): ");
            String input = leer.nextLine().trim();
            try {
                int sistema = Integer.parseInt(input);
                if (sistema == 1 || sistema == 2) {
                    return sistema;
                } else {
                    System.out.println("Opción inválida. Ingrese 1 o 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número (1 o 2).");
            }
        }
    }

    // Método auxiliar para leer dirección
    private String leerDireccion() {
        System.out.print("Ingrese dirección: ");
        return leer.nextLine().trim();
    }

    // Método auxiliar para leer comuna
    private String leerComuna() {
        return leerNombre("Ingrese comuna: ");
    }

    // ------------------ NUEVO CLIENTE ------------------
    public void nuevoCliente() {
        System.out.println("\n--- Ingreso de Nuevo Cliente ---");

        String nombre = leerNombre("Ingrese nombre completo: ");
        LocalDate fechaNacimiento = leerFecha("Fecha de nacimiento");
        int run = leerRun();
        String nombres = leerNombre("Ingrese nombres: ");
        String apellidos = leerNombre("Ingrese apellidos: ");
        String telefono = leerTelefono();
        String afp = leerAfp();
        int sistemaSalud = leerSistemaSalud();
        String direccion = leerDireccion();
        String comuna = leerComuna();

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
                comuna
                // Nota: si Cliente tiene un campo edad, se calcula internamente, no se pasa
        );

        principal.getContenedor().almacenarCliente(nuevoCliente);
        System.out.println("Cliente registrado con éxito.\n");
    }

    // ------------------ NUEVO PROFESIONAL ------------------
    public void nuevoProfesional() {
        System.out.println("\n--- Ingreso de Nuevo Profesional ---");

        String nombre = leerNombre("Ingrese nombre completo: ");
        LocalDate fechaNacimiento = leerFecha("Fecha de nacimiento");
        int run = leerRun();
        System.out.print("Ingrese título: ");
        String titulo = leer.nextLine().trim();
        LocalDate fechaIngreso = leerFecha("Fecha de ingreso");

        Profesional nuevoProfesional = new Profesional(
                nombre,
                fechaNacimiento,
                run,
                titulo,
                fechaIngreso
        );

        principal.getContenedor().almacenarProfesional(nuevoProfesional);
        System.out.println("Profesional registrado con éxito.\n");
    }

    // ------------------ NUEVO ADMINISTRATIVO ------------------
    public void nuevoAdministrativo() {
        System.out.println("\n--- Ingreso de Nuevo Administrativo ---");

        String nombre = leerNombre("Ingrese nombre completo: ");
        LocalDate fechaNacimiento = leerFecha("Fecha de nacimiento");
        int run = leerRun();
        System.out.print("Ingrese área: ");
        String area = leer.nextLine().trim();
        System.out.print("Ingrese experiencia previa: ");
        String expPrevia = leer.nextLine().trim();

        Administrativo nuevoAdministrativo = new Administrativo(
                nombre,
                fechaNacimiento,
                run,
                area,
                expPrevia
        );

        principal.getContenedor().almacenarAdministrativo(nuevoAdministrativo);
        System.out.println("Administrativo registrado con éxito.\n");
    }

    // ------------------ NUEVA CAPACITACIÓN ------------------
    public void nuevoCapacitacion() {
        System.out.println("\n--- Registro de Nueva Capacitación ---");

        System.out.print("Ingrese identificador: ");
        int identificador = Integer.parseInt(leer.nextLine().trim());
        
		System.out.print("Ingrese Rut Cliente: ");
        int rutCliente = Integer.parseInt(leer.nextLine().trim());

        System.out.print("Día de la capacitación\n[Lunes - Domingo]");
        String dia = leer.nextLine().trim();

        System.out.print("Ingrese hora (ej. 10:00): ");
        String hora = leer.nextLine().trim();

        System.out.print("[10-20 caracteres]\nIngrese lugar: ");
        String lugar = leer.nextLine().trim();

        System.out.print("Ingrese duración (en minutos): ");
        String duracion = leer.nextLine().trim();

        System.out.print("Ingrese cantidad de asistentes: ");
        int cantidadAsistentes = Integer.parseInt(leer.nextLine().trim());

        Capacitacion nuevaCapacitacion = new Capacitacion(
                identificador,
				Integer.toString(rutCliente),
                dia,
                hora,
                lugar,
                duracion,
                cantidadAsistentes
        );

        principal.getContenedor().almacenarCapacitacion(nuevaCapacitacion);
        System.out.println("Capacitación registrada con éxito.\n");
    }

    // ------------------ ELIMINAR USUARIO ------------------
    public void eliminarUsuario() {
        System.out.print("Ingrese RUN del usuario a eliminar: ");
        int run;
        try {
            run = Integer.parseInt(leer.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("RUN inválido.\n");
            return;
        }
        principal.getContenedor().eliminarUsuario(run);
        System.out.println("Usuario con RUN " + run + " eliminado (si existía).\n");
    }

    // ------------------ LISTAR UTILS ------------------
    public void imprimirListado(ArrayList<?> listado) {
        if (listado == null || listado.isEmpty()) {
            System.out.println("No hay elementos para mostrar.\n");
            return;
        }
        for (Object elemento : listado) {
            System.out.println(elemento.toString());
        }
        System.out.println();
    }

    public void listarUsuarios() {
        ArrayList<Usuario> asesorias = principal.getContenedor().listarUsuarios();
        if (asesorias == null || asesorias.isEmpty()) {
            System.out.println("No existen asesorias en el registro.\n");
            return;
        }
        imprimirListado(asesorias);
    }

    public void listarUsuariosPorTipo() {
        System.out.print("Ingrese tipo de usuario (Cliente, Profesional, Administrativo): ");
        String tipoUsuario = leer.nextLine().trim().toLowerCase();

        ArrayList<Usuario> usuariosPorTipo = principal.getContenedor().listarUsuariosPorTipo(tipoUsuario);
        if (usuariosPorTipo == null || usuariosPorTipo.isEmpty()) {
            System.out.printf("No existen Usuarios de tipo '%s' en el registro.\n\n", tipoUsuario);
            return;
        }
        imprimirListado(usuariosPorTipo);
    }

    public void listarCapacitaciones() {
        ArrayList<Capacitacion> capacitaciones = principal.getContenedor().listarCapacitaciones();
        if (capacitaciones == null || capacitaciones.isEmpty()) {
            System.out.println("No existen capacitaciones en el registro.\n");
            return;
        }
        imprimirListado(capacitaciones);
    }

    // ------------------ MENÚ ------------------
    public void menu() {
        String[] opciones = {
                "Almacenar Cliente",
                "Almacenar Profesional",
                "Almacenar Administrativo",
                "Almacenar Capacitación",
                "Eliminar Usuario",
                "Listar Usuarios",
                "Listar Usuarios por Tipo",
                "Listar Capacitaciones"
        };
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ": " + opciones[i]);
        }
        System.out.println("0: Salir");
        System.out.print("Seleccione una opción: ");
    }

    // ------------------ SOLICITAR INPUT ------------------
    public void solicitarInput() {
        menu();
        int opcion;
        try {
            opcion = Integer.parseInt(leer.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Opción inválida. Intente nuevamente.\n");
            solicitarInput();
            return;
        }

        switch (opcion) {
            case 0:
                System.out.println("Gracias por su preferencia. ¡Hasta luego!");
                return;
            case 1:
                nuevoCliente();
                break;
            case 2:
                nuevoProfesional();
                break;
            case 3:
                nuevoAdministrativo();
                break;
            case 4:
                nuevoCapacitacion();
                break;
            case 5:
                eliminarUsuario();
                break;
            case 6:
                listarUsuarios();
                break;
            case 7:
                listarUsuariosPorTipo();
                break;
            case 8:
                listarCapacitaciones();
                break;
            default:
                System.out.println("Opción inválida. Intente nuevamente.\n");
        }

        solicitarInput(); // Llamada recursiva para seguir mostrando el menú
    }

// ------------------ MAIN ------------------

    public static void main(String[] args) {
        Main main = new Main();
        main.solicitarInput();
/*
		Usuario user = new Usuario();
		System.out.println( user );
		System.out.println( user.mostrarEdad() );
*/
    }
}