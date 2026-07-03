import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	private static String URL="jdbc:postgresql://localhost:5432/user";
	private static String USERNAME="postgres";
	private static String PASSWORD="admin";
	
	 private static final String INSERT_USERS_SQL = "INSERT INTO usersdata" + "  (username, useremail, usercountry, userage) VALUES " + " (?, ?, ?, ?);";
	 private static final String SELECT_USER_BY_ID = "select userid,username,useremail,usercountry,userage from usersdata where userid =?";
	 private static final String SELECT_ALL_USERS = "select * from usersdata";
	 private static final String DELETE_USERS_SQL = "delete from usersdata where userid = ?;";
	 private static final String UPDATE_USERS_SQL = "update usersdata set username = ?,useremail= ?, usercountry =?, userage=? where userid = ?;";
	
	 public static Connection getConnection() {

		    Connection con = null;

		    try {

		        Class.forName("org.postgresql.Driver");

		        con = DriverManager.getConnection(URL,USERNAME,PASSWORD);

		    } catch(Exception e) {
		        e.printStackTrace();
		    }

		    return con;
		}
	 
	 public  int save(User e) {
			int status = 0;
			try (Connection con = getConnection()) {
				PreparedStatement ps = con.prepareStatement(INSERT_USERS_SQL);
				ps.setString(1, e.getName());
				ps.setString(2, e.getEmail());
				ps.setString(3, e.getCountry());
				ps.setInt(4, e.getAge());
				status = ps.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return status;
		}
	 
	 public User selectUser(int id) {
		 User user = null;
	        
	        try (Connection connection = getConnection();
	            
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
	            preparedStatement.setInt(1, id);
	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	                String name = rs.getString("username");
	                String email = rs.getString("useremail");
	                String country = rs.getString("usercountry");
	                int age = rs.getInt("userage");
	                user = new User(id, name, email, country, age);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return user;
	    }
	 
	 public  List<User> getAllUsers() {
			List<User> list = new ArrayList<>();
			try (Connection con = getConnection()) {
				PreparedStatement ps = con.prepareStatement(SELECT_ALL_USERS);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					User e = new User();
					e.setId(rs.getInt(1));
					e.setName(rs.getString(2));
					e.setEmail(rs.getString(3));
					e.setCountry(rs.getString(4));
					e.setAge(rs.getInt(5));
					list.add(e);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	 
	 public boolean deleteUser(int id) throws SQLException {
	        boolean rowDeleted;
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
	            statement.setInt(1, id);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }
	 
	 public boolean updateUser(User user) throws SQLException {
	        boolean rowUpdated;
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
	            statement.setString(1, user.getName());
	            statement.setString(2, user.getEmail());
	            statement.setString(3, user.getCountry());
	            statement.setInt(4, user.getAge());
	            statement.setInt(5, user.getId());

	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }
	 
	 
	 
	 private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
		    
}
