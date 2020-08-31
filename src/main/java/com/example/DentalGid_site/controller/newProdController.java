package com.example.DentalGid_site.controller;

import com.example.DentalGid_site.domain.Dop_category;
import com.example.DentalGid_site.domain.Manufacturer;
import com.example.DentalGid_site.domain.Product;
import com.example.DentalGid_site.repos.DopCategoryRepo;
import com.example.DentalGid_site.repos.ManufRepo;
import com.example.DentalGid_site.repos.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class newProdController {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ManufRepo manufRepo;
    @Autowired
    private DopCategoryRepo dopCategoryRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/newProd")
    public String newProd( Model model){
        model.addAttribute("manufacturers", manufRepo.findAll());
        model.addAttribute("dop_category", dopCategoryRepo.findAll());

        return "newProd";
    }



    @PostMapping("/newProd")
    public String addProd(@RequestParam("file") MultipartFile file, Product product, String shtrih, String kode, String name, String discript, String discription, Float price, String imgname, Manufacturer manufacturer, Dop_category dop_category, Model model ) throws IOException {

        File uploadDir = new File(uploadPath);
        String resultFN = kode+".jpg";
        file.transferTo(new File(uploadPath+"/"+resultFN));
        
            product.setShtrih(shtrih);
            product.setKode(kode);
            product.setDiscript(discript);
            product.setDiscription(discription);
            product.setName(name);
            product.setPrice(price);
            product.setManufacturer(manufacturer);
          //  product.setDop_categoriesSet(dop_category.getCategory().getDop_categories());
            //product.setDop_categoriesSet((Set<Dop_category>) dop_category);
           // product.setDop_categoriesSet((Set<Dop_category>) dop_category);
            product.setImgname(file.getOriginalFilename());
        //    Set<Product> pr = Collections.singleton(product);
         //   dop_category.setProductsSet(pr);
        //    dopCategoryRepo.save(dop_category);



            productRepo.save(product);
        Iterable<Product> products = productRepo.findAll();
        model.addAttribute("products", products);

        return "productList";
    }
}

