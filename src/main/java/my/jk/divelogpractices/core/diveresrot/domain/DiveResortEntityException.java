package my.jk.divelogpractices.core.diveresrot.domain;

import jakarta.transaction.SystemException;

/**
 * {@link DiveResort} 엔티티에서 발생 가능한 최상위 예외 클래스
 *
 * @author springrunner.kr@gmail.com
 */
@SuppressWarnings("serial")
public class DiveResortEntityException extends SystemException {
    public DiveResortEntityException(String format, Object... args) {
        super(String.format(format, args));
    }
}
