/**
 * This class is the abstract House for the Game of Thrones Simulation.
 * @author Adarsh Suresh
 * @version 1.0
 */
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class House {

    protected int age;
    protected int maxAge;
    protected int xPos;
    protected int yPos;
    protected int health;
    protected Rectangle bounds;
    protected Rectangle iconBound;

    protected ImageIcon image;
    protected String imageFilename;

    /**
    * This is the Class constructor it takes in a string, five ints,
    * and one Rectangle.
    * @param imageFilename the name of the file that will be displayed for the
    * house
    * @param age the staring age of the house
    * @param maxAge the maximum age to which a house can live
    * @param xPos the x coordinate of the icon on the board
    * @param yPos the y coordinate of the icon on the board
    * @param health the starting amount of health for the House
    * @param bounds the rectangle that is the size of the board
    */
    public House(String imageFilename, int age, int maxAge,
        int xPos, int yPos, int health, Rectangle bounds) {
        this.image = new ImageIcon(imageFilename);
        this.imageFilename = imageFilename;
        this.age = age;
        this.maxAge = maxAge;
        this.xPos = xPos;
        this.yPos = yPos;
        this.health = health;
        this.bounds = bounds;
        iconBound = new Rectangle(xPos, yPos,
            image.getIconWidth(), image.getIconHeight());
    }

    /**
     * This method takes in a Graphics object and draws the icons to the board.
     * The method does not return anything.
     * @param g the Graphic drawn on the board.
     */
    protected void draw(Graphics g) {
        image.paintIcon(null, g, iconBound.x, iconBound.y);
    }

    /**
     * This method moves the each instance of a house to a random location,
     * increments the age, decrements the health of the House,
     * and adds functionaltiy specific to a region or house.
     */
    public abstract void move();

    /**
     * This method method takes in a House and checks to see if the Rectangle
     * bounding the House is touching another House's Rectangle. The method
     * returns a boolean.
     * @param otherHouse the other House checked to see if there is a collision
     * @return a boolean. True if two houses are touching. Other wise false.
     */
    public boolean collidesWithHouse(House otherHouse) {
        if (this.iconBound.intersects(otherHouse.iconBound)) {
            return true;
        }
        return false;
    }

    /**
      * This method method takes in a House and checks to see if the two
      * touching houses can reproduce. The method returns a boolean.
      * @param otherHouse the other House checked to see if reproduction is
      * possible based on type of House and probability
      * @return a boolean. True if two houses can reproduce
      */
    public abstract boolean canReproduceWithHouse(House otherHouse);

    /**
      * This method method takes in a House and if reproduction is possible,
      * it returns a new instance of the House touched by otherHouse.
      * @param otherHouse the other House checked to see if reproduction is
      * possible
      * @return a House. A new instance of the House reproducing
      */
    public abstract House reproduceWithHouse(House otherHouse);

    /**
     * This method method checks if a House is old, meaning its age is over some
     * maximum age and the maximum age is not negative.
     * @return a boolean. True if the House is older than the maximum age for
     * its class and the max age is not negative. Otherwise it returns false.
     */
    public boolean isOld() {
        if (age > maxAge && !(maxAge < 0)) {
            return true;
        }
        return false;
    }

    /**
     * This method method takes in a House and checks to see if the House
     * can harm the other House.
     * @param otherHouse the other House checked to see if it can be hurt
     * @return a boolean. True if otherHouse can be hurt. Otherwise false.
     */
    public abstract boolean canHarmHouse(House otherHouse);

    /**
    * This method harms the other House and returns nothing.
    * @param otherHouse the House that gets hurt if it can be hurt by the House
    * it is touching.
    */
    public abstract void harmHouse(House otherHouse);

    /**
    * This method kills the other House by setting its health value to zero.
    * It returns nothing.
    */
    public void die() {
        health = 0;
    }

    /**
    * This method checks if a House id dead.It returns a boolean.
    * @ return a boolean. Returns true if the health of the House is less than
    * or equal to zero. Otherwise it returns false.
    */
    public boolean isDead() {
        if (health <= 0) {
            return true;
        }
        return false;
    }
}
