package notwa.wom;

import java.util.*;

public abstract class BusinessObjectCollection implements Iterable<BusinessObject> {

	protected ArrayList<BusinessObject> collection = new ArrayList<BusinessObject>();

	public Iterator<BusinessObject> iterator() {
		return collection.iterator();
	}
	
	protected void add(BusinessObject bo) {
		collection.add(bo);
	}

}