package entities;

import javax.persistence.*;

@NamedQueries(
        {
                @NamedQuery(
                        name = "entities.LigneVente.nomProduitPlusGrosseLigne",
                        query = "SELECT p.nomProduit FROM LigneVente lv JOIN Produit p ON lv.idLV = p.idProduit ORDER BY lv.quantite DESC"
                ),
                @NamedQuery(
                        name = "entities.LigneVente.plusGrosseVenteQuantite",
                        query = "SELECT p FROM LigneVente lv JOIN Produit p ON lv.idLV = p.idProduit ORDER BY lv.quantite DESC"
                )

        }
)


@Entity
public class LigneVente {
    @Id  @GeneratedValue
    private int idLV;
    @ManyToOne
    private Vente vente;
    @ManyToOne
    private Produit produit;
    private int quantite;

    public int getIdLV() {
        return idLV;
    }


    public Vente getVente() {
        return vente;
    }

    public void setVente(Vente vente) {
        this.vente = vente;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
