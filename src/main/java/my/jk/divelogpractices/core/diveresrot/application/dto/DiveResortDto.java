package my.jk.divelogpractices.core.diveresrot.application.dto;

import my.jk.divelogpractices.core.diveresrot.domain.DiveResort;

import java.time.LocalDateTime;

public record DiveResortDto (
        Long id,
        String name,
        String address,
        String ownerName,
         String contactNumber,
         String description,
        LocalDateTime createdDateTime,
         LocalDateTime lastModifiedDateTime
) {

    public static DiveResortDto ofEntity(DiveResort diveResort) {
        return new DiveResortDto(
                diveResort.getId(),
                diveResort.getName(),
                diveResort.getAddress(),
                diveResort.getOwnerName(),
                diveResort.getContactNumber(),
                diveResort.getDescription(),
                diveResort.getCreatedDateTime(),
                diveResort.getLastModifiedDateTime()
        );
    }
}
