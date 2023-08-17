package luv2code.cruddemo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="instructor")
public class Instructor {
    // Annote the class an entity and map to db table

    // define the fields

    // annote the fields with db column names

    // create constructors

    // generate getter/setter methods

    // generate toString() method
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_detail_id")
    private InstructorDetail instructorDetail;

    @OneToMany( fetch = FetchType.LAZY,
            mappedBy = "instructor",
    cascade = {CascadeType.DETACH,CascadeType.MERGE,
               CascadeType.PERSIST,CascadeType.REFRESH}
    ) // eğitmen birden çok kursa sahip olabilir
    private List<Course>courses;

    // Courses için getter/ setterler
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // Eğitmenler ve kurslar arasıdna çift yönlü bi-directional ilişki kurmak
    public void add(Course tempCourse) {
        if (courses==null){
            courses=new ArrayList<>(); // eger kurs yok null a eşitse yeni bir kurs listesi oluştur
        }
        courses.add(tempCourse);
        tempCourse.setInstructor(this); // oluşturdgun coursesı tempcourse ekle ve bu tempcoursı öğretmen ile tanıştır
    }

    public Instructor() {

    }
    public Instructor(String firstName,String lastName,String email) {
        this.email=email;
        this.lastName=lastName;
        this.firstName=firstName;

    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                '}';
    }

}






