import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        menuPrincipal();
    }

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
                    JOptionPane.showMessageDialog(null, "Generar datos");
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
