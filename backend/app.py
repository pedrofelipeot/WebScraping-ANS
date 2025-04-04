from flask import Flask, request, jsonify
from flask_cors import CORS
from busca import buscar_operadoras

app = Flask(__name__)
CORS(app)  

@app.route('/buscar', methods=['GET'])
def buscar():
    query = request.args.get('q', '')
    resultado = buscar_operadoras(query)

    if isinstance(resultado, tuple): 
        return jsonify(resultado[0]), resultado[1]

    return jsonify(resultado), 200 

if __name__ == '__main__':
    app.run(debug=True)
