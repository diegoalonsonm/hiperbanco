import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Cuenta {

    // ATIRBUTOS
    private int numeroCuenta;
    private String idCliente;
    private String movimientos;
    private int tipoCuenta;
    private String fechaApertura;
    private double saldo;
    private boolean esActiva;
    private Usuario usuario;

    // CONSTRUCTOR
    public Cuenta(int numeroCuenta, String idCliente, String movimientos, int tipoCuenta, String fechaApertura, double saldo, boolean esActiva, Usuario usuario) {
        this.numeroCuenta = numeroCuenta;
        this.idCliente = idCliente;
        this.movimientos = movimientos;
        this.tipoCuenta = tipoCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.esActiva = esActiva;
        this.usuario = usuario;
    }

    // METODOS
    // getters
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getMovimientos(){
        return movimientos;
    }

    public int getTipoCuenta(){
        return tipoCuenta;
    }

    public String getFechaApertura(){
        Date fecha = new Date();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy, HH:mm:ss");

        fechaApertura = formato.format(fecha);
        return fechaApertura;
    }

    public double getSaldo(){
        return saldo;
    }

    public boolean getEsActiva(){
        return esActiva;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    // setters
    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setMovimientos(String movimientos){
        this.movimientos = movimientos;
    }

    public void setTipoCuenta(int tipoCuenta){
        this.tipoCuenta = tipoCuenta;
    }

    public void setFechaApertura(String fechaApertura){
        this.fechaApertura = fechaApertura;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public void setEsActiva(boolean esActiva){
        this.esActiva = esActiva;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

}
