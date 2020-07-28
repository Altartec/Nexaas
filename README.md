# PROJETO CLIENT/SERVER
Este projeto tem a intenção de demonstrar um ambiente contendo um client e um server desenvolvido em linguagem java.
A principal intenção é a demonstração da utilização das seguintes bibliotecas:
* XStream - Utilizada para a transformação de um objeto em xml e também para preencher um objeto usando um xml.
* SocketServer - Utilizado para a comunicação entre o AppClient e o AppServer, utilizando o ip 127.0.01 e a porta 1025.
* JUnit - Utilizado para efetuar os testes unitários.
* InputStreamReader- Utilizado para criar um método Web scrapper simples, para acessar as informações do https://www.imdb.com/
* Para efetuar a validação do código desenvolvido, foi utilizado a Ferramenta PMD.(https://pmd.sourceforge.io/pmd-5.0.4/)
* O código foi desenvolvido utilizando a ide eclipse. (https://www.eclipse.org/)
* Para automaticar a compilação, foi utilizado o Gradle.
* Obs. O funcionamento do projeto consiste em executar o StartAppServer (O mesmo ficará escutando a porta 1025 do ip 127.0.0.1), e logo em seguida executar o StartAppClient (O mesmo solicitará um nome para efetuar a procura no IMDB).

