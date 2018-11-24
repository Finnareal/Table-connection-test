package Domain;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "product")
public class Product implements Serializable {

    @Id
    @Column(name = "good_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "good_id_gen")
    @SequenceGenerator(name = "good_id_gen", allocationSize = 1, sequenceName = "good_id_seq")
    private long Id;

    @Column(name = "good_art", nullable = false)
    private int goodArt;

    @Column(name = "good_name", nullable = false, length = 100)
    private String goodName;

    @ManyToOne(targetEntity = GoodSize.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    private GoodSize goodSize;

    @ManyToOne(targetEntity = GoodColor.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    private GoodColor goodColor;

    @ManyToOne(targetEntity = GoodGroup.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    private GoodGroup goodGroup;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int stock;

    @Column(nullable = false)
    @ColumnDefault("0.0")
    private double price;

    public Product(){}

    public Product(int goodArt, String goodName, GoodColor goodColor, GoodSize goodSize, GoodGroup goodGroup){
       this.goodArt = goodArt;
       this.goodName = goodName;
       this.goodColor = goodColor;
       this.goodSize = goodSize;
       this.goodGroup = goodGroup;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public int getGoodArt() {
        return goodArt;
    }

    public void setGoodArt(int goodArt) {
        this.goodArt = goodArt;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public GoodSize getGoodSize() {
        return goodSize;
    }

    public void setGoodSize(GoodSize goodSize) {
        this.goodSize = goodSize;
    }

    public GoodColor getGoodColor() {
        return goodColor;
    }

    public void setGoodColor(GoodColor goodColor) {
        this.goodColor = goodColor;
    }

    public GoodGroup getGoodGroup() {
        return goodGroup;
    }

    public void setGoodGroup(GoodGroup goodGroup) {
        this.goodGroup = goodGroup;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + Id +
                ", goodArt=" + goodArt +
                ", goodName='" + goodName + '\'' +
                ", goodSize=" + goodSize +
                ", goodColor=" + goodColor +
                ", goodGroup=" + goodGroup +
                ", stock=" + stock +
                ", price=" + price +
                '}' + "\n";
    }
}
