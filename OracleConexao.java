import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConexao {
    // Dados da conexão Oracle.
    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
    public static final String USER = "SEU_USUARIO";
    public static final String PASSWORD = "SUA_SENHA";

    public static Connection abrirConexao() {
        try {
            // Carrega o driver JDBC da Oracle.
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
            );
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao conectar no Oracle: " + e.getMessage());
            return null;
        }
    }
}
