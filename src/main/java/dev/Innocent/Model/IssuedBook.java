package dev.Innocent.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.io.Serializable;

@Entity
@Table(name = "issued")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Audited(withModifiedFlag = true)
public class IssuedBook extends BaseEntity<Long> implements Serializable {

    @OneToOne
    @JoinColumn(name = "book_id")
    @JsonIgnore
    @NotNull(message = "Book is required")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "issued_id")
    @JsonIgnore
    @NotNull(message = "Issued is required")
    private Issued issued;

    private Integer returned;
}
