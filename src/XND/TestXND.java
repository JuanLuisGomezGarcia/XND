
package XND;


import static XND.FuncionesEmpleados.*;
import static XND.FuncionesHistorial.*;
import static XND.FuncionesIncidencias.*;
import java.io.File;
import static XND.Gestor.*;
import static XND.Utilidades.pedirInt;



public class TestXND{
    public static void main(String[] args) throws Exception {
    //Variables para coneectar los archivos a la base de datos en cualquier sistema
    String rutaProyecto =  System.getProperty( "user.dir" );  
    String separador =  System.getProperty( "file.separator" );
        
    Gestor a = new Gestor();
    //En caso de que la coleccion no exista se creara y se introducirar los archivos xml necesarios
    int claveInsertarDatos = conectarBD();
    if(claveInsertarDatos==-1){
    crearColeccion();
    conectarBD();
    File archivoIncidencia = new File(rutaProyecto + separador +  "src"  + separador +  "incidencias.xml" );
    File archivoEmpleado = new File(rutaProyecto + separador +  "src"  + separador +  "empleado.xml" );
    File archivoHistorial = new File(rutaProyecto + separador +  "src"  + separador +  "historial.xml" );
    asignarRecursosDB(archivoIncidencia);   asignarRecursosDB(archivoEmpleado);   asignarRecursosDB(archivoHistorial);
    System.out.println("Base de datos creada");} System.out.println("CONEXION ESTABLECIDA");

   //Variable que usaran los distintos menus en su switch y do while
    int numeroMenu = 0;
    int numeroMenuUsuario = 0;
    int numeroMenuIncidencia = 0;
    int numeroMenuHistorial = 0;
    //MENU DE LA ACTIVIDAD
    do{
        //MENU CENTRAL    
        System.out.println("1.GESTION USUARIOS\n" +
        "2.GESTION INCIDENCIAS\n" +
        "3.GESTION HISTORIAL\n" +
        "0 Salir.");
        numeroMenu = pedirInt();    
        switch(numeroMenu){
        case 1:
            //Menu empleado
            do{
            System.out.println("1.Insertar un empleado nuevo en la B.D.\n" +
            "2.Validar la entrada de un empleado (suministrando usuario y contraseña)\n" +
            "3.Modificar el perfil de un empleado existente.\n" +
            "4.Cambiar la contraseña de un empleado existente.\n" +
            "5.Eliminar un empleado.\n" +
            "0 Salir.");
            numeroMenuUsuario = pedirInt();
            switch(numeroMenuUsuario){
            case 1: insertarEmpleado();
                break;
            case 2: logginUsuario();
                break;
            case 3: modificarEmpleado();
                break;
            case 4: modificarPassword();
                break;
            case 5: eliminarEmpleado();
                break;
            case 0: System.out.println("MENU USUARIOS CERRADO");
                break; }
            }while(!(numeroMenuUsuario == 0));
        break;
        case 2:
            //Menu incidencias
            do{
            System.out.println("1.Obtener un objeto Incidencia a partir de su Id.\n" +
            "2.Obtener la lista de todas las incidencias.\n" +
            "3.Insertar una incidencia.\n" +
            "4.Obtener las incidencias para un empleado a partir de un objeto de clase Empleado.\n" +
            "5.Obtener las incidencias creadas por un empleado concreto.\n" + 
            "0.Salir");
            numeroMenuIncidencia = pedirInt();
            switch(numeroMenuIncidencia){
            case 1: incidencaID();
                break;
            case 2: listaIncidencia();
                break;
            case 3: insertarIncidencia();
                break;
            case 4: obtenerIncidenciaDestinoUsuario();
                break;
            case 5: obtenerIncidenciaOrigenUsuario();
                break;
            case 0: System.out.println("MENU INCIDENCIAS CERRADO");
                break; }
            }while(!(numeroMenuIncidencia == 0));
        break;
        case 3:
            //Menu historial
            do{
            System.out.println("1.Obtener listado de todos los inicios de secion.\n" +
            "2.Obtener un listado de los empleados (nombre de usuario) que han consultado sus incidencias al menos una vez.\n" +
            "3.Obtener el numero de incidencias.\n" +
            "0.Salir");
            numeroMenuHistorial = pedirInt();
            switch(numeroMenuHistorial){
            case 1: listaHistorialInicioSecion();
                break;
            case 2: listaHistorialConsulta();
                break;
            case 3: numeroDeIncidencias();
                break;
            case 0: System.out.println("MENU HISTORIAL CERRADO");
                break; }
            }while(!(numeroMenuHistorial == 0));
        break;}}while(!(numeroMenu == 0)); 
System.out.println("FIN DE PROGRAMA");}}
