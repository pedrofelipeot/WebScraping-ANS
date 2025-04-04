# WebScraping-ANS - Postman Collection

Este repositório contém a coleção do Postman para interagir com o backend do projeto **WebScraping-ANS**. A coleção inclui todas as requisições para testar os endpoints do backend e verificar a funcionalidade da API.

## Endpoints Disponíveis

### 1. **Buscar Operadora**

- **Método**: `GET`
- **URL**: `http://localhost:5000/buscar?q={termo}`
- **Descrição**: Pesquisa operadoras de saúde com base no termo enviado como parâmetro `q`.
- **Parâmetro**:
  - `q` (requerido): Termo para buscar nas operadoras.
  
**Exemplo de Requisição**:
```http
GET http://localhost:5000/buscar?q=odonto
```

**Resposta Esperada:**
```json
[
  {
    "Registro_ANS": "12345",
    "CNPJ": "12345678000195",
    "Nome_Fantasia": "Operadora A",
    "Modalidade": "Odonto",
    "Cidade": "São Paulo",
    "UF": "SP",
    "Telefone": "(11) 1234-5678"
  },
  {
    "Registro_ANS": "67890",
    "CNPJ": "98765432000199",
    "Nome_Fantasia": "Operadora B",
    "Modalidade": "Odonto",
    "Cidade": "Rio de Janeiro",
    "UF": "RJ",
    "Telefone": "(21) 9876-5432"
  }
]
```

### 2. **Erro ao Buscar**

- **Método**: `GET`
- **URL**: `http://localhost:5000/buscar?q={termo}`
- **Descrição**: Caso não haja operadora para o termo informado, a resposta será um erro de 404 com a seguinte mensagem.

**Exemplo de Requisição:**
```http
GET http://localhost:5000/buscar?q=termo_inexistente
```

**Resposta Esperada:**
```json
{
  "erro": "Nenhuma operadora encontrada."
}
```

## Como Importar a Coleção no Postman

1. Abra o Postman.
2. Clique em **Import** no canto superior esquerdo.
3. Selecione **Importar do Link** e cole o link do repositório, ou importe diretamente a coleção em formato JSON.
4. Teste os endpoints e veja os resultados.

## Configuração do Backend

- Certifique-se de que o backend esteja rodando em `http://localhost:5000`.
- No caso de erro 404, verifique se o arquivo CSV de operadoras está no local correto.

Este é o ponto de partida para interagir com a API do **WebScraping-ANS**. Certifique-se de que o backend esteja corretamente configurado e em execução para testar as requisições.
