GCFramework
===========

Framework JOGL para criação de "toy examples" ou projetos de computação gráfica.

INSTALAÇÃO------------------------

Para instalar o framework, basta importar o código do projeto para o eclipse,
criando um projeto que irá referenciar o projeto do framework.

A classe CGTemplate é a classe que o usuário deverá extender para aproveitar 
suas funcionalidades.

Todo Objeto a ser renderizado deverá extender a classe AutoDrawnableObject 
e os comandos do JOGL para a renderizaçao do mesmo devem estar no método selfDraw.

Os objetos deverão ser adicionados no método initObjects da classe CGTemplate
