public class Usuario {

    // ATRIBUTOS
    public int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int cedula;
    private String correo;
    private String telefono;
    private Cuenta[] listaCuentas;
    private int rol;
    private String nombreUsuario;
    private String claveAcceso;
    private Transaccion[] historialTransacciones;
    private boolean esActivo;
    private static int contadorUsuarios = 40;
    private int tarjetaAcceso[][];

    // CONSTRUCTOR
    public Usuario(String nombre, String apellido1, String apellido2, int cedula, String correo, String telefono, Cuenta[] listaCuentas, int rol, String claveAcceso, String historialTransacciones, boolean esActivo) {
        this.id = contadorUsuarios;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.listaCuentas = new Cuenta[5];
        this.rol = rol;
        this.nombreUsuario = nombre.toLowerCase() + contadorUsuarios;
        this.claveAcceso = claveAcceso;
        this.historialTransacciones = new Transaccion[50];
        this.esActivo = esActivo;
        contadorUsuarios++;

        this.tarjetaAcceso = new int[4][5];
        for (int i = 0; i < tarjetaAcceso.length; i++) {
            for (int j = 0; j < tarjetaAcceso[i].length; j++) {
                tarjetaAcceso[i][j] = aleatorio(10, 99);
            }
        }
    }

    // METODOS
    // getters
    public String getDatos() {
        // convertir el rol a String
        String rolString;
        if (rol == 1) {
            rolString = "Administrador";
        } else if (rol == 2) {
            rolString = "Cliente";
        } else {
            rolString = "Sin rol";
        }

        // convertir el estado a String
        String estado;
        if (!esActivo) {
            estado = "Inactivo";
        } else {
            estado = "Activo";
        }

        // hacer legible la lista de cuentas
        String listaCuentas;
        if (this.listaCuentas == null) {
            listaCuentas = "Sin cuentas";
        } else {
            if (this.listaCuentas.length == 0) {
                listaCuentas = "Sin cuentas asignadas";
            } else {
                listaCuentas = "";
                for (int i = 0; i < this.listaCuentas.length; i++) {
                    if (this.listaCuentas[i] != null) {
                        listaCuentas += this.listaCuentas[i].getNumeroCuenta() + ", ";
                    }
                }
            }
        }

        // formatear el telefono
        String primeraMitadnum = telefono.substring(0, 4);
        String segundaMitadnum = telefono.substring(4, 8);
        String telefonoFormateado = primeraMitadnum + "-" + segundaMitadnum;

        return "ID: " + id
                + "\nNombre Completo: " + nombre + " " + apellido1 + " " + apellido2
                + "\nCedula: " + cedula
                + "\nCorreo: " + correo
                + "\nTelefono: " + telefonoFormateado
                + "\nLista de Cuentas: " + listaCuentas
                + "\nRol: " + rolString
                + "\nNombre de usuario: " + nombreUsuario
                + "\nHistorial de Transacciones: " + historialTransacciones
                + "\nEstado: " + estado
                + "\n";
    }

    public int aleatorio(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public int getId() {
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
        return nombre + " " + apellido1 + " " + apellido2;
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

    public Cuenta[] getListaCuentas(){
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

    public Transaccion[] getHistorialTransacciones(){
        return historialTransacciones;
    }

    public boolean getEsActivo(){
        return esActivo;
    }

    // setters
    public void setId(int id){
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

    public void setListaCuentas(Cuenta[] listaCuentas){
        this.listaCuentas = listaCuentas;
    }

    public void setRol(int rol){
        this.rol = rol;
    }

    public void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }

    public void setClaveAcceso(String claveAcceso){
        this.claveAcceso = claveAcceso;
    }

    public void setHistorialTransacciones (Transaccion[] historialTransacciones){
        this.historialTransacciones = historialTransacciones;
    }

    public void setEsActivo(boolean esActivo){
        this.esActivo = esActivo;
    }

    public void setTarjetaAcceso(int[][] tarjetaAcceso){
        this.tarjetaAcceso = tarjetaAcceso;
    }

    public int[][] getTarjetaAcceso(){
        return tarjetaAcceso;
    }

    public void mostrarTarjetaAcceso() {
        char letra = 'A';
        int numero = 1;

        // Mostrar la fila con los números de las columnas
        System.out.print("    ");
        for (int i = 0; i < tarjetaAcceso[0].length; i++) {
            System.out.print("[" + (i + 1) + "]");
            System.out.print(" ");
        }
        System.out.println();

        // Mostrar la matriz
        for (int i = 0; i < tarjetaAcceso.length; i++) {
            System.out.print("[" + letra++ + "] ");
            for (int j = 0; j < tarjetaAcceso[i].length; j++) {
                System.out.print("[" + tarjetaAcceso[i][j] + "]");
            }
            System.out.println();
        }
    }

    public String[] seleccionarPosicones() {
        String[] posiciones = new String[3];

        for (int i = 0; i < 3; i++) {
            int fila = (int) (Math.random() * 4);
            int columna = (int) (Math.random() * 5);

            char letra = (char) ('A' + fila);
            int numero = columna;

            posiciones[i] = letra + "" + numero;
        }
        return posiciones;
    }

    public String generarClaveAcceso(String[] posiciones) {
        String clave = "";
        for (int i = 0; i < posiciones.length; i++) {
            String posicion = posiciones[i];
            char letra = posicion.charAt(0);
            int numero = Integer.parseInt(posicion.substring(1));

            int fila = letra - 'A';
            int valor = tarjetaAcceso[fila][numero];

            clave += valor;
            if (i < posiciones.length - 1) {
                clave += "-";
            }
        }
        return clave;
    }

    public String mostrarPosiciones(String clave) {
        String[] numeros = clave.split("-");
        String posiciones = "";

        for (int k = 0; k < numeros.length; k++) {
            int valor = Integer.parseInt(numeros[k]);
            boolean encontrado = false;

            for (int i = 0; i < tarjetaAcceso.length; i++) {
                for (int j = 0; j < tarjetaAcceso[i].length; j++) {
                    if (tarjetaAcceso[i][j] == valor) {
                        char letra = (char) ('A' + i);
                        int numero = j + 1;
                        posiciones += numero + "" + letra;

                        if (k < numeros.length - 1) {
                            posiciones += "-";
                        }

                        encontrado = true;
                        break;

                    }
                }
                if (encontrado) {
                    break;
                }
            }

        }
        return posiciones;
    }

}
