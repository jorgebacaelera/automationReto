# language: es
Característica: Realizar compra de productos desde la web AutomationPractice

  Como cliente registrado en la web AutomationPractice
  Quiero reservar productos en el carrito de compras
  Para realizar el pago total del pedido

  # Escenarios de negocio
  @ComprarProductos
  Esquema del escenario: Comprar productos desde la web de AutomationPractice

    Dado que el cliente accede a la web de AutomationPractice

    Y el cliente decide registrarse como usuario indicando su email <email>

    Y el cliente ingresa los datos de su nombre <nombre> y apellido <apellido>

    Y el cliente indica la contraseña <password> para la cuenta

    Y el cliente confirma los datos de dirección de entrega

    Y el cliente accede de forma automática a la web de compras

    Cuando el cliente decide seleccionar productos a comprar

    Y el cliente confirma la totalidad de productos a comprar

    Entonces deberá visualizar el detalle del pedido

    Ejemplos:
      |nombre   |apellido   | email                             |password   |
      |Jorge    |Baca       |jorgebaca_prueba2243@yopmail.com   |Abc123456$ |

