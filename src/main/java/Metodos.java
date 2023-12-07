import javax.swing.*;

public class Metodos {

    // METODOS DEL MENU

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // menu banco
    public static void menuBanco(Usuario usuarios[], Cuenta cuentas[], boolean generados, Transaccion[] transacciones) {
        int opc;

        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al Menu Banco\n Seleccione una opcion" +
                    "\n\n" +
                    "1. Generar Datos\n" +
                    "2. Mostrar Clientes\n" +
                    "3. Mostrar cuentas y movimientos\n" +
                    "4. Agregar nuevo cliente\n" +
                    "5. Agregar nueva cuenta\n" +
                    "6. Buscar cliente\n" +
                    "7. Buscar cuenta\n" +
                    "8. Generar reportes\n" +
                    "9. Salir"));

            switch (opc) {
                case 1:
                    if (!generados) {
                        generarDatos(usuarios, cuentas);
                        generados = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Los datos ya se agregaron al sistema");
                    }
                    break;
                case 2:
                    mostrarClientes(usuarios);
                    break;
                case 3:
                    mostrarCuentas(cuentas);
                    mostrarTransacciones(transacciones);
                    break;
                case 4:
                    agregarUsuario(usuarios);
                    break;
                case 5:
                    agregarCuenta(cuentas, usuarios);
                    break;
                case 6:
                    buscarCliente(usuarios);
                    break;
                case 7:
                    buscarCuenta(cuentas);
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Por el momento esta parte se encuentra en mantenimiento!");
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Gracias por visitar HiperBanco!");
                    break;
                default:
                    System.out.println("opcion invalida");
                    break;
            }

        } while (opc != 9);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // generar datos
    private static void generarDatos(Usuario usuarios[], Cuenta cuentas[]) {

        Usuario usuariosGenerados[] = new Usuario[10];
        Cuenta cuentasGeneradas[] = new Cuenta[12];
        Cuenta cuentasPorUsuario[] = new Cuenta[5];

        // creacion de usuarios
        usuariosGenerados[0] = new Usuario("Diego", "Naranjo", "Meza", 119150430, "diego@correo.com", "60469117",cuentasPorUsuario, 1, "12-34-56", "activo", true);
        usuariosGenerados[1] = new Usuario("Maria", "Lopez", "Gomez", 219876543, "maria@correo.com", "60234567", cuentasPorUsuario, 2, "78-90-12", "activo", true);
        usuariosGenerados[2] = new Usuario("Carlos", "Fernandez", "Perez", 319654321, "carlos@correo.com", "60987654", cuentasPorUsuario, 2, "34-56-78", "activo", true);
        usuariosGenerados[3] = new Usuario("Ana", "Gonzalez", "Rodriguez", 419876543, "ana@correo.com", "60123456", cuentasPorUsuario, 1, "90-12-34", "inactivo", false);
        usuariosGenerados[4] = new Usuario("Luis", "Hernandez", "Diaz", 519654321, "luis@correo.com", "60987654", cuentasPorUsuario, 2, "56-78-90", "activo", true);
        usuariosGenerados[5] = new Usuario("Laura", "Serrano", "Blanco", 619876543, "laura@correo.com", "60234567", cuentasPorUsuario, 2, "12-34-56", "activo", true);
        usuariosGenerados[6] = new Usuario("Pedro", "Molina", "Vargas", 719654321, "pedro@correo.com", "60987654", cuentasPorUsuario, 1, "78-90-12", "activo", true);
        usuariosGenerados[7] = new Usuario("Elena", "Cabrera", "Castro", 819876543, "elena@correo.com", "60123456", cuentasPorUsuario, 2, "34-56-78", "activo", true);
        usuariosGenerados[8] = new Usuario("Miguel", "Serrano", "Ruiz", 919654321, "miguel@correo.com", "60987654", cuentasPorUsuario, 1, "90-12-34", "inactivo", false);
        usuariosGenerados[9] = new Usuario("Isabel", "Ruiz", "Gomez", 1019876543, "isabel@correo.com", "60234567", cuentasPorUsuario, 1, "56-78-90", "activo", true);

        // creacion de cuentas
        cuentasGeneradas[0] = new Cuenta(0, TipoCuenta.CUENTA_CORRIENTE, 5000, false, null);
        cuentasGeneradas[1] = new Cuenta(usuariosGenerados[1].getId(), TipoCuenta.AHORROS, 10500, true, usuariosGenerados[1]);
        cuentasGeneradas[2] = new Cuenta(usuariosGenerados[2].getId(), TipoCuenta.INVERSION, 2500, true, usuariosGenerados[2]);
        cuentasGeneradas[3] = new Cuenta(usuariosGenerados[3].getId(), TipoCuenta.PLANILLA, 7500, false, usuariosGenerados[3]);
        cuentasGeneradas[4] = new Cuenta(usuariosGenerados[4].getId(), TipoCuenta.PLANILLA, 5000, false, usuariosGenerados[4]);
        cuentasGeneradas[5] = new Cuenta(usuariosGenerados[5].getId(), TipoCuenta.CUENTA_CORRIENTE, 105850, true, usuariosGenerados[5]);
        cuentasGeneradas[6] = new Cuenta(usuariosGenerados[6].getId(), TipoCuenta.CUENTA_CORRIENTE, 25408, false, usuariosGenerados[6]);
        cuentasGeneradas[7] = new Cuenta(usuariosGenerados[7].getId(), TipoCuenta.AHORROS, 60000, true, usuariosGenerados[7]);
        cuentasGeneradas[8] = new Cuenta(usuariosGenerados[8].getId(), TipoCuenta.INVERSION, 95750, false, usuariosGenerados[8]);
        cuentasGeneradas[9] = new Cuenta(usuariosGenerados[9].getId(), TipoCuenta.AHORROS, 10000, true, usuariosGenerados[9]);
        cuentasGeneradas[10] = new Cuenta(usuariosGenerados[9].getId(), TipoCuenta.INVERSION, 4500, true, usuariosGenerados[9]);
        cuentasGeneradas[11] = new Cuenta(usuariosGenerados[9].getId(), TipoCuenta.CUENTA_CORRIENTE, 3000, true, usuariosGenerados[9]);

        // agregar usuarios y cuentas generados a los arreglos
        for (int i = 0; i < usuariosGenerados.length; i++) {
            if (getIndexUsuario(usuarios) != -1) {
                if (buscarUsuarioId(usuarios, usuariosGenerados[i].getId()) == null) {
                    usuarios[getIndexUsuario(usuarios)] = usuariosGenerados[i];
                }
            }
        }

        for (int i = 0; i < cuentasGeneradas.length; i++) {
            if (getIndexCuenta(cuentas) != -1) {
                if (buscarCuentaNumero(cuentas, cuentasGeneradas[i].getNumeroCuenta()) == null) {
                    cuentas[getIndexCuenta(cuentas)] = cuentasGeneradas[i];
                }
            }
        }

        // agregar cuentas a los usuarios y si un usuario esta asociado a varias vuentas se agreguen todas
        for (int i = 0; i < usuariosGenerados.length; i++) {
            for (int j = 0; j < cuentasGeneradas.length; j++) {
                if (usuariosGenerados[i].getId() == cuentasGeneradas[j].getIdCliente()) {
                    for (int k = 0; k < usuariosGenerados[i].getListaCuentas().length; k++) {
                        if (usuariosGenerados[i].getListaCuentas()[k] == null) {
                            usuariosGenerados[i].getListaCuentas()[k] = cuentasGeneradas[j];
                            break;
                        }
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Datos generados con éxito");
    }

    // agregar nuevo usuario
    private static void agregarUsuario(Usuario usuarios[]) {
        if (getIndexUsuario(usuarios) == -1) {
            JOptionPane.showMessageDialog(null, "La lista de usuarios esta llena");
            return;
        }

        String nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre: ");
        String ap1 = JOptionPane.showInputDialog(null, "Ingrese su primer apellido: ");
        String ap2 = JOptionPane.showInputDialog(null, "Ingrese su segundo apellido: ");
        int cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su cedula: "));
        String correo = JOptionPane.showInputDialog(null, "Ingrese su correo electornico: ");

        if (validarCorreo(correo)) {
            correo = correo;
        } else {
            JOptionPane.showMessageDialog(null, "Correo invalido");
            int opc = getBotones("Desea ingresar otro correo?", "Correo invalido", JOptionPane.WARNING_MESSAGE,
                    new String[]{"Agregar otro correo", "Cancelar"});
            if (opc == 0) {
                correo = JOptionPane.showInputDialog(null, "Ingrese su correo electornico: ");
                validarCorreo(correo);
            } else {
                return;
            }
        }

        String telefono = JOptionPane.showInputDialog(null, "Ingrese su numero telefonico: ");
        Cuenta[] listaCuentas = null;
        int rol = getBotones("Cual de los dos roles cumple el nuevo usuario?", "Rol usuario",
                JOptionPane.DEFAULT_OPTION, new String[]{"Administrador", "Cliente"});
        if (rol == 0) {
            rol = 1;
        } else if (rol == 1) {
            rol = 2;
        } else {
            rol = 0;
        }
        String claveAcceso = "";
        String historialTransacciones = "";
        boolean esActivo = true;

        Usuario nuevoUsuario = new Usuario(nombre, ap1, ap2, cedula, correo, telefono, listaCuentas, rol, claveAcceso,
                historialTransacciones, esActivo);
        usuarios[getIndexUsuario(usuarios)] = nuevoUsuario;

        JOptionPane.showMessageDialog(null, "Usuario Agregado con exito");;

    }

    // mostrar clientes
    private static void mostrarClientes(Usuario usuarios[]) {
        if (usuarios[0] == null) {
            System.out.println("La lista de usuarios esta vacia\n");
        } else {
            System.out.println("**** CLIENTES **** ");
            for (int i = 0; i < usuarios.length; i++){
                if (usuarios[i] != null) {
                    System.out.println((i + 1) + ") " + usuarios[i].getDatos());
                }
            }
        }
    }

    // buscar cliente
    private static Usuario buscarCliente(Usuario usuarios[]) {
        int idBuscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del cliente: "));

        if (buscarUsuarioId(usuarios, idBuscar) == null) {
            int opc = getBotones("El cliente con el ID " + idBuscar + " no se encuentra registrado en el sistema",
                    "Cliente no encontrado", JOptionPane.WARNING_MESSAGE, new String[]{"Ingresar otro ID", "Cancelar"});
            if (opc == 1 || opc == -1) {
                return null;
            } else if (opc == 0) {
                return buscarCliente(usuarios);
            }
        } else if (buscarUsuarioId(usuarios, idBuscar) != null) {
            String botonEstado;

            if (buscarUsuarioId(usuarios, idBuscar).getEsActivo()) {
                botonEstado = "Desactivar";
            } else {
                botonEstado = "Activar";
            }

            // acciones del usuario
            String[] cuentasUsuario = new String[5];
            int cuentaCount = 0;
            for (int i = 0; i < buscarUsuarioId(usuarios, idBuscar).getListaCuentas().length; i++) {
                if (buscarUsuarioId(usuarios, idBuscar).getListaCuentas()[i] != null) {
                    cuentasUsuario[cuentaCount] = buscarUsuarioId(usuarios, idBuscar).getListaCuentas()[i].getNumeroCuenta() + "";
                    cuentaCount++;
                }
            }

            String[] opcionesBotones;
            if (cuentaCount == 0) {
                opcionesBotones = new String[cuentaCount + 4];
                opcionesBotones[0] = "Actualizar Informacion";
                opcionesBotones[1] = botonEstado;
                opcionesBotones[2] = "No tiene cuentas asociadas";
                opcionesBotones[3] = "Cancelar";

                int opc = JOptionPane.showOptionDialog(null, "Como desea proceder?", "Cliente encontrado",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesBotones, opcionesBotones[0]);

                switch (opc) {
                    case 0:
                        actualizarUsuario(usuarios, idBuscar);
                        break;
                    case 1:
                        if (buscarUsuarioId(usuarios, idBuscar).getEsActivo()) {
                            JOptionPane.showMessageDialog(null, "El cliente se ha desactivado de forma correcta");
                            buscarUsuarioId(usuarios, idBuscar).setEsActivo(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "El cliente se ha activado de forma correcta");
                            buscarUsuarioId(usuarios, idBuscar).setEsActivo(true);
                        }
                        break;
                    case 2:
                        System.out.println(" ");
                        break;
                    default:
                        break;
                }

            } else {
                opcionesBotones = new String[cuentaCount + 4];
                opcionesBotones[0] = "Actualizar Informacion";
                opcionesBotones[1] = botonEstado;
                opcionesBotones[2] = "Cuentas asociadas:";

                for (int i = 0; i < cuentaCount; i++) {
                    opcionesBotones[i + 3] = cuentasUsuario[i];
                }

                opcionesBotones[cuentaCount + 3] = "Cancelar";


                switch (cuentaCount) {
                    // una cuenta
                    case 1:
                        int opc = JOptionPane.showOptionDialog(null, "Como desea proceder?", "Cliente encontrado",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesBotones, opcionesBotones[0]);
                        switch (opc) {
                            case 0:
                                actualizarUsuario(usuarios, idBuscar);
                                break;
                            case 1:
                                if (buscarUsuarioId(usuarios, idBuscar).getEsActivo()) {
                                    JOptionPane.showMessageDialog(null, "El cliente se ha desactivado de forma correcta");
                                    buscarUsuarioId(usuarios, idBuscar).setEsActivo(false);
                                } else {
                                    JOptionPane.showMessageDialog(null, "El cliente se ha activado de forma correcta");
                                    buscarUsuarioId(usuarios, idBuscar).setEsActivo(true);
                                }
                                break;

                            case 2:
                                System.out.println(" ");
                                break;
                            case 3:
                                System.out.println("movimientos");
                                break;
                            default:
                                break;
                        }
                    break;

                    // dos cuentas
                    case 2:
                        int opc2 = JOptionPane.showOptionDialog(null, "Como desea proceder?", "Cliente encontrado",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesBotones, opcionesBotones[0]);
                        switch (opc2) {
                            case 0:
                                actualizarUsuario(usuarios, idBuscar);
                                break;
                            case 1:
                                if (buscarUsuarioId(usuarios, idBuscar).getEsActivo()) {
                                    JOptionPane.showMessageDialog(null, "El cliente se ha desactivado de forma correcta");
                                    buscarUsuarioId(usuarios, idBuscar).setEsActivo(false);
                                } else {
                                    JOptionPane.showMessageDialog(null, "El cliente se ha activado de forma correcta");
                                    buscarUsuarioId(usuarios, idBuscar).setEsActivo(true);
                                }
                                break;

                            case 2:
                                System.out.println(" ");
                                break;
                            case 3:
                                System.out.println("movimientos");
                                break;
                            case 4:
                                System.out.println("movimientos");
                                break;
                            default:
                                break;
                        }
                        break;
                        // tres cuentas
                        case 3:
                        int opc3 = JOptionPane.showOptionDialog(null, "Como desea proceder?", "Cliente encontrado",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesBotones, opcionesBotones[0]);
                        switch (opc3) {
                            case 0:
                                actualizarUsuario(usuarios, idBuscar);
                                break;
                            case 1:
                                if (buscarUsuarioId(usuarios, idBuscar).getEsActivo()) {
                                    JOptionPane.showMessageDialog(null, "El cliente se ha desactivado de forma correcta");
                                    buscarUsuarioId(usuarios, idBuscar).setEsActivo(false);
                                } else {
                                    JOptionPane.showMessageDialog(null, "El cliente se ha activado de forma correcta");
                                    buscarUsuarioId(usuarios, idBuscar).setEsActivo(true);
                                }
                                break;

                            case 2:
                                System.out.println(" ");
                                break;
                            case 3:
                                System.out.println("movimientos");
                                break;
                            case 4:
                                System.out.println("movimientos");
                                break;
                            case 5:
                                System.out.println("movimientos");
                                break;
                            default:
                                break;
                        }
                    break;

                    // cuatro cuentas
                    case 4:
                        int opc4 = JOptionPane.showOptionDialog(null, "Como desea proceder?", "Cliente encontrado",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesBotones, opcionesBotones[0]);
                        switch (opc4) {
                            case 0:
                                actualizarUsuario(usuarios, idBuscar);
                                break;
                            case 1:
                                if (buscarUsuarioId(usuarios, idBuscar).getEsActivo()) {
                                    JOptionPane.showMessageDialog(null, "El cliente se ha desactivado de forma correcta");
                                    buscarUsuarioId(usuarios, idBuscar).setEsActivo(false);
                                } else {
                                    JOptionPane.showMessageDialog(null, "El cliente se ha activado de forma correcta");
                                    buscarUsuarioId(usuarios, idBuscar).setEsActivo(true);
                                }
                                break;

                            case 2:
                                System.out.println(" ");
                                break;
                            case 3:
                                System.out.println("movimientos");
                                break;
                            case 4:
                                System.out.println("movimientos");
                                break;
                            case 5:
                                System.out.println("movimientos");
                                break;
                            case 6:
                                System.out.println("movimientos");
                                break;
                            default:
                                break;
                        }
                    break;

                    // cinco cuentas
                    case 5:
                        int opc5 = JOptionPane.showOptionDialog(null, "Como desea proceder?", "Cliente encontrado",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesBotones, opcionesBotones[0]);
                        switch (opc5) {
                            case 0:
                                actualizarUsuario(usuarios, idBuscar);
                                break;
                            case 1:
                                if (buscarUsuarioId(usuarios, idBuscar).getEsActivo()) {
                                    JOptionPane.showMessageDialog(null, "El cliente se ha desactivado de forma correcta");
                                    buscarUsuarioId(usuarios, idBuscar).setEsActivo(false);
                                } else {
                                    JOptionPane.showMessageDialog(null, "El cliente se ha activado de forma correcta");
                                    buscarUsuarioId(usuarios, idBuscar).setEsActivo(true);
                                }
                                break;

                            case 2:
                                System.out.println(" ");
                                break;
                            case 3:
                                System.out.println("movimientos");
                                break;
                            case 4:
                                System.out.println("movimientos");
                                break;
                            case 5:
                                System.out.println("movimientos");
                                break;
                            case 6:
                                System.out.println("movimientos");
                                break;
                            case 7:
                                System.out.println("movimientos");
                                break;
                            default:
                                break;
                        }
                    break;
                }
            }
        }
        return null;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // menu cliente
    public static void menuCliente(Cuenta cuentas[], Usuario usuario, Usuario usuarios[]) {
        int opc = getBotones("Bienvenido al Menu Cliente\n Seleccione una opcion", "Menu Cliente",
                JOptionPane.QUESTION_MESSAGE, new String[]{"Realizar Transacciones", "Mis Cuentas", "Actualizar", "Salir"});

        switch (opc) {
            case 0:
                realizarTransaccion(cuentas, usuario, usuarios);
                menuCliente(cuentas, usuario, usuarios);
                break;
            case 1:
                mostrarCuentas(usuario.getListaCuentas());
                menuCliente(cuentas, usuario, usuarios);
                break;
            case 2:
                actualizarUsuario(usuarios, usuario.getId());
                menuCliente(cuentas, usuario, usuarios);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Gracias por visitarnos!");
                break;
            default:
                System.out.println("opcion invalida");
                break;
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // METODOS COMPARTIDOS
    // generales
    public static int getBotones(String mensaje, String titulo, int tipoMensaje, String botones[]) {
        return JOptionPane.showOptionDialog(null, mensaje, titulo, JOptionPane.DEFAULT_OPTION,
                tipoMensaje, null, botones, botones[0]);
    }

    private static boolean validarCorreo(String correo) {
        int indiceArroba = correo.indexOf("@");
        if (indiceArroba >= 0 && correo.indexOf(".", indiceArroba) > indiceArroba) {
            return true;
        }
        return false;
    }

    // usuario
    public static int getIndexUsuario(Usuario usuarios[]) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private static Usuario buscarUsuarioId(Usuario usuarios[], int idBuscar) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] == null) {
                return null;
            }
            if (usuarios[i].getId() == (idBuscar)) {
                return usuarios[i];
            }
        }
        return null;
    }

    private static Usuario buscarUsuarioNombre(Usuario usuarios[], String nombreBuscar) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] == null) {
                return null;
            }
            if (usuarios[i].getNombreUsuario().equalsIgnoreCase(nombreBuscar)) {
                return usuarios[i];
            }
        }
        return null;
    }

    public static Usuario solicitarUsuario(Usuario usuarios[]) {
        String usuario = JOptionPane.showInputDialog(null, "Ingrese su nombre de usuario: ");
        Usuario usuarioEncontrar = buscarUsuarioNombre(usuarios, usuario);

        if (usuarioEncontrar == null) {
            JOptionPane.showMessageDialog(null, "No hay ningun cliente con el usuario " + usuario);
            return null;
        }

        if (usuarioEncontrar.getNombreUsuario().equalsIgnoreCase(usuario)) {
            boolean estado = usuarioEncontrar.getEsActivo();

            if (!estado) {
                JOptionPane.showMessageDialog(null, "El cliente esta inactivo");
                solicitarUsuario(usuarios);
                return null;
            } else {
                JOptionPane.showMessageDialog(null, "Bienvenido " + usuarioEncontrar.getNombre() + "!");
                return usuarioEncontrar;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay ningun cliente con el usuario " + usuario);
            solicitarUsuario(usuarios);
        }
        return null;
    }

    private static void actualizarUsuario(Usuario usuarios[], int idBuscar) {
        int opt = getBotones("Que desea actualizar?", "Actualizar", JOptionPane.QUESTION_MESSAGE,
                new String[]{"Nombre completo", "Telefono", "Correo", "Cancelar"});

        switch (opt) {
            case 0:
                String nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre: ");
                String ap1 = JOptionPane.showInputDialog(null, "Ingrese su primer apellido: ");
                String ap2 = JOptionPane.showInputDialog(null, "Ingrese su segundo apellido: ");
                buscarUsuarioId(usuarios, idBuscar).setNombre(nombre);
                buscarUsuarioId(usuarios, idBuscar).setApellido1(ap1);
                buscarUsuarioId(usuarios, idBuscar).setApellido2(ap2);
                JOptionPane.showMessageDialog(null, "Datos actualizados con exito");
                break;
            case 1:
                String telefono = JOptionPane.showInputDialog(null, "Ingrese su numero telefonico: ");
                buscarUsuarioId(usuarios, idBuscar).setTelefono(telefono);
                JOptionPane.showMessageDialog(null, "Datos actualizados con exito");
                break;
            case 2:
                String correo = JOptionPane.showInputDialog(null, "Ingrese su correo electornico: ");
                if (validarCorreo(correo)) {
                    correo = correo;
                } else {
                    JOptionPane.showMessageDialog(null, "Correo invalido");
                    int opc2 = getBotones("Desea ingresar otro correo?", "Correo invalido",
                            JOptionPane.WARNING_MESSAGE, new String[]{"Agregar otro correo", "Cancelar"});
                    if (opc2 == 0) {
                        correo = JOptionPane.showInputDialog(null, "Ingrese su correo electornico: ");
                        validarCorreo(correo);
                    } else {
                        return;
                    }
                }
                buscarUsuarioId(usuarios, idBuscar).setCorreo(correo);
                JOptionPane.showMessageDialog(null, "Datos actualizados con exito");
                break;
            default:
                break;
        }
    }

    // cuentas
    private static int getIndexCuenta(Cuenta cuentas[]) {
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private static Cuenta buscarCuentaNumero(Cuenta cuentas[], int numeroBuscar) {
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] == null) {
                return null;
            }
            if (cuentas[i].getNumeroCuenta() == numeroBuscar) {
                return cuentas[i];
            }
        }
        return null;
    }

    private static void mostrarCuentas(Cuenta cuentas[]) {
        if (cuentas == null || cuentas.length == 0) {
            System.out.println("La lista de cuentas está vacía\n");
        } else {
            System.out.println("**** CUENTAS **** ");
            boolean encontradoNull = false;

            for (int i = 0; i < cuentas.length && !encontradoNull; i++) {
                if (cuentas[i] != null) {
                    if (cuentas[i].getUsuario() != null) {
                        System.out.println((i + 1) + ") " + cuentas[i].getNumeroCuenta() + " " +
                                "Usuario: " + cuentas[i].getUsuario().getNombreCompleto() + " " +
                                "Saldo: " + cuentas[i].getSaldo() + " " +
                                "Estado: " + cuentas[i].getEsActiva() + " " +
                                "Tipo de cuenta: " + cuentas[i].getTipoCuenta() + " " +
                                "Fecha de apertura: " + cuentas[i].getFechaApertura());
                    } else {
                        System.out.println((i + 1) + ") " + cuentas[i].getNumeroCuenta() + " " +
                                "Saldo: " + cuentas[i].getSaldo() + " " +
                                "Estado: " + cuentas[i].getEsActiva() + " " +
                                "Tipo de cuenta: " + cuentas[i].getTipoCuenta() + " " +
                                "Fecha de apertura: " + cuentas[i].getFechaApertura());
                    }
                } else {
                    encontradoNull = true;
                    // System.out.println((i + 1) + ") La cuenta está vacía (null)");
                }
            }
        }
    }

    private static void agregarCuenta(Cuenta cuentas[], Usuario usuarios[]) {
        if (getIndexCuenta(cuentas) == -1) {
            JOptionPane.showMessageDialog(null, "La lista de cuentas esta llena");
            return;
        }

        // info necesarioa para llenar la cuenta
        int idCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del cliente: "));
        TipoCuenta tipoCuenta = null;
        double saldo = 0;
        boolean esActiva = true;
        Usuario usuario =  null;

        // revisar que ese cliente exista
        if (buscarUsuarioId(usuarios, idCliente) == null) {
            JOptionPane.showMessageDialog(null, "El cliente con el ID " + idCliente + " " +
                    "no se encuentra registrado en el sistema");
            int opc = getBotones("Desea ingresar otro ID?", "Cliente no encontrado", JOptionPane.WARNING_MESSAGE,
                    new String[]{"Ingresar otro ID", "Cancelar"});
            if (opc == 1 || opc == -1) {
                return;
            } else if (opc == 0) {
                agregarCuenta(cuentas, usuarios);
            }
        } else {
            int contadorCuentas = 0;
            for (int i = 0; i < buscarUsuarioId(usuarios, idCliente).getListaCuentas().length; i++) {
                if (buscarUsuarioId(usuarios, idCliente).getListaCuentas()[i] != null) {
                    contadorCuentas++;
                }
            }

            if (contadorCuentas == 5) {
                JOptionPane.showMessageDialog(null, "El cliente " + idCliente + " " +
                        "ya tiene 5 cuentas");
                return;
            } else {
                int opc = getBotones("Que tipo de cuenta desea agregar?", "Tipo de cuenta",
                        JOptionPane.DEFAULT_OPTION, new String[]{"Cuenta Corriente", "Ahorros", "Inversion", "Planilla"});
                if (opc == 0) {
                    tipoCuenta = TipoCuenta.CUENTA_CORRIENTE;
                } else if (opc == 1) {
                    tipoCuenta = TipoCuenta.AHORROS;
                } else if (opc == 2) {
                    tipoCuenta = TipoCuenta.INVERSION;
                } else if (opc == 3) {
                    tipoCuenta = TipoCuenta.PLANILLA;
                } else {
                    tipoCuenta = TipoCuenta.CUENTA_CORRIENTE;
                }

                saldo = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el saldo inicial: "));

                usuario = buscarUsuarioId(usuarios, idCliente);
            }
        }

        Cuenta nuevaCuenta = new Cuenta(idCliente, tipoCuenta, saldo, esActiva, usuario);
        cuentas[getIndexCuenta(cuentas)] = nuevaCuenta;

        // asignar la cuenta al usuario
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                if (usuarios[i].getId() == idCliente) {
                    for (int j = 0; j < usuarios[i].getListaCuentas().length; j++) {
                        if (usuarios[i].getListaCuentas()[j] == null) {
                            usuarios[i].getListaCuentas()[j] = nuevaCuenta;
                            break;
                        }
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Cuenta agregada con exito");

    }

    private static Cuenta buscarCuenta(Cuenta cuentas[]) {
        int numCuenta = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de cuenta: "));

        if (buscarCuentaNumero(cuentas, numCuenta) == null) {
            int opc = getBotones("La cuenta con el numero " + numCuenta + " no se encuentra registrada en el sistema",
                    "Cuenta no encontrada", JOptionPane.WARNING_MESSAGE, new String[]{"Ingresar otro numero", "Cancelar"});
            if (opc == 1 || opc == -1) {
                return null;
            } else if (opc == 0) {
                return buscarCuenta(cuentas);
            }
        } else {
            int opt = getBotones("Que desea hacer?", "Cuenta encontrada", JOptionPane.QUESTION_MESSAGE,
                    new String[]{"Ver movimientos", "Cancelar"});

            if (opt == 1 || opt == -1) {
                return null;
            } else if (opt == 0) {
                System.out.println("ver movimientos");
            }
        }
        return null;
    }

    // transacciones
    private static void realizarTransaccion(Cuenta cuentas[], Usuario usuario, Usuario usuarios[]) {
        int tipoTransaccion = getBotones("Que tipo de transaccion desea realizar?", "Tipo de transaccion",
                JOptionPane.DEFAULT_OPTION, new String[]{"Deposito", "Retiro", "Transferencia", "Compra", "Cancelar"});
        Cuenta cuentaTransaccion = null;
        int cantidadTransacciones = 0;

        switch (tipoTransaccion) {
            case 0:
                realizarDeposito(usuario, cuentas, cuentaTransaccion, usuarios, usuario.getHistorialTransacciones(), cantidadTransacciones);
                break;
            case 1:
                realizarRetiro(usuario, cuentas, cuentaTransaccion, usuarios, usuario.getHistorialTransacciones(), cantidadTransacciones);
                break;
            case 2:
                realizarTransferencia(usuario, cuentas, cuentaTransaccion, usuarios, usuario.getHistorialTransacciones(), cantidadTransacciones);
                break;
            case 3:
                realizarCompra(usuario, cuentas, cuentaTransaccion, usuarios, usuario.getHistorialTransacciones(), cantidadTransacciones);
                break;
            case 4:
                realizarCompra(usuario, cuentas, cuentaTransaccion, usuarios, usuario.getHistorialTransacciones(), cantidadTransacciones);
                break;
            default:
                break;
        }

    }

    private static void realizarDeposito(Usuario usuario, Cuenta cuentas[], Cuenta cuentaTransaccion, Usuario usuarios[], Transaccion[] transacciones, int cantidadTransacciones) {
        int cuentaCount = 0;
        for (int i = 0; i < usuario.getListaCuentas().length; i++) {
            if (usuario.getListaCuentas()[i] != null) {
                cuentaCount++;
            }
        }

        if (cuentaCount == 0) {
            JOptionPane.showMessageDialog(null, "Usted no tiene cuentas asociadas");
            menuCliente(cuentas, usuario, usuarios);
        } else if (cuentaCount == 1) {
            cuentaTransaccion = usuario.getListaCuentas()[0];
        } else {
            String[] cuentasUsuario = new String[cuentaCount];
            for (int i = 0; i < cuentaCount; i++) {
                cuentasUsuario[i] = usuario.getListaCuentas()[i].getNumeroCuenta() + "";
            }

            int opc = JOptionPane.showOptionDialog(null, "Seleccione la cuenta a la que desea realizar el deposito",
                    "Cuentas asociadas", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    cuentasUsuario, cuentasUsuario[0]);

            cuentaTransaccion = buscarCuentaNumero(cuentas, Integer.parseInt(cuentasUsuario[opc]));
        }

        double saldoDeposito = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el monto a depositar: "));
        cuentaTransaccion.setSaldo(cuentaTransaccion.getSaldo() + saldoDeposito);
        String detalleTransaccion = JOptionPane.showInputDialog(null, "Ingrese el detalle de la transaccion: ");

        Transaccion nuevoDeposito = new Transaccion(cuentaTransaccion, null, detalleTransaccion, saldoDeposito);

        if (cantidadTransacciones < transacciones.length) {
            transacciones[cantidadTransacciones] = nuevoDeposito;
            cantidadTransacciones++;
        }

        JOptionPane.showMessageDialog(null, "Deposito exitoso");
    }

    private static void realizarRetiro(Usuario usuario, Cuenta cuentas[], Cuenta cuentaTransaccion, Usuario usuarios[], Transaccion[] transacciones, int cantidadTransacciones) {
        int cuentaCount = 0;
        for (int i = 0; i < usuario.getListaCuentas().length; i++) {
            if (usuario.getListaCuentas()[i] != null) {
                cuentaCount++;
            }
        }

        if (cuentaCount == 0) {
            JOptionPane.showMessageDialog(null, "Usted no tiene cuentas asociadas");
            menuCliente(cuentas, usuario, usuarios);
        } else if (cuentaCount == 1) {
            cuentaTransaccion = usuario.getListaCuentas()[0];
        } else {
            String[] cuentasUsuario = new String[cuentaCount];
            for (int i = 0; i < cuentaCount; i++) {
                cuentasUsuario[i] = usuario.getListaCuentas()[i].getNumeroCuenta() + "";
            }

            int opc = JOptionPane.showOptionDialog(null, "Seleccione la cuenta a la que desea realizar el deposito",
                    "Cuentas asociadas", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    cuentasUsuario, cuentasUsuario[0]);

            cuentaTransaccion = buscarCuentaNumero(cuentas, Integer.parseInt(cuentasUsuario[opc]));
        }

        double saldoRetiro = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el monto a retirar: "));

        if (saldoRetiro > cuentaTransaccion.getSaldo()) {
            JOptionPane.showMessageDialog(null, "El monto a retirar es mayor al saldo de la cuenta");
            realizarRetiro(usuario, cuentas, cuentaTransaccion, usuarios, transacciones, cantidadTransacciones);
        } else {
            cuentaTransaccion.setSaldo(cuentaTransaccion.getSaldo() - saldoRetiro);
        }

        String detalleTransaccion = JOptionPane.showInputDialog(null, "Ingrese el detalle de la transaccion: ");

        Transaccion nuevoRetiro = new Transaccion(cuentaTransaccion, null, detalleTransaccion, saldoRetiro);

        if (cantidadTransacciones < transacciones.length) {
            transacciones[cantidadTransacciones] = nuevoRetiro;
            cantidadTransacciones++;
        }

        System.out.println(transacciones[cantidadTransacciones - 1]);

        JOptionPane.showMessageDialog(null, "Retiro exitoso");
    }

    private static void realizarTransferencia(Usuario usuario, Cuenta cuentas[], Cuenta cuentaTransaccion, Usuario usuarios[], Transaccion[] transacciones, int cantidadTransacciones) {
        int cuentaCount = 0;
        for (int i = 0; i < usuario.getListaCuentas().length; i++) {
            if (usuario.getListaCuentas()[i] != null) {
                cuentaCount++;
            }
        }

        if (cuentaCount == 0) {
            JOptionPane.showMessageDialog(null, "Usted no tiene cuentas asociadas");
            menuCliente(cuentas, usuario, usuarios);
        } else if (cuentaCount == 1) {
            cuentaTransaccion = usuario.getListaCuentas()[0];
        } else {
            String[] cuentasUsuario = new String[cuentaCount];
            for (int i = 0; i < cuentaCount; i++) {
                cuentasUsuario[i] = usuario.getListaCuentas()[i].getNumeroCuenta() + "";
            }

            int opc = JOptionPane.showOptionDialog(null, "Seleccione la cuenta desde la que desea trasnferir",
                    "Cuentas asociadas", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    cuentasUsuario, cuentasUsuario[0]);

            cuentaTransaccion = buscarCuentaNumero(cuentas, Integer.parseInt(cuentasUsuario[opc]));
        }

        if (cuentaTransaccion.getSaldo() == 0) {
            JOptionPane.showMessageDialog(null, "La cuenta seleccionada no tiene saldo");
            realizarTransferencia(usuario, cuentas, cuentaTransaccion, usuarios, transacciones, cantidadTransacciones);
        }

        int numeroCuentaDestino = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de cuenta destino: "));

        // revisar numero cuenta destino con todas las cuentas del sistema
        Cuenta cuentaDestino = buscarCuentaNumero(cuentas, numeroCuentaDestino);
        if (cuentaDestino == null) {
            JOptionPane.showMessageDialog(null, "El numero de cuenta destino no se encuentra registrado en el sistema");
            realizarTransferencia(usuario, cuentas, cuentaTransaccion, usuarios, transacciones, cantidadTransacciones);
        }

        double montoDepositar = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el monto a depositar: "));

        if (montoDepositar > cuentaTransaccion.getSaldo()) {
            JOptionPane.showMessageDialog(null, "El monto a depositar es mayor al saldo de la cuenta");
            realizarTransferencia(usuario, cuentas, cuentaTransaccion, usuarios, transacciones, cantidadTransacciones);
        }

        String detalleTransferencia = JOptionPane.showInputDialog(null, "Ingrese el detalle de la transferencia: ");
        cuentaTransaccion.setSaldo(cuentaTransaccion.getSaldo() - montoDepositar);
        cuentaDestino.setSaldo(cuentaDestino.getSaldo() + montoDepositar);

        Transaccion nuevaTransferencia = new Transaccion(cuentaTransaccion, cuentaDestino, detalleTransferencia, montoDepositar);

        if (cantidadTransacciones < transacciones.length) {
            transacciones[cantidadTransacciones] = nuevaTransferencia;
            cantidadTransacciones++;
        }

        JOptionPane.showMessageDialog(null, "Transferencia exitosa");

    }

    private static void realizarCompra(Usuario usuario, Cuenta cuentas[], Cuenta cuentaTransaccion, Usuario usuarios[], Transaccion[] transacciones, int cantidadTransacciones) {
        int cuentaCount = 0;
        for (int i = 0; i < usuario.getListaCuentas().length; i++) {
            if (usuario.getListaCuentas()[i] != null) {
                cuentaCount++;
            }
        }

        if (cuentaCount == 0) {
            JOptionPane.showMessageDialog(null, "Usted no tiene cuentas asociadas");
            menuCliente(cuentas, usuario, usuarios);
        } else if (cuentaCount == 1) {
            cuentaTransaccion = usuario.getListaCuentas()[0];
        } else {
            String[] cuentasUsuario = new String[cuentaCount];
            for (int i = 0; i < cuentaCount; i++) {
                cuentasUsuario[i] = usuario.getListaCuentas()[i].getNumeroCuenta() + "";
            }

            int opc = JOptionPane.showOptionDialog(null, "Seleccione la cuenta con la que va a pagar",
                    "Cuentas asociadas", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    cuentasUsuario, cuentasUsuario[0]);

            cuentaTransaccion = buscarCuentaNumero(cuentas, Integer.parseInt(cuentasUsuario[opc]));
        }

        double montoPagar = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el monto a pagar: "));

        if (montoPagar > cuentaTransaccion.getSaldo()) {
            JOptionPane.showMessageDialog(null, "El monto a pagar es mayor al saldo de la cuenta");
            realizarRetiro(usuario, cuentas, cuentaTransaccion, usuarios, transacciones, cantidadTransacciones);
        } else {
            cuentaTransaccion.setSaldo(cuentaTransaccion.getSaldo() - montoPagar);
        }

        String detalleCompra = JOptionPane.showInputDialog(null, "Ingrese el detalle de la compra: ");

        Transaccion nuevoRetiro = new Transaccion(cuentaTransaccion, null, detalleCompra, montoPagar);

        if (cantidadTransacciones < transacciones.length) {
            transacciones[cantidadTransacciones] = nuevoRetiro;
            cantidadTransacciones++;
        }

        JOptionPane.showMessageDialog(null, "Compra exitosa");
    }

    private static void mostrarTransacciones(Transaccion[] transacciones) {
        if (transacciones[0] == null) {
            System.out.println("La lista de transacciones esta vacia\n");
        } else {
            System.out.println("**** TRANSACCIONES **** ");
            for (int i = 0; i < transacciones.length; i++){
                if (transacciones[i] != null) {
                    System.out.println((i + 1) + ") " + transacciones[i].getDatos());
                }
            }
        }
    }

}
