package my.jk.divelogpractices.web.diveresort.dto;

import jakarta.validation.constraints.NotBlank;
import my.jk.divelogpractices.core.diveresrot.application.dto.DiveResortRegisterCommand;

public record DiveResortRegisterRequest(
        @NotBlank
        String name,
        @NotBlank
        String ownerName,
        @NotBlank
        String contactNumber,
        @NotBlank
        String address,
        @NotBlank
        String description
) {
    public DiveResortRegisterCommand convertToRegisterCommand() {
        return DiveResortRegisterCommand.create(name(), ownerName(), contactNumber(), address(),
                description());
    }
}
