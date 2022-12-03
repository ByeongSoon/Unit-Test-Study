package chapter08.version1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class IntegrationTest {

//    private final static String ConnectionString = "Server=.\Sql;Database=IntegrationTests;Trusted_Connection=true;";
    private final static String ConnectionString = "TEST";


    @Test
    @DisplayName("통합 테스트")
    public void changingEmailFromCorporateToNonCorporate() {
        // Arrange
        Database db = new Database(ConnectionString);
        User user = createUser(
            "user@mycorp.com", UserType.Employee, db);
        createCompany("mycorp.com", 1, db);

        IMessageBus messageBusMock = mock(MessageBus.class);
        UserController sut = new UserController(db, messageBusMock);

        // Act
        String result = sut.changeEmail(user.UserId, "new@gmail.com");

        // Assert
        assertEquals("OK", result);

        Object[] userData = db.getUserById(user.UserId);
        User userFromDb = UserFactory.create(userData);
        assertEquals("new@gmail.com", userFromDb.Email);
        assertEquals(UserType.Customer, userFromDb.Type);

        Object[] companyData = db.getCompany();
        Company companyFromDb = CompanyFactory.create(companyData);
        assertEquals(0, companyFromDb.NumberOfEmployees);

        verify(messageBusMock, times(1))
            .sendEmailChangedMessage(user.getUserId(), "new@gmail.com");
    }

    private Company createCompany(String domainName, int numberOfEmployees, Database database)
    {
        Company company = new Company(domainName, numberOfEmployees);
        database.saveCompany(company);
        return company;
    }

    private User createUser(String email, UserType type, Database database)
    {
        User user = new User(0, email, type, false);
        database.saveUser(user);
        return user;
    }

}
