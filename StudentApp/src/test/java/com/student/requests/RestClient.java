package com.student.requests;

import com.student.specs.SpecificationFactory;
import com.student.tests.TestBase;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.Map;


public class RestClient extends TestBase{
	
	/***
	 * 
	 * @param requestPath
	 * @return
	 */
	public Response doGetRequest(String requestPath) {
		
		return 	given()
		   		   .when()
		   		   .get(requestPath);
	}
	
	/**
	 * 
	 * @param uri
	 * @param body
	 * @return
	 */
	public Response doPostRequest(String uri, Object body) {
		
		return given()
				.contentType(ContentType.JSON)
				.spec(SpecificationFactory.logPayloadResponseInfo())
				.when()
				.body(body)
				.post(uri);
	}
	
	/**
	 * 
	 * 
	 * @param res
	 * @param params
	 * @return
	 */
	public Response doGetRequestWithQueryParam(String res, 
											  Map<String, String> params) {

		Response response = given()
								.queryParams(params)
							.when()
							.get(res);

		return response;

	}
	
	/**
	 * 
	 * @param res
	 * @param headers
	 * @return
	 */
	public Response doGetRequestWithHeader(String res,
										  Map<String, String> headers) {

		Response response = given()
								.headers(headers)
							.when()
							.get(res);

		return response;

	}
	
	
	/**
	 * 
	 * @return
	 */
	public Response doPutRequest(String res , Object body) {

		Response response = given()
						   .when()
						   .body(body)
						   		.put(res);

		return response;

	}
	
	/**
	 * 
	 * @return
	 */
	public Response doPatchRequest(String res , Object body) {

		Response response = given()
						   .when()
						   .body(body)
						   		.patch(res);

		return response;

	}
	
	/**
	 * 
	 * @return
	 */
	public Response doDeleteRequest(String res) {

		Response response = given()
						   .when()
						   		.delete(res);

		return response;

	}

}
