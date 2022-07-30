package pl.sda.inventory.inventoryapp.main;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderMain {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("password"));
//        $2a$10$qp1y0SbcZgGeyaWEMYaj6.dkpkIcqUNlA.gfEOTqj1X3PaqX5R5bK

    }
}
