/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serieseval;

import serieseval.model.User;

/**
 *
 * @author Laura
 */
public class Seguridad {
    private static User _usuario;
    
    public static User UsuarioActual(){
        return _usuario;
    }
    
    public static void SetUsuario(User usuario){
        _usuario = usuario;  
    }
}
