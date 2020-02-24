/**
 * 
 */
package com.example.quarkus.servicve;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.quarkus.entity.Order;

/**
 * @author jaydeep.deshmukh 
 * Date : 16-Feb-2020
 *
 */

@Produces(MediaType.APPLICATION_JSON)
@Path("/order")
public class OrderService {

	@GET
	public java.util.List<Order> getAllorders() {
		return Order.listAll();
	}

	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void saveOrder(Order order) {
		order.persist();
	}

}
