import Model.Account;
import Service.AccountServices;
import Service.ApplicationServices;
import Service.ServiceImplementation.AccountServicesImpl;
import Service.ServiceImplementation.ApplicationImplementation;

public class Main {
    public static void main(String[]args){

        ApplicationServices object=new ApplicationImplementation();
        object.startApp();
    }
}
