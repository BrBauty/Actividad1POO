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
    private String nombreYApellidos;
    private String correoElectronico;
    private String telefono;
    private String fechaCumple;

    // Constructor principal: recibe los datos tal como los ingresa la persona usuaria.
    public Contacto(String nombreYApellidos, String email, String telefono, String fechaCumple) {
        this.nombreYApellidos = nombreYApellidos;
        this.correoElectronico = email;
        this.telefono = telefono;
        this.fechaCumple = fechaCumple;
    }


    // Getter del nombre completo en plural para mantener consistencia con el modelo actual.
    public String getNombreYApellidos() {
        return nombreYApellidos;
    }

    // Getter simple para recuperar el correo del contacto.
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    // Getter simple para recuperar el telefono del contacto.
    public String getTelefono() {
        return telefono;
    }

    // Getter simple para recuperar la fecha de cumpleanos del contacto.
    public String getFechaCumple() {
        return fechaCumple;
    }
}
