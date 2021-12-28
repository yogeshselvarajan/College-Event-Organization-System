package project.college.event.organizer.display.eventmanage.meeting;

public class MeetingClass {
    private int SNo;
    private String meeting_name;
    private String meeting_description;
    private String start_time;
    private String duration;
    private String start_date;
    private String meeting_Type;
    private String meeting_options;
    private String Number_of_Participants;
    private String meeting_id;
    private String meeting_pass;
    private String college_id;
    private String email_id;

    public MeetingClass(int id, String meeting_name, String description, String start_time, String duration, String start_date, String event_type, String category, String number_of_participants, String event_id, String college_id, String email_id) {

    }

    public int getSNo() {
        return SNo;
    }

    public String getMeeting_name() {
        return meeting_name;
    }

    public String getMeeting_description() {
        return meeting_description;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getDuration() {
        return duration;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getMeeting_Type() {
        return meeting_Type;
    }

    public String getMeeting_options() {
        return meeting_options;
    }

    public String getNumber_of_Participants() {
        return Number_of_Participants;
    }

    public String getMeeting_id() {
        return meeting_id;
    }

    public String getMeeting_pass() {
        return meeting_pass;
    }

    public String getCollege_id() {
        return college_id;
    }

    public String getEmail_id() {
        return email_id;
    }

    public MeetingClass(int SNo, String meeting_name, String meeting_description, String start_time, String duration, String start_date, String meeting_Type, String meeting_options, String number_of_Participants, String meeting_id, String meeting_pass, String college_id,String email_id) {
        this.SNo = SNo;
        this.meeting_name = meeting_name;
        this.meeting_description = meeting_description;
        this.start_time = start_time;
        this.duration = duration;
        this.start_date = start_date;
        this.meeting_Type = meeting_Type;
        this.meeting_options = meeting_options;
        Number_of_Participants = number_of_Participants;
        this.meeting_id = meeting_id;
        this.meeting_pass = meeting_pass;
        this.college_id = college_id;
        this.email_id = email_id;
    }
}