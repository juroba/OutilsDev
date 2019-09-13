
package com.rpouiller;

import java.util.Arrays;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

// Pour determiner les methodes de tests, JUnit3 recherche toutes celles
// commencant par "test" dans les classes heritant de TestCase. JUnit4,
// quant a lui, recherche les methodes avec l'annotation @Test dans
// n'importe quelle classe.

/**
 *  Operations
 */
public class Operations {

    static Logger logger = Logger.getLogger(Operations.class);

    /**
     * additionner une liste de long
     */
    public static long additionner(final long...pNombres) {
        logger.info("on journalise une addition");
        long lRetour = 0;
        for(final long lNombre : pNombres) {
            lRetour += lNombre;
        }
        return lRetour;
    }
    
    /**
     * multiplier une liste de long
     * Cette methode ne fonctionne pas correctement Les tests vont le verifier
     */    
    public static long multiplier(final long...pNombres) {
        logger.info("on journalise une multiplication");
        long lRetour = 0;
        for(final long lNombre : pNombres) {
            lRetour *= lNombre;
        }
        return lRetour;
    }
    
    /**
     * diviser successivement des long (requiert au moins 2 nombres)
     */
    public static long diviser(final long...pNombres) {
        logger.info("on journalise une division");
        if(pNombres.length < 2) {
            throw new IllegalArgumentException(
                    "Il faut au moins deux nombres en entree");
        }
        long lRetour = pNombres[0];
        for(int i=1;i<pNombres.length;i++) {
            lRetour /= pNombres[i];
        }
        return lRetour;
    }

    /**
     * soustraire successivement des doubles (requiert au moins 2 nombres)
     */    
    public static double soustraire(final double...pNombres) {
        logger.info("on journalise une soustraction");
        if(pNombres.length < 2) {
            throw new IllegalArgumentException(
                    "Il faut au moins deux nombres en entree");
        }
        double lRetour = pNombres[0];
        for(int i=1;i<pNombres.length;i++) {
            lRetour -= pNombres[i];
        }
        return lRetour;
    }

    /**
     * Cette methode verifie que les longueurs passees en parametre
     * sont celles d'un triangle rectangle
     */
    public static Boolean[] pythagore(final long[]...pLongueurs) {
        logger.info("on journalise pythagore");
        final Boolean[] lRetours = new Boolean[pLongueurs.length];

        for(int i=0;i<pLongueurs.length;i++) {
            final long[] lLongeurs = pLongueurs[i];
            if(lLongeurs.length != 3) {
                throw new IllegalArgumentException(
                    "Les blocs de longueurs doivent etre de 3 elements");
            }
            
            final long[] lCopieLongueurs = lLongeurs.clone();
            Arrays.sort(lCopieLongueurs);
            
            final long lLongueur1 = lCopieLongueurs[0] * lCopieLongueurs[0];
            final long lLongueur2 = lCopieLongueurs[1] * lCopieLongueurs[1];
            final long lLongueur3 = lCopieLongueurs[2] * lCopieLongueurs[2];
            
            if(lLongueur1 + lLongueur2 == lLongueur3) {
                lRetours[i] = true;
            }
            else {
                lRetours[i] = false;
            }
        }

        return lRetours;
    }


    public static void main(String[] args) {

        BasicConfigurator.configure();
            
        long a = 1 ;
        long b = 2 ;
        long c = Operations.additionner(a, b);
        System.out.println("Le résultat de l addition entre a="+ a+" et b="+ b+" est c="+c);

        long d = Operations.multiplier(a, b);
        System.out.println("Le résultat de la multiplication entre a="+ a+" et b="+ b+" est d="+d);


    }
}



