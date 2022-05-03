
package XND;

public class Historial {
      
    //Creamos los atributos de la tabla
    private int idevento;
    private String tipo;
    private String fechahora;
    private String empleado;
    
    //Creamos el constructor vacio y otro con los atributos del objeto.
    public Historial() {}
    public Historial(int idevento, String tipo, String fechahora, String empleado) {
    this.idevento = idevento;
    this.tipo = tipo;
    this.fechahora = fechahora;
    this.empleado = empleado;}

    // Getter y Setter de la clase
    public int getIdevento() {
    return idevento;}
    public String getTipo() {
    return tipo;}
    public void setTipo(String tipo) {
    this.tipo = tipo;}
    public String getFechahora() {
    return fechahora;}
    public void setFechahora(String fechahora) {
    this.fechahora = fechahora;}
    public String getEmpleado() {
    return empleado;}
    public void setEmpleado(String empleado) {
    this.empleado = empleado;}

    //Metodo toString
    public String toString() {
    return  "id del evento: " + idevento + "\ntipo: " + tipo
    + "\nfechahora: " + fechahora + "\nempleado: " + empleado;}  }
