import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BudgetManager manager = new BudgetManager(0);

        manager.loadData();

        if (manager.getTotalMoney() == 0 && manager.getTransactions().isEmpty()) {
            System.out.println("Account opened for the first time! Welcome please deposit your money: ");
            Scanner sc = new Scanner(System.in);
            double initialDepositAmount = sc.nextDouble();
            System.out.print("Description: ");
            String initialDescription = sc.next();
            System.out.println("Secret note (if not leave it blank): ");
            String initialNote = sc.next();

            Transaction initialDeposit = new Transaction(initialDepositAmount, initialDescription, initialNote);
            manager.addIncome(initialDeposit);
        }

        System.out.println("\n=== BANK ACCOUNT SUMMARY ===");
        System.out.println("Current Balance: " + manager.getTotalMoney() + " TL");
        manager.showExpenses();

        System.out.println("\n-> Performing new transactions...");

        Transaction expense = new Transaction(300, "Secret Note", "Market Shopping");
        Transaction gain = new Transaction(100, "Secret Note", "Crypto Profit");

        manager.addExpenses(expense);
        manager.addIncome(gain);

        System.out.println("\nNew Balance After Transactions: " + manager.getTotalMoney() + " TL");
        manager.saveData();
    }
}