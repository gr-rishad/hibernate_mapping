package com.hibernate_mapping.OneToOne.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hibernate_mapping.OneToManyBiDirectional.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "instructor")
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @JsonIgnoreProperties("instructor")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetails instructorDetails;


    @JsonIgnoreProperties("instructor")
    @OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Course> courses;

//    public void addCourse(Course course) {
//        if (courses == null) {
//            courses = new ArrayList<>();
//        }
//        courses.add(course);
//        course.setInstructor(this);
//    }
}
