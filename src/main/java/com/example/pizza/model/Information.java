package com.example.pizza.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Set;

@Entity
@Setter
@Getter
@EqualsAndHashCode(exclude = {"pizzas", "dishes", "drinks", "category"})
@ToString(exclude = {"pizzas", "dishes", "drinks", "category"})
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "information", uniqueConstraints = {
        @UniqueConstraint(name = "information_name_key", columnNames = "name"),
        @UniqueConstraint(name = "information_image_key", columnNames = "image")
})
@EntityListeners(AuditingEntityListener.class)
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String name;

    @Column(length = 200)
    private String description;

    @Column(name = "energy_value")
    private Double energyValue;

    @Column
    private Double proteins;

    @Column
    private Double fat;

    @Column
    private Double carb;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false, foreignKey = @ForeignKey(name = "category_information_id_fk"))
    @JsonManagedReference
    private Category category;

    @Column(nullable = false, length = 100, unique = true)
    private String image;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Timestamp created;

    @LastModifiedDate
    @Column(insertable = false)
    private Timestamp changed;

    @OneToMany(mappedBy = "information", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Pizza> pizzas = Collections.emptySet();

    @OneToMany(mappedBy = "information", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Dish> dishes = Collections.emptySet();

    @OneToMany(mappedBy = "information", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Drink> drinks = Collections.emptySet();

    @PreRemove
    private void removeCategory() {
        category.getInformation().remove(this);
    }
}
