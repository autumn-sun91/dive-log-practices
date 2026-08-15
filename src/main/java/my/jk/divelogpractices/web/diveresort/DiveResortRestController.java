package my.jk.divelogpractices.web.diveresort;

import my.jk.divelogpractices.common.log.WebTrace;
import my.jk.divelogpractices.core.diveresrot.application.DiveResortEditor;
import my.jk.divelogpractices.core.diveresrot.application.DiveResortFinder;
import my.jk.divelogpractices.core.diveresrot.application.dto.DiveResortDto;
import my.jk.divelogpractices.core.diveresrot.application.dto.DiveResortRegisterCommand;
import my.jk.divelogpractices.web.diveresort.dto.DiveResortRegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DiveResortRestController {

    private final DiveResortFinder diveResortFinder;
    private final DiveResortEditor diveResortEditor;

    public DiveResortRestController(DiveResortFinder diveResortFinder, DiveResortEditor diveResortEditor) {
        this.diveResortFinder = diveResortFinder;
        this.diveResortEditor = diveResortEditor;
    }

    @WebTrace(apiName = "다이브리조트 조회")
    @GetMapping("/dive-resorts")
    public ResponseEntity<List<DiveResortDto>> findAll() {
        return ResponseEntity.ok(diveResortFinder.findAll());
    }

    @WebTrace(apiName = "다이브리조트 등록", enableRequestBody = true)
    @PostMapping("/dive-resorts")
    public ResponseEntity<?> register(@RequestBody @Validated DiveResortRegisterRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getFieldErrors().stream()
                    .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(diveResortEditor.save(request.convertToRegisterCommand()));
    }

}
