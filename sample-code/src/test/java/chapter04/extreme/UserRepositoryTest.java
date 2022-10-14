package chapter04.extreme;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserRepositoryTest {

    @Test
    @DisplayName("실행 중인 SQL 문을 검증하는 테스트")
    public void getByIdExecutesCorrectSQLCode()  {
        UserRepository sut = new UserRepository();

        User user = sut.getById(5);

        Assertions.assertEquals(
            "SELECT * FROM dbo.[User] WHERE UserID = 5",
            sut.lastExecutedSqlStatement
        );

        /*
        * SQL문을 변경해도 결과는 같으므로 이 테스트는 좋지않다.

        * SELECT * FROM dbo.User WHERE UserID = 5
        * SELECT * FROM dbo.[User] WHERE UserID = @UserID
        * SELECT UserID, Name, Email FROM dbo.[User] WHERE UserId = 5
         */
    }

}
