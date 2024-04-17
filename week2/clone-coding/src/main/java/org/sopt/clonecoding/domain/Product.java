package org.sopt.clonecoding.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;
    private boolean isSale;
    private int price;
    private String description;
    private String address;

    public static Product create(
            Member member,
            String title,
            boolean isSale,
            int price,
            String description,
            String address
    ) {
        return Product.builder()
                .member(member)
                .title(title)
                .isSale(isSale)
                .price(price)
                .description(description)
                .address(address)
                .build();
    }

    @Builder
    public Product(
            Member member,
            String title,
            boolean isSale,
            int price,
            String description,
            String address
    ){
        this.member = member;
        this.title = title;
        this.isSale = isSale;
        this.price = price;
        this.description = description;
        this.address = address;
    }
}
