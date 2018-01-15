package com.devbadger.gatewayapp.contract

import com.devbadger.gatewayapp.contract.base.JokesBase
import com.jayway.jsonpath.DocumentContext
import com.jayway.jsonpath.JsonPath

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.*
import static com.toomuchcoding.jsonassert.JsonAssertion.assertThatJson
import static org.springframework.cloud.contract.verifier.assertion.SpringCloudContractAssertions.assertThat

class JokesSpec extends JokesBase {

	def validate_happyPathCategoriesResponse() throws Exception {
		given:
			def request = given()

		when:
			def response = given().spec(request)
					.get("/api/v1/categories")

		then:
			response.statusCode == 200
			response.header('Content-Type') ==~ java.util.regex.Pattern.compile('application/json;charset=UTF-8.*')
		and:
			DocumentContext parsedJson = JsonPath.parse(response.body.asString())
			assertThatJson(parsedJson).array("['value']").arrayField().isEqualTo("nerdy").value()
			assertThatJson(parsedJson).field("['type']").isEqualTo("success")
			assertThatJson(parsedJson).array("['value']").arrayField().isEqualTo("explicit").value()
	}

	def validate_happyPathJokeCountResponse() throws Exception {
		given:
			def request = given()

		when:
			def response = given().spec(request)
					.get("/api/v1/jokes/count")

		then:
			response.statusCode == 200
			response.header('Content-Type') ==~ java.util.regex.Pattern.compile('application/json;charset=UTF-8.*')
		and:
			DocumentContext parsedJson = JsonPath.parse(response.body.asString())
			assertThatJson(parsedJson).field("['value']").matches("-?\\d*(\\.\\d+)?")
			assertThatJson(parsedJson).field("['type']").isEqualTo("success")
	}

	def validate_shouldGetCategoryListResponse() throws Exception {
		given:
			def request = given()

		when:
			def response = given().spec(request)
					.get("/api/v1/categories")

		then:
			response.statusCode == 200
			response.header('Content-Type') ==~ java.util.regex.Pattern.compile('application/json;charset=UTF-8.*')
		and:
			DocumentContext parsedJson = JsonPath.parse(response.body.asString())
			assertThatJson(parsedJson).array("['value']").arrayField().isEqualTo("nerdy").value()
			assertThatJson(parsedJson).field("['type']").isEqualTo("success")
			assertThatJson(parsedJson).array("['value']").arrayField().isEqualTo("explicit").value()
	}

}
