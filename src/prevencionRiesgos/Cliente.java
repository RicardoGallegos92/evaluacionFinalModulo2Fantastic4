package prevencionRiesgos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private String nombres;         // 5-30
    private String apellidos;       // 5-30
    private String telefono;        // 12
    private String afp;             // 4-30
    private int sistemaSalud;       // 1 o 2
    private String direccion;       // <=70
    private String comuna;          // <=50
    private int edad;               // 1-150
    private ArrayList<Accidente> accidentes;
    private ArrayList<VisitaTerreno> visitasTerreno;

    public Cliente() {
        super();
        this.visitasTerreno = new ArrayList<>();
    }

    
    
    public Cliente(String nombre, LocalDate fechaNacimiento, int run,
                   String nombres, String apellidos, String telefono,
                   String afp, int sistemaSalud, String direccion,
                   String comuna, int edad) {
        super(nombre, fechaNacimiento, run);
        setNombres(nombres);
        setApellidos(apellidos);
        setTelefono(telefono);
        setAfp(afp);
        setSistemaSalud(sistemaSalud);
        setDireccion(direccion);
        setComuna(comuna);
        setEdad(edad);
        this.visitasTerreno = new ArrayList<>();
    }

    public String obtenerNombre() {
        return nombres + " " + apellidos;
    }

    public String obtenerSistemaSalud() {
        return switch (sistemaSalud) {
            case 1 -> "Fonasa";
            case 2 -> "Isapre";
            default -> "Desconocido";
        };
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Nombres: " + nombres + "\n" +
               "Apellidos: " + apellidos + "\n" +
               "Teléfono: " + telefono + "\n" +
               "AFP: " + afp + "\n" +
               "Sistema de Salud: " + obtenerSistemaSalud() + "\n" +
               "Dirección: " + direccion + "\n" +
               "Comuna: " + comuna + "\n" +
               "Edad: " + mostrarEdad(); // herencia
    }

    // ----------- Getters y Setters con validaciones ------------------

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        if (nombres != null && nombres.length() >= 5 && nombres.length() <= 30) {
            this.nombres = nombres;
        } else {
            this.nombres = null;
        }
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        if (apellidos != null && apellidos.length() >= 5 && apellidos.length() <= 30) {
            this.apellidos = apellidos;
        } else {
            this.apellidos = null;
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono != null && telefono.length() == 12) {
            this.telefono = telefono;
        } else {
            this.telefono = null;
        }
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        if (afp != null && afp.length() >= 4 && afp.length() <= 30) {
            this.afp = afp;
        } else {
            this.afp = null;
        }
    }

    public int getSistemaSalud() {
        return sistemaSalud;
    }

    public void setSistemaSalud(int sistemaSalud) {
        if (sistemaSalud == 1 || sistemaSalud == 2) {
            this.sistemaSalud = sistemaSalud;
        } else {
            this.sistemaSalud = 0; // inválido
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion != null && direccion.length() <= 70) {
            this.direccion = direccion;
        } else {
            this.direccion = null;
        }
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        if (comuna != null && comuna.length() <= 50) {
            this.comuna = comuna;
        } else {
            this.comuna = null;
        }
    }


       public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 1 && edad <= 150) {
            this.edad = edad;
        } else {
            this.edad = 0;
        }

    }
    
    public void agregarVisitaTerreno(VisitaTerreno visita) {
    	if(visita.equals(null)) {
    		throw new IllegalArgumentException("La visita no puede ser nula");
    	}
    	if(visita.getRutCliente() != this.getRun()) {
    		throw new IllegalArgumentException("El RUT del cliente en la visita no coincide.");
    	}
    	visitasTerreno.add(visita);
    }
    
    public List<VisitaTerreno> getVisitasTerreno(){
    	return new ArrayList<>(visitasTerreno);
    }
}
