/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicalRecordModel;

import java.util.List;

/**
 *
 * @author chrismorris
 */
public interface EntityStore<T> {
    public List<T> load();
    public void update(T profile);
}
