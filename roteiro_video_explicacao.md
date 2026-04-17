# Roteiro de video - Explicacao do codigo Java com Oracle

## Duracao sugerida
7 a 10 minutos

## Objetivo da apresentacao
Mostrar um programa Java que:
1. Conecta no Oracle Database via JDBC.
2. Faz um INSERT na tabela CARGO.
3. Consulta o registro inserido.
4. Chama procedure e function no Oracle.

## Preparacao antes de gravar
- Deixe aberto o projeto no VS Code.
- Deixe o terminal pronto para compilar/executar.
- Tenha o banco Oracle ativo.
- Garanta que a tabela CARGO e a sequence SCARGO existem.
- Garanta que a procedure e a function chamadas no codigo estao criadas no banco.

## Estrutura do video com falas

### 1) Introducao (0:00 - 0:45)
**Mostrar:** visao geral do projeto no explorer.

**Fala sugerida:**
"Neste video eu vou apresentar um programa em Java que se conecta ao Oracle Database. O sistema realiza um INSERT, faz uma consulta desse registro inserido e tambem executa uma procedure e uma function criadas no Oracle."

---

### 2) Configuracao da conexao (0:45 - 2:00)
**Mostrar:** arquivo OracleConexao.java.

**Pontos para explicar:**
- URL JDBC Oracle no formato `jdbc:oracle:thin:@//host:porta/servico`.
- Usuario e senha.
- Carregamento do driver Oracle JDBC.
- Abertura da conexao com `DriverManager.getConnection(...)`.
- Tratamento de erro de conexao.

**Fala sugerida:**
"Aqui na classe de conexao eu centralizei as configuracoes do Oracle. Defino URL, usuario e senha, carrego o driver JDBC da Oracle e retorno um objeto Connection. Se ocorrer erro, ele eh tratado e o programa informa a falha de conexao."

---

### 3) Operacoes SQL e chamadas PL/SQL (2:00 - 4:45)
**Mostrar:** arquivo OracleOperacoes.java.

**Pontos para explicar (INSERT + consulta):**
- Metodo `inserirCargo(...)`.
- INSERT com `PreparedStatement` e parametros.
- Uso da sequence `SCARGO.NEXTVAL`.
- `commit()` apos sucesso e `rollback()` em erro.
- Metodo `consultarCargoInserido(...)` para buscar o ultimo cargo inserido por nome.

**Fala sugerida:**
"Neste metodo, o INSERT eh feito com PreparedStatement para parametrizar os valores e evitar concatenacao de SQL. O ID eh gerado pela sequence SCARGO. Se tudo funcionar, eu confirmo com commit; se falhar, faco rollback para manter consistencia. Em seguida, no metodo de consulta, eu recupero o registro inserido e exibo os campos principais."

**Pontos para explicar (procedure e function):**
- `CallableStatement` para procedure `sp_boas_vindas`.
- Parametro de saida com `registerOutParameter`.
- Chamada de function `fn_soma` com retorno numerico.

**Fala sugerida:**
"Tambem demonstro integracao com PL/SQL: chamo uma procedure com parametro de entrada e saida, e uma function que retorna um valor numerico. Isso mostra como o Java pode consumir recursos nativos do Oracle."

---

### 4) Fluxo principal da aplicacao (4:45 - 6:15)
**Mostrar:** arquivo OracleConexaoApp.java.

**Pontos para explicar:**
- Abre conexao.
- Executa INSERT em CARGO.
- Executa consulta do INSERT.
- Executa SELECT simples de data atual.
- Chama procedure e function.
- Fecha conexao ao final.

**Fala sugerida:**
"Na classe principal, eu controlo toda a execucao: conecto no Oracle, realizo o INSERT, consulto o registro inserido, executo um SELECT simples e chamo procedure e function. Ao final, fecho a conexao para liberar recursos."

---

### 5) Execucao no terminal (6:15 - 8:00)
**Mostrar:** compilacao e execucao.

**Sugestao de comandos (ajuste conforme seu ambiente):**
```bash
javac -cp .:ojdbc11.jar OracleConexao.java OracleOperacoes.java OracleConexaoApp.java
java -cp .:ojdbc11.jar OracleConexaoApp
```

**Fala sugerida:**
"Agora vou executar o programa. Aqui podemos ver a confirmacao da conexao, o resultado do INSERT, a consulta do registro inserido e os retornos da procedure e da function."

---

### 6) Encerramento (8:00 - 8:30)
**Mostrar:** resultado final no terminal.

**Fala sugerida:**
"Concluindo, o programa atende aos requisitos da atividade: conexao com Oracle, execucao de DML e consulta SQL, alem da chamada de procedure e function."

## Checklist de entrega
- [ ] Codigo-fonte Java completo no repositorio.
- [ ] Video mostrando funcionamento, explicacao do codigo e configuracao do ambiente.
- [ ] Evidencia da conexao Oracle e dos resultados no terminal.

## Dicas para gravacao
- Grave em 1080p.
- Fale pausado e mostre o codigo enquanto comenta.
- Evite digitar senhas na gravacao.
- Se possivel, use zoom de fonte para facilitar leitura.
