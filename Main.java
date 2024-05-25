import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Main {

    public static void main(String[] args) {
        loginPage frame = new loginPage();
        frame.showLoginPanel();

    }
}

class Account {
    private final String username;
    private final String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}

class loginPage {
    static JFrame frame = new JFrame();
    static JPanel MainloginPanel = new JPanel();
    static JPanel MainSignUpPanel = new JPanel();
    static JPanel MainHomePagePanel = new JPanel();
    private static final Map<String, Account> accountList = new HashMap<>();
    static JLabel errorTextSignUp = new JLabel("USERNAME ALREADY EXIST");
    static JTextField usernameField = new JTextField();
    static JPasswordField passwordField = new JPasswordField();

    static JPanel MainShowDatePanel = new JPanel();
    static JPanel homepageBottomPanel = new JPanel();
    static JPanel MainTicketPanel = new JPanel();
    static JPanel MainPaymentPanel = new JPanel();

    static JLabel concertDateAndTimeChosenText = new JLabel();
    static JLabel concertChosenText = new JLabel();

    static String currentAccountUsed;
    static String eventChosen;
    static String dateAndTimeChosen;

    JLabel welcomeUser = new JLabel();
    JPanel homepageTopPanel = new JPanel();

    JTextField informationNameField = new JTextField();
    JTextField informationMethodField = new JTextField();
    JTextField informationContactField = new JTextField();

    JLabel genAdCountText = new JLabel();
    JLabel premierCountText = new JLabel();
    JLabel vipCountText = new JLabel();

    JLabel vipPurchaseText = new JLabel();
    JLabel premierPurchaseText = new JLabel();
    JLabel genAdPurchaseText = new JLabel();

    JLabel totalPayable = new JLabel();

    JLabel vipSeatsLeft = new JLabel();
    JLabel premierSeatsLeft = new JLabel();
    JLabel genAdSeatsLeft = new JLabel();
    int totalBill;
    public int vipNum;
    public int premierNum;
    public int genAdNum;
    public int vipMax;
    public int premierMax;
    public int genAdMax;
    int vipCount;

    int vipNumDay2;
    int premierNumDay2;
    int genAdNumDay2;
    int vipMaxDay2;
    int premierMaxDay2;
    int genAdMaxDay2;

    int vipNumDay3;
    int premierNumDay3;
    int genAdNumDay3;
    int vipMaxDay3;
    int premierMaxDay3;
    int genAdMaxDay3;

    int chosenday;

    String v = "0";
    String p = "0";
    String g = "0";

    JPanel MainMyReservationPanel = new JPanel();
    JPanel hasReservationPanel = new JPanel();

    JPanel noReservationPanel = new JPanel();

    ImageIcon loginPicture = new ImageIcon("Assets/loginPicture.png");

    ImageIcon logo = new ImageIcon("Assets/logo.png");
    JLabel logoHolder = new JLabel(logo);

    ImageIcon taylorPicSheeshPic = new ImageIcon("Assets/TAYLOR SHEESH.png");

    ImageIcon brunoMoonPic = new ImageIcon("Assets/BRUNO MOON.png");

    JScrollPane scroll = new JScrollPane();

    ImageIcon upcomingPic = new ImageIcon("Assets/upcomingPic.png");

    JLabel upcomingHolder = new JLabel(upcomingPic);
    JPanel upcomingPanel = new JPanel();
    String pathVideo = "Assets/video.mp4";

    JPanel sectionMyReservationPanel = new JPanel();
    JLabel sectionMyReservationText = new JLabel("MY RESERVATIONS");
    JPanel sectionUEPanel = new JPanel();
    JLabel sectionUEText = new JLabel("UPCOMING");
    JPanel sectionHomepagePanel = new JPanel();
    JLabel sectionHomepageText = new JLabel("HOMEPAGE");

    void showLoginPanel() {
        frame.setIconImage(logo.getImage());
        try (BufferedReader reader = new BufferedReader(new FileReader("loginFiles.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(" ");
                if (parts.length == 2) {

                    String a = parts[0];
                    String b = parts[1];

                    Account account = new Account(a, b);
                    accountList.put(a, account);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLayout(null);
        frame.setTitle("TIX.PH");
        // SignUpPanel Visibility
        MainSignUpPanel.setVisible(false);

        // Login Panel
        MainloginPanel.setBackground(Color.black);
        MainloginPanel.setBounds(0, 0, 1280, 720);
        MainloginPanel.setVisible(true);
        MainloginPanel.setLayout(null);

        // Leftside
        JPanel loginPanelLeft = new JPanel();
        loginPanelLeft.setBackground(Color.white);
        loginPanelLeft.setBounds(0, 0, 640, 720);
        loginPanelLeft.setVisible(true);
        loginPanelLeft.setLayout(null);

        // Welcome Text
        JLabel loginPanelWelcomeText = new JLabel("TIX.PH");
        loginPanelWelcomeText.setForeground(new Color(0x6AB6D6));
        loginPanelWelcomeText.setBounds(281, 168, 160, 37);
        loginPanelWelcomeText.setFont(new Font("Inter", Font.BOLD, 30));

        logoHolder.setBounds(308, 135, 44, 30);
        logoHolder.setVisible(true);

        // Username Text
        JLabel loginPanelUsernameText = new JLabel("USERNAME");
        loginPanelUsernameText.setForeground(Color.black);
        loginPanelUsernameText.setBounds(197, 258, 91, 19);
        loginPanelUsernameText.setFont(new Font("Inter", Font.BOLD, 12));

        // Username TextField
        usernameField.setBounds(198, 279, 246, 33);

        // Password Text
        JLabel loginPanelPasswordText = new JLabel("PASSWORD");
        loginPanelPasswordText.setForeground(Color.black);
        loginPanelPasswordText.setBounds(198, 330, 93, 25);
        loginPanelPasswordText.setFont(new Font("Inter", Font.BOLD, 12));

        // PassworTextField
        passwordField.setBounds(198, 353, 246, 33);

        // Error Text
        JLabel errorText = new JLabel("WRONG PASSWORD");
        errorText.setForeground(Color.red);
        errorText.setBounds(310, 390, 300, 25);
        errorText.setFont(new Font("Inter", Font.ITALIC, 12));
        errorText.setVisible(false);
        MainHomePagePanel.setVisible(true);

        // Signup Text
        JLabel signUpText = new JLabel("SIGN UP?");
        signUpText.setForeground(new Color(0x10162D));
        signUpText.setBounds(295, 473, 93, 19);
        signUpText.setFont(new Font("Inter", Font.BOLD, 12));
        signUpText.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("sign in clicked");
                errorText.setVisible(false);
                MainloginPanel.setVisible(false);
                MainSignUpPanel.setVisible(true);
                showSignUpPanel();

            }
        });

        // Login Button
        JButton loginButton = new JButton("LOGIN");
        loginButton.setBackground(new Color(0x6AB6D6));
        loginButton.setBounds(198, 427, 245, 34);
        loginButton.setFont(new Font("Inter", Font.BOLD, 14));
        loginButton.setForeground(Color.white);
        loginButton.setFocusable(false);
        loginButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String userID = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                if (accountList.get(userID) == null) {
                    System.out.println("account not in the system");
                    errorText.setText("ACCOUNT NOT FOUND");
                    errorText.setVisible(true);
                } else {
                    Account account = accountList.get(userID);
                    if (account.getPassword().equals(password)) {
                        System.out.print("Valid credentials for account number " + account.getUsername());
                        currentAccountUsed = userID;
                        MainSignUpPanel.setVisible(false);
                        MainloginPanel.setVisible(false);
                        MainMyReservationPanel.setVisible(false);
                        upcomingPanel.setVisible(false);
                        errorText.setVisible(false);
                        welcomeUser.setText(currentAccountUsed + "!");
                        MainHomePagePanel.setVisible(true);
                        homepageBottomPanel.setVisible(true);
                        homepageTopPanel.setVisible(true);
                        sectionHomepagePanel.setBackground(Color.white);
                        sectionHomepageText.setForeground(new Color(0x498CA9));
                        sectionMyReservationPanel.setBackground(new Color(0xBED8E3));
                        sectionMyReservationText.setForeground(new Color(0x498CA9));
                        sectionUEPanel.setBackground(new Color(0xBED8E3));
                        sectionUEText.setForeground(new Color(0x498CA9));

                    } else {
                        errorText.setText(" WRONG PASSWORD");
                        errorText.setVisible(true);
                    }
                }

            }
        });
        //////////////////////////////////////////////////////////////////////////////////////////////////////
        // Sign up
        MainSignUpPanel.setBackground(Color.GREEN);
        MainSignUpPanel.setBounds(0, 0, 1280, 720);
        MainSignUpPanel.setVisible(false);
        MainSignUpPanel.setLayout(null);

        // Leftside
        JPanel SignupPanelRight = new JPanel();
        SignupPanelRight.setBackground(Color.white);
        SignupPanelRight.setBounds(640, 0, 640, 720);
        SignupPanelRight.setVisible(true);
        SignupPanelRight.setLayout(null);

        // SignUp Text
        JLabel SignUpPanelSignUpText = new JLabel("SIGN UP");
        SignUpPanelSignUpText.setForeground(new Color(0x6AB6D6));
        SignUpPanelSignUpText.setBounds(256, 180, 128, 37);
        SignUpPanelSignUpText.setFont(new Font("Inter", Font.BOLD, 32));

        // Username Text
        JLabel SignUpPanelUsernameText = new JLabel("USERNAME");
        SignUpPanelUsernameText.setForeground(Color.BLACK);
        SignUpPanelUsernameText.setBounds(197, 258, 91, 19);
        SignUpPanelUsernameText.setFont(new Font("Inter", Font.BOLD, 12));

        // Username TextField
        JTextField usernameFieldSignUp = new JTextField();
        usernameFieldSignUp.setBounds(198, 279, 246, 33);

        // Password Text
        JLabel SignUpPanelPasswordText = new JLabel("PASSWORD");
        SignUpPanelPasswordText.setForeground(Color.black);
        SignUpPanelPasswordText.setBounds(198, 330, 93, 25);
        SignUpPanelPasswordText.setFont(new Font("Inter", Font.BOLD, 12));

        // PassworTextField
        JTextField passwordFieldSignUp = new JTextField();
        passwordFieldSignUp.setBounds(198, 353, 246, 33);

        // Join Button
        JButton joinButton = new JButton("JOIN");
        joinButton.setBackground(new Color(0x6AB6D6));
        joinButton.setBounds(198, 427, 245, 34);
        joinButton.setFont(new Font("Inter", Font.BOLD, 14));
        joinButton.setForeground(Color.white);
        joinButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String userID = usernameFieldSignUp.getText();
                String password = passwordFieldSignUp.getText();
                if (accountList.get(userID) == null) {
                    System.out.println("success");
                    Account account = new Account(userID, password);
                    accountList.put(userID, account);
                    usernameField.setText("");
                    passwordField.setText("");

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("loginFiles.txt", true))) {
                        Path path = Paths.get("loginFiles.txt");
                        if (Files.size(path) > 0) {
                            writer.newLine();
                        }

                        writer.write(userID + " " + password);
                    } catch (IOException z) {
                        z.printStackTrace();
                    }

                    try (BufferedWriter writer = new BufferedWriter(
                            new FileWriter("CustomerInformation/" + userID + "Details.txt",
                                    true))) {
                        Path path = Paths.get("CustomerInformation/" + currentAccountUsed + "Details.txt");
                        if (Files.size(path) > 0) {

                        }
                    } catch (IOException z) {
                        z.printStackTrace();
                    }

                    usernameFieldSignUp.setText("");
                    passwordFieldSignUp.setText("");
                    MainSignUpPanel.setVisible(false);
                    MainloginPanel.setVisible(true);
                } else {
                    errorTextSignUp.setVisible(true);
                }

            }
        });

        // Error Text
        errorTextSignUp.setForeground(Color.red);
        errorTextSignUp.setBounds(294, 389, 150, 14);
        errorTextSignUp.setFont(new Font("Inter", Font.ITALIC, 10));
        errorTextSignUp.setVisible(false);

        // Have an account text Text
        JLabel haveAccountText = new JLabel("HAVE AN ACCOUNT?");
        haveAccountText.setForeground(new Color(0x10162D));
        haveAccountText.setBounds(260, 479, 126, 19);
        haveAccountText.setFont(new Font("Inter", Font.BOLD, 12));
        haveAccountText.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                MainSignUpPanel.setVisible(false);
                System.out.println("Back to Login Page");
                usernameField.setText("");
                passwordField.setText("");
                usernameField.setVisible(true);
                passwordField.setVisible(true);
                MainloginPanel.setVisible(true);

            }
        });

        JLabel SignUpPanelTitleText = new JLabel("TIX.PH");
        SignUpPanelTitleText.setForeground(new Color(0x6AB6D6));
        SignUpPanelTitleText.setBounds(470, 49, 150, 37);
        SignUpPanelTitleText.setFont(new Font("Inter", Font.BOLD, 30));

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Homepage
        MainShowDatePanel.setVisible(false);
        MainHomePagePanel.setBackground(Color.blue);
        MainHomePagePanel.setBounds(0, 0, 1280, 720);
        MainHomePagePanel.setVisible(true);
        MainHomePagePanel.setLayout(null);

        // homepage top panel

        homepageTopPanel.setBounds(0, 0, 1280, 111);
        homepageTopPanel.setBackground(new Color(0xBED8E3));
        homepageTopPanel.setLayout(null);
        homepageTopPanel.setVisible(false);

        // Signout
        JLabel signOut = new JLabel("SIGN OUT");
        signOut.setBounds(1140, 43, 112, 24);
        signOut.setFont(new Font("Inter", Font.BOLD, 16));
        signOut.setForeground(new Color(0x498CA9));
        signOut.setVisible(true);
        signOut.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                g = "0";
                v = "0";
                p = "0";
                vipNum = vipMax;
                vipSeatsLeft.setText(vipNum + " LEFT");
                premierNum = premierMax;
                premierSeatsLeft.setText(premierNum + " LEFT");
                genAdNum = genAdMax;
                genAdSeatsLeft.setText(genAdNum + " LEFT");
                genAdCountText.setText(g);
                vipCountText.setText(v);
                premierCountText.setText(g);
                MainHomePagePanel.setVisible(false);
                MainSignUpPanel.setVisible(false);
                MainPaymentPanel.setVisible(false);
                MainTicketPanel.setVisible(false);
                MainShowDatePanel.setVisible(false);
                usernameField.setText("");
                passwordField.setText("");
                MainloginPanel.setVisible(true);
            }

            public void mouseEntered(MouseEvent e) {
                signOut.setForeground(Color.white);
            }

            public void mouseExited(MouseEvent e) {
                signOut.setForeground(new Color(0x498CA9));
            }
        });

        // welcome Panel
        JPanel welcomePanel = new JPanel();
        welcomePanel.setBounds(0, 0, 244, 111);
        welcomePanel.setBackground(new Color(0xBED8E3));
        welcomePanel.setVisible(true);
        welcomePanel.setLayout(null);

        // welcome Panel and user text
        JLabel welcomeText = new JLabel("Welcome,");
        welcomeText.setBounds(30, 25, 100, 24);
        welcomeText.setFont(new Font("Inter", Font.BOLD, 20));
        welcomeText.setForeground(new Color(0x498CA9));
        welcomeText.setVisible(true);

        welcomeUser.setBounds(30, 45, 500, 48);
        welcomeUser.setFont(new Font("Inter", Font.BOLD, 35));
        welcomeUser.setForeground(new Color(0x498CA9));
        welcomeUser.repaint();
        welcomeUser.revalidate();

        // homepage section top panel
        sectionHomepagePanel.setBounds(245, 0, 244, 111);
        sectionHomepagePanel.setBackground(Color.white);
        sectionHomepagePanel.setVisible(true);
        sectionHomepagePanel.setLayout(null);

        sectionHomepageText.setBounds(66, 43, 112, 24);
        sectionHomepageText.setFont(new Font("Inter", Font.BOLD, 18));
        sectionHomepageText.setForeground(new Color(0x498CA9));
        sectionHomepageText.setVisible(true);
        sectionHomepagePanel.add(sectionHomepageText);
        sectionHomepagePanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                sectionHomepagePanel.setBackground(Color.white);
                sectionHomepageText.setForeground(new Color(0x498CA9));
                sectionMyReservationPanel.setBackground(new Color(0xBED8E3));
                sectionMyReservationText.setForeground(new Color(0x498CA9));
                sectionUEPanel.setBackground(new Color(0xBED8E3));
                sectionUEText.setForeground(new Color(0x498CA9));
                g = "0";
                v = "0";
                p = "0";
                vipNum = vipMax;
                vipSeatsLeft.setText(vipNum + " LEFT");
                premierNum = premierMax;
                premierSeatsLeft.setText(premierNum + " LEFT");
                genAdNum = genAdMax;
                genAdSeatsLeft.setText(genAdNum + " LEFT");
                genAdCountText.setText(g);
                vipCountText.setText(v);
                premierCountText.setText(g);

                informationNameField.setText("");
                informationMethodField.setText("");
                informationContactField.setText("");
                MainShowDatePanel.setVisible(false);
                MainMyReservationPanel.setVisible(false);
                upcomingPanel.setVisible(false);
                MainTicketPanel.setVisible(false);
                MainPaymentPanel.setVisible(false);
                MainPaymentPanel.setVisible(false);
                MainTicketPanel.setVisible(false);
                homepageBottomPanel.setVisible(true);
                System.out.println("userr:" + currentAccountUsed);
            }

            public void mouseEntered(MouseEvent e) {
                sectionHomepageText.setForeground(new Color(0x256D8C));
            }

            public void mouseExited(MouseEvent e) {
                sectionHomepageText.setForeground(new Color(0x498CA9));
            }
        });

        // MyReservation section top panel

        sectionMyReservationPanel.setBounds(489, 0, 244, 111);
        sectionMyReservationPanel.setBackground(new Color(0xBED8E3));
        sectionMyReservationPanel.setVisible(true);
        sectionMyReservationPanel.setLayout(null);

        sectionMyReservationText.setBounds(30, 43, 200, 24);
        sectionMyReservationText.setFont(new Font("Inter", Font.BOLD, 18));
        sectionMyReservationText.setForeground(new Color(0x498CA9));
        sectionMyReservationText.setVisible(true);

        scroll.setBounds(149, 191, 982, 316);
        sectionMyReservationPanel.add(sectionMyReservationText);

        sectionMyReservationPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                sectionHomepagePanel.setBackground(new Color(0xBED8E3));
                sectionHomepageText.setForeground(new Color(0x498CA9));
                sectionMyReservationPanel.setBackground(Color.white);
                sectionMyReservationText.setForeground(new Color(0x498CA9));
                sectionUEPanel.setBackground(new Color(0xBED8E3));
                sectionUEText.setForeground(new Color(0x498CA9));

                g = "0";
                v = "0";
                p = "0";
                vipNum = vipMax;
                vipSeatsLeft.setText(vipNum + " LEFT");
                premierNum = premierMax;
                premierSeatsLeft.setText(premierNum + " LEFT");
                genAdNum = genAdMax;
                genAdSeatsLeft.setText(genAdNum + " LEFT");
                genAdCountText.setText(g);
                vipCountText.setText(v);
                premierCountText.setText(g);

                informationNameField.setText("");
                informationMethodField.setText("");
                informationContactField.setText("");
                MainShowDatePanel.setVisible(false);
                MainMyReservationPanel.setVisible(false);
                MainTicketPanel.setVisible(false);
                upcomingPanel.setVisible(false);
                MainPaymentPanel.setVisible(false);
                MainPaymentPanel.setVisible(false);
                MainTicketPanel.setVisible(false);
                homepageBottomPanel.setVisible(false);
                JPanel reservationListPanel = new JPanel();
                reservationListPanel.setBackground(Color.white);
                reservationListPanel.setLayout(new GridLayout(10, 1));
                try (BufferedReader reader = new BufferedReader(
                        new FileReader("CustomerInformation/" + currentAccountUsed + "Details.txt"))) {
                    String line;
                    if ((line = reader.readLine()) != null) {
                        noReservationPanel.setVisible(false);
                        hasReservationPanel.setVisible(true);
                        scroll.setVisible(true);

                        do {
                            System.out.println("HAS LINE");
                            JPanel linePanel = new JPanel();
                            linePanel.setBackground(Color.white);
                            linePanel.setPreferredSize(new Dimension(982, 120));
                            linePanel.setLayout(null);
                            String customerName;
                            String customerAccountName;
                            String vipBought;
                            String premierBought;
                            String genAdBought;
                            String customerEvent;
                            String customerDateAndTime;
                            String customerContactNumer;
                            String customerPaymentMethod;
                            // Split the line into variables
                            String[] parts = line.split(" ");
                            if (parts.length == 9) {
                                customerName = parts[0];
                                customerAccountName = parts[1];
                                vipBought = parts[2];
                                premierBought = parts[3];
                                genAdBought = parts[4];
                                customerEvent = parts[5];
                                customerDateAndTime = parts[6];
                                customerContactNumer = parts[7];
                                customerPaymentMethod = parts[8];
                                JLabel name = new JLabel(customerName.toUpperCase());
                                name.setBounds(49, 21, 200, 23);
                                name.setFont(new Font("Inter", Font.PLAIN, 15));
                                name.setForeground(Color.black);
                                name.setVisible(true);
                                JLabel vipLabel = new JLabel("VIP SEAT - 2,560 PHP x " + vipBought);
                                vipLabel.setBounds(344, 21, 200, 23);
                                vipLabel.setFont(new Font("Inter", Font.PLAIN, 15));
                                vipLabel.setForeground(Color.black);
                                vipLabel.setVisible(true);
                                JLabel premierLabel = new JLabel("PREMIER SEAT - 1,550 PHP x " + premierBought);
                                premierLabel.setBounds(344, 44, 300, 23);
                                premierLabel.setFont(new Font("Inter", Font.PLAIN, 15));
                                premierLabel.setForeground(Color.black);
                                premierLabel.setVisible(true);
                                JLabel genAdLabel = new JLabel("GEN AD SEAT - 890 PHP x " + genAdBought);
                                genAdLabel.setBounds(344, 67, 200, 23);
                                genAdLabel.setFont(new Font("Inter", Font.PLAIN, 15));
                                genAdLabel.setForeground(Color.black);
                                genAdLabel.setVisible(true);
                                JLabel event = new JLabel(customerEvent);
                                event.setBounds(692, 21, 200, 23);
                                event.setFont(new Font("Inter", Font.PLAIN, 15));
                                event.setForeground(Color.black);
                                event.setVisible(true);
                                JLabel dateAndTime = new JLabel(customerDateAndTime);
                                dateAndTime.setBounds(692, 46, 200, 23);
                                dateAndTime.setFont(new Font("Inter", Font.PLAIN, 15));
                                dateAndTime.setForeground(Color.black);
                                dateAndTime.setVisible(true);

                                linePanel.add(name);
                                linePanel.add(vipLabel);
                                linePanel.add(premierLabel);
                                linePanel.add(genAdLabel);
                                linePanel.add(event);
                                linePanel.add(dateAndTime);
                            }

                            reservationListPanel.add(linePanel);
                        } while ((line = reader.readLine()) != null);

                        scroll.setViewportView(reservationListPanel);
                        MainMyReservationPanel.add(scroll);
                    } else {
                        noReservationPanel.setVisible(true);
                        scroll.setVisible(false);
                        ;
                        hasReservationPanel.setVisible(false);
                    }
                } catch (IOException s) {
                    s.printStackTrace();
                }

                MainMyReservationPanel.setVisible(true);
            }

            public void mouseEntered(MouseEvent e) {
                sectionMyReservationText.setForeground(new Color(0x256D8C));
            }

            public void mouseExited(MouseEvent e) {
                sectionMyReservationText.setForeground(new Color(0x498CA9));
            }
        });

        // Upcoming Events section top panel

        sectionUEPanel.setBounds(733, 0, 244, 111);
        sectionUEPanel.setBackground(new Color(0xBED8E3));
        sectionUEPanel.setVisible(true);
        sectionUEPanel.setLayout(null);

        sectionUEText.setBounds(67, 43, 200, 24);
        sectionUEText.setFont(new Font("Inter", Font.BOLD, 18));
        sectionUEText.setForeground(new Color(0x498CA9));
        sectionUEText.setVisible(true);
        sectionUEPanel.add(sectionUEText);

        upcomingPanel.setBounds(0, 105, 1280, 609);
        upcomingPanel.add(upcomingHolder);
        upcomingPanel.setVisible(false);

        sectionUEPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                sectionHomepagePanel.setBackground(new Color(0xBED8E3));
                sectionHomepageText.setForeground(new Color(0x498CA9));
                sectionMyReservationPanel.setBackground(new Color(0xBED8E3));
                sectionMyReservationText.setForeground(new Color(0x498CA9));
                sectionUEPanel.setBackground(Color.white);
                sectionUEText.setForeground(new Color(0x498CA9));
                g = "0";
                v = "0";
                p = "0";
                vipNum = vipMax;
                vipSeatsLeft.setText(vipNum + " LEFT");
                premierNum = premierMax;
                premierSeatsLeft.setText(premierNum + " LEFT");
                genAdNum = genAdMax;
                genAdSeatsLeft.setText(genAdNum + " LEFT");
                genAdCountText.setText(g);
                vipCountText.setText(v);
                premierCountText.setText(g);

                informationNameField.setText("");
                informationMethodField.setText("");
                informationContactField.setText("");
                MainShowDatePanel.setVisible(false);
                MainMyReservationPanel.setVisible(false);
                upcomingPanel.setVisible(false);
                MainTicketPanel.setVisible(false);
                MainPaymentPanel.setVisible(false);
                MainPaymentPanel.setVisible(false);
                MainTicketPanel.setVisible(false);
                homepageBottomPanel.setVisible(false);
                upcomingPanel.setVisible(true);
            }

            public void mouseEntered(MouseEvent e) {
                sectionUEText.setForeground(new Color(0x256D8C));
            }

            public void mouseExited(MouseEvent e) {
                sectionUEText.setForeground(new Color(0x498CA9));
            }
        });

        // welcome user add here
        welcomePanel.add(welcomeUser);
        welcomePanel.add(welcomeText);

        // Add objects to homepage top panel
        homepageTopPanel.add(welcomePanel);
        homepageTopPanel.add(signOut);
        homepageTopPanel.add(sectionHomepagePanel);
        homepageTopPanel.add(sectionMyReservationPanel);
        homepageTopPanel.add(sectionUEPanel);

        // homepageBottomPanel
        homepageBottomPanel.setBounds(0, 111, 1280, 609);
        homepageBottomPanel.setBackground(Color.white);
        homepageBottomPanel.setLayout(null);
        homepageBottomPanel.setVisible(true);

        JLabel eventsText = new JLabel("EVENTS THIS 2024");
        eventsText.setBounds(491, 30, 300, 40);
        eventsText.setFont(new Font("Inter", Font.BOLD, 32));
        eventsText.setForeground(new Color(0x6AB6D6));
        eventsText.setVisible(true);
        homepageBottomPanel.add(eventsText);

        // Taylor Sheesh
        JLabel taylorPic = new JLabel(taylorPicSheeshPic);
        taylorPic.setBounds(289, 85, 330, 420);
        taylorPic.setVisible(true);
        taylorPic.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                eventChosen = "TAYLOR SHEESH";
                concertChosenText.setText("TAYLOR SHEESH");
                MainSignUpPanel.setVisible(false);
                MainloginPanel.setVisible(false);
                MainTicketPanel.setVisible(false);
                MainPaymentPanel.setVisible(false);
                homepageBottomPanel.setVisible(false);
                MainShowDatePanel.setVisible(true);
                System.out.println("taylor clicked");
            }
        });

        JLabel taylorText = new JLabel("TAYLOR SHEESH");
        taylorText.setBounds(360, 525, 200, 24);
        taylorText.setFont(new Font("Inter", Font.BOLD, 20));
        taylorText.setForeground(new Color(0x6AB6D6));
        taylorText.setVisible(true);

        // Bruno Moon
        JLabel brunoPic = new JLabel(brunoMoonPic);
        brunoPic.setBounds(634, 85, 330, 420);
        brunoPic.setVisible(true);

        JLabel brunoText = new JLabel("BRUNO MOON");
        brunoText.setBounds(730, 525, 200, 24);
        brunoText.setFont(new Font("Inter", Font.BOLD, 20));
        brunoText.setForeground(new Color(0x6AB6D6));
        brunoText.setVisible(true);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Show Event date
        homepageBottomPanel.setVisible(false);
        MainShowDatePanel.setBackground(Color.white);
        MainShowDatePanel.setBounds(0, 111, 1280, 609);
        MainShowDatePanel.setVisible(false);
        MainShowDatePanel.setLayout(null);

        JButton backButtonEventChoose = new JButton("BACK");
        backButtonEventChoose.setBackground(new Color(0x498CA9));
        backButtonEventChoose.setBounds(48, 29, 91, 32);
        backButtonEventChoose.setFont(new Font("Inter", Font.BOLD, 20));
        backButtonEventChoose.setForeground(Color.white);
        backButtonEventChoose.setFocusable(false);
        backButtonEventChoose.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                MainSignUpPanel.setVisible(false);
                MainloginPanel.setVisible(false);
                MainTicketPanel.setVisible(false);
                MainPaymentPanel.setVisible(false);
                homepageBottomPanel.setVisible(true);
                MainShowDatePanel.setVisible(false);
            }

            public void mouseEntered(MouseEvent e) {

                backButtonEventChoose.setForeground(new Color(0x256D8C));
            }

            public void mouseExited(MouseEvent e) {
                backButtonEventChoose.setForeground(Color.white);
            }
        });
        MainShowDatePanel.add(backButtonEventChoose);

        // Taylor sheesh
        JLabel taylorPicShowDate = new JLabel(taylorPicSheeshPic);
        taylorPicShowDate.setBounds(199, 91, 330, 420);
        taylorPicShowDate.setVisible(true);
        taylorPicShowDate.setBackground(new Color(0x6AB6D6));

        JLabel taylorTextShowDate = new JLabel("TAYLOR SHEESH");
        taylorTextShowDate.setBounds(284, 525, 250, 24);
        taylorTextShowDate.setFont(new Font("Inter", Font.BOLD, 20));
        taylorTextShowDate.setForeground(new Color(0x6AB6D6));
        taylorTextShowDate.setVisible(true);

        // Date and time text
        JLabel dateTimetext = new JLabel("DATE AND TIME");
        dateTimetext.setBounds(567, 91, 200, 23);
        dateTimetext.setFont(new Font("Inter", Font.BOLD, 20));
        dateTimetext.setForeground(Color.black);
        dateTimetext.setVisible(true);

        // Date panel
        JPanel chooseDatePanel = new JPanel();
        chooseDatePanel.setBounds(567, 126, 514, 385);
        chooseDatePanel.setVisible(true);
        chooseDatePanel.setBackground(new Color(0xF5F5F5));
        chooseDatePanel.setLayout(null);

        // Option1
        JPanel option1 = new JPanel();
        option1.setBounds(22, 24, 471, 104);
        option1.setVisible(true);
        option1.setBackground(new Color(0xBED8E3));

        JLabel option1Date = new JLabel("NOVEMBER 19, 2024");
        option1Date.setBounds(55, 69, 250, 23);
        option1Date.setFont(new Font("Inter", Font.PLAIN, 20));
        option1Date.setForeground(new Color(0x498CA9));
        option1Date.setVisible(true);

        JLabel option1Time = new JLabel("1:30 PM");
        option1Time.setBounds(324, 59, 200, 42);
        option1Time.setFont(new Font("Inter", Font.BOLD, 36));
        option1Time.setForeground(new Color(0x498CA9));
        option1Time.setVisible(true);

        option1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (eventChosen.equals("TAYLOR SHEESH")) {
                    try (BufferedReader reader = new BufferedReader(new FileReader("seatLeft.txt"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {

                            String[] parts = line.split(" ");
                            if (parts.length == 3) {

                                String a = parts[0];
                                String b = parts[1];
                                String c = parts[2];

                                vipNum = Integer.parseInt(a);
                                premierNum = Integer.parseInt(b);
                                genAdNum = Integer.parseInt(c);
                                vipMax = Integer.parseInt(a);
                                premierMax = Integer.parseInt(b);
                                genAdMax = Integer.parseInt(c);
                            }
                        }
                    } catch (IOException a) {
                        a.printStackTrace();
                    }
                    vipNum = vipMax;
                    vipSeatsLeft.setText(vipNum + " LEFT");
                    premierNum = premierMax;
                    premierSeatsLeft.setText(premierNum + " LEFT");
                    genAdNum = genAdMax;
                    genAdSeatsLeft.setText(genAdNum + " LEFT");
                    dateAndTimeChosen = "NOVEMBER 19, 2024 1:30 PM";
                    concertDateAndTimeChosenText.setText("NOVEMBER 19, 2024 1:30 PM");
                    System.out.println("CHOSEN 1");
                    chosenday = 1;
                    MainShowDatePanel.setVisible(false);
                    MainPaymentPanel.setVisible(false);
                    MainTicketPanel.setVisible(true);
                    // chooseTicketTaylor();
                } else {

                }

            }

            public void mouseEntered(MouseEvent e) {
                option1Date.setForeground(Color.white);
                option1Time.setForeground(Color.white);
                option1Date.setFont(new Font("Inter", Font.PLAIN, 22));
                option1Time.setFont(new Font("Inter", Font.BOLD, 38));

            }

            public void mouseExited(MouseEvent e) {
                option1Date.setForeground(new Color(0x498CA9));
                option1Time.setForeground(new Color(0x498CA9));
                option1Date.setFont(new Font("Inter", Font.PLAIN, 20));
                option1Time.setFont(new Font("Inter", Font.BOLD, 36));
            }
        });

        // Option2
        JPanel option2 = new JPanel();
        option2.setBounds(22, 141, 471, 104);
        option2.setVisible(true);
        option2.setBackground(new Color(0xBED8E3));

        JLabel option2Date = new JLabel("NOVEMBER 20, 2024");
        option2Date.setBounds(55, 181, 250, 42);
        option2Date.setFont(new Font("Inter", Font.PLAIN, 20));
        option2Date.setForeground(new Color(0x498CA9));
        option2Date.setVisible(true);

        JLabel option2Time = new JLabel("3:00 PM");
        option2Time.setBounds(324, 174, 200, 42);
        option2Time.setFont(new Font("Inter", Font.BOLD, 36));
        option2Time.setForeground(new Color(0x498CA9));
        option2Time.setVisible(true);

        option2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (eventChosen.equals("TAYLOR SHEESH")) {
                    try (BufferedReader reader = new BufferedReader(new FileReader("seatLeftDay2.txt"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {

                            String[] parts = line.split(" ");
                            if (parts.length == 3) {

                                String a = parts[0];
                                String b = parts[1];
                                String c = parts[2];

                                vipNum = Integer.parseInt(a);
                                premierNum = Integer.parseInt(b);
                                genAdNum = Integer.parseInt(c);
                                vipMax = Integer.parseInt(a);
                                premierMax = Integer.parseInt(b);
                                genAdMax = Integer.parseInt(c);
                            }
                        }
                    } catch (IOException a) {
                        a.printStackTrace();
                    }
                    vipNum = vipMax;
                    vipSeatsLeft.setText(vipNum + " LEFT");
                    premierNum = premierMax;
                    premierSeatsLeft.setText(premierNum + " LEFT");
                    genAdNum = genAdMax;
                    genAdSeatsLeft.setText(genAdNum + " LEFT");
                    dateAndTimeChosen = "NOVEMBER 20, 2024 3:00 PM";
                    concertDateAndTimeChosenText.setText("NOVEMBER 20, 2024 3:00 PM");
                    System.out.println("CHOSEN 2");
                    chosenday = 2;
                    MainShowDatePanel.setVisible(false);
                    MainPaymentPanel.setVisible(false);
                    MainTicketPanel.setVisible(true);
                    // chooseTicketTaylor();
                } else {

                }
            }

            public void mouseEntered(MouseEvent e) {
                option2Date.setForeground(Color.white);
                option2Time.setForeground(Color.white);
                option2Date.setFont(new Font("Inter", Font.PLAIN, 22));
                option2Time.setFont(new Font("Inter", Font.BOLD, 38));

            }

            public void mouseExited(MouseEvent e) {
                option2Date.setForeground(new Color(0x498CA9));
                option2Time.setForeground(new Color(0x498CA9));
                option2Date.setFont(new Font("Inter", Font.PLAIN, 20));
                option2Time.setFont(new Font("Inter", Font.BOLD, 36));
            }

        });

        // Option3
        JPanel option3 = new JPanel();
        option3.setBounds(22, 258, 471, 104);
        option3.setVisible(true);
        option3.setBackground(new Color(0xBED8E3));

        JLabel option3Date = new JLabel("NOVEMBER 21, 2024");
        option3Date.setBounds(55, 293, 250, 23);
        option3Date.setFont(new Font("Inter", Font.PLAIN, 20));
        option3Date.setForeground(new Color(0x498CA9));
        option3Date.setVisible(true);

        JLabel option3Time = new JLabel("1:00 PM");
        option3Time.setBounds(324, 284, 200, 42);
        option3Time.setFont(new Font("Inter", Font.BOLD, 36));
        option3Time.setForeground(new Color(0x498CA9));
        option3Time.setVisible(true);

        option3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (eventChosen.equals("TAYLOR SHEESH")) {
                    try (BufferedReader reader = new BufferedReader(new FileReader("seatLeftDay3.txt"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {

                            String[] parts = line.split(" ");
                            if (parts.length == 3) {

                                String a = parts[0];
                                String b = parts[1];
                                String c = parts[2];

                                vipNum = Integer.parseInt(a);
                                premierNum = Integer.parseInt(b);
                                genAdNum = Integer.parseInt(c);
                                vipMax = Integer.parseInt(a);
                                premierMax = Integer.parseInt(b);
                                genAdMax = Integer.parseInt(c);
                            }
                        }
                    } catch (IOException a) {
                        a.printStackTrace();
                    }
                    vipNum = vipMax;
                    vipSeatsLeft.setText(vipNum + " LEFT");
                    premierNum = premierMax;
                    premierSeatsLeft.setText(premierNum + " LEFT");
                    genAdNum = genAdMax;
                    genAdSeatsLeft.setText(genAdNum + " LEFT");
                    dateAndTimeChosen = "NOVEMBER 21, 2024 1:00 PM";
                    concertDateAndTimeChosenText.setText("NOVEMBER 21, 2024 1:00 PM");
                    System.out.println("CHOSEN 3");
                    chosenday = 3;
                    MainShowDatePanel.setVisible(false);
                    MainPaymentPanel.setVisible(false);
                    MainTicketPanel.setVisible(true);
                    // chooseTicketTaylor();
                } else {

                }
            }

            public void mouseEntered(MouseEvent e) {
                option3Date.setForeground(Color.white);
                option3Time.setForeground(Color.white);
                option3Date.setFont(new Font("Inter", Font.PLAIN, 22));
                option3Time.setFont(new Font("Inter", Font.BOLD, 38));

            }

            public void mouseExited(MouseEvent e) {
                option3Date.setForeground(new Color(0x498CA9));
                option3Time.setForeground(new Color(0x498CA9));
                option3Date.setFont(new Font("Inter", Font.PLAIN, 20));
                option3Time.setFont(new Font("Inter", Font.BOLD, 36));
            }
        });

        chooseDatePanel.add(option1Date);
        chooseDatePanel.add(option2Date);
        chooseDatePanel.add(option3Date);
        chooseDatePanel.add(option1Time);
        chooseDatePanel.add(option2Time);
        chooseDatePanel.add(option3Time);
        chooseDatePanel.add(option1);
        chooseDatePanel.add(option2);
        chooseDatePanel.add(option3);
        // Add components
        MainShowDatePanel.add(taylorPicShowDate);
        MainShowDatePanel.add(taylorTextShowDate);
        MainShowDatePanel.add(dateTimetext);
        MainShowDatePanel.add(chooseDatePanel);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // TicketChoose
        MainTicketPanel.setBackground(Color.white);
        MainTicketPanel.setBounds(0, 111, 1280, 609);
        MainTicketPanel.setVisible(false);
        MainTicketPanel.setLayout(null);

        // Back Button for Date and time
        JButton backButtonTicketChoose = new JButton("BACK");
        backButtonTicketChoose.setBackground(new Color(0x498CA9));
        backButtonTicketChoose.setBounds(48, 29, 91, 32);
        backButtonTicketChoose.setFont(new Font("Inter", Font.BOLD, 20));
        backButtonTicketChoose.setForeground(Color.white);
        backButtonTicketChoose.setFocusable(false);
        backButtonTicketChoose.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                g = "0";
                v = "0";
                p = "0";
                vipNum = vipMax;
                vipSeatsLeft.setText(vipNum + " LEFT");
                premierNum = premierMax;
                premierSeatsLeft.setText(premierNum + " LEFT");
                genAdNum = genAdMax;
                genAdSeatsLeft.setText(genAdNum + " LEFT");
                genAdCountText.setText(g);
                vipCountText.setText(v);
                premierCountText.setText(g);

                MainSignUpPanel.setVisible(false);
                MainloginPanel.setVisible(false);
                MainTicketPanel.setVisible(false);
                MainPaymentPanel.setVisible(false);
                homepageBottomPanel.setVisible(false);
                MainShowDatePanel.setVisible(true);
            }

            public void mouseEntered(MouseEvent e) {

                backButtonTicketChoose.setForeground(new Color(0x256D8C));
            }

            public void mouseExited(MouseEvent e) {
                backButtonTicketChoose.setForeground(Color.white);
            }
        });

        MainTicketPanel.add(backButtonTicketChoose);

        // Taylor pic and text
        JLabel taylorPicTickets = new JLabel(taylorPicSheeshPic);
        taylorPicTickets.setBounds(199, 91, 330, 420);
        taylorPicTickets.setVisible(true);

        JLabel taylorTextTickets = new JLabel("TAYLOR SHEESH");
        taylorTextTickets.setBounds(284, 525, 250, 24);
        taylorTextTickets.setFont(new Font("Inter", Font.BOLD, 20));
        taylorTextTickets.setForeground(new Color(0x6AB6D6));
        taylorTextTickets.setVisible(true);

        JLabel dateTimetextTickets = new JLabel("AVAIL YOUR TICKET!");
        dateTimetextTickets.setBounds(567, 91, 250, 23);
        dateTimetextTickets.setFont(new Font("Inter", Font.BOLD, 20));
        dateTimetextTickets.setForeground(Color.black);
        dateTimetextTickets.setVisible(true);

        JPanel chooseTicketPanel = new JPanel();
        chooseTicketPanel.setBounds(567, 134, 594, 377);
        chooseTicketPanel.setVisible(true);
        chooseTicketPanel.setBackground(new Color(0xF5F5F5));
        chooseTicketPanel.setLayout(null);

        // VIP TICKETS
        JPanel vipPanel = new JPanel();
        vipPanel.setBounds(22, 39, 311, 65);
        vipPanel.setVisible(true);
        vipPanel.setBackground(new Color(0xBED8E3));

        JLabel vipText = new JLabel("VIP SEAT [2,650 PHP]");
        vipText.setBounds(48, 60, 250, 23);
        vipText.setFont(new Font("Inter", Font.BOLD, 20));
        vipText.setForeground(new Color(0x256D8C));
        vipText.setVisible(true);

        JPanel vipMinusPanel = new JPanel();
        vipMinusPanel.setBounds(333, 39, 56, 65);
        vipMinusPanel.setVisible(true);
        vipMinusPanel.setBackground(new Color(0x6AB6D6));

        JLabel vipMinusText = new JLabel("-");
        vipMinusText.setBounds(351, 57, 250, 23);
        vipMinusText.setFont(new Font("Inter", Font.BOLD, 40));
        vipMinusText.setForeground(new Color(0x256D8C));
        vipMinusText.setVisible(true);

        vipSeatsLeft.setText(vipNum + " LEFT");
        vipSeatsLeft.setBounds(513, 63, 250, 23);
        vipSeatsLeft.setFont(new Font("Inter", Font.BOLD, 14));
        vipSeatsLeft.setForeground(new Color(0x256D8C));
        vipSeatsLeft.setVisible(true);

        JPanel vipCountPanel = new JPanel();
        vipCountPanel.setBounds(389, 39, 56, 65);
        vipCountPanel.setVisible(true);
        vipCountPanel.setBackground(new Color(0x90C9E1));

        vipCountText.setText(v);
        vipCountText.setBounds(407, 53, 250, 40);
        vipCountText.setFont(new Font("Inter", Font.BOLD, 40));
        vipCountText.setForeground(new Color(0x256D8C));
        vipCountText.setVisible(true);

        JPanel vipAddPanel = new JPanel();
        vipAddPanel.setBounds(445, 39, 56, 65);
        vipAddPanel.setVisible(true);
        vipAddPanel.setBackground(new Color(0x6AB6D6));

        JLabel vipAddText = new JLabel("+");
        vipAddText.setBounds(464, 60, 250, 23);
        vipAddText.setFont(new Font("Inter", Font.BOLD, 40));
        vipAddText.setForeground(new Color(0x256D8C));
        vipAddText.setVisible(true);

        vipMinusPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (vipNum >= vipMax) {
                } else {
                    vipNum = vipNum + 1;
                    int x = Integer.parseInt(v);
                    x = x - 1;
                    v = String.valueOf(x);
                    vipCountText.setText(v);
                    vipSeatsLeft.setText(vipNum + " LEFT");
                }

            }

            public void mouseEntered(MouseEvent e) {
                vipMinusText.setForeground(Color.white);
            }

            public void mouseExited(MouseEvent e) {
                vipMinusText.setForeground(new Color(0x256D8C));
            }
        });

        vipAddPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = Integer.parseInt(v);
                x = x + 1;
                v = String.valueOf(x);
                vipCountText.setText(v);

                vipCountText.setText(v);
                vipNum = vipNum - 1;
                vipSeatsLeft.setText(vipNum + " LEFT");
            }

            public void mouseEntered(MouseEvent e) {
                vipAddText.setForeground(Color.white);
            }

            public void mouseExited(MouseEvent e) {
                vipAddText.setForeground(new Color(0x256D8C));
            }
        });

        // Premier tickets
        JPanel premierPanel = new JPanel();
        premierPanel.setBounds(22, 104, 311, 65);
        premierPanel.setVisible(true);
        premierPanel.setBackground(new Color(0xBED8E3));

        JLabel premierText = new JLabel("PREMIER SEAT [1,550 PHP]");
        premierText.setBounds(48, 125, 300, 23);
        premierText.setFont(new Font("Inter", Font.BOLD, 20));
        premierText.setForeground(new Color(0x256D8C));
        premierText.setVisible(true);

        JPanel premierMinusPanel = new JPanel();
        premierMinusPanel.setBounds(333, 104, 56, 65);
        premierMinusPanel.setVisible(true);
        premierMinusPanel.setBackground(new Color(0x6AB6D6));

        JLabel premierMinusText = new JLabel("-");
        premierMinusText.setBounds(351, 122, 250, 23);
        premierMinusText.setFont(new Font("Inter", Font.BOLD, 40));
        premierMinusText.setForeground(new Color(0x256D8C));
        premierMinusText.setVisible(true);

        JPanel premierCountPanel = new JPanel();
        premierCountPanel.setBounds(389, 104, 56, 65);
        premierCountPanel.setVisible(true);
        premierCountPanel.setBackground(new Color(0x90C9E1));

        premierCountText.setText(g);
        premierCountText.setBounds(407, 115, 250, 40);
        premierCountText.setFont(new Font("Inter", Font.BOLD, 40));
        premierCountText.setForeground(new Color(0x256D8C));
        premierCountText.setVisible(true);

        JPanel premierAddPanel = new JPanel();
        premierAddPanel.setBounds(445, 104, 56, 65);
        premierAddPanel.setVisible(true);
        premierAddPanel.setBackground(new Color(0x6AB6D6));

        JLabel premierAddText = new JLabel("+");
        premierAddText.setBounds(464, 123, 250, 23);
        premierAddText.setFont(new Font("Inter", Font.BOLD, 40));
        premierAddText.setForeground(new Color(0x256D8C));
        premierAddText.setVisible(true);

        premierSeatsLeft.setText(premierNum + " LEFT");
        premierSeatsLeft.setBounds(513, 129, 250, 23);
        premierSeatsLeft.setFont(new Font("Inter", Font.BOLD, 14));
        premierSeatsLeft.setForeground(new Color(0x256D8C));
        premierSeatsLeft.setVisible(true);

        premierMinusPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (premierNum >= premierMax) {
                } else {
                    premierNum = premierNum + 1;
                    int x = Integer.parseInt(p);
                    x = x - 1;
                    p = String.valueOf(x);
                    premierCountText.setText(p);
                    premierSeatsLeft.setText(premierNum + " LEFT");
                }

            }

            public void mouseEntered(MouseEvent e) {
                premierMinusText.setForeground(Color.white);
            }

            public void mouseExited(MouseEvent e) {
                premierMinusText.setForeground(new Color(0x256D8C));
            }
        });

        premierAddPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = Integer.parseInt(p);
                x = x + 1;
                p = String.valueOf(x);
                premierCountText.setText(p);
                premierCountText.setText(p);
                premierNum = premierNum - 1;
                premierSeatsLeft.setText(premierNum + " LEFT");
            }

            public void mouseEntered(MouseEvent e) {
                premierAddText.setForeground(Color.white);
            }

            public void mouseExited(MouseEvent e) {
                premierAddText.setForeground(new Color(0x256D8C));
            }
        });

        // genAd tickets
        JPanel genAdPanel = new JPanel();
        genAdPanel.setBounds(22, 169, 311, 65);
        genAdPanel.setVisible(true);
        genAdPanel.setBackground(new Color(0xBED8E3));

        JLabel genAdText = new JLabel("GEN AD SEAT [890 PHP]");
        genAdText.setBounds(48, 190, 300, 23);
        genAdText.setFont(new Font("Inter", Font.BOLD, 20));
        genAdText.setForeground(new Color(0x256D8C));
        genAdText.setVisible(true);

        JPanel genAdMinusPanel = new JPanel();
        genAdMinusPanel.setBounds(333, 169, 56, 65);
        genAdMinusPanel.setVisible(true);
        genAdMinusPanel.setBackground(new Color(0x6AB6D6));

        JLabel genAdMinusText = new JLabel("-");
        genAdMinusText.setBounds(351, 187, 250, 23);
        genAdMinusText.setFont(new Font("Inter", Font.BOLD, 40));
        genAdMinusText.setForeground(new Color(0x256D8C));
        genAdMinusText.setVisible(true);

        JPanel genAdCountPanel = new JPanel();
        genAdCountPanel.setBounds(389, 169, 56, 65);
        genAdCountPanel.setVisible(true);
        genAdCountPanel.setBackground(new Color(0x90C9E1));

        genAdCountText.setText(g);
        genAdCountText.setBounds(407, 183, 250, 40);
        genAdCountText.setFont(new Font("Inter", Font.BOLD, 40));
        genAdCountText.setForeground(new Color(0x256D8C));
        genAdCountText.setVisible(true);

        JPanel genAdAddPanel = new JPanel();
        genAdAddPanel.setBounds(445, 169, 56, 65);
        genAdAddPanel.setVisible(true);
        genAdAddPanel.setBackground(new Color(0x6AB6D6));

        JLabel genAdAddText = new JLabel("+");
        genAdAddText.setBounds(464, 189, 250, 23);
        genAdAddText.setFont(new Font("Inter", Font.BOLD, 40));
        genAdAddText.setForeground(new Color(0x256D8C));
        genAdAddText.setVisible(true);

        genAdSeatsLeft.setText(genAdNum + " LEFT");
        genAdSeatsLeft.setBounds(513, 194, 250, 23);
        genAdSeatsLeft.setFont(new Font("Inter", Font.BOLD, 14));
        genAdSeatsLeft.setForeground(new Color(0x256D8C));
        genAdSeatsLeft.setVisible(true);

        genAdMinusPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (genAdNum >= genAdMax) {
                } else {
                    genAdNum = genAdNum + 1;
                    int x = Integer.parseInt(g);
                    x = x - 1;
                    g = String.valueOf(x);
                    genAdCountText.setText(g);
                    genAdSeatsLeft.setText(genAdNum + " LEFT");
                }

            }

            public void mouseEntered(MouseEvent e) {
                genAdMinusText.setForeground(Color.white);
            }

            public void mouseExited(MouseEvent e) {
                genAdMinusText.setForeground(new Color(0x256D8C));
            }
        });

        genAdAddPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = Integer.parseInt(g);
                x = x + 1;
                g = String.valueOf(x);
                genAdCountText.setText(g);

                genAdCountText.setText(g);
                genAdNum = genAdNum - 1;
                genAdSeatsLeft.setText(genAdNum + " LEFT");
            }

            public void mouseEntered(MouseEvent e) {
                genAdAddText.setForeground(Color.white);
            }

            public void mouseExited(MouseEvent e) {
                genAdAddText.setForeground(new Color(0x256D8C));
            }
        });

        JPanel proceedPanel = new JPanel();
        proceedPanel.setBounds(183, 279, 238, 58);
        proceedPanel.setVisible(true);
        proceedPanel.setBackground(new Color(0x498CA9));

        JLabel proceedText = new JLabel("PROCEED");
        proceedText.setBounds(250, 295, 250, 28);
        proceedText.setFont(new Font("Inter", Font.BOLD, 24));
        proceedText.setForeground(Color.white);
        proceedText.setVisible(true);

        proceedPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int q = Integer.parseInt(v);
                int w = Integer.parseInt(p);
                int m = Integer.parseInt(g);
                if ((q == 0) && (w == 0) && (m == 0)) {
                    JOptionPane.showMessageDialog(
                            null,
                            "KINDLY ATLEAST PURCHASE ONE TICKET",
                            "DEAR CUSTOMER",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    MainTicketPanel.setVisible(false);
                    System.out.println("Proceed to payment");
                    totalBill = (q * 2560) + (w * 1550) + (m * 890);
                    System.out.println(totalBill);
                    String o = String.valueOf(totalBill);
                    totalPayable.setText(o);
                    premierPurchaseText.setText("PREMIER SEAT - 1550 PHP x " + p);
                    vipPurchaseText.setText("VIP SEAT - 2560 PHP x " + v);
                    genAdPurchaseText.setText("GEN AD SEAT - 890 PHP x " + g);
                    MainPaymentPanel.setVisible(true);
                }

                // paymentPage();
            }

            public void mouseEntered(MouseEvent e) {
                proceedText.setForeground(new Color(0x256D8C));
            }

            public void mouseExited(MouseEvent e) {
                proceedText.setForeground(Color.white);
            }
        });

        MainTicketPanel.add(taylorPicTickets);
        MainTicketPanel.add(taylorTextTickets);
        MainTicketPanel.add(dateTimetext);
        MainTicketPanel.add(chooseTicketPanel);

        chooseTicketPanel.add(vipSeatsLeft);
        chooseTicketPanel.add(premierSeatsLeft);
        chooseTicketPanel.add(genAdSeatsLeft);
        chooseTicketPanel.add(vipText);
        chooseTicketPanel.add(vipPanel);
        chooseTicketPanel.add(vipMinusText);
        chooseTicketPanel.add(vipMinusPanel);
        chooseTicketPanel.add(vipCountText);
        chooseTicketPanel.add(vipCountPanel);
        chooseTicketPanel.add(vipAddText);
        chooseTicketPanel.add(vipAddPanel);
        chooseTicketPanel.add(proceedText);
        chooseTicketPanel.add(proceedPanel);

        chooseTicketPanel.add(premierText);
        chooseTicketPanel.add(premierPanel);
        chooseTicketPanel.add(premierMinusText);
        chooseTicketPanel.add(premierMinusPanel);
        chooseTicketPanel.add(premierCountText);
        chooseTicketPanel.add(premierCountPanel);
        chooseTicketPanel.add(premierAddText);
        chooseTicketPanel.add(premierAddPanel);

        chooseTicketPanel.add(genAdText);
        chooseTicketPanel.add(genAdPanel);
        chooseTicketPanel.add(genAdMinusText);
        chooseTicketPanel.add(genAdMinusPanel);
        chooseTicketPanel.add(genAdCountText);
        chooseTicketPanel.add(genAdCountPanel);
        chooseTicketPanel.add(genAdAddText);
        chooseTicketPanel.add(genAdAddPanel);

        chooseTicketPanel.add(genAdText);
        chooseTicketPanel.add(genAdPanel);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Payment page

        JButton backButton = new JButton("BACK");
        backButton.setBackground(new Color(0x498CA9));
        backButton.setBounds(48, 29, 91, 32);
        backButton.setFont(new Font("Inter", Font.BOLD, 20));
        backButton.setForeground(Color.white);
        backButton.setFocusable(false);
        backButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                informationContactField.setText("");
                informationMethodField.setText("");
                informationNameField.setText("");
                MainSignUpPanel.setVisible(false);
                MainloginPanel.setVisible(false);
                MainTicketPanel.setVisible(true);
                MainPaymentPanel.setVisible(false);
                homepageBottomPanel.setVisible(false);
                MainShowDatePanel.setVisible(false);
            }

            public void mouseEntered(MouseEvent e) {

                backButton.setForeground(new Color(0x256D8C));
            }

            public void mouseExited(MouseEvent e) {
                backButton.setForeground(Color.white);
            }
        });

        MainPaymentPanel.setBackground(Color.white);
        MainPaymentPanel.setBounds(0, 111, 1280, 609);
        MainPaymentPanel.setVisible(false);
        MainPaymentPanel.setLayout(null);
        MainPaymentPanel.add(backButton);

        // Text outside
        JLabel totalText = new JLabel("TOTAL");
        totalText.setBounds(280, 80, 300, 25);
        totalText.setFont(new Font("Inter", Font.BOLD, 20));
        totalText.setForeground(Color.black);
        totalText.setVisible(true);

        JLabel informationText = new JLabel("INFORMATION");
        informationText.setBounds(625, 80, 300, 25);
        informationText.setFont(new Font("Inter", Font.BOLD, 20));
        informationText.setForeground(Color.black);
        informationText.setVisible(true);

        // left panel
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(0xF5F5F5));
        leftPanel.setBounds(280, 112, 330, 387);
        leftPanel.setVisible(true);
        leftPanel.setLayout(null);

        // Right panel
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(0xF5F5F5));
        rightPanel.setBounds(625, 112, 376, 387);
        rightPanel.setVisible(true);
        rightPanel.setLayout(null);

        JLabel concertText = new JLabel("CONCERT");
        concertText.setBounds(315, 140, 300, 25);
        concertText.setFont(new Font("Inter", Font.BOLD, 16));
        concertText.setForeground(Color.black);
        concertText.setVisible(true);

        concertChosenText.repaint();
        concertChosenText.setBounds(315, 159, 300, 25);
        concertChosenText.setFont(new Font("Inter", Font.PLAIN, 16));
        concertChosenText.setForeground(Color.black);
        concertChosenText.setVisible(true);

        concertDateAndTimeChosenText.setText(dateAndTimeChosen);
        concertDateAndTimeChosenText.repaint();
        concertDateAndTimeChosenText.setBounds(315, 178, 300, 25);
        concertDateAndTimeChosenText.setFont(new Font("Inter", Font.PLAIN, 16));
        concertDateAndTimeChosenText.setForeground(Color.black);
        concertDateAndTimeChosenText.setVisible(true);

        JLabel purchaseText = new JLabel("PURCHASED");
        purchaseText.setBounds(315, 245, 300, 25);
        purchaseText.setFont(new Font("Inter", Font.BOLD, 16));
        purchaseText.setForeground(Color.black);
        purchaseText.setVisible(true);

        vipPurchaseText.setBounds(315, 273, 300, 25);
        vipPurchaseText.setFont(new Font("Inter", Font.PLAIN, 16));
        vipPurchaseText.setForeground(Color.black);
        vipPurchaseText.setVisible(true);

        premierPurchaseText.setBounds(315, 292, 300, 25);
        premierPurchaseText.setFont(new Font("Inter", Font.PLAIN, 16));
        premierPurchaseText.setForeground(Color.black);
        premierPurchaseText.setVisible(true);

        genAdPurchaseText.setBounds(315, 311, 300, 25);
        genAdPurchaseText.setFont(new Font("Inter", Font.PLAIN, 16));
        genAdPurchaseText.setForeground(Color.black);
        genAdPurchaseText.setVisible(true);

        JLabel totalBillText = new JLabel("TOTAL");
        totalBillText.setBounds(315, 374, 300, 25);
        totalBillText.setFont(new Font("Inter", Font.BOLD, 20));
        totalBillText.setForeground(Color.black);
        totalBillText.setVisible(true);

        totalPayable.setBounds(500, 374, 300, 25);
        totalPayable.setFont(new Font("Inter", Font.BOLD, 25));
        totalPayable.setForeground(Color.black);
        totalPayable.setVisible(true);

        // InformationSide
        JLabel namePurchasedText = new JLabel("NAME");
        namePurchasedText.setBounds(652, 156, 300, 25);
        namePurchasedText.setFont(new Font("Inter", Font.BOLD, 12));
        namePurchasedText.setForeground(Color.black);
        namePurchasedText.setVisible(true);

        JLabel contactPurchasedText = new JLabel("CONTACT NUMBER");
        contactPurchasedText.setBounds(652, 236, 300, 25);
        contactPurchasedText.setFont(new Font("Inter", Font.BOLD, 12));
        contactPurchasedText.setForeground(Color.black);
        contactPurchasedText.setVisible(true);

        JLabel methodPurchasedText = new JLabel("PAYMENT METHOD");
        methodPurchasedText.setBounds(652, 314, 300, 25);
        methodPurchasedText.setFont(new Font("Inter", Font.BOLD, 12));
        methodPurchasedText.setForeground(Color.black);
        methodPurchasedText.setVisible(true);

        informationNameField.setBounds(653, 180, 310, 33);
        informationContactField.setBounds(653, 258, 310, 33);
        informationMethodField.setBounds(653, 336, 310, 33);

        JButton finishButton = new JButton("DONE");
        finishButton.setBackground(new Color(0x498CA9));
        finishButton.setBounds(653, 433, 309, 33);
        finishButton.setFont(new Font("Inter", Font.BOLD, 20));
        finishButton.setForeground(Color.white);
        finishButton.setFocusable(false);
        finishButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (informationNameField.getText().equals("") || informationContactField.getText().equals("") ||
                        informationMethodField.getText().equals("")) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Please fill up all the areas.",
                            "DEAR CUSTOMER",
                            JOptionPane.WARNING_MESSAGE);
                } else {

                    try (BufferedWriter writer = new BufferedWriter(
                            new FileWriter("CustomerInformation/" + currentAccountUsed + "Details.txt", true))) {
                        Path path = Paths.get("CustomerInformation/" + currentAccountUsed + "Details.txt");
                        if (Files.size(path) > 0) {
                            writer.newLine();
                        }
                        writer.write(informationNameField.getText() + " " + currentAccountUsed + " "
                                + vipCountText.getText() + " " +
                                premierCountText.getText() + " " + genAdCountText.getText() + " " + eventChosen + " "
                                + dateAndTimeChosen + " "
                                + informationContactField.getText() + " " + informationMethodField.getText());
                    } catch (IOException z) {
                        z.printStackTrace();
                    }

                    switch (chosenday) {
                        case 1:
                            try (BufferedWriter writer = new BufferedWriter(new FileWriter("seatLeft.txt", false))) {
                                writer.write(vipNum + " " + premierNum + " " + genAdNum);
                            } catch (IOException z) {
                                z.printStackTrace();
                            }
                            break;
                        case 2:
                            try (BufferedWriter writer = new BufferedWriter(
                                    new FileWriter("seatLeftDay2.txt", false))) {
                                writer.write(vipNum + " " + premierNum + " " + genAdNum);
                            } catch (IOException z) {
                                z.printStackTrace();
                            }
                            break;
                        case 3:
                            try (BufferedWriter writer = new BufferedWriter(
                                    new FileWriter("seatLeftDay3.txt", false))) {
                                writer.write(vipNum + " " + premierNum + " " + genAdNum);
                            } catch (IOException z) {
                                z.printStackTrace();
                            }
                            break;

                        default:
                            break;
                    }

                    vipMax = vipNum;
                    premierMax = premierNum;
                    genAdMax = genAdNum;
                    vipCountText.setText(vipNum + " LEFT");
                    premierCountText.setText(premierNum + " LEFT");
                    genAdCountText.setText(genAdNum + " LEFT");

                    MainMyReservationPanel.setVisible(false);
                    upcomingPanel.setVisible(false);
                    MainPaymentPanel.setVisible(false);
                    homepageBottomPanel.setVisible(true);

                    JOptionPane.showMessageDialog(
                            null,
                            "THANK YOU FOR PURCHASING",
                            "DEAR CUSTOMER",
                            JOptionPane.PLAIN_MESSAGE);

                }

            }

            public void mouseEntered(MouseEvent e) {
                finishButton.setBackground(new Color(0x6AB6D6));
            }

            public void mouseExited(MouseEvent e) {
                finishButton.setBackground(new Color(0x498CA9));
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }
        });
        // Add to Payment Panel

        MainPaymentPanel.add(totalPayable);
        MainPaymentPanel.add(finishButton);
        MainPaymentPanel.add(namePurchasedText);
        MainPaymentPanel.add(contactPurchasedText);
        MainPaymentPanel.add(methodPurchasedText);
        MainPaymentPanel.add(informationNameField);
        MainPaymentPanel.add(informationContactField);
        MainPaymentPanel.add(informationMethodField);
        MainPaymentPanel.add(concertChosenText);
        MainPaymentPanel.add(concertDateAndTimeChosenText);
        MainPaymentPanel.add(concertText);
        MainPaymentPanel.add(purchaseText);
        MainPaymentPanel.add(vipPurchaseText);
        MainPaymentPanel.add(premierPurchaseText);
        MainPaymentPanel.add(genAdPurchaseText);
        MainPaymentPanel.add(totalBillText);

        MainPaymentPanel.add(leftPanel);
        MainPaymentPanel.add(rightPanel);
        MainPaymentPanel.add(totalText);
        MainPaymentPanel.add(informationText);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // MyReservation
        MainMyReservationPanel.setBackground(Color.white);
        MainMyReservationPanel.setBounds(0, 111, 1280, 609);
        MainMyReservationPanel.setVisible(false);
        MainMyReservationPanel.setLayout(null);

        JLabel myReservationText = new JLabel("MY RESERVATION");
        myReservationText.setBounds(169, 62, 400, 50);
        myReservationText.setFont(new Font("Inter", Font.BOLD, 36));
        myReservationText.setForeground(new Color(0x256D8C));
        myReservationText.setVisible(true);

        hasReservationPanel.setBackground(Color.white);
        hasReservationPanel.setBounds(149, 121, 982, 70);
        hasReservationPanel.setVisible(false);
        hasReservationPanel.setLayout(null);
        hasReservationPanel.setBorder(BorderFactory.createLineBorder(new Color(0x256D8C), 3));

        JLabel hasReservationName = new JLabel("NAME");
        hasReservationName.setBounds(49, 10, 400, 50);
        hasReservationName.setFont(new Font("Inter", Font.BOLD, 20));
        hasReservationName.setForeground(new Color(0x256D8C));
        hasReservationName.setVisible(true);

        JLabel hasReservationPurchaseDetails = new JLabel("PURCHASE DETAILS");
        hasReservationPurchaseDetails.setBounds(334, 10, 400, 50);
        hasReservationPurchaseDetails.setFont(new Font("Inter", Font.BOLD, 20));
        hasReservationPurchaseDetails.setForeground(new Color(0x256D8C));
        hasReservationPurchaseDetails.setVisible(true);

        JLabel hasReservationEventDetails = new JLabel("EVENT DETAILS");
        hasReservationEventDetails.setBounds(693, 10, 400, 50);
        hasReservationEventDetails.setFont(new Font("Inter", Font.BOLD, 20));
        hasReservationEventDetails.setForeground(new Color(0x256D8C));
        hasReservationEventDetails.setVisible(true);

        hasReservationPanel.add(hasReservationName);
        hasReservationPanel.add(hasReservationPurchaseDetails);
        hasReservationPanel.add(hasReservationEventDetails);

        noReservationPanel.setBackground(Color.white);
        noReservationPanel.setBounds(149, 123, 982, 375);
        noReservationPanel.setVisible(false);
        noReservationPanel.setLayout(null);
        noReservationPanel.setBorder(BorderFactory.createLineBorder(new Color(0x256D8C), 3));

        JLabel noReservationText = new JLabel("NO RESERVATION");
        noReservationText.setBounds(401, 170, 400, 50);
        noReservationText.setFont(new Font("Inter", Font.BOLD, 20));
        noReservationText.setForeground(new Color(0x256D8C));
        noReservationText.setVisible(true);

        noReservationPanel.add(noReservationText);

        MainMyReservationPanel.add(noReservationPanel);
        MainMyReservationPanel.add(hasReservationPanel);
        MainMyReservationPanel.add(myReservationText);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Addto bottom homepage
        homepageBottomPanel.add(taylorPic);
        homepageBottomPanel.add(taylorText);
        homepageBottomPanel.add(brunoPic);
        homepageBottomPanel.add(brunoText);

        // add objects to homepage panel
        MainHomePagePanel.add(homepageTopPanel);
        MainHomePagePanel.add(homepageBottomPanel);
        MainHomePagePanel.add(MainShowDatePanel);
        MainHomePagePanel.add(MainTicketPanel);
        MainHomePagePanel.add(MainPaymentPanel);
        MainHomePagePanel.add(MainMyReservationPanel);
        MainHomePagePanel.add(upcomingPanel);

        // Leftside
        JLabel SignupPanelLeft = new JLabel(loginPicture);
        SignupPanelLeft.setBounds(0, 0, 640, 720);
        SignupPanelLeft.setLayout(null);

        // Add to Right side of Panel
        SignupPanelRight.add(SignUpPanelSignUpText);
        SignupPanelRight.add(SignUpPanelUsernameText);
        SignupPanelRight.add(usernameFieldSignUp);
        SignupPanelRight.add(SignUpPanelPasswordText);
        SignupPanelRight.add(passwordFieldSignUp);
        SignupPanelRight.add(joinButton);
        SignupPanelRight.add(haveAccountText);
        SignupPanelRight.add(errorTextSignUp);
        SignupPanelRight.add(SignUpPanelTitleText);

        // Add to Main Panel
        MainSignUpPanel.add(SignupPanelRight);
        MainSignUpPanel.add(SignupPanelLeft);

        // Rightside
        JLabel loginPanelRight = new JLabel(loginPicture);
        loginPanelRight.setBounds(640, 0, 640, 720);
        loginPanelRight.setVisible(true);

        // Add to LoginPage
        MainloginPanel.add(loginPanelLeft);
        MainloginPanel.add(loginPanelRight);
        // Add to Left side of LoginPage
        loginPanelLeft.add(logoHolder);
        loginPanelLeft.add(loginPanelWelcomeText);
        loginPanelLeft.add(loginPanelUsernameText);
        loginPanelLeft.add(loginPanelPasswordText);
        loginPanelLeft.add(usernameField);
        loginPanelLeft.add(passwordField);
        loginPanelLeft.add(signUpText);
        loginPanelLeft.add(loginButton);
        loginPanelLeft.add(errorText);

        // Add to Main Panel
        frame.add(MainSignUpPanel);
        frame.add(MainloginPanel);
        frame.add(MainHomePagePanel);
        frame.setResizable(false);

        frame.setVisible(true);

    }

    void selectedDay() {
        System.out.println("Oo ni gana nani na part");
        if (chosenday == 1) {
            try (BufferedReader reader = new BufferedReader(new FileReader("seatLeft.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {

                    String[] parts = line.split(" ");
                    if (parts.length == 3) {

                        String a = parts[0];
                        String b = parts[1];
                        String c = parts[2];

                        vipNum = Integer.parseInt(a);
                        premierNum = Integer.parseInt(b);
                        genAdNum = Integer.parseInt(c);
                        vipMax = Integer.parseInt(a);
                        premierMax = Integer.parseInt(b);
                        genAdMax = Integer.parseInt(c);
                    }
                }
            } catch (IOException a) {
                a.printStackTrace();
            }
            vipNum = vipMax;
            vipSeatsLeft.setText(vipNum + " LEFT");
            premierNum = premierMax;
            premierSeatsLeft.setText(premierNum + " LEFT");
            genAdNum = genAdMax;
            genAdSeatsLeft.setText(genAdNum + " LEFT");

        } else if (chosenday == 2) {
            try (BufferedReader reader = new BufferedReader(new FileReader("seatLeftDay2.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {

                    String[] parts = line.split(" ");
                    if (parts.length == 3) {

                        String a = parts[0];
                        String b = parts[1];
                        String c = parts[2];

                        vipNum = Integer.parseInt(a);
                        premierNum = Integer.parseInt(b);
                        genAdNum = Integer.parseInt(c);
                        vipMax = Integer.parseInt(a);
                        premierMax = Integer.parseInt(b);
                        genAdMax = Integer.parseInt(c);
                    }
                }
            } catch (IOException a) {
                a.printStackTrace();
            }
            vipNum = vipMax;
            vipSeatsLeft.setText(vipNum + " LEFT");
            premierNum = premierMax;
            premierSeatsLeft.setText(premierNum + " LEFT");
            genAdNum = genAdMax;
            genAdSeatsLeft.setText(genAdNum + " LEFT");
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader("seatLeftDay3.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {

                    String[] parts = line.split(" ");
                    if (parts.length == 3) {

                        String a = parts[0];
                        String b = parts[1];
                        String c = parts[2];

                        vipNum = Integer.parseInt(a);
                        premierNum = Integer.parseInt(b);
                        genAdNum = Integer.parseInt(c);
                        vipMax = Integer.parseInt(a);
                        premierMax = Integer.parseInt(b);
                        genAdMax = Integer.parseInt(c);
                    }
                }
            } catch (IOException a) {
                a.printStackTrace();
            }
            vipNum = vipMax;
            vipSeatsLeft.setText(vipNum + " LEFT");
            premierNum = premierMax;
            premierSeatsLeft.setText(premierNum + " LEFT");
            genAdNum = genAdMax;
            genAdSeatsLeft.setText(genAdNum + " LEFT");
        }

    }

    void showSignUpPanel() {
        MainSignUpPanel.setVisible(true);
        MainloginPanel.setVisible(false);
        MainShowDatePanel.setVisible(false);
    }

    void hideMainShowDatePanelStuff() {
    }

}
