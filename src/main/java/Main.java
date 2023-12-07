import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // creacion de arreglos
        Usuario usuarios[] = new Usuario[30];
        Cuenta cuentas[] = new Cuenta[50];
        Transaccion transacciones[] = new Transaccion[50];
        boolean generados = false;
        Usuario usuarioLogin = null;

        while (true) {
            // el usuario selecciona que menu quiere ver
            int opcion = Metodos.getBotones("Bienvenido a Hiperbanco! \n \nA cual menu desea acceder?", "Menu",
                    JOptionPane.QUESTION_MESSAGE, new String[]{"Banco", "Clientes", "Salir"});

            // revisar cual opcion selecciono el usuario
            if (opcion == -1 || opcion == 2) {
                JOptionPane.showMessageDialog(null, "Gracias por visitarnos!");
                break;
            }

            if (opcion == 0) {
                Metodos.menuBanco(usuarios, cuentas, generados, transacciones);
            }

            if (opcion == 1) {
                if (usuarios[0] == null) {
                    JOptionPane.showMessageDialog(null, "No hay usuarios registrados");
                } else {
                    usuarioLogin = Metodos.solicitarUsuario(usuarios);
                    if (usuarioLogin == null) {
                        JOptionPane.showMessageDialog(null, "Ingrese de nuevo el usuario");
                    } else {
                        Metodos.menuCliente(cuentas, usuarioLogin, usuarios);
                    }
                }
            }
        }
    }
}
