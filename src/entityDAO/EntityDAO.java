package entityDAO;

import java.util.ArrayList;

public interface EntityDAO<G> {
	public void create(G obj) throws Exception;
	public void read(int cd) throws Exception;
	public void update(int cd, String toUpdate) throws Exception;
	public void delete(int cd) throws Exception;
	public ArrayList<G> list() throws Exception;
	
}
