package enums;

public enum TypeBourse {
    Entiere(40000.0),
    Demi(20000.0);
    private double montant; 
    private TypeBourse(double montant) {
        this.montant = montant;
    }
    public double getMontant() {
        return montant;
    }
}
