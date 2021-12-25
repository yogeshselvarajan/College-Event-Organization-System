package project.college.event.organizer.display.eventmanage.culturals;

public class CulturalsClass {
    private int SNo;
    private String Name;
    private String Department;
    private String Year_and_section;
    private String Age;
    private String College_name;
    private String Contact_number;
    private String Name_of_faculty;
    private String Emailid;
    private String Events_available;

    public int getSNo() {
        return SNo;
    }

    public String getName() {
        return Name;
    }

    public String getDepartment() {
        return Department;
    }

    public String getYear_and_section() {
        return Year_and_section;
    }

    public String getAge() {
        return Age;
    }

    public String getCollege_name() {
        return College_name;
    }

    public String getContact_number() {
        return Contact_number;
    }

    public String getName_of_faculty() {
        return Name_of_faculty;
    }

    public String getEmailid() {
        return Emailid;
    }

    public String getEvents_available() {
        return Events_available;
    }

    public CulturalsClass(int sNo,String name, String department, String year_and_section, String age, String college_name, String contact_number, String name_of_faculty, String emailid, String events_available) {
        SNo=sNo;
        Name = name;
        Department = department;
        Year_and_section = year_and_section;
        Age = age;
        College_name = college_name;
        Contact_number = contact_number;
        Name_of_faculty = name_of_faculty;
        Emailid = emailid;
        Events_available = events_available;


    }
}