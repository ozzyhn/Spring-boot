package luv2code.cruddemo.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import luv2code.cruddemo.entity.Course;
import luv2code.cruddemo.entity.Instructor;
import luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {
    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl( EntityManager entityManager) {
        this.entityManager= entityManager;
    }
    @Override
    @Transactional   // Veritabanında değişiklik yapabildiği için bu açiklama eklenir
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);

    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {

        // retrieve instructor
        Instructor tempInstructor= entityManager.find(Instructor.class,theId);

        // get the courses
        List<Course> courses = tempInstructor.getCourses();
        // break association of all courses for the instructor
        for (Course tempCourse: courses){
            tempCourse.setInstructor(null);
        }

        // delete instructor
        entityManager.remove(tempInstructor);

    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {

        // retrieve İnstructor detail
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class,theId);

        // remove the associated object reference
        // Break bi-directional link
        // aralarındaki bağlantıyı null atayarak kesiyoruz
        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        // Delete the instructor Detail
        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {


        // create query
        TypedQuery<Course> query= entityManager.createQuery(
                "from Course where instructor.id = :data", Course.class);
        query.setParameter("data",theId);

        // execute query

        List<Course> courses = query.getResultList();
        return courses;

    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {

        // Create a query  özel bir sorgulama yöntem kullanıyoruz string ifadeler bu anlama geliyor
        TypedQuery<Instructor> query = entityManager.createQuery(
                                                        "select i from Instructor i " +
                                                                    "JOIN FETCH i.courses " +
                                                                    "JOIN FETCH i.ınstructorDetail " +
                                                                    "where i.id=: data ", Instructor.class);
                query.setParameter("data",theId);
                // EXECUTE QUERY
                Instructor instructor= query.getSingleResult();

                return  instructor;


    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {

        entityManager.merge(tempInstructor); // merge bir varlıgı güncellemek içindir
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {

        // Retrieve the course
        Course tempCourse= entityManager.find(Course.class, theId);

        //Delete the course
        entityManager.remove(tempCourse);

        System.out.println("done");

    }
}
