package controller;
import view.UserView;
import model.UserModel;
import repository.UserRepository;

import javax.swing.*;
import java.sql.SQLException;

import static repository.UserRepository.isUsernameUnique;

public class UserController {

    private UserModel model;
    private static UserView view;
    private static UserRepository repository;
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    public UserModel getModel() {
        return model;
    }

    public void setModel(UserModel model) {
        this.model = model;
    }

    public static UserView getView() {
        return view;
    }

    public void setView(UserView view) {
        this.view = view;
    }

    public static void authenticateUser(String username, String password) {
        System.out.println("authenticateUser method called");
        UserRepository.AuthenticationResult result = repository.authenticateUser(username, password);

        switch (result) {
            case SUCCESS:
                view.goToMenu(UserView.frameLogin);
                break;
            case NO_USER_FOUND:
                view.showMessage("No user with such username identified", JOptionPane.INFORMATION_MESSAGE);
                break;
            case INCORRECT_PASSWORD:
                view.showMessage("Incorrect password", JOptionPane.ERROR_MESSAGE);
                break;
            case DATABASE_ERROR:
                view.showMessage("Database error", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
    public static void registerUser(String username, String password) {
        try {
            if (isUsernameAndPasswordValid(username, password)) {
                if (isUsernameUnique(username)) {
                    int newUserId = UserRepository.insertUser(username, password);

                    if (newUserId != -1) {
                        showMessage("User registered successfully :) " , JOptionPane.INFORMATION_MESSAGE);
                        UserView.goToMenu(UserView.frameLogin);
                    } else {
                        showMessage("Failed to register user.", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    showMessage("Username already exists. Please choose a different username.", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                showMessage("Username and password must be at least 4 characters long.", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            showMessage("Error registering user", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();  // Handle the exception according to your needs
        }
    }
    public static void submitReview(int locationId, String reviewText, float rating, String userName) {
        try {
            if (isReviewValid(locationId, reviewText, rating, userName)) {
                int newReviewId = UserRepository.insertReview(locationId, reviewText, rating, userName);

                if (newReviewId != -1) {
                    showMessage("Review submitted successfully :) ", JOptionPane.INFORMATION_MESSAGE);
                    // Perform any additional actions, such as updating UI or navigating to a different view
                } else {
                    showMessage("Failed to submit review.", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                showMessage("Invalid review details. Please check your inputs.", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            showMessage("Error submitting review", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();  // Handle the exception according to your needs
        }
    }

    private static boolean isReviewValid(int locationId, String reviewText, float rating, String userName) {
        // Add validation logic for review details, if needed
        // For example, check if locationId is valid, reviewText is not empty, rating is within a valid range, etc.
        // Return true if all details are valid, false otherwise
        return true;  // Modify this based on your validation criteria
    }


    private static boolean isUsernameAndPasswordValid(String username, String password) {
        return username.length() >= 4 && password.length() >= 4;
    }




    private static void showMessage(String message, int messageType) {
        JOptionPane.showMessageDialog(null, message, "Registration", messageType);
    }


}
