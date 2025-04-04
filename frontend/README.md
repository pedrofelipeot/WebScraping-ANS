# Frontend - Web Scraping Operadoras (Vue.js)

## Descrição

Este é o frontend de uma aplicação para buscar operadoras de saúde, utilizando Vue.js. O sistema permite que o usuário busque operadoras pelo nome, exibindo os resultados em uma tabela e fornecendo informações detalhadas sobre cada operadora.

## Funcionalidades

- **Busca por Operadora**: O usuário pode buscar operadoras de saúde utilizando um termo específico.
- **Tabela de Resultados**: Os resultados da busca são exibidos em uma tabela com colunas como: Registro ANS, CNPJ, Nome Fantasia, Modalidade, Cidade, UF e Telefone.
- **Mensagens de Status**: Durante a busca, são exibidas mensagens de erro ou de carregamento, dependendo do estado da requisição.

## Instalação

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
   ```

2. Navegue até a pasta do projeto:
   ```bash
   cd nome-do-repositorio
   ```

3. Instale as dependências:
   ```bash
   npm install
   ```

4. Inicie o servidor de desenvolvimento:
   ```bash
   npm run serve
   ```

5. Acesse a aplicação em `http://localhost:8080`.

## Estrutura de Diretórios

```css
frontend/
├── src/
│   ├── assets/
│   │   ├── logo.png
│   ├── components/
│   │   ├── BuscarOperadora.vue
│   ├── services/
│   │   ├── api.js
│   ├── App.vue
│   ├── main.js
├── package.json
├── README.md
├── .gitignore
```

## Dependências

- **Vue.js**: Framework utilizado para construir a interface de usuário.
- **Axios**: Biblioteca utilizada para realizar as requisições HTTP.

## Como Contribuir

1. Faça um fork do repositório.
2. Crie uma branch para sua modificação:
   ```bash
   git checkout -b feature/nova-funcionalidade
   ```
3. Realize a modificação e faça um commit:
   ```bash
   git commit -am 'Adiciona nova funcionalidade'
   ```
4. Envie para o seu repositório:
   ```bash
   git push origin feature/nova-funcionalidade
   ```
5. Abra um pull request para revisão.

## Licença

Este projeto está licenciado sob a MIT License - veja o arquivo LICENSE para mais detalhes.
