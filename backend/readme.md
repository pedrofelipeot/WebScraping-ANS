# Backend - Web Scraping Operadoras (Flask)

## Descrição

Este repositório contém o backend para a aplicação de web scraping de operadoras de saúde. A API foi construída utilizando o framework **Flask** e fornece um endpoint para buscar operadoras a partir de um arquivo CSV. A busca retorna as operadoras que correspondem ao termo de pesquisa.

## Funcionalidades

- **Busca de Operadoras**: O backend possui um endpoint `/buscar` que permite buscar operadoras de saúde com base no termo fornecido pelo usuário.
- **Retorno de Dados**: A API retorna os dados das operadoras no formato JSON, incluindo informações como Registro ANS, CNPJ, Nome Fantasia, Modalidade, Cidade, UF e Telefone.
- **Verificação de Arquivo CSV**: Antes de realizar a busca, o backend verifica se o arquivo CSV necessário para a busca das operadoras está presente.

## Instalação

### Pré-requisitos

1. **Python 3.x**: Certifique-se de que você tenha o Python 3 instalado em sua máquina.
2. **Dependências**: O projeto utiliza algumas bibliotecas do Python, que podem ser instaladas com o comando `pip`.

### Passos para Instalação

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
   ```
2. **Navegue até o diretório do projeto**:
   ```bash
   cd nome-do-repositorio
   ```
3. **Crie e ative um ambiente virtual**:
   
   No Windows:
   ```bash
   python -m venv venv
   .\venv\Scripts\activate
   ```
   
   No Linux/Mac:
   ```bash
   python3 -m venv venv
   source venv/bin/activate
   ```
4. **Instale as dependências**:
   ```bash
   pip install -r requirements.txt
   ```
5. **Certifique-se de que o arquivo CSV está no diretório correto**:
   - O arquivo `Relatorio_cadop.csv` deve estar na pasta do backend.
6. **Inicie o servidor Flask**:
   ```bash
   python app.py
   ```
   O servidor estará rodando localmente em http://127.0.0.1:5000.

## Estrutura de Diretórios

```
backend/
├── app.py               # Arquivo principal do backend
├── busca.py                  # Lógica para carregar e filtrar os dados do CSV
├── config.py                 # Configuração de variáveis e caminhos
├── venv/                     # Ambiente virtual do Python
├── Relatorio_cadop.csv  # Arquivo CSV com os dados das operadoras
├── README.md            # Documentação do projeto
```

## Dependências

Este projeto utiliza as seguintes dependências:

- **Flask**: Framework micro para Python, usado para criar a API.
- **pandas**: Biblioteca usada para manipulação de dados CSV.

## Endpoints

### **GET /buscar**

- **Descrição**: Este endpoint realiza a busca por operadoras de saúde com base no parâmetro `q`, que é o termo a ser pesquisado.
- **Parâmetros**:
  - `q` (query): O termo que será utilizado para buscar as operadoras.

#### **Exemplo de Requisição**:
```bash
GET http://127.0.0.1:5000/buscar?q=odonto
```

#### **Exemplo de Resposta**:
```json
[
  {
    "Registro_ANS": "123456",
    "CNPJ": "12.345.678/0001-23",
    "Nome_Fantasia": "Odonto Saúde",
    "Modalidade": "Ambulatorial",
    "Cidade": "São Paulo",
    "UF": "SP",
    "Telefone": "(11) 1234-5678"
  },
  {
    "Registro_ANS": "789012",
    "CNPJ": "98.765.432/0001-87",
    "Nome_Fantasia": "Odonto Plus",
    "Modalidade": "Hospitalar",
    "Cidade": "Rio de Janeiro",
    "UF": "RJ",
    "Telefone": "(21) 9876-5432"
  }
]
```

### **Erros**
Se o arquivo CSV não for encontrado, a API retornará um erro:
```json
{ "erro": "Arquivo CSV não encontrado!" }
```
