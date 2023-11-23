import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // creacion de arreglos
        Usuario usuarios[] = new Usuario[30];
        Cuenta cuentas[] = new Cuenta[12];
        boolean generados = false;

        // el usuario selecciona que menu quiere ver
        int opcion = Metodos.getBotones("Bienvenido a Hiperbanco! \n \nA cual menu desea acceder?", "Menu",
                JOptionPane.QUESTION_MESSAGE, new String[]{"Banco", "Clientes", "Salir"});

        // revisar cual opcion selecciono el usuario
        if (opcion == -1 || opcion == 2) {
            JOptionPane.showMessageDialog(null, "Gracias por visitarnos!");
            return;
        }

        if (opcion == 0) {
            Metodos.menuBanco(usuarios, cuentas, generados);
        }

        if (opcion == 1) {
            Metodos.menuCliente();
        }

    }
}