package com.googledrive.files;

import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class APIBase {
	
//	 RequestSpecification request ;
	 
//	public APIBase() {
//		
//		 request = given().baseUri("https://www.googleapis.com").header("Authorization","Bearer ya29.Il-vB2FUKSNOzVhg-wbahZNrAUZOO07QfRQ_clTDhUAiYdPDNpa0vL12L-K03lowBxIoZ4OF2OowYb-2FcWGwmBLzIA4t6I92CEJqttRUFy1rpQUekZSkW4atW6m2Za25w");
//	}
//	
	
	protected RequestSpecification getRequest() {
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://www.googleapis.com").addHeader("Authorization","Bearer ya29.Il-vBypz0Wf1Mncj3MOHxAHrgZEIlAVegaapvvGR-EJha3yZoF2sWS6YDdS_QbUaYlzSrHdr7bYaNZ8g5zpLa7D_srTdTefKSNMc-OiEx7haI5sShqqiRwBo00lB_lJ14A").build();
		return 		given(req);
	}
	

}