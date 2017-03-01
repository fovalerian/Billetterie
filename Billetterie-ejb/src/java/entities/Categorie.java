package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Categorie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nom;
//--------------------------------------------------
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Collection<Zone> zones;

    @OneToMany(mappedBy = "categorie")
    private Collection<Tarif> tarifs;

    @ManyToMany(mappedBy = "categories")
    private Collection<Seance> Seances;

    @OneToOne
    private Promotion promotion;

    public Categorie() {
        tarifs = new ArrayList<>();
        zones = new ArrayList<>();
    }

    public Categorie(String nom) {
        this();
        this.nom = nom;
    }

    public Categorie(String nom, Collection<Tarif> tarifs) {
        this();
        this.nom = nom;
        this.tarifs = tarifs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "entities.Categorie[ id=" + id + " ]";
    }

    public Collection<Zone> getZones() {
        return zones;
    }

    public void setZones(Collection<Zone> zones) {
        this.zones = zones;
    }

    public Collection<Tarif> getTarifs() {
        return tarifs;
    }

    public void setTarifs(Collection<Tarif> tarifs) {
        this.tarifs = tarifs;
    }

    public Collection<Seance> getSeances() {
        return Seances;
    }

    public void setSeances(Collection<Seance> Seances) {
        this.Seances = Seances;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

}
