import java.io.Serializable;

public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L; // This is mandatory for serializable classes and programs

    private double amount;
    private String note;

    private transient String secretNote; //To learn and observe transient

    public double getAmount() {return amount;}
    public String getSecretNote() {return secretNote;}
    public String getNote() {return note;}

    public void setAmount(double amount) {this.amount = amount;}
    public void setNote(String note) {this.note = note;}
    public void setSecretNote(String secretNote) {this.secretNote = secretNote;}

    public Transaction(double amount, String secretNote, String note) {
        this.amount = amount;
        this.secretNote = secretNote;
        this.note = note;
    }
}
