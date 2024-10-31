public class Plant {
    private String species;
    private int height;
    private int waterNeed;

    public Plant(String species, int health, int waterNeed) {
        this.species = species;
        this.height = health;
        this.waterNeed = waterNeed;
    }

    public void grow() {
        height++;
        System.out.println(species + "grew up");
    }

    public void increaseWaterNeed(int amount) {
        waterNeed += amount;

        if (waterNeed >= 100) {
            waterNeed = 100;
        }
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
        return species + " [health = " + height + "waterNeed = " + waterNeed + "]";
    }
}
