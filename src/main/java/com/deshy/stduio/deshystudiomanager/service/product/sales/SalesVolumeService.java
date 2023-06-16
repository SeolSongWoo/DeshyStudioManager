package com.deshy.stduio.deshystudiomanager.service.product.sales;


import com.deshy.stduio.deshystudiomanager.data.dto.product.metrics.ProductSalesMetricsSalesVolumeDTO;
import com.deshy.stduio.deshystudiomanager.repository.ProductSaleRepository;
import com.deshy.stduio.deshystudiomanager.repository.view.ProductSalesMetricsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesVolumeService {
    private final ProductSaleRepository productSaleRepository;
    private final ProductSalesMetricsRepository productSalesMetricsRepository;

    //총 판매량
    public Long getTotalSalesVolume() {
        return productSaleRepository.findTotalSalesVolume().orElse(0L);
    }

    //상품별 판매량
    public Long getSalesVolumeByProduct(Long productId) {
        return productSaleRepository.findSalesVolumeByProductId(productId).orElse(0L);
    }

    //하루 동안의 판매량
    public Long getTodaySalesVolume() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime startOfNextDay = today.plusDays(1).atStartOfDay();

        return productSaleRepository.findSalesVolumeBetweenDates(startOfDay, startOfNextDay).orElse(0L);
    }
    
    //하루동안 매 시간별 판매량
    public List<ProductSalesMetricsSalesVolumeDTO> getTodaySalesVolumeByHour() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime startOfNextDay = today.plusDays(1).atStartOfDay();
        return productSalesMetricsRepository.findSalesVolumeBetweenDatesOrderBySaleDate(startOfDay, startOfNextDay);
    }

    //최근 한달 동안의 판매량
    public Long getMonthSalesVolume() {
        YearMonth thisMonth = YearMonth.now();
        LocalDateTime startOfMonth = thisMonth.atDay(1).atStartOfDay();
        LocalDateTime startOfNextMonth = thisMonth.plusMonths(1).atDay(1).atStartOfDay();

        return productSaleRepository.findSalesVolumeBetweenDates(startOfMonth, startOfNextMonth).orElse(0L);
    }

    //최근 한달 동안의 매 시간별 판매량
    public List<ProductSalesMetricsSalesVolumeDTO> getMonthSalesVolumeByHour() {
        YearMonth thisMonth = YearMonth.now();
        LocalDateTime startOfMonth = thisMonth.atDay(1).atStartOfDay();
        LocalDateTime startOfNextMonth = thisMonth.plusMonths(1).atDay(1).atStartOfDay();
        return productSalesMetricsRepository.findSalesVolumeBetweenDatesOrderBySaleDate(startOfMonth, startOfNextMonth);
    }

    //최근 일년 동안의 판매량
    public Long getYearSalesVolume() {
        int thisYear = LocalDate.now().getYear();
        LocalDateTime startOfYear = LocalDateTime.of(thisYear, Month.JANUARY, 1, 0, 0);
        LocalDateTime startOfNextYear = LocalDateTime.of(thisYear + 1, Month.JANUARY, 1, 0, 0);

        return productSaleRepository.findSalesVolumeBetweenDates(startOfYear, startOfNextYear).orElse(0L);
    }

    //최근 일년 동안의 매 시간별 판매량
    public List<ProductSalesMetricsSalesVolumeDTO> getYearSalesVolumeByHour() {
        int thisYear = LocalDate.now().getYear();
        LocalDateTime startOfYear = LocalDateTime.of(thisYear, Month.JANUARY, 1, 0, 0);
        LocalDateTime startOfNextYear = LocalDateTime.of(thisYear + 1, Month.JANUARY, 1, 0, 0);
        return productSalesMetricsRepository.findSalesVolumeBetweenDatesOrderBySaleDate(startOfYear, startOfNextYear);
    }

}
