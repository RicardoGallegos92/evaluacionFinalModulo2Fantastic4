package prevencionRiesgos;
public class Capacitacion {
    private int identificador; // obligatorio
    private String rutCliente; // obligatorio
    private String dia;        // texto: lunes a domingo
    private String hora;       // formato HH:MM
    private String lugar;      // 10 a 50 caracteres
    private String duracion;   // máximo 70 caracteres
    private int cantidadAsistentes; // < 1000, obligatorio

    // Constructor
    public Capacitacion(int identificador, String rutCliente, String dia, String hora, String lugar, String duracion, int cantidadAsistentes) {
        this.identificador = identificador;
        setRutCliente(rutCliente);
        setDia(dia);
        setHora(hora);
        setLugar(lugar);
        setDuracion(duracion);
        setCantidadAsistentes(cantidadAsistentes);
    }

    // Getters y Setters con validaciones
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        if (rutCliente == null || rutCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("El RUT del cliente es obligatorio.");
        }
        this.rutCliente = rutCliente;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        String[] diasValidos = {"lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo"};
        for (String d : diasValidos) {
            if (d.equalsIgnoreCase(dia)) {
                this.dia = dia.toLowerCase();
                return;
            }
        }
        throw new IllegalArgumentException("El día debe estar entre 'lunes' y 'domingo'.");
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        if (!hora.matches("^([0-1]?\\d|2[0-3]):[0-5]\\d$")) {
            throw new IllegalArgumentException("La hora debe estar en formato HH:MM y ser válida.");
        }
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        if (lugar == null || lugar.length() < 10 || lugar.length() > 50) {
            throw new IllegalArgumentException("El lugar debe tener entre 10 y 50 caracteres.");
        }
        this.lugar = lugar;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        if (duracion == null || duracion.length() > 70) {
            throw new IllegalArgumentException("La duración no puede superar los 70 caracteres.");
        }
        this.duracion = duracion;
    }

    public int getCantidadAsistentes() {
        return cantidadAsistentes;
    }

    public void setCantidadAsistentes(int cantidadAsistentes) {
        if (cantidadAsistentes < 1 || cantidadAsistentes >= 1000) {
            throw new IllegalArgumentException("La cantidad de asistentes debe ser un número menor que 1000.");
        }
        this.cantidadAsistentes = cantidadAsistentes;
    }

    // Método mostrarDetalle
    public String mostrarDetalle() {
        return "La capacitación será en " +
                getLugar() + " a las " +
                getHora() + " del día " +
                getDia() + ", y durará " +
                getDuracion() + ".";
    }
}
