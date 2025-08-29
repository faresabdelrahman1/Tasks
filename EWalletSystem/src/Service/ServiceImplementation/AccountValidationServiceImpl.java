package Service.ServiceImplementation;

import Service.AccountValidationService;

public class AccountValidationServiceImpl implements AccountValidationService {

    @Override
    public boolean isValidateUsername(String userName) {
        boolean isValid =true;
     if(!Character.isUpperCase(userName.charAt(0))){
       System.out.println("userName must start by upperCase letter");
       isValid= false;
     }

     if (userName.length()<3){
         System.out.println("userName must contain three or more letter");
         isValid= false;
     }

        return isValid;
    }

    @Override
    public boolean isValidatePassword(String password) {
        boolean isValid=true;
    if(password.length()<10){
        System.out.println("password size must be >= 10");
        isValid= false;
    }

    boolean hasUpperCase =false;
    boolean hasLowerCase=false;
    boolean hasSpecialCharacter=false;
    boolean hasDigit=false;

    for (char ch:password.toCharArray()){
     if (Character.isUpperCase(ch)){
         hasUpperCase = true;
     }
     else if (Character.isLowerCase(ch)){
         hasLowerCase =true;
     }
     else if(!Character.isLetterOrDigit(ch)){
         hasSpecialCharacter=true;
        }
     else if (Character.isDigit(ch)){
         hasDigit=true;
     }
    }
        return hasUpperCase && hasLowerCase &&hasSpecialCharacter &&hasDigit &&isValid;
    }

    @Override
    public boolean isValidatePhoneNumber(String phoneNumber) {
        boolean isValid=true;
      if (!phoneNumber.startsWith("20")){
          System.out.println("the phoneNumber Should start with 20");
          isValid =false;
      }

      if (phoneNumber.length()!=12){
          System.out.println("phoneNumber size must be = 12");
          isValid =false;
      }
        return isValid;
    }
}
