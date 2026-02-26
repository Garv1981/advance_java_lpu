package com.prac;



import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.*;

import org.junit.jupiter.api.*;


public class UniversityTest {

    private static EntityManagerFactory emf;
    private EntityManager em;

    private InstructorDAO instructorDAO;
    private EnrollmentDAO enrollmentDAO;

    @BeforeAll
    static void setupFactory() {
        emf = Persistence.createEntityManagerFactory("postgres");
    }

    @BeforeEach
    void setup() {
        em = emf.createEntityManager();
        instructorDAO = new InstructorDAO(em);
        enrollmentDAO = new EnrollmentDAO(em);
        insertTestData();
    }

    @AfterEach
    void closeEM() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }

    @AfterAll
    static void closeFactory() {
        if (emf != null) {
            emf.close();
        }
    }

    private void insertTestData() {

        em.getTransaction().begin();

        InstructorProfile profile = new InstructorProfile();
        profile.setOfficeRoom("A101");
        profile.setPhoneNumber("9999999999");

        Instructor instructor = new Instructor();
        instructor.setName("Dr. Sharma");
        instructor.setDepartment("CSE");
        instructor.setIp(profile);

        Course c1 = new Course();
        c1.setTitle("DSA");
        c1.setCredits(4);

        Course c2 = new Course();
        c2.setTitle("DBMS");
        c2.setCredits(3);

        instructor.getCourses().add(c1);
        instructor.getCourses().add(c2);

        em.persist(instructor);

        Enrollment e = new Enrollment();
        e.setSemester("Fall 2025");
        e.setGrade("A");
        e.setCourse(c1);

        em.persist(e);

        em.getTransaction().commit();
    }

    @Test
    void testOneToOne() {
        Instructor instructor = instructorDAO.findInstructor(1);
        assertNotNull(instructor.getIp());
    }

    @Test
    void testOneToMany() {
        Instructor instructor = instructorDAO.findInstructor(1);
        assertTrue(instructor.getCourses().size() > 0);
    }

    @Test
    void testManyToOne() {
        Enrollment e = em.find(Enrollment.class, 1);
        assertNotNull(e.getCourse());
    }

    @Test
    void testUpdateGrade() {
        enrollmentDAO.updateGrade(1, "A+");
        Enrollment e = em.find(Enrollment.class, 1);
        assertEquals("A+", e.getGrade());
    }

    @Test
    void testDeleteInstructor() {

        em.getTransaction().begin();
        Instructor i = em.find(Instructor.class, 1);
        em.remove(i);
        em.getTransaction().commit();

        assertNull(em.find(Instructor.class, 1));
    }
}

