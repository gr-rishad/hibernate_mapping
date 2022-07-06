package com.hibernate_mapping.OneToManyBiDirectional.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hibernate_mapping.ManyToMany.entity.Student;
import com.hibernate_mapping.OneToManyUni.entity.Review;
import com.hibernate_mapping.OneToOne.entity.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course", uniqueConstraints = {
        @UniqueConstraint(columnNames = "title")
}
)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @JsonIgnoreProperties("courses")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private List<Review> reviews;

    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH}
    )
    @JoinTable(name = "course_student",
     joinColumns = @JoinColumn(name = "course_id"),
     inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student>  students;


    // add a convenience method
    public void addReview(Review review) {
        if (reviews == null) {
            reviews = new ArrayList<>();
        }
        reviews.add(review);
    }


}
