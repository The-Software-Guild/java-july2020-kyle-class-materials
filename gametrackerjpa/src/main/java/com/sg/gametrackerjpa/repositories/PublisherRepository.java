/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.gametrackerjpa.repositories;

import com.sg.gametrackerjpa.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kyle David Rudy
 */
@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    
}
