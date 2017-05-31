/**
 * An application to add,search, upload, and delete student records to a directory.
 * @author Poojith Jain (poojithj@andrew.cmu.edu)
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
/**
 * Directory class to keep track of the students in the directory.
 */
public class Directory {
    /**
     * Instance variable to map andrewId and Student objects.
     */
    private Map<String, Student> students = new HashMap<String, Student>();
    /**
     * Instance variable to map firstName and list of Student objects.
     */
    private Map<String, List<Student>> firstNameMap = new HashMap<String, List<Student>>();
    /**
     * Instance variable to map lastName and list of Student objects.
     */
    private Map<String, List<Student>> lastNameMap = new HashMap<String, List<Student>>();
    /**
     * Instance variable to save the list of students who have the same first name.
     */
    private List<Student> firstNameStudentList;
    /**
     * Instance variable to save the list of students who have the same last name.
     */
    private List<Student> lastNameStudentList;
    /**
     * Constructor of Directory with no parameters.
     */
    public Directory() {
    }
    /**
     * Adds new student to all three data structures (map variables).
     * @param s value of Student object to be added
     */
    public void addStudent(Student s) {
        if (s == null || s.equals("")) {
            throw new IllegalArgumentException("Please enter appropriate details to add a new student.");
            }
            if ((!students.containsKey(s.getAndrewId()))) {
                Student newStudent = copyObject(s);
                students.put(s.getAndrewId(), newStudent);
                if (firstNameMap.containsKey(s.getFirstName())) {
                    List<Student> studentList = new LinkedList<Student>();
                    studentList = copyListOfObjects(firstNameMap.get(s.getFirstName()));
                    studentList.add(s);
                    firstNameMap.put(s.getFirstName(), studentList);
                } else {
                    List<Student> firstNameList = new LinkedList<Student>();
                    firstNameList.add(s);
                    firstNameMap.put(s.getFirstName(), firstNameList);
                }
                if (lastNameMap.containsKey(s.getLastName())) {
                    List<Student> studentList = new LinkedList<Student>();
                           studentList = copyListOfObjects(lastNameMap.get(s.getLastName()));
                           studentList.add(s);
                    lastNameMap.put(s.getLastName(), studentList);
                } else {
                    List<Student> lastNameList = new LinkedList<Student>();
                    lastNameList.add(s);
                    lastNameMap.put(s.getLastName(), lastNameList);
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
    /**
     * Deletes student from all three data structures.
     * @param andrewId value of Student to be deleted
     */
    public void deleteStudent(String andrewId) {
        if (andrewId == null || andrewId.equals("")) {
            throw new IllegalArgumentException("Please input a valid student Andrew ID for deletion.");
        }
            Student s = students.get(andrewId);
            if (students.containsKey(andrewId)) {
               students.remove(andrewId);
               List<Student> firstNameList = firstNameMap.get(s.getFirstName());
               for (Student student : firstNameList) {
                   if (student.getAndrewId().equals(andrewId)) {
                       firstNameList.remove(student);
                       break;
                   }
               }
               List<Student> lastNameList = lastNameMap.get(s.getLastName());
               for (Student student : lastNameList) {
                   if (student.getAndrewId().equals(andrewId)) {
                       lastNameList.remove(student);
                       break;
                   }
               }
            } else {
                throw new IllegalArgumentException("Student does not exist in the directory.");
            }
        }
    /**
     * Search student based on Andrew ID.
     * @param andrewId of Student object to be searched
     * @return Student value after search
     */
    public Student searchByAndrewId(String andrewId) {
        if (andrewId == null || andrewId.equals("")) {
            throw new IllegalArgumentException("Please enter a valid Andrew ID to search.");
        }
        if (students.containsKey(andrewId)) {
            Student s = students.get(andrewId);
            Student newStudent = copyObject(s);
            return newStudent;
        } else {
            return null;
        }
    }
    /**
     * Search student based on first name.
     * @param firstName of Student object to be searched
     * @return List of student objects
     */
    public List<Student> searchByFirstName(String firstName) {
        if ((firstName == null) || firstName.equals("") || firstName.isEmpty()) {
            throw new IllegalArgumentException("Please enter a valid first name to search.");
        }
        if (firstNameMap.containsKey(firstName)) {
            firstNameStudentList = copyListOfObjects(firstNameMap.get(firstName));
            return firstNameStudentList;
            } else {
            return new LinkedList<Student>();
            }
        }
    /**
     * Search student based on last name.
     * @param lastName of Student object to be searched
     * @return List of student objects
     */
    public List<Student> searchByLastName(String lastName) {
        if ((lastName == null) || lastName.equals("") || lastName.equals(null)) {
            throw new IllegalArgumentException("Please enter a valid last name to search.");
            }
        if (lastNameMap.containsKey(lastName)) {
            lastNameStudentList = copyListOfObjects(lastNameMap.get(lastName));
                return lastNameStudentList;
        } else {
            return new LinkedList<Student>();
        }
    }
    /**
     * @param s to copy the student
     * @return Student object that is copied
     */
    public Student copyObject(Student s) {
        Student newStudent = new Student(s.getAndrewId());
        newStudent.setFirstName(s.getFirstName());
        newStudent.setLastName(s.getLastName());
        newStudent.setPhoneNumber(s.getPhoneNumber());
        return newStudent;
    }
    /**
     * @param s of student objects to be copied
     * @return List of new student objects
     */
    public List<Student> copyListOfObjects(List<Student> s) {
        List<Student> newList = new LinkedList<Student>();
        for (int i = 0; i < s.size(); i++) {
            newList.add(copyObject(s.get(i)));
        }
        return newList;
    }
    /**
     * Returns number of students in directory.
     * @return size value in int
     */
    public int size() {
        return students.size();
    }
}

