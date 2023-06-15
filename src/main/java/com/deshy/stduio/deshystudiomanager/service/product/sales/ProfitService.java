package com.deshy.stduio.deshystudiomanager.service.product.sales;

import com.deshy.stduio.deshystudiomanager.data.entity.ProductSale;
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

    //최근 한달 동안의 순수익
    public Long getMonthProfit() {
        YearMonth thisMonth = YearMonth.now();
        LocalDateTime startOfMonth = thisMonth.atDay(1).atStartOfDay();
        LocalDateTime startOfNextMonth = thisMonth.plusMonths(1).atDay(1).atStartOfDay();

        return productSaleRepository.findProfitBetweenDates(startOfMonth, startOfNextMonth).orElse(0L);
    }

    //최근 일년 동안의 순수익
    public Long getYearProfit() {
        int thisYear = LocalDate.now().getYear();
        LocalDateTime startOfYear = LocalDateTime.of(thisYear, Month.JANUARY, 1, 0, 0);
        LocalDateTime startOfNextYear = LocalDateTime.of(thisYear + 1, Month.JANUARY, 1, 0, 0);

        return productSaleRepository.findProfitBetweenDates(startOfYear, startOfNextYear).orElse(0L);
    }
}
