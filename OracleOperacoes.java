import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class OracleOperacoes {

    public static int inserirCargo(Connection conn, String nomeCargo, BigDecimal minSal, BigDecimal maxSal) {
        try {
            String sql = "INSERT INTO CARGO (ID_CARGO, NOME_CARGO, MIN_SAL, MAX_SAL) VALUES (SCARGO.NEXTVAL, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nomeCargo);
                stmt.setBigDecimal(2, minSal);
                stmt.setBigDecimal(3, maxSal);
                int linhas = stmt.executeUpdate();
                conn.commit();
                return linhas;
            }
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException rollbackError) {
                System.out.println("Erro no rollback do INSERT de cargo: " + rollbackError.getMessage());
            }
            System.out.println("Erro no INSERT de cargo: " + e.getMessage());
            return 0;
        }
    }

    public static String consultarCargoInserido(Connection conn, String nomeCargo) {
        try {
            String sql = """
                SELECT id_cargo, nome_cargo, min_sal, max_sal
                  FROM cargo
                 WHERE nome_cargo = ?
                 ORDER BY id_cargo DESC
                """;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nomeCargo);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        int id = rs.getInt("id_cargo");
                        String nome = rs.getString("nome_cargo");
                        BigDecimal min = rs.getBigDecimal("min_sal");
                        BigDecimal max = rs.getBigDecimal("max_sal");
                        return "ID=" + id + ", NOME=" + nome + ", MIN_SAL=" + min + ", MAX_SAL=" + max;
                    }
                }
            }
            return "Nenhum cargo encontrado para o nome informado.";
        } catch (SQLException e) {
            System.out.println("Erro na consulta do cargo inserido: " + e.getMessage());
            return null;
        }
    }

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
