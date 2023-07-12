package com.deshy.stduio.deshystudiomanager.repository;

import com.deshy.stduio.deshystudiomanager.data.entity.Member;
import com.deshy.stduio.deshystudiomanager.data.entity.Vendor;
import com.deshy.stduio.deshystudiomanager.repository.custom.VendorCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VendorRepository extends JpaRepository<Vendor,Long>, VendorCustomRepository {
    Optional<Vendor> findByUid(UUID uid);
    List<Vendor> findAllByMember(Member member);
}
