package chapter05.mockandstub;

public class Controller {

    private final IEmailGateway _emailGateway;
    private final IDatabase _database;

    public Controller(IEmailGateway emailGateway) {
        this._emailGateway = emailGateway;
        this._database = null;
    }

    public Controller(IDatabase database) {
        this._database = database;
        this._emailGateway = null;
    }

    public void greetUser(String userEmail) {
        _emailGateway.sendGreetingsEmail(userEmail);
    }

    public Report createReport() {
        int numberOfUsers = _database.getNumberOfUsers();
        return new Report(numberOfUsers);
    }

}
