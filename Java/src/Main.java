public class Main {
    public static void main(String[] args) {
        BudgetManager manager1 = new BudgetManager(2300);
        Transaction transaction1 = new Transaction(1600, "","Mouse");
        Transaction transaction2 = new Transaction(1000, "","Family");

        manager1.addExpenses(transaction1);
        manager1.addExpenses(transaction2);
        manager1.saveData();
        manager1.loadData();
        manager1.showExpenses();
        System.out.println(manager1.getTotalMoney());
    }
}
