import java.util.Scanner;

public class Atmfile {
    static int AcountBalance = 1000000;
    static int NumberOfTransection = 0;
    static String TransectionHistory = "";

    public static void options() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("\n*******************************************************");
            System.out.println("1-->Withdraw");
            System.out.println("2-->Deposit");
            System.out.println("3-->Transfer");
            System.out.println("4-->Cheque Balance");
            System.out.println("5-->To Tansection history");
            System.out.println("0-->TO exist ");
            int Operation = sc.nextInt();
            switch (Operation) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    transfer();
                    break;
                case 4:
                    chequebalance();
                    break;
                case 5:
                    TransectionHistory();
                    break;
                default:
                    System.out.println("Invalid input: ");
            }
        }
    }

    public static void withdraw() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the amount you want to withdraw: ");
            int WAmount = sc.nextInt();
            if (WAmount <= AcountBalance) {
                AcountBalance = AcountBalance - WAmount;
                NumberOfTransection = NumberOfTransection + 1;
                String str = "Rs " + WAmount + " Withdraw\n";
                TransectionHistory = TransectionHistory.concat(str);
                System.out.println("Transaction completed: ");
                options();
            } else {
                System.out.println("Insufficient funds: ");
                options();
            }
        }
    }

    public static void deposit() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the amount you want to deposit: ");
            int DepostMoney = sc.nextInt();
            AcountBalance = AcountBalance + DepostMoney;
            NumberOfTransection = NumberOfTransection + 1;
            System.out.println(DepostMoney + " is deposited in your account: ");
            String str = "Rs " + DepostMoney + " Deposited to your account \n";
            TransectionHistory = TransectionHistory.concat(str);
            options();
        }
    }

    public static void transfer() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the receiver account number: ");
            int ReceiverAccountNo = sc.nextInt();
            System.out.print("Enter the amount you want to send: ");
            int SendingMoney = sc.nextInt();
            if (SendingMoney < AcountBalance) {
                NumberOfTransection = NumberOfTransection + 1;
                System.out.println("The amount sent successfully ");
                String str = "Rs " + SendingMoney + " Transferred to " + ReceiverAccountNo + " \n";
                TransectionHistory = TransectionHistory.concat(str);
                AcountBalance = AcountBalance - SendingMoney;
                options();
            } else {
                System.out.println("Insufficient Balance");
            }
        }
    }

    public static void chequebalance() {
        System.out.print("Your account has a Balance of: ");
        System.out.println(AcountBalance);
        options();
    }

    public static void TransectionHistory() {
        System.out.println("You have made " + NumberOfTransection + " Transactions");
        System.out.println("\n" + TransectionHistory);
        options();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("     WELCOME TO SBI PIN     ");
            System.out.println("1---> To Register ");
            System.out.println("0-----> To Exit ");
            int RegisterExist = sc.nextInt();
            System.out.println("****************************************************");
            if (RegisterExist == 1) {
                System.out.print("Enter your Name:  ");
                sc.nextLine();
                sc.nextLine();
                System.out.print("Enter your UserName:  ");
                sc.nextLine();
                System.out.print("Enter your Account Number:  ");
                int AccountNumber = sc.nextInt();
                System.out.print("Enter your 4 Digit PIN:  ");
                int Pin = sc.nextInt();
                System.out.println("-----REGISTRATION COMPLETED SUCCESSFULLY----");
                System.out.println("-----PLEASE LOGIN TO YOUR ACCOUNT-----");
                System.out.println("1----Login");
                System.out.println("0---->To Exit");
                int LoginExist = sc.nextInt();
                if (LoginExist == 1) {
                    System.out.print("Enter The correct Account number and pin:\n");
                    System.out.print("Enter your Account number: ");
                    int EnterAccountNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter your 4 Digit  PIN : ");
                    int EnterUserPin = sc.nextInt();
                    if (EnterAccountNumber == AccountNumber && EnterUserPin == Pin) {
                        options();
                    } else {
                        System.out.println("Wrong pin number or Account Number \n please Try again");
                    }
                } else if (LoginExist == 0) {
                    System.exit(0);
                } else {
                    System.out.println("Invalid input\n Try again");
                }
            } else if (RegisterExist == 0) {
                System.exit(0);
            } else {
                System.out.print("Invalid input: ");
            }
        }
    }
}
