
public class Vendedor {
    // Atributos
    private String idvendedor;
    private String nombre;
    private String email;
    private String departamento;
    private boolean activo;

    // --- Getter para idvendedor (Corregido el tipo de retorno a String) ---
    public String getIdvendedor() {
        return idvendedor;
    }

    // --- Setter para idvendedor (Agregada la llave de cierre faltante) ---
    public void setIdvendedor(String idvendedor) {
        this.idvendedor = idvendedor;
    }

    // --- Getter y Setter para nombre ---
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacío");
            return;
        }
        this.nombre = nombre;
    }

    // 
    public String getEmail() {
        return email;
    }

    // --- Setter para email (La validación va en el setter, no en el getter) ---
    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            System.out.println("El correo no es válido");
        }
    }

    // --- Getters y Setters para departamento y activo ---
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}