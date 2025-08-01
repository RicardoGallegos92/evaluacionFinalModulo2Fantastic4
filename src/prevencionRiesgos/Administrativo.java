package prevencionRiesgos;



public class Administrativo extends Usuario {
    //atributos
    private String area;// entre 5 y 20 caracteres
    private String expPrevia;// menor a 100 caracteres
    //constructores
    public Administrativo(String area,String expPrevia){
        this.area=validarArea(area);
        this.expPrevia=validarExpPrevia(expPrevia);
    }
    public Administrativo(){}

    //getters
    public String getArea() {
        return area;
    }
    public String getExpPrevia() {return expPrevia;}
    //setters
    public void setArea(String area) {
        this.area = area;
    }
    public void setExpPrevia(String expPrevia) {this.expPrevia = expPrevia;}
    // metodos
    private String validarArea(String area){
        if(area.length() >= 5 && area.length() <= 20 || area!=null){
            return area;
        }else{
            throw new IllegalArgumentException("El área debe tener entre 5-20 caracteres y no ser nulo.");
        }
    }
    private String validarExpPrevia(String expPrevia) {
        if (expPrevia == null || expPrevia.isEmpty() || expPrevia.length() > 100)
            throw new IllegalArgumentException("Experiencia inválida, debe ser menor a 100 caracteres");
        return expPrevia;
    }

    //metodo toString
    @Override
    public String toString() {
        return String.format(getArea(),getExpPrevia());
    }
    // metodo analizarUsuario
    @Override
    public void analizarUsuario() {
        super.analizarUsuario();  // Llama al método del padre para mostrar sus datos
        System.out.println(String.format("Área: %s\nExperiencia previa: %s", getArea(), getExpPrevia()));
    }
}