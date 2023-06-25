import HomeService from "./HomeService.js";
import Util from "../util/Util.js";

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

        const salesVolumeSeries = Util.fillMissingData(salesMetricsChartData.volume, xaxis,'salesVolume');
        const revenueSeries = Util.fillMissingData(salesMetricsChartData.revenue, xaxis,'revenue');
        const profitSeries = Util.fillMissingData(salesMetricsChartData.profit, xaxis,'profit');

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

        const options = {
            chartType : 'area',
            element : element,
            series : series,
            xaxis : xaxis,
            colors : colors,
        }
        await this.createChart(options);
    }

    async createChart(options) {
        const chartOptions = {
            chart: {
                type: options.chartType,
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
            colors: options.colors,
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
            series: options.series,
            xaxis: {
                type : 'datetime',
                min: options.xaxis[0],
                max: options.xaxis[options.xaxis.length - 1],
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

        const chart = new ApexCharts(options.element, chartOptions);
        chart.render();
    }

    async setRecentSalesTBody(element) {
        const recentSalesData = await this.#homeService.getRecentSalesByPaging(0,5);
        element.innerHTML = '';
        recentSalesData.dtoData.forEach((item,index) => {
            const tr = document.createElement('tr');
            const revenue = Util.formatPrice(item.saleQuantity * item.salePrice);
            const originPrice = Util.formatPrice(item.saleQuantity * item.originPrice);
            const profit = Util.formatPrice(item.saleQuantity * (item.salePrice - item.originPrice));
            tr.innerHTML = `
            <th>${index+1}</th>
            <td>${Util.formatDate(item.saleDate)}</td>
            <td>${item.productName}</td>
            <td>${item.saleQuantity}</td>
            <td>${originPrice}/${revenue}\</td>
            <td>${profit}</td>
            `;
            element.appendChild(tr);
        })
    }

    async setTop3VendorSalesTBody(element,serviceMethod) {
        const top3VendorSalesData = await this.#homeService[serviceMethod]();
        element.innerHTML = '';
        top3VendorSalesData.forEach((item,index) => {
            const tr = document.createElement('tr');
            tr.innerHTML = `
            <th>${index+1}</th>
            <td>${item.vendorName}</td>
            <td>${item.totalVolume}</td>
            <td>${Util.formatPrice(item.totalRevenue)}</td>
            <td>${Util.formatPrice(item.totalProfit)}</td>
            `
            element.appendChild(tr);
        })
    }



    get homeService() {
        return this.#homeService;
    }

    addPageTabClickEvent(element) {
        element.addEventListener('click',e => {
            const pageName = e.currentTarget.id;
            switch (pageName) {
                case 'index-page':
                    if(nowPage === 'index-page') return;
                    const indexMainElement = document.querySelector('[data-page="index-page"]');
                    indexMainElement.style.display = 'block';
                    document.querySelector(`[data-page=${nowPage}]`).style.display = 'none';
                    window.nowPage ='index-page';
                    break;
                case 'product-reg-page':
                    if(nowPage === 'product-reg-page') return;
                    const productRegPageElement = document.querySelector('[data-page="product-reg-page"]');
                    productRegPageElement.style.display = 'block';
                    document.querySelector(`[data-page=${nowPage}]`).style.display = 'none';
                    window.nowPage = 'product-reg-page'
                    break;
                default :
                    return;
            }
        });
    }
}