<template>
    <div class="container">
      <h1>Buscar Operadoras</h1>
  
      <div class="search-box">
        <input 
          v-model="termoBusca" 
          placeholder="Digite um termo para buscar" 
          @keyup.enter="buscar"
        />
        <button @click="buscar" :disabled="buscando">🔍 Buscar</button>
      </div>
  
      <p v-if="erro" class="error-message">{{ erro }}</p>
      <div v-if="buscando" class="loading">⏳ Carregando resultados...</div>
  
      <div v-if="operadoras.length > 0" class="table-container">
        <div class="table-wrapper">
          <table class="table">
            <thead>
              <tr>
                <th v-for="(label, campo) in cabecalhos" :key="campo">{{ label }}</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="operadora in operadoras" :key="operadora.Registro_ANS">
                <td v-for="(label, campo) in cabecalhos" :key="campo">
                  {{ operadora[campo] || "Não disponível" }}
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
  
      <p v-else-if="!buscando && !erro && pesquisou" class="no-results">
        Nenhum resultado encontrado.
      </p>
    </div>
  </template>
  
  <script>
  import { buscarOperadoras } from "@/services/api";
  
  export default {
    data() {
      return {
        termoBusca: "",
        operadoras: [],
        erro: "",
        buscando: false,
        pesquisou: false,
        cabecalhos: {
          Registro_ANS: "Registro ANS",
          CNPJ: "CNPJ",
          Nome_Fantasia: "Nome Fantasia",
          Modalidade: "Modalidade",
          Cidade: "Cidade",
          UF: "UF",
          Telefone: "Telefone",
        },
      };
    },
    methods: {
      async buscar() {
        this.buscando = true;
        this.erro = "";
        this.operadoras = [];
        this.pesquisou = true;
  
        try {
          this.operadoras = await buscarOperadoras(this.termoBusca);
        } catch (erro) {
          this.erro = erro.message;
        } finally {
          this.buscando = false;
        }
      },
    },
  };
  </script>
  