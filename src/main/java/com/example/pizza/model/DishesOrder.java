package com.example.pizza.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@EqualsAndHashCode(exclude = {"order", "dishes"})
@ToString(exclude = {"order", "dishes"})
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dishes_order", uniqueConstraints = {
        @UniqueConstraint(name = "dishes_order_pk", columnNames = {"order_id", "dishes_id"})
})
public class DishesOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false, foreignKey = @ForeignKey(name = "dishes_order_order_id_fk"))
    @JsonBackReference
    private Order order;

    @ManyToOne
    @JoinColumn(name = "dishes_id", nullable = false, foreignKey = @ForeignKey(name = "dishes_order_dishes_id_fk"))
    @JsonManagedReference
    private Dishes dishes;

    @Column(nullable = false, columnDefinition = "integer default 1")
    private Integer quantity = 1;

    @PreRemove
    private void removeSnackAndOrder() {
        dishes.getDishesOrders().remove(this);
        order.getDishesOrders().remove(this);
    }
}
