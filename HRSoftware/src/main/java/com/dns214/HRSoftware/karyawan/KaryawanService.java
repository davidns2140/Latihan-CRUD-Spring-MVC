package com.dns214.HRSoftware.karyawan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class KaryawanService {
    private final KaryawanRepository karyawanRepository;

    @Autowired
    public KaryawanService(KaryawanRepository karyawanRepository){
        this.karyawanRepository = karyawanRepository;
    }
    public List<Karyawan> getKaryawans(){
        return karyawanRepository.findAll();
    }

    public void addNewKaryawan(Karyawan karyawan) {
        Optional<Karyawan> karyawanByEmail = karyawanRepository.findKaryawanByEmail(karyawan.getEmail());
        if(karyawanByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }

        karyawanRepository.save(karyawan);
        System.out.println(karyawan);
    }

    public void deleteKaryawan(Long karyawanId) {
        boolean exists = karyawanRepository.existsById(karyawanId);
        if(!exists){
            throw new IllegalStateException(
                    "karyawan with id " + karyawanId + " does not exists"
            );
        }
        karyawanRepository.deleteById(karyawanId);
    }

    @Transactional
    public void updateKaryawan(Long karyawanId,
                              String firstName,
                              String email) {
        Karyawan karyawan = karyawanRepository.findById(karyawanId)
                .orElseThrow(() -> new IllegalStateException(
                        "karyawan with id " + karyawanId + " does not exist"
                ));

        if(firstName != null &&
                firstName.length() > 0 &&
                !Objects.equals(karyawan.getFirstName(), firstName)) {
            karyawan.setFirstName(firstName);
        }

        if(email != null &&
                email.length() > 0 &&
                !Objects.equals(karyawan.getEmail(), email)) {
            Optional<Karyawan> karyawanOptional = karyawanRepository.findKaryawanByEmail(email);
            if (karyawanOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            karyawan.setEmail(email);
        }


    }
}
