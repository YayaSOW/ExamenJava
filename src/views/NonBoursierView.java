package views;

import entities.NonBoursier;

public class NonBoursierView extends ViewImp<NonBoursier> {

    @Override
    public NonBoursier saisi() {
        NonBoursier nonBoursier = new NonBoursier();
        System.out.println("Entrer l'adresse de l'etudiant");
        nonBoursier.setAdresse(scanner.nextLine());
        return nonBoursier;
    }
    
}
