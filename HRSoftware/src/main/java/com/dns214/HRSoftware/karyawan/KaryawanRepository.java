package com.dns214.HRSoftware.karyawan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KaryawanRepository
        extends JpaRepository<Karyawan, Long> {

    @Query("SELECT k FROM Karyawan k Where k.email = ?1")
    Optional<Karyawan> findKaryawanByEmail(String email);
}
