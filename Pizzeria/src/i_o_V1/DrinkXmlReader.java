/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_o_V1;
import i_o.*;
import data.*;
import java.io.IOException;

/**
 *
 * @author Francesco
 */
class DrinkXmlReader implements DrinkReaderFactory {

    public DrinkXmlReader(String path) {
    }

    @Override
    public Drink getNextProduct() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasNextProduct() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
