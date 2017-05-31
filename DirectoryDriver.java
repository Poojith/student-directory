/**
 * An application to add,search, upload, and delete student records to a directory.
 * @author Poojith Jain (poojithj@andrew.cmu.edu)
 */
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/**
 * Class DirectoryDriver that drives the back-end of the directory with the Swing objects.
 */
public class DirectoryDriver {
    /**
     * Instance variable for the search text field.
     */
    private JTextField searchField;
    /**
     * Instance variable for the search text field.
     */
    private JButton searchLnameButton;
    /**
     * Instance variable for the button of searching by first name.
     */
    private JButton searchFnameButton;
    /**
     * Instance variable for the button of searching by Andrew ID.
     */
    private JButton searchAndrewButton;
    /**
     * Instance variable for the area to display result(s).
     */
    private JTextArea resultArea;
    /**
     * Instance variable for the add title border.
     */
    private TitledBorder addTitle;
    /**
     * Instance variable for the delete title border.
     */
    private TitledBorder delTitle;
    /**
     * Instance variable for the search title border.
     */
    private TitledBorder searchTitle;
    /**
     * Instance variable for the result title border.
     */
    private TitledBorder resultTitle;
    /**
     * Instance variable for the scroll bar.
     */
    private JScrollPane scrollBar;
    /**
     * Instance variable for the add label.
     */
    private JLabel addLabel;
    /**
     * Instance variable for the label of first name.
     */
    private JLabel lblFirstName;
    /**
     * Instance variable for the add button.
     */
    private JButton addButton;
    /**
     * Instance variable for the phone number field.
     */
    private JTextField phoneNumField;
    /**
     * Instance variable for the AndrewID field.
     */
    private JTextField andrewIdField;
    /**
     * Instance variable for the last name field.
     */
    private JTextField lastNameField;
    /**
     * Instance variable for the first name field.
     */
    private JTextField firstNameField;
    /**
     * Instance variable for the label of phone number.
     */
    private JLabel lblPhoneNum;
    /**
     * Instance variable for the label of Andrew ID.
     */
    private JLabel lblAndrewId;
    /**
     * Instance variable for the label of last name.
     */
    private JLabel lblLastName;
    /**
     * Instance variable for the font of headers.
     */
    private Font headerFont;
    /**
     * Instance variable for the delete button.
     */
    private JButton deleteButton;
    /**
     * Instance variable for the button of deleting by Andrew ID.
     */
    private JTextField delAndrewField;
    /**
     * Instance variable for the label of deleting by Andrew ID.
     */
    private JLabel delAndrewId;
    /**
     * Instance variable for the label of searching.
     */
    private JLabel lblSearchKey;
    /**
     * Directory object for the student directory.
     */
    private static Directory directory = new Directory();

    /**
     * Constructor of the DirectoryDriver class with no parameters.
     */
    public DirectoryDriver() {
        JFrame window = new JFrame("Student directory");
        window.setSize(500, 500);
        JPanel pane = new JPanel(new FlowLayout());
        JPanel namePanel = new JPanel();
        JPanel delPanel = new JPanel();
        JPanel searchPanel = new JPanel();
        JPanel resultPanel = new JPanel();
        headerFont = new Font(Font.SANS_SERIF, Font.BOLD, 13);
        Font resultFont = new Font(Font.MONOSPACED, Font.PLAIN, 13);
        Font alertFont = new Font(Font.SERIF, Font.BOLD, 15);
        Color backGroundColor = Color.white;
        Color buttonColor = Color.decode("#a7d1e2");
        addTitle = BorderFactory.createTitledBorder("Add a new student");
        addTitle.setTitleFont(headerFont);
        delTitle = BorderFactory.createTitledBorder("Delete a student");
        delTitle.setTitleFont(headerFont);
        searchTitle = BorderFactory.createTitledBorder("Search student(s)");
        searchTitle.setTitleFont(headerFont);
        resultTitle = BorderFactory.createTitledBorder("Results");
        resultTitle.setTitleFont(headerFont);
        resultArea = new JTextArea(30, 50);
        resultArea.setBackground(Color.decode("#edf2f4"));
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        scrollBar = new JScrollPane(resultArea);
        scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        addLabel = new JLabel("Add a new student \n", JLabel.LEFT);
        addLabel.setFont(headerFont);
        lblFirstName = new JLabel("First Name:");
        lblLastName = new JLabel("Last Name:");
        lblAndrewId = new JLabel("Andrew ID:");
        lblSearchKey = new JLabel("Search Key:");
        lblPhoneNum = new JLabel("Phone number:");
        addTextFields(alertFont, buttonColor);
        handleDelete(resultFont, alertFont, buttonColor);
        handleSearch(resultFont, alertFont, buttonColor);
        namePanel.add(lblFirstName);
        namePanel.add(firstNameField);
        namePanel.add(lblLastName);
        namePanel.add(lastNameField);
        namePanel.add(lblAndrewId);
        namePanel.add(andrewIdField);
        namePanel.add(lblPhoneNum);
        namePanel.add(phoneNumField);
        namePanel.add(addButton);
        namePanel.setBorder(addTitle);
        namePanel.setOpaque(true);
        namePanel.setBackground(backGroundColor);
        delPanel.add(delAndrewId);
        delPanel.add(delAndrewField);
        delPanel.add(deleteButton);
        delPanel.setBackground(backGroundColor);
        delPanel.setBorder(delTitle);
        searchPanel.add(lblSearchKey);
        searchPanel.add(searchField);
        searchPanel.setBackground(backGroundColor);
        searchPanel.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorRemoved(AncestorEvent event) {
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
            }

            @Override
            public void ancestorAdded(AncestorEvent event) {
                searchField.requestFocusInWindow();
            }
        });
        searchPanel.add(searchAndrewButton);
        searchPanel.add(searchFnameButton);
        searchPanel.add(searchLnameButton);
        searchPanel.setBorder(searchTitle);
        resultPanel.setBorder(resultTitle);
        resultPanel.add(scrollBar);
        resultPanel.setBackground(backGroundColor);
        pane.add(namePanel);
        pane.add(delPanel);
        pane.add(searchPanel);
        pane.add(resultPanel);
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        pane.setOpaque(true);
        pane.setBackground(Color.WHITE);
        window.setContentPane(pane);
        window.pack();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * @param resultFont to set color for results
     * @param alertFont to set color for alert messages
     * @param buttonColor to set color for buttons
     */
    private void handleSearch(Font resultFont, Font alertFont, Color buttonColor) {
        searchField = new JTextField(15);
        searchField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchAndrewButton.doClick();
            }
        });
        searchAndrewButton = new JButton("By Andrew ID");
        searchAndrewButton.setBackground(buttonColor);
        searchAndrewButton.setFocusPainted(false);
        searchFnameButton = new JButton("By First Name");
        searchFnameButton.setBackground(buttonColor);
        searchFnameButton.setFocusPainted(false);
        searchLnameButton = new JButton("By Last Name");
        searchLnameButton.setBackground(buttonColor);
        searchLnameButton.setFocusPainted(false);
        searchAndrewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (searchField.getText().trim().isEmpty()) {
                    searchField.requestFocus();
                    JOptionPane.showMessageDialog(null, "Andrew ID needs to be entered.");
                    resultArea.setText("Please enter the Andrew ID of the student that you wish to search.");
                    resultArea.setFont(alertFont);
                    return;
                }

                String searchAndrewId = searchField.getText();
                Student s = directory.searchByAndrewId(searchAndrewId);
                if (s == null) {
                    resultArea.setText("There are no matches in the directory for the Andrew ID of " + "\""
                            + searchField.getText() + "\".");
                    resultArea.setFont(alertFont);
                } else {
                    searchField.setText("");
                    resultArea.setText(s.toString());
                    resultArea.setFont(resultFont);
                }
            }
        });
        searchFnameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (searchField.getText().trim().isEmpty()) {
                    searchField.requestFocus();
                    JOptionPane.showMessageDialog(null, "First name needs to be entered.");
                    resultArea.setText("Please enter the first name of the student(s) that you wish to search.");
                    resultArea.setFont(alertFont);
                    return;
                }
                String searchFirstName = searchField.getText();
                List<Student> studentList = directory.searchByFirstName(searchFirstName);
                if (studentList.isEmpty()) {
                    resultArea.setText("There are no matches in the directory for the first name of " + "\""
                            + searchField.getText() + "\".");
                    resultArea.setFont(alertFont);
                } else {
                    StringBuilder sb = new StringBuilder();

                    for (Student s : studentList) {
                        sb.append(s.toString() + "\n");
                    }
                    resultArea.setText(sb.toString());
                    resultArea.setFont(resultFont);
                    searchField.setText("");
                }
            }
        });
        searchLnameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (searchField.getText().trim().isEmpty()) {
                    searchField.requestFocus();
                    JOptionPane.showMessageDialog(null, "Last name needs to be entered.");
                    resultArea.setText("Please enter the last name of the student(s) that you wish to search.");
                    resultArea.setFont(alertFont);
                    return;
                }
                String searchLastName = searchField.getText();
                List<Student> studentList = directory.searchByLastName(searchLastName);
                if (studentList.isEmpty()) {
                    resultArea.setText("There are no matches in the directory for the last name of " + "\""
                            + searchField.getText() + "\".");
                    resultArea.setFont(alertFont);
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (Student s : studentList) {
                        sb.append(s.toString() + "\n");
                    }
                    resultArea.setText(sb.toString());
                    resultArea.setFont(resultFont);
                    searchField.setText("");
                }
            }
        });
    }

    /**
     * @param resultFont to set color for results
     * @param alertFont to set color for alert messages
     * @param buttonColor to set color for buttons
     */
    private void handleDelete(Font resultFont, Font alertFont, Color buttonColor) {
        delAndrewId = new JLabel("Andrew ID:");
        deleteButton = new JButton("Delete");
        deleteButton.setBackground(buttonColor);
        deleteButton.setFocusPainted(false);
        delAndrewField = new JTextField(9);
        delAndrewField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteButton.doClick();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            private String deleleteAndrewIdField;

            public void actionPerformed(ActionEvent e) {
                if (delAndrewField.getText().trim().isEmpty()) {
                    delAndrewField.requestFocus();
                    JOptionPane.showMessageDialog(null, "Andrew ID needs to be entered.");
                    resultArea.setText("Please enter the Andrew ID of the student that you wish to delete.");
                    resultArea.setFont(alertFont);
                    return;
                }
                deleleteAndrewIdField = delAndrewField.getText();
                Student s = directory.searchByAndrewId(deleleteAndrewIdField);
                if (s == null) {
                    resultArea.setText("There are no students in the directory with the Andrew ID of " + "\""
                            + delAndrewField.getText() + "\".");
                    resultArea.setFont(alertFont);
                    return;
                }
                directory.deleteStudent(deleleteAndrewIdField.toString());
                delAndrewField.setText("");
                resultArea.setText(
                        "The following record of " + s.getFirstName().toString() + " " + s.getLastName().toString()
                                + " has been successfully " + "deleted from the directory: \n" + s.toString());
                resultArea.setFont(resultFont);
            }
        });
    }

    /**
     * @param alertFont to set color for alert messages
     * @param buttonColor to set color of buttons
     */
    private void addTextFields(Font alertFont, Color buttonColor) {
        firstNameField = new JTextField(15);
        firstNameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addButton.doClick();
            }
        });
        lastNameField = new JTextField(15);
        lastNameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addButton.doClick();
            }
        });
        andrewIdField = new JTextField(9);
        andrewIdField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addButton.doClick();
            }
        });
        phoneNumField = new JTextField(12);
        phoneNumField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addButton.doClick();
            }
        });
        List<JTextField> textFields = new ArrayList<JTextField>();
        textFields.add(firstNameField);
        textFields.add(lastNameField);
        textFields.add(andrewIdField);
        textFields.add(phoneNumField);
        addButton = new JButton("Add");
        addButton.setBackground(buttonColor);
        addButton.setFocusPainted(false);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                if (firstNameField.getText().trim().isEmpty()) {
                    firstNameField.requestFocus();
                    JOptionPane.showMessageDialog(null, "First name cannot be empty.");
                    resultArea.setText("Please enter a first name.");
                    resultArea.setFont(alertFont);
                    return;
                }
                String lastName = lastNameField.getText();
                if (lastNameField.getText().trim().isEmpty()) {
                    lastNameField.requestFocus();
                    JOptionPane.showMessageDialog(null, "Last name cannot be empty.");
                    resultArea.setText("Please enter a last name.");
                    resultArea.setFont(alertFont);
                    return;
                }
                String phoneNumber = phoneNumField.getText();
                String andrewId = andrewIdField.getText();
                if (andrewIdField.getText().trim().isEmpty()) {
                    andrewIdField.requestFocus();
                    JOptionPane.showMessageDialog(null, "Andrew ID cannot be empty.");
                    resultArea.setText("Please enter the Andrew ID.");
                    resultArea.setFont(alertFont);
                    return;
                }
                Student s = directory.searchByAndrewId(andrewId);
                if (s != null) {
                    resultArea.setText("Please note that the Andrew ID of " + "\"" + andrewIdField.getText() + "\""
                            + " has already been added to the directory.");
                    resultArea.setFont(alertFont);
                    return;
                }
                Student newStudent = new Student(andrewId);
                newStudent.setFirstName(firstName);
                newStudent.setLastName(lastName);
                newStudent.setPhoneNumber(phoneNumber);
                Student addStudent = new Student(newStudent);
                directory.addStudent(addStudent);
                for (JTextField field : textFields) {
                    field.setText("");
                }
                firstNameField.requestFocus();
                resultArea.setText(firstName.toString() + " " + lastName.toString() + " has been successfully "
                        + "added to the directory.");
                resultArea.setFont(alertFont);
            }
        });
    }

    /**
     * @param args from the console
     * @throws IOException to handle I/O errors
     */
    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            new DirectoryDriver();
            FileReader fr = new FileReader(args[0]);
            CSVReader r = new CSVReader(fr);

            boolean eof = false;

            while (!eof) {
                String[] values = r.readCSVInput();
                if (values == null) {
                    eof = true;
                } else {
                    String firstName = values[0];
                    String lastName = values[1];
                    String andrewId = values[2];
                    String phoneNumber = values[3];
                    Student n = new Student(andrewId);
                    n.setFirstName(firstName);
                    n.setLastName(lastName);
                    n.setPhoneNumber(phoneNumber);
                    directory.addStudent(n);
                }
            }
            r.close();
        } else {
            new DirectoryDriver();
        }
    }
}

/**
 * @author Poojith
 *
 */
class CSVReader extends BufferedReader {
    /**
     * @param r to read the input stream
     */
    CSVReader(Reader r) {
        super(r);
    }

    /**
     * Static variable to keep track of count.
     */
    private static int count = 0;

    /**
     * @return String array of parsed input strings
     * @throws IOException to handle I/O errors
     */
    public String[] readCSVInput() throws IOException {
        if (count == 0) {
            super.readLine();
        }
        count = 1;
        String line = super.readLine();
        if (line == null) {
            return null;
        }

        String[] values = line.split(",");
        for (int i = 0; i < values.length; i++) {
            values[i] = values[i].substring(1, values[i].length() - 1);
        }
        return values;
    }
}
