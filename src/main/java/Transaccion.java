import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaccion {

    // ATRIBUTOS
    private int id;
    private Cuenta cuentaProveedora;
    private Cuenta cuentaFinal;
    private String detalle;
    private double monto;
    private String fechaTransaccion;
    private boolean esActiva;

    // CONSTRUCTOR
    public Transaccion(int id, Cuenta cuentaProveedora, Cuenta cuentaFinal, String detalle, double monto, String fecha, boolean esActiva) {
        this.id = id;
        this.cuentaProveedora = cuentaProveedora;
        this.cuentaFinal = cuentaFinal;
        this.detalle = detalle;
        this.monto = monto;
        this.fechaTransaccion = fecha;
        this.esActiva = esActiva;
    }

    // METODOS
    // getters
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

    public String getFecha(){
        Date fecha = new Date();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy, HH:mm:ss");

        fechaTransaccion = formato.format(fecha);
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

    public void setFecha(String fecha){
        this.fechaTransaccion = fecha;
    }

    public void setEsActiva(boolean esActiva){
        this.esActiva = esActiva;
    }

}
