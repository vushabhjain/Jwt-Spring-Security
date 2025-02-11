package com.voting.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Votings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Voting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vid;

    @Column(nullable = false, length = 40)
    private String name;

    @Column(nullable = false, length = 50)
    private String party;
}
