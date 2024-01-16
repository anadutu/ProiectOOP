package view;

import java.awt.Desktop;
import controller.UserController;
import jdk.internal.icu.impl.CharacterIteratorWrapper;
import repository.UserRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.net.URI;
public class UserView extends JPanel{

    //1st frame(Welcome)
    static JFrame frame1=new JFrame("Welcome to ClimbingApp - madeByAna:)");
    static JPanel panel1=new JPanel();

    static JButton buttonLogin=new JButton("Login");
    static JButton buttonSignUp=new JButton("Sign Up");
    //static ImageIcon iconWelcome=new ImageIcon("C:\\Users\\Asus\\Desktop\\OOP-project\\welcome.jpg");
    static ImageIcon iconLogo=new ImageIcon("C:\\Users\\Asus\\Desktop\\OOP-project\\logo.jpg");
    static JLabel labelParam1=new JLabel("Welcome to Climbing App!");
    static JLabel labelParam3=new JLabel(iconLogo);
    static JLabel labelParam2=new JLabel("Please Login or Sign Up");


    //2nd frame(Login)
    public static JFrame frameLogin=new JFrame("Login");
    static JPanel panelLogin= new JPanel();
    static JLabel labelLogin=new JLabel("Please Login");
    static JLabel labelUsername= new JLabel("Username: ");
    static JLabel labelPassword= new JLabel("Password: ");
    static JTextField textUsername= new JTextField();
    static JTextField textPassword= new JTextField();
    static JButton buttonSubmit= new JButton("Submit");
    static JButton buttonBackLogin= new JButton("Back");

    //3rd frame (Sing Up)
    public static JFrame frameSignUp=new JFrame("Sign Up");
    static JPanel panelSignUp= new JPanel();
    static JLabel labelSignUp=new JLabel("To Sign Up please create a username and a password");
    static JLabel labelUsername2=new JLabel("Create  Username:");
    static JLabel labelPassword2=new JLabel("Create Password");
    static JTextField textUsername2= new JTextField();
    static JTextField textPassword2= new JTextField();
    static JButton buttonConfirm= new JButton("Submit");
    static JButton buttonBackSignUp= new JButton("Back");

    //4th frame(Menu)
    static JFrame frameMenu=new JFrame("Menu");
    static JPanel panelMenu=new JPanel();
    static JLabel labelLocations=new JLabel("Go see Climbing locations");
    static ImageIcon iconLocation=new ImageIcon("C:\\Users\\Asus\\Desktop\\OOP-project\\location.jpg");
    static JLabel labelShop=new JLabel("Go to the shop");
    static ImageIcon iconShop=new ImageIcon("C:\\Users\\Asus\\Desktop\\OOP-project\\shop.jpg");
    static JButton buttonLocations=new JButton(iconLocation);
    static JButton buttonShop=new JButton(iconShop);
    static JButton buttonExit=new JButton("Exit");

    //5th frame(Location)
    static JFrame frameLocation=new JFrame("Locations");
    static JPanel panelLocation=new JPanel();
    static JLabel labelChoose=new JLabel("Choose where you want to climb: outdoors or indoors");
    static JLabel labelCooler=new JLabel("outdoors is much cooler:)");
    static ImageIcon iconOutdoor=new ImageIcon("C:\\Users\\Asus\\Desktop\\OOP-project\\outdoor.jpg");
    static ImageIcon iconIndoor=new ImageIcon("C:\\Users\\Asus\\Desktop\\OOP-project\\indoor.jpg");
    static JButton buttonIndoor=new JButton(iconIndoor);
    static JButton buttonOutdoor=new JButton(iconOutdoor);
    static JButton buttonBackLocation=new JButton("Back To Menu");

    //6th frame indoorLoc
    static JFrame frameIndoorLoc=new JFrame("Indoor Locations");
    static JPanel panelIndoorLoc=new JPanel();
    static JLabel labelMoreInfoIndoor=new JLabel("Choose a climbing gym to see more info or leave a rating");
    static JButton buttonGravity=new JButton("Gravity");
    static JButton buttonFreeWall=new JButton("Free Wall");
    static JButton buttonSkai=new JButton("Skai");
    static JButton buttonCentrala=new JButton("Centrala");
    static JButton buttonBackIndoor=new JButton("Back to locations");
    public static JTable tableIndoor=new JTable();
    static JScrollPane scrollPaneIndoor=new JScrollPane(tableIndoor);
    //7th frame gravity
    static JFrame frameGravity=new JFrame("Gravity - Climbing gym");
    static JPanel panelGravity=new JPanel();
    static JLabel labelLeaveARatingGravity=new JLabel("Leave a rating for this climbing gym");
    static JButton buttonSiteGravity=new JButton("GoToWebSite");
    static JTextField textRatingGravity=new JTextField();
    static JButton buttonSubmitRatingGravity=new JButton("Submit Rating");
    static JButton backGravity=new JButton("Back to Indoor Locations");
    static JTextField usernameGravity=new JTextField();
    static JTextField passwordGravity=new JTextField();
    static JLabel textGravity=new JLabel("Please insert your username and password to subit a rating");

    //8th frame freeWall
    static JFrame frameFreeWall=new JFrame("Free Wall - Climbing gym");
    static JPanel panelFreeWall=new JPanel();
    static JLabel labelLeaveARatingFreeWall=new JLabel("Leave a rating for this climbing gym");
    static JButton buttonSiteFreeWall=new JButton("GoToWebSite");
    static JTextField textRatingFreeWall=new JTextField();
    static JButton backFreeWall=new JButton("Back to Indoor Locations");
    // 9th frame Skai
    static JFrame frameSkai = new JFrame("Skai - Climbing gym");
    static JPanel panelSkai = new JPanel();
    static JLabel labelLeaveARatingSkai = new JLabel("Leave a rating for this climbing gym");
    static JButton buttonSiteSkai = new JButton("GoToWebSite");
    static JTextField textRatingSkai = new JTextField();
    static JButton backSkai = new JButton("Back to Indoor Locations");
    // 10th frame Centrala
    static JFrame frameCentrala = new JFrame("Centrala - Climbing gym");
    static JPanel panelCentrala = new JPanel();
    static JLabel labelLeaveARatingCentrala = new JLabel("Leave a rating for this climbing gym");
    static JButton buttonSiteCentrala = new JButton("GoToWebSite");
    static JTextField textRatingCentrala = new JTextField();
    static JButton backCentrala = new JButton("Back to Indoor Locations");
    static JButton buttonSubmitRating=new JButton("Submit Rating");

    //11th frame outdoor
    static JFrame frameOutdoor =new JFrame("Outdoor Locations");
    static JPanel panelOutdoor=new JPanel();
    static JButton buttonTurzii=new JButton("Cheile Turzii");
    static JButton buttonTureni=new JButton("Cheile Turenilor");
    static JButton buttonRimetea=new JButton("Rimetea");
    static JButton backOutdoor=new JButton("Back to Locations");
    static JLabel labelChooseOutdoor=new JLabel("Choose where you want to climb");
    public static JTable tableOutdoor=new JTable();
    static JScrollPane scrollPaneOutdoor=new JScrollPane(tableOutdoor);
    static JButton addReviewGravity=new JButton("Add a review");
    static JButton seeReviewsGravity=new JButton("See reviews from all users");
    static JButton addReviewFreeWall=new JButton("Add a review");
    static JButton seeReviewsFreeWall=new JButton("See reviews from all users");
    static JButton addReviewSkai=new JButton("Add a review");
    static JButton seeReviewsSkai=new JButton("See reviews from all users");
    static JButton addReviewCentrala=new JButton("Add a review");
    static JButton seeReviewsCentrala=new JButton("See reviews from all users");

    //frame add review Gravity and see reviews
    static JFrame frameAddGravity=new JFrame("Add  review for Gravity");
    static JFrame frameSeeGravity=new JFrame("See all reviews for Gravity");
    static JLabel instructionGravity=new JLabel("Write a review for Gravity and give it a rating!");
    static JPanel panelAddGravity=new JPanel();
    static JPanel panelSeeGravity=new JPanel();
    static JTextField usernameGravity2=new JTextField();
    static JTextField reviewGravity=new JTextField();
    static JTextField ratingGravity =new JTextField();
    static JButton submitGravity =new JButton("Submit");
    public static JTable tableReviewGravity=new JTable();
    static JScrollPane scrollPaneGravity=new JScrollPane(tableOutdoor);

    public UserView(){
        frame1.setLocation(500,150);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(500, 500);

        panel1.setLayout(null);

        labelParam1.setBounds(167, 100, 400, 30);
        labelParam2.setBounds(170, 130, 400, 30);
        labelParam3.setBounds(20,200,450,160);
        buttonLogin.setBounds(150, 170, 100, 30);
        buttonSignUp.setBounds(260, 170, 100, 30);

        panel1.add(labelParam1);
        panel1.add(labelParam2);
        panel1.add(labelParam3);
        panel1.add(buttonLogin);
        panel1.add(buttonSignUp);
        frame1.setContentPane(panel1);
        buttonLogin.addActionListener(e->UserView.goToLogin());
        buttonSignUp.addActionListener(e->UserView.goToSignUp());

    }
    public static void goToLogin(){
        frame1.dispose();
        frameLogin.setLocation(500,150);
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.setSize(400, 250);

        panelLogin.setLayout(null);

        labelLogin.setBounds(150,50,400,30);
        labelUsername.setBounds(80,95,100,30);
        labelPassword.setBounds(80,115,100,30);
        textUsername.setBounds(170,100,100,20);
        textPassword.setBounds(170,120,100,20);
        buttonSubmit.setBounds(150,160,80,30);
        buttonBackLogin.setBounds(0,0,80,30);
        panelLogin.add(labelLogin);
        panelLogin.add(labelUsername);
        panelLogin.add(labelPassword);
        panelLogin.add(textUsername);
        panelLogin.add(textPassword);
        panelLogin.add(buttonSubmit);
        panelLogin.add(buttonBackLogin);
        textUsername.setText("");
        textPassword.setText("");
        frameLogin.setContentPane(panelLogin);
        frameLogin.setVisible(true);
        Object currentFrame;
        ActionListener backLoginListener = e -> UserView.goBackToUserView(frameLogin);
        buttonBackLogin.addActionListener(backLoginListener);
        buttonSubmit.addActionListener(e -> {
            String username = textUsername.getText();
            String password = textPassword.getText();
            UserController.authenticateUser(username, password);

        });

    }
    public static void goBackToUserView(JFrame currentFrame) {
        currentFrame.dispose();
        frame1.setLocation(500,150);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(500, 500);

        panel1.setLayout(null);

        labelParam1.setBounds(150, 100, 400, 30);
        labelParam2.setBounds(170, 130, 400, 30);
        buttonLogin.setBounds(150, 170, 100, 30);
        buttonSignUp.setBounds(260, 170, 100, 30);

        panel1.add(labelParam1);
        panel1.add(labelParam2);
        panel1.add(buttonLogin);
        panel1.add(buttonSignUp);
        frame1.setContentPane(panel1);

        for (ActionListener al : buttonLogin.getActionListeners()) {
            buttonLogin.removeActionListener(al);
        }
        buttonLogin.addActionListener(e->UserView.goToLogin());
        frame1.setVisible(true);
    }
    public static void goToSignUp(){
        frame1.dispose();
        frameSignUp.setLocation(500,150);
        frameSignUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameSignUp.setSize(400,250);

        panelSignUp.setLayout(null);
        labelSignUp.setBounds(55,50,400,30);
        labelUsername2.setBounds(50,95,150,30);
        labelPassword2.setBounds(50,115,120,30);
        textUsername2.setBounds(180,100,100,20);
        textPassword2.setBounds(180,120,100,20);
        buttonConfirm.setBounds(140,160,80,30);
        buttonBackSignUp.setBounds(0,0,80,30);

        panelSignUp.add(labelSignUp);
        panelSignUp.add(labelUsername2);
        panelSignUp.add(labelPassword2);
        panelSignUp.add(textUsername2);
        panelSignUp.add(textPassword2);
        panelSignUp.add(buttonConfirm);
        panelSignUp.add(buttonBackSignUp);
        textUsername2.setText("");
        textPassword2.setText("");
        frameSignUp.setContentPane(panelSignUp);
        frameSignUp.setVisible(true);
        ActionListener backSignUpListener = e -> UserView.goBackToUserView(frameSignUp);
        buttonBackSignUp.addActionListener(backSignUpListener);
        buttonConfirm.addActionListener(e->{
            String username = textUsername2.getText();
            String password = textPassword2.getText();
            UserController.registerUser(username, password);
        });
    }
    public static void goToMenu(JFrame currentFrame){
        currentFrame.dispose();
        frameMenu.setLocation(500,150);
        frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenu.setSize(400,400);
        panelMenu.setLayout(null);
        labelLocations.setBounds(25,80,170,40);
        labelShop.setBounds(240,80,170,40);
        buttonLocations.setBounds(10,140,180,120);
        buttonShop.setBounds(200,140,180,120);
        buttonExit.setBounds(0,0,75,30);
        panelMenu.add(labelLocations);
        panelMenu.add(labelShop);
        panelMenu.add(buttonLocations);
        panelMenu.add(buttonShop);
        panelMenu.add(buttonExit);
        buttonShop.addActionListener(e->{
            showMessage("Not implemented yet...",1);
        });
        buttonExit.addActionListener(e->goBackToUserView(frameMenu));
        buttonLocations.addActionListener(e->goToLocation(frameMenu));
        frameMenu.setContentPane(panelMenu);

        frameMenu.setVisible(true);

    }
    public static void goToLocation(JFrame currentFrame){
        currentFrame.dispose();
        frameLocation.setLocation(500,150);
        frameLocation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLocation.setSize(400,400);
        panelLocation.setLayout(null);

        int outdoorWidth = buttonOutdoor.getIcon().getIconWidth();
        int outdoorHeight = buttonOutdoor.getIcon().getIconHeight();
        int indoorWidth = buttonIndoor.getIcon().getIconWidth();
        int indoorHeight = buttonIndoor.getIcon().getIconHeight();

        labelChoose.setBounds(50,80,310,30);
        labelCooler.setBounds(30,330,310,30);
        buttonOutdoor.setBounds(4,120,outdoorWidth,outdoorHeight);
        buttonIndoor.setBounds(195,120,indoorWidth-3,indoorHeight+7);
        buttonBackLocation.setBounds(0,0,150,30);
        panelLocation.add(buttonBackLocation);
        panelLocation.add(buttonIndoor);
        panelLocation.add(buttonOutdoor);
        panelLocation.add(labelCooler);
        panelLocation.add(labelChoose);
        buttonOutdoor.addActionListener(e->goToOutdoor(frameLocation));
        buttonIndoor.addActionListener(e->goToIndoor(frameLocation));
        buttonBackLocation.addActionListener(e->goToMenu(frameLocation));
        frameLocation.setContentPane(panelLocation);
        frameLocation.setVisible(true);


    }
    static void goToIndoor(JFrame currentFrame){
        currentFrame.dispose();
        frameIndoorLoc.setSize(1000,300);
        frameIndoorLoc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameIndoorLoc.setLocation(300,150);
        panelIndoorLoc.setLayout(null);
        labelMoreInfoIndoor.setBounds(55,150,500,20);
        buttonBackIndoor.setBounds(0,0,150,30);
        buttonGravity.setBounds(55,200,100,30);
        buttonFreeWall.setBounds(155,200,100,30);
        buttonSkai.setBounds(255,200,100,30);
        buttonCentrala.setBounds(355,200,100,30);
        UserRepository.loadLocationsIndoorData();
        tableIndoor.setBounds(50, 50, 900, 100);
        panelIndoorLoc.add(labelMoreInfoIndoor);
        panelIndoorLoc.add(tableIndoor);
        panelIndoorLoc.add(buttonBackIndoor);
        panelIndoorLoc.add(buttonGravity);
        panelIndoorLoc.add(buttonFreeWall);
        panelIndoorLoc.add(buttonSkai);
        panelIndoorLoc.add(buttonCentrala);
        buttonSkai.addActionListener(e->goToSkai(frameIndoorLoc));
        buttonCentrala.addActionListener(e->goToCentrala(frameIndoorLoc));
        buttonBackIndoor.addActionListener(e->goToLocation(frameIndoorLoc));
        buttonGravity.addActionListener(e->goToGravity(frameIndoorLoc));
        buttonFreeWall.addActionListener(e->goToFreeWall(frameIndoorLoc));
        frameIndoorLoc.setContentPane(panelIndoorLoc);
        frameIndoorLoc.setVisible(true);


    }

    static void goToGravity(JFrame currentFrame){
        currentFrame.dispose();
        frameGravity.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGravity.setLocation(580,240);
        frameGravity.setSize(400,200);
        panelGravity.setLayout(null);
        buttonSiteGravity.setBounds(100,90,200,30);
        addReviewGravity.setBounds(30,130,170,30);
        seeReviewsGravity.setBounds(200,130,170,30);
//        labelLeaveARatingGravity.setBounds(20,130,200,30);
//        textRatingGravity.setBounds(230,135,30,20);
//        buttonSubmitRatingGravity.setBounds(260,130,125,30);
//        usernameGravity.setBounds(70,100,100,20);
//        passwordGravity.setBounds(200,100,100,20);
//        textGravity.setBounds(20,70,350,30);
        buttonSiteGravity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebsite("https://aventi.ro/aventura-provider/gravity-sala-de-escalada/");
            }
        });
        backGravity.setBounds(0,0,190,30);
        backGravity.addActionListener(e->goToIndoor(frameGravity));
        panelGravity.add(addReviewGravity);
        panelGravity.add(seeReviewsGravity);
        panelGravity.add(backGravity);
        panelGravity.add(textGravity);
        panelGravity.add(passwordGravity);
        panelGravity.add(usernameGravity);
        panelGravity.add(buttonSubmitRatingGravity);
        panelGravity.add(textRatingGravity);
        panelGravity.add(labelLeaveARatingGravity);
        panelGravity.add(buttonSiteGravity);
        panelGravity.add(buttonSiteGravity);
        addReviewGravity.addActionListener(e->goToAddReviewGravity(frameGravity));
        seeReviewsGravity.addActionListener(e->goToSeeReviewGravity(frameGravity));
        frameGravity.setContentPane(panelGravity);
        frameGravity.setVisible(true);

    }
    static JButton backToGravityAdd=new JButton("Back to Gravity");

    static void goToAddReviewGravity(JFrame currentFrame){
            currentFrame.dispose();
            frameAddGravity.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameAddGravity.setSize(400,200);
            frameAddGravity.setLocation(580,240);
            panelAddGravity.setLayout(null);
            instructionGravity.setBounds(30,30,300,30);
            backToGravityAdd.setBounds(0,0,145,30);
            usernameGravity2.setBounds(40,70,100,30);
            reviewGravity.setBounds(40,100,100,30);
            ratingGravity.setBounds(180,100,40,30);
            submitGravity.setBounds(250,110,100,30);
            submitGravity.addActionListener(e->{
                int id=UserRepository.getLocationIdByName("Gravity");
                float floatRating = Float.parseFloat(ratingGravity.getText());
                UserController.submitReview(id,reviewGravity.getText(),floatRating,usernameGravity2.getText());
                showMessage("Succesful!",1);
            });

            panelAddGravity.add(backToGravityAdd);
            backToGravityAdd.addActionListener(e->goToGravity(frameAddGravity));
            panelAddGravity.add(instructionGravity);
            panelAddGravity.add(usernameGravity2);
            panelAddGravity.add(reviewGravity);
            panelAddGravity.add(ratingGravity);
            panelAddGravity.add(submitGravity);
            frameAddGravity.setContentPane(panelAddGravity);
            frameAddGravity.setVisible(true);


    }
    static JButton backGravity2=new JButton("Back to Gravity");
    public static void goToSeeReviewGravity(JFrame currentFrame){
        currentFrame.dispose();
        frameSeeGravity.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameSeeGravity.setSize(700,300);
        frameSeeGravity.setLocation(450,240);
        panelSeeGravity.setLayout(null);
        backGravity2.setBounds(550,0,150,30);
        UserRepository.loadReviewsIndoorDataGravity();
        tableReviewGravity.setBounds(0, 0, 500, 300);
        panelSeeGravity.add(backGravity2);
        backGravity2.addActionListener(e->goToGravity(frameSeeGravity));
        panelSeeGravity.add(tableReviewGravity);
        frameSeeGravity.setContentPane(panelSeeGravity);
        frameSeeGravity.setVisible(true);

    }

    static void goToFreeWall(JFrame currentFrame) {
        currentFrame.dispose();
        frameFreeWall.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameFreeWall.setLocation(580, 240);
        frameFreeWall.setSize(400, 200);
        panelFreeWall.setLayout(null);
        buttonSiteFreeWall.setBounds(100, 90, 200, 30);
//        labelLeaveARatingFreeWall.setBounds(20, 130, 200, 30);
//        textRatingFreeWall.setBounds(230, 135, 30, 20);
//        buttonSubmitRatingFreeWall.setBounds(260, 130, 125, 30);
//        usernameFreeWall.setBounds(70, 100, 100, 20);
//        passwordFreeWall.setBounds(200, 100, 100, 20);
//        textFreeWall.setBounds(20, 70, 350, 30);
        buttonSiteFreeWall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebsite("https://www.freewall.ro/");
            }
        });
        backFreeWall.setBounds(0, 0, 190, 30);
        backFreeWall.addActionListener(e -> goToIndoor(frameFreeWall));
        panelFreeWall.add(backFreeWall);
//        panelFreeWall.add(textFreeWall);
//        panelFreeWall.add(passwordFreeWall);
//        panelFreeWall.add(usernameFreeWall);
//        panelFreeWall.add(buttonSubmitRatingFreeWall);
        panelFreeWall.add(textRatingFreeWall);
        panelFreeWall.add(labelLeaveARatingFreeWall);
        panelFreeWall.add(buttonSiteFreeWall);
        panelFreeWall.add(buttonSiteFreeWall);
        frameFreeWall.setContentPane(panelFreeWall);
        frameFreeWall.setVisible(true);
    }
    static void goToSkai(JFrame currentFrame) {
        currentFrame.dispose();
        frameSkai.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameSkai.setLocation(580, 240);
        frameSkai.setSize(400, 200);
        panelSkai.setLayout(null);
        buttonSiteSkai.setBounds(100, 90, 200, 30);
        buttonSiteSkai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebsite("https://skaiurbancrag.ro/");
            }
        });
        backSkai.setBounds(0, 0, 190, 30);
        backSkai.addActionListener(e -> goToIndoor(frameSkai));
        panelSkai.add(backSkai);
        panelSkai.add(textRatingSkai);
        panelSkai.add(labelLeaveARatingSkai);
        panelSkai.add(buttonSiteSkai);
        panelSkai.add(buttonSiteSkai);
        frameSkai.setContentPane(panelSkai);
        frameSkai.setVisible(true);
    }
    static void goToCentrala(JFrame currentFrame) {
        currentFrame.dispose();
        frameCentrala.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameCentrala.setLocation(580, 240);
        frameCentrala.setSize(400, 200);
        panelCentrala.setLayout(null);
        buttonSiteCentrala.setBounds(100, 90, 200, 30);
        buttonSiteCentrala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebsite("https://www.centrala.ro/");
            }
        });
        backCentrala.setBounds(0, 0, 190, 30);
        backCentrala.addActionListener(e -> goToIndoor(frameCentrala));
        panelCentrala.add(backCentrala);
        panelCentrala.add(textRatingCentrala);
        panelCentrala.add(labelLeaveARatingCentrala);
        panelCentrala.add(buttonSiteCentrala);
        panelCentrala.add(buttonSiteCentrala);
        frameCentrala.setContentPane(panelCentrala);
        frameCentrala.setVisible(true);
    }
    static void goToOutdoor(JFrame currentFrame){
        currentFrame.dispose();
        frameOutdoor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameOutdoor.setSize(1000,400);
        frameOutdoor.setLocation(300,150);
        panelOutdoor.setLayout(null);
        UserRepository.loadLocationsOutdoorData();
        tableOutdoor.setBounds(50,50,900,100);
        labelChooseOutdoor.setBounds(50,150,200,30);
        buttonTureni.setBounds(50,200,150,30);
        buttonTurzii.setBounds(250,200,150,30);
        buttonRimetea.setBounds(450,200,150,30);
        backOutdoor.setBounds(0,0,150,30);
        panelOutdoor.add(backOutdoor);
        panelOutdoor.add(buttonTureni);
        panelOutdoor.add(buttonTurzii);
        panelOutdoor.add(buttonRimetea);
        panelOutdoor.add(tableOutdoor);
        panelOutdoor.add(labelChooseOutdoor);
        buttonRimetea.addActionListener(e->{
            showMessage("Not implemented yet...",0);
        });
        buttonTurzii.addActionListener(e->{
            showMessage("Not implemented yet...",0);
        });
        buttonTureni.addActionListener(e->{
            showMessage("Not implemented yet...",0);
        });
        backOutdoor.addActionListener(e->goToLocation(frameOutdoor));
        frameOutdoor.setContentPane(panelOutdoor);
        frameOutdoor.setVisible(true);
    }



    private static void openWebsite(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception ex) {
            ex.printStackTrace(); // Handle exceptions appropriately
        }
    }

    public void setVisibility(boolean isVisible){frame1.setVisible(isVisible);}

    public static void showMessage(String message, int option){
        if( option == 0) {
            JOptionPane.showMessageDialog(frame1, message, "Swing Tester", JOptionPane.ERROR_MESSAGE);
        }
        if(option ==1){
            JOptionPane.showMessageDialog(frame1, message, "Swing Tester", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void centerFrameOnScreen(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        int frameWidth = getWidth();
        int frameHeight = getHeight();

        int x = (screenWidth - frameWidth) / 2;
        int y = (screenHeight - frameHeight) / 2;

        frame.setLocation(x, y);
    }



}


