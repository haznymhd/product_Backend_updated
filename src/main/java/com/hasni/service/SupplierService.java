
package com.hasni.service;

import com.hasni.model.Supplier;

import java.util.List;

public interface SupplierService {

    Supplier saveSupplier(Supplier supplier);

    List<Supplier> getAllSuppliers();

    Supplier getSupplierById(Long id);

    void deleteSupplier(Long id);

    Supplier editSupplier(Supplier supplier, Long id);
}
