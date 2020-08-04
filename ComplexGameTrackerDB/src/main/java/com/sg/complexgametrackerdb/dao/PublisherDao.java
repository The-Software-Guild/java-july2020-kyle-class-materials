/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.complexgametrackerdb.dao;

import com.sg.complexgametrackerdb.dto.Publisher;
import java.util.List;

/**
 *
 * @author Kyle David Rudy
 */
public interface PublisherDao {
    Publisher getPublisherById(int id);
    List<Publisher> getAllPublishers();
    Publisher addPublisher(Publisher publisher);
    void updatePublisher(Publisher publisher);
    void deletePublisherById(int id);
}
