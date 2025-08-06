package prevencionRiesgos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Accidente{
    private int id;         // +
    private int rutCliente; // valido
    private LocalDate dia;  //[DD/MM/AAAA]
    private LocalDate hora;  //[HH:MM]
    private String lugar;   //[10,50]
    private String origen;  //[1,100]

//------------- Constructores -----------------:start
    public Accidente(){
    	setId(-1);
    	setRutCliente(0);
    	setDia(LocalDate.now());
    	setHora(LocalDate.now());
    	setLugar(null);
    	setOrigen(null);
    }

	public Accidente(int id, int rutCliente, LocalDate dia, LocalDate hora, String lugar, String origen) {
		setId(id);
    	setRutCliente(rutCliente);
    	setDia(dia);
    	setHora(hora);
    	setLugar(lugar);
    	setOrigen(origen);
	}
//------------- Constructores -----------------:end

//------------- Metodos -----------------:start
	public String toString() {
		return String.format("Accidente:"
				+ "\nID: %d"
				+ "\nRut Cliente: %d"
				+ "\nDia: %s"
				+ "\nHora: %s"
				+ "\nLugar: %s"
				+ "\nOrigen: %s"
				, getId(), getRutCliente(), getDia(), getHora(), getLugar(), getOrigen()
			);
	}

	private boolean validarRun(int run) {
		String FORMATO_RUN = "\\d{6,8}";
		return Integer.toString(run).matches(FORMATO_RUN);
	}
	
	private boolean validarLargoTexto(String texto, int min, int max) {
		String FORMATO_TEXTO = String.format("[a-z A-Z0-9]{%d,%d}",min,max);
		if (texto == null) {
			//throwError
			return false;
		}
		return texto.matches(FORMATO_TEXTO);
	}
//------------- Metodos -----------------:end

//------------- Getter & Setter -----------------:start

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(int run) {
		if ( validarRun(run) ) {
			this.rutCliente = run;
		}else {
			//invalido - se usa valor por defecto - invocar algun aviso
			this.rutCliente = 0;
		}
	}

	public String getDia() {
		DateTimeFormatter DDMMAAAA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.dia.format(DDMMAAAA);
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public String getHora() {
		DateTimeFormatter HHMM = DateTimeFormatter.ofPattern("HH:mm");
        return this.hora.format(HHMM);
	}

	public void setHora(LocalDate hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		final int LARGO_MINIMO = 10;
		final int LARGO_MAXIMO = 50;
		if ( validarLargoTexto(lugar, LARGO_MINIMO, LARGO_MAXIMO) ) {
			this.lugar = lugar;
		}
		//throwError
		this.lugar = null;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		final int LARGO_MINIMO = 1;
		final int LARGO_MAXIMO = 100;
		if ( validarLargoTexto(origen, LARGO_MINIMO, LARGO_MAXIMO) ) {
			this.origen = origen;
		}
		//throwError
		this.origen = null;
	}	
//------------- Getter & Setter -----------------:end
}