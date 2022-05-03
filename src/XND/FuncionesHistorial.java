package XND;

import static XND.Gestor.consulta;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;


public class FuncionesHistorial {
  /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    //ESTA FUNCION MUESTRA UNA LISTA DE LOS HISTORIALES
    public static void listaHistorialConsulta() throws XMLDBException{
    //Generamos la consulta MySQL
    String nombre = "";
    String consulta = "for $dato in doc('historial.xml')/historiales/historial where $dato/tipo='C' "
            + "order by $dato/empleado "
            + "return  $dato/empleado/text()";
    //Introducimos esa consulta en la funcion que nos devolvera un resulSet
    ResourceSet result = consulta(consulta);
    //Lo pasamos por un Iterator y un while que vaya mostrando cada una de las partes por System
    ResourceIterator iteratorResouce = result.getIterator();
    while(iteratorResouce.hasMoreResources()){   
    Resource recurso = iteratorResouce.nextResource();
    if(!nombre.equals(recurso.getContent().toString())){
    nombre =recurso.getContent().toString();
    System.out.println("Usuario: " + recurso.getContent());}}}
    
    //ESTA FUNCION MUESTRA UNA LISTA DE LOS HISTORIALES
    public static void listaHistorialInicioSecion() throws XMLDBException{
    //Generamos la consulta MySQL
    int clave = 0;
    String consulta = "for $dato in doc('historial.xml')/historiales/historial where $dato/tipo='I' "
            + "return  $dato/*/text()";
    //Introducimos esa consulta en la funcion que nos devolvera un resulSet
    ResourceSet result = consulta(consulta);
    //Lo pasamos por un Iterator y un while que vaya mostrando cada una de las partes por System
    ResourceIterator iteratorResouce = result.getIterator();
    while(iteratorResouce.hasMoreResources()){   
    Resource recurso = iteratorResouce.nextResource();
    switch(clave){
        case 0:System.out.println("Tipo: " + recurso.getContent());clave++;break;
        case 1:System.out.println("Fecha y hora : " + recurso.getContent());clave++;break;
        case 2:System.out.println("Usuario: " + recurso.getContent() + "\n");clave = 0;break;}}}
    
     //ESTA FUNCION NOS PERMITE CONSEGUIR EL NUMERO DE INCIDENCIAS
    public static void numeroDeIncidencias() throws XMLDBException{
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
    System.out.println(idIncidencia);}   
    
}