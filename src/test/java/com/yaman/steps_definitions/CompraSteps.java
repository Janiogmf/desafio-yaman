package com.yaman.steps_definitions;

import com.yaman.pages_actions.CompraPage;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;

public class CompraSteps {
	CompraPage compra = new CompraPage();
	
	@Dado("^que acesse o site \"([^\"]*)\"$")
	public void queAcesseOSite(String site) {
		compra.acessarSite(site);
	}
	
	@Dado("^que realize a busca \"([^\"]*)\" e inclua produto no carrinho de compras$")
	public void queRealizeABuscaEIncluaProdutoNoCarrinhoDeCompras(String produto) {
		compra.buscaProduto(produto);
	}

	@Entao("^validar produtos incluidos na tela de pagamento$")
	public void validarProdutosIncluidosNaTelaDePagamento() {
		compra.validarInclusaoProduto();
	}
}
