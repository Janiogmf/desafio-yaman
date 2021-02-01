package com.yaman.pages_actions;

import static org.junit.Assert.assertEquals;

import com.yaman.config.utils.Utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiActions {
	// *********Variaveis interativas*********
	 	public int status = 0;
	
	public void consulta(String campo) {
		Response resp = Utils.consultaApi();
		status = resp.getStatusCode();
		JsonPath jsonPathEvaluator = resp.jsonPath();
		System.out.println("Valor campo name: "+jsonPathEvaluator.get("data.list."+campo).toString());
	}

	public void validarStatusRetorno(int codRetorno) {
		assertEquals(status, codRetorno);
	}

}
