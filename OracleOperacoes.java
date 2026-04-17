import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class OracleOperacoes {

    public static int inserirAluno(Connection conn, int id, String nome) {
        try {
            String sql = "INSERT INTO ALUNO (ID, NOME) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.setString(2, nome);
                return stmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Erro no INSERT: " + e.getMessage());
            return 0;
        }
    }

    public static Object buscarDataAtual(Connection conn) {
        try {
            String sql = "SELECT SYSDATE AS data_atual FROM dual";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getObject("data_atual");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro no SELECT: " + e.getMessage());
        }

        return null;
    }

    public static String chamarProcedureBoasVindas(Connection conn, String nome) {
        try {
            String sql = "{ call sp_boas_vindas(?, ?) }";
            try (CallableStatement cstmt = conn.prepareCall(sql)) {
                cstmt.setString(1, nome);
                cstmt.registerOutParameter(2, Types.VARCHAR);
                cstmt.execute();
                return cstmt.getString(2);
            }
        } catch (SQLException e) {
            System.out.println("Erro na procedure: " + e.getMessage());
            return null;
        }
    }

    public static BigDecimal chamarFunctionSoma(Connection conn, int a, int b) {
        try {
            String sql = "{ ? = call fn_soma(?, ?) }";
            try (CallableStatement cstmt = conn.prepareCall(sql)) {
                cstmt.registerOutParameter(1, Types.NUMERIC);
                cstmt.setInt(2, a);
                cstmt.setInt(3, b);

                cstmt.execute();
                return cstmt.getBigDecimal(1);
            }
        } catch (SQLException e) {
            System.out.println("Erro na function: " + e.getMessage());
            return null;
        }
    }
}
