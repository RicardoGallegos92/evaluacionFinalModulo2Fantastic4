package prevencionRiesgos;

public class Principal {
	Contenedor contenedor;
//------------- Constructores -----------------:start
	public Principal() {
		this.contenedor = null;
	}
	public Principal(Contenedor contenedor) {
		this.contenedor = contenedor;
	}
//------------- Constructores -----------------:end
//------------- Metodos -----------------:start

//------------- Metodos -----------------:end
//------------- Getter & Setter -----------------:start
	public Contenedor getContenedor() {
		return contenedor;
	}
	public void setContenedor(Contenedor contenedor) {
		this.contenedor = contenedor;
	}
//------------- Getter & Setter -----------------:end
}
