package org.sid.domain.repository;

import org.sid.entity.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Produit,Long> {

    @Query("select p from Produit p where p.name like :x")
    Page<Produit> searchProduct(@Param("x") String motCle, Pageable pageable);

}
