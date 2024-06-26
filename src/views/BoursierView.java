package views;

import entities.Boursier;
import enums.TypeBourse;

public class BoursierView extends ViewImp<Boursier> {

    @Override
    public Boursier saisi() {
        Boursier boursier = new Boursier();
        boursier.setTypeBourse(typeBourse());
        return boursier;
    }

    public TypeBourse typeBourse(){
        int choix=0;
        do {
            System.out.println("Veuillez choisir le Type de la Bourse :");
            System.out.println("1-Entiere");
            System.out.println("2-Demi");
            System.out.print("Votre Choix : ");
            try {
                choix = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Erreur de Saisi!!! Entrer un entier entre [1-2]");
                scanner.next();
            }
        } while (choix!=1 && choix !=2);
        return TypeBourse.values()[choix-1];
    }
    
}
