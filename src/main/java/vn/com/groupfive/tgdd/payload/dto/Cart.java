package vn.com.groupfive.tgdd.payload.dto;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    
    private final List<CartProductDTO> cartProducts = new ArrayList<>();
    

    public Cart() {
    	
    }


    private CartProductDTO findCartProductById(Long id) {
        for (CartProductDTO cartProd : cartProducts) {
            if (cartProd.getProduct().getId() == id) {
                return cartProd;
            }
        }
        return null;
    }

    public void addProduct(ItemCartDTO productInfo, int quantity) {
    	CartProductDTO cartProd = findCartProductById(productInfo.getId());
    	float price = Float.parseFloat(productInfo.getPrice() + "");
        if (cartProd == null) {
            cartProd = new CartProductDTO();
            cartProd.setQuantity(0);
            cartProd.setProduct(productInfo);
            cartProd.setTotalPrice(price + "");
            cartProducts.add(cartProd);
        }
        int newQuantity = cartProd.getQuantity() + quantity;
        if (newQuantity <= 0) {
            cartProducts.remove(cartProd);
        } else {
            cartProd.setQuantity(newQuantity);
            float totalPrice = newQuantity * price;
            cartProd.setTotalPrice(totalPrice + "");
        }
    }

    public boolean editQuantity(Long id, int quantity) {
        CartProductDTO cartProd = findCartProductById(id);
        if (cartProd != null) {
        	float price = Float.parseFloat(cartProd.getProduct().getPrice() + "");
            if (quantity <= 0) {
                cartProducts.remove(cartProd);
            } else {
                cartProd.setQuantity(quantity);
                float totalPrice = quantity * price;
                cartProd.setTotalPrice(totalPrice + "");
            }
            return true;
        }
        return false;
    }
    
    public boolean changeVersionColorOfProduct(Long versionColorId, ItemCartDTO nVersionColor) {
    	CartProductDTO cartProd = findCartProductById(versionColorId);
    	if(cartProd != null) {
    		cartProd.setProduct(nVersionColor);
    		return true;
    	}
    	return false;
    }

    public boolean removeProduct(Long id) {
        CartProductDTO cartProd = findCartProductById(id);
        if (cartProd != null) {
           cartProducts.remove(cartProd);
           return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return cartProducts.isEmpty();
    }

	public List<CartProductDTO> getCartProducts() {
		return cartProducts;
	}

    
    

}
