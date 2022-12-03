package chapter08.version1;

public class UserFactory {
    public static User create(Object[] data)
    {
//        Precondition.Requires(data.length >= 3);

        int id = (int)data[0];
        String email = (String)data[1];
        UserType type = (UserType)data[2];
        boolean isEmailConfirmed = (boolean)data[3];

        return new User(id, email, type, isEmailConfirmed);
    }
}
