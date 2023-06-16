package com.deshy.stduio.deshystudiomanager.service.product.sales;

import com.deshy.stduio.deshystudiomanager.data.dto.product.metrics.ProductSalesMetricsProfitDTO;
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
public class ProfitService {
    private final ProductSaleRepository productSaleRepository;
    private final ProductSalesMetricsRepository productSalesMetricsRepository;


    //총 순수익
    public Long getTotalProfit() {
        return productSaleRepository.findTotalRevenue().orElse(0L);

    }

    //하루 동안의 순수익
    public Long getTodayProfit() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime startOfNextDay = today.plusDays(1).atStartOfDay();

        return productSaleRepository.findProfitBetweenDates(startOfDay, startOfNextDay).orElse(0L);
    }

    //하루동안 매 시간별 순수익
    public List<ProductSalesMetricsProfitDTO> getTodayProfitByHour() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime startOfNextDay = today.plusDays(1).atStartOfDay();
        return productSalesMetricsRepository.findProfitBetweenDatesOrderBySaleDate(startOfDay, startOfNextDay);
    }

    //최근 한달 동안의 순수익
    public Long getMonthProfit() {
        YearMonth thisMonth = YearMonth.now();
        LocalDateTime startOfMonth = thisMonth.atDay(1).atStartOfDay();
        LocalDateTime startOfNextMonth = thisMonth.plusMonths(1).atDay(1).atStartOfDay();

        return productSaleRepository.findProfitBetweenDates(startOfMonth, startOfNextMonth).orElse(0L);
    }

    //최근 한달 동안의 매 시간별 순수익
    public List<ProductSalesMetricsProfitDTO> getMonthProfitByHour() {
        YearMonth thisMonth = YearMonth.now();
        LocalDateTime startOfMonth = thisMonth.atDay(1).atStartOfDay();
        LocalDateTime startOfNextMonth = thisMonth.plusMonths(1).atDay(1).atStartOfDay();
        return productSalesMetricsRepository.findProfitBetweenDatesOrderBySaleDate(startOfMonth, startOfNextMonth);
    }

    //최근 일년 동안의 순수익
    public Long getYearProfit() {
        int thisYear = LocalDate.now().getYear();
        LocalDateTime startOfYear = LocalDateTime.of(thisYear, Month.JANUARY, 1, 0, 0);
        LocalDateTime startOfNextYear = LocalDateTime.of(thisYear + 1, Month.JANUARY, 1, 0, 0);

        return productSaleRepository.findProfitBetweenDates(startOfYear, startOfNextYear).orElse(0L);
    }

    //최근 일년 동안의 매 시간별 순수익
    public List<ProductSalesMetricsProfitDTO> getYearProfitByHour() {
        int thisYear = LocalDate.now().getYear();
        LocalDateTime startOfYear = LocalDateTime.of(thisYear, Month.JANUARY, 1, 0, 0);
        LocalDateTime startOfNextYear = LocalDateTime.of(thisYear + 1, Month.JANUARY, 1, 0, 0);
        return productSalesMetricsRepository.findProfitBetweenDatesOrderBySaleDate(startOfYear, startOfNextYear);
    }

}
