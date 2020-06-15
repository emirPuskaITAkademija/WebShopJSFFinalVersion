package business;

import business.model.Product;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Grupa2
 */
@Local
public interface ProductSessionBeanLocal {
    public List<Product> getAllProducts();
}
