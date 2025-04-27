package dev.alejandra.carniceria_josin.admin;


import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
class AdminRepositoryTest {
    
    @Autowired
    private AdminRepository adminRepository;

    @Test
    void testFindByUsername() {
        Admin admin = new Admin(null, "adminUser", "securePass");
        adminRepository.save(admin);

        Optional<Admin> result = adminRepository.findByUsername("adminUser");

        assertThat(result).isPresent();
        assertThat(result.get().getUsername()).isEqualTo("adminUser");
    }
}
