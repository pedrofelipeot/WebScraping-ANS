import os

CSV_FILE = "D:\\WebScraping-ANS\\backend\\Relatorio_cadop.csv"

if not os.path.exists(CSV_FILE):
    print("Erro: Arquivo CSV não encontrado!")
else:
    print("Arquivo CSV encontrado com sucesso!")
