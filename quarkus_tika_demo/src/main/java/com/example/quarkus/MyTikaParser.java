package com.example.quarkus;

import java.io.InputStream;
import java.time.Duration;
import java.time.Instant;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.tika.TikaParser;
import org.jboss.logging.Logger;

/**
 * @author jdeshmukh 
 * Date : 16-Feb-2020
 * 
 */
@Path("/parse") 
public class MyTikaParser {

	private static final Logger log = Logger
			.getLogger(MyTikaParser.class);

	@Inject
	TikaParser parser;

	@POST
	@Path("/text")
	@Consumes({ "application/pdf" })
	@Produces(MediaType.TEXT_PLAIN)
	public String extractText(InputStream stream) {
		Instant start = Instant.now();

		String text = parser.getText(stream);

		Instant finish = Instant.now();

		log.info(Duration.between(start, finish).toMillis()
				+ " mls have passed");

		return text;
	}
}
