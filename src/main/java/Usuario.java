import javax.swing.*;

public class Usuario {

    // ATRIBUTOS
    private String id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int cedula;
    private String correo;
    private String telefono;
    private String listaCuentas;
    private int rol;
    private String nombreUsuario;
    private String claveAcceso;
    private String historialTransacciones;
    private boolean esActivo;

    // CONSTRUCTOR
    public Usuario(String id, String nombre, String apellido1, String apellido2, int cedula, String correo, String telefono, String listaCuentas, int rol, String nombreUsuario, String claveAcceso, String historialTransacciones, boolean esActivo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.listaCuentas = listaCuentas;
        this.rol = rol;
        this.nombreUsuario = nombreUsuario;
        this.claveAcceso = claveAcceso;
        this.historialTransacciones = historialTransacciones;
        this.esActivo = esActivo;
    }

    // METODOS
    // getters
    public String getDatos() {
        String rolString;
        String estado;

        if (rol == 1) {
            rolString = "Administrador";
        } else if (rol == 2) {
            rolString = "Cliente";
        } else {
            rolString = "Sin rol";
        }

        if (!esActivo) {
            estado = "Inactivo";
        } else {
            estado = "Activo";
        }

        return "ID: " + id
                + "\nNombre Completo: " + nombre + " " + apellido1 + " " + apellido2
                + "\nCedula: " + cedula
                + "\nTelefono: " + telefono
                + "\nLista de Cuentas: " + listaCuentas
                + "\nRol: " + rolString
                + "\nNombre de usuario: " + nombreUsuario
                + "\nHistorial de Transacciones: " + historialTransacciones
                + "\nEstado: " + estado
                + "\n";
    }

    public String getId() {
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido1(){
        return apellido1;
    }

    public String getApellido2(){
        return apellido2;
    }

    public String getNombreCompleto(){
        return nombre + apellido1 + apellido2;
    }

    public int getCedula(){
        return cedula;
    }

    public String getCorreo(){
        return correo;
    }

    public String getTelefono(){
        return telefono;
    }

    public String getListaCuentas(){
        return listaCuentas;
    }

    public int getRol(){
        return rol;
    }

    public String getNombreUsuario(){
        return nombreUsuario;
    }

    public String getClaveAcceso(){
        return claveAcceso;
    }

    public String getHistorialTransacciones(){
        return historialTransacciones;
    }

    public boolean getEsActivo(){
        return esActivo;
    }

    // setters
    public void setId(String id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1){
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2){
        this.apellido2 = apellido2;
    }

    public void setCedula(int cedula){
        String cedulaString = Integer.toString(cedula);

        if (cedulaString.length() != 9){
            System.out.println("La cedula debe tener 9 digitos");
        } else {
            this.cedula = cedula;
        }
    }

    public void setCorreo(String correo){
        int indiceArroba = correo.indexOf("@");

        if (indiceArroba != -1 && correo.indexOf(".", indiceArroba) > indiceArroba){
            this.correo = correo;
        } else {
            System.out.println("El formato del correo no es el adecuado");
        }
    }

    public void setTelefono(String telefono){
        if (telefono.length() != 8){
            System.out.println("El telefono debe tener 8 digitos");
        } else {
            this.telefono = telefono;
        }
    }

    public void setListaCuentas(String listaCuentas){
        this.listaCuentas = listaCuentas;
    }

    public void setRol(int rol){
        this.rol = rol;
    }

    public void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }

    public void setClaveAcceso(String claveAcceso){
        if(claveAcceso.length() != 8){
            System.out.println("La clave de acceso debe tener 8 digitos");
        } else {
            if(claveAcceso.substring(2,3).equals("-")){
                if(claveAcceso.substring(5, 6).equals("-")){
                    this.claveAcceso = claveAcceso;
                } else {
                    System.out.println("Las parejas de la clave de acceso deben estar separadas por un guion");
                }
            } else {
                System.out.println("Las parejas de la clave de acceso deben estar separadas por un guion");
            }
        }
    }

    public void setHistorialTransacciones(String historialTransacciones){
        this.historialTransacciones = historialTransacciones;
    }

    public void setEsActivo(boolean esActivo){
        this.esActivo = esActivo;
    }

}
