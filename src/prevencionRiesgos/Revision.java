package prevencionRiesgos;

public class Revision {

	private int id;
	private int idVisitaTerreno;
	private String nombreRevision;
	private String detalle;
	private int estado;

	// Constantes para los estados
	public static final int SIN_PROBLEMAS = 1;
	public static final int CON_OBSERVACIONES = 2;
	public static final int NO_APRUEBA = 3;

	public Revision(int identificador, int identificadorVisita, String nombre, String detalle, int estado) {
		setIdentificador(identificador);
		setIdentificadorVisita(identificadorVisita);
		setNombre(nombre);
		setDetalle(detalle);
		setEstado(estado);
	}

	// Constructor sin parámetros
	public Revision() {
	}

	// Validaciones
	private void validarNombre(String nombre) {
		if (nombre == null || nombre.trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre de la revisión es obligatorio.");
		}
		if (nombre.length() < 10 || nombre.length() > 50) {
			throw new IllegalArgumentException("El nombre debe tener entre 10 y 50 caracteres.");
		}
	}

	private void validarDetalle(String detalle) {
		if (detalle != null && detalle.length() > 100) {
			throw new IllegalArgumentException("El detalle no puede exceder 100 caracteres.");
		}
	}

	private void validarEstado(int estado) {
		if (estado < SIN_PROBLEMAS || estado > NO_APRUEBA) {
			throw new IllegalArgumentException(
					"El estado debe ser 1 (sin problemas), 2 (con observaciones) o 3 (no aprueba).");
		}
	}

	// Setters
	public void setIdentificador(int identificador) {
		if (identificador <= 0) {
			throw new IllegalArgumentException("El identificador debe ser un número positivo.");
		}
		this.id = identificador;
	}

	public void setIdentificadorVisita(int identificadorVisita) {
		if (identificadorVisita <= 0) {
			throw new IllegalArgumentException("El identificador de la visita debe ser un número positivo.");
		}
		this.idVisitaTerreno = identificadorVisita;
	}

	public void setNombre(String nombre) {
		validarNombre(nombre);
		this.nombreRevision = nombre.trim();
	}

	public void setDetalle(String detalle) {
		validarDetalle(detalle);
		this.detalle = detalle != null ? detalle.trim() : null;
	}

	public void setEstado(int estado) {
		validarEstado(estado);
		this.estado = estado;
	}

	// Getters
	public int getIdentificador() {
		return id;
	}

	public int getIdentificadorVisita() {
		return idVisitaTerreno;
	}

	public String getNombre() {
		return nombreRevision;
	}

	public String getDetalle() {
		return detalle;
	}

	public int getEstado() {
		return estado;
	}

	// Método toString
	@Override
    public String toString() {
        String estadoTexto;
        switch (estado) {
            case SIN_PROBLEMAS:
                estadoTexto = "Sin problemas";
                break;
            case CON_OBSERVACIONES:
                estadoTexto = "Con observaciones";
                break;
            case NO_APRUEBA:
                estadoTexto = "No aprueba";
                break;
            default:
                estadoTexto = "Desconocido";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Revision {");
        sb.append("identificador=").append(id);
        sb.append(", identificadorVisita=").append(idVisitaTerreno);
        sb.append(", nombre='").append(nombreRevision).append('\'');
        sb.append(", detalle='").append(detalle != null ? detalle : "").append('\'');
        sb.append(", estado=").append(estadoTexto);
        sb.append('}');
        return sb.toString();
    }
}
