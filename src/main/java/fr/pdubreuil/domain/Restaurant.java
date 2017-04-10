package fr.pdubreuil.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name = "restaurant")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Restaurant extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_place", length = 11)
    private Long idPlace;

    @Size(max = 50)
    @Column(name = "name_restaurant", length = 50)
    private String nameRestaurant;

    @Size(max = 50)
    @Column(name = "society", length = 50)
    private String society;

    @OneToOne(mappedBy = "restaurant",cascade = CascadeType.ALL)
    private Place place;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(Long idPlace) {
        this.idPlace = idPlace;
    }

    public String getNameRestaurant() {
        return nameRestaurant;
    }

    public void setNameRestaurant(String nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
    }

    public String getSociety() {
        return society;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Restaurant(String nameRestaurant, String society){
        this.nameRestaurant = nameRestaurant;
        this.society = society;
    }

    public String toString(){
        return "Restaurant{" +
                "id=" + id + '\'' +
                "idPlace=" + idPlace + '\'' +
                "nameRestaurant=" + nameRestaurant + '\'' +
                "society" + society +
                "}";

    }

}
