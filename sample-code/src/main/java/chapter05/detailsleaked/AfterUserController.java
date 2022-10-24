package chapter05.detailsleaked;

public class AfterUserController {

    public void renameUser(int userId, String newName) {
        AfterUser user = getUserFromDatabase(userId);
        user.setName(newName);
        saveUserToDatabase(user);
    }

    private void saveUserToDatabase(AfterUser user) {
    }

    private AfterUser getUserFromDatabase(int userID) {
        return new AfterUser();
    }

}
