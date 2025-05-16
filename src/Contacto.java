public class Contacto {
    String nombre;
    String apellido;
    String nuevoTelefono;

    public Contacto() {
    }

    public Contacto(String nombre, String apellido, String nuevoTelefono) {
        if (nombre == null || nombre.trim().isEmpty() ||
                apellido == null || apellido.trim().isEmpty() ||
                nuevoTelefono == null || nuevoTelefono.trim().isEmpty()) {
            System.out.println("Error, Ingrese todos los campos.");
        } else if (!nuevoTelefono.matches("\\d{10}")) {
            System.out.println("Datos incompletos. El número debe tener 10 dígitos.");
        } else {
            this.nombre = nombre.trim();
            this.apellido = apellido.trim();
            this.nuevoTelefono = nuevoTelefono.trim();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        } else {
            System.out.println("Por favor ingrese un nombre");
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido != null && !apellido.trim().isEmpty()) {
            this.apellido = apellido.trim();
        } else {
            System.out.println("Por favor ingrese un apellido");
        }
    }

    public String getNuevoTelefono() {
        return nuevoTelefono;
    }

    public void setNuevoTelefono(String nuevoTelefono) {
        if (nuevoTelefono != null && nuevoTelefono.matches("\\d{10}")) {
            this.nuevoTelefono = nuevoTelefono.trim();
        } else {
            System.out.println("El número ingresado debe tener exactamente 10 dígitos numéricos.");
        }
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + nuevoTelefono;
    }

    public boolean sonIguales(Contacto nuevo){
        if (nuevo == null){
            return false;
        }
        String nombreThis = this.nombre.trim().toLowerCase();
        String apellidoThis = this.apellido.trim().toLowerCase();

        String nombreNuevo = nuevo.nombre.trim().toLowerCase();
        String apellidoNuevo = nuevo.apellido.trim().toLowerCase();

        return nombreThis.equals(nombreNuevo) && apellidoThis.equals(apellidoNuevo);
    }
}
