package repository;

import controller.UserController;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

import static view.UserView.*;

public class UserRepository {
    static Connection connection = null;
    PreparedStatement preparedStatement = null;
    Integer rowsAffected = 0;
    static String url = "jdbc:postgresql://localhost:5432/climb";
    static String dbUsername = "postgres";
    static String dbPassword = "Pariucuviata123";

    public UserRepository() {
        try {
            connection = DriverManager.getConnection(url, dbUsername, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Boolean ok;

    public void uniqueUsername() {
    }
    public static int insertReview(int locationId, String reviewText, float rating, String userName) throws SQLException {
        int generatedReviewId = -1; // Default value indicating failure

        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO reviewsIndoor(location_id, review_text, rating, user_name) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, locationId);
            preparedStatement.setString(2, reviewText);
            preparedStatement.setFloat(3, rating);
            preparedStatement.setString(4, userName);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // Retrieve the generated review id (auto-incremented primary key)
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        generatedReviewId = generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generatedReviewId;
    }


    public static int insertUser(String username, String password) throws SQLException {
        int generatedUserId = -1; // Default value indicating failure

        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(username, password) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // Retrieve the generated userid (auto-incremented primary key)
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        generatedUserId = generatedKeys.getInt(1) + 5;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generatedUserId;
    }

    public enum AuthenticationResult {
        SUCCESS,
        NO_USER_FOUND,
        INCORRECT_PASSWORD,
        DATABASE_ERROR;


    }

    public static AuthenticationResult authenticateUser(String username, String password) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ?")) {
            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // User with the given username exists in the database
                    int userId = resultSet.getInt("userid");
                    String storedPassword = resultSet.getString("password");
                    if (storedPassword.equals(password)) {
                        return AuthenticationResult.SUCCESS;
                    } else {
                        return AuthenticationResult.INCORRECT_PASSWORD;
                    }
                } else {
                    // No user with the given username found
                    return AuthenticationResult.NO_USER_FOUND;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the exception appropriately
            return AuthenticationResult.DATABASE_ERROR;
        }
    }


    public static boolean isUsernameUnique(String username) throws SQLException {
        // Implement logic to check if the username is unique in the database
        String query = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count == 0;
        }
    }
    public static void loadLocationsOutdoorData() {
        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            String query = "SELECT name, nrOfRoutes, approach FROM locationsOutdoor";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Populate the JTable with data
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Name");
            model.addColumn("Number of Routes");
            model.addColumn("Approach");
            model.addRow(new Object[]{"Name", "Number of Routes", "Approach"});

            while (resultSet.next()) {
                Object[] row = {
                        resultSet.getString("name"),
                        resultSet.getInt("nrOfRoutes"),
                        resultSet.getString("approach")
                };
                model.addRow(row);
            }

            tableOutdoor.setModel(model); // Assuming 'tableIndoor' is the name of your JTable
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void loadReviewsIndoorDataGravity() {
        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            String query = "SELECT location_id, review_text, rating, user_name FROM reviewsIndoor WHERE location_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 1);  // Set the parameter for location_id
            ResultSet resultSet = preparedStatement.executeQuery();

            // Populate the JTable with data
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Location ID");
            model.addColumn("Review Text");
            model.addColumn("Rating");
            model.addColumn("User Name");

            while (resultSet.next()) {
                Object[] row = {
                        resultSet.getInt("location_id"),
                        resultSet.getString("review_text"),
                        resultSet.getFloat("rating"),
                        resultSet.getString("user_name")
                };
                model.addRow(row);
            }

            // Assuming 'tableIndoorReviews' is the name of your JTable
            // Set the model to the JTable
            tableReviewGravity.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static int getLocationIdByName(String locationName) {
        int locationId = -1; // Initialize to an invalid value

        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            String query = "SELECT id FROM locationsIndoor WHERE name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, locationName);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    locationId = resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return locationId;
    }

    public static void loadLocationsIndoorData() {

        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            String query = "SELECT  name, address, priceperentrance, priceformembership, contact, rating FROM locationsIndoor";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Populate the JTable with data
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Name");
            model.addColumn("Address");
            model.addColumn("Price per Entrance");
            model.addColumn("Price for Membership");
            model.addColumn("Contact");
            model.addColumn("Rating");
            model.addRow(new Object[]{"Name", "Address", "Price per Entrance", "Price for Membership", "Contact", "Rating"});
            while (resultSet.next()) {
                Object[] row = {
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getInt("priceperentrance"),
                        resultSet.getInt("priceformembership"),
                        resultSet.getString("contact"),
                        (resultSet.getFloat("rating") == 0) ? "No ratings yet" : resultSet.getFloat("rating")
                };
                model.addRow(row);
            }

            tableIndoor.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


