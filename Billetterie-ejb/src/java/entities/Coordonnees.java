
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Coordonnees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String prenom;
    private String nom;
    private String entreprise;
    private String numeroVoie;
    private String typeVoie;
    private String nomVoie;
    private String telephone;
    private String telephoneMobile;
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Ville ville;
    
    @OneToMany(mappedBy = "coordonnees")
    private Collection<Lieu> lieux;

    public Coordonnees() {        
        lieux = new ArrayList<>();
    }

    public Coordonnees(String nom, String prenom, String entreprise, String numeroVoie, String typeVoie, String nomVoie, String telephone, String telephoneMobile, Ville ville) {
        this();
        this.nom = nom;
        this.prenom = prenom;
        this.entreprise = entreprise;
        this.numeroVoie = numeroVoie;
        this.typeVoie = typeVoie;
        this.nomVoie = nomVoie;
        this.telephone = telephone;
        this.telephoneMobile = telephoneMobile;
        this.ville = ville;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getNumeroVoie() {
        return numeroVoie;
    }

    public void setNumeroVoie(String numeroVoie) {
        this.numeroVoie = numeroVoie;
    }

    public String getTypeVoie() {
        return typeVoie;
    }

    public void setTypeVoie(String typeVoie) {
        this.typeVoie = typeVoie;
    }

    public String getNomVoie() {
        return nomVoie;
    }

    public void setNomVoie(String nomVoie) {
        this.nomVoie = nomVoie;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephoneMobile() {
        return telephoneMobile;
    }

    public void setTelephoneMobile(String telephoneMobile) {
        this.telephoneMobile = telephoneMobile;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }
    
    public String getAdresse() {
        return String.format("%s %s %s, %s %s", getNumeroVoie(), getTypeVoie(), getNomVoie(), getVille().getCodePostal(), getVille().getNom());
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coordonnees)) {
            return false;
        }
        Coordonnees other = (Coordonnees) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Coordonnees[ id=" + id + " ]";
    }

    public Collection<Lieu> getLieux() {
        return lieux;
    }

    public void setLieux(Collection<Lieu> lieux) {
        this.lieux = lieux;
    }

}
