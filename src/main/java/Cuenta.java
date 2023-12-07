import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Cuenta {

    // ATIRBUTOS
    private int numeroCuenta;
    private int idCliente;
    private Transaccion[] movimientos;
    private TipoCuenta tipoCuenta;
    private Date fechaApertura;
    private double saldo;
    private boolean esActiva;
    private Usuario usuario;
    private static int contadorCuentas = 4710;

    // CONSTRUCTOR
    public Cuenta(int idCliente, TipoCuenta tipoCuenta, double saldo, boolean esActiva, Usuario usuario) {
        this.numeroCuenta = contadorCuentas;
        this.idCliente = idCliente;
        this.movimientos = new Transaccion[50];
        this.tipoCuenta = tipoCuenta;
        this.fechaApertura = new java.sql.Date(System.currentTimeMillis());
        this.saldo = saldo;
        this.esActiva = esActiva;
        this.usuario = usuario;
        contadorCuentas++;
    }

    // METODOS
    // getters
    public String getDatos() {
        // convertir el estado a String
        String estadoString;
        if (!esActiva) {
            estadoString = "Inactiva";
        } else {
            estadoString = "Activa";
        }

        // convertir tipo de cuenta a String
        String tipoCuentaString;
        if (tipoCuenta == TipoCuenta.CUENTA_CORRIENTE) {
            tipoCuentaString = "Cuenta corriente";
        } else if (tipoCuenta == TipoCuenta.AHORROS) {
            tipoCuentaString = "Ahorros";
        } else if (tipoCuenta == TipoCuenta.INVERSION) {
            tipoCuentaString = "Inversion";
        } else {
            tipoCuentaString = "Planilla";
        }

        // convertir la fecha a String
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fechaAperturaString = dateFormat.format(fechaApertura);

        // retornar los datos
        return "Numero de cuenta: " + numeroCuenta + "\n" +
                "ID del cliente: " + idCliente + "\n" +
                "Movimientos: " + movimientos + "\n" +
                "Tipo de cuenta: " + tipoCuentaString + "\n" +
                "Fecha de apertura: " + fechaAperturaString + "\n" +
                "Saldo: " + saldo + "\n" +
                "Estado: " + estadoString + "\n" +
                "Usuario: " + usuario.getNombreUsuario() + "\n";
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public Transaccion[] getMovimientos(){
        return movimientos;
    }

    public String getTipoCuenta(){
        String tipoCuentaString;
        if (tipoCuenta == TipoCuenta.CUENTA_CORRIENTE) {
            tipoCuentaString = "Cuenta corriente";
        } else if (tipoCuenta == TipoCuenta.AHORROS) {
            tipoCuentaString = "Ahorros";
        } else if (tipoCuenta == TipoCuenta.INVERSION) {
            tipoCuentaString = "Inversion";
        } else {
            tipoCuentaString = "Planilla";
        }
        return tipoCuentaString;
    }

    public Date getFechaApertura(){
        return fechaApertura;
    }

    public double getSaldo(){
        return saldo;
    }

    public String getEsActiva() {
        String estado;
        if (esActiva) {
            estado = "Activa";
        } else {
            estado = "Inactiva";
        }
        return estado;
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

    public void setMovimientos(Transaccion[] movimientos){
        this.movimientos = movimientos;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta){
        this.tipoCuenta = tipoCuenta;
    }

    public void setFechaApertura(Date fechaApertura){
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
