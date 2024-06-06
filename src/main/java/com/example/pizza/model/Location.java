package com.example.pizza.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@EqualsAndHashCode(exclude = {"orders", "users"})
@ToString(exclude = {"orders", "users"})
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "locations", indexes = {
        @Index(name = "location_street_index", columnList = "street"),
        @Index(name = "location_city_index", columnList = "city")
})
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String country;

    @Column(nullable = false, length = 40)
    private String city;

    @Column(nullable = false, length = 30)
    private String street;

    @Column(nullable = false, length = 10)
    private String house;

    @Column
    private Integer floor;

    @Column(length = 10)
    private String flat;

    @Column(nullable = false)
    private Timestamp created;

    @Column(nullable = false)
    private Timestamp changed;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Order> orders = Collections.emptySet();

    @ManyToMany(mappedBy = "locations", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("locations")
    private Set<User> users = new HashSet<>();

    @PreRemove
    private void removeUsers() {
        for (User user : this.users) {
            user.getLocations().remove(this);
        }
    }
}
