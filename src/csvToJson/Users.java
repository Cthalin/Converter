package csvToJson;

public class Users {
    private String name;
    private String firstname;
    private String lastname;
    private String department;
    private String email;
    private String login;
    private String status;

    public Users(String name, String firstname, String lastname, String department, String email, String login, String status){
        this.name = name;
        this.firstname =firstname;
        this.lastname=lastname;
        this.department=department;
        this.email=email;
        this.login=login;
        this.status=status;
    }
}
