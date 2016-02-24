package org.frontgoo.springdata.test.forkjoin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunny on 16-2-19.
 */
public class ProductListGenerator {

    public List generate(int size) {
        List ret = new ArrayList();
        for (int i = 0; i < size; i++) {
            Product product = new Product();
            product.setName("Product" + i);
            product.setPrice(10);
            ret.add(product);
        }
        return ret;
    }
}
