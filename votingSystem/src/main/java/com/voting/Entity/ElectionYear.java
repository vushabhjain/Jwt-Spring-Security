package com.voting.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Election_Year")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElectionYear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer elecId;

    @Column(nullable = false, length = 4)
    private String year;

    @Column(nullable = false)
    private Integer status = 0;
}
