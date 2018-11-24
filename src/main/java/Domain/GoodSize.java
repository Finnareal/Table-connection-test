package Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "good_size")
public class GoodSize implements Serializable {

    @Id
    @Column(name = "goodsize_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "goodsize_id_gen")
    @SequenceGenerator(name = "goodsize_id_gen", allocationSize = 1, sequenceName = "goodsize_id_seq")
    private long Id;

    @Column(name = "goodsize_name", nullable = false, length = 15, unique = true)
    private String goodSizeName;

    @OneToMany (targetEntity = Product.class, mappedBy = "goodSize", cascade = CascadeType.ALL)
    private Set <Product> products = new HashSet<>();

    public GoodSize(){}

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getGoodSizeName() {
        return goodSizeName;
    }

    public void setGoodSizeName(String goodSizeName) {
        this.goodSizeName = goodSizeName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "GoodSize{" +
                "Id=" + Id +
                ", goodSizeName='" + goodSizeName + '\'' +
                '}';
    }
}
