package com.deshy.stduio.deshystudiomanager.service;

import com.deshy.stduio.deshystudiomanager.data.dto.vendor.VendorStoreDTO;
import com.deshy.stduio.deshystudiomanager.data.entity.Member;
import com.deshy.stduio.deshystudiomanager.data.entity.ProductCategory;
import com.deshy.stduio.deshystudiomanager.data.entity.VendorStore;
import com.deshy.stduio.deshystudiomanager.exception.DuplicateException;
import com.deshy.stduio.deshystudiomanager.repository.VendorRepository;
import com.deshy.stduio.deshystudiomanager.repository.VendorStoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VendorService {
    private final VendorRepository vendorRepository;
    private final VendorStoreRepository vendorStoreRepository;

    public void createStore(VendorStoreDTO vendorStoreDTO, Member member) {
        VendorStore vendorStore = VendorStore.create(vendorStoreDTO.getName(),member);
        try {
            vendorStoreRepository.save(vendorStore);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateException("중복 상가 존재: "+ vendorStoreDTO.getName());
        }
    }

    public List<VendorStoreDTO> getStore() {
        return VendorStoreDTO.ofList(vendorStoreRepository.findAll());
    }

    public void deleteStore(UUID uid) {
        VendorStore category = vendorStoreRepository.findByUid(uid).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 상가: "+uid));
        vendorStoreRepository.delete(category);
    }
}
