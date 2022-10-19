package chapter05.detailsleaked;

public class UserController {

    public void renameUser(int userId, String newName) {
        User user = getUserFromDatabase(userId);

        String normalizedName = user.normalizeName(newName);
        user.name = normalizedName;

        saveUserToDatabase(user);
    }

    private void saveUserToDatabase(User user) {
    }

    private User getUserFromDatabase(int userID) {
        return new User();
    }

}
