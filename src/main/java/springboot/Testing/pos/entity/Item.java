package springboot.Testing.pos.entity;

import jakarta.persistence.*;
import lombok.*;
import springboot.Testing.pos.entity.enums.MesasuringUniteType;

@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id", length = 10)
    private int itemId;

    @Column(name = "item_name", length = 100, nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measuring_type", length = 50, nullable = false)
    private MesasuringUniteType mesasuringUniteType;

    @Column(name = "balance_qty", length = 50, nullable = false)
    private double balanceQty;

    @Column(name = "supplier_price", length = 50, nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price", length = 50, nullable = false)
    private double sellingPrice;

    @Column(name = "active_state" , columnDefinition = "boolean default true")
    private boolean activeState;
}
