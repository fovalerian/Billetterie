package entities;

import enums.StatutSpectacle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery(name = "entities.Spectacle.selectById", query = "select s from Spectacle s where s.id = :paramId"),
    @NamedQuery(name = "entities.Spectacle.selectSeancesBySpectacle", query = "select s from Seance s where s.spectacle = :paramSpectacle ORDER BY s.date"),
    @NamedQuery(name = "entities.Spectacle.selectGroupeBySpectacle", query = "select g from Groupe g where g.spectacle =:paramSpectacle"),
    @NamedQuery(name = "entities.Spectacle.selectCategorie", query = "select c from Categorie c where c.Seances=:paramSeance"),
    @NamedQuery(name = "entities.Spectacle.select", query = "SELECT s FROM Spectacle s WHERE s.statut = :paramStatut ORDER BY s.titre"),
    @NamedQuery(name = "entities.Spectacle.count", query = "SELECT COUNT(s) FROM Spectacle s WHERE s.statut = :paramStatut"),
    @NamedQuery(name = "entities.Spectacle.countAll", query = "SELECT COUNT(s) FROM Spectacle s"),
    @NamedQuery(name = "entities.Spectacle.selectBySearch", query = "SELECT s FROM Spectacle s LEFT JOIN s.evenement e WHERE s.statut = :paramStatut AND (s.titre LIKE :paramSearch OR s.description LIKE :paramSearch OR e.nom LIKE :paramSearch) ORDER BY s.titre"),
    @NamedQuery(name = "entities.Spectacle.countBySearch", query = "SELECT COUNT(s) FROM Spectacle s LEFT JOIN s.evenement e WHERE s.statut = :paramStatut AND (s.titre LIKE :paramSearch OR s.description LIKE :paramSearch OR e.nom LIKE :paramSearch)"),
    @NamedQuery(name = "entities.Spectacle.selectBySubTheme", query = "SELECT s FROM Spectacle s where s.sousTheme.nom = :paramSubThemeNom and s.statut = :paramStatut"),
    @NamedQuery(name = "entities.Spectacle.countBySubTheme", query = "select Count(s) FROM Spectacle s WHERE s.statut = :paramStatut AND s.sousTheme.nom = :paramSubThemeNom"),
    @NamedQuery(name = "entities.Spectacle.selectByTheme", query = "SELECT s FROM Spectacle s where s.sousTheme.theme.nom = :paramThemeNom and s.statut = :paramStatut"),
    @NamedQuery(name = "entities.Spectacle.countByTheme", query = "select Count(s) FROM Spectacle s WHERE s.statut = :paramStatut AND s.sousTheme.theme.nom = :paramThemeNom")
})
public class Spectacle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;
    private StatutSpectacle statut;

//--------------------------------------------------------------------------------------
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Image image;

    @OneToMany(mappedBy = "spectacle")
    private Collection<Seance> seances;

    @OneToMany(mappedBy = "spectacle")
    private Collection<Groupe> groupes;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private SousTheme sousTheme;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Evenement evenement;

//---------------------------------------------------------------------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatutSpectacle getStatut() {
        return statut;
    }

    public void setStatut(StatutSpectacle statut) {
        this.statut = statut;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Spectacle() {
        groupes = new ArrayList<>();
        seances = new ArrayList<>();
    }

    public Spectacle(String titre, String description, StatutSpectacle statut, Collection<Seance> seances) {
        this();
        this.titre = titre;
        this.description = description;
        this.statut = statut;
        this.seances = seances;
    }

    public Spectacle(String titre, String description, StatutSpectacle statut, SousTheme sousTheme, Evenement evenement) {
        this.titre = titre;
        this.description = description;
        this.statut = statut;
        this.sousTheme = sousTheme;
        this.evenement = evenement;
    }
    
    

    public Spectacle(String titre, String description, StatutSpectacle statut) {
        this();
        this.titre = titre;
        this.description = description;
        this.statut = statut;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Collection<Seance> getSeances() {
        return seances;
    }

    public void setSeances(Collection<Seance> seances) {
        this.seances = seances;
    }

    public Collection<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(Collection<Groupe> groupes) {
        this.groupes = groupes;
    }

    public SousTheme getSousTheme() {
        return sousTheme;
    }

    public void setSousTheme(SousTheme sousTheme) {
        this.sousTheme = sousTheme;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    @Override
    public String toString() {
        return "entities.Spectacle[ id=" + id + " ]" + "titre : " + titre;
    }

}
