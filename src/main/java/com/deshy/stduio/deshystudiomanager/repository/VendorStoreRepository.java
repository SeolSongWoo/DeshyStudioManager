package com.deshy.stduio.deshystudiomanager.repository;

import com.deshy.stduio.deshystudiomanager.data.entity.VendorStore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VendorStoreRepository extends JpaRepository<VendorStore,Long> {

    Optional<VendorStore> findByUid(UUID uid);
}
