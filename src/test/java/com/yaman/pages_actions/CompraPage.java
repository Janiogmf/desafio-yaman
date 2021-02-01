package com.yaman.pages_actions;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.yaman.config.hooks.ReportFactoryTest;

public class CompraPage {
    BasePage base = new BasePage();
    WebDriver driver = ReportFactoryTest.driver;
    
 // *********Variaveis interativas*********
 	public String produtoCarrinho = "";
 	public String valor = "";
 	
 // *********Web Elements*********
 	String inputBusca = "search-input";
 	By lupaBusca = By.cssSelector("button[qa-automation='home-search-button']");
 	By produtos = By.cssSelector("div[qa-automation='search-itens']");
 	By tamanho = By.cssSelector("section.product-size-selector ul.radio-options li");
 	By loadingEscolhaTamnho = By.cssSelector("div.loading-box");
 	By btnComprar = By.cssSelector("section#action-buttons button[qa-automation='product-buy-button']");
 	By nomeProduto = By.cssSelector("h3[qa-auto='product-name']");
 	By precoProduto = By.cssSelector("div[qa-auto='cart-price']");
 	By btnContinuarCompra = By.cssSelector("a[qa-auto='cart-buy-button']");
 	String inputUsuario = "username";
 	String inputSenha = "password";
 	String btnLogin = "login-button";
 	By nomeProdutoResumo = By.cssSelector("ul.summary-products strong");
 	By precoProdutoResumo = By.cssSelector("ul.summary-products div[class$='product-price']");
 	By lodingLogin = By.cssSelector("div.button-wrapper button#login-button");

	public void buscaProduto(String produto) {
		base.clicarBotao(inputBusca);
		base.escrever(inputBusca, produto);
		base.clicarBotao(lupaBusca);
		List<WebElement> listProdutos = base.listar(produtos);
		listProdutos.get(base.randomNum(listProdutos.size())).click();
		List<WebElement> sizeProduto = base.listar(tamanho);
		sizeProduto.get(1).click();
		base.aguardarInvisibilidadeElemento(loadingEscolhaTamnho, 30);
		base.clicarBotao(btnComprar);
		produtoCarrinho = base.receberTexto(nomeProduto);
		valor = base.receberTexto(precoProduto);
		base.clicarBotao(btnContinuarCompra);
	}

	public void validarInclusaoProduto() {
		base.clicarBotao(inputUsuario);
		base.escrever(inputUsuario, "qaautomacao@automacao.com.br");
		base.clicarBotao(inputSenha);
		base.escrever(inputSenha, "jgm013");
		base.clicarBotao(btnLogin);
		base.aguardarInvisibilidadeElemento(loadingEscolhaTamnho, 30);
		base.aguardarInvisibilidadeElemento(lodingLogin, 60);
		String itemPedido = base.receberTexto(nomeProdutoResumo);
		String precoItem = base.receberTexto(precoProdutoResumo);
		assertEquals(itemPedido, produtoCarrinho);
		assertEquals(precoItem, valor);
	}

	public void acessarSite(String site) {
		driver.get("https://www.shoestock.com.br/");
	}

}
