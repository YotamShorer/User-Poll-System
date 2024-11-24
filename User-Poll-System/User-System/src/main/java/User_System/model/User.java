package User_System.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class User {

    private Integer id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String email;

    private Integer age;

    private String address;

    @JsonProperty("joining_date")
    private LocalDate joiningDate;


    public User() {
        this.joiningDate = LocalDate.now();
    }

    public User(Integer id, String firstName, String lastName, String email, Integer age, String address, LocalDate joiningDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age != null ? age : 0;
        this.address = address;
        this.joiningDate = joiningDate != null ? joiningDate : LocalDate.now(); // Default joiningDate to today if null
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", joiningDate=" + joiningDate +
                '}';
    }
}
