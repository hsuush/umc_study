package umc5th.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc5th.spring.apiPayload.ApiResponse;
import umc5th.spring.converter.MissionConverter;
import umc5th.spring.domain.Mission;
import umc5th.spring.service.MissionService.MissionCommandService;
import umc5th.spring.web.dto.MissionRequestDTO;
import umc5th.spring.web.dto.MissionResponseDTO;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/{storeId}")
    public ApiResponse<MissionResponseDTO.CreateResultDto> join(@RequestBody MissionRequestDTO.CreateDto request, @PathVariable Long storeId){
        Mission mission = missionCommandService.createMission(request, storeId);
        return ApiResponse.onSuccess(MissionConverter.toCreateResultDto(mission));
    }

}
