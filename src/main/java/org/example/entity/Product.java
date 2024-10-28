package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import org.example.keys.ProductKey;

@Entity
@IdClass(ProductKey.class) // thats how define composite key
// you create new class with fields defining PK and then you add it here
// and add @Id to corresponding places
public class Product {
    /*
    this table will be created:
    CREATE TABLE `product` (
  `number` bigint NOT NULL,
  `code` varchar(255) NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`number`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
     */
    @Id
    private String code;
    private String color;

    @Id
    private long number;

    public Product(String code, String color, long number) {
        this.code = code;
        this.color = color;
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    // composed primary key:

}
