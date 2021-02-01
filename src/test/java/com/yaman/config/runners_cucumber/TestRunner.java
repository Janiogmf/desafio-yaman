package com.yaman.config.runners_cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = {"@done", "@Api"},
		features = "src/test/java/com/yaman/features", 
		plugin = { 
				 "pretty",
				 "json:target/cucumber-reports/cucumber.json", //Imprime a fonte Gherkin com cores adicionais e rastreia a pilha para erros
				 "rerun:target/cucumber-reports/rerun.txt", 
		}, 
		snippets = SnippetType.CAMELCASE, // cria os nomes dos metodos sem _ com Letas maiscula por palavras
		glue = { "com.yaman.steps_definitions", "com.yaman.config.hooks" }, 
		monochrome = true, //Sem Caracters especiais nas logs do Console
		dryRun = false, //Quando true, ele valida se o mapeamento esta correto sem executar o navegador
		strict = true//Quando true, ele falha o teste se encontrar algum steps como undefined/pending
)

public class TestRunner {	

}
