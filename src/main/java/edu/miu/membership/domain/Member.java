package edu.miu.membership.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;;
import java.io.Serializable;
import java.util.*;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/14/22
 */
@Entity
@Getter @Setter
@NoArgsConstructor
@JsonPropertyOrder
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @JsonProperty("member_id")
    @Column(name = "member_id")
    private Long id;

    @Size(min=2, message="First Name should have at least 2 characters")
    @Column(nullable = false)
    private String firstName;

    @Size(min=2, message="Last Name should have at least 2 characters")
    @Column( nullable = false)
    private String lastName;

    @Column(nullable = false)
    @Size(min=10)
    private String phone;

    //@Email
    //@NotEmpty(message = "Email cannot be empty")
    private String email;

    @OneToMany(cascade =  CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Set<Membership> memberships = new HashSet<>();

    @OneToMany(cascade =  CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Set<Badge> badges = new HashSet<>();

//    @OneToMany(cascade =  CascadeType.ALL)
//    @JoinColumn(name="member_id")
//    private Set<Plan> plans = new HashSet<>();


}
