package org.sid.entity;





import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "products")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Produit implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double price;
    private int quantity;
    private String description;
    private String category;
    private boolean selected;




}
