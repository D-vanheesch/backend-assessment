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

    /**
     * Get repairJob attributes by defined repairStatus in getRepairJobByStatus()
     *
     * @param repairJob RepairJob to get the detailed information
     *
     * @return null || object repairJobInformation
     */
    public static RepairJobDto fromRepairStatus (RepairJob repairJob) {
        if (repairJob == null) {
            return null;
        } else {
            var repairJobInformation = new RepairJobDto();
            repairJobInformation.repairStatus = repairJob.getRepairStatus();
            repairJobInformation.examination = repairJob.getExamination();
            repairJobInformation.customerAgrees = repairJob.getCustomerAgrees();
            repairJobInformation.customerId = repairJob.getId();
            return repairJobInformation;
        }
    }

    /**
     * Get repairItems based on repairJob
     *
     * @param repairJob RepairJob to get attached repairItems for
     *
     * @return null || object repairItems
     */
    public static RepairJobDto fromRepairJob (RepairJob repairJob) {
        if (repairJob == null) {
            return null;
        } else {
            var repairItems = new RepairJobDto();
            repairItems.repairItemList = repairJob.getRepairItem().stream().map(RepairItemDto::fromRepairItem).collect(Collectors.toList());
            return repairItems;
        }
    }

    /**
     * Attach repairItem to repairJob
     *
     * @param repairJobDto repairJob to attach repairItems to
     *
     * @return null || object repairJobClass
     */
    public static RepairJob toRepairJob(RepairJobDto repairJobDto) {
        if (repairJobDto == null) {
            return null;
        } else {
            var repairJobClass = new RepairJob();

            repairJobClass.setRepairItem(repairJobDto.repairItemList.stream().map(itemDto -> RepairItemDto.toRepairItem(itemDto, repairJobClass)).collect(Collectors.toList()));

            return repairJobClass;
        }
    }

    /**
     * Get RepairItems
     *
     * @return repairItemList
     */
    public List<RepairItemDto> getRepairItemList() {
        return repairItemList;
    }

    /**
     * Set RepairItems
     *
     * @param repairItemList list of all known repairItems
     */
    public void setRepairItemList(List<RepairItemDto> repairItemList) {
        this.repairItemList = repairItemList;
    }

    /**
     * Get CustomerId based on current repairJob
     *
     * @return customerId
     */
    public long getCustomerId() {
        return customerId;
    }

    /**
     * Set CustomerId
     *
     * @param customerId known id from getCustomerId()
     */
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    /**
     * Get Examination status for repairJob
     *
     * @return examination
     */
    public String getExamination() {
        return examination;
    }

    /**
     * Set Examination status for repairJob
     *
     * @param examination defined status of examination for repairJob
     */
    public void setExamination(String examination) {
        this.examination = examination;
    }

    /**
     * Get customerAgreement status for repairJob
     *
     * @return customerAgrees
     */
    public String getCustomerAgrees() {
        return customerAgrees;
    }

    /**
     * Set customerAgrees status for repairJob
     *
     * @param customerAgrees defined status of customerAgreement
     */
    public void setCustomerAgrees(String customerAgrees) {
        this.customerAgrees = customerAgrees;
    }

    /**
     * Get repairStatus for repairJob
     *
     * @return repairStatus
     */
    public String getRepairStatus() {
        return repairStatus;
    }

    /**
     * Set repairStatus for repairJob
     *
     * @param actions defined status of repairJob
     */
    public void setRepairStatus(String actions) {
        this.repairStatus = actions;
    }
}
