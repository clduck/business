package com.business.service;

import java.util.List;

import com.business.model.MemGroup;

public interface MemGroupService {

	public List<MemGroup> getMemGroups(MemGroup memGroupParam)throws Exception;
}
