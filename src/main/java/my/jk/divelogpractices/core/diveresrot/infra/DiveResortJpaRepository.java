package my.jk.divelogpractices.core.diveresrot.infra;

import my.jk.divelogpractices.core.diveresrot.domain.DiveResort;
import my.jk.divelogpractices.core.diveresrot.domain.DiveResortRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiveResortJpaRepository extends DiveResortRepository, JpaRepository<DiveResort, Long> {}
