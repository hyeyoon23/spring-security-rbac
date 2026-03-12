package dev.authorization.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Authority")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 권한 (user / admin)
    private String authority;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    protected Authority() {}

    public Authority(String authority) {
        this.authority = authority;
    }
}