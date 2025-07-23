package prevencionRiesgos;

import java.time.LocalDate;
import java.time.Period;

public class Usuario implements Asesoria {
	private String nombre;
	private LocalDate fechaNacimiento;
	private int run;

	public Usuario() {
//		this.fechaNacimiento = LocalDate.of(2000, 4, 15);
	}

	public Usuario(String nombre, LocalDate fechaNacimiento, int run) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.run = run;
	}

	public String toString() {
		return String.format("%s, %s, %s", this.nombre, this.fechaNacimiento, this.run);
	}

	public String mostrarEdad() {
		return String.format("El usuario tiene %d años", calcularEdad());
	}

	private String fecha() {
		/*
		 * LocalDate fecha = LocalDate.of(2000, 4, 15); System.out.println(fecha);
		 */
		return "";
	}

	private int calcularEdad() {
		// LocalDate fecha = LocalDate.now() - this.fechaNacimiento;
		Period periodo = Period.between(this.fechaNacimiento, LocalDate.now());
//		System.out.println(periodo.getYears());	
		return periodo.getYears();
	}

	@Override
	public String analizarUsuario() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre: ").append(this.nombre).append("\n");
		sb.append("Fecha de nacimiento: ").append(this.fechaNacimiento).append("\n");
		sb.append("RUN: ").append(this.run).append("\n");
		return sb.toString();
	}
}
