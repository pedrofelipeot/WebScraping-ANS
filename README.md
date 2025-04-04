# TESTES DE NIVELAMENTO

Este repositório contém a implementação de um conjunto de testes de nivelamento realizados nas áreas de Web Scraping, Transformação de Dados, Banco de Dados e API, utilizando Python, Java, MySQL, Vue.js, e ferramentas como Postman. O objetivo é abordar diferentes aspectos do desenvolvimento de software e análise de dados.

## Estrutura do Projeto

O projeto está organizado em diferentes pastas, cada uma responsável por uma tarefa específica do teste. Abaixo, fornecemos uma visão geral do que é encontrado em cada uma dessas pastas.

### 1. Web Scraping

Localizada na pasta `WebScraping`, esta parte do projeto executa o processo de web scraping para acessar o site da **ANS (Agência Nacional de Saúde Suplementar)** e realizar o download de dois arquivos PDF: **Anexo I** e **Anexo II**. Além disso, o código é responsável pela compactação desses arquivos em um único arquivo de formato **ZIP** ou **RAR**.

#### Principais funcionalidades:
- Acesso ao site da ANS para download dos anexos.
- Download de arquivos PDF de forma automatizada.
- Compactação dos arquivos em um único arquivo ZIP.

---

### 2. Transformação de Dados

A pasta `DataTransformation` contém o código responsável pela extração de dados do **Anexo I (PDF)** e transformação desses dados para um formato estruturado. O código faz o seguinte:

#### Funcionalidades:
- Extrai os dados da tabela **"Rol de Procedimentos e Eventos em Saúde"** de todas as páginas do PDF.
- Converte esses dados para um formato **CSV**.
- Compacta o arquivo CSV em um arquivo ZIP nomeado como `Teste_{seu_nome}.zip`.
- Substitui as abreviações das colunas por descrições completas, conforme a legenda do rodapé.

---

### 3. Banco de Dados

A pasta `Database` contém scripts **SQL** que realizam a preparação e manipulação de dados em banco de dados. Os passos incluem:

#### Principais funcionalidades:
- Baixar arquivos do repositório público da **ANS**.
- Criar tabelas e importar os dados **CSV** para o banco de dados.
- Criar **queries analíticas**, incluindo:
  - Consultar as **10 operadoras** com maiores despesas em "Eventos/Sinistros Conhecidos".
  - Consultar as **10 operadoras** com maiores despesas no último ano.

---

### 4. API

A pasta `API` contém a implementação de uma **interface web** usando **Vue.js** que interage com um **servidor Python**. Essa API realiza buscas na lista de cadastros de operadoras e retorna os registros mais relevantes.

#### Funcionalidades:
- Criação de um servidor Python com uma rota para buscar operadoras.
- Interação com o servidor via interface web construída com Vue.js.
- Coleção de **testes para a API**, que pode ser importada no Postman.

---

### 5. Postman

A pasta `Postman` contém uma coleção de **testes para a API**. Essa coleção pode ser importada para o **Postman** para facilitar a execução e verificação das rotas da API.

#### Funcionalidades:
- Testes de API configurados no Postman para interagir com a API desenvolvida.
- Testes de busca de operadoras na API.

---

## Como Usar

### **Pré-requisitos**
- **Python** ou **Java** (para o teste de web scraping e transformação de dados).
- **MySQL** ou **PostgreSQL** (para o banco de dados).
- **Vue.js** (para a interface web).
- **Postman** (para testar a API).

### **Passos Gerais**

#### **Web Scraping:**
1. Navegue até a pasta `WebScraping` e execute o código para acessar o site e baixar os anexos.
2. Compacte os arquivos em formato ZIP.

#### **Transformação de Dados:**
1. Navegue até a pasta `DataTransformation` e execute o código para transformar os dados extraídos do PDF em **CSV** e compactá-los.

#### **Banco de Dados:**
1. Acesse a pasta `Database` e siga as instruções para rodar os scripts SQL.
2. Importe os dados e crie as tabelas necessárias.

#### **API:**
1. Na pasta `API`, configure o servidor **Python**.
2. Crie a interface em **Vue.js** para interagir com a API.

#### **Postman:**
1. Importe a coleção de testes da pasta `Postman` para verificar as rotas da API.

---

## **Contribuições**

Se você deseja contribuir para este projeto, siga os passos abaixo:

1. **Fork** o repositório.
2. Crie uma **branch** para sua modificação:
   ```bash
   git checkout -b feature/nova-funcionalidade
   ```
3. Realize a modificação e faça um **commit**:
   ```bash
   git commit -am 'Adiciona nova funcionalidade'
   ```
4. Envie para o seu repositório:
   ```bash
   git push origin feature/nova-funcionalidade
   ```
5. Abra um **pull request** para revisão.

---

### **Licença**

Este projeto está licenciado sob a **MIT License** - veja o arquivo `LICENSE` para mais detalhes.
