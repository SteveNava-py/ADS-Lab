package Password;

import java.lang.reflect.Field;

/**
 *
 * Experiment using reflection to spy on private fields
 *
 * @author marianky
 */
public class PasswordSpying {

    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker("secretpassword");

        Class c = pc.getClass();
        Field f;
        try {
            f = c.getDeclaredField("password");

            f.setAccessible(true);

            //get method here returns the specified field in the given class
            String stolenPassword = (String) f.get(pc);

            System.out.println("Old password was " + stolenPassword);

            f.set(pc, "malicious_password");
            System.out.println("Trying old password. "
                    + pc.checkPassword("secretpassword"));
        } catch (SecurityException e) {
        } catch (NoSuchFieldException e) {
        } catch (IllegalArgumentException e) {
        } catch (IllegalAccessException e) {
        }
    }
}
