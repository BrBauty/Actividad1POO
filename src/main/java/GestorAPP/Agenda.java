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
public class Agenda {
    private Contacto[] contactos;
    private int contadorContactos;
    public Agenda() {
        contactos=new Contacto[20];
        contadorContactos=0;
    }

    public int getContadorContactos() {
        return contadorContactos;
    }
    public boolean agregarContacto(Contacto contacto){
        if(contadorContactos==20 || buscarContacto(contacto.getNombre())!=-1){
            return false;
        }else{
            contactos[contadorContactos++]=contacto;
            return true;
        }
    }
    public int buscarContacto(String nombre){
        if(contadorContactos==0){
            return -1;
        }else{
            for(int i=0;i<contadorContactos;i++){
                if(contactos[i].getNombre().equals(nombre)){
                    return i;
                }
            }
            return -1;
        }

    }
    public Contacto retornarContacto(int indice){
     return contactos[indice];
    }
    public boolean eliminarContacto(String nombre){
        int id=buscarContacto(nombre);
        if(id==-1){
            return false;
        }else{
            for(int j=id;j<contadorContactos-1;j++){
                contactos[j]=contactos[j+1];
            }
            contactos[--contadorContactos]=null;
            return true;
        }
    }
}
