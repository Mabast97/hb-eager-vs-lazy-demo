package hibernate.demo;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorDemo {

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
            // create the objects
            Instructor tempInstructor = new Instructor("Mabast2", "Public2", "mabast22.public@gmail.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("www.Yahoo.com", "Hello22");
            // associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            Instructor tempInstructor2 = new Instructor("Mohammed", "John", "Mimi@gmail.com");
            InstructorDetail tempInstructorDetail2 = new InstructorDetail("www.Google.com", "Heyyyy");
            // associate the objects
            tempInstructor2.setInstructorDetail(tempInstructorDetail2);

            //start a transaction
            session.beginTransaction();

            System.out.println("Instructor : " + tempInstructor.getFirstName());
            System.out.println("InstructorDetail : " + tempInstructorDetail.getYoutubeChannel());
            session.save(tempInstructor2);

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
