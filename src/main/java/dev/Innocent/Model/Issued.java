package dev.Innocent.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "issued")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Audited(withModifiedFlag = true)
public class Issued extends BaseEntity<Long> implements Serializable {

    @NotNull(message = "Issued date is required")
    private Date issuedDate;
    private String note;
    private Date expectedReturnDate;
    private Integer returned;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private Member member;

    @OneToMany(mappedBy = "issued", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<IssuedBook> issuedBooks;
}
