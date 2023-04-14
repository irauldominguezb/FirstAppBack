package mx.edu.utez.firstapp.models.subcategory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.firstapp.models.category.Category;
import mx.edu.utez.firstapp.models.product.Product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subcategories")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 150)
    private String name;
    @Column(nullable = false, columnDefinition = "TINYINT DEFAULT 1")
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @OneToMany(mappedBy = "subCategory")
    @JsonIgnore
    private List<Product> products;
}
