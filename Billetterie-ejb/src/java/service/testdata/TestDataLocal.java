/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.testdata;

import javax.ejb.Local;

/**
 *
 * @author cdi515
 */
@Local
public interface TestDataLocal {

    void create();

    boolean exists();
}
