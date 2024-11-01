** Colección de Vinilos **

Aplicación de consola en Java para gestionar una colección de vinilos. Permite agregar, buscar y consultar la cantidad de vinilos, con validaciones para evitar duplicados y datos inválidos.

** Estructura del Proyecto **

- Vinilo: Representa un vinilo, con atributos como el nombre del artista, el nombre del disco y el año de lanzamiento.
- ViniloManager: Gestiona la lógica de negocio para la colección de vinilos.
- ViniloMenu: Proporciona una interfaz de usuario en consola.
- ViniloManagerTest: Contiene las pruebas unitarias que verifican la funcionalidad de ViniloManager utilizando JUnit.
-
** Pruebas Unitarias **
- 
Las pruebas unitarias están diseñadas para verificar los métodos de ViniloManager y asegurar que manejen adecuadamente los casos comunes y los extremos:

Pruebas de agregarVinilo:

- testAgregarViniloConDatosValidos: Verifica que se agregue un vinilo con datos correctos.
- testAgregarViniloConDatosInvalidos: Comprueba que no se agreguen vinilos con datos inválidos, manteniendo el tamaño de la colección sin cambios.
- testAgregarViniloConNombreDeUnaLetra: Asegura que se permita agregar un vinilo donde el nombre del artista sea de una sola letra.
- testNoAgregarViniloDuplicado: Garantiza que no se agreguen duplicados a la colección.

Pruebas de buscarVinilo:

- testBuscarViniloExistente: Verifica que se pueda encontrar un vinilo que existe en la colección.
- testBuscarViniloNoExistente: Comprueba que no se devuelvan resultados para un vinilo que no está en la colección.
- testBuscarViniloConDatosParciales: Asegura que no se encuentre un vinilo si faltan algunos datos.
- testBuscarViniloConAnoInvalido: Verifica que el año de lanzamiento deba coincidir exactamente para que el vinilo sea encontrado.

Prueba de Límite Máximo de Vinilos:

- testLimiteMaximoVinilos: Asegura que la colección no permita agregar más de 100 vinilos. Si se intenta añadir un vinilo adicional después de alcanzar este límite, el tamaño de la colección debe permanecer en 100.