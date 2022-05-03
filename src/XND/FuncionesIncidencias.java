
package XND;
import static XND.FuncionesEmpleados.pedirNombreUsuario;
import static XND.Gestor.consulta;
import static XND.Utilidades.pedirInt;
import static XND.Utilidades.pedirString;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
public class FuncionesIncidencias {

    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
     //ESTA FUNCION MUESTRA LA INCIDENCIA INDICADA POR EL ID
    public static void incidencaID() throws XMLDBException{
    //Generamos la consulta MySQL
    int clave = 0;
    System.out.println("Introduce id de la incidencia");
    int idIncidencia = pedirInt();
    String consulta = "for $dato in doc('incidencias.xml')/incidencias/incidencia where $dato/id='" + idIncidencia + "' return $dato/*/text()";
    //Introducimos esa consulta en la funcion que nos devolvera un resulSet
    ResourceSet result = consulta(consulta);
    //Lo pasamos por un Iterator y un while que vaya mostrando cada una de las partes por el System
    ResourceIterator iteratorResouce = result.getIterator();
    if(iteratorResouce.hasMoreResources()){
    while(iteratorResouce.hasMoreResources()){   
    Resource recurso = iteratorResouce.nextResource();
        switch(clave){
        case 0:System.out.println("Tipo: " + recurso.getContent());clave++;break;
        case 1:System.out.println("detalle : " + recurso.getContent());clave++;break;
        case 2:System.out.println("origen: " + recurso.getContent());clave++;break;
        case 3:System.out.println("destino: " + recurso.getContent());clave++;break;
        case 4:System.out.println("id: " + recurso.getContent());clave++;break;
        case 5:System.out.println("Fecha creacion: " + recurso.getContent());clave = 0;break;}}}
    else{System.out.println("El id no pertenece a ninguna incidencia");}}
    
    //ESTA FUNCION MUESTRA LA LISTA DE INCIDENCIA
    public static void listaIncidencia() throws XMLDBException{
    //Generamos la consulta MySQL
    int clave = 0;
    String consulta = "for $dato in doc('incidencias.xml')//incidencias/incidencia/*/text() return $dato";
    //Introducimos esa consulta en la funcion que nos devolvera un resulSet
    ResourceSet result = consulta(consulta);
    //Lo pasamos por un Iterator y un while que vaya mostrando cada una de las partes por el System
    ResourceIterator iteratorResouce = result.getIterator();
    while(iteratorResouce.hasMoreResources()){   
    Resource recurso = iteratorResouce.nextResource();
        switch(clave){
        case 0:System.out.println("Tipo: " + recurso.getContent());clave++;break;
        case 1:System.out.println("detalle : " + recurso.getContent());clave++;break;
        case 2:System.out.println("origen: " + recurso.getContent());clave++;break;
        case 3:System.out.println("destino: " + recurso.getContent());clave++;break;
        case 4:System.out.println("id: " + recurso.getContent());clave++;break;
        case 5:System.out.println("Fecha creacion: " + recurso.getContent() + "\n");clave = 0;break;}}}
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    //ESTA FUNCION OBTIENE LAS INCIDENCIA DE ORIGEN USUARIO
    public static void obtenerIncidenciaOrigenUsuario() throws XMLDBException{
    //Obtenemos el usuario seleccionado
    int clave = 0;
    String nombreUsuario = pedirNombreUsuario();
    //Generamos la consulta MySQL
    String consulta = "for $dato in doc('incidencias.xml')/incidencias/incidencia where $dato/origen='"+nombreUsuario+"' return $dato/*/text()";
    //Introducimos esa consulta en la funcion que nos devolvera un resulSet
    ResourceSet result = consulta(consulta);
    //Lo pasamos por un Iterator y un while que vaya mostrando cada una de las partes por System
    ResourceIterator iteratorResouce = result.getIterator();
    while(iteratorResouce.hasMoreResources()){   
    Resource recurso = iteratorResouce.nextResource();
    switch(clave){
        case 0:System.out.println("Tipo: " + recurso.getContent());clave++;break;
        case 1:System.out.println("detalle : " + recurso.getContent());clave++;break;
        case 2:System.out.println("origen: " + recurso.getContent());clave++;break;
        case 3:System.out.println("destino: " + recurso.getContent());clave++;break;
        case 4:System.out.println("id: " + recurso.getContent());clave++;break;
        case 5:System.out.println("Fecha creacion: " + recurso.getContent() + "\n");clave = 0;break;}   }}
    
    //ESTA FUNCION OBTIENE LAS INCIDENCIA DE DESTINO USUARIO
    public static void obtenerIncidenciaDestinoUsuario() throws XMLDBException{
    //Obtenemos el usuario seleccionado
    int clave = 0;
    List<Incidencia> listaIncidenciaOrigenEmpleado1 = new ArrayList<>(); 
    Empleado empleado = new Empleado(); 
    Incidencia incidencia = new Incidencia();
    String nombreUsuario = pedirNombreUsuario();
    empleado = crearObjetoEmpleado(nombreUsuario);
    empleado.setIncidenciasDestino(listaIncidenciaOrigenEmpleado1);
    List listaIncidencias = empleado.getIncidenciasDestino();
    //Generamos la consulta MySQL
    String consulta = "for $dato in doc('incidencias.xml')/incidencias/incidencia where $dato/destino='"+nombreUsuario+"' return $dato/*/text()";
    //Introducimos esa consulta en la funcion que nos devolvera un resulSet
    ResourceSet result = consulta(consulta);
    //Lo pasamos por un Iterator y un while que vaya mostrando cada una de las partes por System
    ResourceIterator iteratorResouce = result.getIterator();
    while(iteratorResouce.hasMoreResources()){   
    Resource recurso = iteratorResouce.nextResource();
    switch(clave){
        case 0: incidencia.setTipo(recurso.getContent().toString());clave++;break;
        case 1:incidencia.setDetalle(recurso.getContent().toString());clave++;break;
        case 2:incidencia.setOrigen(recurso.getContent().toString());clave++;break;
        case 3:incidencia.setDestino(recurso.getContent().toString());clave++;break;
        case 4:Integer id = Integer.valueOf (recurso.getContent().toString());incidencia.setIdincidencia(id);clave++;break;
        case 5:incidencia.setFechaHora(recurso.getContent().toString());clave = 0;break;}
    listaIncidencias.add(incidencia);}
    for(int i = 0; i<listaIncidencias.size();i++){
     
        System.out.println(listaIncidencias.get(i).toString());
    }
    //Una vez realizada la consulta se crea una variable que almacena la fecha y hora y se convierte a string
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    String format = dtf.format(LocalDateTime.now());
    //Este string junto el nombre del usuario y el tipo en este caso C se usan par crear un nuevo field en el xml historial
    String consultaInsertarHistorial = "update insert <historial> <tipo>" + "C" + "</tipo>"
        + "<fecha-hora>" + format + "</fecha-hora>"
        + "<empleado>" + nombreUsuario + "</empleado></historial> into /historiales";
        consulta(consultaInsertarHistorial);}
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
     
    //ESTA FUNCION NOS PERMITE PEDIR EL NUMERO DE IDENTIFICACION DE LA INCIDENCIA
    public static int introducirNumeroIncidencia() throws XMLDBException{
    int idIncidencia = 0;
    //Generamos la consulta MySQL
    String consulta = "for $dato in doc('incidencias.xml')//incidencias/incidencia/id/text() return $dato";
    //Introducimos esa consulta en la funcion que nos devolvera un resulSet
    ResourceSet result = consulta(consulta);
    //Lo pasamos por un Iterator y un while que vaya mostrando casa una de las partes por System
    ResourceIterator iteratorResouce = result.getIterator();
    while(iteratorResouce.hasMoreResources()){
    iteratorResouce.nextResource();
    idIncidencia++; }
    idIncidencia++;
    //si no esta usado enviamos el numero introducido
    return idIncidencia;}

    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
     
    //ESTA FUNCION NOS PERMITE PEDIR LA FECHA Y HORA DE LA INCIDENCIA
    public static String introducirFechaHora(){
    //Es una funcion sensilla pedimos un string con la funcion pedir string y pasamos su tamaño por el while
    //para controlar los requisitos de cantidad de varchar de la base de datos que no han proporcionado
    String fechaHoraSeleccionada = "";
    do{
    System.out.println("Introduce la fecha y hora recuerda que su tamaño maximo sera de 50 caracteres");
    fechaHoraSeleccionada = pedirString();
    }while(!(fechaHoraSeleccionada.length()<51));
    return fechaHoraSeleccionada;}
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
     
    //ESTA FUNCION NOS PERMITE PEDIR EL TIPO DE LA INCIDENCIA
    public static String introducirTipo(){
    //Es una funcion sencilla pedimos un string con la funcion pedir string y pasamos su tamaño por el while
    //para controlar los requisitos de cantidad de varchar de la base de datos que no han proporcionado
    String tipoSeleccionado = "";
    do{
    System.out.println("Introduce el tipo recuerda que su tamaño maximo sera de 8 caracteres");
    tipoSeleccionado = pedirString();
    }while(!(tipoSeleccionado.length()<9));
    return tipoSeleccionado;}     
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
   
    //ESTA FUNCION NOS PERMITE INSERTAR TODOS LOS DATOS DE LA INCIDENCIA
    public static void insertarIncidencia() throws XMLDBException{
    //Pedimos todos los valores necesarios para crear la incidencias funcionesEmpleado traves de las funciones
    //creadas especificamente en esta clase para este motivo
    int idIncidencia = introducirNumeroIncidencia();
    String origen = pedirNombreUsuario();
    System.out.println("SELECCIONA ORIGEN");
    String destino = pedirNombreUsuario(); 
    System.out.println("SELECCIONA DESTINO");
    String fechaHora = introducirFechaHora();   
    String tipo = introducirTipo();
    System.out.println("Introduce los detalles");
    String detalle = pedirString();
    Incidencia incidencia = new Incidencia(idIncidencia,origen, destino,fechaHora,detalle, tipo);
    //Introducimos todos los valores en la nueva consulta de incidencias
    String insertarConsultaIncidencia = "update insert <incidencia> <tipo>" + incidencia.getTipo() + "</tipo>"
        + "<detalle>" + incidencia.getDetalle() + "</detalle>"
        + "<origen>" + incidencia.getOrigen() + "</origen>"
        + "<destino>" + incidencia.getDestino() + "</destino>"
        + "<id>" + incidencia.getIdincidencia() + "</id>"
        + "<fecha-creacion>" + fechaHora + "</fecha-creacion></incidencia> into /incidencias"; 
    consulta(insertarConsultaIncidencia);
    //Creamos un if que filtra las incidencia y genera un historial en caso de que sea urgente
    if(tipo.equals("Urgente")||tipo.equals("urgente")){    
    //Una vez creada la incidencia se crea una variable que almacena la fecha y hora y se convierte a string
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    String format = dtf.format(LocalDateTime.now());
    //Este string junto el nombre del usuario y el tipo en este caso U se usan par crear un nuevo field en el xml historial
    String consultaInsertarHistorial = "update insert <historial> <tipo>" + "U" + "</tipo>"
        + "<fecha-hora>" + format + "</fecha-hora>"
        + "<empleado>" + origen + "</empleado></historial> into /historiales";
        consulta(consultaInsertarHistorial);}}

    public static Empleado crearObjetoEmpleado(String nombreEmpleado) throws XMLDBException{
    int clave = 0;
    Empleado empleado = new Empleado();
    //Generamos la consulta MySQL
    String consulta = "for $dato in doc('empleado.xml')/empleados/empleado where $dato/usuario='"+nombreEmpleado+"' return $dato/*/text()";
    //Introducimos esa consulta en la funcion que nos devolvera un resulSet
    ResourceSet result = consulta(consulta);
    //Lo pasamos por un Iterator y un while que vaya mostrando cada una de las partes por System
    ResourceIterator iteratorResouce = result.getIterator();
    while(iteratorResouce.hasMoreResources()){   
    Resource recurso = iteratorResouce.nextResource();
    switch(clave){
        case 0:empleado.setNombreusuario(recurso.getContent().toString());clave++;break;
        case 1:empleado.setPassword(recurso.getContent().toString());clave++;break;
        case 2:empleado.setNombrecompleto(recurso.getContent().toString());clave++;break;
        case 3:empleado.setTelefono(recurso.getContent().toString());clave = 0;break;}
    }return empleado; }



}
