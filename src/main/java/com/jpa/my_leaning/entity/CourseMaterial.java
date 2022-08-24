package com.jpa.my_leaning.entity;


import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(
        exclude = "course" // Proxy Error
)
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    //This.class->object cannot exist with course obj
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            //This Entity will have an extra column for the courseId
            name = "course_id",                // column name
            referencedColumnName = "courseId" // This.uniqueId key
    )
    private Course course;
}
