public class Plant {
    private static int idCounter = 1;
    private int id;
    private String species;
    private int height;
    private int waterNeed;
    private FileManager fileManager = new FileManager();

    public Plant(String species, int health, int waterNeed) {
        this.id = idCounter++;
        this.species = species;
        this.height = health;
        this.waterNeed = waterNeed;
    }

    public void adaptToEnviroment(int temperature, int humidity, int waterAbility) {
        if (temperature < 15) {
            height -= 1;
            increaseWaterNeed(5);
        } else if (temperature > 30) {
            increaseWaterNeed(10);
        }

        if (humidity < 30) {
            increaseWaterNeed(10);
        } else if (humidity > 70) {
            decreaseWaterNeed(5);
        }

        if (waterAbility < waterNeed) {
            height -= 1;
            System.out.println(species + "dries up due to lack of water");
        } else {
            height += 1;
            System.out.println(species + " blooms with enough water");
        }
    }

    public void grow() {
        if (waterNeed < 50) {
            height++;
            System.out.println(species + "grew up");
        } else {
            System.out.println(species + "needs more water to grow");
        }
    }

    public void increaseWaterNeed(int amount) {
        waterNeed += amount;

        if (waterNeed >= 100) {
            waterNeed = 100;
            System.out.println(species + " is suffering from a lack of water!");
        }
    }

    public void decreaseWaterNeed(int amount) {
        waterNeed = Math.max(waterNeed - amount, 0);
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWaterNeed() {
        return waterNeed;
    }

    public void setWaterNeed(int waterNeed) {
        this.waterNeed = waterNeed;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Species: " + species + " [height = " + height + ", waterNeed = " + waterNeed + "]";
    }
}
