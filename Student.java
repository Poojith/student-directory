/**
 * An application to add, search, upload, and delete student records to a directory.
 * @author Poojith Jain (poojithj@andrew.cmu.edu)
 */
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * Student class to represent students in the directory.
 */
public  class Student {
    /**
     * Instance variable for first name.
     */
    private String firstName;
    /**
     * Instance variable for last name.
     */
    private String lastName;
    /**
     * Instance variable for Andrew ID.
     */
    private String andrewId;
    /**
     * Instance variable for phone number.
     */
    private String phoneNumber;
    /**
     * Instance variable to check status of updates.
     */
    public Student() {
        throw new IllegalArgumentException("Please enter a valid Andrew ID.");
    }
    /**
     * Constructor of Student with Andrew ID parameter.
     * @param andrewId value
     */
    public Student(String andrewId) {
        if (validateAndrewId(andrewId)) {
            this.andrewId = andrewId;
        }
    }
    /**
     * Constructor of Student with Student object parameter for cloning.
     * @param s value for Student object
     */
    public Student(Student s) {
        if (s == null || s.equals("")) {
            throw new IllegalArgumentException("Not a valid student.");
        }
            this.andrewId = s.andrewId;
            this.firstName = s.firstName;
            this.lastName = s.lastName;
            this.phoneNumber = s.phoneNumber;
        }
    /**
     * Returns Andrew ID value of Student object.
     * @return andrewId value in string
     */
    public String getAndrewId() {
        return new String(andrewId);
    }
    /**
     * Returns first name value of Student object.
     * @return firstName value in string
     */
    public String getFirstName() {
        return new String(firstName);
    }
    /**
     * Returns last name value of Student object.
     * @return lastName value in string
     */
    public String getLastName() {
        return new String(lastName);
    }
    /**
     * Returns phone number value of Student object.
     * @return phoneNumber value in string
     */
    public String getPhoneNumber() {
        return new String(phoneNumber);
    }
    /**
     * Checks for input of first name value of Student object.
     */
    public void setFirstName() {
        throw new IllegalArgumentException("Please enter a first name.");
        }
    /**
     * Sets first name value of Student object.
     * @param s in string
     */
    public void setFirstName(String s) {
        if (validateName(s)) {
            firstName = new String(s);
            }
    }
    /**
     * Checks for input of last name value of Student object.
     */
    public void setLastName() {
        throw new IllegalArgumentException("Please enter a last name.");
        }
    /**
     * Sets last name value of Student object.
     * @param s in string
     */
    public void setLastName(String s) {
        if (validateName(s)) {
            lastName = new String(s);
        }
    }
    /**
     * Checks for input of phone number value of Student object.
     */
    public void setPhoneNumber() {
        throw new IllegalArgumentException("Please enter a phone number.");
        }
    /**
     * Sets phone number value of Student object.
     * @param s in string
     */
    public void setPhoneNumber(String s) {
//        if (validatePhone(s)) {
            phoneNumber = new String(s);
//            }
        }
    /**
     * Validates Andrew ID value of Student object.
     * @param s in string
     * @return validated value in boolean
     */
    public boolean validateAndrewId(String s) {
        if (s == null || s.equals(null)) {
            throw new IllegalArgumentException("Please enter valid Andrew ID.");
        }
        if (s.isEmpty()) {
            throw new IllegalArgumentException("Please note that AndrewID cannot be empty.");
        }
        return true;
    }
    /**
     * Validates phone number value of Student object.
     * @param s in string
     * @return validated value in boolean
     */
    public boolean validatePhone(String s) {
        Pattern numberPattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
        Matcher match = numberPattern.matcher(s);
        if (s == null) {
            throw new IllegalArgumentException("Please enter valid phone number.");
        }
        if (s.isEmpty()) {
            throw new IllegalArgumentException("Please note that phone number cannot be empty.");
        }
        if (!match.matches()) {
            throw new IllegalArgumentException("Please enter phone number in the right format.");
        }
        return true;
    }
    /**
     * Validates name values of Student object.
     * @param name in string
     * @return validated value in boolean
     */
    public boolean validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Please enter valid name.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Please note that name cannot be empty.");
        }
        if (!(name instanceof String)) {
            throw new IllegalArgumentException("Please enter name in the right format.");
        }
        return true;
    }
    /**
     * Returns String representation of Student object.
     * @return String representation of Student object
     */
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " " + "(Andrew ID: " + getAndrewId() + ", " + "Phone Number: "
    + getPhoneNumber() + ")";
    }
}


