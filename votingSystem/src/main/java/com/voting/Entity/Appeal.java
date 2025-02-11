package com.voting.Entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Tbl_Appeal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appeal {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appealId;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 200)
    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
