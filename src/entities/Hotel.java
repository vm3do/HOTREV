package entities;

public class Hotel {
    private String hotelId;
    private String name;
    private String address;
    private int availableRooms;
    private double rating;

    public Hotel(String hotelId, String name, String address, int availableRooms, double rating) {
        this.hotelId = hotelId;
        this.name = name;
        this.address = address;
        this.availableRooms = availableRooms;
        this.rating = rating;
    }

    public String getHotelId() { return hotelId; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public int getAvailableRooms() { return availableRooms; }
    public double getRating() { return rating; }

    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setAvailableRooms(int rooms) { this.availableRooms = rooms; }
    public void setRating(double rating) { this.rating = rating; }
}
