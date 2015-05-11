package data;

import java.util.List;

public interface IDAO {
	
	public void closeAll();
	public void commit();
	public List<Object> getAll();
	public List<Object> getWhere(String whereClause);
	public String tableToString(String NomTable);
}
