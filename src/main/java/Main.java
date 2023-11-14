import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        menuPrincipal();
    }

    // MENU PRINCIPAL
    public static void menuPrincipal(){
        int opc = 0;

        do {
            opc = mostrarMenu();

            switch (opc) {
                case 1:
                    menuBanco();
                    break;
                case 2:
                    menuCliente();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Gracias por su visita!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                    break;
            }

        } while (opc != 3);

    }

    public static int mostrarMenu(){
        String[] opciones = {"Banco", "Clientes", "Salir"};
        int respuesta = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Menú Principal",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        return respuesta + 1;
    }


    // MENU BANCARIO
    public static int mostrarMenuBanco(){
        String opciones = JOptionPane.showInputDialog(null, "Seleccione el modulo al que desea acceder: " +
                "\n1. Generar datos" +
                "\n2. Mostrar clientes" +
                "\n3. Mostrar cuentas y movimientos" +
                "\n4. Agregar nuevo cliente" +
                "\n5. Agregar nueva cuenta" +
                "\n6. Buscar cliente" +
                "\n7. Buscar cuenta" +
                "\n8. Generar reportes" +
                "\n9. Salir");

        if (opciones == null){
            return 0;
        }

        return Integer.parseInt(opciones);
    }

    public static void menuBanco() {
        int opc = 0;

        do {
            opc = mostrarMenuBanco();

            switch(opc){
                case 1:
                    generarDatos();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Mostrar clientes");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Mostrar cuentas y movimientos");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Agregar nuevo cliente");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Agregar nueva cuenta");
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Buscar cliente");
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Buscar cuenta");
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Generar reportes");
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Salir del menu bancario");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                    break;

            }

        } while (opc != 9 );

    }

    public static void generarDatos() {
        Usuario usuarioArray[] = new Usuario[10];
        Cuenta[] cuentaArray = new Cuenta[12];

        // usuarios
        usuarioArray[0] = new Usuario(1, "Diego", "Naranjo", "Meza", 119150430, "diego@correo.com", "60469117", "lista", 1, "diegonm", "12-34-56", "activo", true);
        usuarioArray[1] = new Usuario(2, "Maria", "Lopez", "Gomez", 219876543, "maria@correo.com", "60234567", "otra lista", 2, "marialg", "78-90-12", "activo", true);
        usuarioArray[2] = new Usuario(3, "Carlos", "Fernandez", "Perez", 319654321, "carlos@correo.com", "60987654", "otra lista", 3, "carlosfp", "34-56-78", "activo", true);
        usuarioArray[3] = new Usuario(4, "Ana", "Gonzalez", "Rodriguez", 419876543, "ana@correo.com", "60123456", "otra lista", 1, "anagr", "90-12-34", "inactivo", false);
        usuarioArray[4] = new Usuario(5, "Luis", "Hernandez", "Diaz", 519654321, "luis@correo.com", "60987654", "otra lista", 2, "luishd", "56-78-90", "activo", true);
        usuarioArray[5] = new Usuario(6, "Laura", "Serrano", "Blanco", 619876543, "laura@correo.com", "60234567", "otra lista", 3, "laurasb", "12-34-56", "activo", true);
        usuarioArray[6] = new Usuario(7, "Pedro", "Molina", "Vargas", 719654321, "pedro@correo.com", "60987654", "otra lista", 1, "pedromv", "78-90-12", "activo", true);
        usuarioArray[7] = new Usuario(8, "Elena", "Cabrera", "Castro", 819876543, "elena@correo.com", "60123456", "otra lista", 2, "elenacc", "34-56-78", "activo", true);
        usuarioArray[8] = new Usuario(9, "Miguel", "Serrano", "Ruiz", 919654321, "miguel@correo.com", "60987654", "otra lista", 3, "miguelsr", "90-12-34", "inactivo", false);
        usuarioArray[9] = new Usuario(10, "Isabel", "Ruiz", "Gomez", 101987654, "isabel@correo.com", "60234567", "otra lista", 1, "isabelrg", "56-78-90", "activo", false);

        // cuentas
        cuentaArray[0] = new Cuenta(1, usuarioArray[0].getId(), "Movimientos de la cuenta 1", "Cuenta Corriente", cuentaArray[0].getFechaApertura(), 1500.0, true);
        cuentaArray[1] = new Cuenta(2, usuarioArray[0].getId(), "Movimientos de la cuenta 2", "Cuenta de Ahorros", cuentaArray[1].getFechaApertura(), 2500.0, true);
        cuentaArray[2] = new Cuenta(3, usuarioArray[1].getId(), "Movimientos de la cuenta 3", "Cuenta Corriente", cuentaArray[2].getFechaApertura(), 3500.0, true);
        cuentaArray[3] = new Cuenta(4, usuarioArray[1].getId(), "Movimientos de la cuenta 4", "Cuenta de Ahorros", cuentaArray[3].getFechaApertura(), 4500.0, true);
        cuentaArray[4] = new Cuenta(5, usuarioArray[2].getId(), "Movimientos de la cuenta 5", "Cuenta Corriente", cuentaArray[4].getFechaApertura(), 5500.0, true);
        cuentaArray[5] = new Cuenta(6, usuarioArray[0].getId(), "Movimientos de la cuenta 6", "Cuenta de Ahorros", cuentaArray[5].getFechaApertura(), 6500.0, true);
        cuentaArray[6] = new Cuenta(7, usuarioArray[4].getId(), "Movimientos de la cuenta 7", "Cuenta Corriente", cuentaArray[6].getFechaApertura(), 7500.0, true);
        cuentaArray[7] = new Cuenta(8, usuarioArray[5].getId(), "Movimientos de la cuenta 8", "Cuenta de Ahorros", cuentaArray[7].getFechaApertura(), 8500.0, true);
        cuentaArray[8] = new Cuenta(9, usuarioArray[6].getId(), "Movimientos de la cuenta 9", "Cuenta Corriente", cuentaArray[8].getFechaApertura(), 9500.0, true);
        cuentaArray[9] = new Cuenta(10, usuarioArray[7].getId(), "Movimientos de la cuenta 10", "Cuenta de Ahorros", cuentaArray[9].getFechaApertura(), 10500.0, true);
        cuentaArray[10] = new Cuenta(11, usuarioArray[8].getId(), "Movimientos de la cuenta 11", "Cuenta Corriente", cuentaArray[10].getFechaApertura(), 11500.0, true);
        cuentaArray[11] = new Cuenta(12, usuarioArray[9].getId(), "Movimientos de la cuenta 12", "Cuenta de Ahorros", cuentaArray[11].getFechaApertura(), 12500.0, true);

    }

    // MENU CLIENTE
    public static int mostarMenuCliente() {
        String opciones = JOptionPane.showInputDialog(null, "Seleccione el modulo al que desea acceder: " +
                "\n1. Realizar Transacciones" +
                "\n2. Mis cuentas" +
                "\n3. Actualizar mis datos" +
                "\n4. Salir");

        if (opciones == null){
            return 0;
        }

        return Integer.parseInt(opciones);
    }

    public static void menuCliente() {
        int opc = 0;

        do {
            opc = mostarMenuCliente();

            switch (opc){
                case 1:
                    JOptionPane.showMessageDialog(null, "Realizar transacciones");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Mis cuentas");
                    break;
                case 3: JOptionPane.showMessageDialog(null, "actualizar mis datos");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del presente modulo");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                    break;
            }

        } while (opc != 4);

    }

}
