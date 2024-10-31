public class Enviroment {
    private int temperature;
    private int humidity;
    private int waterSupply;

    public Enviroment(int temperature, int humidity, int waterSupply) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.waterSupply = waterSupply;
    }

    public Enviroment() {
        this.temperature = 20;
        this.humidity = 50;
        this.waterSupply = 100;
    }

    public void changeWeather() {
        temperature += (int) (Math.random() * 10 - 5);
        humidity += (int) (Math.random() * 20 - 10);
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getWaterSupply() {
        return waterSupply;
    }

    public void setWaterSupply(int waterSupply) {
        this.waterSupply = waterSupply;
    }
}
