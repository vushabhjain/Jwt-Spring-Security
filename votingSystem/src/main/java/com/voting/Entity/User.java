package com.voting.Entity;




import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Tbl_Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false, length = 30)
    private String fullName;

    @Column(nullable = false, unique = true, length = 50)
    private String emailId;

    @Column(nullable = false, length = 10)
    private String phone;

    @Column(nullable = false, length = 12, unique = true)
    private String aadharId;

    @Column(nullable = false, length = 10, unique = true)
    private String voterId;

    @Column(nullable = false, length = 30)
    private String password;

    @Column(nullable = false)
    private Integer votingScore = 0;

    
}
