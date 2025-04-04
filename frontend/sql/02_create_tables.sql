USE demonstracoes_contabeis;

CREATE TABLE IF NOT EXISTS demonstracoes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data DATE NOT NULL,
    reg_ans INT NOT NULL,
    cd_conta_contabil BIGINT NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    vl_saldo_inicial DECIMAL(15,2) NOT NULL,
    vl_saldo_final DECIMAL(15,2) NOT NULL
);
