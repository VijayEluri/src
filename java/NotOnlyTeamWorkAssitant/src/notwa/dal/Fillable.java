package notwa.dal;

import notwa.wom.BusinessObjectCollection;

public interface Fillable<T extends BusinessObjectCollection> {
	int Fill(T boc);
	int Fill(T boc, ParameterCollection pc);
}