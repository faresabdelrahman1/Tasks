package Service;

import Model.Account;

public interface AccountServices {
   boolean createAccount(Account account);
   Account searchAccount(String userName,String password);
   boolean withdraw(Account account,double amount);
   boolean deposit(Account account,double amount);
   boolean transfer(Account account,String userNameTransfer,double amount);
}
