package my.jk.divelogpractices.core.diveresrot.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DiveResort {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // 리조트
    private String ownerName; // 리조트 사장님 이름
    private String contactNumber; // 리조트 연락처
    private String address; // 리조트 주소
    private String description; // 리조트 설명
    private LocalDateTime createdDateTime; // 생성일시
    private LocalDateTime lastModifiedDateTime; // 최근변경일시

    private static void validateDiveResortArguments(String name, String ownerName, String contactNumber,
                                                    String address, String description) {
        Assert.hasText(name, "name 은 필수입력값입니다.");
        Assert.hasText(ownerName, "ownerName 은 필수입력값입니다.");
        Assert.hasText(contactNumber, "contactNumber 은 필수입력값입니다.");
        Assert.hasText(address, "address 은 필수입력값입니다.");
        Assert.hasText(description, "description 은 필수입력값입니다.");
    }

    public static DiveResort create(String name, String ownerName, String contactNumber, String address,
                                    String description) {
        validateDiveResortArguments(name, ownerName, contactNumber, address, description);

        DiveResort diveResort = new DiveResort();
        diveResort.name = name;
        diveResort.ownerName = ownerName;
        diveResort.contactNumber = contactNumber;
        diveResort.address = address;
        diveResort.description = description;
        diveResort.createdDateTime = LocalDateTime.now();
        diveResort.lastModifiedDateTime = diveResort.getCreatedDateTime();

        return diveResort;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DiveResort that = (DiveResort) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(ownerName, that.ownerName) && Objects.equals(contactNumber, that.contactNumber) && Objects.equals(address, that.address) && Objects.equals(description, that.description) && Objects.equals(createdDateTime, that.createdDateTime) && Objects.equals(lastModifiedDateTime, that.lastModifiedDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ownerName, contactNumber, address, description, createdDateTime, lastModifiedDateTime);
    }

    public void update(String name, String ownerName, String contactNumber, String address, String description) {
        validateDiveResortArguments(name, ownerName, contactNumber, address, description);

        this.name = name;
        this.ownerName = ownerName;
        this.contactNumber = contactNumber;
        this.address = address;
        this.description = description;
        this.lastModifiedDateTime = LocalDateTime.now();

    }
}
