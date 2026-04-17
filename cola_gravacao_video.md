# Cola de gravacao - Video Java + Oracle (1 pagina)

## Objetivo em 1 frase
Apresentar uma aplicacao Java que conecta no Oracle, faz INSERT e consulta do registro inserido, e chama procedure/function.

## Ordem da gravacao (3 min)

### 1) Abertura (20s)
Fala:
"Vou mostrar uma aplicacao Java com Oracle JDBC, executando INSERT, SELECT, procedure e function."

Tela:
- Explorer do projeto.

### 2) Conexao (35s)
Fala:
"Na classe OracleConexao configuro URL, usuario, senha, carrego o driver e abro a conexao."

Tela:
- OracleConexao.java

### 3) INSERT + consulta (50s)
Fala:
"No metodo inserirCargo uso PreparedStatement com SCARGO.NEXTVAL e parametros. Se der certo, commit; se falhar, rollback. Depois consulto o registro inserido no metodo consultarCargoInserido."

Tela:
- OracleOperacoes.java

### 4) Procedure e function (35s)
Fala:
"Uso CallableStatement para chamar procedure com parametro de saida e function com retorno numerico."

Tela:
- OracleOperacoes.java

### 5) Fluxo principal + execucao (35s)
Fala:
"Na classe principal: conecta, insere, consulta, chama procedure/function e fecha conexao. Agora executo no terminal para mostrar a saida."

Tela:
- OracleConexaoApp.java
- Terminal

Comandos:
```bash
javac -cp .:ojdbc11.jar OracleConexao.java OracleOperacoes.java OracleConexaoApp.java
java -cp .:ojdbc11.jar OracleConexaoApp
```

### 6) Encerramento (5s)
Fala:
"Requisito atendido: conexao Oracle, DML/consulta e chamada de procedure/function."

## Checklist rapido antes de gravar
- Oracle ligado.
- Driver ojdbc no projeto.
- URL, usuario e senha corretos.
- Procedure/function existentes no banco.
- Fonte do VS Code aumentada.
- Nao mostrar senha durante a gravacao.
