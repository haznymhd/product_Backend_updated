// SupplierServiceImpl.java
package com.hasni.service;

import com.hasni.model.Supplier;
import com.hasni.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    @Override
    public Supplier editSupplier(Supplier supplier, Long id) {
        Supplier oldSupplier = supplierRepository.findById(id).orElse(null);

        if (oldSupplier != null) {
            oldSupplier.setName(supplier.getName());
            oldSupplier.setPhone(supplier.getPhone());
            oldSupplier.setSupplyingItem(supplier.getSupplyingItem());
            oldSupplier.setAddress(supplier.getAddress());
            oldSupplier.setEmail(supplier.getEmail());

            return supplierRepository.save(oldSupplier);
        }

        return null; // Handle appropriately if the supplier with given ID is not found
    }
}
