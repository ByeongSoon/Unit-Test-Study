package chapter08.version1;

public class UserController {
    private final Database _database;
    private final IMessageBus _messageBus;

    public UserController(Database database, IMessageBus messageBus)
    {
        _database = database;
        _messageBus = messageBus;
    }

    public String changeEmail(int userId, String newEmail)
    {
        Object[] userData = _database.getUserById(userId);
        User user = UserFactory.create(userData);

        String error = user.canChangeEmail();
        if (error != null) {
            return error;
        }

        Object[] companyData = _database.getCompany();
        Company company = CompanyFactory.create(companyData);

        user.changeEmail(newEmail, company);

        _database.saveCompany(company);
        _database.saveUser(user);
        for (EmailChangedEvent ev: user.emailChangedEvents)
        {
            _messageBus.sendEmailChangedMessage(ev.userId, ev.newEmail);
        }

        return "OK";
    }
}
