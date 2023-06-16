import HomeService from "./HomeService.js";

export default class HomeUI {
    #homeService;
    constructor() {
        this.#homeService = new HomeService();
    }

    async setElementTextContent(element,serviceMethod) {
        element.textContent = await this.#homeService[serviceMethod]();
    }

    addClickListenerToUpdateTextContent(listenerElement, textContentElement, serviceMethod) {
        listenerElement.addEventListener('click', async () => {
            textContentElement.textContent = await this.#homeService[serviceMethod]();
        });
    }

    async setSalesChart(element) {
        // 데이터 가져오기
        const salesData = await this.#homeService.getTodaySalesVolumeByHour();
        const revenueData = await this.#homeService.getTodayRevenueByHour();
        const profitData = await this.#homeService.getTodayProfitByHour();

        const hours = this.getHoursForToday();

        const salesVolumeSeries = this.#fillMissingData(salesData, hours,'salesVolume');
        const revenueSeries = this.#fillMissingData(revenueData, hours,'revenue');
        const profitSeries = this.#fillMissingData(profitData, hours,'profit');

        const series = [{
            name: 'Sales Volume',
            data: salesVolumeSeries
        }, {
            name: 'Revenue',
            data: revenueSeries
        }, {
            name: 'Profit',
            data: profitSeries
        }];

        const colors = ['#4154f1', '#2eca6a', '#ff771d'];

        const categories = hours;

        await this.createChart('area', element, series, categories,colors,'today');
    }

    async createChart(chartType, element, series, categories,colors) {
        const options = {
            chart: {
                type: chartType,
                height: 350,
                toolbar: {
                    show: false
                }
            },
            markers: {
                size: 4,
            },
            colors: colors,
            fill: {
                type: 'gradient',
                gradient: {
                    shadeIntensity: 1,
                    opacityFrom: 0.3,
                    opacityTo: 0.4,
                    stops: [0, 90, 100],
                }
            },
            dataLabels: {
                enabled: false
            },
            stroke: {
                curve: 'smooth',
                width: 2
            },
            series: series,
            xaxis: {
                type : 'datetime',
                categories: categories
            },
            tooltip: {
                x: {
                    format: 'dd/MM/yy HH:mm'
                },
            }
        };

        const chart = new ApexCharts(element, options);
        chart.render();
    }

    getHoursForToday() {
        const now = new Date();
        now.setHours(now.getHours() + 9); // 한국 시간대를 반영합니다.

        const start = new Date(now.getFullYear(), now.getMonth(), now.getDate(), 0, 0, 0);
        start.setHours(start.getHours() + 9); // 한국 시간대를 반영합니다.

        for (var arr = [], dt = start; dt <= now; dt.setHours(dt.getHours() + 1)) {
            arr.push(new Date(dt));
        }

        return arr.map(date => {
            date.setHours(date.getHours() - 9); // UTC로 복원합니다.
            return date.toISOString();
        });
    }

    #getDatesForCurrentMonth() {
        const now = new Date()
        const start = new Date(now.getFullYear(), now.getMonth(), 1);
        const end = new Date();

        for (var arr = [], dt = start; dt <= end; dt.setDate(dt.getDate() + 1)) {
            arr.push(new Date(dt));
        }

        return arr.map(date => date.toISOString());
    }

// 이번년도의 월을 가져오는 함수
    getMonthsForThisYear() {
        const now = new Date()
        const start = new Date(now.getFullYear(), 0, 1);

        for (var arr = [], dt = start; dt <= now; dt.setMonth(dt.getMonth() + 1)) {
            arr.push(new Date(dt));
        }

        return arr.map(date => date.toISOString());
    }
    #fillMissingData(originalData, dates,salesMetricsName) {
        const filledData = dates.map(date => {
            const foundData = originalData.find(item => item.saleDate === date);
            return foundData ? foundData[salesMetricsName] : 0;
        });
        return filledData;
    }

    get homeService() {
        return this.#homeService;
    }

}