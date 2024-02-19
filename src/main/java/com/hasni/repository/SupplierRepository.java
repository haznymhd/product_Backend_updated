// SupplierRepository.java
package com.hasni.repository;

import com.hasni.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
