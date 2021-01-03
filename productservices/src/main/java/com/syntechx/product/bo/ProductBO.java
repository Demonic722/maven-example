package com.syntechx.product.bo;

import com.syntechx.product.dto.Product;

public interface ProductBO {
	
	public void create(Product product);
	public Product findProduct(int id);
}
