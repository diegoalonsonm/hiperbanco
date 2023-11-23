import javax.swing.*;

public class Metodos {

    // METODOS DEL MENU
    // menu banco
    public static void menuBanco(Usuario usuarios[], Cuenta cuentas[], boolean generados) {
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
                    System.out.println("mostrar cuentas y movimientos");
                    break;
                case 4:
                    agregarUsuario(usuarios);
                    break;
                case 5:
                    System.out.println("agregar nueva cuenta");
                    break;
                case 6:
                    buscarCliente(usuarios);
                    break;
                case 7:
                    System.out.println("buscar cuenta");
                    break;
                case 8:
                    System.out.println("generar reportes");
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

    // generar datos
    private static void generarDatos(Usuario usuarios[], Cuenta cuentas[]) {

        Usuario usuariosGenerados[] = new Usuario[10];
        Cuenta cuentasGeneradas[] = new Cuenta[12];

        // creacion de usuarios
        usuariosGenerados[0] = new Usuario("1", "Diego", "Naranjo", "Meza", 119150430, "diego@correo.com", "60469117", "lista", 1, "diegonm", "12-34-56", "activo", true);
        usuariosGenerados[1] = new Usuario("2", "Maria", "Lopez", "Gomez", 219876543, "maria@correo.com", "60234567", "otra lista", 2, "marialg", "78-90-12", "activo", true);
        usuariosGenerados[2] = new Usuario("3", "Carlos", "Fernandez", "Perez", 319654321, "carlos@correo.com", "60987654", "otra lista", 2, "carlosfp", "34-56-78", "activo", true);
        usuariosGenerados[3] = new Usuario("4", "Ana", "Gonzalez", "Rodriguez", 419876543, "ana@correo.com", "60123456", "otra lista", 1, "anagr", "90-12-34", "inactivo", false);
        usuariosGenerados[4] = new Usuario("5", "Luis", "Hernandez", "Diaz", 519654321, "luis@correo.com", "60987654", "otra lista", 2, "luishd", "56-78-90", "activo", true);
        usuariosGenerados[5] = new Usuario("6", "Laura", "Serrano", "Blanco", 619876543, "laura@correo.com", "60234567", "otra lista", 2, "laurasb", "12-34-56", "activo", true);
        usuariosGenerados[6] = new Usuario("7", "Pedro", "Molina", "Vargas", 719654321, "pedro@correo.com", "60987654", "otra lista", 1, "pedromv", "78-90-12", "activo", true);
        usuariosGenerados[7] = new Usuario("8", "Elena", "Cabrera", "Castro", 819876543, "elena@correo.com", "60123456", "otra lista", 2, "elenacc", "34-56-78", "activo", true);
        usuariosGenerados[8] = new Usuario("9", "Miguel", "Serrano", "Ruiz", 919654321, "miguel@correo.com", "60987654", "otra lista", 1, "miguelsr", "90-12-34", "inactivo", false);
        usuariosGenerados[9] = new Usuario("10", "Isabel", "Ruiz", "Gomez", 1019876543, "isabel@correo.com", "60234567", "otra lista", 1, "isabelrg", "56-78-90", "activo", true);

        // creacion de cuentas
        cuentasGeneradas[0] = new Cuenta(4710, "1", "movimientos", 1, "hoy", 250.75, true, usuariosGenerados[0]);
        cuentasGeneradas[1] = new Cuenta(4711, "2", "movimientos", 2, "hoy", 250.75, true, usuariosGenerados[1]);
        cuentasGeneradas[2] = new Cuenta(4712, "13", "movimientos", 3, "hoy", 250.75, true, usuariosGenerados[2]);
        cuentasGeneradas[3] = new Cuenta(4713, "34", "movimientos", 4, "hoy", 250.75, true, usuariosGenerados[3]);
        cuentasGeneradas[4] = new Cuenta(4714, "554", "movimientos", 4, "hoy", 250.75, true, usuariosGenerados[4]);
        cuentasGeneradas[5] = new Cuenta(4715, "6", "movimientos", 4, "hoy", 250.75, true, usuariosGenerados[5]);
        cuentasGeneradas[6] = new Cuenta(4716, "6", "movimientos", 3, "hoy", 250.75, true, usuariosGenerados[6]);
        cuentasGeneradas[7] = new Cuenta(4717, "6", "movimientos", 2, "hoy", 250.75, true, usuariosGenerados[7]);
        cuentasGeneradas[8] = new Cuenta(4718, "7", "movimientos", 1, "hoy", 250.75, true, usuariosGenerados[8]);
        cuentasGeneradas[9] = new Cuenta(4718, "71", "movimientos", 1, "hoy", 250.75, true, usuariosGenerados[9]);
        cuentasGeneradas[10] = new Cuenta(4720, "76", "movimientos", 3, "hoy", 250.75, true, usuariosGenerados[2]);
        cuentasGeneradas[11] = new Cuenta(4721, "88", "movimientos", 1, "hoy", 250.75, true, usuariosGenerados[2]);

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

        JOptionPane.showMessageDialog(null, "Datos generados con éxito");
    }

    // agregar nuevo usuario
    private static void agregarUsuario(Usuario usuarios[]) {
        if (getIndexUsuario(usuarios) == -1) {
            JOptionPane.showMessageDialog(null, "La lista de usuarios esta llena");
            return;
        }

        String id = JOptionPane.showInputDialog(null, "Ingrese el ID del usuario: ");

        if (buscarUsuarioId(usuarios, id) == null) {
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
            String listaCuentas = "";
            int rol = getBotones("Cual de los dos roles cumple el nuevo usuario?", "Rol usuario",
                    JOptionPane.DEFAULT_OPTION, new String[]{"Administrador", "Cliente"});
            if (rol == 0) {
                rol = 1;
            } else if (rol == 1) {
                rol = 2;
            } else {
                rol = 0;
            }
            String nombreUsuario = JOptionPane.showInputDialog(null, "Ingrese su nombre de usuario: ");
            String claveAcceso = "";
            String historialTransacciones = "";
            boolean esActivo = true;

            Usuario nuevoUsuario = new Usuario(id, nombre, ap1, ap2, cedula, correo, telefono, listaCuentas, rol, nombreUsuario,
                    claveAcceso, historialTransacciones, esActivo);
            usuarios[getIndexUsuario(usuarios)] = nuevoUsuario;

            JOptionPane.showMessageDialog(null, "Usuario Agregado con exito");;

        } else {
            int boton = getBotones("Cliente ya agregado en el sistema", "ID existente", JOptionPane.WARNING_MESSAGE,
                    new String[]{"Agregar otro ID", "Cancelar"});

            if (boton == 0) {
                agregarUsuario(usuarios);
            }
        }
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
        String idBuscar = JOptionPane.showInputDialog(null, "Ingrese el ID del cliente: ");

        if (buscarUsuarioId(usuarios, idBuscar) == null) {
            int opc = getBotones("El cliente con el ID " + idBuscar + "no se encuentra registrado en el sistema",
                    "Cliente no encontrado", JOptionPane.WARNING_MESSAGE, new String[]{"Ingresar otro ID", "Cancelar"});
            if (opc == 1 || opc == -1) {
                return null;
            } else if (opc == 0) {
                return buscarCliente(usuarios);
            }
        } else if (buscarUsuarioId(usuarios, idBuscar) != null) {
            String botonEstado;

            if (usuarios[getIndexUsuario(usuarios)].getEsActivo()) {
                botonEstado = "Desactivar";
            } else {
                botonEstado = "Activar";
            }

            int opc = getBotones("Como desea proceder?", "Cliente encontrado", JOptionPane.QUESTION_MESSAGE,
                    new String[]{"Actualizar", botonEstado, "Botones de cuentas", "Cancelar"});

            switch (opc) {
                case 0:
                    System.out.println("actualizar");
                    break;
                case 1:
                    if (usuarios[getIndexUsuario(usuarios)].getEsActivo()) {
                        JOptionPane.showMessageDialog(null, "El cliente se ha desactivado de forma correcta");
                        usuarios[getIndexUsuario(usuarios)].setEsActivo(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "El cliente se ha activado de forma correcta");
                        usuarios[getIndexUsuario(usuarios)].setEsActivo(true);
                    }
                    break;
                case 2:
                    System.out.println("botones de cuentas");
                    break;
                case 3:
                    System.out.println("cancelar");
                    break;
                default:
                    break;
            }
        }
        return null;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // menu cliente
    public static void menuCliente() {
        int opc = getBotones("Bienvenido al Menu Cliente\n Seleccione una opcion", "Menu Cliente",
                JOptionPane.QUESTION_MESSAGE, new String[]{"Realizar Transacciones", "Mis Cuentas", "Actualizar", "Salir"});

        switch (opc) {
            case 0:
                System.out.println("realizar transacciones");
                break;
            case 1:
                System.out.println("mis cuentas");
                break;
            case 2:
                System.out.println("actualizar");
                break;
            case 3:
                System.out.println("salir");
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
    private static int getIndexUsuario(Usuario usuarios[]) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private static Usuario buscarUsuarioId(Usuario usuarios[], String idBuscar) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] == null) {
                return null;
            }
            if (usuarios[i].getId().equalsIgnoreCase(idBuscar)) {
                return usuarios[i];
            }
        }
        return null;
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

}
