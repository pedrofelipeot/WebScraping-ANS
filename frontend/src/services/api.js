import axios from "axios";

const API_URL = "http://127.0.0.1:5000/buscar";

export async function buscarOperadoras(termo) {
  try {
    const resposta = await axios.get(`${API_URL}?q=${termo}`);
    return Array.isArray(resposta.data) ? resposta.data : [];
  } catch (erro) {
    console.error("Erro ao buscar operadoras:", erro);
    throw new Error("Erro ao buscar operadoras. Tente novamente.");
  }
}
