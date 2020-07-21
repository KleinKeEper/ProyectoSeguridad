package pe.edu.upeu.movilidad.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.movilidad.dao.EscuelaDao;
import pe.edu.upeu.movilidad.service.EscuelaService;

@Service
public class EscuelaServiceImp implements EscuelaService {
	
	@Autowired
	private EscuelaDao escuelaDao;

	@Override
	public Map<String, Object> readId(int id) {
		// TODO Auto-generated method stub
		return escuelaDao.readId(id);
	}

}
