/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

/**
 *
 * @author alberto.lopez.sanchez
 */
public class UserKenKen extends User {
    int kekeniadas;
    int tablerosCreados;
    
    public UserKenKen(String name, String password) {
        super(name, password);
    }

    public int getKekeniadas() {
        return kekeniadas;
    }

    public void setKekeniadas(int kekeniadas) {
        this.kekeniadas = kekeniadas;
    }

    public int getTablerosCreados() {
        return tablerosCreados;
    }

    public void setTablerosCreados(int tablerosCreados) {
        this.tablerosCreados = tablerosCreados;
    }
    
    
    
}
