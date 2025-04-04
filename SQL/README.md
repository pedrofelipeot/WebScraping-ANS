
# Demonstracoes Contabeis

Este repositório contém scripts para a criação e carregamento de dados em uma tabela de demonstrações contábeis no MySQL, com o objetivo de organizar e analisar informações financeiras de diferentes trimestres e anos. Além disso, o repositório inclui consultas SQL para calcular as despesas das operadoras de saúde com base em determinados critérios.

## Estrutura do Banco de Dados

1. **Criação do Banco de Dados**: O banco de dados `demonstracoes_contabeis` é criado, caso ainda não exista.

   ```sql
   CREATE DATABASE IF NOT EXISTS demonstracoes_contabeis;
   USE demonstracoes_contabeis;
   ```

2. **Criação da Tabela**: A tabela `demonstracoes` é criada com as seguintes colunas:
   - `id`: Identificador único (chave primária).
   - `data`: Data da demonstração.
   - `reg_ans`: Registro da operadora de saúde.
   - `cd_conta_contabil`: Código da conta contábil.
   - `descricao`: Descrição da operação.
   - `vl_saldo_inicial`: Valor do saldo inicial.
   - `vl_saldo_final`: Valor do saldo final.

   ```sql
   CREATE TABLE IF NOT EXISTS demonstracoes (
       id INT AUTO_INCREMENT PRIMARY KEY,
       data DATE NOT NULL,
       reg_ans INT NOT NULL,
       cd_conta_contabil BIGINT NOT NULL,
       descricao VARCHAR(255) NOT NULL,
       vl_saldo_inicial DECIMAL(15,2) NOT NULL,
       vl_saldo_final DECIMAL(15,2) NOT NULL
   );
   ```

## Carregamento de Dados

Os dados dos trimestres de 2023 e 2024 são carregados na tabela a partir de arquivos CSV. Cada trimestre contém as seguintes operações:

```sql
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/demonstracoes_contabeis/1T2023.csv'
INTO TABLE demonstracoes
FIELDS TERMINATED BY ';' ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(@data, reg_ans, cd_conta_contabil, descricao, @vl_saldo_inicial, @vl_saldo_final)
SET data = STR_TO_DATE(@data, '%Y-%m-%d'),
    vl_saldo_inicial = REPLACE(@vl_saldo_inicial, ',', '.'),
    vl_saldo_final = REPLACE(@vl_saldo_final, ',', '.');
```

Esse processo é repetido para os trimestres seguintes de 2023 e 2024.

## Consultas SQL

### Despesas do Último Trimestre de 2024

A consulta abaixo retorna as 10 operadoras com maiores despesas no último trimestre de 2024.

```sql
SELECT 
    'Último Trimestre' AS titulo,
    reg_ans AS operadora, 
    SUM(vl_saldo_inicial - vl_saldo_final) AS total_despesas
FROM demonstracoes
WHERE descricao LIKE '%SINISTROS CONHECIDOS OU AVISADOS%' 
AND descricao LIKE '%ASSISTÊNCIA A SAÚDE MEDICO HOSPITALAR%'
AND data BETWEEN '2024-10-01' AND '2024-12-31'
GROUP BY reg_ans
ORDER BY total_despesas DESC
LIMIT 10;
```

### Despesas do Ano de 2024

A consulta abaixo retorna as 10 operadoras com maiores despesas no ano de 2024.

```sql
SELECT 
    'Último Ano' AS titulo,
    reg_ans AS operadora, 
    SUM(vl_saldo_inicial - vl_saldo_final) AS total_despesas
FROM demonstracoes
WHERE descricao LIKE '%SINISTROS CONHECIDOS OU AVISADOS%' 
AND descricao LIKE '%ASSISTÊNCIA A SAÚDE MEDICO HOSPITALAR%'
AND data BETWEEN '2024-01-01' AND '2024-12-31'
GROUP BY reg_ans
ORDER BY total_despesas DESC
LIMIT 10;
```

## Conclusão

Esses scripts são úteis para análise de despesas de operadoras de saúde em trimestres específicos, com foco em "sinistros conhecidos ou avisados" relacionados a assistência médica hospitalar.
