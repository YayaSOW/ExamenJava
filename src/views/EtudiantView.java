package views;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import core.Service;
import entities.Boursier;
import entities.Chambre;
import entities.Etudiant;
import entities.Loge;
import entities.NonBoursier;
import enums.TypeBourse;

public class EtudiantView extends ViewImp<Etudiant> {
    private Service<Chambre> chambreService;
    private Service<Etudiant> etudiantService;
    private ViewImp <Chambre> chambreView;

    public EtudiantView(Service<Chambre> chambreService,ViewImp <Chambre> chambreView, Service<Etudiant> etudiantService) {
        this.chambreService = chambreService;
        this.etudiantService = etudiantService;
        this.chambreView = chambreView;
    }

    @Override
    public Etudiant saisi() {
        // Etudiant etudiant = new Etudiant();
        scanner.nextLine();
        System.out.println("Entrer le nom de l'etudiant");
        String nom = scanner.nextLine();
        System.out.println("Entrer le Prenom de l'etudiant");
        String prenom = scanner.nextLine();
        System.out.println("Entrer le mail de l'etudiant");
        String email = scanner.nextLine();
        System.out.println("Entrer le tel de l'etudiant");
        String tel = scanner.nextLine();
        LocalDate dateNaissance  = saisiDate();
        int rep = typeEtudiant();
        if (rep == 1) {
            TypeBourse typeBourse = typeBourse();
            if (typeBourse.compareTo(TypeBourse.Entiere) == 0) {
                if (demandeLoger() == 1) {
                    chambreView.affiche(chambreService.show());
                    System.out.println("Entrer le numéro de la chambre:");
                    String numeroChambre = scanner.nextLine();
                    Chambre chambre = chambreService.getBy(numeroChambre);
                    if (chambre != null && !chambre.isOccuper()) {
                        Loge etudiantBoursierLoge = new Loge(nom, prenom, email, tel, dateNaissance,typeBourse, chambre);
                        chambre.setOccuper(true);
                        //Loge => Chambre
                        etudiantBoursierLoge.setChambre(chambre);
                        //Chambre => Loge
                        chambre.add(etudiantBoursierLoge);
                        // Ajout de l'etudiant boursier loger dans le tableau Etudiant
                        etudiantService.add(etudiantBoursierLoge);
                        System.out.println(chambre);
                        return etudiantBoursierLoge;
                    } else {
                        if (chambre==null) {
                            System.out.println("Ce numero n'existe pas !!!");
                        }else{
                            System.out.println("Chambre Occuper");
                        }
                    }
                }else{
                    // etudiant qui doit etre normalement loge (mais il peut l'affecter après)
                    Loge etudiantBoursierLoge = new Loge(nom, prenom, email, tel, dateNaissance,typeBourse, null);
                    // Ajout de l'etudiant boursier loger dans le tableau Etudiant
                    etudiantService.add(etudiantBoursierLoge);
                    return etudiantBoursierLoge;
                    
                }
            }else{
                // etudiant boursier non loge
                Boursier etudiantBoursier = new Boursier(nom, prenom, email, tel, dateNaissance,typeBourse);
                // Ajout de l'etudiant boursier dans le tableau Etudiant
                etudiantService.add(etudiantBoursier);
                return etudiantBoursier;
            }
        }else{
                System.out.println("Entrer l'adresse de l'étudiant:");
                String adresse = scanner.next();
                NonBoursier nonBoursier = new NonBoursier(nom, prenom, email, tel,dateNaissance, adresse);
                // Ajout de l'etudiant boursier dans le tableau Etudiant
                etudiantService.add(nonBoursier);
                return nonBoursier;
        }
        return null;
    }

    public int typeEtudiant() {
        int choix = 0;
        do {
            System.out.println("L'étudiant est-il:");
            System.out.println("1-Boursier");
            System.out.println("2-Non Boursier");
            System.out.print("Votre choix?: ");
            try {
                choix = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextInt();
            }
        } while (choix != 1 && choix != 2);
        scanner.nextLine();
        return choix;
    }

    public TypeBourse typeBourse() {
        int choix = 0;
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
        } while (choix != 1 && choix != 2);
        return TypeBourse.values()[choix - 1];
    }

    public int demandeLoger() {
        int choix = 0;
        do {
            System.out.println("Voulez-Vous Loger l'etudiant ?: ");
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

    // public void afficherBoursiersLoges() {
    //     List<Loge> boursiersLoges = etudiantService.getBoursiersLoges();
    //     System.out.println("Liste des boursiers logés :");
    //     for (Loge boursierLoge : boursiersLoges) {
    //         System.out.println(boursierLoge);
    //     }
    // }
}
