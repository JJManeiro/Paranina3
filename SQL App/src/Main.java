import javax.swing.*;
import java.sql.*;
public class Main {
    public static void main(String[] args) {
        Methods M = new Methods();
        String[] Opt = {"Insertar", "Borrar", "Consultar", "Modificar","Salir"};
        String o = "";
        do {
            o = (String) JOptionPane.showInputDialog(null, "Bienvenido a la base de datos.",
                    "SQL App", JOptionPane.QUESTION_MESSAGE, null, Opt, Opt[0]);
            if (o == null) {
                o = "";
                JOptionPane.showMessageDialog(null, "No se seleccionó ninguna opción.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            switch (o.toUpperCase()){
                case "INSERTAR":
                    M.Insertar();
                    break;
                case "BORRAR":
                    M.Eliminar();
                    break;
                case "CONSULTAR":
                    M.Consultar();
                    break;
                case "MODIFICAR":
                    M.Cambiar();
                    break;
                case "SALIR":
                    System.exit(0);
                    break;
            }
        } while (o.equalsIgnoreCase("SALIR"));
    }
}