package com.blueocean.app.assistantmanage.service;

import java.util.List;

import com.blueocean.app.assistantmanage.dto.DrugOrderDo;
import com.blueocean.app.assistantmanage.web.DrugOrderWeb;


public interface IOrderSelectService {
	Integer reordercount(DrugOrderWeb order);
	List<DrugOrderDo> getallorder(DrugOrderWeb order);
}
