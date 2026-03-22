package GestorAPP;
/************************************************************************
 Palabra de honor:
 *     No he discutido ni mostrado el código de mi programa con alguien que no sea mi compañero,
 *     Profesor o con el monitor asignado a este curso.
 *
 *     No he utilizado código obtenido de otro u otros estudiantes,
 *     O cualquier otra fuente no autorizada, ya sea modificado o sin modificar.
 *
 *     Si cualquier código o documentación utilizada en mi programa
 *    Fue obtenido de otra fuente, tal como un libro de texto o notas del curso
 *    debe ser claramente señalado con una cita apropiada en
 *    los comentarios de mi programa.
 *
 *    <Breyner Bautista Lozada – 0222510015> *
 *    <Daniel Esteban Borré Caro – 0222510016> *
 ************************************************** *********************/
public class Contacto {
    private String nombre;
    private String apellidos;
    private String correoElectronico;
    private String telefono;
    private String FechaCumple;
    public Contacto(String nombre, String apellidos, String email, String telefono, String fechaCumple) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = email;
        this.telefono = telefono;
        this.FechaCumple = fechaCumple;
    }

    public Contacto(Contacto contacto) {
        this.nombre = contacto.getNombre();
        this.apellidos = contacto.getApellidos();
        this.correoElectronico = contacto.getCorreoElectronico();
        this.telefono = contacto.getTelefono();
        this.FechaCumple = contacto.getFechaCumple();
    }

    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getFechaCumple() {
        return FechaCumple;
    }
}
