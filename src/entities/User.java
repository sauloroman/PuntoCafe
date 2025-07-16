package entities;

import java.util.Date;

public class User {
    
    private int userId;
    private String userName;
    private String userLastname;
    private String userImage;
    private String userEmail;
    private String userPassword;
    private boolean userIsActive;
    private Date userCreatedAt;
    private Date userUpdatedAt;
    private int roleId;

    public User(){}

    public User(
            String userName, 
            String userLastname, 
            String userImage,
            String userEmail, 
            String userPassword, 
            int roleId
    ) {
        this.userName = userName;
        this.userLastname = userLastname;
        this.userImage = userImage;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.roleId = roleId;
    }
    
    public User(
            String userName, 
            String userLastname, 
            String userImage,
            String userEmail,  
            int roleId
    ) {
        this.userName = userName;
        this.userLastname = userLastname;
        this.userImage = userImage;
        this.userEmail = userEmail;
        this.roleId = roleId;
    }
    
    public User(
            int userId, 
            String userName, 
            String userLastname, 
            String userImage,
            String userEmail, 
            String userPassword, 
            boolean userIsActive, 
            Date userCreatedAt, 
            Date userUpdatedAt,
            int roleId
    ) {
        this.userId = userId;
        this.userName = userName;
        this.userLastname = userLastname;
        this.userImage = userImage;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userIsActive = userIsActive;
        this.userCreatedAt = userCreatedAt;
        this.userUpdatedAt = userUpdatedAt;
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean getIsActive() {
        return userIsActive;
    }

    public void setIsActive(boolean userIsActive) {
        this.userIsActive = userIsActive;
    }

    public Date getUserCreatedAt() {
        return userCreatedAt;
    }

    public void setUserCreatedAt(Date userCreatedAt) {
        this.userCreatedAt = userCreatedAt;
    }

    public Date getUserUpdatedAt() {
        return userUpdatedAt;
    }

    public void setUserUpdatedAt(Date userUpdatedAt) {
        this.userUpdatedAt = userUpdatedAt;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userName=" + userName + ", userLastname=" + userLastname + ", userImage=" + userImage + ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", userIsActive=" + userIsActive + ", userCreatedAt=" + userCreatedAt + ", userUpdatedAt=" + userUpdatedAt + ", roleId=" + roleId + '}';
    }
    
    

}
