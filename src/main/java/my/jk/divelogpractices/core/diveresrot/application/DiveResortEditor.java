package my.jk.divelogpractices.core.diveresrot.application;

import my.jk.divelogpractices.core.diveresrot.application.dto.DiveResortDto;
import my.jk.divelogpractices.core.diveresrot.application.dto.DiveResortRegisterCommand;
import my.jk.divelogpractices.core.diveresrot.application.dto.DiveResortUpdateCommand;
import my.jk.divelogpractices.core.diveresrot.domain.DiveResortNotFoundException;

public interface DiveResortEditor {
    /**
     * 다이브리조트 등록
     *
     * @param registCommand
     * @return 등록된 DiveResortDto 개체
     */
    DiveResortDto save(DiveResortRegisterCommand registCommand);

    /**
     * 다이브리조트 변경
     *
     * @param diveResortId
     * @param updateCommand
     * @return 변경된 DiveResortDto 개체
     */
    DiveResortDto update(Long diveResortId, DiveResortUpdateCommand updateCommand) throws DiveResortNotFoundException;

    /**
     * 다이브로지트 삭제
     *
     * @param diveResortId
     */
    void delete(Long diveResortId) throws DiveResortNotFoundException;
}
