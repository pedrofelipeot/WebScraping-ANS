import os
import pandas as pd
from config import CSV_FILE

def carregar_dados():
    if not CSV_FILE or not os.path.exists(CSV_FILE):
        return None
    return pd.read_csv(CSV_FILE, delimiter=';', dtype=str)

df = carregar_dados()

def buscar_operadoras(query):
    """ Filtra os dados com base na busca do usuário. """
    if df is None:
        return {"erro": "Banco de dados não carregado"}, 500  

    query = query.strip().lower()
    if not query:
        return {"erro": "Parâmetro de busca vazio"}, 400  

    colunas_textuais = df.select_dtypes(include=["object"]).columns
    resultado = df[df[colunas_textuais].apply(lambda row: row.str.lower().str.contains(query, na=False)).any(axis=1)]

    if resultado.empty:
        return {"erro": "Nenhum resultado encontrado"}, 404  

    resultado = resultado.where(pd.notna(resultado), None)

    if 'Nome_Fantasia' in resultado.columns:
        resultado['Nome_Fantasia'] = resultado['Nome_Fantasia'].fillna("Nome não disponível")
    if 'Razao_Social' in resultado.columns:
        resultado['Razao_Social'] = resultado['Razao_Social'].fillna("Nome não disponível")

    return resultado.to_dict(orient="records"), 200 
