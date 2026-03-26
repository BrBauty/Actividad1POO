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
    // Arreglo fijo para almacenar los contactos; la capacidad maxima del ejercicio es 20.
    private Contacto[] contactos;
    // Lleva el conteo de las posiciones realmente ocupadas dentro del arreglo.
    private int contadorContactos;

    // Inicializa la agenda vacia con espacio para 20 contactos.
    public Agenda() {
        contactos=new Contacto[20];
        contadorContactos=0;
    }

    // Permite saber cuantos contactos hay guardados en este momento.
    public int getContadorContactos() {
        return contadorContactos;
    }

    // Agrega un contacto solo si hay espacio y si no existe otro con el mismo nombre completo.
    public boolean agregarContacto(Contacto contacto){
        if(contadorContactos==20 || buscarContacto(contacto.getNombreYApellidos())!=-1){
            return false;
        }else{
            // Se inserta en la siguiente posicion libre y luego se incrementa el contador.
            contactos[contadorContactos++]=contacto;
            return true;
        }
    }

    // Busca la posicion de un contacto por nombre completo; retorna -1 si no lo encuentra.
    public int buscarContacto(String nombreYApellidos){
        if(contadorContactos==0){
            return -1;
        }else{
            // Recorremos solo la parte ocupada del arreglo, no todo el arreglo completo.
            for(int i=0;i<contadorContactos;i++){
                if(contactos[i].getNombreYApellidos().equals(nombreYApellidos)){
                    return i;
                }
            }
            return -1;
        }

    }

    // Devuelve el contacto en la posición solicitada.
    public Contacto retornarContacto(int indice){
     return contactos[indice];
    }

    // Elimina un contacto encontrado por nombre completo y compacta el arreglo para no dejar huecos.
    public boolean eliminarContacto(String nombreYApellidos){
        int id=buscarContacto(nombreYApellidos);
        if(id==-1){
            return false;
        }else{
            // Corrimiento a la izquierda: cada contacto toma el lugar del anterior.
            for(int j=id;j<contadorContactos-1;j++){
                contactos[j]=contactos[j+1];
            }
            // Se limpia la última posición ocupada y se ajusta el contador.
            contactos[--contadorContactos]=null;
            return true;
        }
    }
}
