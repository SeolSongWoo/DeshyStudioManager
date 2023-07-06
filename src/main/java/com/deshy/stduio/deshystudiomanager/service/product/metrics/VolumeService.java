package com.deshy.stduio.deshystudiomanager.service.product.metrics;

import com.deshy.stduio.deshystudiomanager.data.dto.product.ProductSalesMetricsDTO;
import com.deshy.stduio.deshystudiomanager.repository.ProductSaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VolumeService {
    private final ProductSaleRepository productSaleRepository;

    //총 판매량
    public Long getTotalVolume() {
        return productSaleRepository.findTotalVolume();
    }

    //하루 동안의 판매량
    public Long getTodayVolume() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime startOfNextDay = today.plusDays(1).atStartOfDay();
        return productSaleRepository.findTotalVolumeBetweenDates(startOfDay, startOfNextDay);
    }

    //이번달 동안의 판매량
    public Long getMonthVolume() {
        YearMonth thisMonth = YearMonth.now();
        LocalDateTime startOfMonth = thisMonth.atDay(1).atStartOfDay();
        LocalDateTime startOfNextMonth = thisMonth.plusMonths(1).atDay(1).atStartOfDay();
        return productSaleRepository.findTotalVolumeBetweenDates(startOfMonth, startOfNextMonth);
    }

    //이번 년동안의 판매량
    public Long getYearVolume() {
        int thisYear = LocalDate.now().getYear();
        LocalDateTime startOfYear = LocalDateTime.of(thisYear, Month.JANUARY, 1, 0, 0);
        LocalDateTime startOfNextYear = LocalDateTime.of(thisYear + 1, Month.JANUARY, 1, 0, 0);
        return productSaleRepository.findTotalVolumeBetweenDates(startOfYear, startOfNextYear);
    }

    //하루 동안의 시간별 판매량
    public List<ProductSalesMetricsDTO> getTodayVolumeByHour() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime startOfNextDay = today.plusDays(1).atStartOfDay();
        return productSaleRepository.findVolumeBetweenDatesByDateTrunc(startOfDay, startOfNextDay,"hour");
    }

    //한달 동안의 일별 판매량
    public List<ProductSalesMetricsDTO> getMonthVolumeByDay() {
        YearMonth thisMonth = YearMonth.now();
        LocalDateTime startOfMonth = thisMonth.atDay(1).atStartOfDay();
        LocalDateTime startOfNextMonth = thisMonth.plusMonths(1).atDay(1).atStartOfDay();
        return productSaleRepository.findVolumeBetweenDatesByDateTrunc(startOfMonth, startOfNextMonth,"day");
    }

    //일년 동안의 월별 판매량
    public List<ProductSalesMetricsDTO> getYearVolumeByMonth() {
        int thisYear = LocalDate.now().getYear();
        LocalDateTime startOfYear = LocalDateTime.of(thisYear, Month.JANUARY, 1, 0, 0);
        LocalDateTime startOfNextYear = LocalDateTime.of(thisYear + 1, Month.JANUARY, 1, 0, 0);
        return productSaleRepository.findVolumeBetweenDatesByDateTrunc(startOfYear, startOfNextYear,"month");
    }
}
