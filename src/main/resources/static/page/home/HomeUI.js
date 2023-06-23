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

    addClickListenerToUpdateChart(listenerElement, chartElement, serviceMethod) {
        listenerElement.addEventListener('click', async () => {
            await this.setSalesChart(chartElement,serviceMethod);
        });
    }

    async setSalesChart(element,methodName) {
        element.innerHTML = '';
        const salesMetricsChartData = await this.#homeService[methodName]();

        const xaxis = salesMetricsChartData.xaxis;

        const salesVolumeSeries = this.#fillMissingData(salesMetricsChartData.volume, xaxis,'salesVolume');
        const revenueSeries = this.#fillMissingData(salesMetricsChartData.revenue, xaxis,'revenue');
        const profitSeries = this.#fillMissingData(salesMetricsChartData.profit, xaxis,'profit');

        const series = [{
            name: 'Sales Volume',
            data: salesVolumeSeries.map((value, index) => ({ x: xaxis[index], y: value }))
        }, {
            name: 'Revenue',
            data: revenueSeries.map((value, index) => ({ x: xaxis[index], y: value }))
        }, {
            name: 'Profit',
            data: profitSeries.map((value, index) => ({ x: xaxis[index], y: value }))
        }];

        const colors = ['#4154f1', '#2eca6a', '#ff771d'];


        await this.createChart('area', element, series, xaxis,colors,'today');
    }

    async createChart(chartType, element, series, xaxis,colors) {
        const options = {
            chart: {
                type: chartType,
                defaultLocale: 'kr',
                locales: [{
                   name : 'kr',
                     options : {
                       months : ['1월', '2월', '3월', '4월', '5월', '6월','7월', '8월', '9월', '10월', '11월', '12월'],
                       shortMonths : ['1월', '2월', '3월', '4월', '5월', '6월','7월', '8월', '9월', '10월', '11월', '12월'],
                       days : ['일', '월', '화', '수', '목', '금', '토'],
                       shortDays : ['일', '월', '화', '수', '목', '금', '토'],
                     }
                }],
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
                min: xaxis[0],
                max: xaxis[xaxis.length - 1],
                labels: {
                    datetimeUTC: false,
                    datetimeFormatter: {
                        year: 'yyyy',
                        month: 'yy년 MMM',
                        day: 'MMM dd일',
                        hour: 'HH:mm'
                    }
                }
            },
            tooltip: {
                x: {
                    format: 'yy년 MM월 dd일 HH시 mm분'
                },
            }
        };

        const chart = new ApexCharts(element, options);
        chart.render();
    }

    async setRecentSalesTBody(element) {
        const recentSales = await this.#homeService.getRecentSalesByPaging(0,5);
        element.innerHTML = '';
        recentSales.dtoData.forEach((item,index) => {
            const tr = document.createElement('tr');
            const revenue = this.#homeService.formatPrice(item.saleQuantity * item.salePrice);
            const profit = this.#homeService.formatPrice(item.saleQuantity * (item.salePrice - item.originPrice));
            const profitRate = (((item.saleQuantity* (item.salePrice - item.originPrice))/(item.saleQuantity * item.salePrice))*100).toFixed(0);
            tr.innerHTML = `
            <th>${index}</th>
            <td>${item.saleDate}</td>
            <td>${item.productName}</td>
            <td>${item.saleQuantity}</td>
            <td>${revenue}/${profit}\</td>
            <td>${profitRate}%</td>
            `;
            element.appendChild(tr);
        })
    }

    #fillMissingData(originalData, dates,salesMetricsName) {
        originalData = originalData || [];
        return dates.map(date => {
            const foundData = originalData.find(item => {
                const itemDate = new Date(item.salesDate);
                const dateDate = new Date(date);
                return itemDate.getTime() === dateDate.getTime();
            });
            return foundData ? foundData[salesMetricsName] : 0;
        });
    }

    get homeService() {
        return this.#homeService;
    }
}