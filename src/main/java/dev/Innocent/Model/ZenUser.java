package dev.Innocent.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;


import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "zen_user")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Audited(withModifiedFlag = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZenUser extends BaseEntity<Long> implements Serializable {

    @NotBlank(message = "Display name is required")
    @NotNull(message = "Display name is required")
    private String displayName;

    @NotBlank(message = "Username is required")
    @NotNull(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    @NotNull(message = "Password is required")
    private String password;

    @NotBlank(message = "Role is required")
    @NotNull(message = "Role is required")
    private String role;

    @NotNull(message = "Active is required")
    private Integer active;

    private Date createdDate;
    private Date lastModifiedDate;

}
