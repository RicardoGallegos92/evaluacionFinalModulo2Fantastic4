package prevencionRiesgos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class VisitaTerreno {
    
    private int id; 
    private int rutCliente; // Número menor a 99,999,999
    private LocalDate dia; // Formato DD/MM/AAAA
    private LocalTime hora; // Formato HH:MM (hora 0-23, minutos 0-59)
    private String lugar; // 10-50 caracteres
    private String comentarios; // Máximo 100 caracteres, opcional
    private ArrayList<Revision> revisiones; // Lista de revisiones asociadas (extensión opcional)

    // Constructor vacío
    public VisitaTerreno() {
        this.revisiones = new ArrayList<>();
    }

    // Constructor con todos los parámetros
    public VisitaTerreno(int identificador, int rutCliente, String dia, String hora, String lugar, String comentarios) {
        setIdentificador(identificador);
        setRutCliente(rutCliente);
        setDia(dia);
        setHora(hora);
        setLugar(lugar);
        setComentarios(comentarios);
        this.revisiones = new ArrayList<>();
    }

    // Validaciones
    private LocalDate validarYParsearFecha(String fecha) {
        if (fecha == null || fecha.trim().isEmpty()) {
            throw new IllegalArgumentException("La fecha es obligatoria.");
        }
        if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new IllegalArgumentException("La fecha debe estar en formato DD/MM/AAAA.");
        }
        try {
            return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Fecha no válida: " + fecha);
        }
    }

    private LocalTime validarHora(String hora) {
        if (hora == null || !hora.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
            throw new IllegalArgumentException("La hora debe estar en formato HH:MM (hora 0-23, minutos 0-59).");
        }
        try {
            return LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Hora no válida: " + hora);
        }
    }

    private String validarLugar(String lugar) {
        if (lugar == null || lugar.trim().isEmpty()) {
            throw new IllegalArgumentException("El lugar es obligatorio.");
        }
        if (lugar.length() < 10 || lugar.length() > 50) {
            throw new IllegalArgumentException("El lugar debe tener entre 10 y 50 caracteres.");
        }
        return lugar.trim();
    }

    private String validarComentarios(String comentarios) {
        if (comentarios != null && comentarios.length() > 100) {
            throw new IllegalArgumentException("Los comentarios no pueden exceder 100 caracteres.");
        }
        return comentarios != null ? comentarios.trim() : null;
    }

    // Setters
    public void setIdentificador(int identificador) {
        if (identificador <= 0) {
            throw new IllegalArgumentException("El identificador debe ser un número positivo.");
        }
        this.id = identificador;
    }

    public void setRutCliente(int rutCliente) {
        if (rutCliente <= 0 || rutCliente > 99999999) {
            throw new IllegalArgumentException("El RUT del cliente debe ser un número positivo menor a 99,999,999.");
        }
        this.rutCliente = rutCliente;
    }

    public void setDia(String dia) {
        this.dia = validarYParsearFecha(dia);
    }

    public void setDia(LocalDate dia) {
        if (dia == null) {
            throw new IllegalArgumentException("La fecha no puede ser null.");
        }
        this.dia = dia;
    }

    public void setHora(String hora) {
        this.hora = validarHora(hora);
    }

    public void setHora(LocalTime hora) {
        if (hora == null) {
            throw new IllegalArgumentException("La hora no puede ser null.");
        }
        this.hora = hora;
    }

    public void setLugar(String lugar) {
        this.lugar = validarLugar(lugar);
    }

    public void setComentarios(String comentarios) {
        this.comentarios = validarComentarios(comentarios);
    }

    // Getters
    public int getIdentificador() {
        return id;
    }

    public int getRutCliente() {
        return rutCliente;
    }

    public String getDia() {
        return dia != null ? dia.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : null;
    }

    public LocalDate getDiaAsLocalDate() {
        return dia;
    }

    public String getHora() {
        return hora != null ? hora.format(DateTimeFormatter.ofPattern("HH:mm")) : null;
    }

    public LocalTime getHoraAsLocalTime() {
        return hora;
    }

    public String getLugar() {
        return lugar;
    }

    public String getComentarios() {
        return comentarios;
    }

    public List<Revision> getRevisiones() {
        return new ArrayList<>(revisiones); // Retorna copia para encapsulación
    }

    // Métodos para manejar revisiones
    public void agregarRevision(Revision revision) {
        if (revision == null) {
            throw new IllegalArgumentException("La revisión no puede ser null.");
        }
        if (revision.getIdentificadorVisita() != this.id) {
            throw new IllegalArgumentException("La revisión debe estar asociada a esta visita (identificadorVisita no coincide).");
        }
        revisiones.add(revision);
    }

    public void eliminarRevision(int identificadorRevision) {
        revisiones.removeIf(revision -> revision.getIdentificador() == identificadorRevision);
    }

    // Método toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VisitaTerreno{");
        sb.append("identificador=").append(id);
        sb.append(", rutCliente=").append(rutCliente);
        sb.append(", dia='").append(getDia()).append('\'');
        sb.append(", hora='").append(getHora()).append('\'');
        sb.append(", lugar='").append(lugar).append('\'');
        sb.append(", comentarios='").append(comentarios != null ? comentarios : "").append('\'');
        sb.append(", revisiones=").append(revisiones.size());
        sb.append('}');
        return sb.toString();
    }
}