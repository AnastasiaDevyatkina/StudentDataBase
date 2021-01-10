import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = null;
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000;

    //Constructor: prompt user to enter student`s name and year
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter student first name: ");
        this.firstName = in.nextLine();

        System.out.println("Enter student last name: ");
        this.lastName = in.nextLine();

        System.out.println("1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior Enter student class level: ");
        this.gradeYear = in.nextInt();

        setStudentID();
//        System.out.println(firstName + " " + lastName + " " + gradeYear + " " + studentID);
        //id++; // every time when student add to the database id will add 1;
    }

    //Generate an ID
    private void setStudentID() {
        //Level Grade + ID
        id++;
        this.studentID = gradeYear + "" + id;
    }
    //Enroll in courses
    public void enroll() {
        //get inside a loop, user hits 0
        do {
            System.out.print("enter course to enroll(0 to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("Q")) {
                courses = courses + "\n" + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            } else {
                break;
            }
        } while (1 != 0);
//        System.out.println("ENROLLED IN: " + courses);
        System.out.println("TUITION BALANCE: " + tuitionBalance);
    }
    //View balance
    public void viewBalance() {
        System.out.println("Your balance is: $" + tuitionBalance);
    }

    //Pay tuition
    public void payTuition() {
        viewBalance();
        System.out.print("Enter a payment: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();

    }
    //Show status
    public String toString(){
        return "Name: " + firstName + " " + lastName +
                "\nGrade level: " + gradeYear +
                "\nCourses Enrolled: " + courses +
                "\nStudent ID: " + studentID +
                "\nBalance: $" + tuitionBalance;
    }
}