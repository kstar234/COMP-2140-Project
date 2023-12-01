public class PollUser {
    private String username;
    private String password;
    private UserType userType;

    // Constructor
    public PollUser(String username, String password, UserType userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    // Getter methods
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }
}

enum UserType {
    ADMIN,
    STUDENT
}
