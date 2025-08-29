package Service.ServiceImplementation;
import Model.Account;
import Service.AccountServices;
import Service.AccountValidationService;
import Service.ApplicationServices;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class ApplicationImplementation implements ApplicationServices {
            Scanner input=new Scanner(System.in);
            AccountServices accountServices=new AccountServicesImpl();
            AccountValidationService accountValidationService=new AccountValidationServiceImpl();
    public void startApp(){
        System.out.println("--------hi sir-------");

        int counter=0;
        while (true){
            boolean isExit =false;
            System.out.println("please choose");
            System.out.println("a.Login      b.SignUP      c.Exit");
            char choose=input.next().charAt(0);
            switch (choose){

                case 'a':
                    login();
                    break;

                case 'b':
                   signUp();
                    break;

                case 'c':
                    System.out.println("Have a nice day");
                    isExit=true;
                    break;

                default:
                    System.out.println("invalid input");
                    counter++;
            }
            if(counter==4){
                System.out.println("please try after five min");
            }
            if(isExit){
                break;
            }

        }

    }

    private void login(){
        System.out.println("please enter username");
        String username=input.next();
        System.out.println("please enter password");
        String password=input.next();
        Account account =accountServices.searchAccount(username,password);
        if(Objects.nonNull(account)){
            System.out.println("you have been login successfully ");
           mainProfile(account);
        }
        else {System.out.println("username or password is wrong");}

    }
       private void signUp() {
           int tries = 0;
           String username;
           String password;
           String phoneNumber;
           while (true) {
               System.out.println("please enter username");
                username = input.next();
               if (accountValidationService.isValidateUsername(username)) {
                   break;
               } else {
                   System.out.println("please try again");
               }

           }

           while (true) {
               System.out.println("please enter password");
                password = input.next();
               if (accountValidationService.isValidatePassword(password)) {
                   break;
               } else {
                   tries++;
                   if (tries > 5) {
                       System.out.println("please try again later");
                       return;
                   }
                   System.out.println(" password must include upper case, lower case , number , [@#$%&^*_+)(!]'\n' and size must be >= 10");
               }
           }
           while (true) {
               System.out.println("please enter phone number");
                phoneNumber = input.next();
               if (accountValidationService.isValidatePhoneNumber(phoneNumber)){
                break;
               }
               else {
                   System.out.println("Invalid phoneNumber please try again");
               }
           }


            Account account = new Account(username, password, phoneNumber);
            if (accountServices.createAccount(account)) {
                System.out.println("Account created success");
            }
            else {
                System.out.println("your userName is already exist on system");
            }


    }



    private void mainProfile(Account account){
        while (true){
            boolean isExist=false;
            System.out.println("1.withdraw   2.Deposit   3.ShowDetails   4.Transfer   5.LoggOut");
            int choose =input.nextInt();
            switch (choose) {
                case 1:
                    withDraw(account);
                    break;

                case 2:
                    Deposit(account);
                    break;
                case 3:
                    ShowDetails(account);
                    break;
                case 4:
                    Transfer(account);
                    ShowDetails(account);

                    break;
                case 5:
                    System.out.println("logging Out...");
                    isExist = true;
                    break;
                default:
                    System.out.println("invalid input");
            }

            if (isExist){
                break;
            }
        }
    }

    void withDraw(Account account){
        System.out.println("please enter the amount that's you need withdraw");
        double amount=input.nextDouble();
       if (accountServices.withdraw(account,amount)){
           System.out.println("success withdraw");
        }
       else {
           System.out.println("withdraw failed");
       }
    }
    void Deposit(Account account){
        System.out.println("please enter the amount that's you need deposit");


        //try and catch;
        try {
            double amount = input.nextDouble();


        if(accountServices.deposit(account,amount)){
            System.out.println("success deposit");
        }
        else {
            System.out.println("deposit failed");
        }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please enter a number");
            input.nextLine(); // clear buffer
        }
    }

    void ShowDetails(Account account){
        account=accountServices.searchAccount(account.getUserName(),account.getPassword());
        System.out.println("username =>"+account.getUserName());
        System.out.println("password =>"+account.getPassword());
        System.out.println("phone number =>"+account.getPhoneNumber());
        System.out.println("balance =>"+account.getBalance());
    }

    void Transfer(Account account){
        System.out.println("enter the amount that's you need send");
         double amount=input.nextDouble();
         System.out.println("please enter the userName that's you need send to ");
         String userNameTransfer=input.next();
        if( accountServices.transfer(account,userNameTransfer,amount)){
        System.out.println("success transfer");
        }
        else {
            System.out.println("transfer failed");
        }
    }
}
