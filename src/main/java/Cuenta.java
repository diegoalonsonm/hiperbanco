import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Cuenta {

    // ATIRBUTOS
    private int numeroCuenta;
    private int idCliente;
    private String movimientos;
    private String tipoCuenta;
    private String fechaApertura;
    private double saldo;
    private boolean esActiva;
    private Usuario usuario;

    // CONSTRUCTOR
    public Cuenta(int numeroCuenta, int idCliente, String movimientos, String tipoCuenta, String fechaApertura, double saldo, boolean esActiva) {
        this.numeroCuenta = numeroCuenta;
        this.idCliente = idCliente;
        this.movimientos = movimientos;
        this.tipoCuenta = tipoCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.esActiva = esActiva;
    }

    // METODOS
    // getters
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getMovimientos(){
        return movimientos;
    }

    public String getTipoCuenta(){
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

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setMovimientos(String movimientos){
        this.movimientos = movimientos;
    }

    public void setTipoCuenta(String tipoCuenta){
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
