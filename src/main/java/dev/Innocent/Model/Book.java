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
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "book")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Audited(withModifiedFlag = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book extends BaseEntity<Long> implements Serializable {

    @NotNull(message = "Title is required")
    @NotBlank(message = "Title is required")
    @Column(name = "title")
    private String title;

    @NotNull(message = "Description is required")
    @NotBlank(message = "Description is required")
    @Column(name = "description")
    private String tag;

    @NotNull(message = "Author is required")
    @NotBlank(message = "Author is required")
    @Column(name = "author")
    private String author;

    @NotNull(message = "Category is required")
    @JoinColumn(name = "category_id")
    @JsonIgnore
    @ManyToOne
    private Category category;

    @Column(name = "publisher")
    private String publisher;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "status")
    private Integer status;
    @Column(name = "created_date")
    private Date createdDate;
}
