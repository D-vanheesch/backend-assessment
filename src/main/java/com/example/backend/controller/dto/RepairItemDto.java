package com.example.backend.controller.dto;

import com.example.backend.model.RepairItem;
import com.example.backend.model.RepairJob;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class RepairItemDto {

    private String waterPump;
    private Integer waterPumpPrice;
    private Integer waterPumpSupply;
    private String repairWaterPump;
    private String engine;
    private Integer enginePrice;
    private Integer engineSupply;
    private String repairEngine;
    private String brakeDiscs;
    private Integer brakeDiscsPrice;
    private Integer brakeDiscsSupply;
    private String repairBrakeDiscs;
    private String brakePads;
    private Integer brakePadsPrice;
    private Integer brakePadsSupply;
    private String repairBrakePads;
    private String other;
    private Integer otherPrice;

    public static RepairItemDto fromRepairItem(RepairItem repairItem) {
        var dto = new RepairItemDto();

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,repairItem);

        return dto;
    }

    public static RepairItem toRepairItem(RepairItemDto dto, RepairJob repairJob) {
        var item = new RepairItem();

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,item);

        item.setRepairJob(repairJob);
        return item;
    }
}
