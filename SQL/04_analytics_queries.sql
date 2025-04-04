USE demonstracoes_contabeis;

-- Quais as 10 operadoras com maiores despesas no último trimestre?
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

-- Quais as 10 operadoras com maiores despesas nessa categoria no último ano?
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
