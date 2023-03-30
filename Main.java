import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

interface Plant{
    String getTypePlant();
    String getNaam();
    int getGemiddeldeHoogte();
    boolean isHalfSchaduwZonPlant();
    boolean isSchaduwPlant();
    boolean isZonPlant();
    String getPlantInformatie();
    String getBloemKleur();
    ArrayList<String> getBloeiMaanden();
}
class BasicPlant{
    protected String naam;
    protected int gemiddeldeHoogte;
    protected boolean halfschaduwzonplant;
    protected boolean schaduwplant;
    protected boolean zonplant;
    protected String bloemkleur;
    protected ArrayList<String> bloeimaanden;

    public BasicPlant(String naam, int gemiddeldeHoogte, boolean halfschaduwzonplant, boolean schaduwplant, boolean zonplant, String bloemkleur, ArrayList<String> bloeimaanden) {
        this.naam = naam;
        this.gemiddeldeHoogte = gemiddeldeHoogte;
        this.halfschaduwzonplant = halfschaduwzonplant;
        this.schaduwplant = schaduwplant;
        this.zonplant = zonplant;
        this.bloemkleur = bloemkleur;
        this.bloeimaanden = bloeimaanden;
    }

    public String getNaam() {
        return naam;
    }
    public int getGemiddeldeHoogte() {
        return gemiddeldeHoogte;
    }
    public boolean isHalfSchaduwZonPlant() {
        return halfschaduwzonplant;
    }
    public boolean isSchaduwPlant() {
        return schaduwplant;
    }
    public boolean isZonPlant() {
        return zonplant;
    }

    public String getBloemKleur() {
        return bloemkleur;
    }

    public ArrayList<String> getBloeiMaanden() {
        return bloeimaanden;
    }
}
class VastePlant extends BasicPlant{
    protected boolean wintergroen;
    protected String grasbladkleur;

    public VastePlant(String naam, int gemiddeldeHoogte, boolean halfschaduwzonplant, boolean schaduwplant, boolean zonplant, String bloemkleur, boolean wintergroen, String grasbladkleur, ArrayList<String> bloeimaanden) {
        super(naam, gemiddeldeHoogte, halfschaduwzonplant, schaduwplant, zonplant, bloemkleur, bloeimaanden);
        this.wintergroen = wintergroen;
        this.grasbladkleur = grasbladkleur;
    }

    public boolean isWintergroen() {
        return wintergroen;
    }
    public String getGrasbladkleur() {
        return grasbladkleur;
    }

}
class VasteBloeiendeSierGras extends VastePlant implements Plant{
    private String typeplant = "VasteBloeiendeSierGras";

    public VasteBloeiendeSierGras(String naam, int gemiddeldeHoogte, boolean halfschaduwzonplant, boolean schaduwplant, boolean zonplant, String bloemkleur, boolean wintergroen, String grasbladkleur, ArrayList<String> bloeimaanden) {
        super(naam, gemiddeldeHoogte, halfschaduwzonplant, schaduwplant, zonplant, bloemkleur, wintergroen, grasbladkleur, bloeimaanden);
    }

    public String getTypePlant() {
        return typeplant;
    }

    public String getPlantInformatie() {
        String bloeimaanden = "";
        String zonschaduw;
        String wintergroen;
        if (this.wintergroen) wintergroen = "This plant keeps his gras/leaf color during the winter";
        else wintergroen = "this plant doesn't keep his gras/leaf color during the winter";
        for (String maand : this.bloeimaanden){
            bloeimaanden += maand + " - ";
        }
        if (schaduwplant){
            zonschaduw = "Best for in the Shadow";
            return String.format("Name: %s%nType of plant: %s%nAverage height (cm): %s%nSun / Shadow: %s%ngras/Leaf color: %s%nBloom/flower colors: %s%nBloom/flowering period: %s%nWintergroen: %s%n",naam,typeplant,gemiddeldeHoogte,zonschaduw,grasbladkleur,bloemkleur,bloeimaanden,wintergroen);
        }
        if(halfschaduwzonplant){
            zonschaduw = "Best for a place with a little bit of shadow";
            return String.format("Name: %s%nType of plant: %s%nAverage height (cm): %s%nSun / Shadow: %s%nGras/Leaf color: %s%nBloom/flower colors: %s%nBloom/flowering period: %s%nWintergroen: %s%n",naam,typeplant,gemiddeldeHoogte,zonschaduw,grasbladkleur,bloemkleur,bloeimaanden,wintergroen);
        }
        if (zonplant){
            zonschaduw = "Best for in the sun";
            return String.format("Name: %s%nType of plant: %s%nAverage height (cm): %s%nSun / Shadow: %s%nGras/Leaf color: %s%nBloom/flower colors: %s%nBloom/flowering period: %s%nWintergroen: %s%n",naam,typeplant,gemiddeldeHoogte,zonschaduw,grasbladkleur,bloemkleur,bloeimaanden,wintergroen);
        }
        return "It seems the plant missed some important information :(";
    }
}
class VasteBloemPlant extends VastePlant implements Plant{
    private String typeplant = "VasteBloemPlant";

    public VasteBloemPlant(String naam, int gemiddeldeHoogte, boolean halfschaduwzonplant, boolean schaduwplant, boolean zonplant, String bloemkleur, boolean wintergroen, String grasbladkleur, ArrayList<String> bloeimaanden) {
        super(naam, gemiddeldeHoogte, halfschaduwzonplant, schaduwplant, zonplant, bloemkleur, wintergroen, grasbladkleur, bloeimaanden);
    }

    public String getTypePlant() {
        return typeplant;
    }

    public String getPlantInformatie() {
        String bloeimaanden = "";
        String zonschaduw;
        String wintergroen;
        if (this.wintergroen) wintergroen = "This plant keeps his leaf color during the winter";
        else wintergroen = "this plant doesn't keep his leaf color during the winter";
        for (String maand : this.bloeimaanden){
            bloeimaanden += maand + " - ";
        }
        if (schaduwplant){
            zonschaduw = "Best for in the Shadow";
            return String.format("Name: %s%nType of plant: %s%nAverage height (cm): %s%nSun / Shadow: %s%nLeaf color: %s%nFlower colors: %s%nFlowering period: %s%nWintergroen: %s%n",naam,typeplant,gemiddeldeHoogte,zonschaduw,grasbladkleur,bloemkleur,bloeimaanden,wintergroen);
        }
        if(halfschaduwzonplant){
            zonschaduw = "Best for a place with a little bit of shadow";
            return String.format("Name: %s%nType of plant: %s%nAverage height (cm): %s%nSun / Shadow: %s%nLeaf color: %s%nFlower colors: %s%nFlowering period: %s%nWintergroen: %s%n",naam,typeplant,gemiddeldeHoogte,zonschaduw,grasbladkleur,bloemkleur,bloeimaanden,wintergroen);
        }
        if (zonplant){
            zonschaduw = "Best for in the sun";
            return String.format("Name: %s%nType of plant: %s%nAverage height (cm): %s%nSun / Shadow: %s%nLeaf color: %s%nFlower colors: %s%nFlowering period: %s%nWintergroen: %s%n",naam,typeplant,gemiddeldeHoogte,zonschaduw,grasbladkleur,bloemkleur,bloeimaanden,wintergroen);
        }
        return "It seems the plant missed some important information :(";
    }
}
class EenJarigeBloemPlant extends BasicPlant implements Plant{
    private String typeplant = "EenJarigeBloemPlant";

    public EenJarigeBloemPlant(String naam, int gemiddeldeHoogte, boolean halfschaduwzonplant, boolean schaduwplant, boolean zonplant, String bloemkleur, ArrayList<String> bloeimaanden) {
        super(naam, gemiddeldeHoogte, halfschaduwzonplant, schaduwplant, zonplant, bloemkleur, bloeimaanden);
    }

    public String getTypePlant() {
        return typeplant;
    }

    public String getPlantInformatie() {
        String bloeimaanden = "";
        String zonschaduw;
        for (String maand : this.bloeimaanden){
            bloeimaanden += maand + " - ";
        }
        if (schaduwplant){
            zonschaduw = "Best for in the Shadow";
            return String.format("Name: %s%nType of plant: %s%nAverage height (cm): %s%nSun / Shadow: %s%nFlower colors: %s%nFlowering period: %s%n",naam,typeplant,gemiddeldeHoogte,zonschaduw,bloemkleur,bloeimaanden);
        }
        if(halfschaduwzonplant){
            zonschaduw = "Best for a place with a little bit of shadow";
            return String.format("Name: %s%nType of plant: %s%nAverage height (cm): %s%nSun / Shadow: %s%nFlower colors: %s%nFlowering period: %s%n",naam,typeplant,gemiddeldeHoogte,zonschaduw,bloemkleur,bloeimaanden);
        }
        if (zonplant){
            zonschaduw = "Best for in the sun";
            return String.format("Name: %s%nType of plant: %s%nAverage height (cm): %s%nSun / Shadow: %s%nFlower colors: %s%nFlowering period: %s%n",naam,typeplant,gemiddeldeHoogte,zonschaduw,bloemkleur,bloeimaanden);
        }
        return "It seems the plant missed some important information :(";
    }
}
class PlantData{
    Plant plant1 = new EenJarigeBloemPlant("test1",50,false,false,true,"blue", new ArrayList<>(Arrays.asList("may","june")));
    Plant plant2 = new VasteBloemPlant("test2",30,true,false,false,"blue",false,"green", new ArrayList<>(Arrays.asList("august","September")));
    Plant plant3 = new VasteBloeiendeSierGras("test3",110,false,true,false,"nvt",true,"red", new ArrayList<>(Arrays.asList("june","july","august")));
    Plant plant4 = new VasteBloeiendeSierGras("test4",70,false,true,false,"purple",true,"green", new ArrayList<>(Arrays.asList("june","july")));
    Plant plant5 = new VasteBloeiendeSierGras("test5",70,false,false,true,"blue",true,"green", new ArrayList<>(Arrays.asList("june","july", "august")));
    ArrayList<Plant> plantenlijst = new ArrayList<>();

    public void installeerPlantData(){
        plantenlijst.addAll(Arrays.asList(plant1,plant2,plant3,plant4,plant5));
    }
}
class VergelijkFuncties {
    public boolean isGelijkeHoogte(int minhoogte, int maxhoogte, Plant plant) {
        if (plant.getGemiddeldeHoogte() >= minhoogte && plant.getGemiddeldeHoogte() <= maxhoogte) {
            return true;
        }
        return false;
    }

    public boolean isTuinGeschikt(String plantligging, Plant plant) {
        if (plantligging.equalsIgnoreCase("shadow")) {
            if (plant.isSchaduwPlant()) return true;
        }
        if (plantligging.equalsIgnoreCase("halfshadow")) {
            if (plant.isHalfSchaduwZonPlant()) return true;
        }
        if (plantligging.equalsIgnoreCase("sun")) {
            if (plant.isZonPlant()) return true;
        }
        return false;
    }

    public boolean isWintergroen(boolean wiltwintergroen,VastePlant vasteplant) {
        if (!wiltwintergroen){
            return true;
        }
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
        for (int i = 0; i < verplichtebloeimaanden.size(); i++){
            for (String bloeimaand : bloeimaanden){
                if (bloeimaand.equalsIgnoreCase(verplichtebloeimaanden.get(i))){
                    matches++;
                }
            }
        }
        if (nodig == matches) return true;
        else return false;
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
        System.out.println("Enter 1 if you do!");
        System.out.println("enter 2 if you don't mind");
        int keuze = scanner.nextInt();
        scanner.nextLine();
        if (keuze == 1) this.wiltwintergroen = true;
        else this.wiltwintergroen = false;
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
                System.out.println("Pls restart the application you entered a wrong number you fool!!!!!!!!!");
                System.out.println("Pls restart the application you entered a wrong number you fool!!!!!!!!!");
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
    private VergelijkFuncties vergelijker;
    private GebruikerEisen eisen;

    public VergelijkPlant(VergelijkFuncties vergelijker, GebruikerEisen eisen) {
        this.vergelijker = vergelijker;
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
        PlantData plantdata = new PlantData();
        VergelijkFuncties vergelijker = new VergelijkFuncties();
        plantdata.installeerPlantData();
        GebruikerEisen eisen = new GebruikerEisen();
        VergelijkPlant vergelijkPlant = new VergelijkPlant(vergelijker, eisen);
        eisen.setMinhoogte();
        eisen.setMaxhoogte();
        eisen.setKleur();
        eisen.setWiltwintergroen();
        eisen.setVerplichtebloeimaanden();
        eisen.setPlantligging();
        System.out.println("");
        for (Plant plant : plantdata.plantenlijst){
            if (vergelijkPlant.vergelijkPlant(plant)){
                System.out.println(plant.getPlantInformatie());
            }
        }
    }
}
