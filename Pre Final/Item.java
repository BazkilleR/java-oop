import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents an item with an ID, name, price, and timestamp.
 */
public class Item implements Serializable {

    private int id;
    private String name;
    private double price;
    private LocalDateTime time;

    /**
     * Default constructor initializes an item with default values and current timestamp.
     */
    public Item() {
        this(0, "", 0.0);
    }

    /**
     * Parameterized constructor initializes an item with specified values.
     * @param id The item ID
     * @param name The item name
     * @param price The item price
     */
    public Item(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.time = LocalDateTime.now(); // Automatically assigns the current timestamp
    }

    /**
     * Gets the item ID.
     * @return The item ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the item ID.
     * @param id The new item ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the item name.
     * @return The item name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the item name.
     * @param name The new item name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the item price.
     * @return The item price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the item price.
     * @param price The new item price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the creation timestamp.
     * @return The timestamp of when the item was created
     */
    public LocalDateTime getTime() {
        return time;
    }

    /**
     * Sets a custom timestamp for the item.
     * @param time The new timestamp
     */
    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    /**
     * Returns the formatted timestamp as a string.
     * @return The timestamp in "dd/MM/yyyy" format
     */
    public String getFormattedTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return time.format(formatter);
    }
}
