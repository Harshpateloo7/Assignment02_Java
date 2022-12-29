/**
 * Chicken class is model class which has isHappy,isAlive, name, heart, seeds property and method of the class.
 *
 * @author Harshadkumar Patel, 000852665
 */

public class Chicken {
    private boolean isHappy;
    private boolean isAlive;
    private String name;
    private int heart;
    private double seeds;

    //This method is used to initialize data
    public void initData(boolean isHappy, boolean isAlive, String name, int heart, double seeds) {
        this.isHappy = isHappy;
        this.isAlive = isAlive;
        this.name = name;
        this.heart = heart;
        this.seeds = seeds;
    }

    public boolean isHappy() {
        return isHappy;
    }

    public void setHappy(boolean happy) {
        isHappy = happy;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeart() {
        return heart;
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }

    public double getSeeds() {
        return seeds;
    }

    public void setSeeds(double seeds) {
        this.seeds = seeds;
    }
}
