import java.util.*;
import java.io.*;

public class ba{
    public static void main(String[] args) {
        bankAccount obj = new bankAccount("Krish", "000001");
        obj.menu();
    }
}
class bankAccount{
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    bankAccount(String cName, String cID){
        customerName = cName;
        customerID = cID;
    }
    
    void deposit(int amount)
    {
        if(amount!=0){
            balance += amount;
            previousTransaction = amount;
        }
        }
        void withdraw(int amount)
        {
            if(amount!=0){
                balance -= amount;
                previousTransaction = -amount;
            }
        }
        void getPreviousTransaction()
        {
            if(previousTransaction>0){
                System.out.println("Deposited: " + previousTransaction);
            }
            else if(previousTransaction<0){
                System.out.println("Withdrawn:" + Math.abs(previousTransaction));
            }
            else{
                System.out.println("No transactions yet");
        }
    }
    void menu()
    {
        char option = '\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerID);
        System.out.println("\n");
        System.out.println("A: Check your balance");
        System.out.println("B: Deposit");
        System.out.println("C: Withdraw");
        System.out.println("D: Your previous transaction");
        System.out.println("E: Exit");
        do
        {
            System.out.println("******************************");
            System.out.println("Select an option");
            System.out.println("******************************");
            option = sc.next().charAt(0);
            System.out.println("\n");
            switch(option){
                case 'A':
                System.out.println("******************************");
                System.out.println("Balance: " + balance);
                System.out.println("******************************");
                System.out.println("\n");
                break;
                case 'B':
                System.out.println("******************************");
                System.out.println("Enter the amout you want to deposit: ");
                System.out.println("******************************");
                int amount = sc.nextInt();
                deposit(amount);
                System.out.println("\n");
                break;
                case 'C':
                System.out.println("******************************");
                System.out.println("Enter the amount you want to withdraw: ");
                System.out.println("******************************");
                int amountOne = sc.nextInt();
                if(amountOne>balance){
                    System.out.println("Please enter a smaller amount");
                }
                else{
                withdraw(amountOne);
                System.out.println("\n");
                }
                break;
                case 'D':
                System.out.println("******************************");
                getPreviousTransaction();
                System.out.println("******************************");
                System.out.println("\n");
                break;
                default:
                System.out.println("Invalid option! Please enter a valid option.");
            }
        }
        while(option!='E');
            System.out.println("Thank you for using our services");
    }
}
