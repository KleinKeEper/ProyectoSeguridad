package pe.edu.upeu.movilidad.daoImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.movilidad.dao.ConvocatoriaDao;
import pe.edu.upeu.movilidad.entity.Convocatoria;

@Repository
public class ConvocatoriaDaoImp implements ConvocatoriaDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withFunctionName("LIST_CONVOCATORIA").withCatalogName("PK_GENERAR_VACANTES");
		return simpleJdbcCall.execute();
	}

	@Override
	public int create(Convocatoria c) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call pk_generar_vacantes.insert_convenio(?,?,?,?,?,?)",
									c.getNombre_convocatoria(),
									c.getNro_vacantes(),
									c.getRequisitos(),
									c.getFecha_presentacion(),
									c.getId_escuela(),
									c.getId_universidad_convenio());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call pk_generar_vacantes.delete_convocatoria(?)", id);
	}
	
	
	@Override
	public int update(Convocatoria c) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call pk_generar_vacantes.update_convenio(?,?,?,?,?,?,?)", 
									c.getId_convocatoria(),
									c.getNombre_convocatoria(),
									c.getNro_vacantes(),
									c.getRequisitos(),
									c.getFecha_presentacion(),
									c.getId_escuela(),
									c.getId_universidad_convenio());
	}

	
	@Override
	public Map<String, Object> readId(int id) {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withFunctionName("LIST_ID_CONVOCATORIA").withCatalogName("PK_GENERAR_VACANTES");
		
		SqlParameterSource in = new MapSqlParameterSource().addValue("i_id_convocatoria", id);
		return simpleJdbcCall.execute(in);
	}

	
	

}
