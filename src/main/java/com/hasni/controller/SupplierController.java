// SupplierController.java
package com.hasni.controller;

import com.hasni.model.Supplier;
import com.hasni.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/{supplierId}")
    public ResponseEntity<Supplier> viewSupplier(@PathVariable Long supplierId) {
        Supplier supplier = supplierService.getSupplierById(supplierId);
        return ResponseEntity.ok(supplier);
    }

    @PostMapping("/saveSupplier")
    public ResponseEntity<Supplier> saveSupplier(@RequestBody Supplier supplier) {
        Supplier savedSupplier = supplierService.saveSupplier(supplier);
        return new ResponseEntity<>(savedSupplier, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
        Supplier supplier = supplierService.getSupplierById(id);
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }

    @DeleteMapping("/deleteSupplier/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return new ResponseEntity<>("Supplier deleted successfully", HttpStatus.OK);
    }

    @PostMapping("/editSupplier/{id}")
    public ResponseEntity<Supplier> editSupplier(@RequestBody Supplier supplier, @PathVariable Long id) {
        Supplier editedSupplier = supplierService.editSupplier(supplier, id);

        if (editedSupplier != null) {
            return new ResponseEntity<>(editedSupplier, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
