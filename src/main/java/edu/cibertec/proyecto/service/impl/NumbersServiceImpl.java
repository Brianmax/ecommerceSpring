package edu.cibertec.proyecto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.NumbersEntity;
import edu.cibertec.proyecto.repository.NumbersRepository;
import edu.cibertec.proyecto.service.NumbersService;
@Service
public class NumbersServiceImpl implements NumbersService {
	@Autowired
	NumbersRepository rn;
	@Override
	public NumbersEntity buscarNumeracion(int id) {
		NumbersEntity num = rn.findById(id).orElse(null);
		int correl = num.getNumeracion() + 1;
		num.setNumeracion(correl);
		rn.save(num);
		return rn.findById(id).orElse(null);
	}

	
	
}
