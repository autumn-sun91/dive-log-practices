package my.jk.divelogpractices.core.diveresrot.application.dto;

import my.jk.divelogpractices.core.diveresrot.domain.DiveResort;

public record DiveResortRegisterCommand(
        String name, String ownerName, String contactNumber, String address, String description) {
    public static DiveResortRegisterCommand create(
            String name, String ownerName, String contactNumber, String address, String description) {
        return new DiveResortRegisterCommand(name, ownerName, contactNumber, address, description);
    }

    public DiveResort convertToEntity() {
        return DiveResort.create(name(), ownerName(), contactNumber(), address(), description());
    }
}
