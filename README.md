# Todo list Back-end com Java Spring
    
<br>

<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
<img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white"/>

<br>

## User, endpoint aberto

* `POST /users/`: Cria usuário.
``` json
{
    "username": "string",
    "password": "string",
    "name": "string"
}
```

<br>

## Task, exige autenticação 'basic auth'

* `POST /tasks/`: Cria tarefa ligada ao usuário logado.

``` json
{  
    "title": "string",
    "description": "string",
    "priority": "string",
    "startAt": "yyyy-mm-ddThh:mm:ss",
    "endAt": "yyyy-mm-ddThh:mm:ss" 
}
```

* `GET /tasks/`: Lista tarefas ligadas ao usuário logado.

* `PUT /tasks/{id}`: Atualiza tarefa ditada pelo id.

    Referenciar `/tasks/` omitindo as propriedades inalteradas.

<br>

<br>

<p align="center"><b>
Se gostou 🌟 - Por André Paulino {🎧}
</b></p>
