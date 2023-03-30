import java.util.ArrayList;
import java.util.Scanner;
class VergelijkFuncties {
    public boolean isGelijkeHoogte(int minhoogte, int maxhoogte, Plant plant) {
        return plant.getGemiddeldeHoogte() >= minhoogte && plant.getGemiddeldeHoogte() <= maxhoogte;
    }
    public boolean isTuinGeschikt(String plantligging, Plant plant) {
        if (plantligging.equalsIgnoreCase("shadow")) {
            return plant.isSchaduwPlant();
        }
        if (plantligging.equalsIgnoreCase("halfshadow")) {
            return plant.isHalfSchaduwZonPlant();
        }
        if (plantligging.equalsIgnoreCase("sun")) {
            return plant.isZonPlant();
        }
        return false;
    }
    public boolean isWintergroen(boolean wiltwintergroen,VastePlant vasteplant) {
        if (!wiltwintergroen) return true;
        return vasteplant.isWintergroen();
    }
    public boolean isBloemKleur(String kleur, Plant plant){
        if (kleur.equalsIgnoreCase(plant.getBloemKleur())) return true;
        else return false;
    }
    public boolean isEenVanDeKleur(String kleur, VastePlant plant){
        if (kleur.equalsIgnoreCase(plant.getGrasbladkleur()) || kleur.equalsIgnoreCase(plant.getBloemKleur())) return true;
        else return false;
    }
    public boolean isBloeiMaanden(ArrayList<String> verplichtebloeimaanden, ArrayList<String> bloeimaanden){
        int nodig = verplichtebloeimaanden.size();
        int matches = 0;
        for (String verplichtemaand : verplichtebloeimaanden){
            for (String bloeimaand : bloeimaanden){
                if (bloeimaand.equalsIgnoreCase(verplichtemaand)){
                    matches++;
                }
            }
        }
        return nodig == matches;
    }
}
class GebruikerEisen{
    Scanner scanner = new Scanner(System.in);
    private int minhoogte;
    private int maxhoogte;
    private String kleur;
    private boolean wiltwintergroen;
    private ArrayList<String> verplichtebloeimaanden = new ArrayList<>();
    private String plantligging;
    public void setMinhoogte() {
        System.out.println("Enter the minimum height for your plant: ");
        this.minhoogte = scanner.nextInt();
    }
    public void setMaxhoogte() {
        System.out.println("Enter the maximum height for your plant: ");
        this.maxhoogte = scanner.nextInt();
        scanner.nextLine();
    }
    public void setKleur() {
        System.out.println("Enter the desired color for your plant: ");
        this.kleur = scanner.nextLine();
    }
    public void setWiltwintergroen() {
        System.out.println("Do you want your plant to be evergreen?");
        System.out.println("Enter 1 if you do! or 2 if you don't mind");
        int keuze = scanner.nextInt();
        scanner.nextLine();
        this.wiltwintergroen = keuze == 1;
    }
    public void setVerplichtebloeimaanden() {
        int stopinvullenmaanden = 1;
        while (!(stopinvullenmaanden == 2)){
            System.out.println("pls enter 1 month that you want your plant to bloom: ");
            verplichtebloeimaanden.add(scanner.nextLine());
            System.out.println("if you want to enter an extra month press 1 else press 2:");
            stopinvullenmaanden = scanner.nextInt();
            scanner.nextLine();
        }
    }
    public void setPlantligging() {
        int keuze;
        System.out.println("enter the position of your garden in relation to the sun");
        System.out.println("1 = north, 2 = west, 3 = south, 4 = east: ");
        if (scanner.nextInt() == 1) this.plantligging = "shadow";
        else {
            System.out.println("In this case pls enter where your plant is gonna be located");
            System.out.println("1 = in the shadow, 2 = in halfshadow, 3 = in the sun");
            keuze = scanner.nextInt();
            if (keuze == 1) this.plantligging = "shadow";
            if (keuze == 2) this.plantligging = "halfshadow";
            if (keuze == 3) this.plantligging = "sun";
            else {
                System.out.println("Pls restart the application you entered a wrong number you fool!!!!!!!!!");
            }
        }
    }
    public int getMinhoogte() {
        return minhoogte;
    }
    public int getMaxhoogte() {
        return maxhoogte;
    }
    public String getKleur() {
        return kleur;
    }
    public boolean isWiltwintergroen() {
        return wiltwintergroen;
    }
    public ArrayList<String> getVerplichtebloeimaanden() {
        return verplichtebloeimaanden;
    }
    public String getPlantligging() {
        return plantligging;
    }
}
class VergelijkPlant{
    final VergelijkFuncties vergelijker = new VergelijkFuncties();
    private GebruikerEisen eisen;
    public VergelijkPlant(GebruikerEisen eisen) {
        this.eisen = eisen;
    }
    public boolean vergelijkPlant(Plant plant){
        if (!(vergelijker.isGelijkeHoogte(eisen.getMinhoogte(), eisen.getMaxhoogte(), plant))) return false;
        if (!(vergelijker.isTuinGeschikt(eisen.getPlantligging(), plant))) return false;
        if (eisen.isWiltwintergroen()){
            if (plant.getTypePlant().equalsIgnoreCase("VasteBloeiendeSierGras") || plant.getTypePlant().equalsIgnoreCase("VasteBloemPlant")){
                if (!(vergelijker.isWintergroen(eisen.isWiltwintergroen(), (VastePlant) plant))) return false;
            }
            else return false;
        }
        if (plant.getTypePlant().equalsIgnoreCase("VasteBloeiendeSierGras") || plant.getTypePlant().equalsIgnoreCase("VasteBloemPlant")){
            if (!(vergelijker.isEenVanDeKleur(eisen.getKleur(), (VastePlant) plant))) return false;
        }
        if (!(vergelijker.isBloemKleur(eisen.getKleur(), plant))) return false;
        if (!(vergelijker.isBloeiMaanden(eisen.getVerplichtebloeimaanden(), plant.getBloeiMaanden()))) return false;
        return true;
    }
}
public class Main {
    public static void main(String[] args) {
        GebruikerEisen eisen = new GebruikerEisen();
        VergelijkPlant vergelijkPlant = new VergelijkPlant(eisen);
        eisen.setMinhoogte();
        eisen.setMaxhoogte();
        eisen.setKleur();
        eisen.setWiltwintergroen();
        eisen.setVerplichtebloeimaanden();
        eisen.setPlantligging();
        for (Plant plant : PlantData.plantenlijst){
            if (vergelijkPlant.vergelijkPlant(plant)){
                System.out.println(plant.getPlantInformatie());
            }
        }
    }
}