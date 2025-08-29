package Service;

public interface AccountValidationService {

    boolean isValidateUsername(String userName);
    boolean isValidatePassword(String password);
    boolean isValidatePhoneNumber(String phoneNumber);
}
