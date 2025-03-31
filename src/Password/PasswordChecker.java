package Password;

/**
 * Warning :  A very insecure password checking class. Don't use this for any actual passwords
 * @author marianky
 */
public class PasswordChecker {

    private int failedAttempts;
    private String password;
    
    public PasswordChecker(String newPassword) {
        password = newPassword;
        failedAttempts = 0;
    }

    public boolean checkPassword(String attemptedPassword) {
        boolean correct = password.equals(attemptedPassword);
        if (!correct) {
            failedAttempts++;
        } else {
            failedAttempts = 0;
        }
        return correct;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public boolean setPassword(String oldPassword, String newPassword) {
        if (checkPassword(oldPassword)) {
            password = newPassword;
            return true;
        } else {
            return false;
        }
    }
    
}
