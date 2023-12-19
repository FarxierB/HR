import Service.CreateDateService;
import configuration.JPAConfig;
import entity.Werknemer;
import jakarta.persistence.EntityManager;
import repository.WerknemerRepo;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        EntityManager entityManager = JPAConfig.getEntityManager();
        WerknemerRepo werknemerRepo = new WerknemerRepo(entityManager);

        try {
            int choice;
            do {
                System.out.println("1. Create Werknemer");
                System.out.println("2. Update Werknemer");
                System.out.println("3. Delete Werknemer");
                System.out.println("4. View All Werknemers");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

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
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }

            } while (choice != 5);
        } finally {
            // Close resources
            scanner.close();
            JPAConfig.shutdown();
        }
    }

    private static void createWerknemer(Scanner scanner, WerknemerRepo werknemerRepo) {
        Werknemer newWerknemer = new Werknemer();
        System.out.print("Enter IdNummer: ");
        newWerknemer.setIdNummer(scanner.nextLine());

        System.out.print("Enter Voornamen: ");
        newWerknemer.setVoorNamen(scanner.nextLine());

        System.out.print("Enter Achternaam: ");
        newWerknemer.setAchterNaam(scanner.nextLine());

        /*System.out.print("Enter geboortedatum (YYYY-MM-DD): ");
        newWerknemer.setGeboorteDatum(LocalDate.parse(scanner.nextLine()));*/

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

//            System.out.print("Enter new Achternaam: ");
//            updatedWerknemer.setAchterNaam(scanner.nextLine());
//
//            System.out.print("Enter new geboortedatum: ");
//            updatedWerknemer.setGeboorteDatum(LocalDate.parse(scanner.nextLine()));
//
//            System.out.print("Enter new Geboorteplaats: ");
//            updatedWerknemer.setGeboortePlaats(scanner.nextLine());

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




         //CreateDateService.CreateData();
        // CreateDataService.getInfo();
    }
