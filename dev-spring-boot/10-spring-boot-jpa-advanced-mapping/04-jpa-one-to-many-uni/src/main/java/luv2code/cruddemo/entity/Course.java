package luv2code.cruddemo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course")
public class Course {


    // define our fields

    // define constructors

    // define getter setters

    // define toString

    // annotate fields
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;


    @ManyToOne(cascade ={CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name="instructor_id") // asıl eğitmeni gösteren bir anahtara joincolumn atıyoruz foregin key
    private Instructor instructor;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY) // laz ile çagrıdlıgında gelecek
    @JoinColumn(name ="course_id")   // bağlama olayı foregin key
    private List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    // add a convenience method

    public void addReview(Review theReview) {
        if (reviews== null){
            reviews= new ArrayList<>();
        }
        reviews.add(theReview);
    }


    // constructor - yapıcı oluşturuyorum
    public Course(){

    }
    public Course(String title){

        this.title=title;
    }


    // GETTER / SETTERLAR

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
