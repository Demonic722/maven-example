package com.syntechx.product.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.syntechx.product.dto.Product;

import org.junit.Test;

public class ProductDAOImplTest {

	@Test
	public void createShouldCreateAProduct() {

		ProductDAO dao = new ProductDAOImpl();
		Product product = new Product();
		product.setId(1);
		product.setName("IPhone");
		product.setDescription("Its Awesome!!");
		product.setPrice(800);
		dao.create(product);
		Product result = dao.read(1);

		assertNotNull(result);
		assertEquals("IPhone", result.getName());

	}

}
