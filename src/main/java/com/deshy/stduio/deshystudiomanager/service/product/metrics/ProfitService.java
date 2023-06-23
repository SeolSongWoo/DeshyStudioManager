package com.deshy.stduio.deshystudiomanager.service.product.metrics;

import com.deshy.stduio.deshystudiomanager.data.dto.ProductSalesMetricsDTO;
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
public class ProfitService {
    private final ProductSaleRepository productSaleRepository;

    //총 이익
    public Long getTotalProfit() {
        return productSaleRepository.findTotalProfit();
    }

    //하루 동안의 이익
    public Long getTodayProfit() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime startOfNextDay = today.plusDays(1).atStartOfDay();
        return productSaleRepository.findTotalProfitBetweenDates(startOfDay, startOfNextDay);
    }

    //이번달 동안의 이익
    public Long getMonthProfit() {
        YearMonth thisMonth = YearMonth.now();
        LocalDateTime startOfMonth = thisMonth.atDay(1).atStartOfDay();
        LocalDateTime startOfNextMonth = thisMonth.plusMonths(1).atDay(1).atStartOfDay();
        return productSaleRepository.findTotalProfitBetweenDates(startOfMonth, startOfNextMonth);
    }

    //이번 년동안의 이익
    public Long getYearProfit() {
        int thisYear = LocalDate.now().getYear();
        LocalDateTime startOfYear = LocalDateTime.of(thisYear, Month.JANUARY, 1, 0, 0);
        LocalDateTime startOfNextYear = LocalDateTime.of(thisYear + 1, Month.JANUARY, 1, 0, 0);
        return productSaleRepository.findTotalProfitBetweenDates(startOfYear, startOfNextYear);
    }

    //하루 동안의 시간별 이익
    public List<ProductSalesMetricsDTO> getTodayProfitByHour() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime startOfNextDay = today.plusDays(1).atStartOfDay();
        return productSaleRepository.findProfitBetweenDatesByDateTrunc(startOfDay, startOfNextDay,"hour");
    }

    //한달 동안의 일별 이익
    public List<ProductSalesMetricsDTO> getMonthProfitByDay() {
        YearMonth thisMonth = YearMonth.now();
        LocalDateTime startOfMonth = thisMonth.atDay(1).atStartOfDay();
        LocalDateTime startOfNextMonth = thisMonth.plusMonths(1).atDay(1).atStartOfDay();
        return productSaleRepository.findProfitBetweenDatesByDateTrunc(startOfMonth, startOfNextMonth,"day");
    }

    //일년 동안의 월별 이익
    public List<ProductSalesMetricsDTO> getYearProfitByMonth() {
        int thisYear = LocalDate.now().getYear();
        LocalDateTime startOfYear = LocalDateTime.of(thisYear, Month.JANUARY, 1, 0, 0);
        LocalDateTime startOfNextYear = LocalDateTime.of(thisYear + 1, Month.JANUARY, 1, 0, 0);
        return productSaleRepository.findProfitBetweenDatesByDateTrunc(startOfYear, startOfNextYear,"month");
    }
}
