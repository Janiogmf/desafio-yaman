package com.yaman.config.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static Response consultaApi() {
		RestAssured.baseURI = "https://api.trello.com/1/actions/592f11060f95a3d3d46a987a";
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");

		Response response = request.get();

		return response;
	}

}
