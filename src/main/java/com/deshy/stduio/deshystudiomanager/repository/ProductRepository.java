package com.deshy.stduio.deshystudiomanager.repository;

import com.deshy.stduio.deshystudiomanager.data.entity.Member;
import com.deshy.stduio.deshystudiomanager.data.entity.Product;
import com.deshy.stduio.deshystudiomanager.repository.custom.ProductCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductCustomRepository {

    Optional<Product> findByName(String productName);

    Optional<Product> findByUid(UUID uid);

    List<Product> findAllByMember(Member member);
}
