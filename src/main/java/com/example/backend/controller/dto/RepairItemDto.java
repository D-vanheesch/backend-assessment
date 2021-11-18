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


    /**
     * Map repairItem information to dto
     *
     * @param repairItem object attached to repairItem
     *
     * @return null || object dto
     */
    public static RepairItemDto fromRepairItem(RepairItem repairItem) {
        if (repairItem == null) {
            return null;
        } else {
            var dto = new RepairItemDto();

            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(dto,repairItem);

            return dto;
        }
    }

    /**
     * Map repairItem add repair item to repair job
     *
     * @param repairItemDto dto class of repair item
     * @param repairJob repair job to add the item to
     *
     * @return null || object dto
     */
    public static RepairItem toRepairItem(RepairItemDto repairItemDto, RepairJob repairJob) {
        if (repairJob == null) {
            return null;
        } else {
            var item = new RepairItem();

            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(repairItemDto,item);

            item.setRepairJob(repairJob);
            return item;
        }
    }
}
