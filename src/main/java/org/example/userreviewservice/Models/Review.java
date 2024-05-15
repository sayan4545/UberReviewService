package org.example.userreviewservice.Models;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.util.Date;

//Annotations class level
@Entity
@Builder
@Table(name ="booking_review")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel {
    @OneToOne(cascade = {
            CascadeType.ALL
    },fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Booking booking;
    @Column(nullable =false)
    private String Content;
    private Double rating;
    @Override
    public String toString(){
        return this.Content +" "+this.rating+" ";
    }
}
