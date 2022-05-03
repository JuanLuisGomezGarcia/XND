
package XND;

import org.xmldb.api.modules.*;
import java.io.File;
import javax.xml.transform.OutputKeys;
import org.exist.xmldb.XQueryService;
import org.xmldb.api.base.CompiledExpression;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XUpdateQueryService;

public class Gestor {
    
    //Creamos la ruta del driver
    protected static String driver = "org.exist.xmldb.DatabaseImpl";
    //Creamos un strin con la URL de la base de datos
    public static String URL ="xmldb:exist://localhost:8080/exist/xmlrpc";
    //Y creamos las variables necesarias para realizar la conexion
    static Database database;
    static Collection col;
    private static String usuario;
    private static String password;
    private static String collection;
    private static String nom_recurso;
    
    //Generamos el constructor de la clase
    public Gestor() throws Exception{
    this.database = null;
    this.usuario = "admin";
    this.password = "erikzulu240489";
    this.collection = "/db/incidencias";
    this.nom_recurso = null; }    
    
    
    //FUNCION CONECTAR BASE DE DATOS
    public static  int conectarBD() throws ClassNotFoundException, XMLDBException, InstantiationException, IllegalAccessException {
    //Conectamos el driver
    Class cl = Class.forName(driver);
    //Lo introdusimos en la base de datos
    database = (Database) cl.newInstance();
    DatabaseManager.registerDatabase(database);
    col = (Collection) DatabaseManager.getCollection(URL + collection, usuario,password);
    int numeroClave = 0;
    try{col.getResourceCount();}catch(Exception e){System.out.println("Creando base de datos");numeroClave = -1;}
    //y ya tenemos la conexion reaizada
    return numeroClave;}

    //FUNCION CREAR COLLECCION 
    public static void crearColeccion() throws XMLDBException{
    //Realizamos una conexion pero esta vez a /db
    col = (Collection) DatabaseManager.getCollection(URL + "/db", usuario,password);
    //Una vez realizada creamos la collecion incidencias
    CollectionManagementService mgtService=(CollectionManagementService)col.getService("CollectionManagementService", "1.0");
    mgtService.createCollection(new String ("incidencias"));}

    //FUNCION INTRODUCIR RECURSOS
    public static void asignarRecursosDB(File archivo)throws Exception {
    //Utilizamos la coleccion con la funcion crear recursos
    Resource nuevoRecurso = col.createResource(archivo.getName(),"XMLResource");
    //Cogemos el archivo que recivimos y lo introducimos en la collecion
    nuevoRecurso.setContent(archivo);
    col.storeResource(nuevoRecurso);}

    //FUNCION QUE DEVUELVE EL DOCUMENTO XML POR CONSOLA
    public static void contenidoRecurso() throws XMLDBException{
    //Seleccionamos la collecion
    col = (Collection) DatabaseManager.getCollection(URL + collection, usuario,password);
    Resource res = null;
    //Seleccionamos el archio a mostrar
    res = (Resource)col.getResource("historial.xml");
    XMLResource xmlres = (XMLResource) res;
    System.out.println("SALIDA " + xmlres.getContent());    }


    //ESTA FUNCION REALIZA CONSULTAS
    public static ResourceSet consulta(String consulta) throws XMLDBException{
    //Creamos el resourceset que enviaremos
    ResourceSet result = null;
    //Generamos la collecion
    col = (Collection) DatabaseManager.getCollection(URL + collection, usuario,password);
    //Añadimos la condiciones del XQUERY
    XQueryService service = (XQueryService)col.getService("XQueryService", "1.0");
    service.setProperty(OutputKeys.INDENT, "yes");
    service.setProperty(OutputKeys.ENCODING,"UTF-8");
    //Compilamos lac onsulta recivida y enviamos el ResourceSet
    CompiledExpression compiled = service.compile(consulta);
    result = service.execute(compiled);
    return result;}}
