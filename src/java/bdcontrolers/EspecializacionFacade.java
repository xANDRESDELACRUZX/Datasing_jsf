/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdcontrolers;

import entitys.Especializacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Deiby
 */
@Stateless
public class EspecializacionFacade extends AbstractFacade<Especializacion> {

    @PersistenceContext(unitName = "Datasignt_JSFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EspecializacionFacade() {
        super(Especializacion.class);
    }
    
}
