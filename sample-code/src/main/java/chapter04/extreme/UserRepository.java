package chapter04.extreme;

public class UserRepository {

    public String lastExecutedSqlStatement = "";

    public String getLastExecutedSqlStatement() throws IllegalAccessException {
        if (lastExecutedSqlStatement.isBlank()) {
            throw new IllegalAccessException("Nothing has been execute");
        }

        return lastExecutedSqlStatement;
    }

    public User getById(int id) {
        lastExecutedSqlStatement = String.format("SELECT * FROM dbo.[User] WHERE UserID = %d", id);
        return new User("testUser");
    }

}
