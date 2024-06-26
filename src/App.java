import java.util.List;
import java.util.Scanner;

import core.Service;
import entities.Boursier;
import entities.Chambre;
import entities.Etudiant;
import entities.Loge;
import entities.NonBoursier;
import entities.Pavillon;
import services.ChambreService;
import services.EtudiantService;
import services.PavillonService;
import views.BoursierView;
import views.ChambreView;
import views.EtudiantView;
import views.NonBoursierView;
import views.PavillonView;
import views.ViewImp;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        ViewImp<Pavillon> pavillonView = new PavillonView();
        ViewImp<Chambre> chambreView = new ChambreView();
        ViewImp<Boursier> boursierView = new BoursierView();
        ViewImp<NonBoursier> nonBoursierView = new NonBoursierView();
        Service<Pavillon> pavillonService = new PavillonService();
        Service<Chambre> chambreService = new ChambreService();
        Service<Etudiant> etudiantService = new EtudiantService();
        ViewImp<Etudiant> etudiantView = new EtudiantView(chambreService, chambreView, etudiantService);
        pavillonView.setScanner(scanner);
        chambreView.setScanner(scanner);
        etudiantView.setScanner(scanner);
        boursierView.setScanner(scanner);
        nonBoursierView.setScanner(scanner);
        int choice;
        do {
            choice = menu();
            switch (choice) {
                case 1 -> {
                    Pavillon pavillon = pavillonView.saisi();
                    int rep;
                    do {
                        if (chambreService.count() == 0) {
                            System.out.println("liste chambre vide!!! Vous devriez creer une chambre:");
                            Chambre chambre = chambreView.saisi();
                            // Ajout de la chambre creer dans le tableau de Chambres
                            chambreService.add(chambre);
                            // Chambre => Pavillon
                            chambre.setPavillon(pavillon);
                            // Pavillon => Chambre
                            pavillon.add(chambre);
                            // Ajout du Pavillon dans le tableau de Pavillons
                            if (pavillonService.getBy(pavillon.getNumeroPavillon()) == null) {
                                pavillonService.add(pavillon);
                            }
                        } else {
                            if (choiceChambre() == 1) {
                                Chambre chambre = chambreView.saisi();
                                // Ajout de la chambre creer dans le tableau de Chambres
                                chambreService.add(chambre);
                                // Chambre => Pavillon
                                chambre.setPavillon(pavillon);
                                // Pavillon => Chambre
                                pavillon.add(chambre);
                                // Ajout du Pavillon dans le tableau de Pavillons
                                if (pavillonService.getBy(pavillon.getNumeroPavillon()) == null) {
                                    pavillonService.add(pavillon);
                                }
                            } else {
                                scanner.nextLine();
                                System.out.println("Affecter ume chambre au pavillon:");
                                chambreView.affiche(chambreService.show());
                                String num;
                                System.out.print("Entrer le numero de la chambre:");
                                num = scanner.nextLine();
                                Chambre chambre = chambreService.getBy(num);
                                if (chambre == null) {
                                    System.out.println("Ce numero n'existe pas !!!");
                                } else {
                                    System.out.println(chambre);
                                    // Chambre => Pavillon
                                    chambre.setPavillon(pavillon);
                                    // Pavillon => Chambre
                                    pavillon.add(chambre);
                                    // Ajout du Pavillon dans le tableau de Pavillons
                                    if (pavillonService.getBy(pavillon.getNumeroPavillon()) == null) {
                                        pavillonService.add(pavillon);
                                    }
                                }
                            }
                        }
                        rep = continuer();
                    } while (rep != 2);
                }
                case 2 -> {
                    scanner.nextLine();
                    String num;
                    System.out.print("Entrer le numero du pavillon:");
                    num = scanner.nextLine();
                    Pavillon pavillon = pavillonService.getBy(num);
                    if (pavillon == null) {
                        System.out.println("Ce numero n'existe pas !!!");
                    } else {
                        System.out.println(pavillon);
                        System.out.println("Entrer le nombre d'Etage du Pavillon:");
                        pavillon.setNbreEtage(scanner.nextInt());
                    }
                }
                case 3 -> {
                    pavillonView.affiche(pavillonService.show());
                }
                case 4 -> {
                    chambreService.add(chambreView.saisi());
                }
                case 5 -> {
                    scanner.nextLine();
                    String num;
                    System.out.print("Entrer le numero de la chambre:");
                    num = scanner.nextLine();
                    Chambre chambre = chambreService.getBy(num);
                    if (chambre == null) {
                        System.out.println("Ce numero n'existe pas !!!");
                    } else {
                        System.out.println(chambre);
                        System.out.println("Entrer le nombre d'Etage de la chambre:");
                        chambre.setNumeroEtage(scanner.nextInt());
                    }
                }
                case 6 -> {
                    chambreView.affiche(chambreService.show());
                }
                case 7 -> {
                    scanner.nextLine();
                    String num;
                    System.out.print("Entrer le numero de la chambre:");
                    num = scanner.nextLine();
                    Chambre chambre = chambreService.getBy(num);
                    if (chambre == null) {
                        System.out.println("Ce numero n'existe pas !!!");
                    } else {
                        chambre.setEtat(false);
                        System.out.println(chambre);
                    }
                }
                case 8 -> {
                    Etudiant etudiant = etudiantView.saisi();
                    // etudiantService.add(etudiant);
                }
                case 9 -> {
                    etudiantView.affiche(etudiantService.show());
                }
                case 10 -> {
                    scanner.nextLine();
                    String num;
                    System.out.print("Entrer le numero du pavillon:");
                    num = scanner.nextLine();
                    Pavillon pavillon = pavillonService.getBy(num);
                    if (pavillon == null) {
                        System.out.println("Ce numero n'existe pas !!!");
                    } else {
                        System.out.println(pavillon);
                        for (Chambre chambre : chambreService.show()) {
                            if (chambre.getPavillon().getNumeroPavillon()
                                    .compareTo(pavillon.getNumeroPavillon()) == 0) {
                                System.out.println(chambre);
                            }
                        }
                    }
                }
                case 11 -> {
                    scanner.nextLine();
                    String num;
                    System.out.print("Entrer le numero de la chambre:");
                    num = scanner.nextLine();
                    Chambre chambre = chambreService.getBy(num);
                    if (chambre == null) {
                        System.out.println("Ce numero n'existe pas !!!");
                    } else {
                        // System.out.println(chambre);
                        // List<Loge> etudiantsDansChambre = chambreService.getEtudiantsParChambre(chambre);
                        // for (Loge etudiant : etudiantsDansChambre) {
                        //     System.out.println(etudiant);
                        }
                        // for (Etudiant etudiant : etudiantService.show()) {
                        // if (etudiantService.getEtudiantsLoges()) {
                        // System.out.println(chambre);
                        // }
                        // }
                    }
                }
                default -> {
                }
            }
        } while (choice != 12);
        scanner.close();
    }

    public static int menu() {
        System.out.println("1-Ajouter Pavillon");
        System.out.println("2-Modifier les Pavillons");
        System.out.println("3-Lister les Pavillons");
        System.out.println("4-Ajouter Chambre");
        System.out.println("5-Modifier Chambre");
        System.out.println("6-Lister les Chambres");
        System.out.println("7-Archiver Chambre");
        System.out.println("8-Ajouter un Etudiant");
        System.out.println("9-Lister les Etudiants");
        System.out.println("10-Lister les Chambres d'un pavillon");
        System.out.println("11-Lister les etudiant d'une chambre");
        System.out.println("12-Quitter");
        System.out.print("Votre choix : ");
        return scanner.nextInt();
    }

    public static int choiceChambre() {
        int choix = 0;
        do {
            System.out.println("1- Voulez-vous creer une nouvelle chambre ?");
            System.out.println("2- Voulez-vous Affecter ume chambre au pavillon ?");
            System.out.print("Votre choix?: ");
            try {
                choix = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextInt();
            }
        } while (choix != 1 && choix != 2);
        return choix;
    }

    public static int continuer() {
        int choix = 0;
        do {
            System.out.println("1-Oui");
            System.out.println("2-Non");
            System.out.print("Voulez-Vous Continuer ?: ");
            try {
                choix = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextInt();
            }
        } while (choix != 1 && choix != 2);
        scanner.nextLine();
        return choix;
    }

}
