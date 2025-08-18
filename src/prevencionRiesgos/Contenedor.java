package prevencionRiesgos;

import java.util.ArrayList;

public class Contenedor {
	ArrayList<Usuario> asesorias;
	ArrayList<Capacitacion> capacitaciones;
//------------- Constructores -----------------:start
	public Contenedor() {
		setAsesorias(null);
		setCapacitaciones(null);
	}
	
	public Contenedor(ArrayList<Usuario> asesorias,
				ArrayList<Capacitacion> capacitaciones) {
		setAsesorias(asesorias);
		setCapacitaciones(capacitaciones);
	}
//------------- Constructores -----------------:end
//------------- Metodos -----------------:start
	private void almacenarAsesoria(Usuario asesoria) {
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
	public ArrayList<Usuario> listarUsuarios() {
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
		for( Usuario usuario : this.asesorias) {
			// Comparamos el nombre de la clase sin el paquete
			String simpleName = usuario.getClass().getSimpleName().toLowerCase();
			if (simpleName.equals(tipoUsuario.toLowerCase().trim())) {
				subListado.add(usuario);
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
	public ArrayList<Usuario> getAsesorias() {
		return asesorias;
	}

	public void setAsesorias(ArrayList<Usuario> asesorias) {
		if (asesorias == null){
			this.asesorias = new ArrayList<>();
		}
		else{
			this.asesorias = asesorias;
		}
	}

	public ArrayList<Capacitacion> getCapacitaciones() {
		return capacitaciones;
	}

	public void setCapacitaciones(ArrayList<Capacitacion> capacitaciones) {
		if (capacitaciones == null){
			this.capacitaciones = new ArrayList<>();
		}
		else{
			this.capacitaciones = capacitaciones;
		}
	}
//------------- Getter & Setter -----------------:end
}
