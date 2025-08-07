package prevencionRiesgos;

import java.util.ArrayList;

public class Contenedor {
	ArrayList<Asesoria> asesorias;
	ArrayList<Capacitacion> capacitaciones;
//------------- Constructores -----------------:start
	public Contenedor() {
		this.asesorias = null;
		this.capacitaciones = null;
	}
	
	public Contenedor(ArrayList<Asesoria> asesorias,
				ArrayList<Capacitacion> capacitaciones) {
		this.asesorias = asesorias;
		this.capacitaciones = capacitaciones;
	}
//------------- Constructores -----------------:end
//------------- Metodos -----------------:start
	@Override
	public String toString() {
		return "Contenedor: {asesorias=" + asesorias
				+ ", capacitaciones=" + capacitaciones + "}";
	}
	
	private void almacenarAsesoria(Asesoria asesoria) {
		if ( asesoria != null ) {
			this.asesorias.add(asesoria);
		}
	}

	public void almacenarCliente(Cliente cliente){
		almacenarAsesoria(cliente);
	}

	public void almacenarProfesional(Profesional profesional) {
		almacenarAsesoria(profesional);
	}
	
	public void almacenarAdministrativo(Administrativo administrativo) {
		almacenarAsesoria(administrativo);
	}
	
	public void almacenarCapacitacion(Capacitacion capacitacion) {
		if ( capacitacion != null ) {
			this.capacitaciones.add(capacitacion);
		}
	}
	
	public void eliminarUsuario(int run) {
		
	}
	
	public ArrayList<Usuario> listarUsuarios() {
		ArrayList<Usuario> a = new ArrayList<>();
		return a;
	}
	
	public ArrayList<Usuario> listarUsuariosPorTipo() {
		ArrayList<Usuario> a = new ArrayList<>();
		return a;
	}
	
	public ArrayList<Capacitacion> listarCapacitaciones () {
		ArrayList<Usuario> a = new ArrayList<>();
		return a;		
	}
//------------- Metodos -----------------:end
//------------- Getter & Setter -----------------:start
//------------- Getter & Setter -----------------:end
}
