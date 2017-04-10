package fr.pdubreuil.domain;



import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;




@Entity
@Table(name="place")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)

public class Place extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max= 100)
    @Column(name = "name_dpt", length = 100)
    private String nameDpt;


    @Column(name="num_dpt", length = 2)
    private Integer numDpt;

    @Size(max=5)
    @Column(name="zipcode", length = 5)
    private String zipcode;

    @Size(max=50)
    @Column(name="city", length = 50)
    private String city;

    @Size(max=100)
    @Column(name="address", length = 100)
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    private Restaurant restaurant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameDpt() {
        return nameDpt;
    }

    public void setNameDpt(String nameDpt) {
        this.nameDpt = nameDpt;
    }

    public Integer getNumDpt() {
        return numDpt;
    }

    public void setNumDpt(Integer numDpt) {
        this.numDpt = numDpt;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Place (String nameDpt, Integer numDpt, String zipcode, String city, String address){
        this.nameDpt = nameDpt;
        this.numDpt = numDpt;
        this.zipcode = zipcode;
        this.city = city;
        this.address = address;
    }
    public String toString (){
        return "Place{" +
                "id=" + id +
                "nameDpt=" + nameDpt +  '\'' +
                "numDpt=" + numDpt +  '\'' +
                "zipcode=" + zipcode +  '\'' +
                "city=" + city +  '\'' +
                "address=" + address +
                "}";
    }
}
