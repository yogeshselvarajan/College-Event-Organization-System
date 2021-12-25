package project.college.event.organizer.display.usersmanage;

public class UserClass
{
    private int sno;
    private String email;
    private String password;
    private String name;

    public UserClass(int sno, String email, String password, String name) {
        this.sno = sno;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
