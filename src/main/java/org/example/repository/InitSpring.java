package org.example.repository;

    import org.springframework.context.annotation.AnnotationConfigApplicationContext;

    public class InitSpring {
    private static  AnnotationConfigApplicationContext context;
    private static StudentRepository studentRepository;
    private static NoteCursRepository noteCursRepository;
    private static CursRepository cursReposirory;
    private static InitSpring  initSpring= null;
    private InitSpring() {
            context = new AnnotationConfigApplicationContext();
            context.scan("org.example");
            context.refresh();
            studentRepository = context.getBean(StudentRepository.class);
            noteCursRepository = context.getBean(NoteCursRepository.class);
           cursReposirory = context.getBean(CursRepository.class);
    }
    public static InitSpring getInstance(){
        if (initSpring == null){
            initSpring = new InitSpring();
        }
        return initSpring;
    }

        public static StudentRepository getStudentRepository() {
            return studentRepository;
        }

        public  NoteCursRepository getNoteCursRepository() {
            return noteCursRepository;
        }

        public static CursRepository getCursReposirory() {
            return cursReposirory;
        }
    }
