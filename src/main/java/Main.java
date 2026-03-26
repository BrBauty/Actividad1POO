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
    // Esta pausa se usa para que la persona alcance a leer el mensaje antes de continuar.
    public static void pausa(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Presione ENTER para continuar");
        sc.nextLine();
    }

    public static void main(String[] args) {
        // Variable de control para mantener vivo el menu hasta que se elija salir.
        boolean salir = false;
        // Scanner principal para capturar todas las entradas de consola.
        Scanner sc = new Scanner(System.in);
        // Se crea una agenda vacia al iniciar la aplicacion.
        Agenda agenda = new Agenda();
        // Variable auxiliar para capturar nombres completos en operaciones de busqueda/eliminacion.
        String nombreYApellidos;
        // Id temporal que guarda la posicion encontrada dentro del arreglo de contactos.
        int id;
        // Referencia temporal para mostrar un contacto encontrado.
        Contacto temp;
        // Opcion del menu seleccionada por la persona usuaria.
        int opcion;

        // Bucle principal del sistema: se repite hasta que "salir" sea verdadero.
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

            // Validacion simple del rango permitido en el menu.
            if(opcion<1 || opcion>5){
                System.out.println("[ERROR] Ingrese una opcion valida.");
                pausa();
            }

            // Cada case representa una accion concreta del menu principal.
            switch (opcion){
                case 1:
                    System.out.println("----------AGREGAR CONTACTO----------");
                    // Se solicita el nombre completo en un solo campo para simplificar el registro.
                    System.out.print("Ingresar Nombre y Apellidos: "); String nombreCompleto=sc.nextLine();
                    System.out.print("Ingresar Correo Electronico: "); String correo=sc.nextLine();
                    System.out.print("Ingresar Telefono: "); String numero=sc.nextLine();
                    System.out.print("Ingresar Fecha de Cumpleaños: "); String cumple=sc.nextLine();

                    // Se construye el objeto y luego se intenta guardar en la agenda.
                    Contacto contacto = new Contacto(nombreCompleto,correo,numero,cumple);
                    System.out.print("Contacto Creado"); pausa();
                    boolean verificacion=agenda.agregarContacto(contacto);

                    // Se informa resultado segun la validacion de capacidad y duplicados.
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
                    // Se captura la llave de busqueda tal como fue almacenada: nombre completo.
                    System.out.print("Ingrese el nombre y apellidos del contacto a buscar: "); nombreYApellidos=sc.nextLine();
                    id=agenda.buscarContacto(nombreYApellidos);

                    // Si no se encuentra, se avisa; si se encuentra, se imprime su informacion.
                    if(id==-1){
                        System.out.println("[ERROR] Contacto no encontrado");
                        pausa();
                    }else{
                        // Como Contacto no tiene setters, podemos usar la referencia directa sin riesgo de cambios.
                        temp= agenda.retornarContacto(id);
                        System.out.println("Contacto encontrado exitosamente");
                        pausa();

                        // Se imprime el detalle completo del contacto encontrado.
                        System.out.println("Nombre y Apellidos: "+temp.getNombreYApellidos());
                        System.out.println("Correo: "+temp.getCorreoElectronico());
                        System.out.println("Telefono: "+temp.getTelefono());
                        System.out.println("Fecha de Cumpleaños: "+temp.getFechaCumple());
                        pausa();
                    }
                    break;
                case 3:
                    System.out.println("----------ELIMINAR CONTACTO----------");
                    System.out.print("Ingrese el nombre y apellidos del contacto a eliminar: ");
                    nombreYApellidos = sc.nextLine();

                    // Mensaje de salida segun si el contacto existia o no.
                    if(!agenda.eliminarContacto(nombreYApellidos)){
                        System.out.println("[ERROR] Contacto no encontrado");
                        pausa();
                    }else{
                        System.out.println("Contacto eliminado exitosamente");
                        pausa();
                    }
                    break;
                case 4:
                    // Consultamos cuantos contactos hay para decidir si se lista o se muestra mensaje vacio.
                    int cantidad = agenda.getContadorContactos();
                    if (cantidad == 0) {
                        System.out.println("No existen Contactos registrados en la agenda...");
                        pausa();
                    } else {
                        // Recorremos contacto por contacto para imprimir toda la agenda.
                        for (int i = 0; i < cantidad; i++) {
                            Contacto actual = agenda.retornarContacto(i);
                            System.out.println("-----CONTACTO #" + (i + 1) + "-----");
                            System.out.println("Nombre y Apellidos: " + actual.getNombreYApellidos());
                            System.out.println("Correo: " + actual.getCorreoElectronico());
                            System.out.println("Telefono: " + actual.getTelefono());
                            System.out.println("Fecha de Cumpleaños: " + actual.getFechaCumple());
                        }
                    }
                    break;
                case 5:
                    salir=true;
                    break;
            }
        }while(!salir);

        // Mensaje final para indicar cierre normal del sistema.
        System.out.println("Salida Exitosa");
        pausa();
    }
}