package facade;

import entity.Student;
import entity.Teacher;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        Facade facade = Facade.getFacadeInstance(emf);
       
        //1
        System.out.println("Number of Students: " +facade.getAllStudents().size());
        
        System.out.println("Students With firstname Anders: " +facade.getStudentsByFirstName("Anders").size());
        
        //3
        Student studentNew = facade.addStudent("Kurt", "Wonnegut");
        System.out.println("New Student with id : "+ studentNew.getId());
        
        //4 (simple) id 1 = CLcos-v14e
        facade.assignStudentToSemester(studentNew.getId(),1l);
        
        //7
        System.out.println("Number of Students: " +facade.studentCount());
        
        //8
        System.out.println("Students on semester CLcos-v14e " +facade.studentCountForSemester("CLcos-v14e"));
        System.out.println("Students on semester CLcos-v14e " +facade.studentCountForSemester("CLdat-a14e"));
        System.out.println("Students on semester CLcos-v14e " +facade.studentCountForSemester("CLcos-v14e"));
        
        //9
        System.out.println("Students assigned to all semesters: "+facade.studentCountAllSemesters());
        
        //10
        List<Teacher> teachers = facade.teachesMostSemesters();
        System.out.println("Teaches most semesters (count) "+teachers.size());
        System.out.println("Teaches most semesters (name of first) "+teachers.get(0).getFirstname());
    }

}
