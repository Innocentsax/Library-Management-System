package dev.Innocent.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.Innocent.Validation.ZenByZenith;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "member")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Audited(withModifiedFlag = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Member extends BaseEntity<Long> implements Serializable {

        @NotNull(message = "Type is required")
        @NotEmpty(message = "Type is required")
        private String type;

        @NotNull(message = "First name is required")
        @NotEmpty(message = "First name is required")
        private String firstName;

        @NotNull(message = "Last name is required")
        @NotEmpty(message = "Last name is required")
        private String lastName;

        @NotNull(message = "Email is required")
        @ZenByZenith(value = "zenbyzenith", message = "Email is not valid")
        private String email;

        @NotNull(message = "Contact number is required")
        private String contactNumber;

        @NotEmpty(message = "Gender is required")
        @NotNull(message = "Gender is required")
        private String gender;

        @NotEmpty(message = "Date of birth is required")
        private String dateOfBirth;

        @NotNull(message = "Address is required")
        private Date joiningDate;
}
