package DAO;

/*public class UserJdbcDAO implements UserDAO {
   private Connection connection;

    public UserJdbcDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> getAllUserDao() {
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM db_example.users";
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
               // userList.add(new User(id, name, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void addUserDao(User user) throws SQLException {
        String name = user.getName();
        int age = user.getAge();
        String sql = "INSERT INTO db_example.users (name, age) Values (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        // createTable();
        connection.setAutoCommit(true);
        statement.setString(1, name);
        statement.setInt(2, age);
        statement.execute();
        statement.close();
    }

    @Override
    public User getUserByIdDao(long id) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("select * from db_example.users where id='" + id + "'");
        ResultSet result = stmt.getResultSet();
        result.next();
        String name = result.getString(2);
        int age = result.getInt(3);
        User user = new User(id, name, age);
        result.close();
        stmt.close();
        return user;
    }

    @Override
    public void updateUserDao(User user) throws SQLException {
        String name = user.getName();
        int age = user.getAge();
        long id = user.getId();
        Statement stmt = connection.createStatement();
        stmt.execute("UPDATE db_example.users SET name = '"+name+"', age = '"+age+"' WHERE id = '"+id+"'");
        stmt.close();
    }

    @Override
    public void deleteUserDao(User user) throws SQLException {
        long id = user.getId();
        Statement stmt = connection.createStatement();
        stmt.execute("DELETE FROM db_example.users WHERE id = '"+id+"'");
        stmt.close();
    }
}*/
