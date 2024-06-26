package views;

import entities.Chambre;
import enums.TypeChambre;

public class ChambreView extends ViewImp<Chambre> {

    @Override
    public Chambre saisi() {
        Chambre chambre = new Chambre();
        System.out.println("Entrer le numero d'Etage de la chambre:");
        chambre.setNumeroEtage(scanner.nextInt());
        chambre.setTypeChambre(choixChambre());
        return chambre;
    }

    public TypeChambre choixChambre(){
        int choix=0;
        do {
            System.out.println("Veuillez choisir le Type de la chambre :");
            System.out.println("1-INDIVIDUEL");
            System.out.println("2-PLUSIEURS");
            System.out.print("Votre Choix : ");
            try {
                choix = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Erreur de Saisi!!! Entrer un entier entre [1-2]");
                scanner.next();
            }
        } while (choix!=1 && choix !=2);
        return TypeChambre.values()[choix-1];
    }
    
}
