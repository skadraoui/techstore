package org.sid.controller;

import lombok.AllArgsConstructor;
import org.sid.domain.repository.ProductRepository;
import org.sid.entity.Produit;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ProductsController {

    private  final ProductRepository productRepository;


    @GetMapping("/products")
    public List<Produit> retrieveAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produit retrieveAllProducts(@PathVariable(name = "id") Long productId){
        Optional<Produit> produitOptional = productRepository.findById(productId);
        return produitOptional.orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable(name = "id") Long productId){
        productRepository.deleteById(productId);
    }

    public Map<String, String> firstChar(String[] strings) {

        Map<String, String> res= new HashMap<>();
        Arrays.stream(strings)
                .forEach(str-> {
                    String firstChat= str.substring(0,1);
                    if(res.containsKey(firstChat)){
                        res.put(firstChat, res.get(firstChat).concat(str));
                    }else {
                        res.put(firstChat, str);
                    }
                });
        return res;
    }

    public Map<String, Boolean> wordMultiple(String[] strings) {
    final Map<String, Boolean> res = new HashMap<>();
    Arrays.stream(strings).forEach(str -> {
        if(res.containsKey(str))
            res.put(str, true);
        else
            res.put(str, false);
    });
    return  res;
    }
}
