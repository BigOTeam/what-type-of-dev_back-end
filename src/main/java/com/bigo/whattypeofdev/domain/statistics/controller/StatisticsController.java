package com.bigo.whattypeofdev.domain.statistics.controller;

        import com.bigo.whattypeofdev.domain.statistics.dto.StatisticsResponseDto;
        import com.bigo.whattypeofdev.global.entity.SurveyRecord;
        import lombok.RequiredArgsConstructor;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/statistics")
public class StatisticsController {

        @GetMapping("")
        public StatisticsResponseDto getStatistics()

}
