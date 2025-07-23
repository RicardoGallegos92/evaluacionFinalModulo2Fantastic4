package prevencionRiesgos;
import java.time.LocalDate;
import java.time.Period;

public class Usuario implements Asesoria{
	private String nombre;
	private LocalDate fechaNacimiento;
	private int run;
	
	public Usuario() {
		setNombre(null);
		setFechaNacimiento( LocalDate.of(1900, 1, 1) );
		setRun(0);
	}
	
	public Usuario(String nombre, LocalDate fechaNacimiento, int run) {
		setNombre(nombre);
		setFechaNacimiento(fechaNacimiento);
		setRun(run);
	}

	public String toString() {
		return String.format("%s, %s, %s", getNombre(), getFechaNacimiento(), getRun());
	}
	
	public String mostrarEdad() {
		return String.format("El usuario tiene %d años", calcularEdad());
	}
	
	private boolean validarRun(int run) {
		String FORMATO_RUN = "\\d{6,8}";
		return Integer.toString(run).matches(FORMATO_RUN);
	}
	
	private boolean validarNombre(String nombre) {
		String FORMATO_NOMBRE = "[a-z A-Z]{10,50}";
		return nombre.matches(FORMATO_NOMBRE);
	}
	
	private boolean validarFecha() {
	/*
		LocalDate fecha = LocalDate.of(2000, 4, 15);
		System.out.println(fecha);
	 */
		int dias = Period.between(getFechaNacimiento(), LocalDate.of(1900, 1, 1)).getDays();
		return dias == 0 ? true: false;
	}
	
	private int calcularEdad() {
		//LocalDate fecha = LocalDate.now() - this.fechaNacimiento;
		Period periodo = Period.between(getFechaNacimiento(), LocalDate.now());
//		System.out.println(periodo.getYears());
		return periodo.getYears();
	}

	@Override
	public String analizarUsuario() {		
		return String.format("Nombre: %s\nRUN: %s",getNombre(), getRun());
	}
//------------- Getter & Setter -----------------:start
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if ( validarNombre(nombre) ) {			
			this.nombre = nombre;
		}else {
			//invalido - se usa valor por defecto - invocar algun aviso
			this.nombre = null;
		}
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getRun() {
		return run;
	}

	public void setRun(int run) {
		if ( validarRun(run) ) {
			this.run = run;
		}else {
			//invalido - se usa valor por defecto - invocar algun aviso
			this.run = 0;
		}
	}
}
//------------- Getter & Setter -----------------:end