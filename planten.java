import java.util.ArrayList;
import java.util.Arrays;

class PlantData {
    static Plant plant1 = new EenJarigeBloemPlant("test1", 50, false, false, true, "blue", new ArrayList<>(Arrays.asList("may", "june")));
    static Plant plant2 = new VasteBloemPlant("test2", 30, true, false, false, "blue", false, "green", new ArrayList<>(Arrays.asList("august", "September")));
    static Plant plant3 = new VasteBloeiendeSierGras("test3", 110, false, true, false, "nvt", true, "red", new ArrayList<>(Arrays.asList("june", "july", "august")));
    static Plant plant4 = new VasteBloeiendeSierGras("test4", 70, false, true, false, "purple", true, "green", new ArrayList<>(Arrays.asList("june", "july")));
    static Plant plant5 = new VasteBloeiendeSierGras("test5", 70, false, false, true, "blue", true, "green", new ArrayList<>(Arrays.asList("june", "july", "august")));
    static Plant plant6 = new VasteBloemPlant("Afrikaanse lelie", 50, false, false, true, "blue", false, "green", new ArrayList<>(Arrays.asList("july", "august", "september")));
    static Plant plant7 = new VasteBloemPlant("Bieslook", 30, false, false, true, "purple", false, "green", new ArrayList<>(Arrays.asList("june", "july")));
    static Plant plant8 = new VasteBloemPlant("Daslook", 20, true, false, false, "white", false, "green", new ArrayList<>(Arrays.asList("april", "may")));
    static Plant plant9 = new VasteBloemPlant("rodeCamelia", 180, true, false, false, "red", true, "green", new ArrayList<>(Arrays.asList("february", "march", "april")));
    static Plant plant10 = new VasteBloemPlant("pinkCamelia", 180, true, false, false, "pink", true, "green", new ArrayList<>(Arrays.asList("february", "march", "april")));
    static Plant plant11 = new VasteBloemPlant("Boterbloem", 35, false, false, true, "yellow", true, "green", new ArrayList<>(Arrays.asList("may","june")));

    static final ArrayList<Plant> plantenlijst = new ArrayList<>(Arrays.asList(plant1, plant2, plant3, plant4, plant5,plant6,plant7,plant8,plant9,plant10,plant11));
}
interface Plant {
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
class BasicPlant {
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
class EenJarigeBloemPlant extends BasicPlant implements Plant {
    final String typeplant = "EenJarigeBloemPlant";

    public EenJarigeBloemPlant(String naam, int gemiddeldeHoogte, boolean halfschaduwzonplant, boolean schaduwplant, boolean zonplant, String bloemkleur, ArrayList<String> bloeimaanden) {
        super(naam, gemiddeldeHoogte, halfschaduwzonplant, schaduwplant, zonplant, bloemkleur, bloeimaanden);
    }

    public String getTypePlant() {
        return typeplant;
    }

    public String getPlantInformatie() {
        String bloeimaanden = "";
        String zonschaduw;
        for (String maand : this.bloeimaanden) {
            bloeimaanden += maand + " - ";
        }
        if (schaduwplant) {
            zonschaduw = "Best for in the Shadow";
            return String.format("Name: %s%nType of plant: %s%nAverage height (cm): %s%nSun / Shadow: %s%nFlower colors: %s%nFlowering period: %s%n", naam, typeplant, gemiddeldeHoogte, zonschaduw, bloemkleur, bloeimaanden);
        }
        if (halfschaduwzonplant) {
            zonschaduw = "Best for a place with a little bit of shadow";
            return String.format("Name: %s%nType of plant: %s%nAverage height (cm): %s%nSun / Shadow: %s%nFlower colors: %s%nFlowering period: %s%n", naam, typeplant, gemiddeldeHoogte, zonschaduw, bloemkleur, bloeimaanden);
        }
        if (zonplant) {
            zonschaduw = "Best for in the sun";
            return String.format("Name: %s%nType of plant: %s%nAverage height (cm): %s%nSun / Shadow: %s%nFlower colors: %s%nFlowering period: %s%n", naam, typeplant, gemiddeldeHoogte, zonschaduw, bloemkleur, bloeimaanden);
        }
        return "It seems the plant missed some important information :(";
    }
}
class VastePlant extends BasicPlant {
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
class VasteBloeiendeSierGras extends VastePlant implements Plant {
    final String typeplant = "VasteBloeiendeSierGras";

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
        for (String maand : this.bloeimaanden) {
            bloeimaanden += maand + " - ";
        }
        if (schaduwplant) {
            zonschaduw = "Best for in the Shadow";
            return String.format("Name: %s%nType of plant: %s%nAverage height (cm): %s%nSun / Shadow: %s%ngras/Leaf color: %s%nBloom/flower colors: %s%nBloom/flowering period: %s%nWintergroen: %s%n", naam, typeplant, gemiddeldeHoogte, zonschaduw, grasbladkleur, bloemkleur, bloeimaanden, wintergroen);
        }
        if (halfschaduwzonplant) {
            zonschaduw = "Best for a place with a little bit of shadow";
            return String.format("Name: %s%nType of plant: %s%nAverage height (cm): %s%nSun / Shadow: %s%nGras/Leaf color: %s%nBloom/flower colors: %s%nBloom/flowering period: %s%nWintergroen: %s%n", naam, typeplant, gemiddeldeHoogte, zonschaduw, grasbladkleur, bloemkleur, bloeimaanden, wintergroen);
        }
        if (zonplant) {
            zonschaduw = "Best for in the sun";
            return String.format("Name: %s%nType of plant: %s%nAverage height (cm): %s%nSun / Shadow: %s%nGras/Leaf color: %s%nBloom/flower colors: %s%nBloom/flowering period: %s%nWintergroen: %s%n", naam, typeplant, gemiddeldeHoogte, zonschaduw, grasbladkleur, bloemkleur, bloeimaanden, wintergroen);
        }
        return "It seems the plant missed some important information :(";
    }
}
class VasteBloemPlant extends VastePlant implements Plant {
    final String typeplant = "VasteBloemPlant";

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
        for (String maand : this.bloeimaanden) {
            bloeimaanden += maand + " - ";
        }
        if (schaduwplant) {
            zonschaduw = "Best for in the Shadow";
            return String.format("Name: %s%nType of plant: %s%nAverage height (cm): %s%nSun / Shadow: %s%nLeaf color: %s%nFlower colors: %s%nFlowering period: %s%nWintergroen: %s%n", naam, typeplant, gemiddeldeHoogte, zonschaduw, grasbladkleur, bloemkleur, bloeimaanden, wintergroen);
        }
        if (halfschaduwzonplant) {
            zonschaduw = "Best for a place with a little bit of shadow";
            return String.format("Name: %s%nType of plant: %s%nAverage height (cm): %s%nSun / Shadow: %s%nLeaf color: %s%nFlower colors: %s%nFlowering period: %s%nWintergroen: %s%n", naam, typeplant, gemiddeldeHoogte, zonschaduw, grasbladkleur, bloemkleur, bloeimaanden, wintergroen);
        }
        if (zonplant) {
            zonschaduw = "Best for in the sun";
            return String.format("Name: %s%nType of plant: %s%nAverage height (cm): %s%nSun / Shadow: %s%nLeaf color: %s%nFlower colors: %s%nFlowering period: %s%nWintergroen: %s%n", naam, typeplant, gemiddeldeHoogte, zonschaduw, grasbladkleur, bloemkleur, bloeimaanden, wintergroen);
        }
        return "It seems the plant missed some important information :(";
    }
}