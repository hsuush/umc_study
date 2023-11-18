package umc5th.spring.converter;

import umc5th.spring.domain.Mission;
import umc5th.spring.domain.Store;
import umc5th.spring.web.dto.MissionRequestDTO;
import umc5th.spring.web.dto.MissionResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionResponseDTO.CreateResultDto toCreateResultDto(Mission mission){
        return MissionResponseDTO.CreateResultDto.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.CreateDto request, Store store){
        return Mission.builder()
                .content(request.getContent())
                .point(request.getPoint())
                .price(request.getPrice())
                .endDate(LocalDate.parse("2023-12-25"))
                .authCode("diefj343425odksfdfief")
                .build();
    }
}
