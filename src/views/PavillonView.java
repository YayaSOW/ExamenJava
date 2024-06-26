package views;

import entities.Pavillon;

public class PavillonView extends ViewImp<Pavillon> {

    @Override
    public Pavillon saisi() {
        Pavillon pavillon = new Pavillon();
        System.out.println("Entrer le nombre d'Etage du Pavillon:");
        pavillon.setNbreEtage(scanner.nextInt());
        return pavillon;
    }
    
}
