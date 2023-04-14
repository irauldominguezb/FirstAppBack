package mx.edu.utez.firstapp.controllers.product.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.firstapp.models.product.Product;
import mx.edu.utez.firstapp.models.product.ProductImages;
import mx.edu.utez.firstapp.models.subcategory.Subcategory;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private int cuantity;
    private double price;
    private String brand;
    private String status;
    private Subcategory subCategory;
    private List<ProductImages> images;
    public Product getProduct(){
        return new Product(
                getId(),
                getName(),
                getDescription(),
                getCuantity(),
                getPrice(),
                getBrand(),
                getStatus(),
                getSubCategory(),
                getImages()
        );
    }
}
