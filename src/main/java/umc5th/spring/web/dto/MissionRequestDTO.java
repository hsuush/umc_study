package umc5th.spring.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class CreateDto {
        @NotBlank
        String content;
        @NotNull
        Integer price;
        @NotNull
        Integer point;
        @NotNull
        String authCode;
        LocalDate endDate;

    }
}
