/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Dell
 */
import java.sql.SQLException;

/**
 *
 * @author jose
 */
public interface IAbstractDaoLogin<T> {
    void fazerLogin(T entidade) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
}
