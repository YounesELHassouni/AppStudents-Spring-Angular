package ma.enset.app_spring_angular;

import ma.enset.app_spring_angular.entities.Payment;
import ma.enset.app_spring_angular.entities.PaymentStatus;
import ma.enset.app_spring_angular.entities.PaymentType;
import ma.enset.app_spring_angular.entities.Student;
import ma.enset.app_spring_angular.repository.PaymentRepository;
import ma.enset.app_spring_angular.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class AppSpringAngularApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppSpringAngularApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository,
                                        PaymentRepository paymentRepository){
        return args -> {
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("Ahmed").lastName("Alami").code("112233").programId("SDIA")
                    .build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("Ali").lastName("Radi").code("112244").programId("SDIA")
                    .build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("Samir").lastName("GHanam").code("112255").programId("GLSID")
                    .build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("Younes").lastName("Elhassouni").code("112266").programId("BDCC")
                    .build());

            PaymentType [] paymentTypes = PaymentType.values();
            Random random = new Random();
            studentRepository.findAll().forEach(stu ->{
                for (int i = 0; i < 10; i++) {
                    int index = random.nextInt(paymentTypes.length);
                    Payment payment = Payment.builder()
                            .amount(1000+(int)(Math.random()*2000))
                            .type(paymentTypes[index])
                            .status(PaymentStatus.CREADTED)
                            .date(LocalDate.now())
                            .student(stu)
                            .build();

                    paymentRepository.save(payment);
                }
            });

        };
    }

}
