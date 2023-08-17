package luv2code.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="review")
public class Review {

    // Define the column and primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int theId;

    @Column(name="comment")
    String comment;

    public Review(){

    }
    // define constructor with elements
    public Review(String comment ){
        this.comment= comment ;
    }
    // Define Getter/Setter methods
    public String getComment() {
        return comment;
    }

    public int getTheId() {
        return theId;
    }

    public void setTheId(int theId) {
        this.theId = theId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    //Define ToString()
    @Override
    public String toString() {
        return "Review{" +
                "theId=" + theId +
                ", comment='" + comment + '\'' +
                '}';
    }
}
