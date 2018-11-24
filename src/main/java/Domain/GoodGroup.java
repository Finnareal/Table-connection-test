package Domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "good_group")
public class GoodGroup implements Serializable {

    @Id
    @Column(name = "goodgroup_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "goodgroup_id_gen")
    @SequenceGenerator(name = "goodgroup_id_gen", allocationSize = 1, sequenceName = "goodgroup_id_seq")
    private long Id;

    @Column(name = "goodgroup_name", nullable = false, length = 30, unique = true)
    private String goodGroupName;

    public GoodGroup(){}

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getGoodGroupName() {
        return goodGroupName;
    }

    public void setGoodGroupName(String goodGroupName) {
        this.goodGroupName = goodGroupName;
    }

    @Override
    public String toString() {
        return "GoodGroup{" +
                "Id=" + Id +
                ", goodGroupName='" + goodGroupName + '\'' +
                '}';
    }
}
