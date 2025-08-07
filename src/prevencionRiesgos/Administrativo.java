package prevencionRiesgos;

public class Administrativo extends Usuario {
    // Atributos
    private String area; // entre 5 y 20 caracteres
    private String expPrevia; // menor a 100 caracteres

    // Constructores
    public Administrativo(String area, String expPrevia) {
        this.area = validarArea(area);
        this.expPrevia = validarExpPrevia(expPrevia);
    }

    public Administrativo() {}

    // Getters
    public String getArea() {return area;}

    public String getExpPrevia() {return expPrevia;}

    // Setters
    public void setArea(String area) {this.area = validarArea(area);}

    public void setExpPrevia(String expPrevia) {this.expPrevia = validarExpPrevia(expPrevia);}

    // Métodos
    private String validarArea(String area) {
        if (area != null && area.length() >= 5 && area.length() <= 20) {
            return area;
        } else {
            throw new IllegalArgumentException("El área debe tener entre 5 y 20 caracteres y no ser nula.");
        }
    }

    private String validarExpPrevia(String expPrevia) {
        if (expPrevia == null || expPrevia.isEmpty() || expPrevia.length() > 100) {
            throw new IllegalArgumentException("Experiencia inválida: debe ser no nula y menor o igual a 100 caracteres.");
        }
        return expPrevia;
    }

    // Método toString
    @Override
    public String toString() {
        return String.format("Área: %s, Experiencia previa: %s", area, expPrevia);
    }

    // Método analizarUsuario
    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println(String.format("Área: %s%nExperiencia previa: %s", area, expPrevia));
    }
}
