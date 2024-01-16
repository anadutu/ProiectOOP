package main;

import controller.UserController;
import view.UserView;
import model.UserModel;
import repository.UserRepository;
public class Main {
    public static void main(String[] args) {
        System.out.println("hai sa facem ClimbingApp");

        UserModel userModel= new UserModel();
        UserRepository userRepository= new UserRepository();
        UserController userController= new UserController(userRepository);
        UserView userView= new UserView();

        userController.setModel(userModel);
        userController.setView(userView);
        userView.setVisibility(true);
    }
}