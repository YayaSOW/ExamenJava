import java.util.List;
import java.util.Scanner;

import core.Service;
import core.ServiceImpChambre;
import core.ServiceImpEtudiant;
import entities.Chambre;
import entities.Etudiant;
import entities.Loge;
import entities.Pavillon;
import services.ChambreService;
import services.EtudiantService;
import services.PavillonService;
import views.ChambreView;
import views.EtudiantView;
import views.PavillonView;
import views.ViewImp;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        ViewImp<Pavillon> pavillonView = new PavillonView();
        ViewImp<Chambre> chambreView = new ChambreView();
        Service<Pavillon> pavillonService = new PavillonService();
        ServiceImpChambre chambreService = new ChambreService();
        ServiceImpEtudiant etudiantService = new EtudiantService();
        ViewImp<Etudiant> etudiantView = new EtudiantView(chambreService, chambreView, etudiantService);
        pavillonView.setScanner(scanner);
        chambreView.setScanner(scanner);
        etudiantView.setScanner(scanner);
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
                                System.out.print("Entrer le numero de la chambre:");
                                String num = scanner.nextLine();
                                Chambre chambre = chambreService.getBy(num);
                                if (chambre == null) {
                                    System.out.println("Ce numero n'existe pas !!!");
                                } else {
                                    System.out.println(chambre);
                                    // Vérification si la chambre n'est pas déjà affectée à un pavillon
                                    if (chambre.getPavillon() == null) {
                                        // Chambre => Pavillon
                                        chambre.setPavillon(pavillon);
                                        // Pavillon => Chambre
                                        pavillon.add(chambre);
                                        // Ajout du Pavillon dans le tableau de Pavillons
                                        if (pavillonService.getBy(pavillon.getNumeroPavillon()) == null) {
                                            pavillonService.add(pavillon);
                                        }
                                    } else {
                                        System.out.println("Cette chambre est déjà affectée à un pavillon !");
                                    }
                                }
                            }
                        }
                        System.out.println("Voulez-vous ajouter une autre chambre ? :");
                        rep = continuer();
                    } while (rep != 2);
                }
                case 2 -> {
                    if (pavillonService.count() == 0) {
                        System.out.println("Liste vide pour le moment");
                    } else {
                        scanner.nextLine();
                        System.out.println("Liste Pavillon");
                        pavillonView.affiche(pavillonService.show());
                        System.out.print("Entrer le numero du pavillon:");
                        String num = scanner.nextLine();
                        Pavillon pavillon = pavillonService.getBy(num);
                        if (pavillon == null) {
                            System.out.println("Ce numero n'existe pas !!!");
                        } else {
                            System.out.println(pavillon);
                            System.out.println("Entrer le nombre d'Etage du Pavillon:");
                            pavillon.setNbreEtage(scanner.nextInt());
                            System.out.println("Pavillon modifier avec succès");
                        }
                    }
                }
                case 3 -> {
                    if (pavillonService.count() == 0) {
                        System.out.println("Liste vide pour le moment");
                    } else {
                        pavillonView.affiche(pavillonService.show());
                    }
                }
                case 4 -> {
                    Chambre chambre = chambreView.saisi();
                    System.out.println("Voulez-vous Affecter la chambre a un pavillon ?:");
                    int rep = continuer();
                    // do {
                    if (rep == 1) {
                        if (pavillonService.count() == 0) {
                            System.out.println("liste Pavillon vide!!! Vous devriez creer un pavillon:");
                            Pavillon pavillon = pavillonView.saisi();
                            // Ajout de lu pavillon creer dans le tableau de Pavillon
                            pavillonService.add(pavillon);
                            // Chambre => Pavillon
                            chambre.setPavillon(pavillon);
                            // Pavillon => Chambre
                            pavillon.add(chambre);
                            System.out.println("Pavillon creer avec succès");
                            // Ajout de la chambre creer dans le tableau de Chambres
                            if (chambreService.getBy(chambre.getNumeroChambre()) == null) {
                                chambreService.add(chambre);
                            }
                        } else {
                            System.out.println("Affecter la chambre a un pavillon:");
                            pavillonView.affiche(pavillonService.show());
                            System.out.print("Entrer le numero du Pavillon:");
                            String num = scanner.nextLine();
                            Pavillon pavillon = pavillonService.getBy(num);
                            if (pavillon == null) {
                                System.out.println("Ce numero n'existe pas !!!");
                            } else {
                                System.out.println(pavillon);
                                // Chambre => Pavillon
                                chambre.setPavillon(pavillon);
                                // Pavillon => Chambre
                                pavillon.add(chambre);
                                // Ajout de la chambre creer dans le tableau de Chambres
                                if (chambreService.getBy(chambre.getNumeroChambre()) == null) {
                                    chambreService.add(chambre);
                                }
                            }
                        }
                    } else {
                        chambreService.add(chambre);
                        System.out.println("Chambre Ajouter avec succès");
                    }
                    // rep = continuer();
                    // } while (rep != 2);
                }
                case 5 -> {
                    if (chambreService.count() == 0) {
                        System.out.println("Liste vide pour le moment");
                    } else {
                        scanner.nextLine();
                        System.out.println("Liste Chambre :");
                        chambreView.affiche(chambreService.show());
                        System.out.print("Entrer le numero de la chambre:");
                        String num = scanner.nextLine();
                        Chambre chambre = chambreService.getBy(num);
                        if (chambre == null) {
                            System.out.println("Ce numero n'existe pas !!!");
                        } else {
                            System.out.println(chambre);
                            System.out.println("Entrer le nombre d'Etage de la chambre:");
                            chambre.setNumeroEtage(scanner.nextInt());
                        }
                    }
                }
                case 6 -> {
                    if (chambreService.count() == 0) {
                        System.out.println("Liste vide pour le moment");
                    } else {
                        chambreView.affiche(chambreService.show());
                    }
                }
                case 7 -> {
                    if (chambreService.count() == 0) {
                        System.out.println("Liste vide pour le moment");
                    } else {
                        scanner.nextLine();
                        System.out.println("Liste Chambre :");
                        chambreView.affiche(chambreService.show());
                        System.out.print("Entrer le numero de la chambre:");
                        String num = scanner.nextLine();
                        Chambre chambre = chambreService.getBy(num);
                        if (chambre == null) {
                            System.out.println("Ce numero n'existe pas !!!");
                        } else {
                            chambre.setEtat(false);
                            System.out.println(chambre);
                        }
                    }
                }
                case 8 -> {
                    Etudiant etudiant = etudiantView.saisi();
                    // etudiantService.add(etudiant);
                }
                case 9 -> {
                    if (etudiantService.count() == 0) {
                        System.out.println("Liste vide pour le moment");
                    } else {
                        etudiantView.affiche(etudiantService.show());
                    }
                }
                case 10 -> {
                    scanner.nextLine();
                    if (chambreService.count() == 0) {
                        System.out.println("Vous devriez creer une chambre au moins!!!");
                    } else {
                        System.out.println("Liste Chambre:");
                        chambreView.affiche(chambreService.show());
                        System.out.print("Entrer le numero de la chambre:");
                        String num = scanner.nextLine();
                        Chambre chambre = chambreService.getBy(num);
                        if (chambre == null) {
                            System.out.println("Ce numero n'existe pas !!!");
                        } else {
                            if (chambre.isOccuper()) {
                                System.out.println("Chambre deja Occuper");
                            } else {
                                List<Loge> etudiantsNonLoges = etudiantService.getEtudiantsNonLoges();
                                if(etudiantsNonLoges.size()==0){
                                    System.out.println("liste des Etudiants Non Loges est vide");
                                }else{
                                    System.out.println("Étudiants non logés:");
                                    System.out.println(etudiantService.getEtudiantsNonLoges());
                                    System.out.println("Entrer le matricule de l'etudiant:");
                                    String mat = scanner.nextLine();
                                    boolean etudiantTrouve = false;
                                    for (Loge etudiantLoge : etudiantsNonLoges) {
                                        if (etudiantLoge.getMatricule().compareToIgnoreCase(mat) == 0) {
                                            etudiantTrouve = true;
                                            chambre.setOccuper(true);
                                            // Loge => Chambre
                                            etudiantLoge.setChambre(chambre);
                                            // Chambre => Loge
                                            chambre.add(etudiantLoge);
                                            // Ajout de l'etudiant boursier loger dans le tableau Etudiant
                                            etudiantService.add(etudiantLoge);
                                            System.out.println("Chambre affectée avec succès à l'étudiant.");
                                            break;
                                        }
                                    }
                                    if (!etudiantTrouve) {
                                        System.out.println("Étudiant non trouvé parmi les étudiants non logés.");
                                    }
                                }
                            }
                        }
                    }
                }
                case 11 -> {
                    scanner.nextLine();
                    if (pavillonService.count() == 0) {
                        System.out.println("Liste vide pour le moment");
                    } else {
                        System.out.println("Liste Pavillon");
                        pavillonView.affiche(pavillonService.show());
                        System.out.print("Entrer le numero du pavillon:");
                        String num = scanner.nextLine();
                        Pavillon pavillon = pavillonService.getBy(num);
                        if (pavillon == null) {
                            System.out.println("Ce numero n'existe pas !!!");
                        } else {
                            System.out.println(pavillon);
                            if (chambreService.count() == 0) {
                                System.out.println("Liste vide pour le moment");
                            } else {
                                for (Chambre chambre : chambreService.show()) {
                                    if (chambre.getPavillon() != null && chambre.getPavillon().getNumeroPavillon()
                                            .compareTo(pavillon.getNumeroPavillon()) == 0) {
                                        System.out.println(chambre);
                                    }
                                }
                            }
                        }
                    }
                }
                case 12 -> {
                    scanner.nextLine();
                    if (chambreService.count() == 0) {
                        System.out.println("Liste vide pour le moment");
                    } else {
                        System.out.println("Liste Chambre");
                        chambreView.affiche(chambreService.show());
                        System.out.print("Entrer le numero de la chambre:");
                        String num = scanner.nextLine();
                        Chambre chambre = chambreService.getBy(num);
                        if (chambre == null) {
                            System.out.println("Ce numero n'existe pas !!!");
                        } else {
                            System.out.println(chambre);
                            if (chambre.isOccuper() == false) {
                                System.out.println("Chambre vide (Aucun etudiant)");
                            } else {
                                if (etudiantService.count() == 0) {
                                    System.out.println("Liste vide pour le moment");
                                } else {
                                    List<Loge> etudiantsDansChambre = chambreService.getEtudiantsParChambre(chambre);
                                    for (Loge etudiant : etudiantsDansChambre) {
                                        System.out.println(etudiant);
                                    }
                                }
                            }
                        }
                    }
                }
                default -> {
                }
            }
        } while (choice != 13);
        scanner.close();
    }

    public static int menu() {
        int choix = 0;
        System.out.println("1-Ajouter Pavillon");
        System.out.println("2-Modifier les Pavillons");
        System.out.println("3-Lister les Pavillons");
        System.out.println("4-Ajouter Chambre");
        System.out.println("5-Modifier Chambre");
        System.out.println("6-Lister les Chambres");
        System.out.println("7-Archiver Chambre");
        System.out.println("8-Ajouter un Etudiant");
        System.out.println("9-Lister les Etudiants");
        System.out.println("10-Affecter une chambre a un boursier logé");
        System.out.println("11-Lister les Chambres d'un pavillon");
        System.out.println("12-Lister les etudiant d'une chambre");
        System.out.println("13-Quitter");
        System.out.print("Votre choix : ");
        try {
            choix = scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
        }
        return choix;
    }

    public static int choiceChambre() {
        int choix = 0;
        do {
            System.out.println("1- Voulez-vous creer une nouvelle chambre ?");
            System.out.println("2- Voulez-vous Affecter une chambre au pavillon ?");
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
            System.out.print("Votre choix ?: ");
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
