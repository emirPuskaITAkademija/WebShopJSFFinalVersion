package beans;

import beans.model.ShoppingCartItem;
import business.ProductSessionBeanLocal;
import business.model.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "productManagedBean", eager = true)
@SessionScoped
public class ProductManagedBean implements Serializable {

    @EJB
    private ProductSessionBeanLocal productSessionBeanLocal;

    private int quantity;
    private List<ShoppingCartItem> shoppingCartItems = new ArrayList<>();

    public ProductManagedBean() {
    }

    public void addProductToCart(Product product){
        for(ShoppingCartItem shoppingCartItem: shoppingCartItems){
            if(product.getId()==shoppingCartItem.getProduct().getId()){
                shoppingCartItem.setQuantity(shoppingCartItem.getQuantity()+quantity);
                return;
            }
        }
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem(product, quantity);
        shoppingCartItems.add(shoppingCartItem);
    }
    
    public List<ShoppingCartItem> getShoppingCartItems() {
        return shoppingCartItems;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Product> getAllProducts() {
        return productSessionBeanLocal.getAllProducts();
    }
}
