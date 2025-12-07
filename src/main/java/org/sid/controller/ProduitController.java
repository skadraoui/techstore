package org.sid.controller;

import org.sid.domain.repository.ProductRepository;
import org.sid.entity.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProduitController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/index")// url
    public String retrieveProducts(Model model,
                                   @RequestParam(name = "page", defaultValue = "0")int page,
                                   @RequestParam(name ="size", defaultValue = "5")int s){

     Page<Produit> pageProduits = productRepository.findAll(PageRequest.of(page,s));

        model.addAttribute("listProduits", pageProduits.getContent());
        int [] pages = new int [pageProduits.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("size", s);
        model.addAttribute("pageCourante", page);

        return "produits";// le nom de la vue à utiliser
    }
    @RequestMapping(value = "/chercherProduits")// url
    public String findProductsByDesignation(Model model,
                                   @RequestParam(name = "page", defaultValue = "0")int page,
                                   @RequestParam(name ="size", defaultValue = "5")int s,
                                   @RequestParam(name = "motCle",defaultValue = "")String motCle){

        Page<Produit> pageProduits = productRepository.searchProduct("%"+motCle+"%", PageRequest.of(page,s));

        model.addAttribute("listProduits", pageProduits.getContent());
        int [] pages = new int [pageProduits.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("size", s);
        model.addAttribute("pageCourante", page);
        model.addAttribute("motCle", motCle);

        return "chercherProduits";// le nom de la vue à utiliser
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String deleteProduit(Long id, String motCle, int page, int size){
        productRepository.deleteById(id);
        return "redirect:/chercherProduits?page="+page+"&size="+size+"&motCle="+motCle;
    }
    @RequestMapping(value = "/formProduit",method = RequestMethod.GET)
    public String formProduit(){
        return "formProduit";
    }


}
