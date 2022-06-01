package org.acme.workloads.Table_Entity;

import org.acme.model.JobDTO;
import org.acme.model.TableEntityDTO;
import org.acme.workloads.Job.Job;

import java.util.List;

public interface TableEntityService {

    List<TableEntity> getAllTables();
    TableEntity addTable(TableEntityDTO tableEntityDTO);
    TableEntity updateTable(TableEntityDTO tableEntityDTO);
    TableEntity deleteTable(TableEntityDTO tableEntityDTO);
    List<TableEntity> getAllTablesByRestaurantId(Long id);

}