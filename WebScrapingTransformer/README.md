
# WebScrapingTransformer

Este projeto realiza o scraping de um site governamental, baixa anexos em formato PDF, extrai dados de tabelas e os converte em arquivos CSV. Além disso, compacta os arquivos em um único arquivo ZIP.

## Funcionalidades

- **Acessa o site**: https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos
- **Baixa os arquivos PDF**: Anexo I e Anexo II.
- **Extrai as tabelas do Anexo I (em PDF)** e converte em um arquivo CSV.
- **Substitui abreviações**: Converte "OD" para "Seg. Odontológica" e "AMB" para "Seg. Ambulatorial".
- **Compacta os arquivos**: PDFs e CSVs são compactados em um arquivo ZIP.

## Requisitos

- JDK 11 ou superior
- Dependências gerenciadas via Maven

## Como rodar

1. Clone este repositório:

   ```bash
   git clone https://github.com/pedrofelipeot/WebScrapingTransformer.git
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd WebScrapingTransformer
   ```

3. Compile e execute o projeto com Maven:

   ```bash
   mvn clean install
   mvn exec:java
   ```

## Estrutura do projeto

- `src/main/java/org/example`: Contém o código-fonte Java, incluindo as classes responsáveis pela manipulação de arquivos, PDFs e requisições HTTP.
- `pom.xml`: Arquivo de configuração do Maven que define as dependências do projeto.
- `.gitignore`: Arquivo para ignorar arquivos temporários ou específicos de IDEs.

## Dependências

- [Tabula](https://tabulapdf.org/): Biblioteca para extração de tabelas de arquivos PDF.
- [JSoup](https://jsoup.org/): Biblioteca para scraping de conteúdo HTML.

## Licença

Este projeto é para fins educacionais e de testes. Não possui licença de código aberto.
