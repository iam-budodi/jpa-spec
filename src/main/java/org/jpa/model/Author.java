package org.jpa.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "t_author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 64)
    private String firstName;

    @Column(name = "last_name", nullable = true, length = 64)
    private String lastName;

    @Column(length = 5000)
    private String bio;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Transient
    private Integer age;

    @Enumerated(EnumType.ORDINAL)
    private Language language;

    public Author() {
    }

    public Author(String firstName, String lastName, String bio, LocalDate dateOfBirth, Integer age, Language language) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bio='" + bio + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                ", language=" + language +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return Objects.equals(getId(), author.getId()) && Objects.equals(getFirstName(), author.getFirstName()) && Objects.equals(getLastName(), author.getLastName()) && Objects.equals(getBio(), author.getBio()) && Objects.equals(getDateOfBirth(), author.getDateOfBirth()) && Objects.equals(getAge(), author.getAge()) && getLanguage() == author.getLanguage();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getBio(), getDateOfBirth(), getAge(), getLanguage());
    }
}
