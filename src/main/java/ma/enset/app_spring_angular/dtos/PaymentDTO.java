package ma.enset.app_spring_angular.dtos;

import jakarta.persistence.ManyToOne;
import lombok.*;
import ma.enset.app_spring_angular.entities.PaymentStatus;
import ma.enset.app_spring_angular.entities.PaymentType;
import ma.enset.app_spring_angular.entities.Student;

import java.time.LocalDate;
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class PaymentDTO {
    private Long id;
    private LocalDate date;
    private double amount;
    private PaymentType type;
    private String studentCode;
}
