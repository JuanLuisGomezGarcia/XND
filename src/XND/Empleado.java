
package XND;


import java.util.List;
public class Empleado {
    //Creamos los atributos de la tabla
    private String nombreusuario;
    private String password;
    private String nombrecompleto;
    private String telefono;
    
    //Creamos la relacion con otras tablas
    private List <Incidencia> incidenciasOrigen;
    private List <Incidencia> incidenciasDestino;
    private List<Historial> listaHistorial;

   //Creamos el constructor vacio y otro con los atributos del objeto.
    public Empleado() {}
    public Empleado(String nombreusuario, String password, String nombrecompleto, String telefono) {
    this.nombreusuario = nombreusuario;
    this.password = password;
    this.nombrecompleto = nombrecompleto;
    this.telefono = telefono;}
    
    // Getter y Setter de la clase
    public String getNombreusuario() {
    return nombreusuario;}
    public void setNombreusuario(String nombreusuario) {
    this.nombreusuario = nombreusuario;}
    public String getPassword() {
    return password;}
    public void setPassword(String password) {
    this.password = password;}
    public String getNombrecompleto() {
    return nombrecompleto;}
    public void setNombrecompleto(String nombrecompleto) {
    this.nombrecompleto = nombrecompleto;}
    public String getTelefono() {
    return telefono;}
    public void setTelefono(String telefono) {
    this.telefono = telefono;}
    public List<Incidencia> getIncidenciasOrigen() {
    return incidenciasOrigen;}
    public void setIncidenciasOrigen(List<Incidencia> incidenciasOrigen) {
    this.incidenciasOrigen = incidenciasOrigen;}
    public void setIncidenciaOrigen(Incidencia incidenciaOrigen){
    this.incidenciasOrigen.add(incidenciaOrigen);}
    public List<Incidencia> getIncidenciasDestino() {
    return incidenciasDestino;}
    public void setIncidenciasDestino(List<Incidencia> incidenciasDestino) {
    this.incidenciasDestino = incidenciasDestino;}
    public void setIncidenciaDestino(Incidencia incidenciaDestino){
    this.incidenciasDestino.add(incidenciaDestino);}
    public List<Historial> getListaHistorial() {
    return listaHistorial;}
    public void setListaHistorial(List<Historial> listaHistorial) {
    this.listaHistorial = listaHistorial;}
    public void addEventoToHistorial(Historial miHistorial){
    this.listaHistorial.add(miHistorial);}
    
    //Metodo toString
    public String toString() {
    return "Nombre del usuario: " + nombreusuario + "\npassword=" + password + 
    "\nnombre completo: " + nombrecompleto + "\ntelefono: " + telefono + "\n";}}

