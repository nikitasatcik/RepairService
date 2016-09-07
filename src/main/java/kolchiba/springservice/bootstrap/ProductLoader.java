package kolchiba.springservice.bootstrap;

import kolchiba.springservice.domain.Product;
import kolchiba.springservice.domain.User;
import kolchiba.springservice.repositories.ProductRepository;
import kolchiba.springservice.repositories.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;
    private UserRepository userRepository;

    private Logger log = Logger.getLogger(ProductLoader.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Product product = new Product();
        product.setDescription("Description");
        product.setPrice(new BigDecimal("18.95"));
        product.setImageUrl("https://google.com");
        product.setProductId("1345767644");
        productRepository.save(product);

        log.info("Saved Shirt - id: " + product.getId());

        User user = new User();
        user.setCompany("рога и копыта");
        user.setEmail("lol@gmail");
        user.setName("John");
        user.setPhone("+38(096) 45-56-34");
        userRepository.save(user);
    }
}
