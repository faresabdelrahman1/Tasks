package Model;
import java.util.*;
public class Ewallatsystem {
    private final String name="E Wallet System";
   private List<Account> account=new ArrayList<>();

    private Map<String, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getUserName(), account);
    }

    public Account getAccount(String userName) {
        return accounts.get(userName);
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccount(List<Account> account){
        this.account=account;
    }
    public List<Account> getAccount(){
        return account;
    }
    String getName(){
        return name;
    }
}
