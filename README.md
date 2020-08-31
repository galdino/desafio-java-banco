# Desafio Java Banco

Serviço REST de aplicação financeira.

Comandos para montar o ambiente(executar em ../desafio-java-banco/docker):
```
docker-compose build --no-cache && docker-compose up 
```

### Endpoints/serviço:

<ul>
  <li>post - http://localhost:8080/pessoas</li>
</ul>

```json
{
    "nome": "Ricardo",
    "tipo": "PF",
    "numDocumento": "01254123372"
} 
```

<ul>
  <li>get - http://localhost:8080/pessoas</li>
</ul>

```json
[
    {
        "idPessoa": 1,
        "nome": "Fernando Galdino",
        "tipo": "PF",
        "numDocumento": "01554223378",
        "score": 2
    },
    {
        "idPessoa": 2,
        "nome": "Amelia Gomes",
        "tipo": "PF",
        "numDocumento": "01265745888",
        "score": 9
    },
    {
        "idPessoa": 3,
        "nome": "Mundo Pet LTDA",
        "tipo": "PJ",
        "numDocumento": "48447654000194",
        "score": 5
    },
    {
        "idPessoa": 4,
        "nome": "Ricardo",
        "tipo": "PF",
        "numDocumento": "01254123372",
        "score": 2
    }
] 
```

<ul>
  <li>get - http://localhost:8080/contas</li>
</ul>

```json
[
    {
        "idConta": 1,
        "numero": 111111,
        "agencia": 3755,
        "tipo": "C",
        "idPessoa": 1,
        "carteiras": [
            {
                "idCarteira": 1,
                "limiteCE": 1000.0,
                "limiteCC": 200.0
            }
        ]
    },
    {
        "idConta": 2,
        "numero": 222222,
        "agencia": 3755,
        "tipo": "C",
        "idPessoa": 2,
        "carteiras": [
            {
                "idCarteira": 2,
                "limiteCE": 5000.0,
                "limiteCC": 15000.0
            }
        ]
    },
    {
        "idConta": 3,
        "numero": 333333,
        "agencia": 3755,
        "tipo": "E",
        "idPessoa": 3,
        "carteiras": [
            {
                "idCarteira": 3,
                "limiteCE": 1000.0,
                "limiteCC": 200.0
            }
        ]
    },
    {
        "idConta": 4,
        "numero": 696137,
        "agencia": 3755,
        "tipo": "C",
        "idPessoa": 4,
        "carteiras": [
            {
                "idCarteira": 4,
                "limiteCE": 1000.0,
                "limiteCC": 200.0
            }
        ]
    }
] 
```