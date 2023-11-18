package umc5th.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc5th.spring.apiPayload.ApiResponse;
import umc5th.spring.converter.MemberConverter;
import umc5th.spring.converter.StoreConverter;
import umc5th.spring.domain.Member;
import umc5th.spring.domain.Store;
import umc5th.spring.service.StoreService.StoreCommandService;
import umc5th.spring.web.dto.MemberRequestDTO;
import umc5th.spring.web.dto.MemberResponseDTO;
import umc5th.spring.web.dto.StoreRequestDTO;
import umc5th.spring.web.dto.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{regionId}")
    public ApiResponse<StoreResponseDTO.CreateStoreResultDto> join(@PathVariable Long regionId, @RequestBody StoreRequestDTO.CreateDto request){
        Store store = storeCommandService.createStore(request, regionId);
        return ApiResponse.onSuccess(StoreConverter.toStoreResultDTO(store));
    }

}
