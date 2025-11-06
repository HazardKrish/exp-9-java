
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAppDI {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigDI.class);
        StudentDI student = context.getBean(StudentDI.class);
        student.startStudying();
    }
}
