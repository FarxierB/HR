import Facade.WerknemerDetailFacade;
import Observer.ObserverChange;
import Service.CreateDateService;
import Service.DetailService;
import configuration.JPAConfig;
import entity.Functie;
import entity.Werknemer;
import entity.WerknemerDetail;
import jakarta.persistence.EntityManager;
import repository.FunctieRepo;
import repository.WerknemerRepo;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);

        EntityManager entityManager = JPAConfig.getEntityManager();
        WerknemerRepo werknemerRepo = new WerknemerRepo(entityManager);
        FunctieRepo functieRepo = new FunctieRepo(entityManager);
        DetailService werknemerDetail = new DetailService();



        try {
            int choice;
            do {
                System.out.println("1. Create Werknemer");
                System.out.println("2. Update Werknemer");
                System.out.println("3. Delete Werknemer");
                System.out.println("4. View All Werknemers");
                System.out.println("5. View aantal werknemers in dienst");
                System.out.println("6. View lijst van functies");
                System.out.println("7. View aantal werknemers in dienst per functies");
                System.out.println("8. Create WerknemerDetail");
                System.out.println("9. Exit");
                System.out.print("Enter your choice: ");

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        createWerknemer(scanner, werknemerRepo);
                        break;
                    case 2:
                        updateWerknemer(scanner, werknemerRepo);
                        break;
                    case 3:
                        deleteWerknemer(scanner, werknemerRepo);
                        break;
                    case 4:
                        viewAllWerknemers(werknemerRepo);
                        break;
                    case 5:
                        getTotalWerknemersCount(werknemerRepo);
                        break;
                    case 6:
                        viewAllFuncties(functieRepo);
                        break;
                    case 7:
                        getWerknemersCountByFunctie(scanner, werknemerRepo);
                        break;
                    case 8:
                        createWerknemerDetail(scanner, werknemerDetail);
                        break;
                    case 9:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }

            } while (choice != 9);
        } finally {
            // Close resources
            scanner.close();
            JPAConfig.shutdown();
        }
        //CreateDateService.CreateData();
    }

    private static void createWerknemer(Scanner scanner, WerknemerRepo werknemerRepo) {
        Werknemer newWerknemer = new Werknemer();
        System.out.print("Enter IdNummer: ");
        newWerknemer.setIdNummer(scanner.nextLine());

        System.out.print("Enter Voornamen: ");
        newWerknemer.setVoorNamen(scanner.nextLine());

        System.out.print("Enter Achternaam: ");
        newWerknemer.setAchterNaam(scanner.nextLine());

        System.out.print("Enter geboortedatum (YYYY-MM-DD): ");
        newWerknemer.setGeboorteDatum(LocalDate.parse(scanner.nextLine()));

        System.out.print("Enter Geboorteplaats: ");
        newWerknemer.setGeboortePlaats(scanner.nextLine());

        werknemerRepo.createWerknemer(newWerknemer);
        System.out.println("Werknemer created successfully!");
    }

    private static void updateWerknemer(Scanner scanner, WerknemerRepo werknemerRepo) {
        Werknemer updatedWerknemer = new Werknemer();
        System.out.print("Enter ID number to update: ");
        updatedWerknemer.setIdNummer(scanner.nextLine());
        if (updatedWerknemer != null) {
            System.out.print("Enter new Voornamen: ");
            updatedWerknemer.setVoorNamen(scanner.nextLine());

            System.out.print("Enter new Achternaam: ");
            updatedWerknemer.setAchterNaam(scanner.nextLine());

//            System.out.print("Enter new geboortedatum: ");
//            updatedWerknemer.setGeboorteDatum(LocalDate.parse(scanner.nextLine()));

            System.out.print("Enter new Geboorteplaats: ");
            updatedWerknemer.setGeboortePlaats(scanner.nextLine());

            werknemerRepo.updateWerknemer(updatedWerknemer);
            System.out.println("Werknemer updated successfully!");
        } else {
            System.out.println("Werknemer not found");
        }
    }

    private static void deleteWerknemer(Scanner scanner, WerknemerRepo werknemerRepo) {

        System.out.print("Enter Werknemer IdNummer om te deleten: ");
        String idNummer = scanner.nextLine();
        Werknemer bestaandeWerknemer = werknemerRepo.getWerknemer(idNummer);
        if (bestaandeWerknemer != null) {
            werknemerRepo.deleteWerknemer(bestaandeWerknemer);
            System.out.println("Werknemer deleted successfully!");
        } else {
            System.out.println("Werknemer not found with ID: " + idNummer);
        }

    }

    private static void viewAllWerknemers(WerknemerRepo werknemerRepo) {
        System.out.println("All Werknemers:");
        for (Werknemer werknemer : werknemerRepo.getWerknemers()) {
            System.out.println("Werknemer ID: " + werknemer.getIdNummer() +
                    ", Voornamen: " + werknemer.getVoorNamen() +
                    ", Achternaam: " + werknemer.getAchterNaam() +
                    ", GeboorteDatum: " + werknemer.getGeboorteDatum() +
                    ", GeboortePlaats: " + werknemer.getGeboortePlaats());
        }
    }


    private static void getTotalWerknemersCount(WerknemerRepo werknemerRepo) {
        long totalWerknemersCount = werknemerRepo.getTotalWerknemersCount();
        System.out.println("Total number of Werknemers: " + totalWerknemersCount);
    }

    private static void getWerknemersCountByFunctie(Scanner scanner, WerknemerRepo werknemerRepo) {
        System.out.print("Enter Functie Name: ");
        String functieName = scanner.nextLine();
        long werknemersCount = werknemerRepo.getWerknemersCountByFunctie(functieName);
        System.out.println("Total number of Werknemers with Functie " + functieName + ": " + werknemersCount);
    }


    private static void viewAllFuncties(FunctieRepo functieRepo) {
        System.out.println("All Werknemers:");
        for (Functie functie : functieRepo.getFuncties()) {
            System.out.println("Functie ID: " + functie.getFunctieId() +
                    ", Functie: " + functie.getFunctieType());
        }
    }

    private static void createWerknemerDetail(Scanner scanner, DetailService detailService) {
        WerknemerDetail newWerknemerDetail = new WerknemerDetail();
        System.out.print("Enter Adres: ");
        newWerknemerDetail.setAdres(scanner.nextLine());

        System.out.print("Enter TelefoonNummer: ");
        newWerknemerDetail.setTelefoonNummer(scanner.nextLine());

        System.out.print("Enter Email: ");
        newWerknemerDetail.setEmail(scanner.nextLine());


        detailService.createWerknemerDetail(newWerknemerDetail);
        System.out.println("WerknemerDetail created successfully!");
    }


        // CreateDataService.getInfo();
}

