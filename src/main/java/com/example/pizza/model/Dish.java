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
import jakarta.persistence.Index;
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
@EqualsAndHashCode(exclude = {"information", "dishOrders"})
@ToString(exclude = {"information", "dishOrders"})
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dishes", uniqueConstraints = {@UniqueConstraint(
        name = "idx_dishes_information_id_weight_uniq",
        columnNames = {"information_id", "weight"})
}, indexes = {@Index(name = "dishes_price_index", columnList = "price")})
@EntityListeners(AuditingEntityListener.class)
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_of_pieces", nullable = false, columnDefinition = "integer default 1")
    private Integer numberOfPieces = 1;

    @Column(nullable = false)
    private Double weight;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "information_id", nullable = false, foreignKey = @ForeignKey(name = "dishes_information_id_fk"))
    @JsonManagedReference
    private Information information;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Timestamp created;

    @LastModifiedDate
    @Column(insertable = false)
    private Timestamp changed;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "boolean default false")
    private Boolean isDeleted = false;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<DishOrder> dishOrders = Collections.emptySet();

    @PreRemove
    private void removeInformation() {
        information.getDishes().remove(this);
    }
}
