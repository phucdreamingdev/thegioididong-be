package vn.com.groupfive.tgdd.payload.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartProductDTO {
	private int quantity;
	
	private ItemCartDTO product;
	
	private String totalPrice;
	
	public CartProductDTO() {
	}

	public CartProductDTO(int quantity, ItemCartDTO product) {
		this.quantity = quantity;
		this.product = product;
	}
	
}
