package dev.Innocent.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "category")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Audited(withModifiedFlag = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category extends BaseEntity<Long> implements Serializable {

        @NotNull(message = "Name is required")
        @NotBlank(message = "Name is required")
        @Length(max = 50, message = "Name must be less than 50 characters")
        @Column(name = "name")
        private String name;

        @Length(max = 300, message = "Description must be less than 300 characters")
        @Column(name = "description")
        private String description;

        @NotNull(message = "Unique name is required")
        @NotBlank(message = "Unique name is required")
        @Length(max = 10, message = "Unique name must be less than 10 characters")
        @Column(name = "unique_name")
        private String uniqueName;

        @JsonIgnore
        @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @Column(name = "books")
        private List<Book> books;

        @Column(name = "created_date")
        private Date createdDate;
}
