package com.example.quarkus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

/**
 * @author jaydeep.deshmukh 
 * Date : 16-Feb-2020
 *
 */
@QuarkusTest
public class OrderServiceTest {

	@Test
	public void testGetAllOrders() {
		given().when().get("/order").then().statusCode(200).body(containsString("TV"), containsString("Cricket Bat"),
				containsString("Iphone-X"));

	}

}
