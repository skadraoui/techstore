package org.sid.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProduitDto {

    private Long id;
    private String designation;
    private double prix;
    private int quantite;
}
