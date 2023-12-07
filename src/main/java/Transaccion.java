import java.util.Date;

public class Transaccion {

    // ATRIBUTOS
    private int id;
    private Cuenta cuentaProveedora;
    private Cuenta cuentaFinal;
    private String detalle;
    private double monto;
    private Date fechaTransaccion;
    private boolean esActiva;
    private static int contadorTransacciones = 10000;

    // CONSTRUCTOR
    public Transaccion(Cuenta cuentaProveedora, Cuenta cuentaFinal, String detalle, double monto) {
        this.id = contadorTransacciones;
        this.cuentaProveedora = cuentaProveedora;
        this.cuentaFinal = cuentaFinal;
        this.detalle = detalle;
        this.monto = monto;
        this.fechaTransaccion = new java.sql.Date(System.currentTimeMillis());;
        this.esActiva = true;
        contadorTransacciones++;
    }

    // METODOS
    // getters
    public String getDatos () {
        // convertir el estado a String
        String estado;
        if (!esActiva) {
            estado = "Inactivo";
        } else {
            estado = "Activo";
        }

        // revisar si hay fuenta final
        String cuentaFinalString;
        if (cuentaFinal == null) {
            cuentaFinalString = "N/A";
        } else {
            cuentaFinalString = cuentaFinal.getNumeroCuenta() + "";
        }

        return "Cuenta proveedora: " + cuentaProveedora.getNumeroCuenta() + "\n" +
                "Cuenta final: " + cuentaFinalString + "\n" +
                "Detalle: " + detalle + "\n" +
                "Monto: " + monto + "\n" +
                "Fecha de transaccion: " + fechaTransaccion + "\n" +
                "Estado: " + estado;

    }

    public int getId() {
        return id;
    }

    public Cuenta getCuentaProveedora(){
        return cuentaProveedora;
    }

    public Cuenta getCuentaFinal(){
        return cuentaFinal;
    }

    public String getDetalle(){
        return detalle;
    }

    public double getMonto(){
        return monto;
    }

    public Date getFecha(){
        return fechaTransaccion;
    }

    public boolean getEsActiva(){
        return esActiva;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCuentaProveedora(Cuenta cuentaProveedora){
        this.cuentaProveedora = cuentaProveedora;
    }

    public void setCuentaFinal(Cuenta cuentaFinal){
        this.cuentaFinal = cuentaFinal;
    }

    public void setDetalle(String detalle){
        this.detalle = detalle;
    }

    public void setMonto(double monto){
        this.monto = monto;
    }

    public void setFecha(Date fecha){
        this.fechaTransaccion = fecha;
    }

    public void setEsActiva(boolean esActiva){
        this.esActiva = esActiva;
    }

}
