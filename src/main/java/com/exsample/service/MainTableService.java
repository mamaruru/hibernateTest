package com.exsample.service;

import java.util.List;
import com.exsample.entity.MainTable;
import com.exsample.entity.MainTableId;

public interface MainTableService {

	public List<MainTable> getAllMainTables();
	public MainTable getMainTableById(MainTableId id);
	public List<MainTable> getMainTableByIds(List<MainTableId> ids);
	public boolean saveMainTable(MainTable mainTable);
	public boolean deleteMainTableById(Long id, Long sub_id);

}
