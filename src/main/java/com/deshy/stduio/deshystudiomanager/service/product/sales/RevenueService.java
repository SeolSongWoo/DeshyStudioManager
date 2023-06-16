package com.deshy.stduio.deshystudiomanager.service.product.sales;

import com.deshy.stduio.deshystudiomanager.data.dto.product.metrics.ProductSalesMetricsRevenueDTO;
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
public class RevenueService {
    private final ProductSaleRepository productSaleRepository;
    private final ProductSalesMetricsRepository productSalesMetricsRepository;


    //총 판매액
    public Long getTotalRevenue() {
        return productSaleRepository.findTotalRevenue().orElse(0L);
    }

    //하루 동안의 판매액
    public Long getTodayRevenue() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime startOfNextDay = today.plusDays(1).atStartOfDay();

        return productSaleRepository.findRevenueBetweenDates(startOfDay, startOfNextDay).orElse(0L);
    }

    //하루동안 매 시간별 판매액
    public List<ProductSalesMetricsRevenueDTO> getTodayRevenueByHour() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime startOfNextDay = today.plusDays(1).atStartOfDay();
        return productSalesMetricsRepository.findRevenueBetweenDatesOrderBySaleDate(startOfDay, startOfNextDay);
    }

    //최근 한달 동안의 판매액
    public Long getMonthRevenue() {
        YearMonth thisMonth = YearMonth.now();
        LocalDateTime startOfMonth = thisMonth.atDay(1).atStartOfDay();
        LocalDateTime startOfNextMonth = thisMonth.plusMonths(1).atDay(1).atStartOfDay();

        return productSaleRepository.findRevenueBetweenDates(startOfMonth, startOfNextMonth).orElse(0L);
    }

    //최근 일년 동안의 판매액
    public Long getYearRevenue() {
        int thisYear = LocalDate.now().getYear();
        LocalDateTime startOfYear = LocalDateTime.of(thisYear, Month.JANUARY, 1, 0, 0);
        LocalDateTime startOfNextYear = LocalDateTime.of(thisYear + 1, Month.JANUARY, 1, 0, 0);

        return productSaleRepository.findRevenueBetweenDates(startOfYear, startOfNextYear).orElse(0L);
    }

}
