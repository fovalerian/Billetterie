package service.testdata;

import entities.Lieu;
import entities.Seance;
import entities.Spectacle;
import enums.StatutSeance;
import enums.StatutSpectacle;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cdi501
 */
@Stateless
public class TestDataInna implements TestDataInnaLocal {

    @PersistenceContext(unitName = "Billetterie-ejbPU")
    private EntityManager em;

    @Override
    public void create() {
        try {
            //-----------------------[ DATES ]----------------------------

            SimpleDateFormat sdf = new SimpleDateFormat();
            sdf.setLenient(false);

            Date d20 = sdf.parse("13/03/2017 18:00:00");
            Date d21 = sdf.parse("14/03/2017 18:00:00");
            Date d22 = sdf.parse("15/03/2017 18:00:00");
            Date d23 = sdf.parse("25/03/2017 18:00:00");
            Date d24 = sdf.parse("16/03/2017 19:00:00");
            Date d25 = sdf.parse("17/03/2017 19:00:00");
            Date d26 = sdf.parse("18/03/2017 19:00:00");
            Date d27 = sdf.parse("19/03/2017 19:00:00");
            Date d28 = sdf.parse("20/03/2017 19:00:00");
            Date d29 = sdf.parse("01/04/2017 21:00:00");
            Date d30 = sdf.parse("025/04/2017 18:00:00");
            Date d31 = sdf.parse("025/04/2017 21:00:00");

//-----------------------[ SPECTACLES ]---------------------------------------
            Spectacle spctMozart = new Spectacle("REQUIEM DE MOZART", " WOLFGANG AMADEUS MOZART", StatutSpectacle.ACTIF);
            Spectacle spctBach = new Spectacle("PASSION SELON SAINT JEAN FRANCOIS DEJARDIN", "JOHANN SEBASTIAN BACH", StatutSpectacle.ACTIF);
            Spectacle spctFoot1 = new Spectacle("FINALE COUPE DE LA LIGUE DES JUSTICIERS", " COUPE DE LA LIGUE", StatutSpectacle.ACTIF);
            Spectacle spctFoot2 = new Spectacle("OLYMPIQUE DE MARSEILLE / PSG", " PARIS SAINT-GERMAIN, OLYMPIQUE DE MARSEILLE", StatutSpectacle.ACTIF);
            Spectacle spctCirque1 = new Spectacle("GRAND CIRQUE ST PETERSBOURG", "CIRQUE TRADITIONNEL", StatutSpectacle.ACTIF);
            Spectacle spctCirque2 = new Spectacle("GRAND CIRQUE MEDRANO", "CIRQUE TRADITIONNEL", StatutSpectacle.ACTIF);

//-----------------------[ LIEU ]------------------------------------------
            Lieu madelaine = new Lieu("Eglise de la Madeleine", null, "eglise catholique");
            Lieu stadeLyon = new Lieu("PARC OLYMPIQUE LYONNAIS", null, null);
            Lieu stadeMarceille = new Lieu("ORANGE VELODROME - MARSEILLE", null, null);
            Lieu parc1 = new Lieu("PARC DES EXPOS- BVD KENNEDY", null, "BESANÇON - FRANCE");
            Lieu parc2 = new Lieu("HIPPODROME DE SENE", null, "VANNES - FRANCE");

//-----------------------[ SEANCES ]------------------------------------------
            Seance s06 = new Seance(d20, StatutSeance.ACTIF, spctMozart);
            s06.setLieu(madelaine);
            Seance s07 = new Seance(d21, StatutSeance.ACTIF, spctMozart);
            s07.setLieu(madelaine);
            Seance s08 = new Seance(d22, StatutSeance.ACTIF, spctMozart);
            s08.setLieu(madelaine);
            Seance s09 = new Seance(d23, StatutSeance.ACTIF, spctMozart);
            s09.setLieu(madelaine);

            Seance s10 = new Seance(d24, StatutSeance.ACTIF, spctBach);
            s10.setLieu(madelaine);
            Seance s11 = new Seance(d25, StatutSeance.ACTIF, spctBach);
            s11.setLieu(madelaine);
            Seance s12 = new Seance(d26, StatutSeance.ACTIF, spctBach);
            s12.setLieu(madelaine);
            Seance s13 = new Seance(d27, StatutSeance.ACTIF, spctBach);
            s13.setLieu(madelaine);
            Seance s14 = new Seance(d28, StatutSeance.ANNULE, spctBach);
            s14.setLieu(madelaine);

            Seance s15 = new Seance(d29, StatutSeance.ACTIF, spctFoot1);
            s15.setLieu(stadeLyon);

            Seance s16 = new Seance(d26, StatutSeance.ACTIF, spctFoot2);
            s16.setLieu(stadeMarceille);

            Seance s17 = new Seance(d30, StatutSeance.ACTIF, spctCirque1);
            s17.setLieu(parc1);

            Seance s18 = new Seance(d31, StatutSeance.ACTIF, spctCirque1);
            s18.setLieu(parc1);

            Seance s19 = new Seance(d30, StatutSeance.ACTIF, spctCirque2);
            s19.setLieu(parc1);
            Seance s20 = new Seance(d20, StatutSeance.ACTIF, spctCirque2);
            s20.setLieu(parc1);

            Seance s21 = new Seance(d21, StatutSeance.ACTIF, spctCirque2);
            s21.setLieu(parc1);

            Seance s22 = new Seance(d22, StatutSeance.ACTIF, spctCirque2);
            s22.setLieu(parc1);

            Seance s23 = new Seance(d23, StatutSeance.ACTIF, spctCirque2);
            s23.setLieu(parc1);

            em.persist(s06);
            em.persist(s07);
            em.persist(s08);
            em.persist(s09);
            em.persist(s10);
            em.persist(s11);
            em.persist(s12);
            em.persist(s13);
            em.persist(s14);
            em.persist(s15);
            em.persist(s16);
            em.persist(s17);
            em.persist(s18);
            em.persist(s19);
            em.persist(s20);
            em.persist(s21);
            em.persist(s22);
            em.persist(s23);

        } catch (ParseException ex) {
            Logger.getLogger(TestDataInna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}