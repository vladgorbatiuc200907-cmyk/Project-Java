public class Sofer extends Persoana {
   private int stagiuMunca;
   private String categorie;
   private double salariu;


   public Sofer(String nume, String adresa, String telefon, int stagiuMunca, String categorie) {
       super(nume, adresa, telefon);
       this.stagiuMunca = stagiuMunca;
       this.categorie = categorie;
       this.salariu = 0.0;
   }


   
   public int getStagiuMunca() { return stagiuMunca; }
   public void setStagiuMunca(int stagiuMunca) { this.stagiuMunca = stagiuMunca; }


   public String getCategorie() { return categorie; }
   public void setCategorie(String categorie) { this.categorie = categorie; }


   public double getSalariu() { return salariu; }
   public void setSalariu(double salariu) { this.salariu = salariu; }


   public void calculeazaSalariu(double distanta, double tarifPeKm) {
       this.salariu = distanta * tarifPeKm;
   }


   @Override
   public void afisareDetalii() {
       System.out.println("Șofer: " + nume + ", Categorie: " + categorie + ", Stagiu muncă: " + stagiuMunca + " ani, Salariu: " + salariu + " lei");
   }
}
