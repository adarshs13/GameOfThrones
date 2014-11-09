import java.awt.Rectangle;

public class Stark extends NorthHouse {

    /**
    * This is the Class constructor takes in two ints and a Rectangle. It then
    * passes those values along with the House specific values to the super
    * class constructor.
    * @param xPos the x coordinate of the icon on the board
    * @param yPos the y coordinate of the icon on the board
    * @param bounds the rectangle that is the size of the board
    */
    public Stark(int xPos, int yPos, Rectangle bounds) {
        super("direwolf.png", 0, 35, xPos, yPos, 50, bounds);
    }

    @Override
    public boolean canReproduceWithHouse(House otherHouse) {
        int prob = (int) (Math.random() * 100) + 1;
        if (this.collidesWithHouse(otherHouse)
            && otherHouse instanceof Tully && prob <= 17) {
            return true;
        }
        return false;
    }

    @Override
    public House reproduceWithHouse(House otherHouse) {
        if (this.canReproduceWithHouse(otherHouse)) {
            return new Stark(xPos, yPos, bounds);
        }
        return null;
    }

    @Override
    public boolean canHarmHouse(House otherHouse) {
        int prob = (int) (Math.random() * 10) + 1;
        if (this.collidesWithHouse(otherHouse)
            && otherHouse instanceof Lannister && prob <= 4) {
            return true;
        }
        return false;
    }

    @Override
    public void harmHouse(House otherHouse) {
        if (this.canHarmHouse(otherHouse)) {
            otherHouse.health -= 5;
        }
    }
}
