package my.jk.divelogpractices.core.diveresrot.application.dto;

import my.jk.divelogpractices.core.diveresrot.domain.DiveResort;

public record DiveResortUpdateCommand(
        String name,
        String ownerName,
        String contactNumber,
        String address,
        String description
) {

    public static DiveResortUpdateCommand create(
            String name,
            String ownerName,
            String contactNumber,
            String address,
            String description) {

        return new DiveResortUpdateCommand(
                name,
                ownerName,
                contactNumber,
                address,
                description
        );
    }

    public DiveResort update(DiveResort diveResort) {
        diveResort.update(name(), ownerName(), contactNumber(), address(), description());
        return diveResort;
    }
}
