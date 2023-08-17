package luv2code.cruddemo.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import luv2code.cruddemo.entity.Instructor;
import luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
