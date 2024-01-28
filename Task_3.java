package codsoft;
import java.util.Scanner;
public class Task_3 {
    public static void main(String[]args){
        int balance=1000,withdraw,deposit;
        Scanner sc =new Scanner(System.in);
        while(true){
            System.out.println("Please insert your card.");
            System.out.println("Welcome to the ATM :)");
            System.out.println("1.Withdraw cash.");
            System.out.println("2.Deposit cash.");
            System.out.println("3.Check balance.");
            System.out.println("4.Exit.");
            System.out.println("Select the operation to be performed:");
            int n=sc.nextInt();
            switch(n){
                case 1:
                    System.out.println("Enter money to be withdrawn:");
                    withdraw=sc.nextInt();
                    if(balance>=withdraw){
                        balance-=withdraw;
                        System.out.println("Please collect your money");
                        System.out.println("Please remember to collect your card");
                    }
                    else{
                        System.out.println("Insufficient balance.Kindly check your balance.");
                    }
                    System.out.println(" ");
                    break;
                case 2:
                    System.out.println("Enter money to be deposited:");
                    deposit= sc.nextInt();
                    balance+=deposit;
                    System.out.println("Your money has been successfully deposited.Thank you :)");
                    System.out.println(" ");
                    break;
                case 3:
                    System.out.println("Your current balance is:"+balance);
                    System.out.println(" ");
                    break;
                case 4:
                    System.out.println("Exit.");
                default:
                    System.out.println("Kindly select an appropriate choice,Thank you!");
                    System.out.println(" ");
                    break;
            }
        }
    }
}
