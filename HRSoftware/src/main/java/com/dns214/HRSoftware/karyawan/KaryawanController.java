package com.dns214.HRSoftware.karyawan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/karyawan")
public class KaryawanController {

    private final KaryawanService karyawanService;

    @Autowired
    public KaryawanController(KaryawanService karyawanService){
        this.karyawanService = karyawanService;
    }

    @GetMapping
    public List<Karyawan> getKaryawans(){
        return karyawanService.getKaryawans();
    }

    @PostMapping
    public void registerNewKaryawan(@RequestBody Karyawan karyawan){
        karyawanService.addNewKaryawan(karyawan);
    }

    @DeleteMapping(path = "{karyawanId}")
    public void deleteKaryawan(@PathVariable("karyawanId") Long karyawanId) {
        karyawanService.deleteKaryawan(karyawanId);
    }

    @PutMapping(path = "{karyawanId}")
    public void updateKaryawan(@PathVariable("karyawanId") Long karyawanId,
                              @RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String email)
    {
        karyawanService.updateKaryawan(karyawanId, firstName, email);
    }
}
