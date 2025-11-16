import java.util.*;
public class CampusAndCourses {
    private final Map<String, Map<String, Set<String>>> SCHOOL_LOCATIONS_AND_COURSES = new LinkedHashMap<>();
    private String currentRegion;
    private String currentCampus;

    Scanner input = new Scanner(System.in);
    private String studentRegion;
    private String studentCampus;
    private String studentCourse;
    private String studentType;

    public void setSchoolLocationsAndCourses() {
        addRegion("Metro Manila");
            addCampus("Alabang");
                addCourse("Senior High School");
                addCourse("Bachelor of Science in Computer Science (BSCS)");
                addCourse("Bachelor of Science in Information Technology (BSIT)");
                addCourse("Bachelor of Science in Business Administration (BSBA)");
                addCourse("Bachelor of Science in Hospitality Management (BSHM)");
                addCourse("Bachelor of Science in Tourism Management (BSTM)");

            addCampus("Caloocan");
                addCourse("Senior High School");
                addCourse("Bachelor of Science in Computer Science (BSCS)");
                addCourse("Bachelor of Science in Information Technology (BSIT)");
                addCourse("Bachelor of Science in Computer Engineering (BSCpE)");
                addCourse("Bachelor of Science in Business Administration (BSBA)");
                addCourse("Bachelor of Science in Accounting Information System (BSAIS)");
                addCourse("Bachelor of Science in Accountancy (BSA)");
                addCourse("Bachelor of Science in Hospitality Management (BSHM)");
                addCourse("Bachelor of Arts in Communication (BACOMM)");
                addCourse("Bachelor of Multimedia Arts (BMMA)");
                addCourse("Bachelor of Science in Tourism Management (BSTM)");

            addCampus("Cubao");
                addCourse("Senior High School");
                addCourse("Bachelor of Science in Computer Science (BSCS)");
                addCourse("Bachelor of Science in Information Technology (BSIT)");
                addCourse("Bachelor of Science in Computer Engineering (BSCpE)");
                addCourse("Bachelor of Science in Accounting Information System (BSAIS)");
                addCourse("Bachelor of Science in Accountancy (BSA)");
                addCourse("Bachelor of Science in Hospitality Management (BSHM)");
                addCourse("Bachelor of Arts in Communication (BACOMM)");
                addCourse("Bachelor of Multimedia Arts (BMMA)");
                addCourse("Bachelor of Science in Tourism Management (BSTM)");
                addCourse("Bachelor of Science in Criminology (BSCrim)");
                addCourse("2-yr. Associate in Computer Technology (ACT)");

        addRegion("Northern Luzon");
            addCampus("Alaminos");
                addCourse("3-yr. Hotel and Restaurant Administration (HRA)");
                addCourse("2-yr. Information Technology (IT)");
                addCourse("2-yr. Hospitality and Restaurant Services (HRS)");

        addRegion("Southern Luzon");
            addCampus("Bacoor");
                addCourse("Senior High School");
                addCourse("Bachelor of Science in Computer Science (BSCS)");
                addCourse("Bachelor of Science in Information Technology (BSIT)");
                addCourse("Bachelor of Science in Business Administration (BSBA)");
                addCourse("Bachelor of Arts in Psychology");
                addCourse("Bachelor of Science in Tourism Management (BSTM)");
                addCourse("2-yr. Associate in Computer Technology (ACT)");

        addRegion("Visayas");
            addCampus("Calbayog");
                addCourse("Senior High School");
                addCourse("Food and Beverage Services NC II");
                addCourse("Cookery NC II");

        addRegion("Mindanao");
            addCampus("Cagayan De Oro");
                addCourse("Senior High School");
                addCourse("Bachelor of Science in Information Technology (BSIT)");
                addCourse("Bachelor of Science in Business Administration (BSBA)");
                addCourse("Bachelor of Science in Hospitality Management (BSHM)");
                addCourse("Bachelor of Science in Tourism Management (BSTM)");
    }

    public void addRegion(String region) {
        SCHOOL_LOCATIONS_AND_COURSES.putIfAbsent(region, new LinkedHashMap<>());
        currentRegion = region;
    }

    public void addCampus(String campus) {
        Map<String, Set<String>> campuses = SCHOOL_LOCATIONS_AND_COURSES.get(currentRegion);
        if (campuses != null) {
            campuses.putIfAbsent(campus, new LinkedHashSet<>());
            currentCampus = campus;
        }
    }

    public void addCourse(String course) {
        Map<String, Set<String>> campuses = SCHOOL_LOCATIONS_AND_COURSES.get(currentRegion);
        if (campuses != null) {
            Set<String> courses = campuses.get(currentCampus);
            if (courses != null) {
                courses.add(course);
            }
        }
    }

    public void setRegion() {
        System.out.println("\nAvailable Regions:");

        int counter = 1;
        for (String region : getAvailableRegions()) {
            System.out.println(counter + ". " + region);
            counter++;
        }

        System.out.print("Enter your selected region here: ");
        studentRegion = input.nextLine();
        studentRegion = convertRegionInput();
    }

    public Set<String> getAvailableRegions() {
        return SCHOOL_LOCATIONS_AND_COURSES.keySet();
    }

    public String convertRegionInput() {
        Set<String> availableRegions = getAvailableRegions();

        studentRegion = toSentenceCase(studentRegion);
        if (availableRegions.contains(studentRegion)) {
            return studentRegion;
        }

        int regionNumber = Integer.parseInt(studentRegion);
        int counter = 1;
        for (String region: availableRegions) {
            if (counter == regionNumber) {
                return region;
            }
            counter++;
        }
        return null;
    }

    public void setCampus() {
        System.out.println("\nAvailable Campuses:");

        int counter = 1;
        for (String campus : getAvailableCampuses()) {
            System.out.println(counter + ". " + campus);
            counter++;
        }

        System.out.print("Enter your selected campus here: ");
        studentCampus = input.nextLine();
        studentCampus = convertCampusInput();
    }

    public Set<String> getAvailableCampuses() {
        Map<String, Set<String>> campuses = SCHOOL_LOCATIONS_AND_COURSES.get(studentRegion);
        if (campuses == null) {
            return Collections.emptySet();
        } else {
            return campuses.keySet();
        }
    }

    public String convertCampusInput() {
        Set<String> availableCampuses = getAvailableCampuses();

        studentCampus = toSentenceCase(studentCampus);
        if (availableCampuses.contains(studentCampus)) {
            return studentCampus;
        }

        int campusNumber = Integer.parseInt(studentCampus);
        int counter = 1;
        for (String campus: availableCampuses) {
            if (counter == campusNumber) {
                return campus;
            }
            counter++;
        }
        return null;
    }

    public void setCourse() {
        System.out.println("\nAvailable courses:");

        int counter = 1;
        for (String course : getAvailableCourses()) {
            System.out.println(counter + ". " + course);
            counter++;
        }

        System.out.print("Enter your selected course here: ");
        studentCourse = input.nextLine();
        studentCourse = convertCourseInput();
    }

    public Set<String> getAvailableCourses() {
        Map<String, Set<String>> campuses = SCHOOL_LOCATIONS_AND_COURSES.get(studentRegion);
        Set<String> courses = campuses.get(studentCampus);
        if (courses.isEmpty()) {
            return Collections.emptySet();
        } else {
            return courses;
        }
    }

    public String convertCourseInput() {
        Set<String> availableCourses = getAvailableCourses();

        studentCourse = toSentenceCase(studentCourse);
        if (availableCourses.contains(studentCourse)) {
            return studentCourse;
        }

        int courseNumber = Integer.parseInt(studentCourse);
        int counter = 1;
        for (String course : availableCourses) {
            if (counter == courseNumber) {
                return course;
            }
            counter++;
        }
        return null;
    }

    public void setStudentType() {
        System.out.println("\nWhat type of student are you?");
        System.out.println("1 - New Student");
        System.out.println("2 - Existing Student");
        System.out.print("Enter student type here: ");
        studentType = input.nextLine();

        studentType = toSentenceCase(studentType);
        switch (studentType) {
            case "1":
            case "New Student":
                studentType = "New Student";
                break;
            case "2":
            case "Existing Student":
                studentType = "Existing Student";
                break;
            default:
                System.out.println("Incorrect input!");
                break;
        }
    }

    public String getRegion() {
        return studentRegion;
    }

    public String getCampus() {
        return studentCampus;
    }

    public String getCourse() {
        return studentCourse;
    }

    public String getStudentType() {
        return studentType;
    }

    public static String toSentenceCase(String input) {
        if (input == null || input.isBlank()) {
            return input;
        }

        input = input.toLowerCase();
        String[] words = input.split("\\s+");
        String result = "";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            result += Character.toUpperCase(word.charAt(0)) + word.substring(1);

            if (i < words.length - 1) {
                result += " ";
            }
        }

        return result;
    }
}
