package com.dns214.HRSoftware;

import com.dns214.HRSoftware.karyawan.Karyawan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class HrSoftwareApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrSoftwareApplication.class, args);
	}

}
