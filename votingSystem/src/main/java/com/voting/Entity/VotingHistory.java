package com.voting.Entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Voting_History")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VotingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vhid;

    @Column(nullable = false, length = 20)
    private String bjp;

    @Column(nullable = false, length = 20)
    private String cong;

    @Column(nullable = false, length = 20)
    private String aap;

    @Column(nullable = false, length = 4)
    private String year;
}
