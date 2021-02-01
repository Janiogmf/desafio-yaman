package com.yaman.steps_definitions;

import com.yaman.pages_actions.ApiActions;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;

public class ApiSteps {
	ApiActions api = new ApiActions();
	
	@Dado("^que realize a consulta na api e retorne o valores do campo \"([^\"]*)\"$")
	public void queRealizeAConsultaNaApiERetorneOValoresDoCampo(String campo) {
		api.consulta(campo);
	}
	
	@Entao("^validar resposta (\\d+)$")
	public void validarResposta(int codRetorno) {
		api.validarStatusRetorno(codRetorno);
	}
}
