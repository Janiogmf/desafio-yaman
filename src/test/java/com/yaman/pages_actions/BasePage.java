package com.yaman.pages_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.yaman.config.hooks.ReportFactoryTest;

import cucumber.api.Scenario;

import java.util.List;
import java.util.Random;

public class BasePage {
	static WebDriver driver = ReportFactoryTest.driver;
	static Scenario cenario;

	public void escrever(By by, String texto) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
	}

	public void escrever(String id_campo, String texto) {
		escrever(By.id(id_campo), texto);
	}

	/**
	 * Recebe um texto que esteja em um determinado elemento na estrutura Xpath,
	 * caso não o texto é procurado através de um By no css. Metodo Overload
	 * 
	 * @param id - String
	 * @param by - Elemento
	 * @return
	 * @author Jânio marinho.
	 */
	public String receberTexto(String id) {
		String texto;
		texto = driver.findElement(By.id(id)).getText();
		return texto;
	}

	public String receberTexto(By by) {
		String texto;
		texto = driver.findElement(by).getText();
		return texto;
	}

	/**
	 * Clica em um botão pré-determinado via id ou by css. Metodo Overload
	 * 
	 * @param id - String
	 * @param by - Elemento
	 * @author Jânio Marinho
	 */
	public void clicarBotao(String id) {
		driver.findElement(By.id(id)).click();
	}

	public void clicarBotao(By by) {
		driver.findElement(by).click();
	}

	public void aguardarInvisibilidadeElemento(By by, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public int randomNum(int num) {
		Random geradorRW = new Random();
		int numGerado = geradorRW.nextInt(num);
		return numGerado;
	}

	/**
	 * Metodos listar elementos repitidos.
	 * 
	 * @param by, elem
	 * @author Jânio Marinho
	 */
	public List<WebElement> listar(By by) {
		List<WebElement> elems = driver.findElements(by);
		return elems;
	}

	public List<WebElement> listar(WebElement elem, By by) {
		List<WebElement> list = elem.findElements(by);
		return list;
	}
}
