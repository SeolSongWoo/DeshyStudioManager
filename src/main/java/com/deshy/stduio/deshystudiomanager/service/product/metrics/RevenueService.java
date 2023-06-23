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
public class RevenueService {
    private final ProductSaleRepository productSaleRepository;

    //총 매출
    public Long getTotalRevenue() {
        return productSaleRepository.findTotalRevenue();
    }

    //하루 동안의 매출
    public Long getTodayRevenue() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime startOfNextDay = today.plusDays(1).atStartOfDay();
        return productSaleRepository.findTotalRevenueBetweenDates(startOfDay, startOfNextDay);
    }

    //이번달 동안의 매출
    public Long getMonthRevenue() {
        YearMonth thisMonth = YearMonth.now();
        LocalDateTime startOfMonth = thisMonth.atDay(1).atStartOfDay();
        LocalDateTime startOfNextMonth = thisMonth.plusMonths(1).atDay(1).atStartOfDay();
        return productSaleRepository.findTotalRevenueBetweenDates(startOfMonth, startOfNextMonth);
    }

    //이번 년동안의 매출
    public Long getYearRevenue() {
        int thisYear = LocalDate.now().getYear();
        LocalDateTime startOfYear = LocalDateTime.of(thisYear, Month.JANUARY, 1, 0, 0);
        LocalDateTime startOfNextYear = LocalDateTime.of(thisYear + 1, Month.JANUARY, 1, 0, 0);
        return productSaleRepository.findTotalRevenueBetweenDates(startOfYear, startOfNextYear);
    }

    //하루 동안의 시간별 매출
    public List<ProductSalesMetricsDTO> getTodayRevenueByHour() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime startOfNextDay = today.plusDays(1).atStartOfDay();
        return productSaleRepository.findRevenueBetweenDatesByDateTrunc(startOfDay, startOfNextDay,"hour");
    }

    //한달 동안의 일별 매출
    public List<ProductSalesMetricsDTO> getMonthRevenueByDay() {
        YearMonth thisMonth = YearMonth.now();
        LocalDateTime startOfMonth = thisMonth.atDay(1).atStartOfDay();
        LocalDateTime startOfNextMonth = thisMonth.plusMonths(1).atDay(1).atStartOfDay();
        return productSaleRepository.findRevenueBetweenDatesByDateTrunc(startOfMonth, startOfNextMonth,"day");
    }

    //일년 동안의 월별 매출
    public List<ProductSalesMetricsDTO> getYearRevenueByMonth() {
        int thisYear = LocalDate.now().getYear();
        LocalDateTime startOfYear = LocalDateTime.of(thisYear, Month.JANUARY, 1, 0, 0);
        LocalDateTime startOfNextYear = LocalDateTime.of(thisYear + 1, Month.JANUARY, 1, 0, 0);
        return productSaleRepository.findRevenueBetweenDatesByDateTrunc(startOfYear, startOfNextYear,"month");
    }
    
}
