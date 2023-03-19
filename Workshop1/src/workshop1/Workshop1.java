/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nguyen Tien Dat
 */
public class Workshop1 {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Student> studentList = new ArrayList<>();
    static ArrayList<Class> classList = new ArrayList<>();
    static ArrayList<Subject> subjectList = new ArrayList<>();
    static ArrayList<Score> scoreList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean f = true;
        while (f == true) {
            System.out.println("Choose an object:");
            System.out.println("1. Students");
            System.out.println("2. Class");
            System.out.println("3. Subject");
            System.out.println("4. Score");
            System.out.println("5. Exit");

            int objectChoice = scanner.nextInt();
            scanner.nextLine();

            switch (objectChoice) {
                case 1:
                    studentOperations();
                    break;
                case 2:
                    classOperations();
                    break;
                case 3:
                    subjectOperations();
                    break;
                case 4:
                    scoreOperations();
                    break;
                case 5:
                    f = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------
    private static void studentOperations() {
        //ex obj for test
        studentList.add(new Student("CE171314", "Nguyen Tien Dat", "233/28", "SE1710"));
        studentList.add(new Student("CE171318", "Nguyen Van A", "896/28", "SE1710"));
        studentList.add(new Student("CE171320", "Lam Thi B", "44/28", "SE1710"));
        //--------------------
        int studentChoice = -1;
        do {
            System.out.println("Choose an operation:");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Sort Students by Name");
            System.out.println("5. Find Students by Class");
            System.out.println("6. Show Student List");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");
            studentChoice = scanner.nextInt();
            scanner.nextLine();

            switch (studentChoice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    sortStudentsByName(studentList);
                    break;
                case 5:
                    findStudentsByID();
                    break;
                case 6:
                    showList(studentList);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        } while (studentChoice != 7);
    }

    private static void addStudent() {
    System.out.println("Enter student information:");

    // get input from user
    System.out.print("Student ID(VD: CE171314): ");
    String id = scanner.nextLine();

    // Check if the student ID already exists
    for (Student student : studentList) {
        if (student.getStudentID().equals(id)) {
            System.out.println("Student ID already exists!");
            return; // Exit the method
        }
    }

    System.out.print("Full Name: ");
    String name = scanner.nextLine();

    System.out.print("Address: ");
    String address = scanner.nextLine();

    System.out.print("Class ID: ");
    String classId = scanner.nextLine();

    // Check if the class ID exists
    boolean classExists = false;
    for (Class c : classList) {
        if (c.getClassID().equals(classId)) {
            classExists = true;
            break;
        }
    }

    if (!classExists) {
        System.out.print("The input class does not exist, Do you want to create a new class(y/n)? ");
        String createNewClass = scanner.nextLine();
        if (createNewClass.equalsIgnoreCase("y")) {
            addClass();
        } else {
            return;
        }
    }

    // create new Student object
    Student student = new Student(id, name, address, classId);

    // add student to list
    studentList.add(student);

    System.out.println("Student added successfully.");
}

    private static void updateStudent() {
        System.out.print("Enter the student ID you want to update(VD: CE171314): ");
        String id = scanner.nextLine();
        System.out.print("Full Name: ");
        String newName = scanner.nextLine();
        System.out.print("Address: ");
        String newAddress = scanner.nextLine();
        System.out.print("Class ID: ");
        String newClassId = scanner.nextLine();
        for (Student student : studentList) {
            if (student.getStudentID().equals(id)) {
                student.setFullName(newName);
                student.setAddress(newAddress);
                student.setClassName(newClassId);
                System.out.println("Student with ID " + id + " updated successfully.");
                return;
            }
        }
        System.out.println("No student found with ID " + id + ".");
    }

    private static void removeStudent() {
        System.out.println("\nRemove Student:");
        System.out.print("Enter Student ID to remove: ");
        String id = scanner.nextLine();

        Student removeStudent = null;
        for (Student s : studentList) {
            if (s.getStudentID().equals(id)) {
                removeStudent = s;
                break;
            }
        }

        if (removeStudent == null) {
            System.out.println("Student not found!");
        } else {
            studentList.remove(removeStudent);
            System.out.println("Student removed successfully!");
        }
    }

    private static void sortStudentsByName(List<Student> studentList) {
        Collections.sort(studentList, (Student s1, Student s2) -> s1.getFullName().compareTo(s2.getFullName()));
    }

    private static void findStudentsByID() {
        boolean found = false;
        System.out.print("Enter the student ID you want to remove(VD: CE171314): ");
        String id = scanner.nextLine();
        for (Student c : studentList) {
            if (c.getStudentID().equals(id)) {
                System.out.println("Found Student:");
                System.out.println(c.toString());
            }
        }
        if (found) {
            System.out.println("Student not found.");
        }
    }

//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    private static void classOperations() {
        int choice;
        do {
            System.out.println("\nClass Operations:");
            System.out.println("1. Add Class");
            System.out.println("2. Update Class");
            System.out.println("3. Remove Class");
            System.out.println("4. Sort Classes");
            System.out.println("5. Find Class");

            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addClass();
                    break;
                case 2:
                    updateClass();
                    break;
                case 3:
                    removeClass();
                    break;
                case 4:
                    sortClasses(classList);
                    break;
                case 5:
                    findClassByID();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);
    }

    private static void addClass() {
        System.out.println("\nAdd Class:");
        System.out.print("Enter Class ID: ");
        String id = scanner.nextLine();
        for (Class _class : classList) {
            if (_class.getClassID().equals(id)) {
                System.out.println("Class ID already exists!");
                return;
            }
        }
        scanner.nextLine();
        System.out.print("Enter Class Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Class Course: ");
        String course = scanner.nextLine();

        Class newClass = new Class(id, name, course);
        classList.add(newClass);

        System.out.println("Class added successfully!");
    }

    private static void updateClass() {
        System.out.println("\nUpdate Class:");
        System.out.print("Enter Class ID to update: ");
        String id = scanner.nextLine();
        scanner.nextLine();

        Class updatedClass = null;
        for (Class c : classList) {
            if (c.getClassID().equals(id)) {
                System.out.print("Enter new Class Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new Class Course: ");
                String course = scanner.nextLine();

                updatedClass = new Class(id, name, course);
                classList.set(classList.indexOf(c), updatedClass);

                break;
            }
        }

        if (updatedClass == null) {
            System.out.println("Class not found!");
        } else {
            System.out.println("Class updated successfully!");
        }
    }

    private static void removeClass() {
        System.out.println("\nRemove Class:");
        System.out.print("Enter Class ID to remove: ");
        String id = scanner.nextLine();
        scanner.nextLine();

        Class removeClass = null;
        for (Class c : classList) {
            if (c.getClassID().equals(id)) {
                removeClass = c;
                break;
            }
        }

        if (removeClass == null) {
            System.out.println("Class not found!");
        } else {
            classList.remove(removeClass);
            System.out.println("Class removed successfully!");
        }
    }

    private static void sortClasses(List<Class> classList) {
        Collections.sort(classList, (Class c1, Class c2) -> c1.getClassName().compareTo(c2.getClassName()));
    }

    public static void findClassByID() {
        String id = scanner.nextLine();
        boolean found = false;
        for (Class c : classList) {
            if (c.getClassID().equals(id)) {
                System.out.println("Found class:");
                System.out.println(c.toString());
                found = true;
            }
        }
        if (found) {
            System.out.println("Class not found!");
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------
    private static void subjectOperations() {
        int choice = -1;
        do {
            System.out.println("Subject Operations Menu:");
            System.out.println("1. Add new subject");
            System.out.println("2. Update existing subject");
            System.out.println("3. Remove existing subject");
            System.out.println("4. Sort subjects by name");
            System.out.println("5. Find subjects by major");
            System.out.println("6. Show Student List");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addSubject();
                    break;
                case 2:
                    updateSubject();
                    break;
                case 3:
                    removeSubject();
                    break;
                case 4:
                    sortSubjectsByName(subjectList);
                    break;
                case 5:
                    findSubjectsByID();
                    break;
                case 6:
                    showList(subjectList);
                case 7:
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid choice.");
                    break;
            }

        } while (choice != 7);
    }

    private static void addSubject() {
        System.out.print("Enter subject ID: ");
        String subjectId = scanner.nextLine();
        scanner.nextLine(); // Consume the newline character left by nextInt()

        // Check if the subject ID already exists
        for (Subject subject : subjectList) {
            if (subject.getSubjectID().equals(subjectId)) {
                System.out.println("Subject ID already exists!");
                return; // Exit the method
            }
        }

        System.out.print("Enter subject name: ");
        String subjectName = scanner.nextLine();
        System.out.print("Enter subject major: ");
        String major = scanner.nextLine();

        // Create a new Subject object and add it to the subjectList
        Subject subject = new Subject(subjectId, subjectName, major);
        subjectList.add(subject);
        System.out.println("Subject added successfully!");
    }

    private static void updateSubject() {
        System.out.print("Enter the subject ID you want to update: ");
        String id = scanner.nextLine();
        scanner.nextLine(); // consume the remaining newline character

        for (Subject subject : subjectList) {
            if (subject.getSubjectID().equals(id)) {
                System.out.print("New Subject Name: ");
                String newName = scanner.nextLine();
                System.out.print("New Major: ");
                String newMajor = scanner.nextLine();

                subject.setSubjectName(newName);
                subject.setMajor(newMajor);

                System.out.println("Subject with ID " + id + " updated successfully.");
                return;
            }
        }
        System.out.println("No subject found with ID " + id + ".");
    }

    private static void removeSubject() {
        System.out.println("\nRemove Subject:");
        System.out.print("Enter Subject ID to remove: ");
        String id = scanner.nextLine();
        scanner.nextLine();

        Subject removeSubject = null;
        for (Subject s : subjectList) {
            if (s.getSubjectID().equals(id)) {
                removeSubject = s;
                break;
            }
        }

        if (removeSubject == null) {
            System.out.println("Subject not found!");
        } else {
            subjectList.remove(removeSubject);
            System.out.println("Subject removed successfully!");
        }
    }

    private static void sortSubjectsByName(List<Subject> subjectList) {
        Collections.sort(subjectList, (Subject s1, Subject s2) -> s1.getSubjectName().compareTo(s2.getSubjectName()));
    }

    public static void findSubjectsByID() {
        System.out.print("Enter the subject ID to find: ");
        String id = scanner.nextLine();
        boolean found = false;
        for (Subject subject : subjectList) {
            if (subject.getSubjectID().equals(id)) {
                System.out.println("Found subject:");
                System.out.println(subject.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Subject not found!");
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------
    private static void scoreOperations() {
        int choice = 0;
        while (choice != 5) {
            System.out.println("\nScore operations:");
            System.out.println("1. Add score");
            System.out.println("2. Update score");
            System.out.println("3. Remove score");
            System.out.println("4. Show scores");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addScore();
                    break;
                case 2:
                    updateScore();
                    break;
                case 3:
                    removeScore();
                    break;
                case 4:
                    showList(scoreList);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }
    }

    private static void addScore() {
        System.out.println("\nAdd Score:");
        // get student
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = findStudentByID(studentId);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        // get subject
        System.out.print("Enter subject ID: ");
        String subjectId = scanner.nextLine();
        Subject subject = findSubjectByID(subjectId);
        if (subject == null) {
            System.out.println("Subject not found!");
            return;
        }

        // get score
        System.out.print("Enter score: ");
        double score = scanner.nextDouble();
        scanner.nextLine();

        // create new score object and add to list
        Score newScore = new Score(student, subject, score);
        scoreList.add(newScore);
        System.out.println("Score added successfully!");
    }

// helper method to find student by ID
    private static Student findStudentByID(String id) {
        for (Student student : studentList) {
            if (student.getStudentID().equals(id)) {
                return student;
            }
        }
        return null;
    }

// helper method to find subject by ID
    private static Subject findSubjectByID(String id) {
        for (Subject subject : subjectList) {
            if (subject.getSubjectID().equals(id)) {
                return subject;
            }
        }
        return null;
    }

    private static void updateScore() {
        System.out.print("Enter the student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter the subject ID: ");
        String subjectId = scanner.nextLine();

        Score updateScore = null;
        for (Score score : scoreList) {
            if (score.getStudent().getStudentID().equals(studentId)
                    && score.getSubject().getSubjectID().equals(subjectId)) {
                updateScore = score;
                break;
            }
        }

        if (updateScore == null) {
            System.out.println("Score not found!");
        } else {
            System.out.print("Enter the new score: ");
            double newScore = scanner.nextDouble();
            scanner.nextLine();

            updateScore.setGrade(newScore);
            System.out.println("Score updated successfully!");
        }
    }

    private static void removeScore() {
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Enter subject ID: ");
        String subjectID = scanner.nextLine();
        boolean found = false;
        for (Score score : scoreList) {
            if (score.getStudent().getStudentID().equals(studentID) && score.getSubject().getSubjectID().equals(subjectID)) {
                scoreList.remove(score);
                found = true;
                System.out.println("Score removed successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Score not found.");
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------
    private static void showList(List<?> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("List: ");
        for (Object obj : list) {
            System.out.println(obj.toString());
        }
    }
}
