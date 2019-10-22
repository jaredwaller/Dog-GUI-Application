
import java.time.LocalDate;


public class Rental {
    
    private String dogID;
    private String dogName;
    private LocalDate checkoutDate;
    private LocalDate returnDate;

    public Rental(String dogID, String dogName, LocalDate checkoutDate) {
        this.dogID = dogID;
        this.dogName = dogName;
        this.checkoutDate = checkoutDate;
    }
    
    public Rental(String dogID, String dogName, LocalDate checkoutDate, LocalDate returnDate) {
        this.dogID = dogID;
        this.dogName = dogName;
        this.checkoutDate = checkoutDate;
        this.returnDate = returnDate;
    }
    
    @Override
    public String toString()
    {
        return this.dogName;
    }
    
    public String getDogID() {
        return dogID;
    }

    public void setDogID(String dogID) {
        this.dogID = dogID;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    
    
    

}
