package chapter08.version1;


public class Database {
    private final String _connectionString;

    public Database(String connectionString)
    {
        _connectionString = connectionString;
    }

    public Object[] getUserById(int userId)
    {
        /**
         * user 정보 가져오는 부분
         */
        return null;
    }

    public void saveUser(User user)
    {
        /**
         * user 정보 저장하는 부분
         */
    }

    public Object[] getCompany()
    {
        /**
         * company 가져오는 부분
         */

        return null;
    }

    public void saveCompany(Company company)
    {
        /**
         * company 저장하는 부분
         */
    }

}
