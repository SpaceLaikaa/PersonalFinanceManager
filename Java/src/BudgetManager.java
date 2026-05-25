import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BudgetManager {
    private double totalMoney;
    private List<Transaction> transactions = new ArrayList<>();

    public double getTotalMoney() {return totalMoney;}
    public List<Transaction> getTransactions() {return transactions;}

    public void setTotalMoney(double totalMoney) {this.totalMoney = totalMoney;}
    public void setTransactions(List<Transaction> transactions) {this.transactions = transactions;}

    public void addExpenses(Transaction transaction){
        if (transaction == null || transaction.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be bigger than 0 or Transaction list cannot be empty");
        }
        totalMoney -= transaction.getAmount();
        transactions.add(transaction);
    }

    public void saveData(){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("transaction.ser"))){
            out.writeObject(transactions);
        } catch (IOException e){
            System.out.println("File error while saving: "+e.getMessage());
        }
    }

    public void loadData(){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("transaction.ser"))){
            transactions = (List<Transaction>) in.readObject();
        } catch (IOException e){
            System.out.println("File error while saving: "+e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
