package services;

import entities.Categorie;
import entities.Gestionnaire;
import entities.Produit;
import entities.Vente;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Service
public class Facade {
    @PersistenceContext
    EntityManager em;

    /**
     * Renvoie le produit dont l'id est fourni. et null si non trouvé.
     * @param idProduit
     * @return
     */
    public Produit findById(int idProduit) {
        Query q = em.createQuery("Select p From Produit p where p.idProduit = :idProduit");
        q.setParameter("idProduit", idProduit);
        return (Produit) q.getSingleResult();
    }

    /**
     * Renvoie le nom du produit correspondant à la plus grosse ligne de vente
     * @return
     */
    public String nomProduitPlusGrosseLigne() {
        Query q = em.createQuery("SELECT p.nomProduit FROM LigneVente lv JOIN Produit p ON lv.idLV = p.idProduit ORDER BY lv.quantite DESC");
        return (String) q.setMaxResults(1).getSingleResult();
    }

    /**
     * Renvoie le produit dont les ventes sont les plus grandes en nombre d'unité (en quantité)
     * VOUS NE POURREZ PAS LE FAIRE DIRECTEMENT EN JPQL OU SQL : PASSEZ PAR UNE VUE DANS LA BD ET UNE REQUETE NATIVE
     * OU PAR UN PEU DE TRAITEMENT EN JAVA...
     * @return
     */
    public Produit plusGrosseVenteQuantite() {
        Query q = em.createQuery("SELECT p FROM LigneVente lv JOIN Produit p ON lv.idLV = p.idProduit ORDER BY lv.quantite DESC");
        return (Produit) q.setMaxResults(1).getSingleResult();
    }

    /**
     * Renvoie le produit dont les ventes génèrent le plus gros chiffre d'affaire (quantité * prix unitaire)
     * VOUS NE POURREZ PAS LE FAIRE DIRECTEMENT EN JPQL OU SQL : PASSEZ PAR UNE VUE DANS LA BD ET UNE REQUETE NATIVE
     * OU PAR UN PEU DE TRAITEMENT EN JAVA...
     * @return
     */
    public Produit plusGrosseVenteMontant() {
        Query q = em.createQuery("SELECT p FROM LigneVente lv JOIN Produit p ON lv.idLV = p.idProduit ORDER BY (lv.quantite * p.prixVente) DESC");
        return (Produit) q.setMaxResults(1).getSingleResult();
    }

    /**
     * Renvoie la liste des produits dont le stock est inférieur ou égal à stockMini
     * @param stockMini
     * @return
     */
    public List<Produit> stockSous(int stockMini) {
        Query q = em.createQuery("SELECT p FROM Produit p WHERE p.stock <= :stockMini");
        q.setParameter("stockMini", stockMini);
        return (List<Produit>) q.getResultList();
    }

//    public List<Produit> stockSous(int stockMini) {
//        String jpql = "SELECT p FROM Produit p WHERE p.stock <= :stockMini";
//        TypedQuery<Produit> query = em.createQuery(jpql, Produit.class);
//        query.setParameter("stockMini", stockMini);
//        return query.getResultList();
//    }

    /**
     * Renvoie la liste des ventes comportant le produit dont l'id est en paramètre
     * @param idProduit
     * @return
     */
    public List<Vente> ventesDe(int idProduit) {
        Query q = em.createQuery("SELECT v FROM Vente v JOIN LigneVente lv ON v.idVente = lv.idLV WHERE lv.idLV = :idProduit");
        q.setParameter("idProduit", idProduit);
        return (List<Vente>) q.getResultList();
    }

    /**
     * Renvoie la liste ** dates de commande *** des ventes comportant le produit dont l'id est en paramètre
     * @param idProduit
     * @return
     */
    public List<LocalDate> datesVentesDe(int idProduit) {
        Query q = em.createQuery("SELECT v.dateCmd FROM Vente v JOIN LigneVente lv ON v.idVente = lv.idLV WHERE lv.idLV = :idProduit");
        q.setParameter("idProduit", idProduit);
        return (List<LocalDate>) q.getResultList();
    }

    /**
     * Renvoie la liste de sproduits qui n'ont jamais été vendus (aucune vente)
     * @return
     */
    public List<Produit> produitsNonVendus() {
        Query q = em.createQuery("SELECT p FROM Produit p WHERE p.idProduit NOT IN (SELECT lv.idLV FROM LigneVente lv)");
        return (List<Produit>) q.getResultList();
    }

    /**
     * Renvoie les gestionnaires qui ont déjà passé des demandes d'approvisionnement pour le produit en paramètre
     * @param idProduit
     * @return
     */
    public List<Gestionnaire> acheteurDe(int idProduit) {
        Query q = em.createQuery("SELECT g FROM Gestionnaire g JOIN Approvisionnement a ON g.idGest = a.gestionnaire JOIN LigneApprovisionnement la ON a.idAppro = la.idLA WHERE la.idLA = :idProduit");
        q.setParameter("idProduit", idProduit);
        return (List<Gestionnaire>) q.getResultList();
    }

    /**
     * Renvoie le produit le moins cher de la catégorie indiquée.
     * @param idCategorie
     * @return
     */
    public Produit moinsCherDe(int idCategorie) {
        Query q = em.createQuery("SELECT p FROM Produit p WHERE p.idProduit = :idCategorie ORDER BY p.prixVente ASC");
        q.setParameter("idCategorie", idCategorie);
        return (Produit) q.setMaxResults(1).getSingleResult();
    }

    /**
     * Renvoie la catégorie du produit indiqué.
     * @param idProduit
     * @return
     */
    public Categorie categorieDe(int idProduit) {
        Query q = em.createQuery("SELECT c FROM Categorie c JOIN Produit p ON c.idCategorie = p.idProduit WHERE p.idProduit = :idProduit");
        q.setParameter("idProduit", idProduit);
        return (Categorie) q.getSingleResult();
    }
}
