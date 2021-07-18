package com.example.backend.controller.dto;

import java.util.List;
import com.example.backend.model.RepairJob;
import java.util.stream.Collectors;

public class RepairJobDto {
    private long customerId;
    private String examination;
    private String customerAgrees;
    private String repairStatus;
    private List<RepairItemDto> repairItemList;

    public static RepairJobDto fromRepairStatus(RepairJob repairJob) {
        if (repairJob == null) return null;
        var dto = new RepairJobDto();
        dto.repairStatus = repairJob.getRepairStatus();
        dto.examination = repairJob.getExamination();
        dto.customerAgrees = repairJob.getCustomerAgrees();
        dto.customerId = repairJob.getId();
        return dto;
    }

    public static RepairJobDto fromRepairJob(RepairJob repairJob) {
        var dto = new RepairJobDto();
        dto.repairItemList = repairJob.getRepairItem().stream().map(RepairItemDto::fromRepairItem).collect(Collectors.toList());
        return dto;
    }

    public static RepairJob toRepairJob(RepairJobDto repairJobDto) {
        var list = new RepairJob();

        list.setRepairItem(repairJobDto.repairItemList.stream().map(itemDto -> RepairItemDto.toRepairItem(itemDto, list)).collect(Collectors.toList()));

        return list;
    }

    public List<RepairItemDto> getRepairItemList() {
        return repairItemList;
    }

    public void setRepairItemList(List<RepairItemDto> repairItemList) {
        this.repairItemList = repairItemList;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public String getCustomerAgrees() {
        return customerAgrees;
    }

    public void setCustomerAgrees(String customerAgrees) {
        this.customerAgrees = customerAgrees;
    }

    public String getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(String actions) {
        this.repairStatus = actions;
    }

}
