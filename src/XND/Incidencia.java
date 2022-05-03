
package XND;


public class Incidencia {
    //Creamos los atributos de la tabla
    private int idincidencia;
    private String origen;
    private String destino;
    private String fechaHora;
    private String detalle;
    private String tipo;
    
    //Creamos el constructor vacio y otro con los atributos del objeto.
    public Incidencia() {}
    public Incidencia(int idIncidencia,String origen, String destino, String fechaHora, String detalle, String tipo) {
    this.idincidencia = idIncidencia;
    this.origen = origen;
    this.destino = destino;
    this.fechaHora = fechaHora;
    this.detalle = detalle;
    this.tipo = tipo;    }

    // Getter y Setter de la clase
    public void setOrigen(int idincidencia) {
    this.idincidencia = idincidencia;}
    public String getOrigen() {
    return origen;}
    public void setOrigen(String origen) {
    this.origen = origen;}
    public String getDestino() {
    return destino;}
    public void setDestino(String destino) {
    this.destino = destino;}
    public int getIdincidencia() {
    return idincidencia;}
    public void setIdincidencia(int idincidencia) {
    this.idincidencia = idincidencia;}
    public String getFechaHora() {
    return fechaHora;}
    public void setFechaHora(String fechaHora) {
    this.fechaHora = fechaHora;}
    public String getDetalle() {
    return detalle;}
    public void setDetalle(String detalle) {
    this.detalle = detalle;}
    public String getTipo() {
    return tipo;}
    public void setTipo(String tipo) {
    this.tipo = tipo;}

    //Metodo toString
    public String toString() {
    return "Idincidencia: " + idincidencia + "\nOrigen: " + origen + "\nDestino: " +
    destino + "\nfecha y hora: " + fechaHora + "\nDetalle: " + detalle + "\nTipo: " + tipo + "\n";}  }
