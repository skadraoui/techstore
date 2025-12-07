package org.sid.mapper;

import org.mapstruct.Mapper;
import org.sid.dto.ProduitDto;
import org.sid.entity.Produit;


@Mapper(componentModel = "spring")
public interface ProduitMapper extends EntityMapper<ProduitDto, Produit> {
}
