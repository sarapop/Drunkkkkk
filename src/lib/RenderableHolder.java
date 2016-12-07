package lib;

//copypast ¡“‡ªÍ–Ê

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();
	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	
	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1,IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}
	public static RenderableHolder getInstance() {
		return instance;
	}
	public void addAndSort(IRenderable entity) {
		add(entity);
		sort();
	}
	public void add(IRenderable entity) {
		entities.add(entity);
		sort();
	}
	public void sort(){
		Collections.sort(entities,comparator);
	}
	public List<IRenderable> getEntites() {
		return entities;
	}
}