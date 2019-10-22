
import javax.swing.DefaultListModel;


public class Customer {
    
    private String email;
    private DefaultListModel<Rental> rentals = new DefaultListModel<Rental>();

    public Customer(String email) {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return email;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DefaultListModel getRentals() {
        return rentals;
    }

    public void setRentals(DefaultListModel rentals) {
        this.rentals = rentals;
    }
    
    public Rental getFirstRental()
    {
        return rentals.getElementAt(0);
    }
    

}
