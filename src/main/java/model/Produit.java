package model;

public class Produit {
    private int numero;
    private String description;
    private double prix;
    private char taxe;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    public char getTaxe() {
        return taxe;
    }

    public void setTaxe(char taxe) {
        this.taxe = taxe;
    }
    public Produit(){}
    public Produit(int numero, String description, double prix, char taxe) {
        this.numero = numero;
        this.description = description;
        this.prix = prix;
        this.taxe=taxe;
    }

    public void Mapper(HttpServletRequest request){

        this.setNumero(Integer.parseInt(request.getParameter("numero")));
        this.setDescription(request.getParameter("description"));
        this.setPrix(Double.parseDouble(request.getParameter("prix")));
        this.setTaxe(request.getParameter("taxe").charAt(0));
    }

}
