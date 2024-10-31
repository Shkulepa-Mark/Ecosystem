public class Animal {
    private static int idCounter = 1;
    private int id;
    private String species;
    private int age;
    private int health; // 0 - 100
    private int hungerLevel;

    public Animal(String spicies, int age, int health, int hungerLevel) {
        this.id = idCounter++;
        this.species = spicies;
        this.age = age;
        this.health = health;
        this.hungerLevel = hungerLevel;
    }

    public void eat() {
        hungerLevel--;
        System.out.println(species + "ate");
    }

    public void starve() {
        hungerLevel += 10;

        if (hungerLevel >= 100) {
            health -= 10;
            if (health <= 0) {
                System.out.println(species + " has died of hunger");
            }
        }
    }

    public Animal reproduce() {
        if (age > 2 && health > 50) {
            System.out.println(species + " has reproduced.");
            return new Animal(species, 0, 100, 0);
        }
        return null;
    }

    public void increaseAgeOneYear() {
        age++;
        health -= 5;
    }

    public void decreaseHealth(int amount) {
        health -= amount;

        if (health <= 0) {
            health = 0;
            System.out.println(species + " has died.");
        }
    }

    private void adaptToEnviroment(int temperature, int humidity) {
        if (temperature < 10) {
            health -= 10;
        } else if (temperature > 35) {
            health -= 15;
        }

        if (humidity < 30) {
            hungerLevel += 5;
        }

        if (health < 0) {
            health = 0;
        }
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Species: " + species + " [age = " + age + ", health = " + health + ", hunger = " + hungerLevel + "]";
    }
}
