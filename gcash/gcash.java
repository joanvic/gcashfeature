import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class gcash {
    static List<String> pinInput = new ArrayList<String>();
    static List<Long> mNumber = new ArrayList<Long>();
    static List<Long> pNumber = new ArrayList<Long>();
    static List<String> Mmessage = new ArrayList<String>();

    public static double balance, mAmount, bills;

    public static void main(String[] args) {
        MyPin();
        LogIn();
    }

    static void MyPin() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("-------------------------------------------------");
            System.out.println("|To create a pin input 4 combination of a number |");
            System.out.println("-------------------------------------------------");
            System.out.println("Input your combination");
            String input = scanner.nextLine();
            pinInput.add(input);

            System.out.println("Successfully Added!");
            System.out.println("");
            System.out.println("------------------------------");
            System.out.println("|      Enter your MPIN        |");
            System.out.println("------------------------------");
            String mypin = scanner.nextLine();

            if (!mypin.equals(input)) {
                System.out.println("You inputted the wrong combination! create again!");
                MyPin();
            } else {
                MyBalance();
            }
        } catch (Exception e) {
            System.out.println("Invalid Input!");
            MyPin();
        }
    }

    static void MyBalance() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("-------------------------------------------------");
            System.out.println("|             GCash Hello!                       |");
            System.out.println("-------------------------------------------------");
            System.out.println("Enter your balance: ");
            balance = Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid Input!");
            MyBalance();
        }
    }

    static void LogIn() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("-------------------------------------------------");
            System.out.println("|             Available Balance                  |");
            System.out.println("-------------------------------------------------");
            System.out.println("$ " + balance);
            System.out.println("1. Send");
            System.out.println("2. Bill");
            System.out.println("3. Transactions");
            System.out.println("4. Exit");
            System.out.println("Enter your choice");
            String choices = scanner.nextLine();

            if (choices.equals("1")) 
            {
                        System.out.println("-------------------------------------------------");
                        System.out.println("|                 Express Send                   |");
                        System.out.println("-------------------------------------------------");
                        System.out.println("Send to");
                        System.out.println("Enter your mobile number");
                        long mobilenum = Long.parseLong(scanner.nextLine());
                        mNumber.add(mobilenum);
        
                        System.out.println("-------------------------------------------------");
                        System.out.println("Amount");
                        System.out.println("Available Balance: PHP " + balance);
                        System.out.print("Enter your amount: ");
                        mAmount = Double.parseDouble(scanner.nextLine());
                        if (mAmount <= balance) 
                        {
                                System.out.println("-------------------------------------------------");
                                System.out.println(mobilenum);
                                System.out.println("GCash                    " + balance);
                                System.out.println("You're about to send");
                                System.out.println("Amount                   " + mAmount);
                                System.out.println("-------------------------------------------------");
                                System.out.println("Total                    " + mAmount);
                                System.out.println("Type Pay if you want to continue");
                                String pay = scanner.nextLine();
            
                                if (pay.equals("Pay") || pay.equals("pay")) 
                                
                                    {
                                        System.out.println("-------------------------------------------------");
                                        System.out.println("|                  Payment                       |");
                                        System.out.println("-------------------------------------------------");
                                        System.out.println("✓ Successfully Sent with current request settings.");
                                    
                                        balance -= mAmount;
                                        System.out.println("✓ Successfully Sent!");
                                        System.out.println("New Balance: PHP " + balance);
                                        Mmessage.add("You have sent PHP " + mAmount + " to " + mobilenum);
                                        LogIn();
                                     } 
                                    
                                else 
                                {
                                    System.out.println("Invalid input! Please try again.");
                                    LogIn();
                                }
                        } 
                
                else
                {
                    System.out.println("Insufficient balance! Please try again.");
                    LogIn();
                }
            } 
            
            else if (choices.equals("2")) {
                System.out.println("-------------------------------------------------");
                System.out.println("|                    Bill                        |");
                System.out.println("-------------------------------------------------");
                System.out.println("Enter your Bill: ");
                bills = Double.parseDouble(scanner.nextLine());
                if (bills <= balance) {
                    System.out.println("-------------------------------------------------");
                    System.out.println("|                    Payment                     |");
                    System.out.println("-------------------------------------------------");
                    System.out.println("✓ Successfully paid your bill!");
                    balance -= bills;
                    System.out.println("New Balance: PHP " + balance);
                    Mmessage.add("You have paid a bill of PHP " + bills);
                    LogIn();
                } else {
                    System.out.println("Insufficient balance! Please try again.");
                    LogIn();
                }
            } else if (choices.equals("3")) {
                System.out.println("-------------------------------------------------");
                System.out.println("|                 Transactions                   |");
                System.out.println("-------------------------------------------------");
                for (int i = 0; i < Mmessage.size(); i++) {
                    System.out.println(Mmessage.get(i));
                }
                LogIn();
            } else if (choices.equals("4")) {
                System.out.println("Exiting...");
                System.exit(0);
            } else {
                System.out.println("Invalid Input! Please try again.");
                LogIn();
            }
        } catch (Exception e) {
            System.out.println("Invalid Input!");
            LogIn();
        }
    }
}
                        