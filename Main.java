import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;




public class Main {
   public static void main(String[] args) {
       ArrayList<Client> clienti = new ArrayList<>();
       ArrayList<Sofer> soferi = new ArrayList<>();
       ArrayList<Contract> contracte = new ArrayList<>();
       ArrayList<Ruta> rute = new ArrayList<>();
       ArrayList<Filiala> filiale = new ArrayList<>();
       Scanner scanner = new Scanner(System.in);
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");




       while (true) {
           System.out.println("\n*** Meniu Servicii Hamali ***");
           System.out.println("1. Adaugă client");
           System.out.println("2. Adaugă șofer");
           System.out.println("3. Adaugă rută");
           System.out.println("4. Crează contract");
           System.out.println("5. Afișează contracte");
           System.out.println("6. Afișează salariul șoferilor într-o perioadă");
           System.out.println("7. Afișează cheltuielile clienților într-o perioadă");
           System.out.println("8. Adaugă filiala");
           System.out.println("9. Afișează filiale");
           System.out.println("10. Ieșire");
           System.out.print("Alege opțiunea: ");




           int optiune = scanner.nextInt();
           scanner.nextLine();




           if (optiune < 1 || optiune > 10) {
               System.out.println("Opțiune invalidă! Introdu un număr între 1 și 10.");
               continue;
           }




           switch (optiune) {
               case 1:
                   System.out.print("Nume client: ");
                   String numeClient = scanner.nextLine().trim();
                   System.out.print("Adresa client: ");
                   String adresaClient = scanner.nextLine().trim();
                   System.out.print("Telefon client: ");
                   String telefonClient = scanner.nextLine().trim();
                   clienti.add(new Client(numeClient, adresaClient, telefonClient));
                   System.out.println("Client adăugat!");
                   break;




               case 2:
                   System.out.print("Nume șofer: ");
                   String numeSofer = scanner.nextLine().trim();
                   System.out.print("Adresa șofer: ");
                   String adresaSofer = scanner.nextLine().trim();
                   System.out.print("Telefon șofer: ");
                   String telefonSofer = scanner.nextLine().trim();
                   System.out.print("Stagiu muncă: ");
                   int stagiu = scanner.nextInt();
                   scanner.nextLine();
                   System.out.print("Categorie: ");
                   String categorie = scanner.nextLine().trim();
                   soferi.add(new Sofer(numeSofer, adresaSofer, telefonSofer, stagiu, categorie));
                   System.out.println("Șofer adăugat!");
                   break;




               case 3:
                   System.out.print("Denumirea rutei: ");
                   String denumireRuta = scanner.nextLine().trim();
                   System.out.print("Distanța rutei (km): ");
                   double distantaRuta = scanner.nextDouble();
                   scanner.nextLine();
                   rute.add(new Ruta(denumireRuta, distantaRuta));
                   System.out.println("Rută adăugată!");
                   break;




               case 4:
                   if (clienti.isEmpty() || soferi.isEmpty() || rute.isEmpty()) {
                       System.out.println("Trebuie să adăugați cel puțin un client, un șofer și o rută înainte de a crea un contract!");
                       break;
                   }




                   try {
                       System.out.println("\nLista clienților:");
                       for (int i = 0; i < clienti.size(); i++) {
                           System.out.println((i + 1) + ". " + clienti.get(i).getNume());
                       }
                       System.out.print("Alege clientul (număr): ");
                       int q = scanner.nextInt() - 1;
                       scanner.nextLine();




                       System.out.println("\nLista șoferilor:");
                       for (int i = 0; i < soferi.size(); i++) {
                           System.out.println((i + 1) + ". " + soferi.get(i).getNume());
                       }
                       System.out.print("Alege șoferul (număr): ");
                       int w = scanner.nextInt() - 1;
                       scanner.nextLine();




                       System.out.println("\nLista rutelor:");
                       for (int i = 0; i < rute.size(); i++) {
                           System.out.println((i + 1) + ". " + rute.get(i).getDenumire() + " (" + rute.get(i).getDistanta() + " km)");
                       }
                       System.out.print("Alege ruta (număr): ");
                       int e = scanner.nextInt() - 1;
                       scanner.nextLine();




                       System.out.print("Introdu data plecării (dd-MM-yyyy): ");
                       String ple = scanner.nextLine().trim();
                       LocalDate dataPlecare = LocalDate.parse(ple, formatter);




                       System.out.print("Introdu data sosirii (dd-MM-yyyy): ");
                       String sos = scanner.nextLine().trim();
                       LocalDate dataSosire = LocalDate.parse(sos, formatter);




                       Contract contract = new Contract(clienti.get(q), soferi.get(w), rute.get(e), 5.0, dataPlecare, dataSosire);
                       contracte.add(contract);
                       System.out.println("Contract creat cu succes!");




                   } catch (Exception e) {
                       System.out.println("Eroare: " + e.getMessage());
                   }
                   break;




               case 5:
                   if (contracte.isEmpty()) {
                       System.out.println("Nu există contracte!");
                   } else {
                       System.out.println("\nLista contractelor:");
                       for (Contract contract : contracte) {
                           contract.afisareDetalii();
                       }
                   }
                   break;




               case 6:
                   System.out.print("Introdu data de început (dd-MM-yyyy): ");
                   LocalDate dataStart = LocalDate.parse(scanner.nextLine().trim(), formatter);
                   System.out.print("Introdu data de sfârșit (dd-MM-yyyy): ");
                   LocalDate dataEnd = LocalDate.parse(scanner.nextLine().trim(), formatter);




                   System.out.println("\nSalariile șoferilor:");
                   for (Contract contract : contracte) {
                       if (contract.isInPeriod(dataStart, dataEnd)) {
                           System.out.println(contract.getSofer().getNume() + " → " + contract.getSofer().getSalariu() + " lei");
                       }
                   }
                   break;




               case 7:
                   System.out.print("Introdu data de început (dd-MM-yyyy): ");
                   LocalDate dataStartClient = LocalDate.parse(scanner.nextLine().trim(), formatter);
                   System.out.print("Introdu data de sfârșit (dd-MM-yyyy): ");
                   LocalDate dataEndClient = LocalDate.parse(scanner.nextLine().trim(), formatter);




                   System.out.println("\nCheltuielile clienților:");
                   for (Contract contract : contracte) {
                       if (contract.isInPeriod(dataStartClient, dataEndClient)) {
                           System.out.println(contract.getClient().getNume() + " → " + contract.getClient().getSumaCheltuita() + " lei");
                       }
                   }
                   break;
               case 8:
                   try {
                       System.out.print("Nume filiala: ");
                       String numeFiliala = scanner.nextLine().trim();
                       if (numeFiliala.isEmpty()) throw new IllegalArgumentException("Numele filialei nu poate fi gol!");




                       System.out.print("Adresa filiala: ");
                       String adresaFiliala = scanner.nextLine().trim();
                       if (adresaFiliala.isEmpty()) throw new IllegalArgumentException("Adresa filialei nu poate fi goală!");




                       System.out.print("Telefon filiala: ");
                       String telefonFiliala = scanner.nextLine().trim();
                       if (telefonFiliala.isEmpty() || !telefonFiliala.matches("\\d+"))
                           throw new IllegalArgumentException("Telefon invalid!");




                       filiale.add(new Filiala(numeFiliala, adresaFiliala, telefonFiliala));
                       System.out.println("Filiala adăugată cu succes!");




                   } catch (IllegalArgumentException e) {
                       System.out.println("Eroare: " + e.getMessage());
                   }
                   break;




               case 9:
                   if (filiale.isEmpty()) {
                       System.out.println("Nu există filiale!");
                   } else {
                       System.out.println("\nLista filialelor:");
                       for (Filiala filiala : filiale) {
                           System.out.println(filiala);
                       }
                   }
                   break;
               case 10:
                   System.out.println("Ieșire din program.");
                   scanner.close();
                   System.exit(0);
                   break;
           }
       }
   }
}
