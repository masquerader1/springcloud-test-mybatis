package com.albert.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albert.app.dao.GirlDao;
import com.albert.app.model.Girl;

@Service
public class GirlService {
@Autowired
private GirlDao girlDao;
	
	public Girl getGirlById(Long id){
		return girlDao.selectByPrimaryKey(id);
	}
}
