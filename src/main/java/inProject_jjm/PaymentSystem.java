package inProject_jjm;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="PaymentSystem_table")
public class PaymentSystem {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long studentId;

    @PostPersist
    public void onPostPersist(){
        PaymentCompleted paymentCompleted = new PaymentCompleted();
        BeanUtils.copyProperties(this, paymentCompleted);
        paymentCompleted.publish();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }




}
