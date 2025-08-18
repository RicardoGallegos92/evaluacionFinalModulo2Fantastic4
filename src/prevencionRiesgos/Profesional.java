package prevencionRiesgos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Representa un profesional dentro del sistema de prevención de riesgos.
 * Extiende la clase Usuario e incluye información adicional como título y fecha
 * de ingreso.
 */
public class Profesional extends Usuario {
	private String titulo;
	private LocalDate fechaIngreso;

	public Profesional() {
		super();
		this.titulo = "";
		this.fechaIngreso = LocalDate.now();
	}

	public Profesional(String nombre, LocalDate fechaNacimiento, int run, String titulo, LocalDate fechaIngreso) {
		super(nombre, fechaNacimiento, run);
		this.titulo = (titulo != null) ? titulo : "Sin título";
		this.fechaIngreso = (fechaIngreso != null) ? fechaIngreso : LocalDate.now();
	}

	/**
	 * Analiza el usuario profesional y devuelve una descripción con todos sus
	 * datos.
	 * 
	 * @return Información detallada del profesional.
	 */

	@Override
	public String analizarUsuario() {
		// Usamos StringBuilder para construir la cadena de salida
		StringBuilder sb = new StringBuilder();

		// Primero agregamos lo que mostraría el método padre
		sb.append(super.analizarUsuario());

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// Agregamos los datos específicos del profesional
		sb.append("Titulo: ").append(this.titulo).append("\n");
		sb.append("Fecha de ingreso: ").append(this.fechaIngreso.format(formatter)).append("\n");
		return sb.toString();
	}

	
	
	// Getters y Setters con validaciones
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if (titulo != null && !titulo.isBlank()) {
			this.titulo = titulo;
		}
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		if (fechaIngreso != null) {
			this.fechaIngreso = fechaIngreso;
		}
	}

	@Override
	public String toString() {
		return "Profesional [titulo=" + titulo + ", fechaIngreso=" + fechaIngreso + "]";
	}

}
