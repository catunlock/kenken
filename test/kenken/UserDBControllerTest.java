/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SuNLoCK
 */
public class UserDBControllerTest {
    UserDBController db = new UserDBController();
    
    public UserDBControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        UserKenKen marc = new UserKenKen("Marc", "12345");
        
        marc.setKekeniadas(133);
        marc.setTablerosCreados(43);
        db.createUser(marc);
        if (db.createUser(marc) == -1) {
            System.err.println("Error al crear usuario: Usuario ya existente.");
        }
        
        marc.setTablerosCreados(60);
        if (db.modifyUser(marc, null) == 0) {
            System.out.println("Usuario modificado correctamente.");
        }
        
        if (db.modifyUser(marc, "asdfwsdf") != 0) {
            System.err.println("Error al modificar usuario : El anterior no existe.");
        }
        
        if (db.modifyUser(marc, "Marc") != 0) {
            System.err.println("Error al modificar usuario : El anterior no existe.");
        }
        
        marc.setUsername("rodolfo");
        if (db.modifyUser(marc, "Marc") != 0) {
            System.err.println("Error al modificar usuario: rodolfo ya existe.");
        }
                
        
        UserKenKen marc2;
        try {
            marc2 = (UserKenKen) db.getUser("alsdkfj");
            
            System.out.printf("%s, Kenkeniadas: %d, TablerosCreados: %d", 
                marc2.getUsername(), marc2.getKekeniadas(), marc2.getTablerosCreados());
            
        } catch (IOException ex) {
            System.err.println("El usuario no existe o no se puede acceder a disco.");
        }
        
        db.deleteUser("Marc");
        db.deleteUser("rodolfo");
        
        if(db.deleteUser("manuala") != 0) {
            System.err.println("Error al borrar el usuario.");
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createUser method, of class UserDBController.
     */
    @Test
    public void testCreateUser() {
        System.out.println("createUser");
        User newUser = null;
        UserDBController instance = new UserDBController();
        int expResult = 0;
        int result = instance.createUser(newUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifyUser method, of class UserDBController.
     */
    @Test
    public void testModifyUser() {
        System.out.println("modifyUser");
        User user = null;
        String oldName = "";
        UserDBController instance = new UserDBController();
        int expResult = 0;
        int result = instance.modifyUser(user, oldName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class UserDBController.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        String username = "";
        UserDBController instance = new UserDBController();
        int expResult = 0;
        int result = instance.deleteUser(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class UserDBController.
     */
    @Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        String username = "";
        UserDBController instance = new UserDBController();
        User expResult = null;
        User result = instance.getUser(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
