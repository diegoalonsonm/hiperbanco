import javax.swing.*;

public class Metodos {

    // METODOS DEL MENU

    // menu banco
    public static void menuBanco(Usuario usuarios[]) {
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
                    generarDatos(usuarios);
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
                    System.out.println("buscar cliente");
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
    private static void generarDatos(Usuario usuarios[]) {

        Usuario usuariosGenerados[] = new Usuario[10];

        // creacion de usuarios
        usuariosGenerados[0] = new Usuario("1", "Diego", "Naranjo", "Meza", 119150430, "diego@correo.com", "6046-9117", "lista", 1, "diegonm", "12-34-56", "activo", true);
        usuariosGenerados[1] = new Usuario("2", "Maria", "Lopez", "Gomez", 219876543, "maria@correo.com", "6023-4567", "otra lista", 2, "marialg", "78-90-12", "activo", true);
        usuariosGenerados[2] = new Usuario("3", "Carlos", "Fernandez", "Perez", 319654321, "carlos@correo.com", "6098-7654", "otra lista", 2, "carlosfp", "34-56-78", "activo", true);
        usuariosGenerados[3] = new Usuario("4", "Ana", "Gonzalez", "Rodriguez", 419876543, "ana@correo.com", "6012-3456", "otra lista", 1, "anagr", "90-12-34", "inactivo", false);
        usuariosGenerados[4] = new Usuario("5", "Luis", "Hernandez", "Diaz", 519654321, "luis@correo.com", "6098-7654", "otra lista", 2, "luishd", "56-78-90", "activo", true);
        usuariosGenerados[5] = new Usuario("6", "Laura", "Serrano", "Blanco", 619876543, "laura@correo.com", "6023-4567", "otra lista", 2, "laurasb", "12-34-56", "activo", true);
        usuariosGenerados[6] = new Usuario("7", "Pedro", "Molina", "Vargas", 719654321, "pedro@correo.com", "6098-7654", "otra lista", 1, "pedromv", "78-90-12", "activo", true);
        usuariosGenerados[7] = new Usuario("8", "Elena", "Cabrera", "Castro", 819876543, "elena@correo.com", "6012-3456", "otra lista", 2, "elenacc", "34-56-78", "activo", true);
        usuariosGenerados[8] = new Usuario("9", "Miguel", "Serrano", "Ruiz", 919654321, "miguel@correo.com", "6098-7654", "otra lista", 1, "miguelsr", "90-12-34", "inactivo", false);
        usuariosGenerados[9] = new Usuario("10", "Isabel", "Ruiz", "Gomez", 1019876543, "isabel@correo.com", "6023-4567", "otra lista", 1, "isabelrg", "56-78-90", "activo", true);

        for (int i = 0; i < usuariosGenerados.length; i++) {
            if (getIndexUsuario(usuarios) != -1) {
                if (buscarUsuarioId(usuarios, usuariosGenerados[i].getId()) == null) {
                    usuarios[getIndexUsuario(usuarios)] = usuariosGenerados[i];
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
            String telefono = JOptionPane.showInputDialog(null, "Ingrese su numero telefonico (xxxx-xxxx): ");
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

    /////////////////////////////////////////////////////////////
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

    // METODOS COMPARTIDOS

    // generales
    public static int getBotones(String mensaje, String titulo, int tipoMensaje, String botones[]) {
        return JOptionPane.showOptionDialog(null, mensaje, titulo, JOptionPane.DEFAULT_OPTION,
                tipoMensaje, null, botones, botones[0]);
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
        System.out.println("hola 5");
        return null;
    }

    private static void mostrarClientes(Usuario usuarios[]) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[0] == null) {
                System.out.println("La lista de usuarios esta vacia");
                return;
            }
        }

        System.out.println("**** CLIENTES **** ");
        for (int i = 0; i < usuarios.length; i++){
            if (usuarios[i] != null) {
                System.out.println((i + 1) + ") " + usuarios[i].getDatos());
            }
        }
    }

}
