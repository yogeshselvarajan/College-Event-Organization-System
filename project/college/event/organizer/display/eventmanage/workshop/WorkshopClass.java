package project.college.event.organizer.display.eventmanage.workshop;

public class WorkshopClass
{
    private int SNo;
    private String Workshop_Title;
    private String Description;
    private String Conducted_By;
    private String Duration;
    private String StartDate;
    private String EndDate;
    private String Department;
    private String slots_allocated;
    private String ConductedFor;
    private String EligibilityCriteria;
    private String mode_of_workshop;

    public int getSNo() {
        return SNo;
    }

    public String getWorkshop_Title() {
        return Workshop_Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getConducted_By() {
        return Conducted_By;
    }

    public String getDuration() {
        return Duration;
    }

    public String getStartDate() {
        return StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public String getDepartment() {
        return Department;
    }

    public String getSlots_allocated() {
        return slots_allocated;
    }

    public String getConductedFor() {
        return ConductedFor;
    }

    public String getEligibilityCriteria() {
        return EligibilityCriteria;
    }

    public String getMode_of_workshop() {
        return mode_of_workshop;
    }

    public WorkshopClass(int SNo, String workshop_Title, String description, String conducted_By, String duration, String startDate, String endDate, String department, String slots_allocated, String conductedFor, String eligibilityCriteria, String mode_of_workshop) {
        this.SNo = SNo;
        Workshop_Title = workshop_Title;
        Description = description;
        Conducted_By = conducted_By;
        Duration = duration;
        StartDate = startDate;
        EndDate = endDate;
        Department = department;
        this.slots_allocated = slots_allocated;
        ConductedFor = conductedFor;
        EligibilityCriteria = eligibilityCriteria;
        this.mode_of_workshop = mode_of_workshop;
    }
}
