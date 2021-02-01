#language: pt
#encoding: iso-8859-1
#autor: janiogouveia@hotmail.com
@fluxo-compra
Funcionalidade: Fluxo compra
  Cliente faz busca conteudo para realizar compra

  @done @Web
  Cenario: Validar os produtos incluidos no carrinho na tela de pagamento
    Dado que acesse o site "https://www.shoestock.com.br/"
    E que realize a busca "Tênis" e inclua produto no carrinho de compras
    Entao validar produtos incluidos na tela de pagamento
