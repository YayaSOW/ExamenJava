package views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import core.View;

public abstract class ViewImp<T> implements View<T> {
    protected Scanner scanner;

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void affiche(List<T> objet) {
        for (T values : objet) {
            System.out.println(values);
        }
    }

    public LocalDate saisiDate() {
        LocalDate dateValide = null;
        boolean valide = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        while (!valide) {
            System.out.print("Entrer la date [dd-MM-yyyy] : ");
            String date = scanner.nextLine();
            try {
                dateValide = LocalDate.parse(date, formatter);
                valide=true;
            } catch (DateTimeParseException e) {
                System.out.println("Date invalide, veuillez entrer une date au format dd-MM-yyyy!");
            }
        }
        return dateValide;
    }

}
