package Service.ServiceImplementation;
import Model.Account;
import Model.Ewallatsystem;
import Service.AccountServices;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AccountServicesImpl implements AccountServices {
    private Ewallatsystem ewallatsystem = new Ewallatsystem();
    Scanner input = new Scanner(System.in);

//    @Override
//    public boolean createAccount(Account account) {
//        for (Account account1 : ewallatsystem.getAccount()) {
//            if (account1.getUserName().equals(account.getUserName())) {
//                System.out.println("the account is already exist");
//                return false;
//            }
//        }
//        ewallatsystem.getAccount().add(account);
//        return true;
//    }
//
//    @Override
//    public Account searchAccount(Account account) {
//        for (Account account1 : ewallatsystem.getAccount()) {
//            if (account1.getUserName().equals(account.getUserName()) && account1.getPassword().equals(account.getPassword())) {
//                System.out.println("your account is found");
//                return account1;
//            }
//        }
//        System.out.println("your account isn't found");
//        return null;
//    }

    public boolean deposit(Account account, double amount) {
        Account existingAccount = ewallatsystem.getAccount(account.getUserName());
        if (existingAccount == null) {
            return false; // الحساب مش موجود
        }
        if (amount <= 0) {
            return false; // لازم يكون المبلغ موجب
        }
        existingAccount.setBalance(existingAccount.getBalance() + amount);
        return true;
    }



    //COLLECTION
    private Map<String, Account> accounts = new HashMap<>();

    public boolean createAccount(Account account) {
        if (accounts.containsKey(account.getUserName())) {
            System.out.println("the account already exists");
            return false;
        }
        accounts.put(account.getUserName(), account);
        return true;
    }

    public Account searchAccount(String userName, String password) {
        Account acc = accounts.get(userName);
        if (acc != null && acc.getPassword().equals(password)) {
            return acc;
        }
        return null;
    }

    @Override
    public boolean withdraw(Account account, double amount) {
        List<Account> accounts = ewallatsystem.getAccount();
        int accountIndex = -1;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUserName().equals(account.getUserName())) {
                accountIndex = i;
                break;
            }
        }
        if (accountIndex == -1) {
            return false;
        }
        Account existedAccount = ewallatsystem.getAccount().get(accountIndex);
        if (existedAccount.getBalance() < amount) {
            return false;
        }
        existedAccount.setBalance(existedAccount.getBalance() - amount);
        return true;
    }


//    @Override
//    public boolean deposit(Account account, double amount) {
//        List<Account> accounts = ewallatsystem.getAccount();
//        int accountIndex = -1;
//        for (int i = 0; i < accounts.size(); i++) {
//            if (accounts.get(i).getUserName().equals(account.getUserName())) {
//                accountIndex = i;
//                break;
//            }
//        }
//        if (accountIndex == -1) {
//            return false;
//        }
//        double newBalance = ewallatsystem.getAccount().get(accountIndex).getBalance() + amount;
//        ewallatsystem.getAccount().get(accountIndex).setBalance(newBalance);
//        return true;
//    }

    @Override
    public boolean transfer(Account account,String userNameTransfer, double amount) {

        List<Account>accounts=ewallatsystem.getAccount();
        int accountIndex=-1;
        int accountTransferIndex=-1;
        for (int i=0;i<accounts.size();i++){
           if (accounts.get(i).getUserName().equals(account.getUserName())){
               accountIndex=i;
           }
           if (accounts.get(i).getUserName().equals(userNameTransfer)){
               accountTransferIndex=i;
           }
        }
        if (accountIndex==-1||accountTransferIndex==-1||userNameTransfer.equals(accounts.get(accountIndex).getUserName())){
            return false;
        }
 boolean isValidBalance= accounts.get(accountIndex).getBalance()<amount;
        if (isValidBalance){
            return false;
        }
        accounts.get(accountIndex).setBalance(accounts.get(accountIndex).getBalance()-amount);

        accounts.get(accountTransferIndex).setBalance(accounts.get(accountTransferIndex).getBalance()+amount);


        return true;
    }
}