import java.util.*;
public class ATM_COMPLETE_PROJECT {
    public static void main(String[] args) {
        int pin=2004;
        int balance=100000;
        int Addamount=0;
        int Takeamount=0;

        String name;

        Scanner s=new Scanner(System.in);


        // we have to take an input by an user
        System.out.println("Enter your pin number : ");

        int password=s.nextInt();

        if(password==pin)
        {
            System.out.println("Enter your name");
            name=s.next();
            System.out.println("Welcome "+name);

            while(true)
            {
                System.out.println("Press 1 to check your balance");
                System.out.println("press 2 to add amount");
                System.out.println("press 3 to take amount");
                System.out.println("press 4 to take receipt");
                System.out.println("press 5 to EXIT");

                int option=s.nextInt();
                switch(option)
                {
                    case 1:
                        System.out.println("Your current balance is "+balance);
                        break;

                    case 2:
                        System.out.println("How much amount did you want to add to your account");
                        Addamount=s.nextInt();
                        System.out.println("Successfully credited");
                        balance=Addamount+balance;  // 100000=1000+100000=101000
                        break;

                    case 3:
                        System.out.println("How much amount did you want to take ");
                        Takeamount=s.nextInt();
                        if(Takeamount>balance)
                        {
                            System.out.println("Insufficient balance in your account");
                            System.out.println("Try less than your available current balance");
                        }
                        else
                        {
                            System.out.println("Successfully the amount was taken");
                            balance=balance-Takeamount; // 100000=100000-5000=95000

                        }
                        break;

                    case 4:
                        System.out.println("Welcome to All in one 24 hrs mini ATM");
                        System.out.println("Available balance is "+balance);
                        System.out.println("Amount deposit "+Addamount);
                        System.out.println("Taken amount "+Takeamount);
                        System.out.println("Thank you for visiting our atm!");
                        break;

                        // Here default case is not required for this process
                }
                if(option==5)
                {
                    System.out.println("Thank you!");
                    break;
                }
            }
        }
        else {
            System.out.println("Wrong pin_numer");
            System.out.println("Enter the correct pin number");
        }

    }
}
