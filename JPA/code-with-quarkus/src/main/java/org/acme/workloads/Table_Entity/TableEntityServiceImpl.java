package org.acme.workloads.Table_Entity;

import org.acme.model.TableEntityDTO;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class TableEntityServiceImpl implements TableEntityService{

    private final TableEntityRepo tableEntityRepo;

    public TableEntityServiceImpl(TableEntityRepo tableEntityRepo) {
        this.tableEntityRepo = tableEntityRepo;
    }

    @Override
    public List<TableEntity> getAllTables() {
        return this.tableEntityRepo.getAllTables();
    }

    @Override
    public TableEntity addTable(TableEntityDTO tableEntityDTO) {
        TableEntity tableEntity = new TableEntity();
        tableEntity.setTableno(tableEntityDTO.getTable_num());
        tableEntity.setRoom(tableEntityDTO.getRoom());
        this.tableEntityRepo.add(tableEntity);
        return tableEntity;
    }

    @Override
    public TableEntity updateTable(TableEntityDTO tableEntityDTO) {
        TableEntity tableEntity = new TableEntity();
        tableEntity.setTableno(tableEntityDTO.getTable_num());
        tableEntity.setRoom(tableEntityDTO.getRoom());
        this.tableEntityRepo.update(tableEntity);
        return tableEntity;
    }

    @Override
    public TableEntity deleteTable(TableEntityDTO tableEntityDTO) {
        TableEntity tableEntity = new TableEntity();
        tableEntity.setTableno(tableEntityDTO.getTable_num());
        tableEntity.setRoom(tableEntityDTO.getRoom());
        this.tableEntityRepo.delete(tableEntity);
        return tableEntity;
    }

    @Override
    public List<TableEntity> getAllTablesByRestaurantId(Long id) {
        return this.tableEntityRepo.getAllTablesByRestaurantId(id);
    }
}