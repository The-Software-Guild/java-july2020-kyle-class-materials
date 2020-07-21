/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.advancedgametrackerjdbctemplate.dao;

import com.sg.advancedgametrackerjdbctemplate.dto.Platform;
import java.util.List;

/**
 *
 * @author Kyle David Rudy
 */
public interface PlatformDao {
    Platform getPlatformById(int id);
    List<Platform> getAllPlatforms();
    Platform addPlatform(Platform platform);
    void updatePlatform(Platform platform);
    void deletePlatformById(int id);
}
