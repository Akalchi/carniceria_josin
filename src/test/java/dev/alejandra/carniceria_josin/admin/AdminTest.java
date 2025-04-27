package dev.alejandra.carniceria_josin.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;


public class AdminTest {
 @Test
    void testAdminCreationAndGetters() {
        Admin admin = new Admin(1L, "adminUser", "securePass");

        assertEquals(1L, admin.getId());
        assertEquals("adminUser", admin.getUsername());
        assertEquals("securePass", admin.getPassword());
    }

    @Test
    void testSetters() {
        Admin admin = new Admin();
        admin.setUsername("newAdmin");
        admin.setPassword("newPass");

        assertEquals("newAdmin", admin.getUsername());
        assertEquals("newPass", admin.getPassword());
    }

    @Test
    void testGetAuthorities() {
        Admin admin = new Admin();
        Collection<? extends GrantedAuthority> authorities = admin.getAuthorities();

        assertEquals(1, authorities.size());
        assertEquals("ROLE_ADMIN", authorities.iterator().next().getAuthority());
    }

    @Test
    void testEqualsAndHashCode() {
        Admin admin1 = new Admin(1L, "admin1", "pass1");
        Admin admin2 = new Admin(1L, "admin2", "pass2"); 
        Admin admin3 = new Admin(2L, "admin3", "pass3");

        assertEquals(admin1, admin2); 
        assertNotEquals(admin1, admin3); 
        assertEquals(admin1.hashCode(), admin2.hashCode());
        assertNotEquals(admin1.hashCode(), admin3.hashCode());
    }

    @Test
    void testToStringDoesNotExposePassword() {
        Admin admin = new Admin(1L, "adminUser", "securePass");

        String toString = admin.toString();

        assertFalse(toString.contains("securePass"));
        assertTrue(toString.contains("[PROTECTED]"));
    }

}
