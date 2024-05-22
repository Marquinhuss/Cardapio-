Cardápio Digital

Descrição

Cardápio Digital é um sistema para gerenciamento de pedidos de um restaurante. 
Ele permite a criação, atualização, leitura e exclusão de pedidos e itens do cardápio, calculando o valor total do pedido com base nos itens selecionados.

Funcionalidades

- Criação de pedidos
- Gestão de itens do cardápio
- Atualização de pedidos
- Exclusão de pedidos
- Consulta de pedidos por cliente
- Tecnologias Utilizadas
- Java
- Spring Boot
- JPA/Hibernate
- PostgreSQL
- Maven

Requisitos
Java 17 ou superior
SpringBoot
Lombok
Maven
PostgreSQL

Configurar o caminho do Banco de Dados no arquivo application.properties

EndPoints

Também disponivel ao iniciar a aplicação e acessando a url http://seuEndereço/swagger-ui/index.html#/

OrdersController

Get All Orders
Descrição: Retorna uma lista de todos os pedidos.
Método HTTP: GET
URL: /api/orders
Resposta:
Status: 200 OK
Body:
json
[
    {
        "id": 1,
        "client_Id": 1,
        "foods_Id": [
	1,
	2],
        "totalValue": 39.98
    },
    {
        "id": 2,
        "client_Id": 2,
        "foods_Id": [3],
        "totalValue": 19.99
    }
]

Get Order by ID
Descrição: Retorna os detalhes de um pedido específico.
Método HTTP: GET
URL: /api/orders/{orderId}
Resposta:
Status: 200 OK
Body:
json
{
    "id": 1,
    "client_Id": 1,
    "foods_Id": [1, 2],
    "totalValue": 39.98
}

Create New Order

Descrição: Cria um novo pedido.
Método HTTP: POST
URL: /api/orders criar um body na requisição
Caso a lista de foods estiver vazia ou os ids não existerem na tabela de foods retornará
Body:
json
{
    "client_Id":"1",
    "foods_Id": [1,2,],
    "totalValue": ""
}
Resposta:
Status: 201 CREATED
Body:
json
{
    "id": 1,
    "client_Id": 1,
    "foods_Id": [1, 2],
    "totalValue": XX.XX
}

Update Order
Descrição: Atualiza um pedido existente.
Método HTTP: PUT
URL: /api/orders/update/{orderId}
Body:
json
Copiar código
{
    "client_Id": 1,
    "foods_Id": [1, 2, 3],
    "totalValue": ""
}

Delete Order
Descrição: Exclui um pedido.
Método HTTP: DELETE
URL: /api/orders/{orderId}
Resposta:
Status: 200 OK
Body:
json
{
    "message": "Order successfully deleted"
}

Próximo update será o cadastramento de usuário e utilização de SpringSecurity
