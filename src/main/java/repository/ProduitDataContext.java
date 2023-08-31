package repository;

import model.IDataContext;
import model.Produit;

import java.util.ArrayList;

public class ProduitDataContext implements IDataContext {
    private  static List<Produit> listeproduits= new ArrayList(){
        {
            add(new Produit(1,"Stylo",10.99,'A'));
            add(new Produit(2,"Crayon",2.50,'A'));
            add(new Produit(3,"Cahier",4.99,'S'));
            add(new Produit(4,"Efface",5.00,'A'));
        }
    };
    public Object getListeProduits(){
        return this.listeproduits;
    }

    @Override
    public  Produit find(int numero){
        Produit p;
        p=ProduitDataContext.listeproduits.stream().filter((a)->a.getNumero()==numero).findFirst().get();
        return p;
    }


    @Override
    public  void remove(int numero){
        ProduitDataContext.listeproduits.removeIf((p)->p.getNumero()==numero);
    }


    @Override
    public  void add(Produit produit){
        ProduitDataContext.listeproduits.add(produit);
    }


    @Override
    public  void update(Produit produit){
        Produit p=this.find(produit.getNumero());
        p.setNumero(produit.getNumero());
        p.setDescription(produit.getDescription());
        p.setPrix(produit.getPrix());
        p.setTaxe(produit.getTaxe());
    }


}
