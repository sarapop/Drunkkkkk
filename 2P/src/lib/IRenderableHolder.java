package lib;

import java.util.ArrayList;
import java.util.List;

public class IRenderableHolder {
	
	private static final IRenderableHolder instance = new IRenderableHolder();
	
	private List<IRenderableObject> entities;
	
	public IRenderableHolder() {
		entities = new ArrayList<IRenderableObject>();
	}
	
	public static IRenderableHolder getInstance() {
		return instance;
	}
	
	public void addAndSort(IRenderableObject entity) {
		add(entity);
	}
	
	public void add(IRenderableObject entity) {
		entities.add(entity);
	}
	
	public List<IRenderableObject> getEntities() {
		return entities;
	}
}