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
//		myObjectList.removeIf(obj -> obj.getName().equals("Beta"));	//ejemplo
		this.asesorias.removeIf(ase -> ((Usuario) ase).getRun() == run);
	}
	
	/**
	 * 
	 * @return lista de todos los usuarios
	 */
	public ArrayList<Asesoria> listarUsuarios() {
//		ArrayList<Usuario> a = new ArrayList<>();
		return getAsesorias();
	}
	/**
	 * 
	 * @param tipoUsuario nombre del tipo de Usuario que se desea obtener,
	 * corresponde al nombre de la sub-clase especifica de Usuario (Administrativo,
	 *  Cliente, Profesional).
	 * @return ArrayList con los Usuarios que coinciden con el tipo solicitado.
	 */
	public ArrayList<Usuario> listarUsuariosPorTipo(String tipoUsuario) {
		ArrayList<Usuario> subListado = new ArrayList<>();
		for( Asesoria usuario : this.asesorias) {
				if ( usuario.getClass().toString().equals(tipoUsuario.trim()) ) {					
					subListado.add((Usuario)usuario);
				}
		}
		return subListado;
	}
	
	public ArrayList<Capacitacion> listarCapacitaciones () {
		return getCapacitaciones();
	}
	/**
	 * @return un Array con el listado de metodos disponibles 
	 */
	public String[] metodos() {
		String[] lista= {"almacenarCliente",
						"almacenarProfesional",
						"almacenarAdministrativo",
						"almacenarCapacitacion",
						"eliminarUsuario",
						"listarUsuarios",
						"listarUsuariosPorTipo",
						"listarCapacitaciones"};
		return lista;
	}
//------------- Metodos -----------------:end
//------------- Getter & Setter -----------------:start
	public ArrayList<Asesoria> getAsesorias() {
		return asesorias;
	}

	public void setAsesorias(ArrayList<Asesoria> asesorias) {
		this.asesorias = asesorias;
	}

	public ArrayList<Capacitacion> getCapacitaciones() {
		return capacitaciones;
	}

	public void setCapacitaciones(ArrayList<Capacitacion> capacitaciones) {
		this.capacitaciones = capacitaciones;
	}
//------------- Getter & Setter -----------------:end
}
