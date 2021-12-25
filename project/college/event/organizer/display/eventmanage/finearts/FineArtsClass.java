package project.college.event.organizer.display.eventmanage.finearts;

public class FineArtsClass
{
    private int SNo;
    private String event_name;
    private String event_description;
    private String start_time;
    private String duration;
    private String start_date;
    private String Event_Type;
    private String Category;
    private String Number_of_Participants;
    private String event_id;
    private String college_id;
    private String email_id;

    public int getSNo() {
        return SNo;
    }

    public String getEvent_name() {
        return event_name;
    }

    public String getEvent_description() {
        return event_description;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getDuration() {
        return duration;
    }

    public String getEvent_Type() {
        return Event_Type;
    }

    public String getCategory() {
        return Category;
    }

    public String getNumber_of_Participants() {
        return Number_of_Participants;
    }

    public String getEvent_id() {
        return event_id;
    }

    public String getCollege_id() {
        return college_id;
    }

    public String getEmail_id() {
        return email_id;
    }

    public FineArtsClass(int SNo, String event_name, String event_description, String start_time, String duration, String start_date, String event_Type, String category, String number_of_Participants, String event_id, String college_id, String email_id) {
        this.SNo = SNo;
        this.event_name = event_name;
        this.event_description = event_description;
        this.start_time = start_time;
        this.duration = duration;
        this.start_date = start_date;
        Event_Type = event_Type;
        Category = category;
        Number_of_Participants = number_of_Participants;
        this.event_id = event_id;
        this.college_id = college_id;
        this.email_id = email_id;
    }
}

