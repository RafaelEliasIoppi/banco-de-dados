import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Classe principal do exemplo.
 */
public class OracleConexaoApp {

    public static void main(String[] args) {
        // Abre a conexão com o banco.
        Connection conn = OracleConexao.abrirConexao();

        if (conn != null) {
            System.out.println("Conexao com Oracle estabelecida com sucesso.");

            // 1) INSERT
            int linhas = OracleOperacoes.inserirAluno(conn, 1001, "Rafael");
            System.out.println("INSERT executado. Linhas afetadas: " + linhas);

            // 2) SELECT
            Object dataAtual = OracleOperacoes.buscarDataAtual(conn);
            System.out.println("Data atual do Oracle: " + dataAtual);

            // 3) Procedure
            String msgProcedure = OracleOperacoes.chamarProcedureBoasVindas(conn, "Rafael");
            System.out.println("Retorno da procedure: " + msgProcedure);

            // 4) Function
            BigDecimal resultadoFunction = OracleOperacoes.chamarFunctionSoma(conn, 10, 25);
            System.out.println("Resultado da function fn_soma: " + resultadoFunction);

            try {
                // Fecha a conexão ao final.
                conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexao: " + e.getMessage());
            }
        } else {
            System.out.println("Nao foi possivel conectar ao banco.");
        }
    }
}
