package Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table (name = "good_color")
public class GoodColor implements Serializable {

    @Id
    @Column(name = "goodcolor_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "goodcolor_id_gen")
    @SequenceGenerator(name = "goodcolor_id_gen", allocationSize = 1, sequenceName = "goodcolor_id_seq")
    private long Id;

    @Column(name = "goodcolor_name", nullable = false, length = 30, unique = true)
    private String goodColorName;

//    @OneToMany(mappedBy = "goodColor", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
//    @JoinColumn(name = "goodcolor_id")
//    private Set<Product> products;

    public GoodColor(){}

    public long getGoodColorId() {
        return Id;
    }

    public void setGoodColorId(long goodColorId) {
        this.Id = goodColorId;
    }

    public String getGoodColorName() {
        return goodColorName;
    }

    public void setGoodColorName(String goodColorName) {
        this.goodColorName = goodColorName;
    }

//    public Set<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }

    @Override
    public String toString() {
        return "GoodColor{" +
                "Id=" + Id +
                ", goodColorName='" + goodColorName + '\'' +
                '}';
    }
}
