
package XND;

import static XND.Gestor.consulta;
import static XND.Utilidades.pedirString;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;

public class FuncionesEmpleados {
    

    
    
    
     /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
 
    //ESTA FUNCION DEVUELVE UNA LISTA DE LOS EMPLEADOS EXISTENTES
    public static void listaEmpleado() throws XMLDBException{
    //Generamos la consulta MySQL
    String consulta = "for $dato in doc('empleado.xml')//empleados/empleado/usuario/text() return $dato";
    //Introducimos esa consulta en la funcion que nos devolvera un resulSet
    ResourceSet result = consulta(consulta);
    //Lo pasamos por un Iterator y un while que vaya mostrando casa una de las partes por System
    ResourceIterator iteratorResouce = result.getIterator();
    while(iteratorResouce.hasMoreResources()){
    Resource recurso = iteratorResouce.nextResource();
    System.out.println(recurso.getContent());   }}
   
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
     
    //ELIMINAR EMPLEADO
    public static void eliminarEmpleado() throws XMLDBException{
    //Se obtiene el nombre de usuario
    String nombreUsuario = pedirNombreUsuario();
    System.out.println("Que usuario desea eliminar");
    //Se genera una consulta MySQL y se implementa
    String consulta = "update delete //empleados/empleado[usuario='" + nombreUsuario + "']";
    consulta(consulta);}
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //MODIFICAR EMPLEADO
    public static void modificarEmpleado() throws XMLDBException{
    //Se obtiene el nombre de usuario
    String nombreUsuario = pedirNombreUsuario();
    //Se piden los nuevos valores y se introducen las consultas
    String nuevoNombre = insertarNombreCompleto();
    String consultaNuevoNombre = "update replace /empleados/empleado[usuario='" + nombreUsuario + "' ]/nombre with <nombre>" + nuevoNombre + "</nombre>";
    consulta(consultaNuevoNombre);
    String nuevoPassword = insertarPassword();
    String consultaNuevoPassword  = "update replace /empleados/empleado[usuario='" + nombreUsuario + "' ]/contraseña with <contraseña>" + nuevoPassword + "</contraseña>";
    consulta(consultaNuevoPassword);
    String nuevoTelefono = insertarTelefono();
    String consultaNuevoTelefono = "update replace /empleados/empleado[usuario='" + nombreUsuario + "' ]/telefono with <telefono>" + nuevoTelefono+ "</telefono>";
    consulta(consultaNuevoTelefono);}
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
     
    //MODIFICAR PASSWORD
    public static void modificarPassword() throws XMLDBException{
    String nombreUsuario = pedirNombreUsuario();
    //introducimos el nuevo password
    String nuevoPassword = insertarPassword();
    String consulta = "update replace /empleados/empleado[usuario='" + nombreUsuario + "' ]/contraseña with <contraseña>" + nuevoPassword + "</contraseña>";
    consulta(consulta);}
        

    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //FUNCION PARA PEDIR EL PASSWORD
    public static String insertarPassword(){
    String passwordSeleccionado = "";
    //Es una funcion sensilla pedimos un string con la funcion pedir string y pasamos su tamaño por el while
    //para controlar los requisitos de cantidad de varchar de la base de datos que no han proporcionado
    do{
    System.out.println("Introduce el password recuerda que su tamaño maximo sera de 10 caracteres");
    passwordSeleccionado = pedirString();
    }while(!(passwordSeleccionado.length()<11));
    return passwordSeleccionado;}
    
    //FUNCION PARA PEDIR EL TELEFONO
    public static String insertarTelefono(){
    String telefonoSeleccionado = "";
    //Es una funcion sensilla pedimos un string con la funcion pedir string y pasamos su tamaño por el while
    //para controlar los requisitos de cantidad de varchar de la base de datos que no han proporcionado
    do{
    System.out.println("Introduce el telefono recuerda que su tamaño maximo sera de 9 caracteres");
    telefonoSeleccionado = pedirString();
    }while(!(telefonoSeleccionado.length()<10));
    return telefonoSeleccionado;}
    
    //FUNCION PARA PEDIR EL NOMBRE COMPLETO
    public static String insertarNombreCompleto(){
    String nombreSeleccionado = "";
    //Es una funcion sensilla pedimos un string con la funcion pedir string y pasamos su tamaño por el while
    //para controlar los requisitos de cantidad de varchar de la base de datos que no han proporcionado
    do{
    System.out.println("Introduce el nombre completo recuerda que su tamaño maximo sera de 50 caracteres");
    nombreSeleccionado = pedirString();
    }while(!(nombreSeleccionado.length()<51));
    return nombreSeleccionado;}
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    //FUNCION PARA VERIFICAR QUE LOS USUARIOS EXISTEN
    public static String pedirNombreUsuario() throws XMLDBException{
    listaEmpleado();
    //Gneramos las variables necesarias
    boolean filtro = true;  
    String nombreEmpleado ="";
    String consulta = "for $dato in doc('empleado.xml')//empleados/empleado/usuario/text() return $dato";
    while(filtro){
    System.out.println("INTRODUCE EL NOMBRE DEL USUARIO");
    //pedimo un string
    nombreEmpleado = pedirString();
    //Se crea un objeto ResourceSet donde se almacena la consulta
    ResourceSet result = consulta(consulta);
    ResourceIterator iteratorResouce = result.getIterator(); 
    //recorremos todos los usuarios
    while (iteratorResouce.hasMoreResources()){         
    Resource recurso = iteratorResouce.nextResource();
    //Comparamos el string con los nombres existentes de los usuarios
    if(nombreEmpleado.equals(recurso.getContent())){
    //En caso deque no exista repetimos el bucle
    filtro = false;}}}
    return nombreEmpleado;}  
    
    //FUNCION PARA VERIFICAR EL PASSWORD
    public static void verificarPassword(String nombreUsuario) throws XMLDBException{
    //Gneramos las variables necesarias
    boolean filtro = true;    
    while(filtro){
    System.out.println("INTRODUCE LA CONTRASEÑA");
    //pedimo un string
    String contraseña = pedirString();
    String consulta = "for $dato in doc('empleado.xml')/empleados/empleado where $dato/contraseña='"+contraseña+"' and $dato/usuario='"+nombreUsuario+"' return $dato/contraseña/text()";
    //Se crea un objeto ResourceSet donde se almacena la consulta
    ResourceSet result = consulta(consulta);
    ResourceIterator iteratorResouce = result.getIterator(); 
    //recorremos todos los usuarios
    while (iteratorResouce.hasMoreResources()){         
    Resource recurso = iteratorResouce.nextResource();
    //Comparamos el string con los nombres existentes de los usuarios
    if(contraseña.equals(recurso.getContent())){
    //En caso deque no exista repetimos el bucle
    filtro = false;}}}}  
        /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
   
    
    //FUNCION PARA PEDIR EL NOMBRE DE USUARIO
    public static String insertarNombreUsuario() throws XMLDBException{
    //Creamos lar variables necesarias
    boolean filtro = true;
    System.out.println("INTRODUCE EL NOMBRE DEL USUARIO");
    String nombreEmpleado ="";
    //Creamos la consulta
    String consulta = "for $dato in doc('empleado.xml')//empleados/empleado/usuario/text() return $dato";
    while(filtro){
    filtro = false;
    //pedimo un string
    nombreEmpleado = pedirString();
    //Se crea un objeto ResourceSet donde se almacena la consulta
    ResourceSet result = consulta(consulta);
    ResourceIterator iteratorResouce = result.getIterator(); 
    //recorremos todos los usuarios
    while (iteratorResouce.hasMoreResources()){         
    Resource recurso = iteratorResouce.nextResource();
    //Comparamos el string con los nombres existentes de los usuarios
    if(nombreEmpleado.equals(recurso.getContent())){
    //En caso de que exista repetimos el bucle
    filtro = true;System.out.println("El empleado existe");}}}
    return nombreEmpleado;}  
        
    
    /*-----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
   
    //FUNCION PARA INSERTAR EMPLEADO
    public static void insertarEmpleado() throws XMLDBException{    
    //Pedimos todos los valores necesarios para crear la incidencias a traves de las funciones
    //creadas especificamente en esta clase para este motivo
    String nombreUsuario = insertarNombreUsuario();
    String password = insertarPassword();
    String nombreCompleto = insertarNombreCompleto();
    String telefono = insertarTelefono();                      
    //Introducimos todos los valores en la consulta XQUERY
    String consulta = "update insert <empleado> <usuario>" + nombreUsuario + "</usuario>"
        + "<contraseña>" + password + "</contraseña>"
        + "<nombre>" + nombreCompleto + "</nombre>"
        + "<telefono>" + telefono + "</telefono></empleado> into /empleados";
    consulta(consulta);}
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
   
    //FUNCION PARA PARA LOGGEAR EMPLEADO
    public static void logginUsuario() throws XMLDBException{
    //Llamamos a las funciones necesarias para verificar password y usuario
    String nombreUsuario = pedirNombreUsuario();
    verificarPassword(nombreUsuario);
    //Generamos un historial del inicion de secion
    //Introducimo fecha y hora
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    String format = dtf.format(LocalDateTime.now());
    //Generamos la consulta y la procesamos para intoducir el nuevo historial
    String consultaInsertarHistorial = "update insert <historial> <tipo>" + "I" + "</tipo>"
        + "<fecha-hora>" + format + "</fecha-hora>"
        + "<empleado>" + nombreUsuario + "</empleado></historial> into /historiales";
        consulta(consultaInsertarHistorial); }
    
}
