import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<customer> customers = new ArrayList<>();
            customer c1 = new customer("1`", "Parth", "Koshti", "kavishnag13@gmail.com", "9829334567", "Pune", "12345678910", "ABCDEFGHIJK");
            customer c2 = new customer("2", "Kavish", "Nag", "kavish.nag@gmail.com", "9876534567", "Pune", "98765432109", "XYZABCDEFGH");
            customer c3 = new customer("3", "krrish", "koshti", "krrish.koshti@gmail.com", "9123345678", "Pune", "12341234123", "PQRSTUVWXYZ");
            customers.add(c1);
            customers.add(c2);
            customers.add(c3);
            ArrayList<Account> accounts = new ArrayList<>();
            SavingsAccount sa1 = new SavingsAccount(1001, 500, c1); // Set low balance to trigger exception
            CurrentAccount ca1 = new CurrentAccount(2001, 30000, c1);
            accounts.add(sa1);
            accounts.add(ca1);
            SavingsAccount sa2 = new SavingsAccount(1002, 5000, c2);
            CurrentAccount ca2 = new CurrentAccount(2002, 150000, c2);
            accounts.add(sa2);
            accounts.add(ca2);
            SavingsAccount sa3 = new SavingsAccount(1003, 8000, c3);
            accounts.add(sa3);
            // Now accounts is defined, so demonstrate InvalidAccountException here
            try {
                Account invalidAcc = findAccountByNumber(accounts, 9999); // 9999 does not exist
                invalidAcc.deposit(100);
            } catch (InvalidAccountException e) {
                System.out.println("Exception: " + e.getMessage());
            }
            System.out.println("\n Performing Transactions \n");
            sa1.deposit(200); // Balance now 700
            sa1.withdraw(100); // Balance now 600
            sa1.calculateInterest();
            sa1.printTransactionHistory();
            System.out.println();
            Loan loan = new Loan(12000, 12);
            loan.displayLoan();
            // This EMI is 1000, which is more than sa1's balance (600), so exception will be triggered
            loan.payEMI(sa1);
            System.out.println("\n Customer and Account summary:\n");
            displayInfo(customers, accounts);
        } catch(InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    public static Account findAccountByNumber(ArrayList<Account> accounts, int accNumber) throws InvalidAccountException {
        for (Account acc : accounts) {
            if (acc.accountNumber == accNumber) {
                return acc;
            }
        }
        throw new InvalidAccountException("Account number " + accNumber + " not found.");
    }

    public static void displayInfo(ArrayList<customer> customers, ArrayList<Account> accounts) {
        for(customer cust : customers) {
            System.out.println("---- CUSTOMER DETAILS ----");
            cust.displayCustomer();
            System.out.println("\n---- ACCOUNTS ----");
            double totalBalance = 0;
            int accountCount = 0;
            for(Account acc : accounts) {
                if(acc.customer.customerID.equals(cust.customerID)) {
                    System.out.println("Account Number: " + acc.accountNumber);
                    System.out.println("Account Type: " + acc.getClass().getSimpleName());
                    System.out.println("Balance: Rs. " + acc.balance);
                    acc.printTransactionHistory();
                    totalBalance += acc.balance;
                    accountCount++;
                    System.out.println();
                }
            }
        }
    }
}
