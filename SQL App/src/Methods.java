import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class Methods {
    private static final int SALIR = 0;
    private static final int EMPLEADO = 1;
    private static final int CONTRATADO = 2;
    private static final int DESTAJO = 3;

    public void Insertar() {
        int opcion = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Que tabla quieres entrar?\n1 para empleados.\n2 para contratados.\n3 para destajos.\n0 para salir."));
            switch (opcion) {
                case EMPLEADO:
                    try {
                        Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                        PreparedStatement st = cn.prepareStatement("INSERT INTO EMPLEADO (Nombre,Apellido,DNI,Ingreso,Sueldo) VALUES (?,?,?,?,?)");
                        st.setString(1, JOptionPane.showInputDialog(null, "Dame un nombre"));
                        st.setString(2, JOptionPane.showInputDialog(null, "Dame un apellido"));
                        st.setString(3, JOptionPane.showInputDialog(null, "Pasame el dni"));

                        String Sfecha = JOptionPane.showInputDialog(null, "Dime la fecha, debe ser en yyyy-MM-dd");
                        java.util.Date Dfecha = new SimpleDateFormat("yyyy-MM-dd").parse(Sfecha);
                        java.sql.Date SqlFecha = new java.sql.Date(Dfecha.getTime());
                        st.setDate(4, SqlFecha);

                        st.setInt(5, Integer.parseInt(JOptionPane.showInputDialog(null, "Dame un sueldo")));
                        int res = st.executeUpdate();
                        System.out.println("Inserción hecha:\n" + st);
                        cn.close();
                    } catch (Exception ex) {
                        System.out.println("Porqué no podrá conectar?");
                        ex.printStackTrace();
                    }
                    break;
                case CONTRATADO:
                    try {
                        Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                        PreparedStatement st = cn.prepareStatement("INSERT INTO CONTRATADOS (nombre,apellido,dni,ingreso,sueldo,antiguedad) VALUES (?,?,?,?,?,?)");
                        st.setString(1, JOptionPane.showInputDialog(null, "Dame un nombre"));
                        st.setString(2, JOptionPane.showInputDialog(null, "Dame un apellido"));
                        st.setString(3, JOptionPane.showInputDialog(null, "Pasame el dni"));

                        String Sfecha = JOptionPane.showInputDialog(null, "Dime la fecha, debe ser en yyyy-MM-dd");
                        java.util.Date Dfecha = new SimpleDateFormat("yyyy-MM-dd").parse(Sfecha);
                        java.sql.Date SqlFecha = new java.sql.Date(Dfecha.getTime());
                        st.setDate(4, SqlFecha);

                        st.setInt(5, Integer.parseInt(JOptionPane.showInputDialog(null, "Dame un sueldo")));
                        st.setInt(6, Integer.parseInt(JOptionPane.showInputDialog(null, "Dame su antiguedad")));
                        int res = st.executeUpdate();
                        System.out.println("Insercion hecha:\n" + st);
                        cn.close();
                    } catch (Exception ex) {
                        System.out.println("Porqué no podrá conectar?");
                        ex.printStackTrace();
                    }
                    break;
                case DESTAJO:
                    try {
                        Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                        PreparedStatement st = cn.prepareStatement("INSERT INTO ADESTAJO (nombre,apellido,dni,ingreso,sueldo,clientes) VALUES (?,?,?,?,?,?)");
                        st.setString(1, JOptionPane.showInputDialog(null, "Dame un nombre"));
                        st.setString(2, JOptionPane.showInputDialog(null, "Dame un apellido"));
                        st.setString(3, JOptionPane.showInputDialog(null, "Pasame el dni"));

                        String Sfecha = JOptionPane.showInputDialog(null, "Dime la fecha, debe ser en yyyy-MM-dd");
                        java.util.Date Dfecha = new SimpleDateFormat("yyyy-MM-dd").parse(Sfecha);
                        java.sql.Date SqlFecha = new java.sql.Date(Dfecha.getTime());
                        st.setDate(4, SqlFecha);

                        st.setInt(5, Integer.parseInt(JOptionPane.showInputDialog(null, "Dame un sueldo")));
                        st.setInt(6, Integer.parseInt(JOptionPane.showInputDialog(null, "Dime que clientes tuvo")));
                        int res = st.executeUpdate();
                        System.out.println("Insercion hecha:\n" + st);
                        cn.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
            }
        }
        while (opcion != SALIR);
    }

    public void Eliminar() {
        int opcion = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Que tabla quieres entrar?\n1 para empleados.\n2 para contratados.\n3 para destajos.\n0 para salir"));
            switch (opcion) {
                case EMPLEADO:
                    try {
                        Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                        PreparedStatement st = cn.prepareStatement("DELETE FROM EMPLEADO WHERE DNI =?");
                        st.setString(1, JOptionPane.showInputDialog(null, "Dame el DNI"));
                        int res = st.executeUpdate();
                        System.out.println("Substracción hecha:\n" + st);
                        cn.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                case CONTRATADO:
                    try {
                        Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                        PreparedStatement st = cn.prepareStatement("DELETE FROM CONTRATADOS WHERE DNI =?");
                        st.setString(1, JOptionPane.showInputDialog(null, "Dame el DNI"));
                        int res = st.executeUpdate();
                        System.out.println("Susbtracción hecha:\n" + st);
                        cn.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                case DESTAJO:
                    try {
                        Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                        PreparedStatement st = cn.prepareStatement("DELETE FROM ADESTAJO WHERE DNI =?");
                        st.setString(1, JOptionPane.showInputDialog(null, "Dame el DNI"));
                        int res = st.executeUpdate();
                        System.out.println("Susbtracción hecha:\n" + st);
                        cn.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
            }
        }
        while (opcion != SALIR);
    }

    public void Cambiar() {
        int opcion = 0;
        int op = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Que tabla quieres entrar?\n1 para empleados.\n2 para contratados.\n3 para destajos.\n0 para salir."));
            switch (opcion) {
                case EMPLEADO:
                    do {
                        op = Integer.parseInt(JOptionPane.showInputDialog(null, "Quieres cambiar algún atributo en específico?\n1 para decir no.\n2 para decir si.\n0 para salir."));
                        switch (op) {
                            case 1:
                                try {
                                    Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                    PreparedStatement st = cn.prepareStatement("UPDATE EMPLEADO SET Nombre=?,Apellido=?,DNI=?,Ingreso=?,Sueldo=? WHERE DNI=?");

                                    st.setString(6, JOptionPane.showInputDialog(null, "Dame el DNI de quien quieres cambiar."));
                                    st.setString(1, JOptionPane.showInputDialog(null, "Dame un nombre"));
                                    st.setString(2, JOptionPane.showInputDialog(null, "Dame un apellido"));
                                    st.setString(3, JOptionPane.showInputDialog(null, "Pasame el nuevo dni"));

                                    String Sfecha = JOptionPane.showInputDialog(null, "Dime la fecha, debe ser en yyyy-MM-dd");
                                    java.util.Date Dfecha = new SimpleDateFormat("yyyy-MM-dd").parse(Sfecha);
                                    java.sql.Date SqlFecha = new java.sql.Date(Dfecha.getTime());
                                    st.setDate(4, SqlFecha);
                                    st.setInt(5, Integer.parseInt(JOptionPane.showInputDialog(null, "Dame un sueldo")));
                                    int res = st.executeUpdate();
                                    System.out.println("Modificación hecha:\n" + st);
                                    cn.close();
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                                break;
                            case 2:
                                String[] Option = {"Nombre", "Apellido", "DNI", "Ingreso", "Sueldo", "Salir"};
                                String O = "";
                                do {
                                    O = (String) JOptionPane.showInputDialog(null, "Que quieres cambiar en espcifico?",
                                            "Specific Update", JOptionPane.QUESTION_MESSAGE, null, Option, Option[0]);
                                    if (O == null) {
                                        O = "";
                                        JOptionPane.showMessageDialog(null, "No se seleccionó ninguna opción.", "Aviso", JOptionPane.WARNING_MESSAGE);
                                    }
                                    switch (O.toUpperCase()) {
                                        case "NOMBRE":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("UPDATE EMPLEADO SET Nombre=? WHERE DNI =?");
                                                st.setString(2, JOptionPane.showInputDialog(null, "Dame el DNI de quien quieres cambiar."));
                                                st.setString(1, JOptionPane.showInputDialog(null, "dame su nuevo nombre."));
                                                int res = st.executeUpdate();
                                                System.out.println("Modificación hecha:\n" + st);
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            break;
                                        case "APELLIDO":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("UPDATE EMPLEADO SET Apellido=? WHERE DNI =?");
                                                st.setString(2, JOptionPane.showInputDialog(null, "Dame el DNI de quien quieres cambiar."));
                                                st.setString(1, JOptionPane.showInputDialog(null, "dame su nuevo apellido."));
                                                int res = st.executeUpdate();
                                                System.out.println("Modificación hecha:\n" + st);
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            break;
                                        case "DNI":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("UPDATE EMPLEADO SET DNI=? WHERE DNI =?");
                                                st.setString(2, JOptionPane.showInputDialog(null, "Dame el DNI de quien quieres cambiar."));
                                                st.setString(1, JOptionPane.showInputDialog(null, "dame su nuevo DNI."));
                                                int res = st.executeUpdate();
                                                System.out.println("Modificación hecha:\n" + st);
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            break;
                                        case "INGRESO":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("UPDATE EMPLEADO SET Ingreso=? WHERE DNI =?");

                                                st.setString(2, JOptionPane.showInputDialog(null, "Dame el DNI de quien quieres cambiar."));
                                                String Sfecha = JOptionPane.showInputDialog(null, "Dime la fecha, debe ser en yyyy-MM-dd");
                                                java.util.Date Dfecha = new SimpleDateFormat("yyyy-MM-dd").parse(Sfecha);
                                                java.sql.Date SqlFecha = new java.sql.Date(Dfecha.getTime());
                                                st.setDate(1, SqlFecha);

                                                int res = st.executeUpdate();
                                                System.out.println("Modificación hecha:\n" + st);
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            break;
                                        case "SUELDO":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("UPDATE EMPLEADO SET Sueldo=? WHERE DNI =?");
                                                st.setString(2, JOptionPane.showInputDialog(null, "Dame el DNI de quien quieres cambiar."));
                                                st.setInt(1, Integer.parseInt(JOptionPane.showInputDialog(null, "dame su nuevo sueldo.")));
                                                int res = st.executeUpdate();
                                                System.out.println("Modificación hecha:\n" + st);
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            break;
                                        case "SALIR":
                                            break;
                                    }
                                }
                                while (!O.equalsIgnoreCase("SALIR"));
                                break;
                        }
                    }
                    while (op != SALIR);
                    break;
                case CONTRATADO:
                    do {
                        op = Integer.parseInt(JOptionPane.showInputDialog(null, "Quieres cambiar algún atributo en específico?\n1 para decir no.\n2 para decir si.\n0 para salir."));
                        switch (op) {
                            case 1:
                                try {
                                    Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                    PreparedStatement st = cn.prepareStatement("UPDATE CONTRATADOS SET Nombre=?,Apellido=?,DNI=?,Ingreso=?,Sueldo=?,Antiguedad=? WHERE DNI=?");

                                    st.setString(7, JOptionPane.showInputDialog(null, "Dame el DNI de quien quieres cambiar."));
                                    st.setString(1, JOptionPane.showInputDialog(null, "Dame un nombre"));
                                    st.setString(2, JOptionPane.showInputDialog(null, "Dame un apellido"));
                                    st.setString(3, JOptionPane.showInputDialog(null, "Pasame el nuevo dni"));

                                    String Sfecha = JOptionPane.showInputDialog(null, "Dime la fecha, debe ser en yyyy-MM-dd");
                                    java.util.Date Dfecha = new SimpleDateFormat("yyyy-MM-dd").parse(Sfecha);
                                    java.sql.Date SqlFecha = new java.sql.Date(Dfecha.getTime());
                                    st.setDate(4, SqlFecha);
                                    st.setInt(5, Integer.parseInt(JOptionPane.showInputDialog(null, "Dame un sueldo")));
                                    st.setInt(6, Integer.parseInt(JOptionPane.showInputDialog(null, "Dime su antiguedad")));
                                    int res = st.executeUpdate();
                                    System.out.println("Modificación hecha:\n" + st);
                                    cn.close();
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                                break;
                            case 2:
                                String[] Option = {"Nombre", "Apellido", "DNI", "Ingreso", "Sueldo", "Antiguedad", "Salir"};
                                String O = "";
                                do {
                                    O = (String) JOptionPane.showInputDialog(null, "Que quieres cambiar en espcifico?",
                                            "Specific Update", JOptionPane.QUESTION_MESSAGE, null, Option, Option[0]);
                                    if (O == null) {
                                        O = "";
                                        JOptionPane.showMessageDialog(null, "No se seleccionó ninguna opción.", "Aviso", JOptionPane.WARNING_MESSAGE);
                                    }
                                    switch (O.toUpperCase()) {
                                        case "NOMBRE":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("UPDATE CONTRATADOS SET Nombre=? WHERE DNI =?");
                                                st.setString(2, JOptionPane.showInputDialog(null, "Dame el DNI de quien quieres cambiar."));
                                                st.setString(1, JOptionPane.showInputDialog(null, "dame su nuevo nombre."));
                                                int res = st.executeUpdate();
                                                System.out.println("Modificación hecha:\n" + st);
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            break;
                                        case "APELLIDO":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("UPDATE CONTRATADOS SET Apellido=? WHERE DNI =?");
                                                st.setString(2, JOptionPane.showInputDialog(null, "Dame el DNI de quien quieres cambiar."));
                                                st.setString(1, JOptionPane.showInputDialog(null, "dame su nuevo apellido."));
                                                int res = st.executeUpdate();
                                                System.out.println("Modificación hecha:\n" + st);
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            break;
                                        case "DNI":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("UPDATE CONTRATADOS SET DNI=? WHERE DNI =?");
                                                st.setString(2, JOptionPane.showInputDialog(null, "Dame el DNI de quien quieres cambiar."));
                                                st.setString(1, JOptionPane.showInputDialog(null, "dame su nuevo DNI."));
                                                int res = st.executeUpdate();
                                                System.out.println("Modificación hecha:\n" + st);
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            break;
                                        case "INGRESO":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("UPDATE CONTRATADOS SET Ingreso=? WHERE DNI =?");

                                                st.setString(2, JOptionPane.showInputDialog(null, "Dame el DNI de quien quieres cambiar."));
                                                String Sfecha = JOptionPane.showInputDialog(null, "Dime la fecha, debe ser en yyyy-MM-dd");
                                                java.util.Date Dfecha = new SimpleDateFormat("yyyy-MM-dd").parse(Sfecha);
                                                java.sql.Date SqlFecha = new java.sql.Date(Dfecha.getTime());
                                                st.setDate(1, SqlFecha);

                                                int res = st.executeUpdate();
                                                System.out.println("Modificación hecha:\n" + st);
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            break;
                                        case "SUELDO":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("UPDATE CONTRATADOS SET Sueldo=? WHERE DNI =?");
                                                st.setString(2, JOptionPane.showInputDialog(null, "Dame el DNI de quien quieres cambiar."));
                                                st.setInt(1, Integer.parseInt(JOptionPane.showInputDialog(null, "dame su nuevo sueldo.")));
                                                int res = st.executeUpdate();
                                                System.out.println("Modificación hecha:\n" + st);
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            break;
                                        case "ANTIGUEDAD":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("UPDATE CONTRATADOS SET Antiguedad=? WHERE DNI =?");
                                                st.setString(2, JOptionPane.showInputDialog(null, "Dame el DNI de quien quieres cambiar."));
                                                st.setInt(1, Integer.parseInt(JOptionPane.showInputDialog(null, "dame su nueva vejez.")));
                                                int res = st.executeUpdate();
                                                System.out.println("Modificación hecha:\n" + st);
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            break;
                                        case "SALIR":
                                            break;
                                    }
                                }
                                while (!O.equalsIgnoreCase("SALIR"));
                                break;
                        }
                    }
                    while (op != SALIR);
                    break;
                case DESTAJO:
                    do {
                        op = Integer.parseInt(JOptionPane.showInputDialog(null, "Quieres cambiar algún atributo en específico?\n1 para decir no.\n2 para decir si.\n0 para salir."));
                        switch (op) {
                            case 1:
                                try {
                                    Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                    PreparedStatement st = cn.prepareStatement("UPDATE ADESTAJO SET Nombre=?,Apellido=?,DNI=?,Ingreso=?,Sueldo=?,Clientes=? WHERE DNI=?");

                                    st.setString(7, JOptionPane.showInputDialog(null, "Dame el DNI de quien quieres cambiar."));
                                    st.setString(1, JOptionPane.showInputDialog(null, "Dame un nombre"));
                                    st.setString(2, JOptionPane.showInputDialog(null, "Dame un apellido"));
                                    st.setString(3, JOptionPane.showInputDialog(null, "Pasame el nuevo dni"));

                                    String Sfecha = JOptionPane.showInputDialog(null, "Dime la fecha, debe ser en yyyy-MM-dd");
                                    java.util.Date Dfecha = new SimpleDateFormat("yyyy-MM-dd").parse(Sfecha);
                                    java.sql.Date SqlFecha = new java.sql.Date(Dfecha.getTime());
                                    st.setDate(4, SqlFecha);
                                    st.setInt(5, Integer.parseInt(JOptionPane.showInputDialog(null, "Dame un sueldo")));
                                    st.setInt(6, Integer.parseInt(JOptionPane.showInputDialog(null, "Dime sus clientes")));
                                    int res = st.executeUpdate();
                                    System.out.println("Modificación hecha:\n" + st);
                                    cn.close();
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                                break;
                            case 2:
                                String[] Option = {"Nombre", "Apellido", "DNI", "Ingreso", "Sueldo", "Clientes", "Salir"};
                                String O = "";
                                do {
                                    O = (String) JOptionPane.showInputDialog(null, "Que quieres cambiar en espcifico?",
                                            "Specific Update", JOptionPane.QUESTION_MESSAGE, null, Option, Option[0]);
                                    if (O == null) {
                                        O = "";
                                        JOptionPane.showMessageDialog(null, "No se seleccionó ninguna opción.", "Aviso", JOptionPane.WARNING_MESSAGE);
                                    }
                                    switch (O.toUpperCase()) {
                                        case "NOMBRE":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("UPDATE ADESTAJO SET Nombre=? WHERE DNI =?");
                                                st.setString(2, JOptionPane.showInputDialog(null, "Dame el DNI de quien quieres cambiar."));
                                                st.setString(1, JOptionPane.showInputDialog(null, "dame su nuevo nombre."));
                                                int res = st.executeUpdate();
                                                System.out.println("Modificación hecha:\n" + st);
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            break;
                                        case "APELLIDO":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("UPDATE ADESTAJO SET Apellido=? WHERE DNI =?");
                                                st.setString(2, JOptionPane.showInputDialog(null, "Dame el DNI de quien quieres cambiar."));
                                                st.setString(1, JOptionPane.showInputDialog(null, "dame su nuevo apellido."));
                                                int res = st.executeUpdate();
                                                System.out.println("Modificación hecha:\n" + st);
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            break;
                                        case "DNI":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("UPDATE ADESTAJO SET DNI=? WHERE DNI =?");
                                                st.setString(2, JOptionPane.showInputDialog(null, "Dame el DNI de quien quieres cambiar."));
                                                st.setString(1, JOptionPane.showInputDialog(null, "dame su nuevo DNI."));
                                                int res = st.executeUpdate();
                                                System.out.println("Modificación hecha:\n" + st);
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            break;
                                        case "INGRESO":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("UPDATE ADESTAJO SET Ingreso=? WHERE DNI =?");

                                                st.setString(2, JOptionPane.showInputDialog(null, "Dame el DNI de quien quieres cambiar."));
                                                String Sfecha = JOptionPane.showInputDialog(null, "Dime la fecha, debe ser en yyyy-MM-dd");
                                                java.util.Date Dfecha = new SimpleDateFormat("yyyy-MM-dd").parse(Sfecha);
                                                java.sql.Date SqlFecha = new java.sql.Date(Dfecha.getTime());
                                                st.setDate(1, SqlFecha);

                                                int res = st.executeUpdate();
                                                System.out.println("Modificación hecha:\n" + st);
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            break;
                                        case "SUELDO":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("UPDATE ADESTAJO SET Sueldo=? WHERE DNI =?");
                                                st.setString(2, JOptionPane.showInputDialog(null, "Dame el DNI de quien quieres cambiar."));
                                                st.setInt(1, Integer.parseInt(JOptionPane.showInputDialog(null, "dame su nuevo sueldo.")));
                                                int res = st.executeUpdate();
                                                System.out.println("Modificación hecha:\n" + st);
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            break;
                                        case "CLIENTES":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("UPDATE ADESTAJO SET Clientes=? WHERE DNI =?");
                                                st.setString(2, JOptionPane.showInputDialog(null, "Dame el DNI de quien quieres cambiar."));
                                                st.setInt(1, Integer.parseInt(JOptionPane.showInputDialog(null, "dame sus fans.")));
                                                int res = st.executeUpdate();
                                                System.out.println("Modificación hecha:\n" + st);
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            break;
                                        case "SALIR":
                                            break;
                                    }
                                }
                                while (!O.equalsIgnoreCase("SALIR"));
                                break;
                        }
                    }
                    while (op != SALIR);
                    break;
            }
        }
        while (opcion != SALIR);
    }

    public void Consultar() {
        int opcion = 0;
        int op = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Que tabla quieres entrar?\n1 para empleados.\n2 para contratados.\n3 para destajos.\n0 para salir."));
            switch (opcion) {
                case EMPLEADO:
                    do {
                        op = op = Integer.parseInt(JOptionPane.showInputDialog(null, "Quieres filtrar tu busqueda?\n1 para decir no.\n2 para decir si.\n0 para salir."));
                        switch (op) {
                            case 1:
                                try {
                                    Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                    Statement st = cn.createStatement();
                                    ResultSet rs = st.executeQuery("SELECT * FROM EMPLEADO");
                                    while (rs.next()) {
                                        System.out.println(rs.getString("Nombre") + rs.getString("Apellido") + rs.getString("DNI")+rs.getDate("Ingreso")+rs.getInt("Sueldo"));
                                    }
                                }
                                catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            break;
                            case 2:
                                String[] Option = {"Nombre", "Apellido", "DNI", "Salir"};
                                String O = "";
                                do {
                                    O = (String) JOptionPane.showInputDialog(null, "Que quieres cambiar en espcifico?",
                                            "Specific Update", JOptionPane.QUESTION_MESSAGE, null, Option, Option[0]);
                                    if (O == null) {
                                        O = "";
                                        JOptionPane.showMessageDialog(null, "No se seleccionó ninguna opción.", "Aviso", JOptionPane.WARNING_MESSAGE);
                                    }
                                    switch (O.toUpperCase()) {
                                        case "NOMBRE":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("SELECT * FROM EMPLEADO WHERE Nombre =?");
                                                st.setString(1, JOptionPane.showInputDialog(null, "Dame el nombre que buscas."));
                                                ResultSet rs = st.executeQuery();
                                                while (rs.next()) {
                                                    System.out.println(rs.getString("Nombre") + rs.getString("Apellido") + rs.getString("DNI")+rs.getDate("Ingreso")+rs.getInt("Sueldo"));
                                                }
                                                cn.close();
                                            }
                                            catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        break;
                                        case "APELLIDO":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("SELECT * FROM EMPLEADO WHERE Apellido =?");
                                                st.setString(1, JOptionPane.showInputDialog(null, "Dame el apellido que buscas."));
                                                ResultSet rs = st.executeQuery();
                                                while (rs.next()) {
                                                    System.out.println(rs.getString("Nombre") + rs.getString("Apellido") + rs.getString("DNI")+rs.getDate("Ingreso")+rs.getInt("Sueldo"));
                                                }
                                                cn.close();
                                            }
                                            catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        break;
                                        case "DNI":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("SELECT * FROM EMPLEADO WHERE DNI =?");
                                                st.setString(1, JOptionPane.showInputDialog(null, "Dame el apellido que buscas."));
                                                ResultSet rs = st.executeQuery();
                                                while (rs.next()) {
                                                    System.out.println(rs.getString("Nombre") + rs.getString("Apellido") + rs.getString("DNI")+rs.getDate("Ingreso")+rs.getInt("Sueldo"));
                                                }
                                                cn.close();
                                            }
                                            catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        break;
                                    }
                                } while (!O.equalsIgnoreCase("SALIR"));
                            break;
                        }
                    }while (op != SALIR);
                break;
                case CONTRATADO:
                    do {
                        op = op = Integer.parseInt(JOptionPane.showInputDialog(null, "Quieres filtrar tu busqueda?\n1 para decir no.\n2 para decir si.\n0 para salir."));
                        switch (op) {
                            case 1:
                                try {
                                    Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                    Statement st = cn.createStatement();
                                    ResultSet rs = st.executeQuery("SELECT * FROM CONTRATADOS");
                                    while (rs.next()) {
                                        System.out.println(rs.getString("Nombre") + rs.getString("Apellido") + rs.getString("DNI")+rs.getDate("Ingreso")+rs.getInt("Sueldo")+rs.getInt("Antiguedad"));
                                    }
                                }
                                catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            break;
                            case 2:
                                String[] Option = {"Nombre", "Apellido", "DNI", "Salir"};
                                String O = "";
                                do {
                                    O = (String) JOptionPane.showInputDialog(null, "Que quieres cambiar en espcifico?",
                                            "Specific Update", JOptionPane.QUESTION_MESSAGE, null, Option, Option[0]);
                                    if (O == null) {
                                        O = "";
                                        JOptionPane.showMessageDialog(null, "No se seleccionó ninguna opción.", "Aviso", JOptionPane.WARNING_MESSAGE);
                                    }
                                    switch (O.toUpperCase()) {
                                        case "NOMBRE":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("SELECT * FROM CONTRATADOS WHERE Nombre =?");
                                                st.setString(1, JOptionPane.showInputDialog(null, "Dame el nombre que buscas."));
                                                ResultSet rs = st.executeQuery();
                                                while (rs.next()) {
                                                     System.out.println(rs.getString("Nombre") + rs.getString("Apellido") + rs.getString("DNI")+rs.getDate("Ingreso")+rs.getInt("Sueldo")+rs.getInt("Antiguedad"));
                                                }
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            break;
                                        case "APELLIDO":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("SELECT * FROM CONTRATADOS WHERE Apellido =?");
                                                st.setString(1, JOptionPane.showInputDialog(null, "Dame el apellido que buscas."));
                                                ResultSet rs = st.executeQuery();
                                                while (rs.next()) {
                                                    System.out.println(rs.getString("Nombre") + rs.getString("Apellido") + rs.getString("DNI")+rs.getDate("Ingreso")+rs.getInt("Sueldo")+rs.getInt("Antiguedad"));
                                                }
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            break;
                                        case "DNI":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("SELECT * FROM CONTRATADOS WHERE DNI =?");
                                                st.setString(1, JOptionPane.showInputDialog(null, "Dame el apellido que buscas."));
                                                ResultSet rs = st.executeQuery();
                                                while (rs.next()) {
                                                    System.out.println(rs.getString("Nombre") + rs.getString("Apellido") + rs.getString("DNI")+rs.getDate("Ingreso")+rs.getInt("Sueldo")+rs.getInt("Antiguedad"));
                                                }
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            break;
                                    }
                                }
                                while (!O.equalsIgnoreCase("SALIR"));
                            break;
                        }
                    }while (op!=SALIR);
                break;
                case DESTAJO:
                    do {
                        op = op = Integer.parseInt(JOptionPane.showInputDialog(null, "Quieres filtrar tu busqueda?\n1 para decir no.\n2 para decir si.\n0 para salir."));
                        switch (op) {
                            case 1:
                                try {
                                    Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                    Statement st = cn.createStatement();
                                    ResultSet rs = st.executeQuery("SELECT * FROM ADESTAJO");
                                    while (rs.next()) {
                                        System.out.println(rs.getString("Nombre") + rs.getString("Apellido") + rs.getString("DNI")+rs.getDate("Ingreso")+rs.getInt("Sueldo")+rs.getInt("Clientes"));
                                    }
                                }
                                catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                                break;
                            case 2:
                                String[] Option = {"Nombre", "Apellido", "DNI", "Salir"};
                                String O = "";
                                do {
                                    O = (String) JOptionPane.showInputDialog(null, "Que quieres cambiar en espcifico?",
                                            "Specific Update", JOptionPane.QUESTION_MESSAGE, null, Option, Option[0]);
                                    if (O == null) {
                                        O = "";
                                        JOptionPane.showMessageDialog(null, "No se seleccionó ninguna opción.", "Aviso", JOptionPane.WARNING_MESSAGE);
                                    }
                                    switch (O.toUpperCase()) {
                                        case "NOMBRE":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("SELECT * FROM ADESTAJO WHERE Nombre =?");
                                                st.setString(1, JOptionPane.showInputDialog(null, "Dame el nombre que buscas."));
                                                ResultSet rs = st.executeQuery();
                                                while (rs.next()) {
                                                    System.out.println(rs.getString("Nombre") + rs.getString("Apellido") + rs.getString("DNI")+rs.getDate("Ingreso")+rs.getInt("Sueldo")+rs.getInt("Clientes"));
                                                }
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        break;
                                        case "APELLIDO":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("SELECT * FROM ADESTAJO WHERE Apellido =?");
                                                st.setString(1, JOptionPane.showInputDialog(null, "Dame el apellido que buscas."));
                                                ResultSet rs = st.executeQuery();
                                                while (rs.next()) {
                                                    System.out.println(rs.getString("Nombre") + rs.getString("Apellido") + rs.getString("DNI")+rs.getDate("Ingreso")+rs.getInt("Sueldo")+rs.getInt("Clientes"));
                                                }
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        break;
                                        case "DNI":
                                            try {
                                                Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/personal", "root", "");
                                                PreparedStatement st = cn.prepareStatement("SELECT * FROM ADESTAJO WHERE DNI =?");
                                                st.setString(1, JOptionPane.showInputDialog(null, "Dame el apellido que buscas."));
                                                ResultSet rs = st.executeQuery();
                                                while (rs.next()) {
                                                    System.out.println(rs.getString("Nombre") + rs.getString("Apellido") + rs.getString("DNI")+rs.getDate("Ingreso")+rs.getInt("Sueldo")+rs.getInt("Clientes"));
                                                }
                                                cn.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        break;
                                    }
                                }
                                while (!O.equalsIgnoreCase("SALIR"));
                            break;
                        }
                    }while (op!=SALIR);
                break;
            }
        }
        while (opcion != SALIR);
    }
 }