package codsoft;
import java.util.ArrayList;
import java.util.Scanner;
    class Course {
        String code;
        String title;
        String description;
        int capacity;
        String schedule;

        public Course(String code, String title, String description, int capacity, String schedule) {
            this.code = code;
            this.title = title;
            this.description = description;
            this.capacity = capacity;
            this.schedule = schedule;
        }

        public String toString() {
            return "Course Code: " + code + "\nTitle: " + title + "\nDescription: " + description +
                    "\nCapacity: " + capacity + "\nSchedule: " + schedule + "\n";
        }
    }

    class Student {
        int id;
        String name;
        ArrayList<String> registeredCourses = new ArrayList<>();

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return "Student ID: " + id + "\nName: " + name + "\nRegistered Courses: " + registeredCourses + "\n";
        }
    }

    class CourseRegistrationSystem {
        static ArrayList<Course> courses = new ArrayList<>();
        static ArrayList<Student> students = new ArrayList<>();

        public static void main(String[] args) {
            initializeCourses();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("1. View Available Courses");
                System.out.println("2. Register for a Course");
                System.out.println("3. Drop a Course");
                System.out.println("4. View Student Information");
                System.out.println("5. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        displayCourses();
                        break;
                    case 2:
                        registerForCourse();
                        break;
                    case 3:
                        dropCourse();
                        break;
                    case 4:
                        viewStudentInfo();
                        break;
                    case 5:
                        System.out.println("Exiting Program. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        private static void initializeCourses() {
            courses.add(new Course("CSCI101", "Introduction to Computer Science", "Fundamental concepts of programming", 30, "Mon/Wed 10:00 AM - 11:30 AM"));
            courses.add(new Course("MATH201", "Calculus I", "Limits, derivatives, and integrals", 25, "Tue/Thu 1:00 PM - 2:30 PM"));
            courses.add(new Course("ENG102", "Composition and Rhetoric", "Writing skills and critical analysis", 20, "Mon/Wed/Fri 2:00 PM - 3:30 PM"));
        }

        private static void displayCourses() {
            System.out.println("Available Courses:");
            for (Course course : courses) {
                System.out.println(course);
            }
        }

        private static void registerForCourse() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your student ID: ");
            int studentID = scanner.nextInt();

            // Check if the student exists
            Student student = findStudent(studentID);
            if (student == null) {
                System.out.println("Student not found. Please enter valid student ID.");
                return;
            }

            // Display available courses
            displayCourses();

            System.out.print("Enter the course code you want to register for: ");
            String courseCode = scanner.next();

            // Check if the course exists
            Course course = findCourse(courseCode);
            if (course == null) {
                System.out.println("Course not found. Please enter valid course code.");
                return;
            }

            // Check if there is available capacity in the course
            if (course.capacity <= 0) {
                System.out.println("Sorry, the course is full. Unable to register.");
                return;
            }

            // Register the student for the course
            student.registeredCourses.add(courseCode);
            course.capacity--;
            System.out.println("Registration successful!");
        }

        private static void dropCourse() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your student ID: ");
            int studentID = scanner.nextInt();

            // Check if the student exists
            Student student = findStudent(studentID);
            if (student == null) {
                System.out.println("Student not found. Please enter valid student ID.");
                return;
            }

            // Display the courses the student is registered for
            System.out.println("Courses registered by " + student.name + ": " + student.registeredCourses);

            System.out.print("Enter the course code you want to drop: ");
            String courseCode = scanner.next();

            // Check if the course exists
            Course course = findCourse(courseCode);
            if (course == null) {
                System.out.println("Course not found. Please enter valid course code.");
                return;
            }

            // Drop the course for the student
            if (student.registeredCourses.contains(courseCode)) {
                student.registeredCourses.remove(courseCode);
                course.capacity++;
                System.out.println("Course dropped successfully.");
            } else {
                System.out.println("You are not registered for this course.");
            }
        }

        private static void viewStudentInfo() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your student ID: ");
            int studentID = scanner.nextInt();

            // Check if the student exists
            Student student = findStudent(studentID);
            if (student == null) {
                System.out.println("Student not found. Please enter valid student ID.");
            } else {
                System.out.println(student);
            }
        }

        private static Student findStudent(int studentID) {
            for (Student student : students) {
                if (student.id == studentID) {
                    return student;
                }
            }
            return null;
        }

        private static Course findCourse(String courseCode) {
            for (Course course : courses) {
                if (course.code.equals(courseCode)) {
                    return course;
                }
            }
            return null;
        }
    }

