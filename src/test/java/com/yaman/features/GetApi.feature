#language: pt
#encoding: iso-8859-1
#autor: janiogouveia@hotmail.com
@retorno-api
Funcionalidade: Fluxo get api
  Fazer consulta de api

  @done @Api
  Cenario: get de api com retorno names
    Dado que realize a consulta na api e retorne o valores do campo "name"
    Entao validar resposta 200