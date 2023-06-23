package com.deshy.stduio.deshystudiomanager.repository;

import com.deshy.stduio.deshystudiomanager.data.entity.Vendor;
import com.deshy.stduio.deshystudiomanager.repository.custom.VendorCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor,Long>, VendorCustomRepository {

}
