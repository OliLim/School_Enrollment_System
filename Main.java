public class Main {
    public static void main(String[] args) {

        CampusAndCourses enroll = new CampusAndCourses();

        enroll.setStudentType();

        enroll.setSchoolLocationsAndCourses();
        enroll.setRegion();
        enroll.setCampus();
        enroll.setCourse();

        System.out.println("\nStudent Type: " + enroll.getStudentType());
        System.out.println("Region: " + enroll.getRegion());
        System.out.println("Campus: " + enroll.getCampus());
        System.out.println("Course: " + enroll.getCourse());
    }
}