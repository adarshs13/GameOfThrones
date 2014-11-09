import java.awt.Rectangle;

public abstract class SouthHouse extends House {

    protected static final double SPEED_BONUS = 1.5;

    /**
    * This is the Class constructor it takes in a string, five ints,
    * and one Rectangle. This constructor also checks if the click to provide
    * the location or the House is out of bounds. If it is, the image is shifted
    * up or to the left to bring it in bounds. It passes the values to the super
    * class constructor.
    * @param imageFilename the name of the file that will be displayed for the
    * house
    * @param age the staring age of the house
    * @param maxAge the maximum age to which a house can live
    * @param xPos the x coordinate of the icon on the board
    * @param yPos the y coordinate of the icon on the board
    * @param health the starting amount of health for the House
    * @param bounds the rectangle that is the size of the board
    */
    public SouthHouse(String imageFilename, int age, int maxAge, int xPos,
                int yPos, int health, Rectangle bounds) {
        super(imageFilename, age, maxAge, xPos, yPos, health, bounds);
        if (yPos > bounds.height - iconBound.height) {
            yPos = bounds.height - iconBound.height - 1;
            iconBound.setLocation(xPos, yPos);
        }
        if (xPos > bounds.width - iconBound.width) {
            xPos = bounds.width - iconBound.width - 1;
            iconBound.setLocation(xPos, yPos);
        }
    }

    @Override
    public void move() {
        int x = (int) ((Math.random() * 20) - 10);
        int y = (int) ((Math.random() * 20) - 10);

        if (yPos > (bounds.getHeight() / 2)) {
            x *= SPEED_BONUS;
            y *= SPEED_BONUS;
        }

        iconBound.translate(x, y);
        if (!bounds.contains(iconBound)) {
            iconBound.translate(-x, -y);
        }
        age++;
        health--;
    }
}
