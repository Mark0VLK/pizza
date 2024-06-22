package com.example.pizza.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@EqualsAndHashCode(exclude = {"order", "dish"})
@ToString(exclude = {"order", "dish"})
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dishes_order", uniqueConstraints = {
        @UniqueConstraint(name = "dishes_order_pk", columnNames = {"order_id", "dish_id"})
})
public class DishOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false, foreignKey = @ForeignKey(name = "dish_order_order_id_fk"))
    @JsonBackReference
    private Order order;

    @ManyToOne
    @JoinColumn(name = "dish_id", nullable = false, foreignKey = @ForeignKey(name = "dish_order_dish_id_fk"))
    @JsonManagedReference
    private Dish dish;

    @Column(nullable = false, columnDefinition = "integer default 1")
    private Integer quantity = 1;

    @PreRemove
    private void removeSnackAndOrder() {
        dish.getDishOrders().remove(this);
        order.getDishOrders().remove(this);
    }
}
