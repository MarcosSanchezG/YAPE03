# language: es
Característica: GENERACION DE PETICIONES APIS

  @tag1
  Escenario: : Generar token
  Cuando ingreso usuario y clave
  Entonces valido token

  @tag2
  Escenario: : Obtener Booking id
  Cuando obtengo id
  Cuando valido numero de id

  @tag3
  Escenario: : Obtener Ping
  Cuando obtengo Ping
  Entonces valido numero de Ping


  @tag4
  Esquema del escenario:: Creacion de Booking
    Cuando completo el campo firstname <NOMBRE>
    Y completo el campo Apellido <APELLIDO>
    Y completo el campo Precio <PRECIO>
    Y completo el campo Depósito <DEPOSITOP>
    Y completo el campo Fecha reserva <FECHAR> fecha de pago <FECHAP>
    Y completo el campo adicionales <ADICIONALES>
    Entonces se envia solicitud
    Ejemplos:
      | NOMBRE | APELLIDO  | PRECIO | DEPOSITOP | FECHAR     | FECHAP     | ADICIONALES |
      | Joel   | Sanchez   | 120    | true      | 2018-01-01 | 2019-01-01 | desayuno    |
      | Marcos | Galan     | 10     | true      | 2023-11-11 | 2023-11-31 | cena        |
      | Juan   | Dominguez | 120    | true      | 2018-01-01 | 2019-01-01 | almuerzo    |

