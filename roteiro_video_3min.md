# Roteiro curto - Video de 3 minutos (Java + Oracle)

## Tempo total
3 minutos

## 1) Abertura (0:00 - 0:20)
**Mostrar:** estrutura do projeto no VS Code.

**Fala:**
"Neste video, apresento uma aplicacao Java conectada ao Oracle. Ela realiza um INSERT, consulta o registro inserido e tambem chama uma procedure e uma function no banco."

## 2) Conexao com Oracle (0:20 - 0:55)
**Mostrar:** OracleConexao.java.

**Fala:**
"Nesta classe estao as configuracoes da conexao JDBC: URL, usuario e senha. O driver Oracle eh carregado e a conexao eh aberta com DriverManager. Se houver erro, a aplicacao informa no console."

## 3) INSERT + consulta (0:55 - 1:45)
**Mostrar:** OracleOperacoes.java.

**Fala:**
"Aqui o metodo inserirCargo executa um INSERT na tabela CARGO usando PreparedStatement e SCARGO.NEXTVAL para gerar o ID. Em caso de sucesso, faz commit; em erro, rollback. Em seguida, o metodo consultarCargoInserido busca o ultimo registro inserido por nome e retorna os dados principais."

## 4) Procedure e function (1:45 - 2:20)
**Mostrar:** OracleOperacoes.java (metodos de CallableStatement).

**Fala:**
"Tambem uso CallableStatement para chamar a procedure e a function criadas no Oracle. A procedure retorna uma mensagem por parametro de saida e a function retorna um valor numerico."

## 5) Execucao e resultado (2:20 - 2:50)
**Mostrar:** OracleConexaoApp.java e terminal.

**Fala:**
"Na classe principal, o fluxo eh: conectar, inserir, consultar o inserido, executar select simples, chamar procedure e function, e fechar a conexao. Agora no terminal, vemos os resultados de cada etapa."

**Comandos (ajuste o nome do JAR se necessario):**
```bash
javac -cp .:ojdbc11.jar OracleConexao.java OracleOperacoes.java OracleConexaoApp.java
java -cp .:ojdbc11.jar OracleConexaoApp
```

## 6) Encerramento (2:50 - 3:00)
**Fala:**
"Concluindo, o programa atende aos requisitos: conexao com Oracle, DML/consulta SQL e chamada de procedure/function."

## Dicas rapidas para gravar
- Nao exibir senha na tela.
- Aumentar fonte do editor e terminal.
- Falar com frases curtas e objetivas.
