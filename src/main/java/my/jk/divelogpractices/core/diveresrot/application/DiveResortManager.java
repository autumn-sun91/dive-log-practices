package my.jk.divelogpractices.core.diveresrot.application;

import my.jk.divelogpractices.core.diveresrot.application.dto.DiveResortDto;
import my.jk.divelogpractices.core.diveresrot.application.dto.DiveResortRegisterCommand;
import my.jk.divelogpractices.core.diveresrot.application.dto.DiveResortUpdateCommand;
import my.jk.divelogpractices.core.diveresrot.domain.DiveResort;
import my.jk.divelogpractices.core.diveresrot.domain.DiveResortNotFoundException;
import my.jk.divelogpractices.core.diveresrot.domain.DiveResortRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DiveResortManager implements DiveResortFinder, DiveResortEditor {

    private final DiveResortRepository repository;

    public DiveResortManager(DiveResortRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true) // transactionRouting Datasource - db replica
    @Override
    public List<DiveResortDto> findAll() {
        return repository.findAll().stream()
                .map(DiveResortDto::ofEntity)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<DiveResortDto> findByDiveResortId(Long diveResortId) {
        return repository.findById(diveResortId).map(DiveResortDto::ofEntity);
    }

    @Transactional
    @Override
    public DiveResortDto save(DiveResortRegisterCommand registCommand) {
        return DiveResortDto.ofEntity(repository.save(registCommand.convertToEntity()));
    }

    @Transactional
    @Override
    public DiveResortDto update(Long diveResortId, DiveResortUpdateCommand updateCommand) throws DiveResortNotFoundException {
        DiveResort diveResort = repository.findById(diveResortId)
                .orElseThrow(() -> new DiveResortNotFoundException(diveResortId));

        return DiveResortDto.ofEntity(repository.save(updateCommand.update(diveResort)));
    }

    @Transactional
    @Override
    public void delete(Long diveResortId) throws DiveResortNotFoundException {
        DiveResort diveResort = repository.findById(diveResortId)
                .orElseThrow(() -> new DiveResortNotFoundException(diveResortId));

        repository.delete(diveResort);
    }
}
