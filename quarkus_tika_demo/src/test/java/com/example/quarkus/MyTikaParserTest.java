package com.example.quarkus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import io.quarkus.test.junit.QuarkusTest;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

/**
 * @author jdeshmukh
 * Date : 16-Feb-2020
 *
 */
public class MyTikaParserTest {

	@QuarkusTest
	public class TikaParserResourceTest {

	    @Test
	    public void testHelloQuarkusPdfFormat() throws Exception {
	    	checkText("application/pdf", "pdf");
	    }

	    private void checkText(String contentType, String extension) throws Exception {
	        given()
	          .when().header("Content-Type", contentType)
	                 .body(readQuarkusFile("quarkus." + extension))
	                 .post("/parse/text")
	          .then()
	             .statusCode(200)
	             .body(is("Hello Quarkus"));
	    }
	    
	    private byte[] readQuarkusFile(String fileName) throws Exception {
	        try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileName)) {
	        	ByteArrayOutputStream os = new ByteArrayOutputStream();
		        byte[] buffer = new byte[4096];
		        int len;
		        while ((len = is.read(buffer)) != -1) {
		            os.write(buffer, 0, len);
		        }
		        return os.toByteArray();
	        }
	    }
}
}
