import GestorAPP.Agenda;
import GestorAPP.Contacto;

import java.util.Scanner;

/************************************************************************
 Palabra de honor:
 *     No he discutido ni mostrado el código de mi programa con alguien que no sea mi compañero,
 *     Profesor o con el monitor asignado a este curso.
 *
 *     No he utilizado código obtenido de otro u otros estudiantes,
 *     O cualquier otra fuente no autorizada, ya sea modificado o sin modificar.
 *
 *    Si cualquier código o documentación utilizada en mi programa
 *    Fue obtenido de otra fuente, tal como un libro de texto o notas del curso
 *    debe ser claramente señalado con una cita apropiada en
 *    los comentarios de mi programa.
 *
 *    <Breyner Bautista Lozada – 0222510015> *
 *    <Daniel Esteban Borré Caro  – 0222510016> *
 ************************************************** *********************/
public class Main {
    public static void pausa(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Presione ENTER para continuar");
        sc.nextLine();
    }
    public static void main(String[] args) {
        boolean salir = false;
        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();
        String nombre;
        int id;
        Contacto temp;
        int opcion;
        do{
            System.out.println("----------ADMINISTRADOR DE AGENDA----------");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto por nombre");
            System.out.println("3. Eliminar Contacto Existente");
            System.out.println("4. Mostrar Todos los contactos Almacenados");
            System.out.println("5. Salir");
            System.out.print("Elija una de las opciones [1-5] para continuar: ");
            opcion=sc.nextInt();
            sc.nextLine();
            if(opcion<1 || opcion>5){
                System.out.println("[ERROR] Ingrese una opcion valida.");
                pausa();
            }
            switch (opcion){
                case 1:
                    System.out.println("----------AGREGAR CONTACTO----------");
                    System.out.print("Ingresar Nombre: "); String name=sc.nextLine();
                    System.out.print("Ingresar Apellidos: "); String apellidos=sc.nextLine();
                    System.out.print("Ingresar Correo Electronico: "); String correo=sc.nextLine();
                    System.out.print("Ingresar Telefono: "); String numero=sc.nextLine();
                    System.out.print("Ingresar Fecha de Cumpleaños: "); String cumple=sc.nextLine();
                    Contacto contacto = new Contacto(name, apellidos,correo,numero,cumple);
                    System.out.print("Contacto Creado"); pausa();
                    boolean verificacion=agenda.agregarContacto(contacto);
                    if(verificacion){
                        System.out.println("Contacto agregado exitosamente");
                        pausa();
                    }else{
                        System.out.println("[ERROR] Contacto ya existente o No hay espacio en la agenda para más contactos...");
                        pausa();
                    }
                    break;
                case 2:
                    System.out.println("----------MOSTRAR CONTACTO----------");
                    System.out.print("Ingrese el nombre del contacto a buscar: "); nombre=sc.nextLine();
                    id=agenda.buscarContacto(nombre);
                    if(id==-1){
                        System.out.println("[ERROR] Contacto no encontrado");
                        pausa();
                    }else{
                        temp= new Contacto(agenda.retornarContacto(id));
                        System.out.println("Contacto encontrado exitosamente");
                        pausa();
                        System.out.println("Nombre: "+temp.getNombre());
                        System.out.println("Apellidos: "+temp.getApellidos());
                        System.out.println("Correo: "+temp.getCorreoElectronico());
                        System.out.println("Telefono: "+temp.getTelefono());
                        System.out.println("Fecha de Cumpleaños: "+temp.getFechaCumple());
                        pausa();
                    }
                    break;
                case 3:
                    System.out.println("----------ELIMINAR CONTACTO----------");
                    System.out.print("Ingrese el nombre del contacto a eliminar: ");
                    nombre = sc.nextLine();
                    if(!agenda.eliminarContacto(nombre)){
                        System.out.println("[ERROR] Contacto no encontrado");
                        pausa();
                    }else{
                        System.out.println("Contacto eliminado exitosamente");
                        pausa();
                    }
                    break;
                case 4:
                    System.out.println("----------MOSTRAR TODOS LOS CONTACTOS----------");
                    Contacto[] copia=agenda.getContactos();
                    int copiaContador=agenda.getContadorContactos();
                    if(copiaContador==0){
                        System.out.println("No existen Contactos registrados en la agenda...");
                        pausa();
                    }else{
                        for(int i=0;i<copiaContador;i++){
                            System.out.println("-----CONTACTO #"+(i+1)+"-----");
                            System.out.println("Nombre: "+copia[i].getNombre());
                            System.out.println("Apellidos: "+copia[i].getApellidos());
                            System.out.println("Correo: "+copia[i].getCorreoElectronico());
                            System.out.println("Telefono: "+copia[i].getTelefono());
                            System.out.println("Fecha de Cumpleaños: "+copia[i].getFechaCumple());
                        }
                    }
                    break;
                case 5:
                    salir=true;
                    break;
            }
        }while(!salir);
        System.out.println("Salida Exitosa");
        pausa();
    }
}