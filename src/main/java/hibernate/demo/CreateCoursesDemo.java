package hibernate.demo;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {

            //start a transaction
            session.beginTransaction();

            int theId = 2;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            Course tempCourse1 = new Course("baa1");

            tempInstructor.add(tempCourse1);

            session.save(tempCourse1);


            //commit the transaction
            session.getTransaction().commit();


            System.out.println("Done ..!!!.. ");
        }
        finally {
            session.close();
            factory.close();
        }

    }

}
