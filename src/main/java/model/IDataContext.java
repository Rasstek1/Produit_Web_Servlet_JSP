package model;

public interface IDataContext {
    public void add(Produit produit);
    public Produit find(int numero);
    public void remove(int numero);
    public void update(Produit produit);

}
