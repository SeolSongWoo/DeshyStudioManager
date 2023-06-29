package com.deshy.stduio.deshystudiomanager.repository;

import com.deshy.stduio.deshystudiomanager.data.entity.Vendor;
import com.deshy.stduio.deshystudiomanager.repository.custom.VendorCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendorRepository extends JpaRepository<Vendor,Long>, VendorCustomRepository {
    Optional<Vendor> findByName(String vendorName);
}
